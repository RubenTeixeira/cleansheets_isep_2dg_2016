package csheets.framework.volt.protocols.tcp;

import csheets.framework.volt.Action;
import csheets.framework.volt.Channel;
import csheets.framework.volt.Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class represents a TCP server that is able to receive and respond to
 * requests.
 *
 * @author Renato Machado
 */
public class TcpServer extends Server {

    /**
     * Server socket.
     */
    protected ServerSocket server;

    /**
     * Routes.
     */
    protected Map<String, Action> routes;

    public TcpServer()
    {
        super();
        this.routes = new HashMap<>();
    }

    public ServerSocket server()
    {
        synchronized (this.server) {
            return this.server;
        }
    }

    /**
     * Boots the server.
     *
     * @param port The port number.
     */
    @Override
    protected void bootServer(int port)
    {
        try {
            synchronized (this.server) {
                if (this.server != null) {
                    throw new IllegalArgumentException("Server is already bound.");
                }

                try {
                    super.connectedPort = port;
                    this.server = new ServerSocket(port);
                    this.server.setSoTimeout(1000);
                } catch (IOException ex) {
                    super.connectedPort = -1;
                    Logger.getLogger(TcpServer.class.getName()).
                            log(Level.SEVERE, null, ex);
                }

                super.active = true;
            }
        } catch (NullPointerException e) {
            try {
                super.connectedPort = port;
                this.server = new ServerSocket(port);
                this.server.setSoTimeout(1000);
                super.active = true;
            } catch (IOException ex) {
                super.connectedPort = -1;
                throw new IllegalArgumentException(ex);
            }
        }
    }

    /**
     * Closes all open connections from the server.
     */
    @Override
    public void shutdown()
    {
        try {
            synchronized (this.server) {
                try {
                    if (this.server != null) {
                        this.server.close();
                        this.server = null;
                    }

                    super.active = false;
                } catch (IOException ex) {
                    throw new IllegalArgumentException(ex.getMessage());
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * Serves the server in the given port.
     *
     * @param port The port number.
     */
    @Override
    public void serve(int port)
    {
        if (this.isActive()) {
            return;
        }

        InputStreamReader isr = null;

        try {
            this.bootServer(port);

            while (this.isActive()) {
                Socket socket = this.server().accept();

                isr = new InputStreamReader(socket.getInputStream());
                BufferedReader input = new BufferedReader(isr);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                this.protocol(socket, input, output);

                socket.close();
            }

        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                
                this.shutdown();
            } catch (IOException ex) {
                Logger.getLogger(TcpServer.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Streams the server in the given port.
     *
     * @param port The port number.
     */
    public void stream(int port)
    {
        if (this.isActive()) {
            return;
        }

        this.bootServer(port);

        while (this.isActive()) {
            try {
                Socket socket = this.server.accept();

                new Thread() {
                    @Override
                    public void run() {
                        try {
                            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
                            BufferedReader input = new BufferedReader(isr);
                            PrintWriter output = new PrintWriter(socket.
                                    getOutputStream(), true);

                            protocol(socket, input, output);
                            
                            isr.close();
                            output.close();
                            socket.close();
                        } catch (IOException ex) {
                            Logger.getLogger(TcpServer.class.getName()).
                                    log(Level.SEVERE, null, ex);
                        }
                    }
                }.start();
            } catch (IOException ex) {
                // Don't do anything.
            }
        }

    }

    /**
     * Returns the hostname of the server, including the port.
     *
     * @return Server hostname.
     */
    public String hostname()
    {
        try {
            String hostname = InetAddress.getByName(InetAddress.getLocalHost().
                    getHostAddress()).getHostName();

            synchronized (this.server) {
                return hostname + ":" + this.server.getLocalPort();
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(TcpServer.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        synchronized (this.server) {
            return this.server.getInetAddress().getHostAddress();
        }
    }

    /**
     * Expects for a request to ask for this route.
     *
     * @param route Route.
     * @param action Action to execute if the request matches this route.
     */
    @Override
    public void expect(String route, Action action)
    {
        synchronized (this.routes) {
            this.routes.put(route, action);
        }
    }
    
    /**
     * Neglects an expected route.
     *
     * @param route Route to be neglected.
     */
    @Override
    public void neglect(String route)
    {
        synchronized (this.routes) {
            this.routes.remove(route);
        }
        
        synchronized (this.channels) {
            this.channels.remove(route);
        }
    }

    /**
     * Sends a given set of headers with a message to the given target.
     *
     * @param headers Set of headers separated by ";". This headers follow a
     * strict structure:
     *
     * route;encrypted
     *
     * Route: (String) Gives the target route to where this message will land.
     * Encrypted: (Boolean) True if the embedded message is currently encrypted.
     *
     * @param target Target defined by IPv4:Port.
     * @param message Message.
     */
    @Override
    public void send(String headers, String target, String message)
    {
        try {
            synchronized (this.server) {
                if (this.server.isClosed()) {
                    throw new IllegalArgumentException("This Tcp instance needs to have a open server to be able to communicate.");
                }
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("A server needs to be booted in order to be able to communicate.");
        }
        
        String data[] = headers.split(";");
        StringBuilder builder = new StringBuilder();

        builder.append(data[0]);
        builder.append(" ");
        builder.append(message.length());
        builder.append("\r\n");

        for (int i = 1; i < data.length; i++) {
            builder.append(data[i]);
            builder.append("\r\n");
        }
        
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("message", message);
        
        // Execute all of the wildcard channels.
        for (Channel channel : getRouteChannels("*")) {
            channel.before(arguments, dependencies);
        }
        
        // Execute all the before channels.
        for (Channel channel : getRouteChannels(data[0])) {
            channel.before(arguments, dependencies);
        }

        message = (String) arguments.get("message");

        builder.append("\r\n");
        builder.append(message);

        this.protocol(data[0], target, builder.toString());
    }

    /**
     * Communication Protocol.
     *
     * @param socket Connected socket.
     * @param input Server input stream.
     * @param output Server output stream.
     */
    protected void protocol(Socket socket, BufferedReader input, PrintWriter output)
    {
        // Handle the request headers.
        String headers = this.getHeaders(input);

        if (headers == null || headers.isEmpty()) {
            return;
        }

        Map<String, Object> args = new HashMap<>();

	// Request example:
        // :route 250\r\n
        // Other headers\r\n
        // Message
        String[] request = headers.split("\n");

        String[] first = request[0].split(" ");
        Action action = null;

        synchronized (this.routes) {
            if (!this.routes.containsKey(first[0])) {
                return;
            }

            action = this.routes.get(first[0]);
        }

        args.put("route", first[0]);
        args.put("length", first[1]);

        int i = 1;

        for (; i < request.length; i++) {
            if (request[i].isEmpty()) {
                break;
            }

            // Handle other headers.
            String[] line = request[i].split(":");
            args.put(line[0], line[1]);
        }

        StringBuilder message = new StringBuilder();

        i++;

        for (; i < request.length; i++) {
            message.append(request[i]);
        }

        args.put("message", message.toString());

        // Extra arguments.
        args.put("from", socket.getInetAddress().getHostAddress() + ":" + socket.getPort());
        args.put("hostname", socket.getInetAddress().getHostName());
        args.put("input", input);
        args.put("output", output);
        args.put("socket", socket);
        
        // Execute all of the wildcard channels.
        for (Channel channel : getRouteChannels("*")) {
            channel.before(args, dependencies);
        }
        
        // Execute all the before channels.
        for (Channel channel : getRouteChannels((String) args.get("route"))) {
            channel.before(args, dependencies);
        }
        
        action.run(args);
        
        // Execute all of the wildcard channels.
        for (Channel channel : getRouteChannels("*")) {
            channel.after(args, dependencies);
        }
        
        // Execute all the after channels.
        for (Channel channel : getRouteChannels((String) args.get("route"))) {
            channel.after(args, dependencies);
        }
    }

    /**
     * Communication Protocol.
     *
     * @param route Target route.
     * @param target Target address and port (IPv4:Port)
     * @param message Message to be sent (includes headers)
     */
    protected void protocol(String route, String target, String message)
    {
        String[] targetData = target.split(":");

        if (targetData.length < 2) {
            throw new IllegalArgumentException("Target must be defined as IPv4:Port.");
        }

        try {
            Socket socket = new Socket(targetData[0], Integer.parseInt(targetData[1]));
            this.reply(socket, message);
            socket.close();
            
            Map<String, Object> arguments = new HashMap<>();
            arguments.put("message", message);
            arguments.put("target", target);
            
            // Execute all of the wildcard channels.
            for (Channel channel : getRouteChannels("*")) {
                channel.after(arguments, dependencies);
            }
            
            // Execute all the after channels.
            for (Channel channel : getRouteChannels(route)) {
                channel.after(arguments, dependencies);
            }
        } catch (IOException ex) {
            // Don't do anything.
        }
    }

    /**
     * Gets the headers, which follow the HTTP format, from the input stream.
     *
     * @param input Input stream.
     * @return Headers.
     */
    private String getHeaders(BufferedReader input)
    {
        String headers = null;

        try {
            String lines = input.readLine();
            headers = lines;

            while ((lines = input.readLine()) != null) {
                headers += '\n' + lines;
            }
        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return headers;
    }

    /**
     * Allows the server to send a response to a socket.
     *
     * @param socket Socket.
     * @param response Response object.
     */
    protected void reply(Socket socket, Object response)
    {
        if (response instanceof String) {
            try {
                response = ((String) response).getBytes("UTF-8");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TcpServer.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        }

        try {
            socket.getOutputStream().write((byte[]) response);
        } catch (IOException ex) {
            Logger.getLogger(TcpServer.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
