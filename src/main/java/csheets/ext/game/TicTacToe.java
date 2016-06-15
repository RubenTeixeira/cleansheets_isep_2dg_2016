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

	Cell[][] board;

	/**
	 * The workbook to which the spreadsheet belongs
	 */
	public TicTacToe() {
		this.board = board;
	}

	public boolean validateRules(String move, Cell cell, String symbol) throws FormulaCompilationException {
		int beginColumn = board[0][0].getAddress().getColumn();
		int beginRow = board[0][0].getAddress().getRow();
		int endColumn = board[board.length - 1][board[0].length - 1].
			getAddress().getColumn();
		int endRow = board[board.length - 1][board[0].length - 1].getAddress().
			getRow();
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

	public boolean validateWin(String symbol, Cell[][] table) {
		if (table[0][0].getContent().equalsIgnoreCase(symbol)
			&& table[1][0].getContent().equalsIgnoreCase(symbol)
			&& table[2][0].getContent().equalsIgnoreCase(symbol)) {
			return true;
		} else if (table[0][1].getContent().equalsIgnoreCase(symbol)
			&& table[1][1].getContent().equalsIgnoreCase(symbol)
			&& table[2][1].getContent().equalsIgnoreCase(symbol)) {
			return true;
		} else if (table[0][2].getContent().equalsIgnoreCase(symbol)
			&& table[1][2].getContent().equalsIgnoreCase(symbol)
			&& table[2][2].getContent().equalsIgnoreCase(symbol)) {
			return true;
		} else if (table[0][0].getContent().equalsIgnoreCase(symbol)
			&& table[0][1].getContent().equalsIgnoreCase(symbol)
			&& table[0][2].getContent().equalsIgnoreCase(symbol)) {
			return true;
		} else if (table[1][0].getContent().equalsIgnoreCase(symbol)
			&& table[1][1].getContent().equalsIgnoreCase(symbol)
			&& table[1][2].getContent().equalsIgnoreCase(symbol)) {
			return true;
		} else if (table[2][0].getContent().equalsIgnoreCase(symbol)
			&& table[2][1].getContent().equalsIgnoreCase(symbol)
			&& table[2][2].getContent().equalsIgnoreCase(symbol)) {
			return true;
		} else if (table[0][0].getContent().equalsIgnoreCase(symbol)
			&& table[1][1].getContent().equalsIgnoreCase(symbol)
			&& table[2][2].getContent().equalsIgnoreCase(symbol)) {
			return true;
		} else if (table[0][2].getContent().equalsIgnoreCase(symbol)
			&& table[1][1].getContent().equalsIgnoreCase(symbol)
			&& table[2][0].getContent().equalsIgnoreCase(symbol)) {
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
		return board[i][j].getContent();
	}
}
