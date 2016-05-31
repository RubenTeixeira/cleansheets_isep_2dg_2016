/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing;

import csheets.core.Cell;
import csheets.support.volt.protocols.udp.UdpClient;
import csheets.support.volt.protocols.udp.UdpServer;
import java.util.List;

public class ShareCellsController {

    public ShareCellsController(int port) {      
        Thread udpServer = new Thread() {
            @Override
            public void run() {
                new UdpServer();
            }
        };
        
        Thread udpClient = new Thread() {
            @Override
            public void run() {
                new UdpClient(8000);
            }
        };
        
        Thread tcpServer = new Thread() {
            public void run() {
                
            }
        };
        
        udpServer.start();
        udpClient.start();
        tcpServer.start();
    }
    
    /**
     * Sends a broadcast signal requesting for hosts (their ip and port).
     * @return List of available hosts
     */
    public List<String> getOtherInstances() {
        return null;
    }
    
    /**
     * Sends a array of Cells to the targeted host.
     * @param target Targeted Host (ip and port)
     * @param cells Array of Cells
     */
    public void sendCells(String target, Cell[][] cells) {
        
    }
}
