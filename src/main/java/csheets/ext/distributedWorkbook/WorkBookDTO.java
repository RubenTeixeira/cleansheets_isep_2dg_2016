/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.distributedWorkbook;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class WorkBookDTO implements Serializable {

	/**
	 * The title
	 */
	public String name;

	/**
	 * The Spreadsheet titles
	 */
	public List<String> spreadsheets;

	/**
	 * The cells
	 */
	public List<String[][]> cells;

	public WorkBookDTO(String name, List<String> spreadsheets,
					   List<String[][]> cells) {
		this.name = name;
		this.spreadsheets = spreadsheets;
		this.cells = cells;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(this.name);
		builder.append("\n");
		int SpreadSheetIndex = 0;
		for (String spreadsheet : spreadsheets) {
			builder.append(spreadsheet).append("\n");
			String[][] matrix = cells.get(SpreadSheetIndex);
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					builder.append(matrix[i][j]).append(",");
				}
				builder.append("\n");
			}
			SpreadSheetIndex++;
		}
		return builder.toString();
	}

}
