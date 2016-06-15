/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.AppSettings;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.NetworkManager;
import csheets.framework.volt.Action;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AB
 */
public class TestController implements CellListener {

	private TcpServer server;
	UIController uiController;
	Spreadsheet sheet;
	String connection;
	boolean otherPlay;
	boolean turn;

	public TestController(UIController uiController, boolean turn, String ip) {
		this.turn = true;
		this.uiController = uiController;
		connection = "127.0.0.1" + ":" + Integer.
			parseInt(AppSettings.instance().
				get("TCP_PORT"));
		startServer();
		newSpreadsheet();
	}

	public void newSpreadsheet() {
		Workbook activeBook = this.uiController.getActiveWorkbook();
		activeBook.addTictactoeSpreadsheet();
		sheet = activeBook.getSpreadsheet(activeBook.getSpreadsheetCount() - 1);
	}

	public void addListeners() {
		sheet.getCell(0, 0).addCellListener(this);
		sheet.getCell(0, 1).addCellListener(this);
		sheet.getCell(0, 2).addCellListener(this);
		sheet.getCell(1, 0).addCellListener(this);
		sheet.getCell(1, 1).addCellListener(this);
		sheet.getCell(1, 2).addCellListener(this);
		sheet.getCell(2, 0).addCellListener(this);
		sheet.getCell(2, 1).addCellListener(this);
		sheet.getCell(2, 2).addCellListener(this);
	}

	private void startServer() {
		ThreadManager.create("ipc.tictactoe-tcpServer", new Thread() {
							 @Override
							 public void run() {
								 server = NetworkManager.tcp();

								 server.expect(":game-play", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   String cellString = (String) args.
													   get("message");
												   String params[] = cellString.
													   split(";");
												   Cell spreadcheetCell = sheet.
													   getCell(Integer.
														   parseInt(params[0]), Integer.
															   parseInt(params[1]));
												   try {
													   otherPlay = true;
													   spreadcheetCell.
														   setContent("XXX");

													   System.out.
														   println("Jogada do outro");
												   } catch (FormulaCompilationException ex) {
													   Logger.
														   getLogger(TestController.class.
															   getName()).
														   log(Level.SEVERE, null, ex);
												   }
											   }
										   });
								 server.expect(":game-lost", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   String cellString = (String) args.
													   get("message");
												   String params[] = cellString.
													   split(";");
												   Cell spreadcheetCell = sheet.
													   getCell(Integer.
														   parseInt(params[0]), Integer.
															   parseInt(params[0]));
												   try {
													   spreadcheetCell.
														   setContent(params[2]);
													   otherPlay = true;
												   } catch (FormulaCompilationException ex) {
													   Logger.
														   getLogger(TestController.class.
															   getName()).
														   log(Level.SEVERE, null, ex);
												   }
												   diplayLoss();
												   stopThis();
											   }
										   });

							 }
						 });

		ThreadManager.run("ipc.tictactoe-tcpServer");
	}

	/**
	 * Stops all the TCP services.
	 */
	public boolean winningPlay(Cell cell) {
		if (!isWinningPlay()) {
			return false;
		}
		String message = cell.getAddress().getColumn() + ";" + cell.
			getAddress().getRow() + ";" + cell.getContent();
		new TcpClient(0).send(":game-lost", connection, message);
		stopThis();
		diplayVictory();
		return true;
	}

	/**
	 * Stops all the TCP services.
	 */
	public void stopThis() {
		server.shutdown();
		ThreadManager.destroy("ipc.tictactoe-tcpServer");
	}

	private boolean isWinningPlay() {
		return false;
	}

	private void diplayLoss() {
		System.out.println("lost");
	}

	private void diplayVictory() {
		System.out.println("Won");
	}

	private boolean validate() {
		return true;
	}

	@Override
	public void contentChanged(Cell cell) {
		if (!cell.getSpreadsheet().equals(sheet)) {
			return;
		}

		if (turn) {
			System.out.println("Joguei na minha vez");
			if (validate()) {
				String message = cell.getAddress().getColumn() + ";" + cell.
					getAddress().getRow() + ";" + cell.getContent();
				if (winningPlay(cell)) {
					return;
				}
				new TcpClient(0).send(":game-play", connection, message);
				turn = false;
				System.out.println("Deixou de ser a minha vez");
			} else {
				cell.clear();
			}
		} else if (otherPlay) {
			System.out.println("Deixou de ser a vez do outro");
			System.out.println("Passou a ser a minha vez");
			otherPlay = false;
			turn = true;
		} else {
			System.out.println("Eu joguei fora da minha vez");
			cell.clear();
		}
	}

	@Override
	public void dependentsChanged(Cell cell) {
	}

	@Override
	public void cellCleared(Cell cell) {
	}

	@Override
	public void cellCopied(Cell cell, Cell source) {
	}

	@Override
	public void valueChanged(Cell cell) {
	}

}
