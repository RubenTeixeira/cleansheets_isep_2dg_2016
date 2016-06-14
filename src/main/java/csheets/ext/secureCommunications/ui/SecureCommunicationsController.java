package csheets.ext.secureCommunications.ui;

import csheets.AppSettings;
import csheets.ext.NetworkManager;
import csheets.framework.volt.Action;
import csheets.framework.volt.channels.MessageEncryptionChannel;
import csheets.framework.volt.channels.MessageReceivedChannel;
import csheets.framework.volt.channels.MessageSentChannel;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.framework.volt.protocols.udp.UdpServer;
import java.util.Map;
import java.util.Observer;

public class SecureCommunicationsController {

	/**
	 * Starts the service of the current extension.
	 *
	 * @param observer User Interface to observe the communications.
	 */
	public void startServices(Observer observer) {

		UdpServer udp = NetworkManager.udp();

		udp.channel("*", new MessageReceivedChannel("Incoming from ", observer),
					new MessageSentChannel("Sent from ", observer));
		udp.expect(":secure-communication", new Action() {
			@Override
			public void run(Map<String, Object> args) {
			}
		});

		TcpServer tcp = NetworkManager.tcp();

		tcp.
			channel(":secure-communication", new MessageReceivedChannel("Incoming from ", observer),
					new MessageSentChannel("Sent from ", observer));

		tcp.expect(":secure-communication", new Action() {
			@Override
			public void run(Map<String, Object> args) {

			}
		});
	}

	/**
	 * Sends a message to all other CleanSheets instances in the current
	 * network.
	 *
	 * @param observer User Interface to observe the communications.
	 * @param message Message to be sent.
	 * @param secure True if the message is to be sent encrypted, false
	 * otherwise.
	 */
	public void send(Observer observer, String message, boolean secure) {
		UdpClient client = new UdpClient(0);

		if (secure) {
			client.client().channel(":secure-communication",
									new MessageEncryptionChannel(AppSettings.
										instance().getApplicationKey()));
		}
		client.send(":secure-communication", "all:" + AppSettings.instance().
					get("UDP_PORT"), message);
	}

	public int messageBytesUnsecureIncomming(String message) {

		return message.getBytes().length;

	}

	public int messageBytesSecureIncomming(String message) {

		return message.getBytes().length;

	}

	public int messageBytesUnsecureOutgoing(String message) {

		return message.getBytes().length;

	}

	public int messageBytesSecureOutgoing(String message) {

		return message.getBytes().length;

	}

}
