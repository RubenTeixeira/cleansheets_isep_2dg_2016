package csheets.ext.distributedWorkbook.ui;

import csheets.ext.distributedWorkbook.SearchWorkbook;
import csheets.ui.ctrl.UIController;

/**
 * A controller to search workbooks of other instance.
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

	/**
	 * Instance responsible for save a workbook data and search to of this
	 * workbook on another instance.
	 */
	private SearchWorkbook searchWorkbook;

	/**
	 * Creates instance.
	 *
	 * @param uiController UI Controller
	 */
	public void newSearch(UIController uiController) {
		this.searchWorkbook = new SearchWorkbook(uiController);
	}

	/**
	 * Starts the UDP service
	 *
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	void startUdpService(int seconds) {
		if (seconds <= 0) {
			throw new IllegalArgumentException("Invalid seconds. It's not possible to register negative or zero seconds.");
		}

		try {
			this.udpService.server();
			this.udpService.client(seconds);
		} catch (IllegalArgumentException e) {
			this.udpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the UDP service.
	 *
	 * @param ui UI of Workbook Search
	 * @param port The target port that is defined by the user.
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(WorkbookSearchUI ui, int seconds) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.udpService = new UdpService();

		this.startUdpService(seconds);

		this.udpService.addObserver(ui);
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param port The target port that is defined by the user.
	 */
	private void startTcpService() {
		try {
			this.tcpService.server();

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
	public void startTcpService(WorkbookSearchUI ui) {
		if (ui == null) {
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.tcpService = new TcpService();

		this.startTcpService();

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
	public void restartServices(int seconds) {
		this.tcpService.stop();
		this.udpService.stop();

		this.startUdpService(seconds);
		this.startTcpService();
	}

	/**
	 * Sends a request to another instance to search workbook.
	 *
	 * @param target Targeted Host (ip and port)
	 * @param message Request message
	 */
	public void sendRequest(String target, String message) {
		tcpService.client(target, message);

	}

	/**
	 * Set name of workbook to search.
	 *
	 * @param target host
	 * @param workbookName name of workbook
	 */
	public void sendNameOfWorkbookToSearch(String target, String workbookName) {
		tcpService.searchWorkbook(target, workbookName);
	}

	/**
	 * Search the workbook in directories.
	 *
	 * @param uiController UI Controller
	 * @param workbookToSearch workbook
	 * @return response
	 */
	public boolean searchWorkbook(UIController uiController,
								  String workbookToSearch) {
		return searchWorkbook.findWorkbook(workbookToSearch);
	}

	/**
	 * Check result of search
	 *
	 * @return Response of search
	 */
	public boolean checkResult() {
		return searchWorkbook.result();
	}

	/**
	 * Gets the workbook summary
	 *
	 * @return Summary of workbook contents
	 */
	public String getWorkbookSummary() {
		return searchWorkbook.getSummary();
	}

	public void sendSearchResult(String target, String result) {
		tcpService.searchResult(target, result);
	}
}
