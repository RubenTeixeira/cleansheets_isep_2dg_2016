package csheets.ext.distributedWorkbook.ui;

import csheets.ext.NetworkManager;
import csheets.notification.Notifier;
import csheets.support.ThreadManager;
import javax.swing.JOptionPane;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.tcp.TcpClient;
import vendor.volt.protocols.tcp.TcpServer;

/**
 * This service allows to easily set up an run the TCP protocol.
 */
public class TcpService extends Notifier {

    /**
     * Server instance.
     */
    private TcpServer server;

    /**
     * Initializes a server following the UDP protocol.
     *
     */
    public void server() {
        ThreadManager.create("ipc.distributed-tcpServer", new Thread() {
            @Override
            public void run() {
                server = NetworkManager.tcp();

                server.
                        expect(":distributed-request", new Action() {
                            @Override
                            public void run(Request request) {
                                String message = request.message() + " with " + request.hostname();

                                String destination = server.target(request.from());

                                int reply = JOptionPane.
                                        showConfirmDialog(null, message);

                                switch (reply) {
                                    case JOptionPane.YES_OPTION: {
                                        server.
                                                send(":distributed-reply", destination, "TRUE");
                                        break;
                                    }
                                    case JOptionPane.NO_OPTION: {
                                        server.
                                                send(":distributed-reply", destination, "FALSE");
                                        break;
                                    }
                                    default:
                                        server.
                                                send(":distributed-reply", destination, "FALSE");
                                        break;
                                }
                            }
                        });

                server.
                        expect(":distributed-reply", new Action() {
                            @Override
                            public void run(Request request) {
                                notifyChange(request.message());
                            }
                        });

                server.
                        expect(":distributed-search", new Action() {
                            @Override
                            public void run(Request request) {
                                String[] search = new String[3];
                                search[0] = "Search";
                                search[1] = request.message();
                                search[2] = server.target(request.from());

                                notifyChange(search);
                            }
                        });

                server.
                        expect(":distributed-result", new Action() {
                            @Override
                            public void run(Request request) {
                                notifyChange(request.message());
                            }
                        });

            }
        }
        );

        ThreadManager.run(
                "ipc.distributed-tcpServer");
    }

    /**
     * Initializes a client following the TCP protocol.
     *
     * @param target The target IPv4:Port
     * @param message Message to send to the target.
     */
    public void client(String target, String message) {
        ThreadManager.create("ipc.distributed-tcpClient", new Thread() {
            @Override
            public void run() {
                new TcpClient(0).
                        send(":distributed-request", target, message);
            }
        });

        ThreadManager.run("ipc.distributed-tcpClient");
    }

    /**
     * Initializes a client following the TCP protocol.
     *
     * @param target The target IPv4:Port
     * @param message Message to send to the target.
     */
    public void searchWorkbook(String target, String message) {
        ThreadManager.create("ipc.distributed-searchTcpClient", new Thread() {
            @Override
            public void run() {
                new TcpClient(0).
                        send(":distributed-search", target, message);
            }
        });

        ThreadManager.run("ipc.distributed-searchTcpClient");
    }

    /**
     * Initializes a client following the TCP protocol.
     *
     * @param target The target IPv4:Port
     * @param message Message to send to the target.
     */
    public void searchResult(String target, String message) {
        ThreadManager.create("ipc.distributed-resultTcpClient", new Thread() {
            @Override
            public void run() {
                new TcpClient(0).
                        send(":distributed-result", target, message);
            }
        });

        ThreadManager.run("ipc.distributed-resultTcpClient");
    }

    /**
     * Stops all the TCP services.
     */
    public void stop() {
        ThreadManager.destroy("ipc.distributed-tcpServer");
        ThreadManager.destroy("ipc.distributed-tcpClient");
        ThreadManager.destroy("ipc.distributed-searchTcpClient");
        ThreadManager.destroy("ipc.distributed-resultTcpClient");
    }

}
