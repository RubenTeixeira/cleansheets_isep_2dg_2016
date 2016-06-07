/**
 * Technical documentation regarding the work of the team member (1140263) Joao Martins during week2
 *
 * <p>
 * <b>Scrum Master: no</b>
 *
 * <p>
 * <b>Area Leader: no</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 * //Notas daquilo que fiz durante a semana (exemplo usado na worklog week1)
 *
 *
 * <h2>2. Use Case/Feature: IPC07.1 - Choose Game and Partner</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-69">LPFOURDG-69</a>
 * <p>
 * Sub-Task in Jira:
 * <p>
 * Analysis:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-124">LPFOURDG-124</a>
 * <p>
 * Design:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-125">LPFOURDG-125</a>
 * Tests:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-126">LPFOURDG-126</a>
 * Implementation:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-127">LPFOURDG-127</a>
 *
 *
 * <h2>3. Requirements</h2>
 * Implement extension to choose game. Establish a connection to play games.
 * List all the users in the local network. Invite/send request to play a game
 * (one of two games - not available). Define the profile of the user - username
 * (username from the system) and photo. Display all the available users to
 * play. User should be able to play more than one game at the same time.
 * Sidebar to display all the active games and all the online users. Should be
 * possible to end a game.
 *
 *
 * <h2>4. Analysis</h2>
 * Some of the requirements are already implemented (week1). I need to
 * use/implement udp/tcp protocols - List all "online" users (UDP) , Send
 * request to an other player TCP etc. It's necessary to implement the user
 * profile requirement. In the sidebar i will put the 2 options of games - the
 * games are not implemented yet in this week - only for demonstration and
 * starting point to my colleagues. To end a game it is necessary to stop the
 * service (connection established between the "online" clients). - (1st
 * analysis of the problem) //changes are comming ...
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. </h3>
 *
 * <b>Sequence Diagram - Get Instance and select/send request to another
 * instance</b>:
 * <img src="doc-files/ip07.1_getInstances.png" alt="SD">
 *
 * <b>Sequence Diagram - Create an extension</b>:
 * <img src=".png" alt="SD">
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
 * <b>Created Classes</b>:
 * <p>
 *
 * <b>Updated Classes/Files</b>:
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
 * <b>Weekend</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Create the worklog for the second week of work. 2. Analyze the problem.
 * <p>
 * Today
 * <p>
 * 1. Did the requirements. 2. Did the analyses. 3. Clarified some doubts of the
 * first analyses with my colleagues.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Did the requirements. 2. Did the analyses. 3. Clarified some doubts of the
 * first analyses with my colleagues.
 * <p>
 * Today
 * <p>
 * 1. Design. 2. Implement the extension.
 * <p>
 * Blocking:
 * <p>
 * 1.nothing.
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:</h3>
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
 * @author joao martins
 */
package csheets.worklog.n1140263.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
