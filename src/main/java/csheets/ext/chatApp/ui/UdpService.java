package csheets.ext.chatApp.ui;

import csheets.AppSettings;
import csheets.ext.NetworkManager;
import csheets.notification.Notifier;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.support.ThreadManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.udp.UdpClient;
import vendor.volt.protocols.udp.UdpServer;

/**
 * This service allows to easily set up an run the UDP protocol.
 */
public class UdpService extends Notifier {

    /**
     * Server instance.
     */
    private UdpServer server;

    /**
     * Initializes a server following the UDP protocol.
     *
     */
    public void server() {
        ThreadManager.create("ipc.chat-udpServer", new Thread() {
            @Override
            public void run() {
                server = NetworkManager.udp();

                server.expect(":chatbroadcast", new Action() {
                    @Override
                    public void run(Request request) {

                        if (request.same()) {
                            return;
                        }
                        
                        // Destination = Target's IP and Port
                        String destination = server.target(request.from());

                        server.
                                send(":chat-port", destination, AppSettings.
                                        instance().
                                        get("TCP_PORT"));
                    }
                });

                server.expect(":chat-port", new Action() {
                    @Override
                    public void run(Request request) {
                        List<String> ports = request.get("chat-port");

                        Map<String, String> chatHosts = new LinkedHashMap<>();
                        chatHosts.
                                put("reference", "hosts");
                        for (String port : ports) {
                            chatHosts.
                                    put(
                                        request.from() + ":" + port, request.hostname()
                                    );
                        }

                        notifyChange(chatHosts);
                    }
                });

            }
        });

        ThreadManager.run("ipc.chat-udpServer");
    }

    /**
     * Initializes a client following the UDP protocol.
     *
     * @param seconds Time in seconds to send another request.
     */
    public void client(int seconds) {
        ThreadManager.create("ipc.chat-udpClient", new Thread() {
            @Override
            public void run() {
                UdpClient client = new UdpClient(0);

                Task broadcast = new Task() {
                    @Override
                    public void fire() {
                        client.
                                send(":chatbroadcast", "all:" + AppSettings.
                                        instance().get("UDP_PORT"), "check");
                    }
                };

                TaskManager manager = new TaskManager();

                manager.after(1).every(seconds).
                        fire(broadcast);
            }
        });

        ThreadManager.run("ipc.chat-udpClient");
    }

    /**
     * Stops all the UDP services.
     */
    public void stop() {
        server.shutdown();
        ThreadManager.destroy("ipc.chat-udpServer");
        ThreadManager.destroy("ipc.chat-udpClient");
    }

}
