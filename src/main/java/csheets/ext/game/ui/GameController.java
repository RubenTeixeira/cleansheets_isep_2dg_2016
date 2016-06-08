/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.AppSettings;
import csheets.ext.NetworkManager;
import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.framework.volt.protocols.udp.UdpServer;
import csheets.support.Task;
import csheets.support.TaskManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;

/**
 *
 * @author João Martins
 */
public class GameController {

	/**
	 * The UDP Service.
	 */
	private UdpService udpService;

	/**
	 * The TCP Service.
	 */
	private TcpService tcpService;

	/**
	 * Starts the UDP Service.
	 *
	 * @param port Target port defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpServices(Observer observer, String username,
								 byte[] image) {
		UdpServer udp = NetworkManager.udp();

		udp.expect(":game-broadcast", new Action() {
				   @Override
				   public void run(Map<String, Object> args) {
					   udp.send(":username|:image", "all:" + AppSettings.
								instance().get("UDP_PORT"), username + "|" + new String(image));
				   }
			   });

		udp.expect(":username|:image", new Action() {
				   @Override
				   public void run(Map<String, Object> args) {
					   Map<String, Object> objects = new HashMap<>();

					   objects.put("from", (String) args.get("from"));
					   objects.put("username", ((String) ((List<String>) args.
								   get("username")).get(0)));
					   objects.put("image", ((String) ((List<String>) args.
								   get("image")).get(0)));

					   observer.update(null, objects);
				   }
			   });

		this.startUdpClient();
	}

	private void startUdpClient() {
		UdpClient client = new UdpClient(0);

		TaskManager tm = new TaskManager();

		tm.every(5).fire(new Task() {
			public void fire() {
				client.send(":game-broadcast", "all:" + AppSettings.
							instance().get("UDP_PORT"), "canPlay");

			}
		});
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param panel The user interface.
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(GamePanel panel, int port, int seconds) {
		if (panel == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.udpService = new UdpService();

		//this.startUdpService(port, seconds);
		this.udpService.addObserver(panel);
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param panel The user interface.
	 * @param port The target port that is defined by the user.
	 */
	public void startTcpService(GamePanel panel, int port) {
		if (panel == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.tcpService = new csheets.ext.game.ui.TcpService(panel);

		this.startTcpService(panel, port);

		this.tcpService.addObserver(panel);
	}

	/**
	 * Send request to another instance to establish connection.
	 *
	 * @param target
	 * @param message
	 */
	public void sendRequest(String target, String message) {
		new TcpService().client(target, message);
	}

}
