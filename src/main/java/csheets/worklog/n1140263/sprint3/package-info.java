/**
 * Technical documentation regarding the work of the team member (1140263) Joao Martins during week3
 *
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
 * - notas se existiu ajuda aos colegas -
 *
 * <h2>2. Use Case/Feature: Core06.2Forms and variables</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-43">LPFOURDG-43</a>
 * <p>
 * Sub-Task in Jira:
 * <p>
 * Analysis:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-236">LPFOURDG-236</a>
 * <p>
 * Design:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-237">LPFOURDG-237</a>
 * <p>
 * Implementation:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-238">LPFOURDG-238</a>
 * <p>
 * Tests:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-239">LPFOURDG-239</a>
 *
 *
 * <h2>3. Requirement</h2>
 * In order for forms to become useful in formulas or macros it is necessary to
 * associate data with the contents of the visual widgets. The mechanism used
 * for that will be the binding of variables (macros or formulas variables) with
 * the contents of the visual widgets. One simple way to achieve this is by
 * using temporary variables (from macros and formulas). The matching between
 * widgets and variables should be done by associating the ones with the same
 * name. When displaying a form (in the context of a macro or a formula), if the
 * temporary variables with the same name of widgets exist, them they are used
 * to set the content of the widgets. For widgets for which no temporary
 * variables with the same name are found then new temporary variables should be
 * created. The user should be able to change the contents of edit boxes. When
 * closing the form window the contents of the temporary variables should be
 * updated from the contents of the corresponding visual widgets.
 *
 *
 * <h2>4. Analysis</h2>
 * Allow the user to create a form dynamically in it can insert or remove a line
 * with buttons or labels or textfields, which is composed of a name and
 * content. Use temporary variables. It is necessary to associate data with the
 * contents of the visual widgets. The user should be able to change the
 * contents of edit boxes. When closing the form window the contents of the
 * temporary variables should be updated from the contents of the corresponding
 * visual widgets.
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 * <img src="doc-files/forms_editor_analysis" alt="SD">
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
 * <img src="doc-files/forms_editor_2_design.png" alt="image">
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
package csheets.worklog.n1140263.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author joao martins
 */
class _Dummy_ {
}
