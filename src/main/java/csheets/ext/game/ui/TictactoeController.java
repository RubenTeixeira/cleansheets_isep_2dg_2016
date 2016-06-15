/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Rafael
 */
public class TictactoeController {

	private UIController uiController;
	/**
	 * The base of the titles of new spreadsheets
	 */
	public static final String Name = "TicTacToe";

	public TictactoeController(UIController uiController) throws FormulaCompilationException {
		this.uiController = uiController;
		newSpreadsheet();
	}

	public void newSpreadsheet() {
		Workbook activeBook = this.uiController.getActiveWorkbook();
		activeBook.addTictactoeSpreadsheet();

		Spreadsheet sheet = activeBook.getSpreadsheet(activeBook.
			getSpreadsheetCount() - 1);
	}
}
