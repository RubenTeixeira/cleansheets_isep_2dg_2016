package csheets.ui.legacy.exportXML;

import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author ruben
 */
public class ExportXMLController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 */
	public ExportXMLController(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 *
	 * Method to create a file with format .xml, call method exportWorkbook to
	 * export a workbook and write to file
	 *
	 * @param fileChooser fileChooser
	 * @param tagWorkBook tagWorkBook
	 * @param tagSpreadSheet tagSpreadSheet
	 * @param tagRow tagRow
	 * @param tagColumn tagColumn
	 * @throws IOException exception
	 */
	public void exportWorkbook(JFileChooser fileChooser, String tagWorkBook,
							   String tagSpreadSheet,
							   String tagRow, String tagColumn) throws IOException {
		FileWriter file = new FileWriter(fileChooser.getSelectedFile() + ".xml");
		String result = ExportXML.
			exportWorkbook(tagWorkBook, tagSpreadSheet, tagRow, tagColumn, uiController.
						   getActiveWorkbook());
		file.write(result);
		file.close();
	}

	/**
	 *
	 * Method to create a file with format .xml, call method exportSpreadSheet
	 * to export a spreadsheet and write to file
	 *
	 * @param fileChooser fileChooser
	 * @param tagSpreadSheet tagSpreadSheet
	 * @param tagRow tagRow
	 * @param tagColumn tagColumn
	 * @param spreadsheet tagSpreadSheet
	 * @throws IOException exception
	 */
	public void exportSpreadSheet(JFileChooser fileChooser,
								  String tagSpreadSheet,
								  String tagRow, String tagColumn,
								  Spreadsheet spreadsheet) throws IOException {
		FileWriter file = new FileWriter(fileChooser.getSelectedFile() + ".xml");
		String result = ExportXML.
			exportSpreadsheet(tagSpreadSheet, tagRow, tagColumn, spreadsheet);
		file.write(result);
		file.close();
	}

	/**
	 *
	 * Method to create a file with format .xml, call method
	 * exportSpreadSheetSelected to export a spreadsheetSelected and write to
	 * file
	 *
	 * @param fileChooser fileChooser
	 * @param tagSpreadSheet tagSpreadSheet
	 * @param tagRow row
	 * @param tagColumn column
	 * @throws IOException exception
	 */
	public void exportSpreadSheetSelected(JFileChooser fileChooser,
										  String tagSpreadSheet,
										  String tagRow, String tagColumn) throws IOException {
		FileWriter file = new FileWriter(fileChooser.getSelectedFile() + ".xml");
		String result = ExportXML.
			exportSpreadsheetSelected(tagSpreadSheet, tagRow, tagColumn, uiController);
		file.write(result);
		file.close();
	}
}
