/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.AppSettings;

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

		this.udpService = new csheets.ext.game.ui.UdpService();

		this.startUdpService(port, seconds);

		this.udpService.addObserver(panel);
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param port The target port that is defined by the user.
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
			this.udpService.server(Integer.valueOf(AppSettings.instance().
				get("TCP_PORT")), Integer.valueOf(AppSettings.instance().
								   get("TCP_PORT")));
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();

			throw e;
		}
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

		this.tcpService = new TcpService(panel);

		this.startTcpService(port);

		this.tcpService.addObserver(panel);
	}

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

	public void establishConnection(String host, String message) {
		this.tcpService.client(host, message);
	}

	public void setContinuousTarget(String target) {
		this.tcpService.setContinuousTarget(target);
	}

	public void stopConnection() {
		this.tcpService.stopContinuousSending();
	}

	public void updateOpponentActiveGames(String target) {
		this.tcpService.updateOpponent(target);
	}

	/**
	 * Starts the TCP Service.
	 *
	 * @param observer observer
	 * @param username username
	 * @param image image
	 */
//	public void startServices(GamePanel panel, String username) {
//
//		TcpServer tcp = NetworkManager.tcp();
//
//		tcp.expect(":game-request", new Action() {
//				   @Override
//				   public void run(Map<String, Object> args) {
//					   // Get the game type and so on...
//
//					   int reply = JOptionPane.
//						   showConfirmDialog(panel, "::. Receive information .::\n"
//											 + "A host (" + (String) args.
//											 get("from") + ") wants to play "
//											 + (String) args.get("message")
//											 + " with you.\nDo you wish to play with him?");
//
//					   // Needs to get answer from the UI.
//					   if (reply == JOptionPane.NO_OPTION || reply == JOptionPane.CANCEL_OPTION) {
//						   return;
//					   }
//
//					   String from = ((String) args.get("from")).split(":")[0];
//
//					   tcp.send(":game-on", from + ":" + AppSettings.instance().
//								get("TCP_PORT"), (String) args.get("message"));
//				   }
//			   });
//
//		tcp.expect(":game-on", new Action() {
//				   public void run(Map<String, Object> args) {
//					   JOptionPane.
//						   showMessageDialog(panel, "Game is being played!");
//				   }
//			   });
//
//	}
//	public void requestMatch(String target, String gameType) {
//		TcpClient client = new TcpClient(0);
//
//		client.send(":game-request", target + ":" + AppSettings.instance().
//					get("TCP_PORT"), gameType);
//	}
//	/**
//	 * Initializes a client following the TCP protocol.
//	 *
//	 * @param target The target IPv4:Port
//	 * @param message Message to send to the target.
//	 */
//	public void client(String target, String message) {
//		ThreadManager.create("ipc.tcpClient", new Thread() {
//							 @Override
//							 public void run() {
//								 new TcpClient(0).
//									 send(":game-request", target, message);
//							 }
//						 });
//
//		ThreadManager.run("ipc.tcpClient");
//	}
}
