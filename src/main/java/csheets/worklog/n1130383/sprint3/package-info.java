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
 * During this week the work went well as planned. First days dedicated to
 * Analysis and Design, then the Test phase and finally the feature
 * Implementation. While implementing the first Analysis and Design solutions,
 * new concepts were added and therefore changing the previews phases. Most of
 * the time were invested in implementing my feature and global discussion.</p>
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
 * available, therefore it should be performed as a background search. The user
 * can one-click over a specific Workbook found to see a preview or/and
 * double-click to open the Workbook on Cleansheets application.</p>
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
 * Bar plus Classes that handle these feature required algorithms.<ul>
 * <li><b>AWSExtension:</b> This class contains data regarding the Extension:
 * Name, Version. It also provides access to this UIExtension, required to load
 * the Extension in the main User Interface of the application, and will extend
 * the Extension Class, as all other Extensions. (All inheritance will be
 * available further on this page).
 * </li>
 * <li><b>AWSUI:</b> Extends UIExtension as all other Extensions UI. It will
 * provide the Side Bar.</li>
 * <li><b>AWSPanel:</b> This class is the actual Side Bar Panel and will contain
 * all components to interact with the User to perform the implemented features
 * – Searching for a Workbook, open a preview or/and open the Workbook to the
 * current workspace. This Sidebar, aside from Buttons and Text Fields, has also
 * a DefaultListModel to contain all searched files and a DefaultTableModel to
 * contain all data regarding the Workbook Preview.</li>
 * <li><b>AWSController:</b> Class in charge of handling the Search and
 * providing the results to AWSPanel. It will also communicate with
 * WorkbookPreview and retrieve a preview of the given Workbook.</li>
 * <li><b>WorkbookPreview:</b> This Class builds a preview according the
 * Workbook received from AWSController. The preview is a 5*5 rectangular area
 * delimited by an upper left corner and a lower right corner. The first Cell
 * with content will fulfil the position (0; 0) and will serve as a reference
 * for the other cells. This class works as a <b>service</b> who builds 5*5
 * preview for any non-corrupted Workbook. The size of the preview can easily be
 * changed.</li>
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
 * <h2>5. Design</h2>
 *
 * <h3>Functional Tests</h3>
 * <p>
 * Tests can be made for class <code>WorkbookPreview</code> in order to evaluate
 * the previwed cells and if it correspond to the given workbook. There can also
 * be tests for the method that searchs for workbooks in the current machine. In
 * order to do so there must be a testing class for <code>AWSController</code>
 * and <code>WindowPreview.</code></p>
 * <p>
 * Both classes were tested for this feature requirements and are fully
 * functional.</p>
 *
 *
 * <h3>UC Realization</h3>
 *
 * <b>Class Diagram:</b>
 *
 * <p>
 * <img src="doc-files/ipc02.2_class_diagram.png" alt="Class Diagram"></p>
 *
 * <b>Sequence Diagram:</b>
 * <p>
 * <img src="doc-files/ipc02.2_sequence_diagram.png" alt="Sequence Diagram"></p>
 *
 *
 * <h3>Design Patterns and Best Practices</h3>
 *
 * <p>
 * Singleton Pattern implemented by ExtensionManager.</p>
 * <p>
 * Low Cowpling - High Cohesion.</p>
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * This feature side bar provides the major interaction with the user and access
 * to its functionalities.The user is able to specify a directory to perform the
 * search and a pattern on how the search is based on. Two <b>Text Labels</b>
 * will be implemented alongside with 2 buttons:<ul>
 * <li><b>Search button</b> - Opens a Directory Dialog. The user chooses a
 * directory on the machine.</li>
 * <li><b>Go button</b> - Starts a background search based on the information
 * provided. At this moment a second thread performs the search while all
 * features are available - asynchronous operation.</li>
 * <li>
 * A Grid (DefaultTableModel) will be implemented on the side bar Extension. It
 * will be a preview of one of the selected workbooks showing a group of cells.
 * The list of possible selected workbooks will be displayed below the grid
 * showing all workbooks found.</li>
 * <li>
 * Also a List(DefaultListModel) that will contain all Files found from the
 * Search</li>
 * </ul>
 *
 * <p>
 * <b> Final Version of the Side Bar:</b></p>
 * <p>
 * <img src="http://i.imgur.com/p3T6ZeR.png" alt="Side-Bar"></p>
 *
 * <p>
 * Top-Right Corner has a Gif that is enabled while the Search is running
 * (Search algorithm).</p>
 * <p>
 * <img src="http://i.imgur.com/nY7q5uw.png" alt="Side-Bar-Search-Indicator"></p>
 *
 * <p>
 * The WorkbookPreview was implemented to set up a Preview for any non-corrupted
 * Workbook. The Algorithm makes use of Iteration to look for the first
 * non-empty cell in all Spreadsheets available. The cell is saved and used as a
 * reference to export the content of a block of cells to create the
 * preview.</p>
 * <p>
 * The AWSController Search Algorithm searchs for Files in a given Directory and
 * makes use of Recursivity to search on the Sub-Directories of that Directory
 * and so on. For the pattern system the java.util.regex package was used for
 * matching the given pattern with regular expressions and to validate them.</p>
 *
 *
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * <p>
 * During this week I focused more on my individual feature while still being
 * available for anyone who needed. All IPC team had great members and the
 * Demonstration worked really well.</p>
 *
 * <h2>8. Final Remarks</h2>
 *
 * <p>
 * After the Demonstration a crucial update on this feature side bar was made
 * and commited to fix a malfunction on the Search Button as well as selecting a
 * directory.
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
 * <p>
 * <b>Thurday</b>
 * <p>
 * Today:
 * <p>
 * 1. Demonstration.
 * <p>
 * 2. Sprint Review.
 * <p>
 * 3. Feature Update.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <h2>10. Self Assessment</h2>
 *
 * <h3>10.1. Design and Implementation</h3>
 * <p>
 * A more viable TDD approach was used and all tests made cover 100% of the code
 * outside UI.</p>
 *
 *
 * <p>
 * <b>Evidences:</b><ul>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/c3a5c9fe39154b624680e6b52c20991b968f1004">Analysis
 * and Design</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/822ca145ecc9799881b43cb1ca06f3bdc179953c">Design
 * and Class Placement</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/d5ceafb0d5d6416bfd0218dac52a3632176abf87">Tests
 * First Commit</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/e7b2e49c07aa46c0e27e2928b0cafb2fba1f07ae">Tests
 * Second Commit</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/559501802962845526a28a6e2114394e84d4bd04">Implementation
 * First Commit</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/a073243f859e439345ec0e32c78fc530b00c99ad">Implementation
 * Second Commit</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/dfe1a235369db494ee593d7821b411e90a6bdb3e">Code
 * Refactoring</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/1fb1e915bb8272f439f7c18e0e1963e74a5d977f">Tests
 * Update</a></li>
 * <li>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/0958846ef2a30eb7e3c6145257b38a8a9e7f65e1">Feature
 * UI Update</a></li>
 * </ul>
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
