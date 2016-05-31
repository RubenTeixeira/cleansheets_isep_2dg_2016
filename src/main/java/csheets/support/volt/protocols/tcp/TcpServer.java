package csheets.support.volt.protocols.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import csheets.support.volt.Server;

/**
 *
 * @author Renato Machado
 */
public abstract class TcpServer extends Server {

    /**
     * Server socket.
     */
    protected ServerSocket server;

    /**
     * Client socket.
     */
    protected Socket client;

    /**
     * Server input stream.
     */
    protected BufferedReader input;

    /**
     * Server output stream.
     */
    protected PrintWriter output;

    protected TcpServer() {
        super();
    }

    /**
     * Boots the server.
     *
     * @param port The port number.
     * @throws IOException
     */
    @Override
    protected void bootServer(int port) throws IOException {
        this.server = new ServerSocket(port);

        super.active = true;
    }

    /**
     * Closes all the client connections to the server.
     *
     * @param stream Input stream.
     */
    protected void dropClient(Reader stream) {
        try {
            if (stream != null) {
                stream.close();
            }

            if (this.client != null) {
                this.client.close();
            }

            if (this.input != null) {
                this.input.close();
            }

            if (this.output != null) {
                this.output.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Closes all open connections from the server.
     *
     * @param stream Input stream.
     */
    protected void dropServer(Reader stream) {
        try {
            this.dropClient(stream);

            if (this.server != null) {
                this.server.close();
            }

            super.active = false;
        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Serves the server in the given port.
     *
     * @param port The port number.
     */
    @Override
    public void serve(int port) {
        if (this.isActive()) {
            return;
        }

        InputStreamReader isr = null;

        try {
            this.bootServer(port);

            while (this.isActive()) {
                this.client = this.server.accept();

                isr = new InputStreamReader(this.client.getInputStream());
                this.input = new BufferedReader(isr);
                this.output = new PrintWriter(this.client.getOutputStream(), true);

                this.protocol(this.input, this.output);

                this.client.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dropServer(isr);
        }
    }

    /**
     * Streams the server in the given port.
     *
     * @param port The port number.
     */
    public void stream(int port) {
        if (this.isActive()) {
            return;
        }

        try {
            this.bootServer(port);

            while (this.isActive()) {
                this.client = this.server.accept();

                new Thread() {
                    @Override
                    public void run() {
                        InputStreamReader isr = null;

                        try {

                            isr = new InputStreamReader(client.getInputStream());
                            input = new BufferedReader(isr);
                            output = new PrintWriter(client.getOutputStream(), true);
                            protocol(input, output);
                        } catch (IOException ex) {
                            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
                        } finally {
                            dropClient(isr);
                        }
                    }
                }.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.dropServer(null);
        }
    }
    
    /**
     * Returns the hostname of the server, including the port.
     * 
     * @return Server hostname.
     */
    public String hostname() {
        try {
            String hostname = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()).getHostName();
            
            return hostname + ":" + this.server.getLocalPort();
        } catch (UnknownHostException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.server.getInetAddress().getHostAddress();
    }
    
    /**
     * Protocol to be used by the server.
     *
     * @param input Server input stream.
     * @param output Server output stream.
     */
    protected abstract void protocol(BufferedReader input, PrintWriter output);

    /**
     * Allows the server to send a response to the associated client.
     *
     * @param response Response object.
     */
    protected void reply(Object response) {
        try {
            this.client.getOutputStream().write((byte[]) response);
        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
