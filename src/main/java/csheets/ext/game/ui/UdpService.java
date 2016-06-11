package csheets.ext.game.ui;

import csheets.AppSettings;
import csheets.ext.NetworkManager;
import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.framework.volt.protocols.udp.UdpServer;
import csheets.notification.Notifier;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.support.ThreadManager;
import java.util.ArrayList;
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
	 * @param localPort The local port to contact other UDP servers.
	 * @param targetPort The target port, customized by the user.
	 */
	public void server(int localPort, int targetPort) {
		ThreadManager.create("ipc.game-udpServer", new Thread() {
							 @Override
							 public void run() {
								 server = NetworkManager.udp();

								 server.expect(":game-broadcast", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {

												   /*if (server.same(args.
													   get("from"))) {
													   return;
												   }*/
												   // Destination = Target's IP and Port
//												   String destination = ((String) args.
//													   get("from")).
//													   split(":")[0] + ":" + AppSettings.instance().get("UDP_PORT");
												   String destination = ((String) args.
													   get("hostname")).
													   split(":")[0] + ":" + AppSettings.
													   instance().
													   get("UDP_PORT");
												   server.
													   send(":game-port", destination, String.
															valueOf(targetPort));
											   }
										   });

								 server.expect(":game-port", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   List<String> ports = (List<String>) args.
													   get("game-port");

												   List<String> addresses = new ArrayList<>();

												   for (String port : ports) {
//													   addresses.
//														   add((((String) args.
//															   get("from")).
//															   split(":")[0]) + ":" + port);
													   addresses.
														   add((((String) args.
															   get("hostname")).
															   split(":")[0]) + ":" + port);
												   }

												   notifyChange(addresses);
											   }
										   });

							 }
						 });

		ThreadManager.run("ipc.game-udpServer");
	}

	/**
	 * Initializes a client following the UDP protocol.
	 *
	 * @param seconds Time in seconds to send another request.
	 */
	public void client(int seconds) {
		ThreadManager.create("ipc.game-udpClient", new Thread() {
							 @Override
							 public void run() {
								 UdpClient client = new UdpClient(0);

								 Task broadcast = new Task() {
									 @Override
									 public void fire() {
										 client.
											 send(":game-broadcast", "all:" + AppSettings.
												  instance().get("UDP_PORT"), "check");
									 }
								 };

								 TaskManager manager = new TaskManager();

								 manager.after(10).every(seconds).
									 fire(broadcast);
							 }
						 });

		ThreadManager.run("ipc.game-udpClient");
	}

	/**
	 * Stops all the UDP services.
	 */
	public void stop() {
		server.shutdown();
		ThreadManager.destroy("ipc.game-udpServer");
		ThreadManager.destroy("ipc.game-udpClient");
	}

}
