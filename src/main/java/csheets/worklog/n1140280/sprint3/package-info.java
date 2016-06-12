/**
 * Technical documentation regarding the work of the team member (1140280) António Estêvão during week3.
 *
 *
 *
 * <b>Scrum Master: -(yes/no)- yes</b>
 *
 *
 * <b>Area Leader: -(yes/no)- yes</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.
 * <p>
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: CRM5.2</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-88">LPFOURDG-88</a>
 * <p>
 * Cleansheets should now have a 'special' window to display the agenda of a
 * contact. It should be possible to select the contact from a dropbox. The
 * window should display the agenda of the selected contact. The window should
 * also have a field to enter a date in the format DD-MM-YYYY. The window should
 * display the agenda of the selected contact for the selected day. The window
 * should display the day of the week for the given day. The window should also
 * have two buttons: one to move to the next day and the other to move to the
 * previous day. The window should display in a simple list box the events for
 * the select day (for all the calendars).</p>
 * <h2>3. Requirement</h2>
 * <p>
 * When a contact is selected it shoud be displayed his browsable daily agenda,
 * it should be browsable either be a next and previous button or a by
 * specifying a given date
 * </p>
 *
 *
 * <h2>4. Analysis</h2>
 * <p>
 * Mainly a visual use case, after reading how the code was structured found
 * that most of the owrk was already done, just need to change personViewUI to
 * AgendaUI and display a panel for each even for the given day</p>
 *
 *
 * <h3>Analysis sequence diagram</h3>
 * <p>
 * <img src="doc-files/analysis_CRM_5_2.png" alt="image">
 * <p>
 *
 * From the previous diagram we see that we need to a UI panel with the events
 * of the user
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Main test is to see if the data queries to database are correct
 * For unit tests regarding this is feature are basically to test if the
 * controller returns the correct events given a data and a contact, since this
 * has nothing to change in the domain model most of the testing will be manual,
 * also some unit tests can test if next and previous button are returning the
 * correct date
 * 
 * 
 * <h3>5.2. UC Realization</h3>
 * Uc completed as the design and tests were pointing, main setbacks were:
 * Understanding how to add a new jar to the maven project
 * Understand how to work with jCalendar
 * Understand how to querie the database correcly
 * <code>
 *
 * <h3>Design sequence diagram</h3>
 * <p>
 * <img src="doc-files/design_CRM_5_2.png" alt="image">
 * <p>
 *
 * <h2>6. Implementation</h2>
 *
 * 
 * <h2>9. Work Log</h2>
 *
 * <b>Friday</b>
 * Today
 * <p>
 * 1. Started analysis adn requirements, analysing the use case a learning what
 * code has been done Concluded only controller and Ui methods will be needed,
 * decided to crete a new menu on the extention menu since the requirements ash
 * for a "special" window
 * </p>
 * Blocking:
 * <p>
 * -nothing-
 * </p>
 * <b>Saturday</b>
 * <p>
 * Yesterday I worked on: Analysis
 * </p>
 * Today
 * <p>
 * 1. Stared and finished desiging the new window 
 * 2. Learned about jCalendar and
 * added jar to maven project 
 * 3. Started sprint 3 (Moving tasks from backlog to
 * sprint scope, atributing tasks and start it) 
 * 4. Started tests but had some
 * trouble on how to implement UI and list model tests
 * <p>
 * Blocking:
 * <p>
 * 1. trouble on how to implement UI and list model tests
 *
 * <b>Sunday</b>
 * <p>
 * Uc implementation completed as the design and tests were pointing, main setbacks were:
 * Understand how to work with jCalendar
 * Understand how to querie the database correcly
 * </p>
 * <p>
 * Blocking:
 * 1. How to implement unit test on queries to the database
 * </p>
 * <p>
 * Tomorrow:
 * 1. Ask specialist on how to implement unit test on queries to the database
 * 2. Help all members having problems with their feature
 * </p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * <h3>10.1. Design and Implementation:3</h3>
 * <p>
 * Após a penalizaçao no Sprint 1 por nao tomar uma metodoliga TDD tentei alterar
 * a ordem de trabalho e pensar e implementar os testes antes de começar a implemetaçao do caso de use em si
 * Caso de uso funcional sem bugs detatados 
 * 100% de coverage em metodos de controller a tirar duvidas para ter 100% em todo o codigo á exepção da UI
 * </p>
 * <b>Evidences:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/a1b927d93083c0cd659998bb5e2fea40855698dc">Analysis</a>
 * Commit was sent referencing th wrong issue
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author alexandrebraganca
 */
package csheets.worklog.n1140280.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}