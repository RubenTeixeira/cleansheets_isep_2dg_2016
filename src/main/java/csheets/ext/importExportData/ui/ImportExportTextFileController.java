package csheets.ext.importExportData.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.importExportData.parsers.FileHandler;
import csheets.ext.importExportData.parsers.TxtParser;
import csheets.ext.importExportData.parsers.encoders.TxtEncoder;
import csheets.ext.importExportData.parsers.strategies.ImportTextFileStrategy;

public class ImportExportTextFileController {

	/**
	 *
	 * @param path
	 * @param separator
	 * @param cells
	 * @return
	 */
	public boolean hasEnoughCells(String path, String separator,
								  Cell[][] cells) {

		TxtParser txtParser = new TxtParser(new FileHandler());
		String[] lines = ((String[]) txtParser.use(new ImportTextFileStrategy()).
			with(path).
			parse());

		Cell[][] textCells = nTextCells(lines, separator);

		return textCells.length <= cells.length
			&& textCells[0].length <= cells[0].length;
	}

	/**
	 *
	 * @param path
	 * @param separator
	 * @param header
	 * @param cells
	 * @return
	 * @throws FormulaCompilationException
	 */
	public Cell[][] parse(String path, String separator, boolean header,
						  Cell[][] cells) throws FormulaCompilationException {
		if (cells == null) {
			return null;
		}

		TxtParser txtParser = new TxtParser(new FileHandler());
		String[] lines = ((String[]) txtParser.use(new ImportTextFileStrategy()).
			with(path).parse());
		if (lines == null) {
			return null;
		}
		Cell[][] textCells = nTextCells(lines, separator);

		if (header == true) {
			cells[0][0].setContent(lines[0]);
			textCells[0][0] = cells[0][0];
			int r = cells[0][0].getAddress().getRow();
			int c = cells[0][0].getAddress().getColumn();
			Cell cell = cells[0][0].getSpreadsheet().getCell(c, r + 1);
			for (int i = 1; i < lines.length; i++) {
				String[] col = lines[i].split(separator);
				for (int j = 0; j < col.length; j++) {
					cell.setContent(col[j]);
					textCells[i][j] = cell;
					int column = cell.getAddress().getColumn() + 1;
					int row = cell.getAddress().getRow();
					cell = cell.getSpreadsheet().getCell(column, row);
				}
				cell = cell.getSpreadsheet().getCell(c, cell.getAddress().
													 getRow() + 1);
			}
		} else {
			int r = cells[0][0].getAddress().getRow();
			int c = cells[0][0].getAddress().getColumn();
			Cell cell = cells[0][0].getSpreadsheet().getCell(c, r);
			for (int i = 0; i < lines.length; i++) {
				String[] col = lines[i].split(separator);
				for (int j = 0; j < col.length; j++) {
					cell.setContent(col[j]);
					textCells[i][j] = cell;
					int column = cell.getAddress().getColumn() + 1;
					int row = cell.getAddress().getRow();
					cell = cell.getSpreadsheet().getCell(column, row);
				}
				cell = cell.getSpreadsheet().getCell(c, cell.getAddress().
													 getRow() + 1);
			}
		}
		return textCells;
	}

	/**
	 *
	 * @param lines
	 * @param separator
	 * @return
	 */
	private Cell[][] nTextCells(String[] lines, String separator) {
		if (lines == null) {
			return null;
		}
		int maxColumns = 0;
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].split(separator).length > maxColumns) {
				maxColumns = lines[i].split(separator).length;
			}
		}
		return new Cell[lines.length][maxColumns];
	}

	/**
	 *
	 * @param filename
	 * @param cells
	 * @param separator
	 * @return
	 */
	public boolean exportFile(String filename, Cell[][] cells, String separator) {
		FileHandler fh = new FileHandler();

		String content = new TxtEncoder().getContent(cells, separator);

		if (fh.createFile(filename)) {
			return fh.append(filename, content);
		}
		return false;
	}

}
