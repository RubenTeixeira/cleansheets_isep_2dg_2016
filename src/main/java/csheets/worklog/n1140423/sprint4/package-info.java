/**
 * Technical documentation regarding the work of the team member (1140423)
 * Renato Machado during week4.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <b>Area Leader: -(yes/no)- no</b>
 * </p>
 *
 * <h2>1. Notes</h2>
 * 
 * <h2>2. Use Case/Feature: Lang07.3</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-47">LPFOURDG-47</a>
 * </p>
 * <p>
 * LPFOURDG-47
 *
 * Design and implement a mini API of the Cleansheets objects inside Beanshell.
 * The new API should provide access to objects like workbook, worksheet, cells,
 * macros, variables, etc. This API should prevent as far as possible access to
 * 'internal' classes of Cleansheets.
 *
 * </p>
 *
 * <h2>3. Requirement</h2>
 *
 * It should be possible to access Cleansheets objects inside Beanshell by providing a public API.
 *
 * <p>
 * <b>Use Case "Cleansheets API":</b>
 *
 * The user creates a new script and uses the API object from Cleansheets go gain access to Cleansheets objects in run time.
 *
 *
 * <h2>4. Analysis</h2>
 *
 * <h3>Beanshell</h3>
 * <p>
 * BeanShell is a small, free, embeddable Java source interpreter with object
 * scripting language features, written in Java. BeanShell dynamically executes
 * standard Java syntax and extends it with common scripting conveniences such
 * as loose types, commands, and method closures like those in Perl and
 * JavaScript.
 * </p>
 * 
 * <h3>Cleansheets</h3>
 * <p>
 * The API should provide public methods to be able to retrieve:
 * </p>
 * 
 * <p>
 * Workbook
 * </p>
 * <p>
 * Worksheet
 * </p>
 * <p>
 * Cells
 * </p>
 * <p>
 * Macros
 * </p>
 * <p>
 * Variables
 * </p>
 * <p>
 * And a few other data types.
 * </p>
 * 
 * <p>
 * The API consists of being a small Facade object in which creates a layer of abstraction between Cleansheets classes and Beanshell. 
 * </p>
 * 
 * <p>
 * Since BeanShell executes an interpreter, all we need is to provide that interpreter an instance of the API in order to have access to it in run time.
 * </p>
 * 
 * <h4>Analysis diagram:</h4>
 *
 * <img src="doc-files/analysis.png" alt="Analysis">
 *
 * <h2>5. Design</h2>
 *  
 * <p>
 * API Class Diagram
 * </p>
 * 
 * <p>
 * <img src="doc-files/api_class_diagram.png" alt="API Class Diagram.">
 * </p>
 * 
 * <p>
 * Associating the API with the BeanShell.
 * </p>
 * 
 * <p>
 * <b>Important:<b> This diagram assumes that the interaction with the User was already made (check earlier feature increments), and therefore we are already on the run() method of BeanShell class.
 * <p>
 * <p>
 * <img src="doc-files/api_beanshell_connection.png" alt="Associating the API with the BeanShell.">
 * </p>
 * 
 * <h3>Tests:</h3>
 * 
 * <h2>6. Implementation</h2>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * <h2>8. Final Remarks</h2>
 *
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * 20/06/2016
 * </p>
 * <b>Monday</b>
 * <p>
 * Today
 * </p>
 * <p>
 * Started to work on the feature. Will try to get as much done as possible.
 * Will also fix some of the previous iterations on small aspects.
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
 * 
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Renato Machado
 */
package csheets.worklog.n1140423.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
