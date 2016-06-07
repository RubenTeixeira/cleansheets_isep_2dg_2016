/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

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
	private void startUdpService(int port, int seconds) {
		if (port < 0 || port > 49151) {
			throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
		}

		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds number given. It's not possible to register negative or zero seconds.");
		}

		try {
			this.udpService.server(30606, port);
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();

			throw e;
		}
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

		this.startUdpService(port, seconds);

		this.udpService.addObserver(panel);
	}

}
