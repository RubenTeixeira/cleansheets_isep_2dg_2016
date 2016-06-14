/**
 * Technical documentation regarding the work of the team member (1140611)
 * Carlos Santos during week3.
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
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: IPC05.1</h2>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-49">LPFOURDG-49</a>
 * <p>
 * -Include the identification and description of the feature-
 *
 * <h2>3. Requirement</h2>
 * It should be possible to import data from an XML file.
 * <p>
 * <b>Use Case " Lang08.2- Import XML ":</b> It should be possible to import
 * data from an XML file (this operation is the 'inverse' of the previous FI).
 * Depending on the contents of the XML file, the data from the file can replace
 * the contents of a workbook, a worksheet or a range of a worksheet. This
 * option should appear in the File menu.
 *
 *
 * <h2>4. Analysis</h2>
 * <h3>Import XML</h3>
 * The user selects in File Menu to import from XML file. The system read file
 * and put information on cell content. The workbook update and information are
 * shown on the user interface.
 *
 * <h3>First "analysis" sequence diagram</h3>
 *
 * <h4>Import XML</h4>
 * <p>
 * <img src="doc-files/lang08.2_analysis.png" alt="image">
 *
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * The core of import data is to made it open to other formats to import
 * <p>
 * <img src="" alt="image">
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to send and receive messages.
 * <p>
 * see: <code>csheets</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.chatApp</code> we can find examples that illustrate how to
 * implement these technical requirements. The following diagrams illustrate
 * core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical
 * documentation the elements depicted in these design diagrams exist in the
 * code!
 *
 * <h3>Chat send Message</h3>
 * The following diagram shows the setup of the local connection when
 * cleansheets's user select share.
 * <p>
 * <img src="doc-files/ipc05.1_design.png" alt="image">
 *
 * <h3>5.3. Classes</h3>
 * <p>
 * <b>Class Diagram</b>
 * <p>
 * Global Class Diagram
 * <p>
 * <img src="doc-files/ipc05.1_classdiagram.png" alt="image">
 * <p>
 * -Document the implementation with class diagrams illustrating the new and the
 * modified classes-
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 *
 * Observer: This Pattern is used to notify SharePanel with new instances in
 * local network and received cells.
 *
 * <h2>6. Implementation</h2>
 *
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/ui/legacy/importXML/package-summary.html">csheets.ui.legacy.importXML</a><p>
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
 * <p>
 * As an extra this use case also implements a small cell visual decorator if
 * the cell has a comment. This "feature" is not documented in this page.
 *
 *
 * <h2>9. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 * <p>
 * Example
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. sprint review
 * <p>
 * Today
 * <p>
 * 1. read the feature
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Saturday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. read the feature
 * <p>
 * Today
 * <p>
 * 1. nothing
 * <p>
 * Blocking:
 * <p>
 * 1.-nothing-
 * <p>
 * <b>Sunday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. nothing
 * <p>
 * Today
 * <p>
 * 1. nothing
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing to report at moment-
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. nothing
 * <p>
 * Today
 * <p>
 * 1. Start analysis of feature lang08.2 importXML
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing to report at moment-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Start analysis of feature lang08.2 importXML
 * <p>
 * Today
 * <p>
 * 1. finish analysis and start design lang08.2 importXML
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing to report at moment-
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. ipc05.1 Chat Application implementation
 * <p>
 * Today
 * <p>
 * 1. ipc05.1 Chat Application implementation
 * <p>
 * Blocking:
 * <p>
 * 1. User interface
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. ipc05.1 Chat Application implementation
 * <p>
 * Today
 * <p>
 * 1. ipc05.1 Chat Application implementation
 * <p>
 * Blocking:
 * <p>
 * 1. how to do tests to a chat
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * 3- good: the design is implemented in same way of architecture of application
 * and extensions
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit:
 *
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Carlos Santos
 */
package csheets.worklog.n1140611.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Carlos Santos
 */
class _Dummy_ {
}
