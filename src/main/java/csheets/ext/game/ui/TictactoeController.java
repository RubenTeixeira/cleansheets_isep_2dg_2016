/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

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

	/**
	 * The button for applying left alignment
	 */
	private Map<Integer, JToggleButton> hAlignButtons
		= new HashMap<Integer, JToggleButton>();

//	private int rows = 0;
//
//	private int columns = 0;
//
//	private Map<Address, Cell> cells = new HashMap<Address, Cell>();
//
//	private Cell[][] table;
	public TictactoeController(UIController uiController) throws FormulaCompilationException {
		this.uiController = uiController;
		newSpreadsheet();
	}

	public void newSpreadsheet() throws FormulaCompilationException {
		Workbook activeBook = this.uiController.getActiveWorkbook();
		activeBook.addTictactoeSpreadsheet();
		Spreadsheet sheet = activeBook.getSpreadsheet(activeBook.
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
//		sheet.getCell(0, 0).setContent("X");
//		sheet.getCell(0, 1).setContent("X");
//		sheet.getCell(0, 2).setContent("X");
//		sheet.getCell(0, 3).setContent("X");
//		sheet.getCell(0, 4).setContent("X");
//		sheet.getCell(1, 0).setContent("X");
//		sheet.getCell(2, 0).setContent("TICTACTOE");
//		sheet.getCell(0, 1).setContent("X");
//		sheet.getCell(0, 2).setContent("X");
//		sheet.getCell(0, 3).setContent("X");
//		sheet.getCell(0, 4).setContent("X");
//		sheet.getCell(1, 4).setContent("X");
//		sheet.getCell(2, 4).setContent("X");
//		sheet.getCell(3, 4).setContent("X");
//		sheet.getCell(4, 4).setContent("X");
//		sheet.getCell(4, 3).setContent("X");
//		sheet.getCell(4, 2).setContent("X");
//		sheet.getCell(4, 1).setContent("X");
//		sheet.getCell(4, 0).setContent("X");
//		sheet.getCell(3, 0).setContent("X");
//
	}
}
