/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;

/**
 * Dummy Class
 *
 * @author João Martins
 */
public class TicTacToe {

	int ROW = 3;
	int COLUMN = 3;

	private String[][] board;

	/**
	 * The workbook to which the spreadsheet belongs
	 */
	public TicTacToe() {
		this.board = board;
	}

	public boolean validateRules(String move, Cell cell,
								 String symbol) throws FormulaCompilationException {
		int beginColumn = board.length;//.getAddress().getColumn();
		int beginRow = board[1].length;//.getAddress().getRow();
		int endColumn = board[board.length - 1][board[0].length - 1].length();//getAddress().getColumn();
		int endRow = board[board.length - 1][board[0].length - 1].length();//getAddress().getRow();
		int columnContent = cell.getAddress().getColumn();
		int rowContent = cell.getAddress().getRow();
		if (beginColumn <= columnContent && columnContent <= endColumn && beginRow <= rowContent && rowContent <= endRow) {
			if (cell.getContent().isEmpty()) {
				if (move.equalsIgnoreCase(symbol)) {
					cell.setContent(move);
					return true;
				}
			}
		}
		return false;
	}

	public boolean validateWin(String symbol) {

//		int column = 4;
//		int rows = 4;
//		for (int col = 0; col < column; col++) {
//			for (int row = 0; row < rows; row++) {
//				if(board[col][row].getContent().equalsIgnoreCase(symbol)) {
//					return true;
//				}
//			}
//				if (!(col >= 1 && col <= 3 && row >= 1 && row <= 3)) {
//
//
//				}
//			}
		if (board[0][0].equalsIgnoreCase(symbol)
			&& board[1][0].equalsIgnoreCase(symbol)
			&& board[2][0].equalsIgnoreCase(symbol)) {
			return true;
		} else if (board[0][1].equalsIgnoreCase(symbol)
			&& board[1][1].equalsIgnoreCase(symbol)
			&& board[2][1].equalsIgnoreCase(symbol)) {
			return true;
		} else if (board[0][2].equalsIgnoreCase(symbol)
			&& board[1][2].equalsIgnoreCase(symbol)
			&& board[2][2].equalsIgnoreCase(symbol)) {
			return true;
		} else if (board[0][0].equalsIgnoreCase(symbol)
			&& board[0][1].equalsIgnoreCase(symbol)
			&& board[0][2].equalsIgnoreCase(symbol)) {
			return true;
		} else if (board[1][0].equalsIgnoreCase(symbol)
			&& board[1][1].equalsIgnoreCase(symbol)
			&& board[1][2].equalsIgnoreCase(symbol)) {
			return true;
		} else if (board[2][0].equalsIgnoreCase(symbol)
			&& board[2][1].equalsIgnoreCase(symbol)
			&& board[2][2].equalsIgnoreCase(symbol)) {
			return true;
		} else if (board[0][0].equalsIgnoreCase(symbol)
			&& board[1][1].equalsIgnoreCase(symbol)
			&& board[2][2].equalsIgnoreCase(symbol)) {
			return true;
		} else if (board[0][2].equalsIgnoreCase(symbol)
			&& board[1][1].equalsIgnoreCase(symbol)
			&& board[2][0].equalsIgnoreCase(symbol)) {
			return true;
		}
		return false;
	}

	public int getColumnCount() {
		return COLUMN;
	}

	public int getRowCount() {
		return ROW;
	}

	public String getValueAt(int i, int j) {
		return board[i][j];
	}
}
