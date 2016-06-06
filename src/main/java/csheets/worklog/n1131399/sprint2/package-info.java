/**
 * Technical documentation regarding the work of the team member (1131399)
 * Marcelo Barroso during week2.
 *
 * <p>
 * <b>Scrum Master: yes</b>
 *
 * <p>
 * <b>Area Leader: yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 *
 * <h2>2. Use Case/Feature: CRM01.2</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-76">LPFOURDG-76
 * CRM01.2- Company Contact</a>
 *
 * <h2>3 Requirement</h2>
 * A contact may also be a company. If a contact is a company then it has a name
 * (no first and no last name). A person contact may now be related to a company
 * contact. A person contact may have also a profession. The profession should
 * be selected from a list. The list of professions should be loaded (and/or
 * updated) from a external xml file or an existing configuration file of
 * Cleansheets. The window for company contacts should display all the person
 * contacts that are related to it. The company window should also have an
 * agenda. The agenda of a company should be read only and display all the
 * events of the individual contacts that are related to it.
 *
 *
 * <h2>4. Analysis</h2>
 * Since contacts will be supported in a new extension to cleansheets we need to
 * study how extensions are loaded by cleansheets and how they work. The first
 * sequence diagram in the section
 * <a href="../../../../overview-summary.html#arranque_da_aplicacao">Application
 * Startup</a> tells us that extensions must be a subclass of the Extension
 * abstract class and need to be registered in special files. The Extension
 * class has a method called getUIExtension that should be implemented and
 * return an instance of a class that is a subclass of UIExtension. In this
 * subclass of UIExtension there is a method (getSideBar) that returns the
 * sidebar for the extension. A sidebar is a JPanel.
 *
 * <p>
 * After understanding how extensions are created, we proceded to our use case
 * analysis. We decided that our sidebar will cover all the possible features
 * for the user (create/edit/remove contacts and events).
 *
 * We control the use case flow by enable or disable sidebar's components and
 * updating other components.
 *
 * The functional area of this use case requires the use of JPA (ORM). To
 * achieve this functionality we use the same framework used in UC EAPLI,
 * allowing the abstraction of persistence layer.
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Basically, for the development and after analysis, we test if the assign for
 * a specidfic cell it works and a method to test if should recognize the
 * Expression as a InstructionBlock and assign the result of the last Expression
 * to result.
 *
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create Class "For" (function), and
 * "Atribution" (operator). It will be necessary to define a better grammar to
 * accept new tokens, and a "for" loop with multiple operations blocks. Also we
 * have create a new Operation to resolve n expressions and validates in
 * function "convert" of class "ExcelExpressionCompiler".
 *
 * <b>Assign Operation Sequence Diagram</b>:
 * <img src="doc-files/lang01.1_design_assign_operator.png" alt="SD">
 *
 * <h3>5.3. Classes</h3>
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p>
 * Implemented Patterns: Low Coupling - High Cohesion.
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * <b>Created Classes</b>: For, Assign, Instruction Block, Ternary Operation,
 * Ternary Operator.
 *
 * <p>
 * <b>Updated Classes/Files</b>: language.props, Formula.g,
 * ExcelExpressionCompiler.
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
 * </p>
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * <b>Monday</b>
 * </p>
 * <p>
 * Cloning of the project, its compilation and first analysis.
 * </p>
 * <p>
 * <b>Tuesday</b>
 * </p>
 * <p>
 * Development of scripts and thinking in design.
 * </p>
 * <p>
 * <b>Wednesday</b>
 * </p>
 * <p>
 * Integration of the notification system and adaptation of grammar.
 * </p>
 * <p>
 * <b>Thursday</b>
 * </p>
 * <p>
 * Fine corrections in the cycle is functional and presentation.
 * </p>
 * <p>
 * <b>Friday</b>
 * </p>
 * <p>
 * Reload Worklog, global planning and finalizing some other obligations of the
 * ScrumMaster as review and finish sprint to start a new one.
 * </p>
 *
 *
 * <h2>10. Self Assessment</h2>
 *
 * During this sprint, my work was mainly of analysis and study of the
 * application architecture.
 *
 * <h3>10.1. Design and Implementation:</h3>
 *
 * <p>
 * <b>Evidences: ...</b>
 * </p>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Marcelo Barroso 1131399
 */
package csheets.worklog.n1131399.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
