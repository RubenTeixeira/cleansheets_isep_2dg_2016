package csheets.ext.distributedWorkbook.ui;

/**
 *
 * @author José Barros
 */
public class DistributedWorkbookSearchController {

	/**
	 * The UDP Service.
	 */
	private UdpService udpService;

	/**
	 * The TCP Service.
	 */
	private TcpService tcpService;

	void startUdpService(int port, int seconds) {

		if (port < 0 || port > 49151) {
			throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
		}

		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds. It's not possible to register negative or zero seconds.");
		}

		try {
			this.udpService.server(30601, port);
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param ui
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(WorkbookSearchUI ui, int port, int seconds) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.udpService = new UdpService();

		this.startUdpService(port, seconds);

		this.udpService.addObserver(ui);
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param port The target port that is defined by the user.
	 */
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

	/**
	 * Starts the TCP service.
	 *
	 * @param ui
	 * @param port The target port that is defined by the user.
	 */
	public void startTcpService(WorkbookSearchUI ui, int port) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.tcpService = new TcpService();

		this.startTcpService(port);

		this.tcpService.addObserver(ui);
	}

	/**
	 * Restarts both the UDP and TCP services.
	 *
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void restartServices(int port, int seconds) {
		this.tcpService.stop();
		this.udpService.stop();

		this.startUdpService(port, seconds);
		this.startTcpService(port);
	}

	public void sendRequest(String target, String message) {
		new TcpService().client(target, message);
	}
}
