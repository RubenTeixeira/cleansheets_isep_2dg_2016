/**
 * Technical documentation regarding the work of the team member (1140491) Rui
 * Bastos during week4.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: Lang05.1</h2>
 *
 * Issue in Jira: -LPFOURDG-39-
 *
 * <h2>3. Requirement</h2>
 * The new extension should add a menu option to open a window to edit and
 * execute a single macro. Macros should be designed as a complete new language
 * in Cleansheets. However, its initial grammar should be very simple and based
 * on the formulas of Cleansheets. In particular, a macro is simply a sequence
 * of formulas that are executed sequentially. The formulas are the same as
 * those used in the cells. Each line of the macro may contain a formula or be a
 * comment. A comment is a line that starts with the character ";". The lines of
 * the macros must support all that is possible to do with the cell formulas
 * that start with "=" (but in the macros the lines do not need to start the
 * line with "="). The macro is to be associated with the current workbook (but,
 * for the moment, it is not required to persist the macro). The result of
 * executing a macro is the result of the last executed instruction. The new
 * window should have an area to edit the text of the macro and button to run
 * the macro. The result of the execution of the macro should also appear in the
 * window.
 *
 * <p>
 * <b>Use Case "Macro Window":</b> The user opens the macro window. The system
 * prints an example of the macro. The user writes is macro and runs it. The
 * system validates it and executes it.
 *
 *
 * <h2>4. Analysis</h2>
 * To do this use case i will use the side bar created by my colleague Rui
 * Bento. To complete this feature we will need to understand how to adapte de
 * formulas of Cleansheets in order to create the macros.
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
 * <img src="doc-files/macro_window_extension_uc_realization.png" alt="image">
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * It's my responsability to create a new language: Macros. I must create it
 * using the already existing formulas. I will check all the functions of
 * Cleansheets and adapt them. Therefore, we will start to implement tests for
 * this use case, testing the Macros.
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to create and execute macros. We need to
 * check each line of the code and validate them. So i will do tests to validate
 * and to not validate. As usual, in a test driven development approach tests
 * normally fail in the beginning. The idea is that the tests will pass in the
 * end.
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the window we need to
 * implement a JDialog. The code of the extension will be in
 * <code>csheets.ext.macro_beanshell</code> package. The following diagrams
 * illustrate core aspects of the design of the solution for this use case.
 *
 * <h3>Use Case Sequence Diagram</h3>
 * The following diagram shows the steps needed for this use case. My colleague
 * Rui Bento has made a feature that follows the same steps as this. After
 * studying is code and design, i thougth that would make sense if i followed is
 * diagram, not only because it makes sense, but to keep the app cohesive as
 * well.
 * <p>
 * <img src="doc-files/macro_window_extension_design.png" alt="image">
 *
 *
 * <h3>5.3. Classes</h3>
 *
 * This class diagram shows all the classes used and there relations.
 * <img src="doc-files/macro_window_extension_class_diagram.png" alt="image">
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * -To resolve this use case, i'm using patterns learned in the courses of EAPLI
 * and ESOFT, namely the GRASP and SOLID patterns-
 * <p>
 * -...-
 *
 * <h2>6. Implementation</h2>
 *
 * To resolve this issue, i used the class Macro(already created) and
 * implemented the necessary methods. I created the class
 * MacroExpressionCompiler that is really similar to the
 * FormulaExpressionCompiler but it doesn't work with a referenced cell.
 * Instead, it works with the Spreadsheet. This class uses all the available
 * formulas in CleanSheets. To execute all the instructions, i separated all the
 * instructions by line, compiling them one by one. If it starts with ";", it
 * ignores the instruction because is a comment. If the instruction is not
 * compiled, the method returns an error message.
 *
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/ext/email/package-summary.html">csheets.ext.email</a><p>
 * <a href="../../../../csheets/ext/email/ui/package-summary.html">csheets.ext.email.ui</a>
 *
 * <p>
 * Commit Evidences:</p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/fbe15de453facc60bd0b7e78dc0830755bc013cc">Analysis</a></p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/e0022d44168c7e9246e949aa18bf945685e6c962#chg-src/main/java/csheets/worklog/n1140491/sprint3/email_configuration_extension_class_diagram.puml">Design
 * commit 1</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/e0022d44168c7e9246e949aa18bf945685e6c962#chg-src/main/java/csheets/worklog/n1140491/sprint3/email_configuration_extension_design.puml">Design
 * commit 2</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/a5a84fb20c661307b36e92a8ce95d8cdff25c761">Tests</a></p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/a6ec0a830a2170c64503703d8206c0f3214377e1">Implementation
 * coommit 1</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/6bcfcf9d8b2ab2dff19158071a4611091fd98dea">Implementation
 * commit 2</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/81dcff57e323849e9379020a528136d161c73ebf">Implementation
 * coommit 3</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/45bccc3dd48e13996c717027464e2dc6b9fd5992">Implementation
 * commit 4</a></p>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * On this sprint i demonstrated my own feature individuall.
 *
 * <h2>8. Final Remarks</h2>
 *
 * <p>
 * I tried to make a jdialog with a loading bar while the message was being
 * sent. I tried deifferent approaches but i couldn't finish it. So this may be
 * something to do in the future.
 *
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * <b>Saturday</b>
 * <p>
 * Understanding JavaMail library.
 * <p>
 * <b>Sunday</b>
 * <p>
 * Analisys, design and beggining of user interface implementation
 * <p>
 * <b>Monday</b>
 * <p>
 * Implementation of controller, more user interfaces and unit tests
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Checking if all the features are correct. Updated tests using mock javamail
 * and greenmail
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * Wednesday
 * <p>
 * Helped my co-worker Carlos Mateus in his use case. Made final touches. 1. ...
 *
 * <h2>10. Self Assessment</h2>
 *
 * -I think i worked well during the week. I worked on it during the weekend
 * and, because of that, i was able to finish it earlier..-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 * To resolve this use case, we're using patterns learned in the courses of
 * EAPLI and ESOFT, namely the GRASP and SOLID patterns. All the code is
 * following the design made.
 * <p>
 * <b>Evidences:</b>
 * <p>
 * -
 * https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/a6ec0a830a2170c64503703d8206c0f3214377e1
 * - description: this commit is related to the implementation of the design
 * pattern ...-
 *
 * <h3>10.2. Teamwork: ...</h3>
 * <p>
 * We worked well as a team. We were a 4 element team which made our team work
 * easier.
 *
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 * This was my technical documentation on this sprint. I think that, comparing
 * with the last sprint, this part of the work is way better.
 *
 * @author Rui Bastos
 */
package csheets.worklog.n1140491.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Rui Bastos
 */
class _Dummy_ {
}
