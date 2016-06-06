package csheets.ui.legacy.exportXML;

import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
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

	public void exportWorkbook(JFileChooser file, String tagWorkBook,
							   String tagSpreadSheet,
							   String tagRow, String tagColumn) {
		ExportXML.
			exportWorkbook(file, tagWorkBook, tagSpreadSheet, tagRow, tagColumn, uiController.
						   getActiveWorkbook());
	}

	public void exportSpreadSheet(JFileChooser file, String tagSpreadSheet,
								  String tagRow, String tagColumn,
								  Spreadsheet spreadsheet) {
		ExportXML.
			exportSpreadsheet(file, tagSpreadSheet, tagRow, tagColumn, spreadsheet);
	}

	public void exportSpreadSheetSelected(JFileChooser file,
										  String tagSpreadSheet,
										  String tagRow, String tagColumn) {
		ExportXML.
			exportSpreadsheetSelected(file, tagSpreadSheet, tagRow, tagColumn, uiController);
	}
}
