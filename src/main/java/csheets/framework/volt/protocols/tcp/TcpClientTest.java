package csheets.framework.volt.protocols.tcp;

import csheets.framework.volt.channels.MessageEncryptionChannel;
import csheets.support.Task;
import csheets.support.TaskManager;

public class TcpClientTest {

    public static void main(String[] args) {
        TcpClient client = new TcpClient(0);
        
        // Define the channel.
        client.client().channel(":message", new MessageEncryptionChannel("ohT3e8TJ55QOsAsx"));
        

        Task message = new Task() {
            public void fire() {
                client.send(":message", "192.168.56.1:30600", "Meet Volt.");
                 client.send(":new-message", "192.168.56.1:30600", "Meet Advanced Volt.");
            }
        };

        TaskManager tm = new TaskManager();

        tm.every(2).fire(message);

    }

}
