/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.core.Cell;
import csheets.framework.volt.protocols.udp.UdpClient;
import csheets.framework.volt.protocols.udp.UdpServer;
import csheets.ui.ctrl.UIController;
import java.util.List;

public class ShareCellsController {

	/**
	 * The user interface controller
	 */
	private final UIController uiController;

	/**
	 * User interface panel *
	 */
	private final SharePanel uiPanel;

	public ShareCellsController(UIController uiController, SharePanel uiPanel, int port) {

		this.uiController = uiController;
		this.uiPanel = uiPanel;

		Thread udpServer = new Thread() {
			@Override
			public void run() {
				new UdpClientService();
			}
		};

		Thread udpClient = new Thread() {
			@Override
			public void run() {
				new UdpServerService();
			}
		};

		Thread tcpServer = new Thread() {
			public void run() {
                            
			}
		};

		udpServer.start();
		udpClient.start();
		tcpServer.start();
	}

	/**
	 * Sends a broadcast signal requesting for hosts (their ip and port).
	 *
	 * @return List of available hosts
	 */
	public List<String> getOtherInstances() {
		return null;
	}

	/**
	 * Sends a array of Cells to the targeted host.
	 *
	 * @param target Targeted Host (ip and port)
	 * @param cells Array of Cells
	 */
	public void sendCells(String target, Cell[][] cells) {
		String message = "";
		int linhas = cells.length;
		int colunas = cells[0].length;
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				Cell cell = cells[i][j];
				message += "" + cell; //prototipo TODO MESSAGE TO SEND
			}
		}
		//TODO SEND MESSAGE BY UDP OR TCP...??
	}
}
