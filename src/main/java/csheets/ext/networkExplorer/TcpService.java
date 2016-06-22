package csheets.ext.networkExplorer;

import csheets.CleanSheets;
import csheets.core.Workbook;
import csheets.ext.cellsSharing.ui.*;
import csheets.notification.Notifier;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.Volt;
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

    private final String cl = ":cleansheet";
    String continuousTarget;

    List<String> connectedInstances;
    Map<String, int[]> targets = new HashMap();

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
        ThreadManager.create("ipc.network-explorer-tcpServer", new Thread() {
            @Override

            public void run() {
                server = Volt.tcp(port, 0);
                server.expect(":network-explorer", new Action() {
                    @Override
                    public void run(Request request) {
                        String destination = server.target(request.from());
                        CleanSheets sheet = UIController.getUIController().getCleanSheets();
//                        server.send(cl, destination, sheet.);
//                        server.send(cl, destination, cleansheet);
                        //worksheets
                    }
                }
                );
                ThreadManager.run("ipc.network-explorer-tcpServer");
            }
        }
        );
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

        ThreadManager.run("ipc.network-explorer-tcpClient");
    }

    /**
     * Stops all the TCP services.
     */
    public void stop() {
        server.shutdown();
        ThreadManager.destroy("ipc.network-explorer-tcpServer");
        ThreadManager.destroy("ipc.network-explorer-tcpClient");
    }
}
