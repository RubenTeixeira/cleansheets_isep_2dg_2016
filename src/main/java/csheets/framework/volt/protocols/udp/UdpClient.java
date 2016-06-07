package csheets.framework.volt.protocols.udp;

public class UdpClient {

    private final UdpServer client;
    
    private final int port;
    
    public UdpClient(int port)
    {
        this.port = port;
        this.client = new UdpServer();
    }
    
    /**
     * Gets the client.
     * 
     * @return Client instance.
     */
    public UdpServer client()
    {
        return this.client;
    }
    
    public void send(String route, String target, String message)
    {
        this.client.bootServer(this.port);
        this.client.send(route, target, message);
        this.client.shutdown();
    }
    
    @Override
    public String toString (){
        return client.server().getInetAddress().getHostAddress() + ":" + port;
    }
}
