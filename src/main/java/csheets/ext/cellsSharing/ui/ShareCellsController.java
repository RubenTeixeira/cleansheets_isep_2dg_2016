/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.core.Cell;
import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.framework.volt.protocols.udp.UdpServer;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShareCellsController {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * User interface panel *
     */
    private final SharePanel uiPanel;

    private TcpClient tcpClient;

    private TcpServer tcpServer;

    public ShareCellsController(UIController uiController, SharePanel uiPanel, int port) {

        this.uiController = uiController;
        this.uiPanel = uiPanel;

        HostAddressContainer addresses = new HostAddressContainer();

        Thread udpServer = new Thread() {
            @Override
            public void run() {
                new UdpClientService();
            }
        };

        Thread udpClient = new Thread() {
            @Override
            public void run() {
                new UdpServerService(addresses);
            }
        };
        Thread tcpServer = new Thread() {
            public void run() {
                new TcpServerService();
            }
        };
        
        Thread tcpClient = new Thread() {
            public void run() {
                new TcpClientService(port);
            }
        };

        udpServer.start();
        udpClient.start();
        tcpServer.start();
        tcpClient.start();
    }

    /**
     * Sends a broadcast signal requesting for hosts (their ip and port).
     *
     * @return List of available hosts
     */
    public List<String> getOtherInstances() {
        return null;
    }
}
