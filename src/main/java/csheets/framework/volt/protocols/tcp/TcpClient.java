package csheets.framework.volt.protocols.tcp;

/**
 *
 * @author Renato Machado
 */
public class TcpClient {
    /**
     * Client.
     */
    private final TcpServer client;

    /**
     * Client port.
     */
    private final int port;

    /**
     * Creates a new Tcp Client.
     * 
     * @param port Client port. Use 0 to use a dynamic port.
     */
    public TcpClient(int port) {
        this.port = port;
        this.client = new TcpServer().client();
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
    public void send(String headers, String target, String message) {
        this.client.bootServer(this.port);
        this.client.send(headers, target, message);
        this.client.shutdown();
    }
}
