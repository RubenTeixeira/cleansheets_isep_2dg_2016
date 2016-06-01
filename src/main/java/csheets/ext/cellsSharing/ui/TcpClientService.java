/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.core.Cell;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.support.Task;

/**
 *
 * @author scarl
 */
public class TcpClientService {

    TcpClient tcpClient;

    public TcpClientService(int port, String target, String data) {
        Thread clientTcp = new Thread() {
            public void run() {
                tcpClient = new TcpClient(port);

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
