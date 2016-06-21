package csheets.ui.legacy.exportPDF;

import com.itextpdf.text.Anchor;
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
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogo Leite
 */
public class ExportPDF {

	/**
	 * Creates a new PDF codec.
	 */
	public ExportPDF() {
	}

	/**
	 * This method writes into the document the list of sections if user select
	 * that option
	 *
	 * @param document Document
	 * @param writer writer
	 * @param showList boolean
	 * @return PdfPTable
	 */
	public PdfPTable showListSections(Document document, PdfWriter writer,
									  boolean showList) {
		PdfPTable listSections = new PdfPTable(1);
		//add list of sections
		if (showList) {
			PdfPTable titleSections = new PdfPTable(1);
			PdfPCell cellSections;
			cellSections = new PdfPCell(new Paragraph("List of Sections", FontFactory.
													  getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
			cellSections.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellSections.setBorder(Rectangle.NO_BORDER);
			titleSections.addCell(cellSections);
			try {
				document.add(titleSections);
			} catch (DocumentException ex) {
				Logger.getLogger(ExportPDF.class.getName()).
					log(Level.SEVERE, null, ex);
			}

			Workbook workbook = UIController.getUIController().
				getActiveWorkbook();
			for (int k = 0; k < workbook.getSpreadsheetCount(); k++) {

				Spreadsheet spreadsheet = workbook.getSpreadsheet(k);
				Paragraph linkToSection = new Paragraph();
				Anchor anchor = new Anchor("Spreadsheet title:" + spreadsheet.
					getTitle());

				anchor.setReference("#Spreadsheet title:" + spreadsheet.
					getTitle());
				linkToSection.add(anchor);
				listSections.addCell(linkToSection);
				listSections.setTotalWidth(700);
				listSections.writeSelectedRows(0, 0, 36, 36, writer.
											   getDirectContent());

			}

			return listSections;

		}
		return listSections;
	}

	/**
	 *
	 * Method used to write workbook into the PDF file
	 *
	 * @param workbook workbook
	 * @param file file
	 * @param showList boolean
	 * @throws IOException exception
	 */
	public void writeWorkbook(Workbook workbook, File file, boolean showList) throws IOException {
		Document document = new Document(PageSize.A1);

		try {

			PdfWriter writer = PdfWriter.
				getInstance(document, new FileOutputStream(file));
			document.open();
			PdfPTable listSections = showListSections(document, writer, showList);
			if (listSections.size() != 0) {
				document.add(listSections);
				document.newPage();
			}

			PdfPCell cell;

			//added title workbook to pdf file
			PdfPTable title = new PdfPTable(1);
			cell = new PdfPCell(new Paragraph("Workbook", FontFactory.
											  getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Rectangle.NO_BORDER);
			title.addCell(cell);
			title.setSpacingAfter(10);
			document.add(title);

			for (int k = 0; k < workbook.getSpreadsheetCount(); k++) {
				PdfPTable subTitle = new PdfPTable(1);
				Spreadsheet spreadsheet = workbook.getSpreadsheet(k);

				int row = spreadsheet.getRowCount();
				int columm = spreadsheet.getColumnCount();

				PdfPTable table = new PdfPTable(1);

				//added subTitle Spreadsheet to pdf file
				Anchor target = new Anchor("Spreadsheet title:" + spreadsheet.
					getTitle());

				target.setName("Spreadsheet title:" + spreadsheet.
					getTitle());

				document.add(target);

				//added subTitle Cells to pdf file
				cell = new PdfPCell(new Paragraph("Cells", FontFactory.
												  getFont(FontFactory.TIMES_BOLD, 14, Font.BOLD, BaseColor.BLACK)));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setBorder(Rectangle.NO_BORDER);

				subTitle.addCell(cell);
				subTitle.setSpacingAfter(100);
				document.add(subTitle);

				//put information into table
				Font f = new Font();
				PdfPCell tableCell;
				for (int i = 0; i < row + 1; i++) {
					for (int j = 0; j < columm + 1; j++) {

						if (!spreadsheet.getCell(j, i).getValue().
							toString().isEmpty()) {
							tableCell = new PdfPCell(new Paragraph(spreadsheet.
								getCell(j, i).getValue().
								toString(), f));

							table.addCell(tableCell);
						}

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
	 * @throws IOException exception
	 */
	public void writeSpreadsheet(Spreadsheet spreadsheet, File file) throws IOException {
		Document document = new Document(PageSize.A1);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			int row = spreadsheet.getRowCount();
			int columm = spreadsheet.getColumnCount();

			PdfPTable table = new PdfPTable(1);
			PdfPCell cell;

			//added title Spreadsheet to pdf file
			PdfPTable title = new PdfPTable(1);
			cell = new PdfPCell(new Paragraph("Spreadsheet title:" + spreadsheet.
				getTitle(), FontFactory.
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
			for (int i = 0; i < row + 1; i++) {
				for (int j = 0; j < columm + 1; j++) {

					if (!spreadsheet.getCell(j, i).getValue().
						toString().isEmpty()) {
						tableCell = new PdfPCell(new Paragraph(spreadsheet.
							getCell(j, i).getValue().
							toString(), f));

						table.addCell(tableCell);
					}
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
	 * @throws IOException exception
	 */
	public void writeSelectedCells(Cell[][] cells, File file) throws IOException {
		Document document = new Document(PageSize.A1);

		try {

			PdfWriter.getInstance(document, new FileOutputStream(file));
			document.open();

			PdfPTable table = new PdfPTable(1);
			PdfPCell cell;

			//added title Cells in pdf file
			PdfPTable title = new PdfPTable(1);
			cell = new PdfPCell(new Paragraph("Cells", FontFactory.
											  getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD, BaseColor.BLACK)));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(Rectangle.NO_BORDER);
			title.addCell(cell);

			document.add(title);
			int row = cells.length;
			int columm = cells[0].length;

			//put information into table
			Font f = new Font();
			PdfPCell tableCell;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < columm; j++) {

					if (!cells[i][j].
						getValue().toString().isEmpty()) {
						tableCell = new PdfPCell(new Paragraph(cells[i][j].
							getValue().toString(), f));

						table.addCell(tableCell);
					}
				}
			}
			document.add(table);

			document.close();
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

	}

}
