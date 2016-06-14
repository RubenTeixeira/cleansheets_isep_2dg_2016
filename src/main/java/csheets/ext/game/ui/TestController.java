/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.framework.volt.Action;
import csheets.framework.volt.Volt;
import csheets.framework.volt.protocols.tcp.TcpClient;
import csheets.framework.volt.protocols.tcp.TcpServer;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AB
 */
public class TestController implements Observer {

	private TcpServer server;
	UIController uiController;
	String connection;
	boolean otherPlay;
	boolean turn;

	public TestController(UIController uiController, boolean turn, String ip) {
		this.turn = turn;
		this.uiController = uiController;
		connection = ip + ":9449";
		startServer();
	}

	private void startServer() {
		ThreadManager.create("ipc.tictactoe-tcpServer", new Thread() {
							 @Override
							 public void run() {
								 server = Volt.tcp(9449);

								 server.expect(":game-play", new Action() {
											   @Override
											   public void run(
												   Map<String, Object> args) {
												   String cellString = (String) args.
													   get("message");
												   String params[] = cellString.
													   split(";");
												   Cell spreadcheetCell = uiController.
													   getActiveSpreadsheet().
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
												   Cell spreadcheetCell = uiController.
													   getActiveSpreadsheet().
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

	@Override
	public void update(Observable o, Object arg) {
		if (!(arg instanceof Cell)) {
			return;
		}
		Cell cell = (Cell) arg;
		if (!cell.getSpreadsheet().equals(uiController.getActiveSpreadsheet())) {
			return;
		}

		if (turn) {
			if (validate()) {
				String message = cell.getAddress().getColumn() + ";" + cell.
					getAddress().getRow() + ";" + cell.getContent();
				new TcpClient(0).send(":game-play", connection, message);
				turn = false;
			} else {
				try {
					cell.setContent("");
				} catch (FormulaCompilationException ex) {
					Logger.getLogger(TestController.class.getName()).
						log(Level.SEVERE, null, ex);
				}
			}
		} else if (otherPlay) {
			otherPlay = false;
			turn = true;
		} else {
			try {
				cell.setContent("");
			} catch (FormulaCompilationException ex) {
				Logger.getLogger(TestController.class.getName()).
					log(Level.SEVERE, null, ex);
			}
		}
	}

	/**
	 * Stops all the TCP services.
	 */
	public boolean winningPlay(Cell cell) {
		if (isWinningPlay()) {
			String message = cell.getAddress().getColumn() + ";" + cell.
				getAddress().getRow() + ";" + cell.getContent();
			new TcpClient(0).send(":game-lost", connection, message);
			stopThis();
			diplayVictory();
			return true;
		}
		return false;
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
}
