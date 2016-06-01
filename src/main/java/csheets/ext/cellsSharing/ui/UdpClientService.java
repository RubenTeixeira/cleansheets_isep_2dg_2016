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

        Thread thread = new Thread() {
            @Override
            public void run() {
                UdpClient client = new UdpClient(0);
                
                Task broadcast = new Task() {
                    @Override
                    public void fire() {
                        client.send(":broadcast", "all:30600", "check");
                    }
                };

                TaskManager manager = new TaskManager();

                // We're giving a 30 second interval per broadcast message,
                // although this time could be changed to a smaller time
                // frame so that the information would be more reliable.
                manager.after(3).every(1).fire(broadcast);
            }
        };
        
        thread.start();
    }
}
