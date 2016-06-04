/**
 * Technical documentation regarding the work of the team member (1140364) José
 * Barros during week2.
 *
 * <p>
 * <b>Scrum Master:</b> no
 *
 * <p>
 * <b>Area Leader:</b> no
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature-
 *
 * <h2>2. Use Case/Feature: Core02.1</h2>
 *
 * <b>Issue in Jira:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-57">LPFOURDG-57</a></p>
 * <b>Sub-tasks:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-132">LPFOURDG-132</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-133">LPFOURDG-133</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-134">LPFOURDG-134</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-135">LPFOURDG-135</a></p>
 *
 *
 * <h2>3. Requirement</h2>
 * <p>
 * A new extension that makes it possible to search for workbooks in all
 * instances of Cleansheets in the local network</p>
 *
 * <p>
 * <b>Use Case 1 - "Search in Another Instance":</b> It should be possible to
 * send a request for searching workbooks to another instance of Cleansheets.
 * The search should be based on the name of the workbook (a pattern of the
 * name). The search should only include workbooks that are open in the remote
 * instance of Cleansheets. The reply must inform if the workbook was find or
 * not. If the workbook was find then the reply must also include a summary of
 * the contents of the workbook. This summary should include the name of the
 * worksheets and the values of the first non-empty cells of each worksheet.</p>
 *
 *
 * <h2>4. Analysis</h2>
 * Search workbook in another instance will be supported in a new extension to
 * cleansheets we need to study how extensions are loaded by cleansheets and how
 * they work. The first sequence diagram in the section
 * <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application
 * Startup</a> tells us that extensions must be subclasses of the Extension
 * abstract class and need to be registered in special files. The Extension
 * class has a method called getUIExtension that should be implemented and
 * return an instance of a class that is a subclass of UIExtension.
 *
 * <h3>First Analysis sequence diagram</h3>
 *
 * <h3>Send Request</h3>
 * The user selects "Search in another instance" option in the "Search
 * Workbooks" menu. The system gets the other available instances in the local
 * network, and presents. The user selects which instance to communicate and
 * hopes that the other instance accepted the request.
 *
 * <p>
 * <img src="doc-files/ipc_03.1_analysis.png" alt="image">
 *
 * <h3>Search the workbook by name</h3>
 * The user introduces the name of workbook to search in the remote instance of
 * Cleansheets and waits reply of search.
 *
 * <p>
 * <img src="#" alt="image">
 *
 * <h3>Display summary of search</h3>
 * If workbook was find the system display a summary of the contents of the
 * workbook. This summary include the name of the worksheets and the values of
 * the first non-empty cells of each worksheet.
 *
 * <p>
 * <img src="#" alt="image">
 *
 * <h3>Analysis of Core Technical Problem</h3>
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * For this user story we can start by coding a unit test that uses a subclass
 * of InstanceWorkbookExtension to see if the other instance receives the
 * request and that in turn responds to the same request. Another test can be
 * verify that the name of the book returned is the same user-entered name. And
 * still prove that it is impossible to find a workbook in another instance
 * without the user has introduces a pattern name for search
 *
 * <p>
 * see: #
 * </p>
 *
 * <h3>5.2. UC Realization</h3>
 *
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension csheets.ext.style we can
 * find examples that illustrate how to implement these technical requirements.
 * The following diagrams illustrate core aspects of the design of the solution
 * for this use case.
 *
 * <h3>Extension Setup</h3>
 *
 * The following sequence diagram illustrates the creation of the user interface
 * extension. All the UI extensions are loaded by the UIController at
 * application startup.
 *
 * <p>
 * <img src="doc-files/ipc_3.1_extension_image2.png" alt="image">
 *
 * <p>
 * The following sequences diagrams illustrates the creation of the menu
 * extension. All the menu extensions are loaded by the MenuBar at application
 * startup.
 *
 * <p>
 * <img src="doc-files/ipc_3.1_extension_image3.png" alt="image">
 *
 *
 * <p>
 * <img src="doc-files/ipc_3.1_extension_image4.png" alt="image">
 *
 * <h3>5.3. Classes</h3>
 *
 * The following diagram shows the setup of the "share" extension when
 * cleansheets is run.
 *
 * <p>
 * <img src="doc-files/ipc_3.1_extension_image1.png" alt="image">
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance,
 * database models or updates to the domain model-
 *
 * <h2>6. Implementation</h2>
 *
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-</p>
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
 * <p>
 * <b>Saturday</b>
 * <p>
 * Today: Analysis use case and design.
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 *
 * <p>
 * <b>Sunday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today:
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today:
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today:
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
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
 * 1.
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
 * - url of commit: - description: this commit is related to the implementation
 * of the design pattern-</p>
 *
 * <h3>10.2. Teamwork:</h3>
 *
 * <h3>10.3. Technical Documentation:</h3>
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
package csheets.worklog.n1140364.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author José Barros 1140364@isep.ipp.pt
 */
class _Dummy_ {
}
