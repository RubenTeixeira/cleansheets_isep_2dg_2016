/**
 * Technical documentation regarding the work of the team member (1140263) Joao Martins during week4
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- yes</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 *
 * <h2>2. Core05.2- Send Email and Outbox</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-13">LPFOURDG-13</a>
 * <p>
 * Sub-Task in Jira:
 * <p>
 * Analysis:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-310">LPFOURDG-310</a>
 * <p>
 * Design:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-312">LPFOURDG-312</a>
 * <p>
 * Implementation:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-314">LPFOURDG-314</a>
 * <p>
 * Tests:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-316">LPFOURDG-316</a>
 *
 *
 * <h2>3. Requirement</h2>
 * Include option to send email. The windows should include at least the fields:
 * destination; subject and body. It should possible to include in the body of
 * the message the contents of a range of cells. Include a new sidebar window
 * that will display the outbox (historical of all send messages). Double clicks
 * a message, its contents should be displayed.
 *
 *
 * <h2>4. Analysis</h2>
 * Take advantage of what was done Core 5.1. Add the option to send email to
 * what Rui Bastos have done last week (test email). "It should possible to
 * include in the body of the message the contents of a range of cells." - it is
 * possible to get the content of a range of cells with: this.cells =
 * this.uiController.focusOwner.getSelectedCells(); I need to create a new
 * sidebar to represent the OUTBOX. Add the feature of "double click".
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 * <img src="doc-files/forms_editor_analysis" alt="SD">
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * It is not possible to test this feature because this is essentially/totally
 * UI. UI does not have tests.
 *
 * <h3>5.2. UC Realization</h3>
 * <img src="doc-files/forms_editor_2_design.png" alt="image">
 *
 * <h3>5.3. Classes</h3>
 *
 * Form; AskContent; ButtonPanel; ButtonWidget; FormEditor; LabelPanel;
 * LabelWidget; SingleLine; TextFieldPanel; TextFieldWidget; (Interface) Widget
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * 1. Test Driven Design. 2. Layers - UI; Controller; Domain
 *
 *
 * <h2>6. Implementation</h2>
 *
 * Creation of the classes of the three types of widgets: the user interface
 * panel and the class with the "actions" - "NameType"Widget.java Interface:
 * Widget with the methods that the "NameType"Widget.java will use to each type.
 * "NameType"Widget.java - toString with the designation and the constructor
 * with the creation of the "NameType"Panel.java to add to the FormEditor
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * Nothing.
 *
 * <h2>8. Final Remarks</h2>
 *
 * The number of supported widget will increase. It is necessary to offer more
 * options widget options to the form (or this 3 types are enough?)
 *
 * <h2>9. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 * <p>
 * Example
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Learn 6.1 Lang implementation.
 * <p>
 * Today
 * <p>
 * 1. Analysis. 2. Think about design.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis. 2. Think about design.
 * <p>
 * Today
 * <p>
 * 1. Design. 2.Tests 3.Implementation
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Design. 2.Tests 3.Implementation
 * <p>
 * Today
 * <p>
 * 1. Tests. 2. Implementation.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
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
 * - url of commit: ... - description: this commit is related to the
 * implementation of the design pattern ...-
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author joao martins
 */
package csheets.worklog.n1140263.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author joao martins
 */
class _Dummy_ {
}
