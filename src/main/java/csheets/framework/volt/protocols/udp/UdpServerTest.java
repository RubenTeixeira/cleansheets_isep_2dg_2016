package csheets.framework.volt.protocols.udp;

import csheets.framework.volt.Action;
import csheets.framework.volt.Volt;
import csheets.support.Task;
import csheets.support.TaskManager;
import java.util.Map;

public class UdpServerTest {
    
    /**
     * Announcing Channels and Dependencies.
     */
    public static void main(String[] args) 
    {
//        UdpServer server = new UdpServer();
//        
//        // Define a channel.
//        server.channel(":message", new MessageDecryptionChannel("ohT3e8TJ55QOsAsx"));
//        
//        // Define a dependency.
//        server.use("numbers", new int[] {1, 2, 3, 4, 5});
//        
//        server.expect(":message", new Action() {
//            @Override
//            public void run(Map<String, Object> args)
//            {
//                // Message was manipulated in the channel.
//                String message = (String) ((List<String>) args.get("message")).get(0);
//                
//                // Get the dependency.
//                int size = ((int[]) server.get("numbers")).length;
//                
//                System.out.println("Size of numbers array: " + size);
//                System.out.println("Message: " + message);
//                System.out.println("Hostname: " + (String) args.get("hostname"));
//            }
//        });
//        
//        server.stream(30600);
        
        
        UdpServer server = Volt.udp(30600);
        
        System.out.println(server.getPort());
        
        
        server.expect(":message", new Action() {
            public void run(Map<String, Object> args) {
                System.out.println((String) args.get("message").toString());
            }
        });
        
        System.out.println("hi2");
        
        callAnotherInstance();
    }
    
    public static void callAnotherInstance()
    {
       
        
        TaskManager tm = new TaskManager();
       
        tm.after(2).once(new Task() {
            public void fire() {
                System.out.println("2 ran");
                UdpServer server = Volt.udp(30600);
                
                server.expect(":new-message", new Action() {
                    public void run(Map<String, Object> args) {
                        System.out.println("NEw message: " + (String) args.get("new-message").toString());
                    }
                });
            }
        });
        
        tm.after(9).once(new Task() {
            public void fire() {
                // server.neglect(":message");
                System.out.println("wsup");
                Volt.stop(30600);
            }
        });
        
        tm.after(10).once(new Task() {
            public void fire() {
                tm.destroy();
            }
        });
        
        System.out.println("hi");
    }
}
