/**
 * Technical documentation regarding the work of the team member (1130303) Rui Freitas during week4.
 *
 * <p>
 * <b>Scrum Master: no</b>
 *
 * <p>
 * <b>Area Leader: no</b>
 *
 * <h2>1. Notes</h2>
 *
 * <h2>2. Use Case/Feature: CRM05.3</h2>
 *
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-89">LPFOURDG-89</a>
 *
 * <h2>3. Requirement</h2>
 * The agenda window should now have a display area divided in 24 slots, one for
 * each hour of the day. Each of the slots should have a small text displaying
 * the hour of the day. The Events should be displayed in a size corresponding
 * to its duration and in the colour of the calendar. It should be possible to
 * select the calendars to display in the window. When double clicking in an
 * event its edit window should appear. It should be possible to switch between
 * this new view and a view that display the events of the day in a simple list
 * (like CRM05.2).
 *
 * <p>
 * <b>Use Case "Advanced Agenda Window":</b>
 *
 *
 * <h2>4. Analysis</h2>
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design. For that
 * reason we mark the elements of the diagram with the stereotype "analysis"
 * that states that the element is not a design element and, therefore, does not
 * exists as such in the code of the application (at least at the moment that
 * this diagram was created).
 * <h4>Send Message proposal analysis</h4>
 * <p>
 * <img src="doc-files/chat_app_analysis_send.png" alt="image">
 *
 * <h4>Receive Message proposal analysis</h4>
 * <p>
 * <img src="doc-files/chat_app_analysis_receive.png" alt="image">
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * The core of communication is expected to communicate in udp and tcp protocols
 * connections.
 * <p>
 * <img src="doc-files/ipc05.2_chat_analysis.png" alt="image">
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * Since this feature uses the network framework already implemented any tests
 * needed to be done are done on that level. For the realization of this use
 * case I only use/call this framework methods.
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to create a subclass of Extension. We
 * will also need to create a subclass of UIExtension. For the sidebar we need
 * to implement a JPanel. In the code of the extension
 * <code>csheets.ext.chatApp</code> we can find examples that illustrate how to
 * implement these technical requirements. The following diagrams illustrate
 * core aspects of the design of the solution for this use case.
 *
 * <h3>Chat send Message</h3>
 * The following diagram shows the setup of the local connection when
 * cleansheets's user select share.
 * <p>
 * <img src="doc-files/ipc05.2_udp_design.png" alt="image">
 *
 *
 * <h3>Receive Message</h3>
 * The following diagram illustrates what happens when a instance of cleansheet
 * receive message.
 * <p>
 * <img src="doc-files/ipc05.2_received_design.png" alt="image">
 *
 * <h3>5.3. Classes</h3>
 * <p>
 * <b>Class Diagram</b>
 * <p>
 * Global Class Diagram
 * <p>
 * <img src="doc-files/ipc05.2_classdiagram.png" alt="image">
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * Used "Service" classes instead of having the controller directly controlling
 * networking related operations.
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * see:
 * <p>
 * <a href="../../../../csheets/ext/chatApp/application/package-summary.html">csheets.ext.chatApp.application</a><p>
 * <a href="../../../../csheets/ext/chatApp/ui/package-summary.html">csheets.ext.chatApp.ui</a><p>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 *
 * <h2>8. Final Remarks</h2>
 *
 *
 * <h2>9. Work Log</h2>
 * <p>
 * <b>Monday</b>
 * <p>
 * Today
 * <p>
 * 1. Analysis of the UC and started asking some explanations to the previous
 * colleague.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Today
 * <p>
 * 1. Started design and testing.
 * <p>
 * Blocking:
 * <p>
 * 1.
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Today
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 * <p>
 * <b>Thursday</b>
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
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * <p>
 * <b>Evidences:</b>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Rui Freitas <1130303@isep.ipp.pt>
 */
package csheets.worklog.n1130303.sprint4;

class _Dummy_ {
}
