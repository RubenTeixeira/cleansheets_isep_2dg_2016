/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.notification.Notifier;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author scarl
 */
public class TcpServerService extends Notifier {

    public TcpServerService(int port) {
        Thread serverTcp = new Thread() {
            @Override
            public void run() {
                TcpServer tcpServer = new TcpServer();
                tcpServer.expect(":address|:value", new Action() {
                    @Override
                    public void run(Map<String, Object> args) {
//                      List<String> hosts = (List<String>) args.get("from");
//                      notifyChange(hosts);
                        List<String> address = (List<String>) args.get("address");
                        List<String> value = (List<String>) args.get("value");

                        Map<String,String> cellsInformation = new HashMap<>();

                        for (int i = 0; i < address.size(); i++) {
                            cellsInformation.put(address.get(i), value.get(i));
                        }
                        notifyChange(cellsInformation);
                    }
                });
                tcpServer.stream(port);
            }
        };
    }
}
