/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpServer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author scarl
 */
public class TcpServerService {
    

public TcpServerService() {
      TcpServer tcpServer= new TcpServer();
  
        tcpServer.expect(":address|:value", new Action() {
            @Override
            public void run(Map<String, Object> args) {
                List<String> address = (List<String>) args.get("address");
                List<String> value = (List<String>) args.get("value");

                List<String> cellsInformation = new ArrayList<>();

                for (int i = 0; i < address.size(); i++) {
                    cellsInformation.add(address.get(i) + ":" + value.get(i));
                }
            }
        });
    }

}
