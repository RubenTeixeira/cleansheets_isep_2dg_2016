/**
 * Technical documentation regarding the work of the team member (1130383) Pedro
 * Gomes during week2.
 *
 * <p>
 * <b>Scrum Master:</b> no
 *
 * <p>
 * <b>Area Leader:</b> yes
 *
 * <h2>1. Notes</h2>
 *
 * <p>
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature-
 *
 * <h2>2. Use Case/Feature: Core02.1</h2>
 *
 * <b>Issue in Jira:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-6">LPFOURDG-6</a></p>
 * <b>Sub-tasks:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-120">LPFOURDG-120</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-121">LPFOURDG-121</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-122">LPFOURDG-122</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-123">LPFOURDG-123</a></p>
 *
 *
 * <h2>3. Requirement</h2>
 * <p>
 * A new extension to add sort functionalities to Cleansheets - Sort the
 * contents of a column of cells. It should be possible to select the order:
 * ascending or descending. The interaction with the user can be based solely on
 * menu options. It should be possible to sort columns with numeric and/or text
 * contents.</p>
 *
 * <p>
 * <b>Use Case 1 - "Sort Column Ascending/Descending":</b> The user selects the
 * column and what type of sort he wants (ascending/descending). The Extension
 * proceeds to sort the column as required.</p>
 *
 *
 * <h2>4. Analysis</h2>
 * <p>
 * The Analysis of the Example Extension facilitates the understanding on how to
 * implement this new Extension. As seen, the ExtensionManager.Class should load
 * this Extension and provide it to the UiController. The ExtensionManager.Class
 * is in charge of managing the extensions and it's the link between them and
 * the Cleansheets application.</p>
 * <b>ExtensionManager.Class:</b>
 * <p>
 * Implements the Singleton pattern to guarantee that there is only one instance
 * running. The Class links itself to a File - extension.props - that contains
 * the name reference for all available extensions. All loaded Extensions are
 * saved into a TreeMap with the Extensions Itself associated with a name
 * reference (String).</p>
 * <p>
 * CleanSheetps dynamically loads all Extensions that it finds declared in this
 * files: res/extensions.props and entensions.props. Both this files must
 * contain the name of the Extension - csheets.ext.sort.SortExtension</p>
 * <b>SortExtension.Class:</b>
 * <p>
 * Therefore, an extension class should be implemented to support cell sorting.
 * The class will extend, as all already implemented extensions the:
 * <b>Extension.class</b></p>
 * <b>SortExtensionController.Class:</b>
 * <p>
 * This Class will be implemented to handle sorting. It will contain a method
 * that by providing a specific column and a specific order it will sort the
 * Column as required. sortColumnOrder(Cell[] Column, int Order);</p>
 * <p>
 * <b>SortAction.Class:</b>
 * This Class will interact with the actual SpreadSheet.</p>
 * <p>
 * <b>SortExtensionMenu.Class:</b>
 * Represents the User Interface Menu for Sorting.</p>
 *
 * <p>
 * <b>UISortExtension.Class: </b>
 * Extends UIExtension. User Interface Sort Extension.</p>
 * <p>
 * <b>UIController.Class: </b>
 * Has an important Attribute -uiExtensions : UIExtension[]. It will contain all
 * UIExtensions that extend UIExtension.Class.</p>
 *
 *
 *
 * <h3>Class Diagram Analysis</h3>
 * <p>
 * <img src="doc-files/sort_extension_1.png" alt="Class Diagram Analysis"></p>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <p>
 * <img src="doc-files/sort_extension_2.png" alt="Sequence Diagram Design"></p>
 * <p>
 * <img src="doc-files/sort_extension_3.png" alt="Sequence Diagram Design"></p>
 * <p>
 * <img src="doc-files/sort_extension_4.png" alt="Sequence Diagram Design"></p>
 * <p>
 * <img src="doc-files/sort_extension_5.png" alt="Sequence Diagram Design"></p>
 *
 * <h3>5.3. Extension Setup</h3>
 *
 * <h3>5.4. Classes</h3>
 *
 * -Document the implementation with class diagrams illustrating the new and the
 * modified classes-
 *
 * <h3>5.5. Design Patterns and Best Practices</h3>
 * <p>
 * Singleton Pattern implemented by ExtensionManager.</p>
 * <p>
 * Patterns promoting Low Cowpling - High Cohesion.</p>
 *
 * <h2>6. Implementation</h2>
 *
 * -Reference the code elements that where updated or added-
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-</p>
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
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * <b>Saturday</b>
 * <p>
 * Today:
 * <p>
 * 1. Analysis.
 * <p>
 * 2. Design.
 *
 *
 * <p>
 * <b>Sunday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today:
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today:
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.
 * <p>
 * Today:
 * <p>
 * 1.
 * <p>
 * Blocking:
 * <p>
 * 1.
 *
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
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
package csheets.worklog.n1130383.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
class _Dummy_ {
}
