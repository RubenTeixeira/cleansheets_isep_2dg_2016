package csheets.framework.volt.protocols.tcp;

import csheets.framework.volt.Action;
import csheets.framework.volt.channels.MessageDecryptionChannel;
import java.util.Map;

public class TcpServerTest {

    public static void main(String[] args) {
        TcpServer server = new TcpServer();
        
        // Define a channel.
        server.channel(":message", new MessageDecryptionChannel("ohT3e8TJ55QOsAsx"));
        
        server.expect(":message", new Action() {
            public void run(Map<String, Object> args) {
                System.out.println("Hostname: " + (String) args.get("hostname"));
                System.out.println((String) args.get("message"));
            }
        });

        server.stream(8000);
    }
}
