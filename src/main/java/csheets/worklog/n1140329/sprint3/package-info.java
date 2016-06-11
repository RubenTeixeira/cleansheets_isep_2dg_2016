/**
 * Technical documentation regarding the work of the team member (1140329) 
 * Rafael Rocha during week3. 
 * 
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 * 
 * <p>
 * <b>Area Leader: -(yes/no)- yes</b>
 * 
 * <h2>1. Notes</h2>
 * 
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work during the week.
 * For instance, if you spend significant time helping a colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: Core07.2</h2>
 * Issue in Jira: <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-19">LPFOURDG-19: Global Search</a>
 * <p>
 * Sub-Tasks in Jira:  <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-228">LPFOURDG-228: Analysis</a>; 
 *                     <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-229">LPFOURDG-229: Design</a>; 
 *                     <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-230">LPFOURDG-230: Tests</a>; 
 *                     <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-231">LPFOURDG-231: Implementation</a>
 * <p>
 * 
 * LPFOURDG-19
 * 
 * The search option should now include all the open workbooks. 
 * The list of search results should be interactive.
 * When the user clicks a line in the search result Cleansheets should change 
 * the focus to the respective cell. It should be possible to configure 
 * the search by selecting the set of type of cells and formulas to include 
 * in the search. For instance, the search could only apply to cells of 
 * type date. The search should now include also text in cell comments 
 * (if selected).
 * 
 * <h2>3. Requirement</h2>
 * The search panel now has to search all opened workbooks. It should also
 * focus on the cell of the selected search result.
 * The search process can now be more specific about what type of values and
 * formulas to search for, and it can also search the text in a cell's comments.
 * 
 * <p>
 * <b>Use Case "Global Search":</b> The user can now specify the type of values
 * to search for and if the search should also include the cells' comments.
 * The system will then display the respective workbook, the cell coordinates,
 * and content/value of the search results. The user can then select one of the 
 * search results so that the system can change the focus to that cell.
 *  
 * <h2>4. Analysis</h2>
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
 * the search tools button, the search button, and the results list.</p>
 * 
 * <b>SearchToolsPanel Class:</b>
 * <p>
 * A helper panel that opens up when the search tools button (in the SearchPanel
 * class) is clicked, which will display a set of check boxes where the user 
 * specifies what type of values to search for, and a toggle button that 
 * indicates if the cells' comments should be included in the search as well.</p>
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
 * <h3>First "analysis" sequence diagram</h3>
 * The following diagram depicts a proposal for the realization of the 
 * previously described use case. We call this diagram an "analysis" use case
 * realization because it functions like a draft that we can do during analysis
 * or early design in order to get a previous approach to the design.
 * For that reason we mark the elements of the diagram with the stereotype
 * "analysis" that states that the element is not a design element and, 
 * therefore, does not exists as such in the code of the application
 * (at least at the moment that this diagram was created).
 * 
 * <h4>Global Search proposal analysis</h4>
 * <p>
 * <img src="doc-files/core07_02_analysis.png" alt="image"> 
 * <p>
 * 
 * From the previous diagram we see that we need to add a new functionality to 
 * the UI and : receiving and searching specific value types, and know if it has
 * to search in a cell's comments aswell.
 * We also need to implement a mouse clicked event for when the user selects a 
 * search result, so that the UI can focus on the respective cell.
 * Therefore, at this point, we need to study how to add this new 
 * functionality to the UI and the WorkbookSearch.
 * These are the core technical problems regarding this issue.
 * 
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * <h3>5.2. UC Realization</h3>
 * To realize this user story we will need to implement 
 * The following diagrams illustrate core aspects of the design of the solution for this use case.
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical documentation the elements depicted in these design diagrams exist in the code!
 * 
 * <h3>User selects to connect to another instance (Automatic Cell Update)</h3>
 * The following diagram shows the setup of the local connection when the user selects to connect to another instance, and how the updates are made.
 * <p>
 * <img src="doc-files/core07_02_design_2.png" alt="image">
 * 
 * <h3>Extension Setup</h3>
 * The following diagram shows the setup of the "share" extension when cleansheets is running.
 * <p>
 * <img src="doc-files/core07_02_design_1.png" alt="image">
 *  
 * <h3>5.3. Classes</h3>
 * <p>
 * <b>Class Diagram</b>
 * 
 * <p>
 * * <b>Sequence Diagrams</b> illustrating the setup of the extension
 * <p>
 * The following sequence diagram illustrates the creation of the share
 * extension. All the extensions are loaded dynamically by the ExtensionManager
 * at application startup.
 * <img src="doc-files/ipc01_2_design_part1.png" alt="image">
 * <img src="doc-files/ipc01_2_design_part2.png" alt="image">
 *
 * <p>
 * The following sequence diagram illustrates the creation of the user interface
 * extension. All the UI extensions are loaded by the UIController at
 * application startup.
 * <img src="doc-files/ipc_extension_image3.png" alt="image">
 *
 * <p>
 * The following sequence diagram illustrates the creation of the menu
 * extension. All the menu extensions are loaded by the MenuBar at application
 * startup.
 * <img src="doc-files/ipc_extension_image4.png" alt="image">
 * <p>
 * <b>Sequence Diagrams</b> illustrating use cases of the extension
 * <p>
 * <img src="doc-files/ipc_extension_image5.png" alt="image">
 *
 * -Document the implementation with class diagrams illustrating the new and the modified classes-
 * 
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * 
 * -Describe new or existing design patterns used in the issue-
 * 
 * Observer: This Pattern is used to notify SharePanel with new instances in local network and received cells.
 * 
 * <h2>6. Implementation</h2>
 * 
 * -Reference the code elements that where updated or added-
 * 
 * -Also refer all other artifacts that are related to the implementation and where used in this issue. As far as possible you should use links to the commits of your work-
 * 
 * <h2>7. Integration/Demonstration</h2>
 * 
 * -In this section document your contribution and efforts to the integration of your work with the work of the other elements of the team and also your work regarding the demonstration (i.e., tests, updating of scripts, etc.)-
 * 
 * <h2>8. Final Remarks</h2>
 * 
 * -In this section present your views regarding alternatives, extra work and future work on the issue.-
 * 
 * 
 * <h2>9. Work Log</h2> 
 * <b>Friday</b>
 * <p>
 * Today
 * <p>
 * 1. Started analysis of IPC07.2
 * <p>
 * 2. Studied the program's code to help with the analysis.
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Saturday</b>
 * <p>
 * Yesterday I worked on: 
 * <p>
 * 1. Started analysis of IPC07.2
 * <p>
 * 2. Studied the program's code to help with the analysis.
 * <p>
 * Today
 * <p>
 * 1. Working on analysis of IPC07.2
 * <p>
 * 2. Working on design of IPC07.2
 * <p>
 * 3. Working on the implementation of IPC07.2
 * <p>
 * Blocking:
 * <p>
 * 1. -nothing-
 * <p>
 * <b>Sunday</b>
 * 
 * <b>Monday</b>

 * <b>Tuesday</b>

 * <b>Wednesday</b>

 * <b>Thursday</b>

 * <b>Friday</b>
 * 
 * <h2>10. Self Assessment</h2> 
 * 
 * <h3>10.1. Design and Implementation: 3</h3>
 * 
 * 3- Good. My Use Case's implementation worked out fine but could be severely improved. 
 * The Unit Tests were scarce because I wasn't really sure how to test a Use Case that was very network dependent (broadcasts and TCP connections).
 * 
 * <b>Evidences:</b>
 * <p>
 * - url of commit: ... - description: this commit is related to the implementation of the design pattern ...-
 * 
 * <h3>10.2. Teamwork: ...</h3>
 * 
 * <h3>10.3. Technical Documentation: ...</h3>
 * 
 * @author Rafael Rocha
 */

package csheets.worklog.n1140329.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this EMPTY package! Do not remove this class!
 * 
 * @author RafaelRocha
 */
class _Dummy_ {}

