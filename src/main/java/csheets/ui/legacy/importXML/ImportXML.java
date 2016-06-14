/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.importXML;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author scarl
 */
public class ImportXML {

	public ImportXML() {

	}

	public static String getFileData(String path) throws FileNotFoundException {
		Scanner in = new Scanner(new File(path));
		String aux = "";
		while (in.hasNextLine()) {
			aux += in.nextLine();
		}
		String newAux = aux.replaceAll("\t", "");
		return newAux;
	}

	static public void importWorkbook(String path, String tagWorkbook,
									  String tagSpreadSheet,
									  String tagRow, String tagColumn,
									  Workbook workbook) throws FileNotFoundException, FormulaCompilationException {

		String data = getFileData(path);

		String[] workbooks = data.split("<" + tagWorkbook + ">");
		for (int i = 1; i < workbooks.length; i++) {
			String workbook1 = workbooks[i];
			String[] spreadsheets = workbook1.split("<" + tagSpreadSheet + "");
			for (int j = 1; j < spreadsheets.length; j++) {
				//ui controller get spread sheetatual
				String spreadsheet = spreadsheets[j];
				Spreadsheet uiSpreadsheet = workbook.getSpreadsheet(j - 1);
				String[] rows = spreadsheet.split("<" + tagRow + "");
				for (int k = 1; k < rows.length; k++) {
					String row = rows[k];
					String[] auxRowIndex = row.split("\"");
					int rowIndex = Integer.parseInt(auxRowIndex[1]);
					String[] columns = row.split("<" + tagColumn + "");
					for (int l = 1; l < columns.length; l++) {
						String column = columns[l];
						String[] value = column.split(">|<");
						String[] auxColumIndex = column.split("\"");
						int columnIndex = Integer.parseInt(auxColumIndex[1]);
						uiSpreadsheet.getCell(columnIndex, rowIndex).
							setContent(value[1]);
					}
				}
			}
		}

	}

	static public void importSpreadsheet(String path, String tagSpreadSheet,
										 String tagRow,
										 String tagColumn,
										 Spreadsheet spreadsheet) throws FileNotFoundException, FormulaCompilationException {
		String data = getFileData(path);

		String[] rows = data.split("<" + tagRow + "");
		for (int k = 1; k < rows.length; k++) {
			String row = rows[k];
			String[] auxRowIndex = row.split("\"");
			int rowIndex = Integer.parseInt(auxRowIndex[1]);
			String[] columns = row.split("<" + tagColumn + "");
			for (int l = 1; l < columns.length; l++) {
				String column = columns[l];
				String[] value = column.split(">|<");
				String[] auxColumIndex = column.split("\"");
				int columnIndex = Integer.parseInt(auxColumIndex[1]);
				spreadsheet.getCell(columnIndex, rowIndex).
					setContent(value[1]);
			}
		}
	}

	static public void importSpreadsheetSelected(String path,
												 String tagSpreadSheet,
												 String tagRow,
												 String tagColumn,
												 UIController uiController) {

	}
}
