package csheets.framework.volt.protocols.tcp;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renato Machado
 */
public class TcpClient {
    private final TcpServer client;

    private final int port;

    public TcpClient(int port) {
        this.port = port;
        this.client = new TcpServer().client();
    }

    public void send(String route, String target, String message) {
        try {
            this.client.bootServer(this.port);
            this.client.send(route, target, message);
            this.client.shutdown();
        } catch (IOException ex) {
            Logger.getLogger(TcpClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return client.hostname();
    }
}
