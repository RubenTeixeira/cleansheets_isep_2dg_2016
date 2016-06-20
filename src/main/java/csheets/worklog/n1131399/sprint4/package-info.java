/**
 * Technical documentation regarding the work of the team member (1131399)
 * Marcelo Barroso during week4.
 *
 * <p>
 * <b>Scrum Master: no</b>
 *
 * <p>
 * <b>Area Leader: no</b>
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * This new fucnionalidade is a continuation of what was developed in the third
 * week, will create the concept of rooms, a user creates a public or private
 * room will now be possible, interacting them with users.
 *
 * <h2>2. Use Case/Feature: IPC05.3</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-65">LPFOURDG-65
 * IPC05.3- Chat Rooms</a>
 *
 * <h2>3 Requirements</h2>
 * The chat extension should now support the concept of chat room. A chat room
 * can have several participants. Messages in a chat room are broadcasted to all
 * its members. The user that creates a chat room becomes its owner. There are 2
 * types of rooms: private rooms and public rooms. Public rooms are announced to
 * all instances of Cleansheets and each user is free to become a member of a
 * public room. A private room is not announced in the network. The owner should
 * send invites to other users to participate on the room. Each user is free to
 * accept or reject the invitation. The sidebar should now display also the chat
 * rooms.
 *
 * <h2>4 Analysis</h2>
 * From sprint3 that the chat system is done (UC: IPC05.2). The hardest part to
 * implement in this UC is how to check if a chat user is online or offline. UDP
 * is going to be used to find new chat users and to check if already known
 * users are offline or online. TCP is going to be only used to send and receive
 * messages. Chat profile and chat history is going to be persisted using the
 * already implemented persistence framework.
 *
 * <h2>5. Design</h2>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.style</code> we can find examples that illustrate how to
 * implement these technical requirements. The following diagrams illustrate
 * core aspects of the design of the solution for this use case.
 *
 * <h3>6. Tests</h3>
 *
 * <h2>7. Implementation</h2>
 *
 * <h2>8. Integration/Demonstration</h2>
 *
 * <h2>9. Final Remarks</h2>
 *
 * <h2>10. Work Log</h2>
 *
 * <p>
 * <b>Monday</b>
 * </p>
 * <p>
 * ...
 * </p>
 * <p>
 * <b>Tuesday</b>
 * </p>
 * <p>
 * ...
 * </p>
 * <p>
 * <b>Wednesday</b>
 * </p>
 * <p>
 * ...
 * </p>
 * <p>
 * <b>Thursday</b>
 * </p>
 * <p>
 * ...
 * </p>
 * <p>
 * <b>Friday</b>
 * </p>
 * <p>
 * ...
 * </p>
 *
 *
 * <h2>11. Self Assessment</h2>
 *
 * During this sprint, my work was mainly of analysis and study of the
 * application architecture.
 *
 * <h3>11.1. Design and Implementation:</h3>
 * <b>Evidences: ...</b>
 *
 * <h3>11.2. Teamwork: ...</h3>
 * ...
 *
 * <h3>11.3. Technical Documentation: ...</h3>
 * ...
 *
 * @author Marcelo Barroso 1131399
 */
package csheets.worklog.n1131399.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
