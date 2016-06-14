/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.advancedWorkbookSearch.ui;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;

/**
 * A Preview of one specific Workbook. A Preview has a direct connection to one
 * Workbook and only one. It contains a matrix of cells where the position (0,0)
 * of the preview will be the first content cell of the giving workbook. The
 * size of the preview will be 5*5.
 *
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class WorkbookPreview {

	/**
	 * Preview Columns.
	 */
	private static final int COLUMNS = 5;

	/**
	 * Preview Rows.
	 */
	private static final int ROWS = 5;

	/**
	 * Workbook.
	 */
	private final Workbook workbook;

	/**
	 * First cell with content.
	 */
	private Cell cell;

	/**
	 * First Spreadsheet with content.
	 */
	private Spreadsheet spreadsheet;

	/**
	 * Preview Matrix.
	 */
	private Cell[][] matrix = new Cell[COLUMNS][ROWS];

	/**
	 * Creates an Workbook Preview.
	 *
	 * @param workbook workbook
	 */
	public WorkbookPreview(Workbook workbook) {
		this.workbook = workbook;
		preview();
		setUpPreview();
	}

	/**
	 * Search for Content.
	 */
	private void preview() {
		outerloop:
		for (int i = 0; i < this.workbook.getSpreadsheetCount(); i++) {
			Spreadsheet ss = this.workbook.getSpreadsheet(i);
			for (Cell c : ss) {
				if (!c.getContent().equalsIgnoreCase("")) {
					spreadsheet = ss;
					this.cell = c;
					break outerloop;
				}
			}
		}
		if (this.cell == null) {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Builds the matrix.
	 */
	private void setUpPreview() {
		int[] column = new int[COLUMNS];
		int[] row = new int[ROWS];

		for (int i = 0; i < COLUMNS; i++) {
			column[i] = cell.getAddress().getColumn() + i;
		}
		for (int j = 0; j < ROWS; j++) {
			row[j] = cell.getAddress().getRow() + j;
		}
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				matrix[i][j] = this.spreadsheet.getCell(column[i], row[j]);
			}
		}
	}

	/**
	 *
	 * @return Workbook Preview Matrix.
	 */
	public Cell[][] getPreview() {
		return this.matrix;
	}

	public static int getColumnPreviewSize() {
		return COLUMNS;
	}

	public static int getRowsPreviewSize() {
		return ROWS;
	}

}
