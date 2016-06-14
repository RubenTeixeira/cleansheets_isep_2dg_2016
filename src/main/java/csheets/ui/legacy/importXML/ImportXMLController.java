/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.importXML;

import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author scarl
 */
public class ImportXMLController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * Creates a new import controller.
	 *
	 * @param uiController the user interface controller
	 */
	public ImportXMLController(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 *
	 * Method to create a file with format .xml, call method exportWorkbook to
	 * export a workbook and write to file
	 *
	 * @param path path of file
	 * @param tagWorkBook tagWorkBook
	 * @param tagSpreadSheet tagSpreadSheet
	 * @param tagRow tagRow
	 * @param tagColumn tagColumn
	 * @throws IOException exception
	 */
	public void importWorkbook(String path, String tagWorkBook,
							   String tagSpreadSheet,
							   String tagRow, String tagColumn) throws IOException {
		try {
			ImportXML.
				importWorkbook(path, tagWorkBook, tagSpreadSheet, tagRow, tagColumn, uiController.
							   getActiveWorkbook());
		} catch (FileNotFoundException | FormulaCompilationException ex) {
			Logger.getLogger(ImportXMLController.class.getName()).
				log(Level.SEVERE, null, ex);
		}

	}

	/**
	 *
	 * Method to create a file with format .xml, call method exportSpreadSheet
	 * to export a spreadsheet and write to file
	 *
	 * @param path path of file
	 * @param tagSpreadSheet tagSpreadSheet
	 * @param tagRow tagRow
	 * @param tagColumn tagColumn
	 * @param spreadsheet tagSpreadSheet
	 * @throws IOException exception
	 */
	public void importSpreadSheet(String path,
								  String tagSpreadSheet,
								  String tagRow, String tagColumn,
								  Spreadsheet spreadsheet) throws IOException {
		try {
			ImportXML.
				importSpreadsheet(path, tagSpreadSheet, tagRow, tagColumn, spreadsheet);
		} catch (FileNotFoundException | FormulaCompilationException ex) {
			Logger.getLogger(ImportXMLController.class.getName()).
				log(Level.SEVERE, null, ex);
		}

	}

	/**
	 *
	 * Method to create a file with format .xml, call method
	 * exportSpreadSheetSelected to export a spreadsheetSelected and write to
	 * file
	 *
	 * @param path path of file
	 * @param tagSpreadSheet tagSpreadSheet
	 * @param tagRow row
	 * @param tagColumn column
	 * @throws IOException exception
	 */
	public void importSpreadSheetSelected(String path,
										  String tagSpreadSheet,
										  String tagRow, String tagColumn) throws IOException {
		ImportXML.
			importSpreadsheetSelected(path, tagSpreadSheet, tagRow, tagColumn, uiController);
	}
}
