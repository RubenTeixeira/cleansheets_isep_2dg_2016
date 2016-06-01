/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.support.Task;
import csheets.support.TaskManager;

public class UdpClientService {
    
    public UdpClientService() {
        UdpClient client = new UdpClient(8000);

        Task broadcast = new Task() {
            @Override
            public void fire() {
                client.send(":broadcast", "255.255.255.255:8000" , "check");
            }
        };

        TaskManager manager = new TaskManager();
        
        // We're giving a 30 second interval per broadcast message,
        // although this time could be changed to a smaller time
        // frame so that the information would be more reliable.
        manager.after(1).every(30).fire(broadcast);
    }
}
