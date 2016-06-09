/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.chatApp.ui;

import csheets.notification.Notification;
import java.util.LinkedHashMap;
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

	void startUdpService(int seconds) {
		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds. It's not possible to register negative or zero seconds.");
		}
		try {
			this.udpService.server();
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
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(ChatUI ui, int seconds) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}
		this.udpService = new UdpService();
		this.startUdpService(seconds);
		this.udpService.addObserver(ui);
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param port The target port that is defined by the user.
	 */
	private void startTcpService() {
		try {
			this.tcpService.server();

		} catch (IllegalArgumentException e) {
			this.tcpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param ui user interface od chat
	 */
	public void startTcpService(ChatUI ui) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}
		this.tcpService = new TcpService();
		this.startTcpService();
	}

	/**
	 * Restarts both the UDP and TCP services.
	 *
	 * @param seconds The number of seconds to execute each request.
	 */
	public void restartServices(int seconds) {
		this.tcpService.stop();
		this.udpService.stop();
		this.startUdpService(seconds);
		this.startTcpService();
	}

	public void sendMessage(String hostname, String target, String message) {
		Map<String, String> sendMessage = new LinkedHashMap<>();
		sendMessage.put("reference", "sendMessage");
		sendMessage.put("hostname", hostname);
		sendMessage.put("message", message);
		sendMessage.put("target", target);
		Notification.chatMessageInformer().
			notifyChange(sendMessage);
		new TcpService().client(target, message);
	}

}
