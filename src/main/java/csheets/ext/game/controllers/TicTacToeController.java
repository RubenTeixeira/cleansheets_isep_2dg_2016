/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.controllers;

import csheets.ext.game.controllers.SpecificGameController;
import csheets.AppSettings;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.NetworkManager;
import csheets.ext.game.domain.TicTacToe;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import vendor.volt.Action;
import vendor.volt.Request;
import vendor.volt.protocols.tcp.TcpClient;
import vendor.volt.protocols.tcp.TcpServer;

/**
 *
 * @author AB
 */
public class TicTacToeController implements CellListener, SpecificGameController {

	private TcpServer server;
	UIController uiController;
	Spreadsheet sheet;
	String connection;
	String symbol;
	TicTacToe tictactoe;
	boolean otherPlay;
	boolean turn;

	public TicTacToeController(UIController uiController, boolean turn,
							   String opponentIP) {
		this.turn = true;
		this.symbol = "X";
		this.uiController = uiController;
		connection = "127.0.0.1" + ":" + Integer.
			parseInt(AppSettings.instance().
				get("TCP_PORT"));
	}

	public void stopGame() {
		stopThis();
		removeListeners();
		diplayVictory();
	}

	public void start() {
		this.tictactoe = new TicTacToe();
		startServer();
		try {
			newSpreadsheet();
		} catch (FormulaCompilationException ex) {
			Logger.getLogger(TicTacToeController.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		addListeners();

	}

	public void newSpreadsheet() throws FormulaCompilationException {
		Workbook activeBook = this.uiController.getActiveWorkbook();
		activeBook.addTictactoeSpreadsheet();
		sheet = activeBook.getSpreadsheet(activeBook.
			getSpreadsheetCount() - 1);
		Border border = BorderFactory.
			createMatteBorder(2, 2, 2, 2, Color.ORANGE);
		StylableCell cell;
		int column = 5;
		int rows = 5;
		for (int col = 0; col < column; col++) {
			for (int row = 0; row < rows; row++) {
				if (col == 1 && row == 0) {
					sheet.getCell(1, 0).setContent("TIC");
					cell = (StylableCell) uiController.
						getActiveWorkbook().getSpreadsheet(activeBook.
							getSpreadsheetCount() - 1).
						getCell(col, row).getExtension(StyleExtension.NAME);
					cell.setForegroundColor(Color.BLUE);
					cell.setBackgroundColor(Color.LIGHT_GRAY);

					Font font = new Font("Monospaced", Font.BOLD, 20);
					cell.setFont(font);
				} else if (col == 2 && row == 0) {
					sheet.getCell(2, 0).setContent("TAC");
					cell = (StylableCell) uiController.
						getActiveWorkbook().getSpreadsheet(activeBook.
							getSpreadsheetCount() - 1).
						getCell(col, row).getExtension(StyleExtension.NAME);
					cell.setForegroundColor(Color.LIGHT_GRAY);
					cell.setBackgroundColor(Color.BLUE);
					Font font = new Font("Monospaced", Font.BOLD, 20);
					cell.setFont(font);
				} else if (col == 3 && row == 0) {
					sheet.getCell(3, 0).setContent("TOE");
					cell = (StylableCell) uiController.
						getActiveWorkbook().getSpreadsheet(activeBook.
							getSpreadsheetCount() - 1).
						getCell(col, row).getExtension(StyleExtension.NAME);
					cell.setForegroundColor(Color.BLUE);
					cell.setBackgroundColor(Color.LIGHT_GRAY);

					Font font = new Font("Monospaced", Font.BOLD, 20);
					cell.setFont(font);
				} else if (!(col >= 1 && col <= 3 && row >= 1 && row <= 3)) {
//					sheet.getCell(col, row).setContent("X");
					cell = (StylableCell) uiController.
						getActiveWorkbook().getSpreadsheet(activeBook.
							getSpreadsheetCount() - 1).
						getCell(col, row).getExtension(StyleExtension.NAME);

					cell.setBackgroundColor(Color.decode("#006400"));

				} else {

					cell = (StylableCell) uiController.
						getActiveWorkbook().getSpreadsheet(activeBook.
							getSpreadsheetCount() - 1).
						getCell(col, row).getExtension(StyleExtension.NAME);
					cell.setBorder(border);
				}
			}
		}
	}

	public void addListeners() {
		for (int i = 0; i < tictactoe.getRowCount(); i++) {
			for (int j = 0; j < tictactoe.getColumnCount(); j++) {
				sheet.getCell(i + 1, j + 1).addCellListener(this);
			}
		}
	}

	public void removeListeners() {
		for (int i = 0; i < tictactoe.getRowCount(); i++) {
			for (int j = 0; j < tictactoe.getColumnCount(); j++) {
				sheet.getCell(i + 1, j + 1).removeCellListener(this);
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
												   int column = Integer.
													   parseInt(params[0]);
												   int row = Integer.
													   parseInt(params[1]);
												   String content = params[2];
												   Cell spreadcheetCell = sheet.
													   getCell(column, row);
												   try {
													   otherPlay = true;
													   spreadcheetCell.
														   setContent(params[2]);
													   tictactoe.
														   play(column, row, content);
													   System.out.
														   println("Jogada do outro");
												   } catch (FormulaCompilationException ex) {
													   Logger.
														   getLogger(TicTacToeController.class.
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
														   getLogger(TicTacToeController.class.
															   getName()).
														   log(Level.SEVERE, null, ex);
												   }
												   stopGame();
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
		stopGame();
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
					String value = tictactoe.getValueAt(i, j);
					sheet.getCell(i + 1, j + 1).setContent(value);
				} catch (FormulaCompilationException ex) {
					Logger.getLogger(TicTacToeController.class.getName()).
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
			int column = cell.getAddress().getColumn() - 1;
			int row = cell.getAddress().getRow() - 1;
			String message = column + ";" + row + ";" + cell.getContent();
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