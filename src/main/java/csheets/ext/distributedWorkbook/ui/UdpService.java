package csheets.ext.distributedWorkbook.ui;

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

	private static final String BROADCAST_HEADER = ":distributed-broadcast";
	private static final String PORT_HEADER = ":distributed-port";
	private static final int BROADCAST_TIMEOUT = 20;

	/**
	 * Server instance.
	 */
	private UdpServer server;

	/**
	 * Initializes a server following the UDP protocol.
	 *
	 */
	public void server() {
		System.out.println("creating server");
		ThreadManager.create("ipc.distributed-udpServer", new Thread() {
			@Override
			public void run() {
				server = NetworkManager.udp();

				server.
					expect(BROADCAST_HEADER, new Action() {
						@Override
						public void run(
							Map<String, Object> args) {
//
//												if (server.same(args.
//													get("from"))) {
//													return;
//												}
								// Destination = Target's IP and Port
								System.out.println("Received BROADCAST_HEADER");
								String destination = ((String) args.
								get("from")).split(":")[0] + ":" + AppSettings.
								instance().get("UDP_PORT");

								System.out.println("Sending PORT_HEADER");
								server.
								send(PORT_HEADER, destination, AppSettings.
									 instance().
									 get("TCP_PORT"));
							}
					});

				server.
					expect(PORT_HEADER, new Action() {
						@Override
						public void run(
							Map<String, Object> args) {
								System.out.println("Received PORT_HEADER");
								List<String> ports = (List<String>) args.
								get("distributed-port");

								List<String> addresses = new ArrayList<>();

								for (String port : ports) {
									addresses.
									add((((String) args.
										get("from")).
										split(":")[0]) + ":" + port);
								}

								notifyChange(addresses);
							}
					});

			}
		});

		ThreadManager.run("ipc.distributed-udpServer");
	}

	/**
	 * Initializes a client following the UDP protocol.
	 *
	 * @param seconds Time in seconds to send another request.
	 */
	public void client(int seconds) {
		ThreadManager.create("ipc.distributed-udpClient", new Thread() {
			@Override
			public void run() {
				UdpClient client = new UdpClient(0);

				Task broadcast = new Task() {
					@Override
					public void fire() {
						System.out.println("Sending BROADCAST_HEADER");
						client.
							send(BROADCAST_HEADER, "all:" + AppSettings.
								 instance().get("UDP_PORT"), "check");
					}
				};

				TaskManager manager = new TaskManager();

				manager.after(3).every(seconds).fire(broadcast);
				manager.after(BROADCAST_TIMEOUT).once(new Task() {
					@Override
					public void fire() {
						broadcast.kill();
					}
				});
			}
		});

		ThreadManager.run("ipc.distributed-udpClient");
	}

	/**
	 * Stops all the UDP services.
	 */
	public void stop() {
		server.shutdown();
		ThreadManager.destroy("ipc.distributed-udpServer");
		ThreadManager.destroy("ipc.distributed-udpClient");
	}

}
