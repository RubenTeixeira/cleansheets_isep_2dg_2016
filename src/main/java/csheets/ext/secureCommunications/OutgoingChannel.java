package csheets.ext.secureCommunications;

import csheets.framework.volt.Channel;
import csheets.framework.volt.encryption.Encrypter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Observer;

/**
 *
 * @author Diogo Leite
 */
public class OutgoingChannel extends Channel {

	/**
	 * Encryption key.
	 */
	private final String key;

	/**
	 * The observer that wants to know about the sent messages.
	 */
	private final List<Observer> observers;

	public OutgoingChannel(String key, String from, Observer... observers) {
		this.key = key;
		this.observers = new ArrayList<>();
		this.observers.addAll(Arrays.asList(observers));
	}

	@Override
	public void after(Map<String, Object> args, Map<String, Object> dependencies) {
		// S -> Sent
		// SE -> Sent Encrypted
		// R -> Received
		// RE -> Received Encrypted

		String outgoing = "S";

		try {
			Encrypter.decrypt((String) args.get("message"), key);

			outgoing += "E";
		} catch (Exception e) {
			// Ignore the exception and don't do anything with the message.
		}

		outgoing += ":" + args.get("length");

		for (Observer observer : this.observers) {
			observer.update(null, outgoing);
		}
	}

}
