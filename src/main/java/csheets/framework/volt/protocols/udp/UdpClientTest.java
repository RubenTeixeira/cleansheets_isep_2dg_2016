package csheets.framework.volt.protocols.udp;

import csheets.framework.volt.channels.MessageEncryptionChannel;
import csheets.support.Task;
import csheets.support.TaskManager;

public class UdpClientTest {

    public static void main(String[] args) {
        UdpClient client = new UdpClient(0);
        
        // Define the channel.
        client.client().channel(":message", new MessageEncryptionChannel("ohT3e8TJ55QOsAsx"));
        
        TaskManager tm = new TaskManager();
        
        // Execute the broadcast task every 4 seconds.
        tm.every(4).fire(new Task() {
            @Override
            public void fire()
            {
                client.send(":message", "all:30600", "Meet Volt.");
            }
        });
        
    }

}
