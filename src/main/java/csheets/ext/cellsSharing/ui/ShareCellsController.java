/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.ui.ctrl.UIController;
import java.util.List;

public class ShareCellsController {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * User interface panel *
     */
    private final SharePanel uiPanel;
    
    private UdpServerService updServerService;

    public ShareCellsController(UIController uiController, SharePanel uiPanel, int port) {

        this.uiController = uiController;
        this.uiPanel = uiPanel;

        Thread udpServer = new Thread() {
            @Override
            public void run() {
                new UdpClientService();
            }
        };

        Thread udpClient = new Thread() {
            @Override
            public void run() {
                updServerService = new UdpServerService();
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
     *
     * @param observer
     * @param observable
     */
    public void addObserverToServer(SharePanel observer) {
        this.updServerService.addObserver(observer);
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
