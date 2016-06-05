/**
 * Technical documentation regarding the work of the team member (1140491) Rui
 * Bastos during week1.
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
 * 06/05/2016: Started the analysis of the feature
 *
 * <h2>2. Use Case/Feature: IPC04.1</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-60">LPFOURDG-60</a>
 *
 * <h2>3. Requirement</h2>
 * -The responsibility that was assignedto me, was to resolve the feature of
 * import/export/sharing a text file.-
 *
 * <p>
 * <b>Use Case "Import/Export Text":</b> A sidebar window that provides
 * functionalities for importing/exporting/sharing a text fiel. Each line of
 * this file should be separeted by a special character. The user may choose if
 * the first line of the file is a header or not. He can choose the cells where
 * the content is displayed.
 *
 *
 * <h2>4. Analysis</h2>
 * This feature will be supported in a new extension. The connection between the
 * instances will be similar to the share cells feature.
 * <h3>Import File and Send</h3>
 * The user selects the file, choooses the special character to use as a column
 * separator, if the first line is an header or not and the cells to add the
 * file text. The system gets the information and add the text to the cells. The
 * user selects "Send" option. The system gets the other available instances in
 * the local network, and presents them in a sidebar window. The user selects
 * which instance to send the cells to, and activates the sending. The system
 * gets the selected cells, and sends them to the targeted instance. The system
 * notifies the user that the cells were sent.
 *
 * <h3>Receive Cells and Export File</h3>
 * The user selects "Receive" option and the cells to add the text. The system
 * waits for the cells being sent in the local network. After receiving the
 * cells, the system checks if checks if the received cells are located on an
 * address that already has existing cells. If so, then the system asks the user
 * for permission to change the original cells with the new ones. Otherwise, the
 * system just changes them. The system notifies the user that the cells were
 * changed. The user selects the path to export the file. System exports the
 * file to the wanted path.
 *
 * <h3>First "analysis" sequence diagram</h3>
 *
 *  * <h4>Import file and Send Content proposal analysis</h4>
 * <p>
 * <img src="doc-files/import_file_send_image.png" alt="image">
 *
 * <h4>Receive Content and Export File proposal analysis</h4>
 * <p>
 * <img src="doc-files/receive_export_file_image.png" alt="image">
 * <p>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * The core of communication is expected to communicate in udp and tcp protocols
 * connections.
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * <p>
 *
 * <p>
 * see: <code>csheets.domain.EventTest</code>
 * <p>
 * Agenda has no information at this point. From our view of the requirements
 * there is no business rule to apply on this concept.
 * <p>
 * Event MUST have a time and a description. So we have created a test that
 * represents this business rule.
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.style</code> we can find examples that illustrate how to
 * implement these technical requirements. The following diagrams illustrate
 * core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical
 * documentation the elements depicted in these design diagrams exist in the
 * code!
 * </p>
 * <h3>5.3. Classes</h3>
 *
 * <h3>Class Diagram of the feature</h3>
 * <p>
 * <img src="doc-files/crm01_01_design_class_diagram.png" alt="image">
 * </p>
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 * <p>
 *  * In this issue we used some design patterns: -Persistence layer as an
 * abstraction for the domain or application layer. -Entity, AggregateRoot and
 * value object DDD concepts.
 * </p>
 * <h2>6. Implementation</h2>
 *
 *
 * <code>csheets.domain.Contact</code> <code>csheets.domain.Agenda</code>
 * <code>csheets.domain.Event</code>
 *
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/persistence/package-summary.html">csheets.ext.comments</a>
 *
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * We are in the first week where the workflow of the project is a little bit
 * different from the rest of the weeks. Our functional area is very independent
 * from the others. The only that we had to talk with our work collegues was
 * related to the extensions part (Core functional area).
 *
 * <h2>8. Final Remarks</h2>
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * <b>Sunday</b>
 * Analysis of the feature.
 * </p>
 *
 * <p>
 * <b>Monday</b>
 * </p>
 * 1. Meeting with our supervisor and decided who were the Aea Leaders as well
 * who was going to be Scrum Master.
 * <p>
 * Blocking:
 * </p>
 * 1. Nothing.
 * <p>
 * <b>Tuesday</b>
 * </p>
 * <p>
 * <b>Wednesday</b>
 * <p>
 * <p>
 * 1. Nothing.
 *
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * 3- bom: os testes cobrem uma parte significativa das funcionalidades (ex:
 * mais de 50%) e apresentam código que para além de não ir contra a arquitetura
 * do cleansheets segue ainda as boas práticas da área técnica (ex:
 * sincronização, padrões de eapli, etc.)
 * <p>
 * <b>Evidences:</b>
 * </p>
 * - url of commit: ... - description: this commit is related to the
 * implementation of the design pattern ...-
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * /**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Rui Bastos
 */
package csheets.worklog.n1140491.sprint1;
