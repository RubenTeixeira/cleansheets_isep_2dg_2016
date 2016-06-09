package csheets.ext.game.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.Volt;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.notification.Notifier;
import csheets.support.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * This service allows to easily set up an run the TCP protocol.
 */
public class TcpService extends Notifier {

	/**
	 * Server instance.
	 */
	private TcpServer server;

	String continuousTarget;

	List<String> connectedInstances;

	GamePanel panel;

	// Empty constructor
	public TcpService() {
	}

	public TcpService(GamePanel ui) {
		connectedInstances = new ArrayList<>();
		this.panel = ui;
	}

	/**
	 * Initializes a server following the UDP protocol.
	 *
	 * @param port The server port, customized by the user.
	 */
	public void server(int port) {
		ThreadManager.create("ipc.tcpServer", new Thread() {
							 @Override
							 public void run() {
								 server = Volt.tcp(port, 0);

								 server.expect("game-request", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {

												   String from = ((String) args.
													   get("from")).split(":")[0];

//												   server.
//													   send(":game-on", from + ":" + AppSettings.
//															instance().
//															get("TCP_PORT"), (String) args.
//															get("message"));
												   //notifyChange(from);
											   }
										   });

								 server.
									 expect(":game-stopped", new Action() {
											@Override
											public void run(
												Map<String, Object> args) {
												JOptionPane.
													showMessageDialog(panel, "Game has been stopped.");
											}
										});

								 server.stream(port);
							 }
						 });

		ThreadManager.run("ipc.tcpServer");
	}

	public void setContinuousTarget(String target) {
		continuousTarget = target;
	}

	public void continuousSending(String message) {
		ThreadManager.create("ipc.continuousTcpClient", new Thread() {
							 @Override
							 public void run() {
//								 new TcpClient(0).
//									 send(":game-request", continuousTarget, message);
								 int reply = JOptionPane.
									 showConfirmDialog(panel, "::. Receive information .::\n"
													   + "A host " + continuousTarget + " wants to play "
													   + " with you.\n Game: " + message + " Do you wish to play with him ?");

								 if (reply == JOptionPane.NO_OPTION || reply == JOptionPane.CANCEL_OPTION) {
									 return;
								 }

								 if (reply == JOptionPane.YES_OPTION) {
									 JOptionPane.
										 showMessageDialog(panel, "Opponent: " + continuousTarget + "\n" + "Game: " + message);
								 }

							 }
						 });
		ThreadManager.run("ipc.continuousTcpClient");
	}

	/**
	 * TODO. Terminar jogo.
	 */
	public void stopContinuousSending() {
		ThreadManager.create("ipc.continuousTcpClient", new Thread() {
							 @Override
							 public void run() {
								 new TcpClient(0).
									 send(":game-stopped", continuousTarget, "STOP");

							 }
						 });
		ThreadManager.run("ipc.continuousTcpClient");
	}
//
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
//
//							 }
//						 });
//
//		ThreadManager.run("ipc.tcpClient");
//	}

	/**
	 * Stops all the TCP services.
	 */
	public void stop() {
		server.shutdown();
		ThreadManager.destroy("ipc.tcpServer");
		ThreadManager.destroy("ipc.tcpClient");
	}
}
