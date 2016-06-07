/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExportData.parsers.strategies;

import csheets.core.Cell;
import csheets.ext.importExportData.parsers.ParserStrategy;

/**
 *
 * @author Rui Bastos<1140491@isep.ipp.pt>
 */
public class ExportTextFileStrategy implements ParserStrategy {

	private Cell[][] cells;
	private String separator;

	public ExportTextFileStrategy(Cell[][] cells, String separator) {
		this.cells = cells;
		this.separator = separator;
	}

	@Override
	public Object execute(String filepath) {
		String content = "";

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				content += cells[i][j].getContent() + this.separator + " ";
			}
			content += "\n";
		}

		return content;
	}

}
