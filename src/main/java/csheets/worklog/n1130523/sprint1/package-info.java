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
 * Basically, for the development and after analysis, we test if the assign for
 * a specidfic cell it works and a method to test if should recognize the
 * Expression as a InstructionBlock and assign the result of the last Expression
 * to result.
 * <p>
 *
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create Class "For" (function), and
 * "Atribution" (operator). It will be necessary to define a better grammar to
 * accept new tokens, and a "for" loop with multiple operations blocks. Also we
 * have create a new Operation to resolve n expressions and validates in
 * function "convert" of class "ExcelExpressionCompiler".
 *
 *
 * <h3>5.3. Classes</h3>
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 *
 * <h2>6. Implementation</h2>
 *
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 *
 * <h2>8. Final Remarks</h2>
 *
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
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Part of Design Lang01.1- Block of Instructions, 2. Analysis update and
 * pair programming
 * <p>
 * Today
 * <p>
 * 1. Part of Design Lang01.1- Block of Instructions.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 *
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
