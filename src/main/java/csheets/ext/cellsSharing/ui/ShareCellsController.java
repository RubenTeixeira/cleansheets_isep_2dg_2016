package csheets.ext.cellsSharing.ui;

import csheets.ui.ctrl.UIController;

public class ShareCellsController {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * User interface panel *
     */
    private final SharePanel uiPanel;

    public ShareCellsController(UIController uiController, SharePanel uiPanel, int port) {

        this.uiController = uiController;
        this.uiPanel = uiPanel;
        
        UdpClientService udpClientService = new UdpClientService();
        UdpServerService udpServerService = new UdpServerService();
        TcpServerService tcpServerService = new TcpServerService();
        
        udpServerService.addObserver(uiPanel);
        //tcpServerService.addObserver(uiPanel);
    }
}
