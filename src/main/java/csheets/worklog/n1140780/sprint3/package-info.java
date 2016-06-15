/**
 * Technical documentation regarding the work of the team member (1140780) Ruben
 * Teixeira during week2.
 *
 * <p>
 * <b>Scrum Master:</b> no
 *
 * <p>
 * <b>Area Leader:</b> no
 *
 * <h2>1. Notes</h2>
 *
 *
 *
 * <h2>2. Use Case/Feature: IPC03.2 - Search in the Network</h2>
 *
 * <b>Issue in Jira:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-58">LPFOURDG-58</a></p>
 * <b>Sub-tasks:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-274">Analysis</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-275">Design</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-276">Tests</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-277">Implementation</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-273">Worklog</a></p>
 *
 *
 * <h2>3. Requirement</h2>
 * <p>
 * It should be possible to broadcast a workbook search request to all the
 * instances of Cleansheets in the same local network. The search should only
 * include the workbooks that are open. Cleansheets should have a sidebar window
 * to display - in a list - the results of the search. This window should be
 * updated as replies as received. The list of results should include the
 * identification of the instance where the workbook was found, the name of the
 * workbook and a summary of the contents of the workbook.</p>
 *
 * <p>
 * <b>Use Case 1 - "Search networked instances for workbook pattern":</b> The
 * user enters a regular expression on a textbox, then presses a button to start
 * the search. The system will then display for each instance in the network
 * that have matching workbook's, its identification as well as a preview of the
 * first non-empty cells.</p>
 *
 *
 * <h2>4. Analysis</h2>
 * <p>
 * After analysis of the current implementation, it was found that this feature
 * is implemented following this class diagram design:</p>
 * <p>
 * <img src="doc-files/ipc_03.2_extension_image1.png" alt="Class Diagram"></p>
 *
 * <p>
 * After <code>WorkbookSearchExtension</code> is dinamycally loaded (load flow
 * control analysed in the last sprint, see: see:
 * <a href="../sprint2/package-summary.html">4. Analysis</a></p> ), it will
 * return to the UI the <code>UIExtensionWorkbookSearch</code> which in turn
 * returns a <code>WorkbookSearchMenu</code> that contains a
 * <code>JMenuItem</code> associated with the <code>WorkbookSearchAction</code>,
 * the latter being the responsible for starting the flow of the Use Case.</p>
 *
 * <b>WorkbookSearchExtension Class:</b>
 * <p>
 * Returns the main UI for this extension.</p>
 *
 * <b>UIExtensionWorkbookSearch Class:</b>
 * <p>
 * Returns the <code>JMenu</code> component added to the main UI.</p>
 *
 * <b>WorkbookSearchMenu Class: </b>
 * <p>
 * The JMenu component added to the main UI.</p>
 *
 * <b>WorkbookSearchAction Class: </b>
 * <p>
 * This Action will be associated with the JMenu component above.</p>
 *
 * <h3>4.1 Current Design</h3>
 *
 * <p>
 * <b>ActionPerformed:</b></p>
 * <p>
 * <img src="doc-files/ipc_03.2_extension_image4.png" alt="Action performed"></p>
 *
 * <p>
 * <b>Since the requirements now specify the need for a Sidebar this will be the
 * updated design:</b></p>
 *
 * <p>
 * <b>Updated diagram of the loading process:</b></p>
 * <p>
 * <img src="doc-files/ipc_03.2_class_diagram_updated.png" alt="CD updated"></p>
 *
 *
 * <p>
 * <b>Search request:</b></p>
 * <p>
 * <img src="doc-files/ipc_03.1_analysis.png" alt="Send Request"></p>
 *
 * <p>
 * <b>For the search request however, re-engineering will be needed as we will
 * now have to request search for all found instances, instead of just the one
 * instance chosen by the User. Aditionally, no input from the client instance
 * user should be necessary until further discussion with the team.</b></p>
 *
 * <p>
 * <b>Updated Search request:</b></p>
 * <p>
 * <img src="doc-files/ipc_03.1_analysis_server_side.png" alt="First Approach SD"></p>
 *
 * <p>
 * <b>This is the first approach to the problem after the analysis, in which the
 * main difference is that all instances found after broadcast and reply
 * received, are then saved in-memory for later request for search.</b></p>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * <p>
 * The core technical problem is mainly how to refresh the UI with search
 * results which should contain instance identification as well as a preview of
 * their matching workbooks.</p>
 * <p>
 * Perhaps this is time for another Data Transfer object... But first, one
 * should take care of the networking flow of this functional increment.</p>
 * <p>
 * <b>UPDATE:</b></p>
 * <p>
 * After further analysis of the current implementation, one may come to the
 * conclusion that the Volt network implementation might not be the most
 * appropriate solution to this application, as an Object Oriented one, as we
 * quickly come to the conclusion that the Volt Interfaces and protocol don't
 * even support the transfer of objects other than String ones.</p>
 * <p>
 * This almost defeats the purpose of using DTO's as serializable and
 * lightweight objects to send through the network.</p>
 * <p>
 * I will suggest to the original main programmer of Volt (Renato Machado) the
 * addition of generic Object transfer support if possible. Nevertheless, the
 * current goal is to make do with what is currently available as time to
 * deliver is of upmost concern.</p>
 *
 * <p>
 * <b>UPDATE:</b></p>
 * <p>
 * After consulting with Volt owner who rejected the suggested changes to his
 * implementation I decided to implement <code>ObjectSerialization</code> class
 * with static methods <code>toString()</code> and <code>fromString()</code> in
 * order to accomplish the same objective by serializing the objects into a
 * Base64 string and the other way around on the other end of the network.
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * <p>
 * Currently, there aren't any acceptable tests for the feature. Since testing
 * against network packet trading can be a cumbersome and fail prone task, the
 * plan is to test the code performed by each side of the communication, so the
 * goal is to write down tests for <code>WorkbookDTOAssemblerTest</code> to
 * ensure valid DTO's are created, <code>ObjectSerializationTest</code> for
 * obvious reasons and <code>LocalWorkbookSearchTest</code> to assert searches
 * are correctly performed. These are subject to change.
 * </p>
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <p>
 * The following Diagrams are useful to understand the UC Realization:</p>
 *
 * <p>
 * <b>Main Flow:</b></p>
 * <p>
 * <img src="doc-files/ipc_03.2_sequence_diagram.png" alt="Sequence Diagram Design"></p>
 *
 * <p>
 * <b>UDPService:</b></p>
 * <p>
 * <img src="doc-files/ipc_03.2_udp.png" alt="Sequence Diagram UDP"></p>
 *
 * <p>
 * <b>TCPService:</b></p>
 * <p>
 * <img src="doc-files/ipc_03.2_tcp.png" alt="Sequence Diagram TCP"></p>
 *
 * <h3>5.3. Extension Setup</h3>
 * <p>
 * The Search Extention is loaded as per the following:</p>
 * <p>
 * <img src="doc-files/ipc03.2_extension_load_sd.png" alt="Extension Load"></p>
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p>
 * Singleton Pattern implemented by ExtensionManager.</p>
 * <p>
 * Data Transfer Object implemented by WorkbookDTO.</p>
 * <p>
 * Low Cowpling - High Cohesion.</p>
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * The file containing the extensions name was the only file required to update
 * - extension.props. All other Classes where implemented.</p>
 * <p>
 * see:</p>
 * <p>
 * <a href="../../../../csheets/ext/search/package-summary.html">csheets.ext.search</a></p>
 * <p>
 * <a href="../../../../csheets/ext/search/ui/package-summary.html">csheets.ext.search.ui</a></p>
 * <p>
 * <a href="../../../../csheets/framework/search/package-summary.html">csheets.framework.search</a></p>
 *
 * <p>
 * Commit Evidences:</p>
 *
 * <b>Analysis:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/30579cf346e35642e71fa2edc643e9e7b64e6953">Commit
 * concerning Analysis</a></p>
 *
 * <b>Design:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/changeset/aa9c04974805b955243d24db03128bbe37a30d5f">Commit
 * concerning Design #1</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/changeset/d5d87b1bfd6da7e2f8631fe71b50005ec8d5ffc9">Commit
 * concerning Design #2</a></p>
 *
 * <b>Tests:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/changeset/e65d6a279a51145e5ce49d3f1206adbddaf3a93d">Commit
 * concerning Tests</a></p>
 *
 * <b>Implementation:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/7e0c63311c05ef5e39e1d562e8b52222927b660f">Commit
 * concernation Implementation #1</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/24e3490725066d2a8eeacddb2a319e8a62bacf3d">Commit
 * concernation Implementation #2</a></p>
 *
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * <p>
 * On this sprint i demonstrated my own feature individually and helped prepare
 * the demo for
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-4">Core02.2-
 * Tooltip and User Associated to Comment</a>
 * as well as help final testing of
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-6">Core03.1- Column
 * Sort</a></p>
 *
 * <h2>8. Final Remarks</h2>
 *
 * <p>
 * During the design of this feature i always tried to make sure the next
 * iteration would be the more effortless as possible with small changes to
 * design and/or implementation.</p>
 * <p>
 * It was also implemented the class <code>SearchResultAssembler</code> which
 * for its simplicity is not documented here.</p>
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * <b>Saturday</b>
 * <p>
 * Today:
 * <p>
 * 1. Nothing.
 *
 * <p>
 * <b>Sunday</b>
 * <p>
 * Today:
 * <p>
 * 1. Nothing.
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Today:
 * <p>
 * 1. Analysis.
 *
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Today:
 * <p>
 * 1. Finished Analysis.
 * <p>
 * 2. Started Design and Tests...
 *
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Today:</p>
 * <p>
 * 1. Finished Tests</p>
 * <p>
 * 2. Helped colleague. See Notes on top.
 *
 * <p>
 * <b>Thursday</b>
 * <p>
 * Today:</p>
 * <p>
 * 1. Helped prepare the presentations on my Area</p>
 * <p>
 * 2. Did my presentation</p>
 *
 *
 * <p>
 * <b>Friday</b>
 * <p>
 * Today:</p>
 * <p>
 * 1. Finished this worklog.</p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * This sprint i consider my participation exponetially better as i felt more
 * confortable with the architecture and the new area to work on.
 *
 * <h3>10.1. Design and Implementation</h3>
 *
 * <p>
 * <b>Evidences:</b>
 *
 * <p>
 * Commit Evidences:</p>
 *
 * <b>Analysis:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/30579cf346e35642e71fa2edc643e9e7b64e6953">Commit
 * concerning Analysis</a></p>
 *
 * <b>Design:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/changeset/aa9c04974805b955243d24db03128bbe37a30d5f">Commit
 * concerning Design #1</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/changeset/d5d87b1bfd6da7e2f8631fe71b50005ec8d5ffc9">Commit
 * concerning Design #2</a></p>
 *
 * <b>Tests:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/changeset/e65d6a279a51145e5ce49d3f1206adbddaf3a93d">Commit
 * concerning Tests</a></p>
 *
 * <b>Implementation:</b>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/7e0c63311c05ef5e39e1d562e8b52222927b660f">Commit
 * concernation Implementation #1</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/24e3490725066d2a8eeacddb2a319e8a62bacf3d">Commit
 * concernation Implementation #2</a></p>
 *
 * <h3>10.2. Teamwork:</h3>
 *
 * I believe the teamwork on this sprint was great as i learned a bit more by
 * helping other colleagues.
 *
 * <h3>10.3. Technical Documentation:</h3>
 *
 * <p>
 * I improved my documentation on this sprint as obviously i had more time to
 * prepare it aswell has i didn't had the learning curve associated with the
 * first sprint.</p>
 * <p>
 * This is the final result:</p>
 * <p>
 * <img src="http://i.imgur.com/TGO7a52.png" alt="JPanel Final Result"></p>
 * <p>
 * <img src="http://i.imgur.com/8uMRGXd.png" alt="JPanel Final Result"></p>
 * <p>
 * <img src="http://i.imgur.com/j0ao6vL.png" alt="JPanel Final Result"></p>
 *
 * @author Ruben Teixeita 1140780@isep.ipp.pt
 */
package csheets.worklog.n1140780.sprint3;

/**
 *
 *
 * @author Ruben Teixeira 1140780@isep.ipp.pt
 */
class _Dummy_ {
}
