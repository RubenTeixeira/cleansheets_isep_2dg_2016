/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.search;

import csheets.core.Cell;
import csheets.core.Spreadsheet;

/**
 * This class serves as the assembler to Search Results
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class SearchResultAssembler {

	/**
	 * Returns the SearchResultDTO translation of the given Core objects
	 *
	 * @param spreadSheet the Spreadsheet
	 * @param cell the Cell
	 * @return the SearchResultDTO
	 */
	public static SearchResultDTO getResultInformation(Spreadsheet spreadSheet,
													   Cell cell) {
		String sheetName = spreadSheet.getTitle();
		String cellAddress = cell.getAddress().toString();
		String cellContent = cell.getContent();
		String cellValue = cell.getValue().toString();
		return new SearchResultDTO(sheetName, cellAddress, cellContent, cellValue);
	}

}
