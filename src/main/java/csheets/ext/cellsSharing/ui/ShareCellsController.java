package csheets.ext.cellsSharing.ui;

import csheets.core.Cell;
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

        UdpServerService udpServerService = new UdpServerService(port);
        UdpClientService udpClientService = new UdpClientService();

        TcpServerService tcpServerService = new TcpServerService(port);

        udpServerService.addObserver(uiPanel);
        tcpServerService.addObserver(uiPanel);
    }

    /**
     * Sends a array of Cells to the targeted host.
     *
     * @param target Targeted Host (ip and port)
     * @param cells Array of Cells
     */
    public void sendCells(int port, String target, Cell[][] cells) {

        String message = "";
        int linhas = cells.length;
        int colunas = cells[0].length;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Cell cell = cells[i][j];

                message += cell.getAddress().getColumn() + ";" + cell.getAddress().getRow() + "|" + cell.getValue().getType() + ";" + cell.getValue() + ";"; //prototipo TODO MESSAGE TO SEND
            }
        }
        TcpClientService tcpService = new TcpClientService(target, message);
    }
}
