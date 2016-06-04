/**
 * Technical documentation regarding the work of the team member (1140280) Antonio Bernardo during week2.
 *
 *
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 *
 * <b>Area Leader: -(yes/no)- no</b>
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Use Case/Feature: LANG04.1</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-36">LPFOURDG-39</a>
 *
 *
 * <h2>3. Requirement</h2>
 * Cleansheets should have a menu option to launch a wizard to aid the user
 * in calling functions in formulas. This new window should display a list of 
 * possible functions. The construction of this list should be made dynamically
 * based on the properties file and self-description of the functions. When a function 
 * is selected in the list its syntax should be displayed in a edit box. The 'syntax'
 * should include the name of the functions and its parameters. For example, for the 
 * factorial function, that only has one parameter, the following text should be displayed
 * in the edit box '= FACT(Number)'. The window should also contain an area to display 
 * a text describing the selected function (i.e., help text). The window should have an 
 * 'Apply' and a 'Cancel' button. If the user selects the 'Apply' button the text of the
 * syntax of the function should be written in the formula bar.
 *
 *
 * <h2>4. Analysis</h2>
 * Display all avalible functions
 * When selected display its atributes
 * If requested display help usage
 * When asked execute function and diplay results
 * If some operation goes wrong a blocking pop shoud be diplayed
 * 
 * 
 * <h2>5. Design</h2>
 *
 *  <p>Diagram of the core functionality of the feature </p>
 *
 * <img src="doc-files/lang04_01_design1.png" alt="image">
 * 
 * <h3>5.3. Classes</h3>
 *
 * <h2>9. Work Log</h2>
 *
 * <b>Friday</b>
 *
 * Reading feature requirements and analysing formulas code in order to understand how
 * antlr and grammars are integratd in the project
 * 
 * 
 * <b>Saturday</b> 
 * 
 * Doing Use case design, first draft finished and ready to strat implementing, might require some
 * changes later on
 * 
 * <b>Monday</b>
 *
 *
 *
 * <b>Tuesday</b>
 *
 *
 * <h2>10. Self Assessment</h2>
 *
 * -
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 *
 * <b>Evidences:</b>
 * 
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Antonio Bernardo
 */
package csheets.worklog.n1140280.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Antonio Bernardo
 */
class _Dummy_ {
}
