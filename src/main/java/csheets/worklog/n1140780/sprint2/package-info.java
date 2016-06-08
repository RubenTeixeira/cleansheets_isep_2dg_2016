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
 * <p>
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature-
 *
 * <h2>2. Use Case/Feature: Core07.1</h2>
 *
 * <b>Issue in Jira:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-18">LPFOURDG-18</a></p>
 * <b>Sub-tasks:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-187">LPFOURDG-187</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-188">LPFOURDG-188</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-189">LPFOURDG-189</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-190">LPFOURDG-190</a></p>
 *
 *
 * <h2>3. Requirement</h2>
 * <p>
 * An extension that adds support for searching the contents of workbooks. - The
 * extension should provide a new sidebar window for searching the contents of
 * the active workbook. The window should be composed of two parts. The first
 * part (upper part of the window) should contain a textbox for the user to
 * enter a regular expression to be the basis for the search. This part should
 * also contain a button to launch the search. The second part (lower part of
 * the window) should be used to display the search results (cell coordinates
 * and value or contents). The search should include no only the content of the
 * cell (i.e., the text entered by the user) but also its value (that could have
 * been calculated by a formula).</p>
 *
 * <p>
 * <b>Use Case 1 - "Search the contents of the active WorkBook":</b> The user
 * enters a regular expression on a textbox, then presses a button to start the
 * search. The system will then display the cell coordinates and content/value
 * of the search results</p>
 *
 * <p>
 * Window first Draft:</p>
 * <p>
 * <img src="http://i.imgur.com/Lij7lsd.png" alt="JPanel_draft"></p>
 *
 * <h2>4. Analysis</h2>
 * <p>
 * The ExtensionManager should load this (and others) Extension(s) and provide
 * them to the UIController. UIController is in charge of managing the Interface
 * and therefore it returns all UIExtensions from their corresponding
 * Extensions. The ExtensionManager is the link to all Extensions and
 * Cleansheets application.</p>
 *
 * <b>ExtensionManager Class:</b>
 * <p>
 * Implements the Singleton pattern to guarantee that there is only one instance
 * running on each application. The Class links itself to a File -
 * "extension.props" - that contains the name reference for all available
 * extensions. When loaded the Extensions are saved into a TreeMap associated
 * with a name reference, a String.</p>
 * <p>
 * CleanSheets dynamically loads, at Runtime, all Extensions that
 * ExtensionManager finds declared in this file: "res/extensions.props". For
 * this specific case "csheets.ext.search.SearchExtension" was added.</p>
 *
 * <b>SearchExtension Class:</b>
 * <p>
 * An extension class should be implemented to support WorkBook search. The
 * class will extend, as all already implemented extensions, the: Extension
 * class.</p>
 *
 * <b>UIController Class: </b>
 * <p>
 * Provide us a crucial Attribute -uiExtensions : UIExtension[]. It will contain
 * all UIExtensions that extend UIExtension Class.</p>
 *
 * <b>UISearch Class: </b>
 * <p>
 * Extends UIExtension. Will provide the needed graphical components, including
 * the sidebar containing the actual functionalitys.</p>
 *
 *
 * <b>SearchController Class:</b>
 * <p>
 * This Class will be implemented to handle searching. It will contain a method
 * that will perform the search.</p>
 *
 * <b>SearchPanel Class:</b>
 * <p>
 * The actual panel that will be added as sidebar which contains the search box,
 * search button and results list.</p>
 *
 * <b>SearchresultDTO Class:</b>
 * <p>
 * This is the Data Transfer Object which will serve as the translation of core
 * objects to UI specific implementation. Thought for future iterations of this
 * feature.</p>
 *
 * <b>SearchresultAssembler Class:</b>
 * <p>
 * The translator. Should serve as good point to rearrange the way the results
 * are displayed (arranged by sheet/workbook etc)</p>
 *
 * <b>WorkBookSearch Class:</b>
 * <p>
 * This class is responsible for the search behaviour. Any enhancements to the
 * feature with respect to the search logic should be made here.</p>
 *
 * <h3>Class Diagram</h3>
 * <p>
 * <img src="doc-files/search_extension_image1.png" alt="Class Diagram"></p>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * <p>
 * The core problem is mainly the way the resulting information should be
 * presented. The goal, at first, was to aggregate each result on the
 * corresponding spreadsheet as per the draft shown upwards. That requires
 * either full access to core objects on the UI, or a Data Transfer Object.</p>
 * <p>
 * Although the decision was made to use a DTO, for simplicity and time concerns
 * the results won't be aggregated as of this sprint.</p>
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * <p>
 * Tests will be performed for Class WorkBookSearch to check if the search works
 * as intended.</p>
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <p>
 * The following Diagrams are useful to understand the UC Realization:</p>
 *
 * <h3>5.3. Extension Setup</h3>
 *
 * <p>
 * <img src="doc-files/search_extension_image1.png" alt="Sequence Diagram Design"></p>
 * <p>
 * <img src="doc-files/sort_extension_3.png" alt="Sequence Diagram Design"></p>
 * <p>
 * <img src="doc-files/sort_extension_4.png" alt="Sequence Diagram Design"></p>
 * <p>
 * <img src="doc-files/sort_extension_5.png" alt="Sequence Diagram Design"></p>
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p>
 * Singleton Pattern implemented by ExtensionManager.</p>
 * <p>
 * Data Transfer Object implemented by SearchResultDTO.</p>
 * <p>
 * Patterns promoting Low Cowpling - High Cohesion.</p>
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * The file containing the extensions name was the only file required to update
 * - extension.props. All other Classes where implemented.</p>
 * <p>
 * Also, it was found a <b>bug</b> on SpreadsheetImpl in method getColumn(index)
 * - For loop limiter wasn't valid</p>
 *
 * <p>
 * Commit Evidences:</p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/30579cf346e35642e71fa2edc643e9e7b64e6953">Commit
 * concerning Analysis</a></p>
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
 * -In this section document your contribution and efforts to the integration of
 * your work with the work of the other elements of the team and also your work
 * regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 *
 * <h2>8. Final Remarks</h2>
 *
 * <p>
 * Helped Pedro Gomes reproduce/fix a bug:
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/f0c55e41e41be9debb9cd4cea981d2b64c9c2717">Commit
 * of the fix</a></p>
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
 * 2. Started Design.
 * <p>
 * 3. Started Implementation.
 *
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.</p>
 * <p>
 * Today:</p>
 * <p>
 * 1.</p>
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 * <p>
 * <b>Thursday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.</p>
 * <p>
 * Today:</p>
 * <p>
 * 1.</p>
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 *
 * <p>
 * <b>Friday</b>
 * <p>
 * Yesterday I worked on:</p>
 * <p>
 * 1.</p>
 * <p>
 * Today:</p>
 * <p>
 * 1.</p>
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * <p>
 * - url of commit: - description: this commit is related to the implementation
 * of the design pattern-</p>
 *
 * <h3>10.2. Teamwork:</h3>
 *
 * <h3>10.3. Technical Documentation:</h3>
 *
 * @author Ruben Teixeita 1140780@isep.ipp.pt
 */
package csheets.worklog.n1140780.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Ruben Teixeita 1140780@isep.ipp.pt
 */
class _Dummy_ {
}
