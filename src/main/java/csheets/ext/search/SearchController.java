/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search;

import csheets.core.Workbook;
import csheets.search.SearchResultDTO;
import csheets.search.WorkBookSearch;
import java.util.List;
import java.util.regex.PatternSyntaxException;

/**
 * The SearchController
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class SearchController {

	/**
	 * The constructor
	 */
	public SearchController() {
	}

	/**
	 *
	 * @param workbook
	 * @param searchstring
	 * @return
	 */
	public List<SearchResultDTO> searchWorkBook(Workbook workbook,
												String searchstring) throws PatternSyntaxException {
		WorkBookSearch workBookSearch = new WorkBookSearch(workbook);
		List<SearchResultDTO> results = workBookSearch.getMatches(searchstring);
		return results;
	}

}
