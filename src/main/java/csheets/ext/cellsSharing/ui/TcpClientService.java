/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.core.Cell;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.notification.Notifier;
import csheets.support.Task;

/**
 *
 * @author scarl
 */
public class TcpClientService {

    public TcpClientService(String target, String data) {
        Thread clientTcp = new Thread() {
            @Override
            public void run() {
                TcpClient tcpClient = new TcpClient(0);
                Task sendData = new Task() {
                    @Override
                    public void fire() {
                        tcpClient.send(":share-cells", target, data);
                    }
                };
            }
        };
        clientTcp.start();
    }

}
