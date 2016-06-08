/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.search;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * This class is responsible for the search behaviour of the application.
 * Further, more advanced search techniques should be implemented/added here.
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class WorkBookSearch {

	/**
	 * The Workbook in which the search shall be performed
	 */
	private final Workbook workBook;

	/**
	 * The constructor
	 *
	 * @param workBook the workbook
	 */
	public WorkBookSearch(Workbook workBook) {
		this.workBook = workBook;
	}

	/**
	 * Returns the list of results matching then given pattern NB: Calls private
	 * method
	 *
	 * @param pattern regex pattern
	 * @return list of matching results
	 */
	public List<SearchResultDTO> getMatches(String pattern) throws PatternSyntaxException {

		// This is a stub, will be needed later and serves as test
		// for the pattern syntax
		Pattern regex = Pattern.compile(pattern);

		List<SearchResultDTO> results = new ArrayList<>();

		for (int i = 0; i < this.workBook.getSpreadsheetCount(); i++) {
			Spreadsheet sheet = this.workBook.getSpreadsheet(i);
			results.addAll(getMatches(pattern, sheet));
		}

		return results;
	}

	/**
	 * Private method, called for each Spreadsheet in the Workbook
	 *
	 * @param pattern regex pattern
	 * @param sheet the Spreadsheet
	 * @return list of matching results
	 */
	private List<SearchResultDTO> getMatches(String pattern,
											 Spreadsheet sheet) {
		List<SearchResultDTO> results = new ArrayList<>();
		int columns = sheet.getColumnCount();
		int rows = sheet.getRowCount();

		for (int i = 0; i <= columns; i++) {
			for (int j = 0; j <= rows; j++) {

				Cell cell = sheet.getCell(i, j);
				String content = cell.getContent();
				String value = cell.getValue().toString();

				// Should we match the empty cells if the pattern
				// allows it?
				if ((!content.isEmpty() && content.matches(pattern))
					|| (!value.isEmpty() && value.matches(pattern))) {

					results.add(SearchResultAssembler.
						getResultInformation(sheet, cell));
				}
			}
		}
		return results;
	}

}
