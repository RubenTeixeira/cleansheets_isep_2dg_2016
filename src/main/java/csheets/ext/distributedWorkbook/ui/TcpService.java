package csheets.ext.distributedWorkbook.ui;

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

												   String destination = ((String) args.
													   get("from")).
													   split(":")[0] + ":" + port;

												   int reply = JOptionPane.
													   showConfirmDialog(null, message);

												   switch (reply) {
													   case JOptionPane.YES_OPTION: {
														   server.
															   send(":reply", destination, "TRUE");
														   break;
													   }
													   case JOptionPane.NO_OPTION: {
														   server.
															   send(":reply", destination, "FALSE");
														   break;
													   }
													   default:
														   server.
															   send(":reply", destination, "FALSE");
														   break;
												   }
											   }
										   });

								 server.expect(":reply", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   notifyChange(args.
													   get("message"));
											   }
										   });

								 server.expect(":search", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   String[] search = new String[3];
												   search[0] = "Search";
												   search[1] = ((String) args.
													   get("message"));
												   search[2] = ((String) args.
													   get("from")).
													   split(":")[0] + ":" + port;

												   notifyChange(search);
											   }
										   });

								 server.expect(":result", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   notifyChange(args.
													   get("message"));
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
	 * Initializes a client following the TCP protocol.
	 *
	 * @param target The target IPv4:Port
	 * @param message Message to send to the target.
	 */
	public void searchWorkbook(String target, String message) {
		ThreadManager.create("ipc.searchTcpClient", new Thread() {
							 @Override
							 public void run() {
								 new TcpClient(0).
									 send(":search", target, message);
							 }
						 });

		ThreadManager.run("ipc.searchTcpClient");
	}

	/**
	 * Initializes a client following the TCP protocol.
	 *
	 * @param target The target IPv4:Port
	 * @param message Message to send to the target.
	 */
	public void searchResult(String target, String message) {
		ThreadManager.create("ipc.resultTcpClient", new Thread() {
							 @Override
							 public void run() {
								 new TcpClient(0).
									 send(":result", target, message);
							 }
						 });

		ThreadManager.run("ipc.resultTcpClient");
	}

	/**
	 * Stops all the TCP services.
	 */
	public void stop() {
		server.shutdown();
		ThreadManager.destroy("ipc.tcpServer");
		ThreadManager.destroy("ipc.tcpClient");
		ThreadManager.destroy("ipc.searchTcpClient");
		ThreadManager.destroy("ipc.resultTcpClient");
	}
}
