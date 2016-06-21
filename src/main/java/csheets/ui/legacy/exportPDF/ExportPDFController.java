/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.exportPDF;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.io.PDFCodec;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author Diogo Leite
 */
public class ExportPDFController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * Creates a new ExportPDFController controller.
	 *
	 * @param uiController the user interface controller
	 */
	public ExportPDFController(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 *
	 * Method to create a file with format .pdf, call method writeWorkbook to
	 * export a workbook and write to file
	 *
	 * @param fileChooser fileChooser
	 * @param showList true if user wants to see list of sections,otherwise
	 * false
	 * @throws IOException exception
	 */
	public void exportWorkbook(JFileChooser fileChooser, boolean showList) throws IOException {

		File file = fileChooser.getSelectedFile();

		file = new File(file.toString() + ".pdf");  // append .pdf

		Workbook workbook = uiController.getActiveWorkbook();
		PDFCodec pdf = new PDFCodec();
		try {
			pdf.writeWorkbook(workbook, file, showList);
		} catch (IOException ex) {
			//do nothing
		}

	}

	/**
	 *
	 * Method to create a file with format .pdf, call method writeSpreadsheet to
	 * export a spreadsheet and write to file
	 *
	 * @param fileChooser fileChooser
	 * @param spreadSheet spreadSheet
	 * @throws IOException exception
	 */
	public void exportSpreadSheet(JFileChooser fileChooser,
								  Spreadsheet spreadSheet) throws IOException {
		File file = fileChooser.getSelectedFile();
		file = new File(file.toString() + ".pdf");  // append .pdf

		PDFCodec pdf = new PDFCodec();
		try {
			pdf.writeSpreadsheet(spreadSheet, file);
		} catch (IOException ex) {
			//do nothing
		}
	}

	/**
	 *
	 * Method to create a file with format .pdf, call method writeSelectedCells
	 * to export a range of cells and write to file
	 *
	 * @param fileChooser fileChooser
	 * @param uiController uiController
	 * @throws IOException exception
	 */
	public void exportSelectedCells(JFileChooser fileChooser,
									UIController uiController
	) throws IOException {
		File file = fileChooser.getSelectedFile();
		file = new File(file.toString() + ".pdf");  // append .pdf
		PDFCodec pdf = new PDFCodec();
		try {
			pdf.
				writeSelectedCells(uiController.focusOwner.getSelectedCells(), file);
		} catch (IOException ex) {
			//do nothing
		}
	}

}
