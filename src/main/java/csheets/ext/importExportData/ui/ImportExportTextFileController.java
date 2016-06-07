package csheets.ext.importExportData.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.importExportData.parsers.FileHandler;
import csheets.ext.importExportData.parsers.TxtParser;
import csheets.ext.importExportData.parsers.encoders.TxtEncoder;
import csheets.ext.importExportData.parsers.strategies.ImportTextFileStrategy;
import csheets.ui.ctrl.UIController;
import java.util.Map;

public class ImportExportTextFileController {

	public boolean hasEnoughCells(String path, String separator,
								  Cell[][] cells) {

		TxtParser txtParser = new TxtParser(new FileHandler());
		String[] lines = ((String[]) txtParser.use(new ImportTextFileStrategy()).
			with(path).
			parse());

		Cell[][] textCells = nTextCells(lines, separator);

		return textCells.length == cells.length
			&& textCells[0].length == cells[0].length;
	}

	/**
	 *
	 * @param path path of the file
	 * @return
	 */
	public Cell[][] parse(String path, String separator, boolean header,
						  Cell[][] cells) throws FormulaCompilationException {

		TxtParser txtParser = new TxtParser(new FileHandler());
		String[] lines = ((String[]) txtParser.use(new ImportTextFileStrategy()).
			with(path).parse());
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
			for (int i = 0; 0 < lines.length; i++) {
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

	private Cell[][] nTextCells(String[] lines, String separator) {
		int maxColumns = 0;
		for (int i = 0; i < lines.length; i++) {
			if (lines[i].split(separator).length > maxColumns) {
				maxColumns = lines[i].split(separator).length;
			}
		}
		return new Cell[lines.length][maxColumns];
	}

	public boolean exportFile(String filename, Cell[][] cells, String separator) {
		FileHandler fh = new FileHandler();

		String content = new TxtEncoder().getContent(cells, separator);

		if (fh.createFile(filename)) {
			return fh.append(filename, content);
		}
		return false;
	}

	/**
	 * Updates the active spreadsheet with the received cells.
	 *
	 * @param ui The user interface controller.
	 * @param cells Received cells information.
	 * @throws csheets.core.formula.compiler.FormulaCompilationException Cells
	 * can have the wrong value.
	 */
	public void updateCells(UIController ui, Map<String, String> cells,
							Cell selectedCell) throws FormulaCompilationException {

		int selectedColumn = selectedCell.getAddress().getColumn();
		int selectedRow = selectedCell.getAddress().getRow();

		int iteration = 0;
		int originColumn = 0;
		int originRow = 0;

		for (Map.Entry<String, String> entry : cells.entrySet()) {
			if (iteration == 0) {
				String[] addressData = entry.getKey().split(":");
				originColumn = Integer.parseInt(addressData[0]);
				originRow = Integer.parseInt(addressData[1]);
			}
			String[] addressData = entry.getKey().split(":");
			int column = Integer.parseInt(addressData[0]) - originColumn + selectedColumn;
			int row = Integer.parseInt(addressData[1]) - originRow + selectedRow;

			try {
				String value = "";
				String[] valueData = entry.getValue().split(";");

				if (valueData.length > 1) {
					value = valueData[1];
				} else {
					value = "";
				}

				ui.getActiveSpreadsheet().getCell(column, row).setContent(value);
			} catch (FormulaCompilationException ex) {
				throw new FormulaCompilationException();
			}
		}
	}
}
