/**
 * Technical documentation regarding the work of the team member (1140611) Carlos Santos during week1. 
 * 
 * <p>
 * <b>-Note: this is a template/example of the individual documentation that each team member must produce each week/sprint. Suggestions on how to build this documentation will appear between '-' like this one. You should remove these suggestions in your own technical documentation-</b>
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
 * <h2>2. Use Case/Feature: IPC01.1</h2>
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-51">LPFOURDG-51</a>
 * <p>
 * Sub-Task in Jira:  <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-105">LPFOURDG-105</a>
 * <p>
 * -Include the identification and description of the feature-
 * 
 * <h2>3. Requirement</h2>
 * It should be possible to establish a connection with other instance of Cleansheets in the local network.
 * 
 * <p>
 * <b>Use Case "Start Sharing":</b> It should be possible to send the contents of a range of cells to another instance of Cleansheets. The other instance should display the received contents in the same cell address as the original cells.
 * 
 *  
 * <h2>4. Analysis</h2>
 * <h3>Send Cells</h3>
 * The user selects "Send Cells" option in the "Share Cells" menu.
 * The system gets the other available instances in the local network, and presents them in a sidebar window.
 * The user selects which instance to send the cells to, and activates the sending.
 * The system gets the selected cells, and sends them to the targeted instance.
 * The system notifies the user that the cells were sent.
 * 
 * <h3>Receive Cells</h3>
 * The user selects "Receive Cells" option in the "Share Cells" menu.
 * The system waits for the cells being sent in the local network.
 * After receiving the cells, the system checks if checks if the received cells are located on an address that already has existing cells.
 * If so, then the system asks the user for permission to change the original cells with the new ones.
 * Otherwise, the system just changes them.
 * The system notifies the user that the cells were changed.
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * <h4>Send Cells proposal analysis</h4>
 * <p>
 * <img src="doc-files/share_cell_send_image.png" alt="image"> 
 * 
 * <h4>Receive Cells proposal analysis</h4>
 * <p>
 * <img src="doc-files/share_cell_receive_image.png" alt="image"> 
 * <p>
 * 
 * From the previous diagram we see that we need to add a new "attribute" to a cell: "comment".
 * Therefore, at this point, we need to study how to add this new attribute to the class/interface "cell". This is the core technical problem regarding this issue.
 * <h3>Analysis of Core Technical Problem</h3>
 * We can see a class diagram of the domain model of the application <a href="../../../../overview-summary.html#modelo_de_dominio">here</a>
 * From the domain model we see that there is a Cell interface. This defines the interface of the cells. We also see that there is a class CellImpl that must implement the Cell interface.
 * If we open the {@link csheets.core.Cell} code we see that the interface is defined as: <code>public interface Cell extends Comparable &lt;Cell&gt;, Extensible&lt;Cell&gt;, Serializable</code>. Because of the <code>Extensible</code> it seams that a cell can be extended.
 * If we further investigate the hierarchy of {@link csheets.core.Cell} we see that it has a subclass {@link csheets.ext.CellExtension} which has a subclass {@link csheets.ext.style.StylableCell}. {@link csheets.ext.style.StylableCell} seems to be an example of how to extend cells.
 * Therefore, we will assume that it is possible to extend cells and start to implement tests for this use case. 
 * <p>
 * The <a href="http://en.wikipedia.org/wiki/Delegation_pattern">delegation design pattern</a> is used in the cell extension mechanism of cleansheets. The following class diagram depicts the relations between classes in the "Cell" hierarchy.
 * <p>
 * <img src="doc-files/" alt="image"> 
 * 
 * <p>
 * One important aspect is how extensions are dynamically created and returned. The <code>Extensible</code> interface has only one method, <code>getExtension</code>. Any class, to be extensible, must return a specific extension by its name. The default (and base) implementation for the <code>Cell</code> interface, the class <code>CellImpl</code>, implements the method in the following manner:
 * <pre>
 * {@code 
 * 	empty //Insert code if necessary
 * }
 * </pre>
 * As we can see from the code, if we are requesting a extension that is not already present in the cell, it is applied at the moment and then returned. The extension class (that implements the <code>Extension</code> interface) what will do is to create a new instance of its cell extension class (this will be the <b>delegator</b> in the pattern). The constructor receives the instance of the cell to extend (the <b>delegate</b> in the pattern). For instance, <code>StylableCell</code> (the delegator) will delegate to <code>CellImpl</code> all the method invocations regarding methods of the <code>Cell</code> interface. Obviously, methods specific to <code>StylableCell</code> must be implemented by it.
 * Therefore, to implement a cell that can have a associated comment we need to implement a class similar to <code>StylableCell</code>.
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
 * <h3>5.3. Classes</h3>
 * 
 * -Document the implementation with class diagrams illustrating the new and the modified classes-
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance, database models or updates to the domain model-
 * 
 * <h2>6. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and where used in this issue. As far as possible you should use links to the commits of your work-
 * <p>
 * see:<p>
 * <a href="../../../../csheets/ext/cellsSharing/package-summary.html">csheets.ext.cellsSharing</a><p>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.comments.ui</a>
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
 * Today
 * <p>
 * 1. Design of IPC01.1 Start Sharing and help on first analysis
 * <p>
 * Blocking:
 * <p>
 * 1. Depend on first analysis
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Design of IPC01.1 Start Sharing
 * <p>
 * Today
 * <p>
 * 1. Study the architecture of application
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing to report at moment-
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * -Insert here your self-assessment of the work during this sprint.-
 * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * 3- good: the design is implemented in same way of architecture of application and extensions
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/b80d9575f17f21a548b497f92a1f33bad9c216c5">commit b80d957</a>- description: this commit is related to the design of feature start sharing.-
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Carlos Santos
 */

package csheets.worklog.n1140611.sprint1;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author Carlos Santos
 */
class _Dummy_ {}

