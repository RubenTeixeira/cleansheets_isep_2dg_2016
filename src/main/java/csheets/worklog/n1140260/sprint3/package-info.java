/**
 * Technical documentation regarding the work of the team member (1140260) Diogo
 * Leite during week3.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <b>Area Leader: -(yes/no)- no</b>
 * </p>
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Use Case/Feature: IPC06.2</h2>
 * <p>
 * alterar</p>
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-66">LPFOURDG-66</a>
 * </p>
 * <p>
 * LPFOURDG-66
 *
 * Cleansheets should now have a new sidebar window that displays a real time
 * chart of all incoming and outgoing network traffic. There should be four
 * columns: unsecure incoming; secure incoming; unsecure outgoing; secure
 * outgoing. The chart should automatically adjust the units used:
 * bytes;kilobytes; megabytes and gigabytes. The unit used should be the one
 * that results in a chart that is more adjusted to the size of the window.
 *
 * </p>
 *
 * <h2>3. Requirement</h2>
 *
 * It should be possible to display a real time chart that automatically adjust
 * the units used :bytes; kilobytes; megabytes and gigabytes.
 *
 * <p>
 * <b>Use Case "Network Analizer":</b>
 *
 * The user inputs a message, and chooses between a secure or insecure
 * connection, and finally it sends the message. The other instance should
 * receive a message with the connection chosen from the other instance.In this
 * process a real time chart is automatically updated
 *
 *
 * <h2>4. Analysis</h2>
 *
 *
 * <h4>Analysis diagram:</h4>
 *
 * <img src="doc-files/analysis.png" alt="Analysis">
 *
 * <h3>Network Analizer</h3>
 * <p>
 * We'll use rtcharts that is a lightweight library for plotting data with a
 * high sampling rate in real time.
 * </p>
 * <h4>Analysis diagram:</h4>
 *
 * <img src="doc-files/analysis.png" alt="Analysis">
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>Sequence Diagram:</h3>
 *
 *
 * <p>
 * <strong>Note:</strong> It is also important to note that the Service is
 * abstracted to work with the UDP or TCP protocol, which means that the class
 * represented as the "Service" in the sequence diagram can be either UdpService
 * or TcpService.
 * </p>
 * <p>
 * alterar</p>
 * <img src="doc-files/final_design.png" alt="Final Design">
 *
 * <h3>Tests:</h3>
 * <p>
 * We're displaying a real time chart so,we are going to manually test the
 * network to see expected results.
 * </p>
 *
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * In regards to implementation, most of the feature implementation is done
 * through Volt. Since Volt already supports Channels for Encryption and
 * Decryption and as well as watch who receives and sends messages, the feature
 * is easily implemented.
 *
 *
 * <p>
 * As for displaying a real time char, Volt uses rtcharts
 * </p>
 * <h2>7. Integration/Demonstration</h2>
 *
 * <h2>8. Final Remarks</h2>
 *
 * <h2>9. Work Log</h2>
 *
 * <b>Saturday</b>
 *
 * <p>
 * Reading feature requirements and analysing Volt
 *
 * <p>
 * Blocking :Nothing
 * </p>
 *
 * <h2>10. Self Assessment</h2>
 *
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * The implementation uses Volt, a package developed during the RCOMP course of
 * the current year (2015/2016), which aims to ease the development of
 * communication protocols with a expressive syntax.
 * <p>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Diogo Leite
 */
package csheets.worklog.n1140260.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
