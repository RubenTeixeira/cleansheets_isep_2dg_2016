package csheets.ext.chatApp.ui;

import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.notification.Notification;
import csheets.notification.Notifier;
import csheets.support.ThreadManager;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * This service allows to easily set up an run the TCP protocol.
 */
public class TcpService extends Notifier {

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
								 server.expect(":chat", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   Map<String, String> mapMessage = new LinkedHashMap<>();
												   mapMessage.
													   put("reference", "chatMessage");
												   mapMessage.
													   put("hostname", (String) args.
														   get("hostname"));
												   mapMessage.
													   put("from", (String) args.
														   get("from"));
												   mapMessage.
													   put("message", (String) args.
														   get("message"));

												   Notification.
													   messageInformer().
													   notifyChange(mapMessage);
											   }
										   });

								 server.stream(port);
							 }
						 });

		ThreadManager.run("ipc.tcpServer");
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
									 send(":chat", target, message);
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
