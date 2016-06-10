package csheets.ext.cellsSharing.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.Volt;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.notification.Notifier;
import csheets.support.ThreadManager;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This service allows to easily set up an run the TCP protocol.
 */
public class TcpService extends Notifier {

    /**
     * Server instance.
     */
    private TcpServer server;

    String continuousTarget;

    List<String> connectedInstances;

    SharePanel panel;

    // Empty constructor
    public TcpService() {
    }

    /**
     * Handles the TCP connection.
     *
     * @param ui User Interface
     */
    public TcpService(SharePanel ui) {
        connectedInstances = new ArrayList<>();
        this.panel = ui;
    }

    /**
     * Initializes a server following the UDP protocol.
     *
     * @param port The server port, customized by the user.
     */
    public void server(int port) {
        ThreadManager.create("ipc.share-cells-tcpServer", new Thread() {
            @Override
            public void run() {
                server = Volt.tcp(port, 0);

                server.expect(":share-cells", new Action() {
                    @Override
                    public void run(
                            Map<String, Object> args) {
                        // Each cell has the following information:
                        // Column;Line;Type;Value;FontName;FontStyle;FontSize;HAlignment;VAlignment;fgColor;bgColor
                        final int params = 11;

                        Map<String, String> cells = new LinkedHashMap<>();
                        String[] data = ((String) args.
                                get("message")).
                                split(";");

                        for (int i = 0; i < data.length; i += params) {
                            // Put in the map the address and the values.
                            // Example:
                            // 0:2 => TEXT;abc
                            // Represents the A3 cell with the value of abc, which is of type TEXT.

                            if (i + 3 < data.length) {
                                cells.
                                        put(data[i] + ":" + data[i + 1], data[i + 2] + ";" + data[i + 3]
                                                + ";" + data[i + 4] + ";" + data[i + 5] + ";" + data[i + 6]
                                                + ";" + data[i + 7] + ";" + data[i + 8] + ";" + data[i + 9]
                                                + ";" + data[i + 10]);
                                continue;
                            }

                            if (i + 2 < data.length) {
                                cells.
                                        put(data[i] + ":" + data[i + 1], data[i + 2] + ";");
                                continue;
                            }

                            if (i + 1 < data.length) {
                                cells.
                                        put(data[i] + ":" + data[i + 1], ";");
                            }
                        }

                        notifyChange(cells);
                    }
                });

                server.
                        expect(":continuous-share-cells", new Action() {
                            @Override
                            public void run(
                                    Map<String, Object> args) {
                                // Each cell has the following information:
                                // Column;Line;Type;Value;FontName;FontStyle;FontSize;HAlignment;VAlignment;fgColor;bgColor
                                final int params = 11;

                                boolean knownInstance = false;

                                for (String instance : connectedInstances) {
                                    if (instance.
                                            equals(((String) args.
                                                    get("from")).
                                                    split(":")[0])) {
                                        knownInstance = true;
                                        break;
                                    }
                                }

                                // If the instance that is trying to connect isn't known by the system, 
                                // then the system asks if the user wants to allow a connection between these two instances
                                if (knownInstance == false) {
                                    if (panel.askForConfirmation((String) args.get("hostname")) == false) {
                                        return;
                                    }
                                    connectedInstances.
                                            add(((String) args.get("from")).
                                                    split(":")[0]);
                                }

                                // Checks if its time to stop the connection
                                if (((String) args.
                                        get("message")).
                                        equals("STOP")) {
                                    panel.notifyDisconnection((String) args.get("hostname"));
                                    int index = 0;
                                    for (String instance : connectedInstances) {
                                        if (instance.
                                                equals(((String) args.
                                                        get("from")).
                                                        split(":")[0])) {
                                            connectedInstances.
                                                    remove(index);
                                            return;
                                        }
                                        index++;
                                    }
                                }

                                Map<String, String> cells = new LinkedHashMap<>();
                                String[] data = ((String) args.
                                        get("message")).split(";");

                                for (int i = 0; i < data.length; i += params) {
                                    // Put in the map the address and the values.
                                    // Example:
                                    // 0:2 => TEXT;abc
                                    // Represents the A3 cell with the value of abc, which is of type TEXT.

                                    if (i + 3 < data.length) {
                                        cells.
                                                put("Continuous" + "@" + data[i] + ":" + data[i + 1], data[i + 2] + ";" + data[i + 3]
                                                        + ";" + data[i + 4] + ";" + data[i + 5] + ";" + data[i + 6]
                                                        + ";" + data[i + 7] + ";" + data[i + 8] + ";" + data[i + 9]
                                                        + ";" + data[i + 10]);
                                        continue;
                                    }

                                    if (i + 2 < data.length) {
                                        cells.
                                                put(data[i] + ":" + data[i + 1], data[i + 2] + ";");
                                        continue;
                                    }

                                    if (i + 1 < data.length) {
                                        cells.
                                                put(data[i] + ":" + data[i + 1], ";");
                                    }
                                }

                                notifyChange(cells);
                            }
                        });
            }
        });

        ThreadManager.run("ipc.share-cells-tcpServer");
    }

    /**
     * Sets the target instance for a continuous sending of messages.
     *
     * @param target Targeted instance
     */
    public void setContinuousTarget(String target) {
        continuousTarget = target;
    }

    /**
     * Sends a message identified as part of a continuous sending.
     *
     * @param message Message to be sent
     */
    public void continuousSending(String message) {
        ThreadManager.create("ipc.continuousTcpClient", new Thread() {
            @Override
            public void run() {
                new TcpClient(0).
                        send(":continuous-share-cells", continuousTarget, message);
            }
        });
        ThreadManager.run("ipc.continuousTcpClient");
    }

    /**
     * Sends a "STOP" message to signal the listening server that the continuous
     * sending of messages has stopped.
     */
    public void stopContinuousSending() {
        ThreadManager.create("ipc.continuousTcpClient", new Thread() {
            @Override
            public void run() {
                new TcpClient(0).
                        send(":continuous-share-cells", continuousTarget, "STOP");
            }
        });
        ThreadManager.run("ipc.continuousTcpClient");
    }

    /**
     * Initializes a client following the TCP protocol.
     *
     * @param target The target IPv4:Port
     * @param message Message to send to the target.
     */
    public void client(String target, String message) {
        ThreadManager.create("ipc.share-cells-tcpClient", new Thread() {
            @Override
            public void run() {
                new TcpClient(0).
                        send(":share-cells", target, message);
            }
        });

        ThreadManager.run("ipc.share-cells-tcpClient");
    }

    /**
     * Stops all the TCP services.
     */
    public void stop() {
        server.shutdown();
        ThreadManager.destroy("ipc.share-cells-tcpServer");
        ThreadManager.destroy("ipc.share-cells-tcpClient");
    }
}
