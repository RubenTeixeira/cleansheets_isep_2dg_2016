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
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 */
	public ExportPDFController(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 *
	 * Method to create a file with format .xml, call method exportWorkbook to
	 * export a workbook and write to file
	 *
	 * @param fileChooser fileChooser
	 * @throws IOException exception
	 */
	public void exportWorkbook(JFileChooser fileChooser) throws IOException {
		//fileChooser = new JFileChooser(fileChooser, uiController.
		//getUserProperties());

		File file = fileChooser.getSelectedFile();

		Workbook workbook = uiController.getActiveWorkbook();
		PDFCodec pdf = new PDFCodec();
		try {
			pdf.writeWorkbook(workbook, file);
		} catch (IOException ex) {
			//todo
		}

	}

	/**
	 *
	 * Method to create a file with format .xml, call method exportSpreadSheet
	 * to export a spreadsheet and write to file
	 *
	 * @param fileChooser fileChooser
	 * @param spreadSheet spreadSheet
	 * @throws IOException exception
	 */
	public void exportSpreadSheet(JFileChooser fileChooser,
								  Spreadsheet spreadSheet) throws IOException {
		File file = fileChooser.getSelectedFile();

		PDFCodec pdf = new PDFCodec();
		try {
			pdf.writeSpreadsheet(spreadSheet, file);
		} catch (IOException ex) {
			//todo
		}
	}

	/**
	 *
	 * Method to create a file with format .xml, call method
 exportSelectedCells to export a spreadsheetSelected and write to
 file
	 *
	 * @param fileChooser fileChooser
	 * @param uiController uiController
	 * @throws IOException exception
	 */
	public void exportSelectedCells(JFileChooser fileChooser,
										  UIController uiController
	) throws IOException {
		File file = fileChooser.getSelectedFile();

		PDFCodec pdf = new PDFCodec();
		try {
			pdf.
				writeSelectedCells(uiController.focusOwner.getSelectedCells(), file);
		} catch (IOException ex) {
			//todo
		}
	}

}
