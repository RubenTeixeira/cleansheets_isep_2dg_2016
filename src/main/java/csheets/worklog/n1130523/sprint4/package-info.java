/**
 * Technical documentation regarding the work of the team member (1130523) Ruben
 * Santos during week4.
 *
 * <p>
 * <b>Scrum Master: João Martins</b>
 *
 * <p>
 * <b>Area Leader: Rui Bento</b>
 *
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Use Case/Feature: IPC08.1) File Sharing</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-72">LPFOURDG-72</a>
 *
 * <p>
 * Sub-Task in Jira:
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-375">LPFOURDG-375</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-376">LPFOURDG-376</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-377">LPFOURDG-377</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-378">LPFOURDG-378</a>
 *
 * <h2>3.1 IPC08.1) File Sharing</h2>
 *
 * Cleansheets should have a new option to share the files contained in a
 * specific directory. The user should be able to specify the directory to share
 * (output). These files should now be listed on other instances of Cleansheets
 * (in a specific window, for instance, in a sidebar). The list should include
 * the name of the files and its size. It is also required to configure the
 * local directory that will receive the downloaded files (input). The
 * configuration of file sharing should be persistent. For the moment it is not
 * required to implement the download of files, however it is necessary to keep
 * the list of files updated automatically. It is also necessary to update the
 * list of files that where selected for download in the input list. This list
 * should include the name of the file, its size, its source and its status
 * (download in progress, up to date, etc.).
 *
 * <p>
 * <b>Use Case 1 - "Inbox files Reception":</b>
 * <p>
 *
 * The files should now be listed on other instances of Cleansheets (in a
 * specific window, for instance, in a sidebar). The list should include the
 * name of the files and its size. It is also required to configure the local
 * directory that will receive the downloaded files (input). The configuration
 * of file sharing should be persistent.
 *
 *
 * <p>
 * <b>Use Case 2 - "Outbox files Share":</b>
 * <p>
 *
 * Cleansheets should have a new option to share the files contained in a
 * specific directory. The user should be able to specify the directory to share
 * (output). Then the file must be in the outbox with all specific data (name of
 * the file, its size, its source and its status). The configuration of file
 * sharing should be persistent.
 *
 *
 *
 * <h2>4.2 Analysis - IPC08.1) File Sharing</h2>
 *
 *
 * The purpose of this use case is to create an extension that allows you to
 * share files in the same network . You must receive the network port
 * configuration and the location of the folder to share. Another cleansheets
 * program should receive a list of available files and show it . This requires
 * that at least two programs are running simultaneously on the same network .
 * One will be the client and the other the server. The server will start with
 * the selected folder you want to share is listening waiting for the request of
 * a customer. You'll have to tell the customer the amount of files sending.
 * Once you know this value the customer knows how many files will receive. When
 * you finish this process , closes the connection. The list of files updated
 * automatically. It is also necessary to update the list of files that where
 * selected for download in the input list. This list should include the name of
 * the file, its size, its source and its status (download in progress, up to
 * date, etc.).
 *
 *
 * <h3> First "analysis" sequence diagram - IPC08.1) File Sharing</h3>
 *
 * <p>
 * <img src="doc-files/ipc_file_sharing_analysis_ssd.png" alt="image">
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * TEXT
 *
 *
 *
 * <h3>5.2. UC Realization</h3>
 *
 * TEXT
 *
 *
 * <h3>5.3. Classes</h3>
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p>
 * TEXT
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * <b>Use Case 1 - "Inbox files Reception"</b>
 *
 * TEXT
 *
 * <p>
 * <b>Use Case 2 - "Outbox files Share":</b>
 *
 * TEXT
 *
 * <p>
 *
 *
 * <b>Created Classes</b>:
 *
 * <p>
 * TEXT
 *
 * <b>Updated Classes/Files</b>:
 *
 * <p>
 * TEXT
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
 * TEXT
 * </p>
 *
 * <h2>9. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 * <p>
 * Example
 * </p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * </p>
 * nothing
 * <p>
 * Today
 * </p>
 * 1. Analysis - IPC08.1) File Sharing 2. Design - IPC08.1) File Sharing
 * <p>
 * Blocking:
 * </p>
 * 1. nothing
 * <p>
 * <b>Tuesday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis - IPC08.1) File Sharing 2. Design - IPC08.1) File Sharing
 * </p>
 * Today
 * <p>
 * TEXT
 * </p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 * <p>
 * <b>Wednesday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * TEXT
 * </p>
 * Today
 * <p>
 * TEXT Update
 * </p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 * <p>
 * <b>Thursday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * TEXT
 * </p>
 * Today
 * <p>
 * 1. Apresentation of Sprint 3; 2. Worklog Update
 * <p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 * <p>
 * <b>Friday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * TEXT
 * </p>
 * Today
 * <p>
 * TEXT
 * </p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * During this sprint, my work was mainly of analysis and study of the
 * application architecture.
 *
 * <h3>10.1. Design and Implementation:</h3>
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
 * Implementation commits (links only open in new windows - select option
 * browser to open in new windows) :
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/8fc74cac13484fd526d44ed5dfc08c02950054f2">Implementation</a>
 *
 * <p>
 * TEXT
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Ruben Santos
 */
package csheets.worklog.n1130523.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author ruben
 */
class _Dummy_ {
}
