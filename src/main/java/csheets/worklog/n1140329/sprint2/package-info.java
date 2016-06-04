/**
 * Technical documentation regarding the work of the team member (1140329) Rafael Rocha during week2. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work during the week.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: IPC01.2</h2>
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-52">LPFOURDG-52: Sharing’s Automatic Update</a>
 * <p>
 * Sub-Tasks in Jira:  <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-152">LPFOURDG-152: Analysis</a>; 
 *                     <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-153">LPFOURDG-153: Design</a>; 
 *                     <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-154">LPFOURDG-154: Tests</a>; 
 *                     <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-155">LPFOURDG-155: Implementation</a>
 * <p>
 * 
 * LPFOURDG-52
 * 
 * Once a connection is stablished between two instances of Cleansheets updates 
 * made in one side must be automatically sent to the other side. 
 * The data shared must include now also the style of the cells. 
 * At the moment it is not necessary to support the sharing of cells with formulas.
 * 
 * <h2>3. Requirement</h2>
 * Once a connection is stablished between two instances of Cleansheets, 
 * it should be possible for updates made in one side to be automatically sent to the other side.
 * The data shared must include now also the style of the cells.
 * 
 * <p>
 * <b>Use Case "Sharing's Automatic Update":</b> Once a connection is stablished
 * between two instances of Cleansheets, it should be possible for updates made
 * in one side to be automatically sent to the other side.
 * 
 *  
 * <h2>4. Analysis</h2>
 * <h3>Automatic Cells Update</h3>
 * The user selects "Automatic Cells Update Between Two Instances" option in the "Share Cells" menu.
 * The system gets the other available instances in the local network, and presents them in a sidebar window.
 * The user selects which instance to establish a connection to.
 * Once a cell is edited by the user, the system sends it to the targeted instance 
 * and updates the instance's spreadsheet.
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * <h4>Automatic Cells Update proposal analysis</h4>
 * <p>
 * <img src="doc-files/automatic_cell_update_image.png" alt="image"> 
 * <p>
 * 
 * From the previous diagram we see that we need to add a new functionality to the UI: listening to the active spreadsheet's cells.
 * Therefore, at this point, we need to study how to add this new functionality to the UI. This is the core technical problem regarding this issue.
 * 
 * <h3>Analysis of Core Technical Problem</h3>
 *
 * 
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core functionality of this use case is to be able to add an attribute to cells to be used to store a comment/text. We need to be able to set and get its value.
 * Following this approach we can start by coding a unit test that uses a subclass of <code>CellExtension</code> with a new attribute for user comments with the corresponding method accessors (set and get). A simple test can be to set this attribute with a simple string and to verify if the get method returns the same string.
 * As usual, in a test driven development approach tests normally fail in the beginning. The idea is that the tests will pass in the end. 
 * <p>
 * see: <code>csheets.core.SpreadsheetTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We will also need to create a subclass of UIExtension. For the sidebar we need to implement a JPanel. In the code of the extension <code>csheets.ext.style</code> we can find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>User Share selected Cells</h3>
 * The following diagram shows the setup of the local connection when cleansheets's user select share.
 * <p>
 * <img src="doc-files/ipc01_01_design.png" alt="image">
 * 
 *
 * <h3>Application display shared cells</h3>
 * The following diagram illustrates what happens when a instance of cleansheet receive shared cells.
 * <p>
 * <img src="doc-files/ipc01_01_design1.png" alt="image">
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "share" extension when cleansheets is run.
 * <p>
 * <img src="doc-files/ipc01_design.png" alt="image">
 *  
 * <h3>5.3. Classes</h3>
 * <p>
 * <b>Class Diagram</b>
 * <p>
 * Global Class Diagram
 * <p>
 * <img src="doc-files/ipc01_classDiagram.png" alt="image"> 
 * <p>
 * Extension Class Diagram
 * <p>
 * <img src="doc-files/ipc_extension_image1.png" alt="image">
 * <p>
 * * <b>Sequence Diagrams</b> illustrating the setup of the extension
 * <p>
 * The following sequence diagram illustrates the creation of the share
 * extension. All the extensions are loaded dynamically by the ExtensionManager
 * at application startup.
 * <img src="doc-files/ipc_extension_image2.png" alt="image">
 *
 * <p>
 * The following sequence diagram illustrates the creation of the user interface
 * extension. All the UI extensions are loaded by the UIController at
 * application startup.
 * <img src="doc-files/ipc_extension_image3.png" alt="image">
 *
 * <p>
 * The following sequence diagram illustrates the creation of the menu
 * extension. All the menu extensions are loaded by the MenuBar at application
 * startup.
 * <img src="doc-files/ipc_extension_image4.png" alt="image">
 * <p>
 * <b>Sequence Diagrams</b> illustrating use cases of the extension
 * <p>
 * <img src="doc-files/ipc_extension_image5.png" alt="image">
 *
 * -Document the implementation with class diagrams illustrating the new and the modified classes-
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * -Describe new or existing design patterns used in the issue-
 * 
 * Observer: This Pattern is used to notify SharePanel with new instances in local network and received cells.
 * 
 * <h2>6. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and where used in this issue. As far as possible you should use links to the commits of your work-
 * <p>
 * see:<p>
 * <a href="../../../../csheets/ext/cellsSharing/package-summary.html">csheets.ext.cellsSharing</a><p>
 * <a href="../../../../csheets/ext/cellsSharing/ui/package-summary.html">csheets.ext.cellsSharing.ui</a><p>
 * <a href="../../../../csheets/framework/volt/package-summary.html">csheets.framework.volt</a>
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * -In this section present your views regarding alternatives, extra work and future work on the issue.-
 * <p>
 * As an extra this use case also implements a small cell visual decorator if the cell has a comment. This "feature" is not documented in this page.
 * 
 * 
 * <h2>9. Work Log</h2> 
 * 
 * -Insert here a log of you daily work. This is in essence the log of your daily standup meetings.-
 * <p>
 * Example
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Configure the IDE to start working
 * <p>
 * 2. Studying the base code.
 * <p>
 * 3. Started analysis of IPC01.1.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Configure the IDE to start working
 * <p> 
 * 2. Studying the base code.
 * <p>
 * 3. Started analysis of IPC01.1.
 * <p>
 * Today
 * <p>
 * 1. Working on analysis of IPC01.1
 * <p>
 * 2. Help designing IPC01.1
 * <p>
 * 3. Help implementing IPC01.1
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Working on analysis of IPC01.1
 * <p>
 * 2. Help designing IPC01.1
 * <p>
 * 3. Help implementing IPC01.1
 * <p>
 * Today
 * <p>
 * 1. Help implementing IPC01.1
 * <p>
 * Blocking:
 * 1. -nothing-
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Help implementing IPC01.1
 * <p>
 * Today
 * <p>
 * 1. Help finishing IPC01.1
 * <p>
 * 2. Preparing the functionality for the client demo.
 * <p>
 * Blocking:
 * 1. -nothing-
 * <h2>10. Self Assessment</h2> 
 * 
 * -Insert here your self-assessment of the work during this sprint.-
 * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * 3- bom: os testes cobrem uma parte significativa das funcionalidades (ex: mais de 50%) e apresentam código que para além de não ir contra a arquitetura do cleansheets segue ainda as boas práticas da área técnica (ex: sincronização, padrões de eapli, etc.)
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: ... - description: this commit is related to the implementation of the design pattern ...-
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Rafael Rocha
 */

package csheets.worklog.n1140329.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author CarlosSantos
 */
class _Dummy_ {}

