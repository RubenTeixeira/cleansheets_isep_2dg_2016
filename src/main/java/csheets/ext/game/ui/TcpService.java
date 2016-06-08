package csheets.ext.game.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.notification.Notifier;
import csheets.support.ThreadManager;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * This service allows to easily set up an run the TCP protocol.
 */
public class TcpService extends Notifier {

	private boolean receiveMessage;

	/**
	 * Server instance.
	 */
	private TcpServer server;

	/**
	 * Initializes a server following the UDP protocol.
	 *
	 * @param port The server port, customized by the user.
	 */
	public void server(int port) {
		ThreadManager.create("ipc.tcpServer", new Thread() {
							 @Override
							 public void run() {
								 server = new TcpServer();

								 server.expect(":request", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   String message = ((String) args.
													   get("message")) + " with " + args.
													   get("hostname");

												   int reply = JOptionPane.
													   showConfirmDialog(null, message);
												   if (reply == JOptionPane.YES_OPTION) {
													   receiveMessage = true;
													   String destination = ((String) args.
														   get("from")).
														   split(":")[0] + ":" + port;
													   server.
														   send(":reply", destination, "30606");

												   } else if (reply == JOptionPane.NO_OPTION) {
													   receiveMessage = false;
													   String destination = ((String) args.
														   get("from")).
														   split(":")[0] + ":" + port;
													   server.
														   send(":reply", destination, "30606");
												   }
											   }
										   });

								 server.expect(":reply", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   notifyChange(receiveMessage);

												   String destination = ((String) args.
													   get("from")).
													   split(":")[0] + ":" + port;
												   server.
													   send(":search", destination, "30606");
											   }
										   });

								 server.expect(":search", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   notifyChange("Search");
												   String destination = ((String) args.
													   get("from")).
													   split(":")[0] + ":" + port;
												   server.
													   send(":check", destination, "30606");
											   }
										   });

								 server.expect(":check", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   notifyChange("Check");
											   }
										   });

								 server.stream(port);
							 }
						 }
		);

		ThreadManager.run(
			"ipc.tcpServer");
	}

	/**
	 * Initializes a client following the TCP protocol.
	 *
	 * @param target The target IPv4:Port
	 * @param message Message to send to the target.
	 */
	public void client(String target, String message) {
		ThreadManager.create("ipc.tcpClient", new Thread() {
							 @Override
							 public void run() {
								 new TcpClient(0).
									 send(":request", target, message);
							 }
						 });

		ThreadManager.run("ipc.tcpClient");
	}

	/**
	 * Stops all the TCP services.
	 */
	public void stop() {
		server.shutdown();
		ThreadManager.destroy("ipc.tcpServer");
		ThreadManager.destroy("ipc.tcpClient");
	}
}
