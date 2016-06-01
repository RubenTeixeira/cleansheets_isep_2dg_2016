/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.volt.protocols.tcp;

import csheets.support.Task;
import csheets.support.TaskManager;

/**
 *
 * @author oxy
 */
public class TcpClientTest {

	public static void main(String[] args) {
		TcpClient client = new TcpClient(0);

		Task hi = new Task() {
			public void fire() {
				client.
					send(":hi", "25.73.142.236:8000", "WASUP asjkdlaksjdlasjdlasjdlkjasdl asldkjasldja sldkjasldkask d"
						 + "alkd;aslkd;askld;lskad;lskad;lksad;ksa;dlk");
			}
		};

		Task hi2 = new Task() {
			public void fire() {
				client.send(":olaaa", "25.73.142.236:8000", "ola ta tudo bem");

			}
		};

		TaskManager tm = new TaskManager();

		tm.every(2).fire(hi);
		tm.after(2).every(2).fire(hi2);

	}

}
