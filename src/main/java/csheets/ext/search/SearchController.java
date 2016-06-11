/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search;

import csheets.core.Workbook;
import csheets.framework.search.SearchResultDTO;
import csheets.framework.search.WorkBookSearch;
import java.util.List;
import java.util.Stack;
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
     * Searches given Workbook for given pattern
     *
     * @param workBooks All the open workbooks
     * @param searchstring the string to match
     * @return result list
     */
    public List<SearchResultDTO> searchWorkBook(Stack<Workbook> workBooks,
            String searchstring) throws PatternSyntaxException {
        WorkBookSearch workBookSearch = new WorkBookSearch(workBooks);
        List<SearchResultDTO> results = workBookSearch.getMatches(searchstring);
        return results;
    }

}
