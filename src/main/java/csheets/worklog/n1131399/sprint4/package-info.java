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
 * <p>
 * All the work was done as planned. Initially it was necessary to do some
 * refatoring of some use after case, due to the fact they are not fully
 * functional, affecting the performance of my use case. After being done with
 * my feature I've helped to implement CRM02.1 Address Edition, CRM06.3 Tasks,
 * Reminders, Events, IPC 08.1 File Sharing and also discussing Analysis and
 * Design with my teammates of their respective feature.
 * </p>
 *
 *
 * <h2>2. Use Case/Feature: CRM04.3</h2>
 *
 * <b>Issue in Jira:</b>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-65">LPFOURDG-65</a>
 * <b>Sub-tasks:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-322">LPFOURDG-322</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-323">LPFOURDG-323</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-324">LPFOURDG-324</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-325">LPFOURDG-325</a></p>
 *
 * <h2>3. Requirement</h2>
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
 * <h2>4. Analysis</h2>
 * Initially I started by analyzing the Volt framework used throughout the
 * development team and how it would help me in implementing the requested
 * requirement. I analyzed the code so far produced by my colleagues and
 * although it complies with the requirements so far solictiados, this new
 * delivery will not be possible to use, so it is necessary refatoring which
 * already affects the time it is not much to implement the new requirement.
 * With regard to my use case does not raise many questions, and so its
 * implementation after refatoring, more or less quiet. Users can send messages
 * to the rooms, but for this, they must send a message to the "owner" of this
 * room and know who is in it, doing so for the message order for all classroom
 * participants. The "owners of the rooms" will share their public rooms in
 * broadcast with the network.
 *
 * <p>
 * <b>UIExtensionChat Class: </b>
 * <p>
 * Extends UIExtension. The User Interface known by the MenuBar of Find Chat
 * Extension.
 * </p>
 *
 * <b>ChatExtension Class: </b>
 * <p>
 * Therefore, an extension class should be implemented to support chat. The
 * class will extend, as all already implemented extensions, the: Extension
 * class (All Inheritance will be available further on this page).
 * </p>
 *
 * <b>ChatFrame Class: </b>
 * <p>
 * Class responsible for opening chat outside clean
 * </p>
 *
 * <b>ChatPanel Class: </b>
 * <p>
 * Chat panel with online users
 * </p>
 *
 * <b>ChatPanelSingle Class: </b>
 * <p>
 * Each user panel
 * </p>
 *
 * <b>RoomManage Class: </b>
 * <p>
 * Window responsible for creating room
 * </p>
 *
 * <b>RoomPanel Class: </b>
 * <p>
 * SideBar with available rooms
 * </p>
 *
 * <b>RoomPanelSingle Class: </b>
 * <p>
 * Panel with information from a room
 * </p>
 *
 * <b>Tcp Service Class: </b>
 * <p>
 * Class of Service to ensure TCP connections
 * </p>
 *
 * <b>Udp Service Class: </b>
 * <p>
 * Class of Service to ensure UDP connections
 * </p>
 *
 * <b>Chat Controller Class: </b>
 * <p>
 * Class used by the user interface, responsible for ensuring support throughout
 * the use case flow
 * </p>
 *
 * <b>Message: </b>
 * <p>
 * Instantiates that keeps track of an incoming message
 * </p>
 *
 * <b>Room: </b>
 * <p>
 * Instantiates that is a room with their respective data
 * </p>
 *
 * <b>User: </b>
 * <p>
 * Instantiates representing a chat user
 * </p>
 *
 * <b>JpaMessageRepository: </b>
 * <p>
 * Repository messages
 * </p>
 *
 * <b>JpaRoomRepository: </b>
 * <p>
 * Repository rooms
 * </p>
 *
 * <b>JpaUserRepository: </b>
 * <p>
 * Repository users
 * </p>
 *
 * <h2>5. Design</h2>
 *
 * <img src="doc-files/crm04_3_design.png" alt="image">
 *
 * <h3>5.1. Functional Tests</h3>
 * <p>
 * Tests will be performed for Class FindController to check if the order occurs
 * as planned.
 * </p>
 *
 * <h2>6. Implementation</h2>
 * <p>
 *
 * </p>
 *
 * <h2>7. Commit Evidences</h2>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/1265adc504b711d80ba5264d2a428831176ebc87">Commit
 * concerning Analysis</a>
 * </p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/a61dc9568fa13ada67c44bc975cea464a2554f30">Commit
 * concerning Design</a>
 * </p>
 *
 *
 * <h2>8. Work Log</h2>
 *
 * <b>Sunday</b>
 * <p>
 * Analysis of the UC
 * <p>
 *
 * <b>Monday</b>
 * <p>
 * Design of the UC
 * <p>
 * Helping IPC 08.1 File Sharing
 * <p>
 *
 * <b>Tuesday</b>
 * <p>
 * Implementation of the UC
 * <p>
 * <p>
 * Helping IPC 08.1 File Sharing
 * <p>
 *
 * <b>Wednesday</b>
 * <p>
 * Implementation and Testing of the UC
 * <p>
 *
 * <b>Thursday</b>
 * <p>
 * Presentation to the client
 *
 *
 * <h2>9. Self Assessment</h2>
 * <p>
 * All features worked as expected.
 *
 * <h3>9.1. Design and Implementation:</h3>
 *
 * <h3>9.2. Teamwork: ...</h3>
 *
 * <h3>9.3. Technical Documentation: ...</h3>
 *
 * @author Marcelo Barroso
 */
package csheets.worklog.n1131399.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Marcelo Barroso
 */
class _Dummy_ {
}
