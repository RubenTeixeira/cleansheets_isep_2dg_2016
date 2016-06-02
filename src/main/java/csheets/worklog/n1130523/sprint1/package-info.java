/**
 * Technical documentation regarding the work of the team member (1130523) Ruben
 * Santos during week1.
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
 * <h2>2. Use Case/Feature: Lang01.1</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-27">LPFOURDG-27</a>
 * <p>
 * Sub-Task in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-98">LPFOURDG-98</a>
 * <p>
 * -Include the identification and description of the feature-
 *
 * <h2>3. Requirement</h2>
 * Add the possibility of writing blocks (or sequences) of instructions. A block
 * must be delimited by curly braces and its instructions must be separated by
 * ";". The instructions of a block are executed sequentially and the block
 * "result" is the result of the last statement of the block. For example, the
 * formula "= {1+2; sum (A1:A10), B3 + 4 }" must result in the sequential
 * execution of all expressions and the result is the value of the expression
 * "B3 + 4". Add the assign operator (its symbol is ":="). This operator assigns
 * to its left the result of the right expression. At the moment the left of the
 * assign operator can only be a cell reference. The FOR loop should also be
 * implemented based on instruction blocks.
 *
 * <p>
 * <b>Use Case "Instructions Block":</b>
 * Extend the formulas of Cleansheets.
 *
 * <h2>4. Analysis</h2>
 *
 * For the development of use case "Lang01.1 - Instructions Block", it´s
 * necessary analyze all classes of the project of packages formula. We conluded
 * that is necessary add new tokens "{", "}", ":=", "FOR" and define new rules
 * of grammatics for recognize intructions block and function for. It is
 * necessary create some extra classes. We have to create Class "For"
 * (function), and "Atribution" (operator). In cycle "For", the first expression
 * is the initialization, the second term is the boundary condition, and the
 * third is based on instruction blocks. Also we have create a new Operation to
 * resolve n expressions and validates in function "convert" of class
 * "ExcelExpressionCompiler".
 *
 * <p>
 * <img src="doc-files/lang01.1_Instructions_block_sd_analysis.png" alt="Analysis">
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, from requirements and also analysis, we see that the core
 * functionality of this use case is to be able to add an attribute to cells to
 * be used to store a comment/text. We need to be able to set and get its value.
 * Following this approach we can start by coding a unit test that uses a
 * subclass of <code>CellExtension</code> with a new attribute for user comments
 * with the corresponding method accessors (set and get). A simple test can be
 * to set this attribute with a simple string and to verify if the get method
 * returns the same string. As usual, in a test driven development approach
 * tests normally fail in the beginning. The idea is that the tests will pass in
 * the end.
 * <p>
 * see: <code>csheets.ext.comments.CommentableCellTest</code>
 *
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
 *
 * <h3>User Share selected Cells</h3>
 * The following diagram shows the setup of the local connection when
 * cleansheets's user select share.
 * <p>
 * <img src="doc-files/ipc01_01_design.png" alt="image">
 *
 *
 * <h3>Application display shared cells</h3>
 * The following diagram illustrates what happens when a instance of cleansheet
 * receive shared cells.
 * <p>
 * <img src="doc-files/ipc01_01_design.png" alt="image">
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
 * 1. Read javadoc
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Configure the IDE to start working 2. Read javadoc
 * <p>
 * Today
 * <p>
 * 1. Configure the IDE to start working 2. Analysis Lang01.1- Block of
 * Instructions
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 *
 *
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Configure the IDE to start working 2. Analysis Lang01.1- Block of
 * Instructions
 * <p>
 * Today
 * <p>
 * 1. Part of Design Lang01.1- Block of Instructions, 2. Analysis update and
 * pair programming
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 *
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
 * @author ruben
 */
package csheets.worklog.n1130523.sprint1;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author ruben
 */
class _Dummy_ {
}
