/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.io;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Diog Leite
 */
public class PDFCodec {

	/**
	 * Creates a new PDF codec.
	 */
	public PDFCodec() {
	}

	/**
	 *
	 * Method used to write spreadsheet to the PDF file
	 *
	 * @param workbook
	 * @param file
	 * @throws IOException
	 */
	public void writeWorkbook(Workbook workbook, File file) throws IOException {
		Document document = new Document(PageSize.A4);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			for (int k = 0; k < workbook.getSpreadsheetCount(); k++) {
				Spreadsheet spreadsheet = workbook.getSpreadsheet(k);

				int row = spreadsheet.getRowCount();
				int columm = spreadsheet.getColumnCount();
				String value[][] = new String[row + 1][columm + 1];
				PdfPTable table = new PdfPTable(columm + 1);
				PdfPCell cell;

				Font f = new Font();
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < columm + 1; j++) {
						value[i][j] = spreadsheet.getCell(j, i).getValue().
							toString();

						cell = new PdfPCell(new Paragraph(value[i][j], f));

						table.addCell(cell);

					}
				}
				document.add(table);
				document.newPage();
			}
			document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

		System.out.println("Done!");
	}

	public void writeSpreadsheet(Spreadsheet spreadsheet, File file) throws IOException {
		Document document = new Document(PageSize.A4);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			int row = spreadsheet.getRowCount();
			int columm = spreadsheet.getColumnCount();
			String value[][] = new String[row + 1][columm + 1];
			PdfPTable table = new PdfPTable(columm + 1);
			PdfPCell cell;

			Font f = new Font();
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < columm + 1; j++) {
					value[i][j] = spreadsheet.getCell(j, i).getValue().
						toString();

					cell = new PdfPCell(new Paragraph(value[i][j], f));

					table.addCell(cell);

				}
			}
			document.add(table);

			document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

		System.out.println("Done!");
	}

	public void writeSelectedCells(Cell[][] cells, File file) throws IOException {
		Document document = new Document(PageSize.A4);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			String value[][] = new String[cells.length][cells[0].length];
			PdfPTable table = new PdfPTable(cells[0].length);
			PdfPCell cell;

			Font f = new Font();
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {

					value[i][j] = cells[i][j].
						getValue().toString();

					cell = new PdfPCell(new Paragraph(value[i][j], f));

					table.addCell(cell);

				}
			}
			document.add(table);

			document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

		System.out.println("Done!");
	}
}
