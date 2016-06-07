package csheets.framework.volt.protocols.tcp;

import csheets.framework.volt.Action;
import csheets.framework.volt.Volt;
import csheets.support.Task;
import csheets.support.TaskManager;
import java.util.Map;

public class TcpServerTest {

    public static void main(String[] args) {
//        TcpServer server = new TcpServer();
//        
//        // Define a channel.
//        server.channel(":message", new MessageDecryptionChannel("ohT3e8TJ55QOsAsx"));
//        
//        server.expect(":message", new Action() {
//            public void run(Map<String, Object> args) {
//                System.out.println("Hostname: " + (String) args.get("hostname"));
//                System.out.println((String) args.get("message"));
//            }
//        });
//
//        server.stream(8000);
        
        TcpServer server = Volt.tcp(30600);

        server.expect(":message", new Action() {
            public void run(Map<String, Object> args) {
                System.out.println((String) args.get("message"));
            }
        });

        System.out.println("hi2");

        callAnotherInstance();
    }

    public static void callAnotherInstance() {

        TaskManager tm = new TaskManager();

        tm.after(2).once(new Task() {
            public void fire() {
                System.out.println("2 ran");
                TcpServer server = Volt.tcp(30600);

                server.expect(":new-message", new Action() {
                    public void run(Map<String, Object> args) {
                        System.out.println("NEw message: " + (String) args.get("message"));
                    }
                });
            }
        });

        tm.after(5).once(new Task() {
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
