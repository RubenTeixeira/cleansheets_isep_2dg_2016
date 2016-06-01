/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.volt.protocols.tcp;

/**
 *
 * @author oxy
 */
public class TcpClientTest {

    public static void main(String[] args)
    {
        TcpClient client = new TcpClient(0);
        
        client.send(":hi", "25.65.227.79:8000", "WASUP asjkdlaksjdlasjdlasjdlkjasdl asldkjasldja sldkjasldkask d"
                + "alkd;aslkd;askld;lskad;lskad;lksad;ksa;dlk");
    }
    
}
