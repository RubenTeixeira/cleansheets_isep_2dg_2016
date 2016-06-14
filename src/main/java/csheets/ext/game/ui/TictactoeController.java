/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Rafael
 */
public class TictactoeController {

	private UIController uiController;
	private static final String NAME = "TicTacToe";

	public TictactoeController(UIController uiController) {
		this.uiController = uiController;
		newSpreadsheet();
	}

	public void newSpreadsheet() {
		Workbook activeBook = this.uiController.getActiveWorkbook();
		activeBook.addSpreadsheet();

		Spreadsheet sheet = activeBook.getSpreadsheet(activeBook.
			getSpreadsheetCount() - 1);
		System.out.println(sheet.getTitle());
		sheet.setTitle(NAME);
		System.out.println(sheet.getTitle());

	}

//	public void newTictactoeSpreadsheetExtension() {
//		TictactoeSpreadsheetExtension sheetExt = new TictactoeSpreadsheetExtension();
//
//	}
}
