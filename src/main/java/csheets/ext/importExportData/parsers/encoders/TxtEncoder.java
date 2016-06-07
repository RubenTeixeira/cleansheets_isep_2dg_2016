/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExportData.parsers.encoders;

import csheets.core.Cell;

/**
 *
 * @author Rui Bastos<1140491@isep.ipp.pt>
 */
public class TxtEncoder {

	String content = "";

	public String getContent(Cell[][] cells, String separator) {
		content = "";

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				content += cells[i][j].getContent() + separator + " ";
			}
			content += "\n";
		}

		return content;
	}
}
