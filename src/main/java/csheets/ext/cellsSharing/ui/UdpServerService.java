/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.udp.UdpServer;
import csheets.notification.Notifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UdpServerService extends Notifier {

    public UdpServerService(int port) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                UdpServer server = new UdpServer();

                server.expect(":broadcast", new Action() {
                    @Override
                    public void run(Map<String, Object> args) {

//                        if (server.same(args.get("from"))) {
//                            return;
//                        }

                        // Destination = Target's IP and Port
                        String destination = ((String) args.get("from")).split(":")[0] + ":30600";

                        server.send(":port", destination, String.valueOf(port));
                    }
                });

                server.expect(":port", new Action() {
                    @Override
                    public void run(Map<String, Object> args) {
                        List<String> ports = (List<String>) args.get("port");

                        List<String> addresses = new ArrayList<>();

                        for (int i = 0; i < ports.size(); i++) {
                            addresses.add((((String) args.get("from")).split(":")[0]) + ":" + ports.get(i));
                        }

                        notifyChange(addresses);
                    }
                });
                
                server.stream(30600);
            }
        };
        
        thread.start();
    }
}
