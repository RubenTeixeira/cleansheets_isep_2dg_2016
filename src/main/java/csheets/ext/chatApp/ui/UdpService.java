package csheets.ext.chatApp.ui;

import csheets.AppSettings;
import csheets.ext.NetworkManager;
import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.framework.volt.protocols.udp.UdpServer;
import csheets.notification.Notifier;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.support.ThreadManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This service allows to easily set up an run the UDP protocol.
 */
public class UdpService extends Notifier {

	/**
	 * Server instance.
	 */
	private UdpServer server;

	/**
	 * Initializes a server following the UDP protocol.
	 *
	 */
	public void server() {
		ThreadManager.create("ipc.udpServer", new Thread() {
							 @Override
							 public void run() {
								 server = NetworkManager.udp();

								 server.expect(":chatbroadcast", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {

												   if (server.same(args.
													   get("from"))) {
													   return;
												   }
												   // Destination = Target's IP and Port
												   String destination = ((String) args.
													   get("from")).split(":")[0] + ":" + AppSettings.
													   instance().
													   get("UDP_PORT");

												   server.
													   send(":chat-port", destination, AppSettings.
															instance().
															get("TCP_PORT"));
											   }
										   });

								 server.expect(":chat-port", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   List<String> ports = (List<String>) args.
													   get("chat-port");

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

												   notifyChange(chatHosts);
											   }
										   });

							 }
						 });

		ThreadManager.run("ipc.udpServer");
	}

	/**
	 * Initializes a client following the UDP protocol.
	 *
	 * @param seconds Time in seconds to send another request.
	 */
	public void client(int seconds) {
		ThreadManager.create("ipc.udpClient", new Thread() {
							 @Override
							 public void run() {
								 UdpClient client = new UdpClient(0);

								 Task broadcast = new Task() {
									 @Override
									 public void fire() {
										 client.
											 send(":chatbroadcast", "all:" + AppSettings.
												  instance().get("UDP_PORT"), "check");
									 }
								 };

								 TaskManager manager = new TaskManager();

								 manager.after(4).every(seconds).
									 fire(broadcast);
							 }
						 });

		ThreadManager.run("ipc.udpClient");
	}

	/**
	 * Stops all the UDP services.
	 */
	public void stop() {
		server.shutdown();
		ThreadManager.destroy("ipc.udpServer");
		ThreadManager.destroy("ipc.udpClient");
	}

}
