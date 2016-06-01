package csheets.ext.cellsSharing.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.notification.Notifier;
import csheets.support.Task;
import csheets.support.ThreadManager;
import java.util.HashMap;
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
    
    /**
     * Initializes a server following the UDP protocol.
     *
     * @param port The server port, customized by the user.
     */
    public void server(int port)
    {
        ThreadManager.create("ipc.tcpServer", new Thread() {
            @Override
            public void run() {
                server = new TcpServer();
                
                server.expect(":address|:value", new Action() {
                    @Override
                    public void run(Map<String, Object> args) {
//                      List<String> hosts = (List<String>) args.get("from");
//                      notifyChange(hosts);
                        List<String> address = (List<String>) args.get("address");
                        List<String> value = (List<String>) args.get("value");

                        Map<String, String> cellsInformation = new HashMap<>();

                        for (int i = 0; i < address.size(); i++) {
                            cellsInformation.put(address.get(i), value.get(i));
                        }
                        notifyChange(cellsInformation);
                    }
                });
                
                server.stream(port);
            }
        });
        
        ThreadManager.run("ipc.tcpServer");
    }
    
    /**
     * Initializes a client following the TCP protocol.
     * 
     * @param target The target IPv4:Port
     * @param message Message to send to the target.
     */
    public void client(String target, String message)
    {
        ThreadManager.create("ipc.tcpClient", new Thread() {
            @Override
            public void run() {
                new TcpClient(0).send(":share-cells", target, message);
            }
        });
        
        ThreadManager.run("ipc.tcpClient");
    }

    /**
     * Stops all the TCP services.
     */
    public void stop()
    {
        server.shutdown();
        ThreadManager.destroy("ipc.tcpServer");
        ThreadManager.destroy("ipc.tcpClient");
    }
}
