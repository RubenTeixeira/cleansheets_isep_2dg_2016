/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.volt.protocols.udp;

import java.util.Map;
import javax.swing.Action;

/**
 *
 * @author Carlos Mateus
 */
public class UdpServerTest {
    public static void main(String[] args) 
    {
        UdpServer server = new UdpServer();
          
        server.expect(":oi", new csheets.framework.volt.Action() {
            public void run(Map<String, Object> args)
            {
                System.out.println(args.get("message"));
                
                server.send(":oi", (String) args.get("from"), "resposta do oi");
            }
        });
        
        
    }
}
