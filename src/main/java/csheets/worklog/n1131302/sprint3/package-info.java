/**
 * Technical documentation regarding the work of the team member (1131302) Gabriel Sousa during week3.
 *
 * <b>Scrum Master: no</b>
 *
 * <p>
 * <b>Area Leader: No</b>
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Use Case/Feature: Lang04.2</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-37">LPFOURDG-37</a>
 *
 * <h2>3. Requirement</h2>
 * 
 *
 * <p>
 * <b>Insert Function Intermediate Wizard:</b> The wizard window should display an edit box for each parameter of the selected function. 
 * The user should use these edit boxes to enter the values for each parameter of the function. As the user enters the values the wizard should display (in a new region of the window)
 * the result of the execution of the formula or a message explaining the problem. 
 * The function list should now include also the operators as well as the functions that are dynamically loaded from java.lang.Math. 
 * The wizard should be now launched from an icon or button located in the formula bar, between the label of the active cell and the edit box of the formula/value of the current cell.
 * The menu option should be removed.
 *</p>
 *
 * <h2>4. Analysis</h2>
 * <p>
 * The user initiates the process by pressing a button of the formula bar, and not a menu, because this should be removed.  
 * You should see a new window with the user edit boxes for each parameter of the selected function.
 * To the extent that you are entering values in the parameters, it should be updated the result. Or display a message explaining the problem.
 * The result is displayed.
 *</p>
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Tests</h3>
 * <p>
 * 
 * </p>
 * see: <code></code>
 *
 * <p>
 * Agenda has no information at this point. From our view of the requirements
 * there is no business rule to apply on this concept.
 * </p>
 *
 * Event MUST have a time and a description. So we have created a test that
 * represents this business rule.
 *
 * <p>
 * see: <code></code>
 *
 * </p>
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <h3>Use Functions Intermediate Wizard:</h3>
 * <p>
 * <img src="doc-files/lang04_02_design1.png" alt="image">
 * </p>
 * 
 * <h3>5.3. Classes</h3>
 *
 * TODO: class diagram!
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p>
 * In this issue we used some design patterns: -Persistence layer as an
 * abstraction for the domain or application layer. -Entity, AggregateRoot and
 * value object DDD concepts.
 * </p>
 *
 * <h2>6. Implementation</h2>
 *
 * <code>csheets.domain.Contact</code> <code>csheets.domain.Agenda</code>
 * <code>csheets.domain.Event</code>
 *
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 * </p>
 * see:
 * <a href="../../../../csheets/persistence/package-summary.html">csheets.ext.comments</a>
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
 * <b>Monday</b>
 * </p>
 * 1. 
 * <p>
 * Blocking:
 * </p>
 * 1. Nothing.
 * <p>
 * <b>Tuesday</b>
 * <p>
 * 1.
 * <b>Evidences:</b>
 * </p>
 * <b>Wednesday:</b>
 * <p>
 * 1.
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
 *
 * @author Gabriel Sousa
 */
package csheets.worklog.n1131302.sprint3;

class _Dummy_ {
}
