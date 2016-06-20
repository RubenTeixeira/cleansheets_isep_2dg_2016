package csheets.io;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
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
	 * Method used to write workbook into the PDF file
	 *
	 * @param workbook workbook
	 * @param file file
	 * @throws IOException
	 */
	public void writeWorkbook(Workbook workbook, File file) throws IOException {
		Document document = new Document(PageSize.A4);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();
			PdfPCell cell;

			//added title workbook to pdf file
			PdfPTable title = new PdfPTable(1);
			cell = new PdfPCell(new Paragraph("Workbook", FontFactory.
											  getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Rectangle.NO_BORDER);
			title.addCell(cell);
			document.add(title);

			for (int k = 0; k < workbook.getSpreadsheetCount(); k++) {
				PdfPTable subTitle = new PdfPTable(1);
				Spreadsheet spreadsheet = workbook.getSpreadsheet(k);

				int row = spreadsheet.getRowCount();
				int columm = spreadsheet.getColumnCount();
				String value[][] = new String[row + 1][columm + 1];
				PdfPTable table = new PdfPTable(columm + 1);

				//added subTitle Spreadsheet to pdf file
				cell = new PdfPCell(new Paragraph("Spreadsheet " + k + 1, FontFactory.
												  getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, BaseColor.BLACK)));
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setBorder(Rectangle.NO_BORDER);
				subTitle.addCell(cell);

				//added subTitle Cells to pdf file
				cell = new PdfPCell(new Paragraph("Cells", FontFactory.
												  getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, BaseColor.BLACK)));
				cell.setHorizontalAlignment(Element.ALIGN_LEFT);
				cell.setBorder(Rectangle.NO_BORDER);
				subTitle.addCell(cell);

				document.add(subTitle);
				//put information into table
				Font f = new Font();
				PdfPCell tableCell;
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < columm + 1; j++) {
						value[i][j] = spreadsheet.getCell(j, i).getValue().
							toString();

						tableCell = new PdfPCell(new Paragraph(value[i][j], f));

						table.addCell(tableCell);

					}
				}
				document.add(table);
				document.newPage();
			}
			document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

	}

	/**
	 * Method used to write Spreadsheet into the PDF file
	 *
	 * @param spreadsheet Spreadsheet
	 * @param file file
	 * @throws IOException
	 */
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

			//added title Spreadsheet to pdf file
			PdfPTable title = new PdfPTable(1);
			cell = new PdfPCell(new Paragraph("Spreadsheet", FontFactory.
											  getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Rectangle.NO_BORDER);
			title.addCell(cell);

			//added subTitle Cells to pdf file
			cell = new PdfPCell(new Paragraph("Cells", FontFactory.
											  getFont(FontFactory.TIMES_BOLD, 16, Font.BOLD, BaseColor.BLACK)));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(Rectangle.NO_BORDER);
			title.addCell(cell);

			document.add(title);

			//put information into table
			Font f = new Font();
			PdfPCell tableCell;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < columm + 1; j++) {
					value[i][j] = spreadsheet.getCell(j, i).getValue().
						toString();

					tableCell = new PdfPCell(new Paragraph(value[i][j], f));

					table.addCell(tableCell);

				}
			}
			document.add(table);

			document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

	}

	/**
	 * Method used to write a range of cells into the PDF file
	 *
	 * @param cells range of cells
	 * @param file File
	 * @throws IOException
	 */
	public void writeSelectedCells(Cell[][] cells, File file) throws IOException {
		Document document = new Document(PageSize.A4);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			String value[][] = new String[cells.length][cells[0].length];
			PdfPTable table = new PdfPTable(cells[0].length);
			PdfPCell cell;

			//added title Cells in pdf file
			PdfPTable title = new PdfPTable(1);
			cell = new PdfPCell(new Paragraph("Cells", FontFactory.
											  getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Rectangle.NO_BORDER);
			title.addCell(cell);

			document.add(title);

			//put information into table
			Font f = new Font();
			PdfPCell tableCell;
			for (int i = 0; i < cells.length; i++) {
				for (int j = 0; j < cells[0].length; j++) {

					value[i][j] = cells[i][j].
						getValue().toString();

					tableCell = new PdfPCell(new Paragraph(value[i][j], f));

					table.addCell(tableCell);

				}
			}
			document.add(table);

			document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

	}
}
