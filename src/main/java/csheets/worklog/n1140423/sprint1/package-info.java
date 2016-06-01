/**
 * Technical documentation regarding the work of the team member (1140423) Renato Machado during week1. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <b>Area Leader: -(yes/no)- yes</b>
 * </p>
 * 
 * <h2>1. Notes</h2>
 * 
 * <p>
 * Been setting up the network protocols for instances of Cleansheets to connect to each others.
 * Helped my colleagues to understand the protocol structure and how things connect to each other.
 * </p>
 * 
 * <h2>2. Use Case/Feature: IPC01.1</h2>
 * 
 * <p>
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-51">LPFOURDG-51</a>
 * </p>
 * <p>
 * LPFOURDG-51
 * 
 * It should be possible to establish a connection with other instance of
 * Cleansheets in the local network. It should be possible to send the contents
 * of a range of cells to another instance of Cleansheets. The other instance
 * should display the received contents in the same cell address as the original
 * cells. It should be possible to configure the port to be used for network
 * connections. It should be possible to find other instances of Cleansheets
 * available in e local network. These instances should be listed in a new
 * window (sidebar window). The user should be able to select one of the
 * discovered instances to connect to when establishing the connection to send
 * the contents of the range of cells. At the moment it is only required to send
 * the value of the cells.
 * 
 * </p>
 * 
 * <h2>3. Requirement</h2>
 *
 * It should be possible to establish a connection with other Clensheets instances in the local network, and share the values of the selected cells.
 * The connection should be configurable.
 * 
 * <p>
 * <b>Use Case "Start Sharing":</b> The user .
 * 
 *  
 * <h2>4. Analysis</h2>
 * Since comments on cells will be supported in a new extension to cleansheets we need to study how extensions are loaded by cleansheets and how they work.
 * The first sequence diagram in the section <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application Startup</a> tells us that extensions must be subclasses of the Extension abstract class and need to be registered in special files.
 * The Extension class has a method called getUIExtension that should be implemented and return an instance of a class that is a subclass of UIExtension.
 * In this subclass of UIExtension there is a method (getSideBar) that returns the sidebar for the extension. A sidebar is a JPanel.
 * 
 * 
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the previously described use case. We call this diagram an "analysis" use case realization because it functions like a draft that we can do during analysis or early design in order to get a previous approach to the design. For that reason we mark the elements of the diagram with the stereotype "analysis" that states that the element is not a design element and, therefore, does not exists as such in the code of the application (at least at the moment that this diagram was created).
 * <p>
 * <img src="doc-files/comments_extension_uc_realization1.png" alt="image"> 
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
 * <img src="doc-files/core02_01_analysis_cell_delegate.png" alt="image"> 
 * 
 * <p>
 * One important aspect is how extensions are dynamically created and returned. The <code>Extensible</code> interface has only one method, <code>getExtension</code>. Any class, to be extensible, must return a specific extension by its name. The default (and base) implementation for the <code>Cell</code> interface, the class <code>CellImpl</code>, implements the method in the following manner:
 * <pre>
 * {@code 
 * 	public Cell getExtension(String name) {
 *		// Looks for an existing cell extension
 *		CellExtension extension = extensions.get(name);
 *		if (extension == null) {
 *			// Creates a new cell extension
 *			Extension x = ExtensionManager.getInstance().getExtension(name);
 *			if (x != null) {
 *				extension = x.extend(this);
 *				if (extension != null)
 *					extensions.put(name, extension);
 *			}
 *		}
 *		return extension;
 *	}
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
 * see: <code>csheets.ext.comments.CommentableCellTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We will also need to create a subclass of UIExtension. For the sidebar we need to implement a JPanel. In the code of the extension <code>csheets.ext.style</code> we can find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "comments" extension when cleansheets is run.
 * <p>
 * <img src="doc-files/core02_01_design.png" alt="image">
 * 
 *
 * <h3>User Selects a Cell</h3>
 * The following diagram illustrates what happens when the user selects a cell. The idea is that when this happens the extension must display in the sidebar the comment of that cell (if it exists).
 * <p>
 * <img src="doc-files/core02_01_design2.png" alt="image">
 * 
 * <h3>User Updates the Comment of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the text of the comment of the current cell. To be noticed that this diagram does not depict the actual selection of a cell (that is illustrated in the previous diagram).
 * <p>
 * <img src="doc-files/core02_01_design3.png" alt="image">
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
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.comments</a><p>
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
 * <p>31/05/2016</p>
 * <b>Tuesday</b>
 * <p>Yesterday:</p>
 * <p>I defined the subtasks for the IPC01.1.</p>
 * <p>Today</p>
 * <p>Started working on the feature. Helped colleagues to understand the problem and recommended a solution.
 * Explained how Volt, a package developed in RCOMP that eases the development of UDP and TCP protocols, works.
 * Implemented Volt in the repository, and the Support package (with the TaskManager, ThreadManager).</p>
 * <p>Blocking</p>
 * <p>Nothing.</p>
 * 
 * <p>01/06/2016</p>
 * <b>Wednesday</b>
 * <p>Yesterday:</p>
 * <p>I've develop a few helper classes to handle some more difficult situations, such as timing events and
 * thread management. I've also develop a super set protocol over TCP/IP to be able to develop my feature.</p>
 * <p>Today</p>
 * <p>Will work on Volt to make the whole process a bit more stable, testing, try to find bugs and fix them.
 * Will help my colleagues if they have any difficulties.</p>
 * <p>Blocking</p>
 * <p>Nothing.</p>
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * -Insert here your self-assessment of the work during this sprint.-
 * 
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * 3- bom: os testes cobrem uma parte significativa das funcionalidades (ex: mais de 50%) e apresentam código que para além de não ir contra a arquitetura do cleansheets segue ainda as boas práticas da área técnica (ex: sincronização, padrões de eapli, etc.)
 * <p>
 * <b>Evidences:</b>
 * </p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/e01bbf726b8a1ba29f3e920f53d8fb10b6c2ed57">Small updates on TcpServer</a>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/2c14560581f15ead1be0471d8ac39f9e69ce697c">Fixed errors on TcpClient</a>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/2b4ded30d0b4dfa006a4fa5e9377923bef28fcc7">Added Volt. Developed TaskManager and ThreadManager</a>
 * </p>
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Renato Machado
 */

package csheets.worklog.n1140423.sprint1;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}

