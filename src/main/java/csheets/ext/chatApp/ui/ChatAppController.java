/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chatApp.ui;

import csheets.AppSettings;
import csheets.ext.NetworkManager;
import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.framework.volt.protocols.udp.UdpServer;
import csheets.notification.Notification;
import csheets.support.Task;
import csheets.support.TaskManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Carlos Santos
 */
public class ChatAppController {

	public ChatAppController() {

	}
	/**
	 * The UDP Service.
	 */
	private UdpService udpService;

	/**
	 * The TCP Service.
	 */
	private TcpService tcpService;

	public void startServices(int localPort, int targetPort) {
		UdpServer udp = NetworkManager.udp();

		udp.expect(":port", new Action() {
				   @Override
				   public void run(
					   Map<String, Object> args) {
					   List<String> ports = (List<String>) args.
						   get("port");

					   Map<String, String> chatHosts = new LinkedHashMap<>();
					   chatHosts.
						   put("reference", "hosts");
					   for (String port : ports) {
						   chatHosts.
							   put((((String) args.
								   get("from")).
								   split(":")[0]) + ":" + port, (String) args.
								   get("hostname"));
					   }

					   Notification.chatMessageInformer().
						   notifyChange(chatHosts);
				   }
			   });

		udp.expect(":chatbroadcast", new Action() {
				   @Override
				   public void run(
					   Map<String, Object> args) {

					   if (udp.same(args.
						   get("from"))) {
						   return;
					   }
					   // Destination = Target's IP and Port
					   String destination = ((String) args.get("from")).
						   split(":")[0] + ":" + localPort;

					   udp.send(":port", destination, String.
								valueOf(targetPort));
				   }
			   });

		this.startUdpClient();

		TcpServer tcp = NetworkManager.tcp();

		tcp.expect(":chat", new Action() {
				   @Override
				   public void run(
					   Map<String, Object> args) {
					   Map<String, String> mapMessage = new LinkedHashMap<>();
					   mapMessage.put("reference", "chatMessage");
					   mapMessage.put("hostname", (String) args.get("hostname"));
					   mapMessage.put("from", (String) args.get("from"));
					   mapMessage.put("message", (String) args.get("message"));

					   Notification.chatMessageInformer().
						   notifyChange(mapMessage);
				   }
			   });

	}

	void startUdpService(int port, int seconds) {

		if (port < 0 || port > 49151) {
			throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
		}

		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds. It's not possible to register negative or zero seconds.");
		}

		try {
			this.udpService.server(30600, port);
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param ui user interface of chat
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(ChatUI ui, int port, int seconds) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.udpService = new UdpService();

		this.startUdpService(port, seconds);

		this.udpService.addObserver(ui);
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param port The target port that is defined by the user.
	 */
	private void startTcpService(int port) {
		if (port < 0 || port > 49151) {
			throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
		}

		try {
			this.tcpService.server(port);

		} catch (IllegalArgumentException e) {
			this.tcpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param ui user interface od chat
	 * @param port The target port that is defined by the user.
	 */
	public void startTcpService(ChatUI ui, int port) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.tcpService = new TcpService();

		this.startTcpService(port);
	}

	/**
	 * Restarts both the UDP and TCP services.
	 *
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void restartServices(int port, int seconds) {
		this.tcpService.stop();
		this.udpService.stop();

		this.startUdpService(port, seconds);
		this.startTcpService(port);
	}

	public void sendMessage(String hostname, String target, String message) {
		Map<String, String> sendMessage = new LinkedHashMap<>();
		sendMessage.put("reference", "sendMessage");
		sendMessage.put("hostname", hostname);
		sendMessage.put("message", message);
		sendMessage.put("target", target);
		Notification.
			chatMessageInformer().
			notifyChange(sendMessage);
		new TcpService().client(target, message);
	}

	private void startUdpClient() {
		UdpClient client = new UdpClient(0);

		TaskManager tm = new TaskManager();

		tm.every(5).fire(new Task() {
			public void fire() {
				client.send(":chatbroadcast", "all:" + AppSettings.
							instance().get("UDP_PORT"), "canPlay");

			}
		});
	}
}
