package csheets.ext.distributedWorkbook.ui;

import csheets.ext.distributedWorkbook.SearchWorkbook;
import csheets.ui.ctrl.UIController;

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

	private SearchWorkbook searchWorkbook;

	public void newSearch(UIController uiController) {
		this.searchWorkbook = new SearchWorkbook(uiController);
	}

	void startUdpService(int port, int seconds) {

		if (port < 0 || port > 49151) {
			throw new IllegalArgumentException("Invalid port was defined. Please select a valid port.");
		}

		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds. It's not possible to register negative or zero seconds.");
		}

		try {
			this.udpService.server(30602, port);
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param ui Workbook Search ui
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
	 * @param ui Workbook Search ui
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
	 * Stop both the UDP and TCP services.
	 */
	public void stopServices() {
		this.tcpService.stop();
		this.udpService.stop();
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

	public void setNameOfWorkbookToSearch(String name) {
		searchWorkbook.setWorkbookToSearch(name);
	}

	public void searchWorkbook(UIController uiController) {
		searchWorkbook.findWorkbook();
	}

	public boolean checkResult() {
		return searchWorkbook.result();
	}

	public String getWorkbookSummary() {
		return searchWorkbook.getSummary();
	}
}
