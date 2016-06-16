/**
 * Technical documentation regarding the work of the team member (1130383) Pedro
 * Gomes during week3.
 *
 *
 * <p>
 * <b>Scrum Master:</b> no</p>
 * <p>
 * <b>Area Leader:</b> no</p>
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: Ipc02.2</h2>
 *
 * <b>Issue in Jira:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-55">LPFOURDG-55</a></p>
 * <b>Sub-tasks:</b><ul>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-244">LPFOURDG-244</a></li>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-245">LPFOURDG-245</a></li>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-246">LPFOURDG-246</a></li>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-247">LPFOURDG-247</a></li>
 * </ul>
 *
 * <h2>3. Requirement</h2>
 * <p>
 * The sidebar window that displays the results of the search should now include
 * an area to display a preview of the contents of a workbook when the user
 * selects it (i.e., clicks on it). The preview should be based on the values of
 * the first non-empty cells of the workbook. This preview should be produced
 * without open the worksheet (at least without the worksheet been opened in the
 * user interface). The search should now be based on a pattern and not only on
 * the file name extension.</p>
 *
 * <p>
 * <b>Use Case - Workbook Search:</b> The user indicates a pattern and a
 * directory to search for workbooks that resembles the pattern. The search
 * should be performed accordingly and while Cleansheets application is fully
 * available, therefore it should be perform in the background. The user should
 * one-click over a specific result to see a preview or/and double-click to open
 * the result on Clean Sheets application.</p>
 *
 *
 * <h2>4. Analysis</h2>
 *
 * <p>
 * Analysis Diagram:</p>
 **<p>
 * <img src="doc-files/ipc02.2_analysis.png" alt="Class Diagram Analysis"></p>
 *
 * The Classes to implement are similar to other Extensions that also use a Side
 * Bar plus Classes that handle this feature algorithms.<ul>
 * <li><b>AWSExtension:</b> This class contains data regarding the Extension:
 * Name, Version. It also provides access to this UIExtension, required to load
 * the Extension in the main User Interface of the application, and will extend
 * the Extension Class, as all other Extensions. (All inheritance will be
 * available further on this page).
 * </li>
 * <li><b>AWSUI:</b> Extends UIExtension as all other Extensions UI. It will
 * provide the Side Bar.</li>
 * <li><b>AWSPanel:</b> This class is the actual Side Bar Panel and will contain
 * the components to interact with the User to perform the implemented features
 * – Searching for a Workbook, open a preview or/and open the Workbook to the
 * current workspace. The first draft for the side bar panel:<li>
 * <li><b>AWSController:</b> Class in charge of handling the Search results,
 * open the Preview for a specific Workbook or set the current workspace with an
 * opened Workbook.</li>
 * <li><b>WorkbookPreview:</b> This Class will build a preview panel according
 * the Workbook it receives from AWSController. The preview is a 6*4 rectangular
 * area delimited by an upper left corner and a lower right corner. The first
 * Cell with content will fulfil the position (0; 0) and will serve as a
 * reference for the other cells.</li>
 * </ul>
 *
 * <h3>Analysis of the core problem/functionality:</h3>
 * <p>
 * From the analysis made above, and the set of requirements needed for this
 * feature, the core functionality is to provide the user the ability to not
 * only search for workbooks in a specific directory but also to see a preview
 * of the found workbooks without performing the actual "opening" to the current
 * workspace. This feature will save time and will enhance the experience with
 * the application.</p>
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>Functional Tests</h3>
 * <p>
 * Tests can be made for class <code>WorkbookPreview</code> in order to evaluate
 * the previwed cells and if they correspond to the workbook. There can also be
 * tests for the method that searchs for workbooks in the current machine. In
 * order to do so there must be a testing class for <code>AWSController</code>
 * and <code>WindowPreview.</code></p>
 *
 *
 * <h3>UC Realization</h3>
 *
 * <b>First Class Diagram:</b>
 *
 * <p>
 * <img src="doc-files/ipc02.2_class_diagram.png" alt="Class Diagram"></p>
 *
 * <b>First Sequence Diagram:</b>
 * <p>
 * <img src="doc-files/ipc02.2_sequence_diagram.png" alt="Sequence Diagram"></p>
 *
 *
 * <h3>Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance,
 * database models or updates to the domain model-
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * This feature side bar provides the major interaction with the user and access
 * to its functionalities.The user is able to specify a directory to perform the
 * search and a pattern on how the search is based on. Two <b>Text Labels</b>
 * will be implemented alongside with 3 buttons:<ul>
 * <li><b>Search button</b> - Opens a Directory Dialog. The user chooses a
 * directory on the machine.</li>
 * <li><b>Go button</b> - Starts a background search based on the information
 * provided. At this moment a second thread performs the search while all
 * features are available - asynchronous operation.</li>
 * <li><b>Stop button</b> - Stops the search. Useful for when the user already
 * found the workbook required.</li>
 * </ul>
 * <p>
 * Both Go and Stop buttons will work with auxiliar synchronization.</p>
 * <p>
 * A Grid will also be implemented on the side bar Extension. It will be a
 * preview of one of the selected workbooks showing a group of cells. The list
 * of possible selected workbooks will be displayed below the grid showing all
 * workbooks found.</p>
 *
 *
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * -In this section document your contribution and efforts to the integration of
 * your work with the work of the other elements of the team and also your work
 * regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 *
 * <h2>8. Final Remarks</h2>
 *
 * -In this section present your views regarding alternatives, extra work and
 * future work on the issue.-
 *
 * <h2>9. Work Log</h2>
 * <p>
 * <b>Sunday</b>
 * <p>
 * Today:
 * <p>
 * 1. Analysis.
 * <p>
 * 2. Design
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Today:
 * <p>
 * 1. Test Solutions Implementation.
 * <p>
 * 2. Reunion with Product Owner.
 * <p>
 * 2. Reunion with Manager.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Today:
 * <p>
 * 1. Worked on Implementation.
 * <p>
 * 2. Reunion with Supervisor.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Today:
 * <p>
 * 1. Finished Implementation. Feature Deployment.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: ... - description: this commit is related to the
 * implementation of the design pattern ...-
 *
 * <h3>10.2. Teamwork</h3>
 *
 * <h3>10.3. Technical Documentation</h3>
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
package csheets.worklog.n1130383.sprint3;

class _Dummy_ {
}
