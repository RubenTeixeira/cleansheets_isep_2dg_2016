/**
 * Technical documentation regarding the work of the team member (1140423)
 * Renato Machado during week3.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <b>Area Leader: -(yes/no)- no</b>
 * </p>
 *
 * <h2>1. Notes</h2>
 *
 * Outside of the development of this use case, I've also been working on Volt - our IPC library that handles all communications.
 *
 * <h2>2. Use Case/Feature: Core03.2</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-7">LPFOURDG-7</a>
 * </p>
 * <p>
 * LPFOURDG-7
 *
 * Sort a range of cells. A range of cells is a rectangular area delimited by an
 * upper left corner and a lower right corner. The sorting is based on a column
 * of the range. It should be possible to select the order: ascending or
 * descending. Interaction with the user should be based on a popup menu. It
 * should be possible to sort data of the following types: numeric, text or
 * date.
 *
 * </p>
 *
 * <h2>3. Requirement</h2>
 *
 * It should be possible to sort a column in a range of selected cells delimited by an upper left and lower right corner.
 * Once a column is sorted, all the other columns inside the selected cells should be edited as well.
 *
 * <p>
 * <b>Use Case "Sort Range of Cells":</b>
 *
 * The user selects a range of cells and selects a option that leads to a popup menu to sort the selected cells.
 * In this menu, the user is allowed to select which column to sort, either ascending or descending and based on which type of value (numeric, text, date).
 * Finally, after the user selects the required options and clicks to proceed, the columns should be sorted accordingly.
 *
 *
 * <h2>4. Analysis</h2>
 *
 * <h3>Sorting</h3>
 * <p>
 * In order to sort all cells in a column, we'll sort per type, meaning that if all cells in a column are not of the same type, we won't sort them.
 * </p>
 * <p>For each type we'll use the following sorting rules:</p>
 * <p>For a Text type we'll evaluate its lexicographical value and sort it accordingly.</p>
 * <p>For a Date type we'll evaluate the date in time and sort it accordingly.</p>
 * <p>For a Numeric type we'll evaluate its value and sort it accordingly.</p>
 * 
 * <h4>Analysis diagram:</h4>
 *
 * <img src="doc-files/analysis.png" alt="Analysis">
 *
 * <h2>5. Design</h2>
 *
 * <h3>Sequence Diagram:</h3>
 *
 *
 * <h3>Tests:</h3>
 *
 * <h2>6. Implementation</h2>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * <h2>8. Final Remarks</h2>
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * 13/06/2016</p>
 * <b>Monday</b>
 * <p>
 * Today</p>
 * <p>
 * Worked on Volt (optmizations and general improvements).
 * Started the analysis of the feature Core03.2.
 * </p>
 * <p>
 * Blocking</p>
 * <p>
 * Nothing.</p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * <p>
 * Outcome 3 ("Design and Implementation") - ?</p>
 * <p>
 * Outcome 5 ("Teamwork") - ?</p>
 * <p>
 * Outcome 6 ("Technical Documentation") - ?</p>
 *
 * <h3>10.1. Design and Implementation:</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * </p>
 *
 * <p>
 * <a href="#">#</a></p>
 * <p>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Renato Machado
 */
package csheets.worklog.n1140423.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
