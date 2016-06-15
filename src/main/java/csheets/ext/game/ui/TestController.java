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
import csheets.ext.game.TicTacToe;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.tcp.TcpClient;
import vendor.volt.protocols.tcp.TcpServer;

/**
 *
 * @author AB
 */
public class TestController implements CellListener, SpecificGameController {

	private TcpServer server;
	UIController uiController;
	Spreadsheet sheet;
	String connection;
	String symbol;
	TicTacToe tictactoe;
	boolean otherPlay;
	boolean turn;

	public TestController(UIController uiController, boolean turn, String ip) {
		this.turn = true;
		this.uiController = uiController;
		connection = "127.0.0.1" + ":" + Integer.
			parseInt(AppSettings.instance().
				get("TCP_PORT"));
	}

	public void stop() {
		stopThis();
		removeListeners();
		diplayVictory();
	}

	public void start() {
		startServer();
		newSpreadsheet();
		this.tictactoe = new TicTacToe();
	}

	public void newSpreadsheet() {
		Workbook activeBook = this.uiController.getActiveWorkbook();
		activeBook.addTictactoeSpreadsheet();
		sheet = activeBook.getSpreadsheet(activeBook.getSpreadsheetCount() - 1);
	}

	public void addListeners() {
		for (int i = 0; i < tictactoe.getRowCount(); i++) {
			for (int j = 0; j < tictactoe.getColumnCount(); j++) {
				sheet.getCell(i, j).addCellListener(this);
			}
		}
	}

	public void removeListeners() {
		for (int i = 0; i < tictactoe.getRowCount(); i++) {
			for (int j = 0; j < tictactoe.getColumnCount(); j++) {
				sheet.getCell(i, j).removeCellListener(this);
			}
		}
	}

	private void startServer() {
		ThreadManager.create("ipc.tictactoe-tcpServer", new Thread() {
							 @Override
							 public void run() {
								 server = NetworkManager.tcp();

								 server.expect(":game-play", new Action() {
											   @Override
											   public void run(Request request) {
												   String cellString = request.
													   message();
												   String params[] = cellString.
													   split(";");
												   Cell spreadcheetCell = sheet.
													   getCell(Integer.
														   parseInt(params[0]), Integer.
															   parseInt(params[1]));
												   try {
													   otherPlay = true;
													   spreadcheetCell.
														   setContent(params[2]);

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
											   public void run(Request request) {
												   String cellString = request.
													   message();
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
												   stop();
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
		stop();
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
		JOptionPane.showMessageDialog(null, "Perdeste");
	}

	private void diplayVictory() {
		JOptionPane.showMessageDialog(null, "Ganhaste");
	}

	private boolean validate() {
		return true;
	}

	public void repaintBoard() {
		for (int i = 0; i < tictactoe.getRowCount(); i++) {
			for (int j = 0; j < tictactoe.getColumnCount(); j++) {
				try {
					sheet.getCell(i, j).setContent(tictactoe.getValueAt(i, j));
				} catch (FormulaCompilationException ex) {
					Logger.getLogger(TestController.class.getName()).
						log(Level.SEVERE, null, ex);
				}
			}
		}
	}

	@Override
	public void contentChanged(Cell cell) {
		if (!cell.getContent().equalsIgnoreCase(symbol)) {
			repaintBoard();
			return;
		}
		if (!turn) {
			if (otherPlay) {
				System.out.println("Deixou de ser a vez do outro");
				System.out.println("Passou a ser a minha vez");
				otherPlay = false;
				turn = true;
			} else {
				repaintBoard();
			}
			return;
		}
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
