/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.core.Cell;
import csheets.framework.volt.protocols.tcp.TcpClient;

/**
 *
 * @author scarl
 */
public class TcpClientService {

    TcpClient tcpClient;

    public TcpClientService(int port) {
        tcpClient = new TcpClient(port);
    }

    /**
     * Sends a array of Cells to the targeted host.
     *
     * @param target Targeted Host (ip and port)
     * @param cells Array of Cells
     */
    public void sendCells(String target, Cell[][] cells) {
        String message = "";
        int linhas = cells.length;
        int colunas = cells[0].length;
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Cell cell = cells[i][j];

                message += cell.getAddress().getColumn() + "," + cell.getAddress().getRow() + "|" + cell.getValue().getType() + "," + cell.getValue() + "@"; //prototipo TODO MESSAGE TO SEND
            }
        }
        tcpClient.send(":address|:value", target, message);
    }
}