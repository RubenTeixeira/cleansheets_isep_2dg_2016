/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.volt.protocols.udp;

/**
 *
 * @author Carlos Mateus
 */
public class UdpClientTest {

    public static void main(String[] args) {
        UdpClient client = new UdpClient(0);
        client.send(":oi", "25.58.255.35:30600", "Enviar mensagem");
    }

}
