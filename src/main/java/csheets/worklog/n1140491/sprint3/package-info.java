/**
 * Technical documentation regarding the work of the team member (1140491) Rui
 * Bastos during week3.
 *
 * <p>
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
 * <h2>2. Use Case/Feature: Core05.1</h2>
 *
 * Issue in Jira: -LPFOURDG-12-
 * <p>
 *
 * <h2>3. Requirement</h2>
 * The new extension should have a window to setup email. This window should be
 * used to setup the required configurations for email. For instance, the
 * account data and server to be used to send emails. All the configuration data
 * should be saved in a proper file (used to save global data). The window
 * should have a button to send a test email. This test email should get its
 * contents (destination, subject and body) from the contents of specific cells
 * (to be selected when the user select the test email button). The window
 * should display a preview of the email and the result of the test.
 *
 * <p>
 * <b>Use Case "Email Configuration":</b> The user logs with is mail, entering
 * is e-mail, password and server. The system saves the data on a properties
 * file. The user selects the test mail button, selecting the destination,
 * subject and body of the message from the selected cells . The system sends
 * the message and shows a preview to the user.
 *
 *
 * <h2>4. Analysis</h2>
 * A jDialog should be created to ask for the configuration data. Another
 * jDialog should be used to preview the e-mail. To complete this feature we
 * will need to understand how emails are sent and how we can adapte them in our
 * code.
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
 * <p>
 * <img src="doc-files/email_configuration_extension_uc_realization.png" alt="image">
 * <p>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * It is possible to send email in java, using the javamail library. This
 * library allows us to communicate with the smtp protocol easily, almost
 * "abstracting" the problem. We will test this library to understand it better.
 * Therefore, we will start to implement tests for this use case.
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to configure an email. We need to be able
 * to know if the email data is valid. Following this approach we can start by
 * coding a unit test that uses an email account and try to log in it. We
 * created an account to test this. We will also need a test that tells us if
 * the email got sent or not. A simple test can be sending an email from this
 * email account to itself. As usual, in a test driven development approach
 * tests normally fail in the beginning. The idea is that the tests will pass in
 * the end.
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the window we need to
 * implement a JDialog. The code of the extension will be in
 * <code>csheets.ext.email</code> package. The following diagrams illustrate
 * core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical
 * documentation the elements depicted in these design diagrams exist in the
 * code!
 *
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "comments" extension when
 * cleansheets is run.
 * <p>
 * <img src="doc-files/core02_01_design.png" alt="image">
 *
 *
 * <h3>User Selects a Cell</h3>
 * The following diagram illustrates what happens when the user selects a cell.
 * The idea is that when this happens the extension must display in the sidebar
 * the comment of that cell (if it exists).
 * <p>
 * <img src="doc-files/core02_01_design2.png" alt="image">
 *
 * <h3>User Updates the Comment of a Cell</h3>
 * The following diagram illustrates what happens when the user updates the text
 * of the comment of the current cell. To be noticed that this diagram does not
 * depict the actual selection of a cell (that is illustrated in the previous
 * diagram).
 * <p>
 * <img src="doc-files/core02_01_design3.png" alt="image">
 *
 * <h3>5.3. Classes</h3>
 *
 * -Document the implementation with class diagrams illustrating the new and the
 * modified classes-
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
 * commits of your work-
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/ext/comments/package-summary.html">csheets.ext.comments</a><p>
 * <a href="../../../../csheets/ext/comments/ui/package-summary.html">csheets.ext.comments.ui</a>
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
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. -nothing-
 * <p>
 * Today
 * <p>
 * 1. Analysis of the...
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. ...
 * <p>
 * Today
 * <p>
 * 1. ...
 * <p>
 * Blocking:
 * <p>
 * 1. ...
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
 * <p>
 * - url of commit: ... - description: this commit is related to the
 * implementation of the design pattern ...-
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Rui Bastos
 */
package csheets.worklog.n1140491.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Rui Bastos
 */
class _Dummy_ {
}
