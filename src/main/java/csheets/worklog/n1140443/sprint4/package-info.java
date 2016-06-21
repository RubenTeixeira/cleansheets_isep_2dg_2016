/**
 * Technical documentation regarding the work of the team member (1140443) Diogo Azevedo during week 4.
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
    * <h2>2. Use Case/Feature: IPC06.3</h2>
 *
 * Issue in Jira: http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-31
 * <p>
 * LPFOURDG-113 LANG02.2: Global Variables
 *
 * <h2>3. Requirements</h2>
 * Cleansheets should now have a new sidebar window to display information about all the instances of
 *Cleansheets in the same local network. The window should be based on a tree control. The tree should
 *display at the root all instances of Cleansheets. For each instance it should display its resources as
 *branches of the root element corresponding to the instance. The information should include: workbooks
 *and respective worksheets; loaded extensions (if they are active or inactive) and its description and version.
 *This tree should be updated in real time.
 * <h2>4. Analysis</h2>
 First we will be inserting the cleansheets and its elements in the tree, by creating a UdpService which gets all the cleansheets instances in de local network, which updates it each 4 seconds(Real Time in a pratical way, which doesnt cause a drop of the app preformance).Once we got tthe cleansheets, we must transfers its elements to its branches(workbooks,worksheets and its active extensions plus its version and its respective description.
 * <h2>5. Design</h2>
*
 * <h3>5.1. Functional Tests</h3>
 *
 * <h3>5.2. UC Realization</h3>
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
 * </p>
 * 
 * <h2>6. Implementation</h2>
 *
 * 
 * <h2>7. Integration/Demonstration</h2>
 * Has we enter the second week of the project, we start to develop features for
 * the contacts.
 *
 * <h2>8. Final Remarks</h2>
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * Example
 * </p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * </p>
 * 1. -nothing-
 * <p>
 * Today
 * </p>
 * 1. Analysis and Design of the Network Explorer
 * <p>
 * Blocking:
 * </p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis and Design of the Network Explorer
 * </p>
 * Today
 * <p>
 * 
 * </p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 * <b>Wednesday</b>
 * <p>
 * ...
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
 * @author Diogo Azevedo
 */
package csheets.worklog.n1140443.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
