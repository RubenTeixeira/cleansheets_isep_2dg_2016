/**
 * Technical documentation regarding the work of the team member (1140423) Renato Machado during week2. 
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
 * <h2>2. Use Case/Feature: IPC06.1</h2>
 * 
 * <p>
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-66">LPFOURDG-66</a>
 * </p>
 * <p>
 * LPFOURDG-66
 * 
 * There should be a new mechanism to add secure communications (encrypted
 * communications) between instances of Cleansheets. It is not required at this
 * moment that the cypher should be 'professional', only that it should not be
 * trivial to break it. It should be possible to establish secure and unsecure
 * communications with other instances. Cleansheets should now have a new window
 * that logs all the incoming and outgoing communications. Therefore, when this
 * window is activated it should be possible to see encrypted and unsecure data
 * being exchanged. For testing purposes it should be possible for the user to
 * send simple text messages either unsecure or encrypted.
 * 
 * </p>
 * 
 * <h2>3. Requirement</h2>
 *
 * It should be possible to secure communications (encrypted messages) between instances of Cleansheets.
 * Users should have the choice to use secure or insecure communications (for testing purposes).
 * 
 * <p>
 * <b>Use Case "Secure Communication":</b>
 * 
 * The user inputs a message, and chooses between a secure or insecure connection, and finally it sends the message.
 * The other instance should receive a message with the connection chosen from the other instance.
 * 
 *  
 * <h2>4. Analysis</h2>
 *
 * <h3>Send a Secure Message</h3>
 * <p>
 * In order to secure a message we'll need to encrypt it. To do so, we'll need to have an application key to help us protect our communication protocols.
 * Generally, this key should be generated randomly (in a production environment) in order to maintain security, but for simplicity purposes we will just pre-define it.
 * </p>
 * <img src="appkey.png" alt="Application Key protecting the CleanSheets instances from attackers">
 * <p>
 * We'll use AES (Advanced Encryption Standard) which is a symmetric encryption algorithm, where we'll use our application key to encrypt our message.
 * On the instance that is receiving our encrypted message, we'll apply the same application key and decrypt our message.
 * </p>
 * <h4>Analysis diagram:</h4>
 * 
 * <img src="doc-files/analysis.png" alt="Analysis">
 * 
 * <h3>Send a insecure message</h3>
 * 
 * This feature is already supported, and was built on the Feature <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-51">IPC01.1</a>.
 * 
 * <h2>5. Design</h2>
 * 
 * <h2>6. Implementation</h2>
 * 
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * <h2>8. Final Remarks</h2>
 *  
 * <h2>9. Work Log</h2> 
 * 
 * <p>04/06/2016</p>
 * <b>Saturday</b>
 * <p>Today</p>
 * <p>Started to plan out Volt new features. Started and completed the first analysis on this feature.</p>
 * <p>Blocking</p>
 * <p>Nothing.</p>
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * Outcome 3 ("Design and Implementation") -> 
 * Outcome 5 ("Teamwork") -> 
 * Outcome 6 ("Technical Documentation") -> 
 *
 * <h3>10.1. Design and Implementation:3</h3>
 * 
 * The implementation uses Volt, a package developed during the RCOMP course of the current year (2015/2016), which aims to ease the development of
 * communication protocols with a expressive syntax. It has some nice features such as Routing (Route cycling on UDP) and automatic management of multiple UDP packets.
 * 
 * <p>
 * <b>Evidences:</b>
 * </p>
 * <p>
 * 
 * </p>
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Renato Machado
 */

package csheets.worklog.n1140423.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author alexandrebraganca
 */
class _Dummy_ {}
