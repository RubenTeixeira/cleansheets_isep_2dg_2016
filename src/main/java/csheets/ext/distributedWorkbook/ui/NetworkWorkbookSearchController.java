/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.distributedWorkbook.ui;

import csheets.core.Workbook;
import csheets.ext.distributedWorkbook.WorkBookDTO;
import csheets.ext.distributedWorkbook.WorkBookDTOAssembler;
import csheets.framework.search.LocalWorkbookSearch;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Based on previous implementation by José Barros
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class NetworkWorkbookSearchController {

	/**
	 * The UDP Service.
	 */
	private UdpService udpService;

	/**
	 * The TCP Service.
	 */
	private TcpService tcpService;

	/**
	 * The constructor
	 */
	public NetworkWorkbookSearchController() {
	}

	/**
	 * Performs a new search for workbooks
	 *
	 * @param uiController the UIController
	 * @param search the search pattern
	 * @return list of WorkbookDTO
	 */
	public List<WorkBookDTO> newLocalSearch(UIController uiController,
											String search) {
		LocalWorkbookSearch localSearch = new LocalWorkbookSearch(uiController, search);
		List<Workbook> foundWorkbooks = localSearch.getResults();
		if (foundWorkbooks == null) {
			return null;
		}
		List<WorkBookDTO> resultList = new ArrayList<>();
		for (Workbook foundWorkbook : foundWorkbooks) {
			resultList.add(WorkBookDTOAssembler.getWorkbookDTO(foundWorkbook));
		}
		return resultList;
	}

	/**
	 * Initiates the transaction by requesting the user permission, and if
	 * granted, the subsequent operations
	 *
	 * @param target the target host
	 * @param permissionMessage the message the permission request shall carry
	 */
	public void initiateSearch(String target, String permissionMessage) {
		this.tcpService.requestPermission(target, permissionMessage);
	}

	/**
	 * Restarts the UDP service.
	 *
	 * @param ui UI of Workbook Search
	 * @param seconds The number of seconds to execute each request.
	 */
	public void restartUdpService(NetworkWorkbookSearchPanel ui, int seconds) {
		if (this.udpService == null) {
			startUdpService(ui, seconds);
		} else {
			startUdpService(seconds);
		}

	}

	/**
	 * Restarts the TCP service.
	 *
	 * @param ui UI of Workbook Search
	 * @param pattern the Workbook name pattern.
	 */
	public void restartTcpService(NetworkWorkbookSearchPanel ui, String pattern) {
		if (this.tcpService == null) {
			startTcpService(ui, pattern);
			System.out.println("Starting tcpserver from scratch");
		} else {
			startTcpService(pattern);
			System.out.println("Restart tcp server");
		}
	}

	/**
	 * Starts the UDP service
	 *
	 * @param seconds The number of seconds to execute each request.
	 */
	private void startUdpService(int seconds) {
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
	 * @param seconds The number of seconds to execute each request.
	 */
	public void startUdpService(
		NetworkWorkbookSearchPanel ui, int seconds) {
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
	 * @param pattern the Workbook name pattern.
	 */
	private void startTcpService(String pattern) {
		try {
			this.tcpService.server(pattern);

		} catch (IllegalArgumentException e) {
			this.tcpService.stop();

			throw e;
		}
	}

	/**
	 * Starts the TCP service.
	 *
	 * @param ui Workbook Search ui
	 * @param pattern the Workbook name pattern.
	 */
	public void startTcpService(NetworkWorkbookSearchPanel ui, String pattern) {
		if (ui == null) {
			System.out.println("error");
			throw new IllegalArgumentException("The user interface cannot be null.");
		}

		this.tcpService = new TcpService();

		this.startTcpService(pattern);

		this.tcpService.addObserver(ui);
	}

	/**
	 * Stop both the UDP and TCP services.
	 */
	public void stopServices() {
		try {
			this.tcpService.stop();
			this.udpService.stop();
		} catch (NullPointerException ex) {

		}
		this.udpService = null;
		this.tcpService = null;
	}

	/**
	 * Sends a Workbook search result to a target host
	 *
	 * @param search search pattern
	 * @param result The string representation of the result
	 */
	void sendSearchResult(String target, String result) {
		tcpService.sendSearchResult(target, result);
	}
}
