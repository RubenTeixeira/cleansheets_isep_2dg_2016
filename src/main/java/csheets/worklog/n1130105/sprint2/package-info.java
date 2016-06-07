/**
 * Technical documentation regarding the work of the team member (1130105) Carlos Mateus during week2.
 *
 * <p>
 * <b>-Note: this is a template/example of the individual documentation that
 * each team member must produce each week/sprint. Suggestions on how to build
 * this documentation will appear between '-' like this one. You should remove
 * these suggestions in your own technical documentation-</b>
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
 * <h2>2. Use Case/Feature: IPC02.1- Find Workbooks</h2>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-54">LPFOURDG-54</a>
 * <p>
 * Sub-Task in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-173">LPFOURDG-173</a>
 * <p>
 * -Include the identification and description of the feature-
 *
 * <h2>3. Requirement</h2>
 * <p>
 * A new extension that makes it possible to search for workbooks in the local
 * file system</p>
 *
 * <p>
 * <b>Use Case "Find Workbooks":</b>
 *
 * </p>
 *
 *
 * <h2>4. Analysis</h2>
 *
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).
 * <h4>Send Cells proposal analysis</h4>
 * <p>
 * <img src="doc-files/share_cell_send_image.png" alt="image">
 *
 * <h4>Receive Cells proposal analysis</h4>
 * <p>
 * <img src="doc-files/share_cell_receive_image.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we need to add a new "attribute" to a
 * cell: "comment". Therefore, at this point, we need to study how to add this
 * new attribute to the class/interface "cell". This is the core technical
 * problem regarding this issue.
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * The core of communication is expected to communicate in udp and tcp protocols
 * connections.
 * <p>
 * <img src="doc-files/ipc_analysis.png" alt="image">
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * see: <code>csheets.core.SpreadsheetTest</code>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension csheets.ext.style we can
 * find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.
 *
 * <h3>Extension Setup</h3>
 *
 * <h3>5.3. Classes</h3>
 *
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 *
 *
 * <h2>6. Implementation</h2>
 *
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 * <p>
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
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 *
 * <p>
 * <b>Saturday</b>
 * <p>
 * Today: Analysis use case and design.
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 *
 *
 * <p>
 * <b>Sunday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis use case and design.
 * <p>
 * Today:
 *
 * Blocking:
 * <p>
 * 1. Nothing
 *
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on: Today:
 * <p>
 * 1. Analysis. Start Implementation
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 *
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 *
 *
 * Today:
 * <p>
 *
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 *
 *
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.</p>
 * <p>
 * Today:</p>
 * <p>
 * 1.</p>
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.</p>
 * <p>
 * Today:</p>
 * <p>
 * 1.</p>
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 *
 *
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on:</p>
 * <p>
 * 1.</p>
 * <p>
 * Today:</p>
 * <p>
 * 1.</p>
 * <p>
 * Blocking:
 * <p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: - description: this commit is related to the implementation
 * of the design pattern-</p>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Carlos Mateus
 */
package csheets.worklog.n1130105.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Carlos Mateus
 */
class _Dummy_ {
}
