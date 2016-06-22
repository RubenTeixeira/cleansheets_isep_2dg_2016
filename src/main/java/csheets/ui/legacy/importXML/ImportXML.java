/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.importXML;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.comments.Comment;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentsExtension;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
									  String tagValue, String tagFont,
									  String tagBackground,
									  String tagBorder, String tagForeground,
									  String tagHorizontal,
									  String tagVertical, String tagComment,
									  String tagAuthor,
									  String tagScripts,
									  String tagScript,
									  String tagName,
									  String tagType,
									  String tagContent,
									  String tagSync,
									  Workbook workbook) throws FileNotFoundException, FormulaCompilationException, IOException {

		String data = getFileData(path);
		if (data.contains(tagWorkbook)) {
			String[] workbooks = data.split("<" + tagWorkbook + ">");
			for (int i = 1; i < workbooks.length; i++) {
				String workbook1 = workbooks[i];
				String[] spreadsheets = workbook1.
					split("<" + tagSpreadSheet + "");
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
							String value = column.
								split("<" + tagValue + ">|</" + tagValue + ">")[1];
							String font = column.
								split("<" + tagFont + ">|</" + tagFont + ">")[1];
							String name = font.split("name=")[1].split(",")[0];
							String style = font.split("style=")[1].split(",")[0];
							String size = font.split("size=")[1].split("]")[0];
							Font fonts = new Font(name, 1, Integer.
												  parseInt(size.trim()));
							String[] auxColumIndex = column.split("\"");
							int columnIndex = Integer.parseInt(auxColumIndex[1]);
							uiSpreadsheet.
								getCell(columnIndex, rowIndex).setContent(value);
							((StylableCell) uiSpreadsheet.
								getCell(columnIndex, rowIndex).
								getExtension(StyleExtension.NAME)).
								setFont(fonts);

							String background = column.
								split("<" + tagBackground + ">|</" + tagBackground + ">")[1];
							String border = column.
								split("<" + tagBorder + ">|</" + tagBorder + ">")[1];
							String foreground = column.
								split("<" + tagForeground + ">|</" + tagForeground + ">")[1];
							String horizontal = column.
								split("<" + tagHorizontal + ">|</" + tagHorizontal + ">")[1];
							String vertical = column.
								split("<" + tagVertical + ">|</" + tagVertical + ">")[1];

							((StylableCell) uiSpreadsheet.
								getCell(columnIndex, rowIndex).
								getExtension(StyleExtension.NAME)).
								setBackgroundColor(new Color(Integer.
									parseInt(background)));

							((StylableCell) uiSpreadsheet.
								getCell(columnIndex, rowIndex).
								getExtension(StyleExtension.NAME)).
								setForegroundColor(new Color(Integer.
									parseInt(foreground)));

							((StylableCell) uiSpreadsheet.
								getCell(columnIndex, rowIndex).
								getExtension(StyleExtension.NAME)).
								setHorizontalAlignment(Integer.
									parseInt(horizontal));

							((StylableCell) uiSpreadsheet.
								getCell(columnIndex, rowIndex).
								getExtension(StyleExtension.NAME)).
								setVerticalAlignment(Integer.
									parseInt(vertical));

							//<--Comments-->
							String[] comments = column.
								split("<" + tagComment + ">|</" + tagComment + ">");

							CommentableCell cell = (CommentableCell) uiSpreadsheet.
								getCell(columnIndex, rowIndex).getExtension(
								CommentsExtension.NAME);
//							for (int m = 1; m < comments.length; m++) {
							for (Comment c : cell.getCommentsList()) {

								String comment = comments[1];

								String author = comment.
									split("<" + tagAuthor + ">|</" + tagAuthor + ">")[1];
								String commentValue = comment.
									split("<" + tagValue + ">|</" + tagValue + ">")[1];

								String commentfont = comment.
									split("<" + tagFont + ">|</" + tagFont + ">")[1];
								String cName = font.split("name=")[1].split(",")[0];
								String cStyle = font.split("style=")[1].
									split(",")[0];
								String cSize = font.split("size=")[1].split("]")[0];

								Font CFonts = new Font(cName, 1, Integer.
													   parseInt(cSize.trim()));

								String commentBackground = comment.
									split("<" + tagBackground + ">|</" + tagBackground + ">")[1];
								//commantableCell para ir buscar comment

//								((Comment) uiSpreadsheet.
//									getCell(columnIndex, rowIndex).
//									getExtension(CommentsExtension.NAME)).
//									setUsername(author);
								c.setUsername(author);

//								((Comment) uiSpreadsheet.
//									getCell(columnIndex, rowIndex).
//									getExtension(CommentsExtension.NAME)).
//									setText(commentValue);
								c.setText(commentValue);
//								((Comment) uiSpreadsheet.
//									getCell(columnIndex, rowIndex).
//									getExtension(CommentsExtension.NAME)).
//									setFont(CFonts);
								c.setFont(CFonts);

								c.setBackgroundColor(new Color(Integer.
									parseInt(commentBackground)));

//								((Comment) uiSpreadsheet.
//									getCell(columnIndex, rowIndex).
//									getExtension(StyleExtension.NAME)).
//									setBackgroundColor(new Color(Integer.
//										parseInt(commentBackground)));
								//<--Comment-->
							}

						}
					}
				}

//				String[] scripts = workbook1.split("<" + tagScripts + ">");
//				for (int o = 1; o < scripts.length(); o++) {
//					String scripts1 = scripts[o];
//					String[] script = scripts1.
//						split("<" + tagScript + "");
//
//					for (int p = 1; p < script.length; p++) {
//
//						String column = columns[l];
//						String[] value = column.split(">|<");
//
//					}
//
//				}
			}

		} else {
			throw new IOException("Ficheiro XML Woorkbook Invalido");
		}
	}

	static public void importSpreadsheet(String path, String tagSpreadSheet,
										 String tagRow,
										 String tagColumn, String tagValue,
										 String tagFont,
										 String tagBackground,
										 String tagBorder, String tagForeground,
										 String tagHorizontal,
										 String tagVertical, String tagComment,
										 String tagAuthor,
										 Spreadsheet spreadsheet) throws FileNotFoundException, FormulaCompilationException, IOException {
		String data = getFileData(path);
		if (data.contains(tagSpreadSheet)) {
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
		} else {
			throw new IOException("Ficheiro XML SpreadSheet Invalido");
		}
	}

	static public void importSpreadsheetSelected(String path,
												 String tagSpreadSheet,
												 String tagRow,
												 String tagColumn,
												 UIController uiController) throws FileNotFoundException, FormulaCompilationException {

		String data = getFileData(path);
		Cell[][] cells = uiController.focusOwner.getSelectedCells();
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				Cell cell = cells[i][j];
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
						if (cell.getAddress().getColumn() == columnIndex && cell.
							getAddress().getRow() == rowIndex) {
							cell.setContent(value[1]);
						}
					}
				}
			}
		}
	}
}
