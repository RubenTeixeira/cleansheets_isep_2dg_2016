package csheets.framework.volt.protocols.udp;

import csheets.framework.volt.Action;
import csheets.framework.volt.channels.MessageDecryptionChannel;
import java.util.List;
import java.util.Map;

public class UdpServerTest {
    
    /**
     * Announcing Channels and Dependencies.
     */
    public static void main(String[] args) 
    {
        UdpServer server = new UdpServer();
        
        // Define a channel.
        server.channel(":message", new MessageDecryptionChannel("ohT3e8TJ55QOsAsx"));
        
        // Define a dependency.
        server.use("numbers", new int[] {1, 2, 3, 4, 5});
        
        server.expect(":message", new Action() {
            @Override
            public void run(Map<String, Object> args)
            {
                // Message was manipulated in the channel.
                String message = (String) ((List<String>) args.get("message")).get(0);
                
                // Get the dependency.
                int size = ((int[]) server.get("numbers")).length;
                
                System.out.println("Size of numbers array: " + size);
                System.out.println("Message: " + message);
                System.out.println("Hostname: " + (String) args.get("hostname"));
            }
        });
        
        server.stream(30600);
    }
}
