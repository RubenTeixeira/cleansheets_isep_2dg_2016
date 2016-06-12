/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.search;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.ext.comments.Comment;
import csheets.ext.comments.CommentableCell;
import csheets.ext.comments.CommentsExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
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
    private final Stack<Workbook> workBooks;

    /**
     * The constructor
     *
     * @param workBooks All the open wokbooks
     */
    public WorkBookSearch(Stack<Workbook> workBooks) {
        this.workBooks = workBooks;
    }

    /**
     * Returns the list of results matching then given pattern NB: Calls private
     * method
     *
     * @param pattern regex pattern
     * @param types
     * @param comments
     * @return list of matching results
     */
    public List<SearchResultDTO> getMatches(String pattern, Map<String, Value.Type> types, boolean comments) throws PatternSyntaxException {

        // This is a stub, will be needed later and serves as test
        // for the pattern syntax
        Pattern regex = Pattern.compile(pattern);

        List<SearchResultDTO> results = new ArrayList<>();

        for (Workbook workBook : this.workBooks) {
            for (int i = 0; i < workBook.getSpreadsheetCount(); i++) {
                Spreadsheet sheet = workBook.getSpreadsheet(i);
                results.addAll(getMatches(pattern, types, comments, sheet));
            }
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
            Map<String, Value.Type> types, boolean comments, Spreadsheet sheet) {
        List<SearchResultDTO> results = new ArrayList<>();
        int columns = sheet.getColumnCount();
        int rows = sheet.getRowCount();

        for (int i = 0; i <= columns; i++) {
            for (int j = 0; j <= rows; j++) {

                Cell cell = sheet.getCell(i, j);
                String content = cell.getContent();
                String value = cell.getValue().toString();

                if (comments == true) {
                    CommentableCell commentableCell = (CommentableCell) cell.
				getExtension(CommentsExtension.NAME);
                    
                    List<Comment> commentList = commentableCell.getCommentsList();
                    
                    for (Comment comment : commentList) {
                        if (comment.text().matches(pattern)) {
                            results.add(SearchResultAssembler.
                                        getResultInformation(sheet, cell));
                        }
                    }
                }

                // Should we match the empty cells if the pattern
                // allows it?
                if ((!content.isEmpty() && content.matches(pattern))
                        || (!value.isEmpty() && value.matches(pattern))) {

                    if (!types.isEmpty()) {
                        for (Map.Entry<String, Value.Type> entry : types.entrySet()) {
                            if (cell.getValue().getType().equals(entry.getValue())) {
                                results.add(SearchResultAssembler.
                                        getResultInformation(sheet, cell));
                            }
                        }
                    } else {
                        results.add(SearchResultAssembler.
                            getResultInformation(sheet, cell));
                    }
                }
            }
        }
        return results;
    }

}
