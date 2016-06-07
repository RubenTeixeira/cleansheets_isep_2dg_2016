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
 * The Analysis of the ExampleExtension facilitates the understanding of this
 * feature and how to implement this new Sort Extension. As seen, the
 * ExtensionManager should load this (and others) Extension(s) and provide them
 * to the UIController. UIController is in charge for managing the Interface and
 * therefore it returns all UIExtensions from their belonging Extensions to the
 * MenuBar. The ExtensionManager is the link all Extensions and Cleansheets
 * application.</p>
 *
 * <b>ExtensionManager Class:</b>
 * <p>
 * Implements the Singleton pattern to guarantee that there is only one instance
 * running on each application. The Class links itself to a File -
 * "extension.props" - that contains the name reference for all available
 * extensions. When loaded the Extensions are saved into a TreeMap associated
 * with a name reference, a String.</p>
 * <p>
 * CleanSheetps dynamically loads, at Runtime, all Extensions that it finds
 * declared in this files: "res/extensions.props" and "entensions.props" by the
 * ExtensionManager. Both this files must contain the name of the Extension -
 * "csheets.ext.sort.SortExtension" for this specific case.</p>
 *
 * <b>SortExtension Class:</b>
 * <p>
 * Therefore, an extension class should be implemented to support cell sorting.
 * The class will extend, as all already implemented extensions, the: Extension
 * class (All Inheritance will be available further on this page).</p>
 *
 * <b>UIController Class: </b>
 * <p>
 * Provide us a crucial Attribute -uiExtensions : UIExtension[]. It will contain
 * all UIExtensions that extend UIExtension Class.</p>
 *
 * <b>UISort Class: </b>
 * <p>
 * Extends UIExtension. The User Interface known by the MenuBar of Sort
 * Extension.</p>
 *
 * <b>SortMenu Class:</b>
 * <p>
 * Represents the User Interface Menu for Sorting.</p>
 *
 * <b>SortAction Class:</b>
 * <p>
 * This Class will perform the Action, set the SortController to update the
 * Cleansheet application.</p>
 *
 * <b>SortController Class:</b>
 * <p>
 * This Class will be implemented to handle sorting. It will contain a method
 * that will perform the actual sorting of the chosen column. No other elements
 * will be required aside from a column : cell[] and specific order.</p>
 *
 * <b>Update on SortController Class after first Implementation:</b>
 * <p>
 * After spending some time with the Design and trying to imagine what would be
 * the best way to promote Low Coupling High Cohesion, I decided to give this
 * class access to UIController and therefore to the active Spreadsheet.</p>
 * <p>
 * The sorting will be performed on an Arraylist of Values. Before the actual
 * sorting occurs all Cells' Values will be added to this Arraylist to
 * facilitate the procedure. After that, the Controller will use this sorted
 * ArrayList to update the current selected column. On a previous version,
 * instead of an ArrayList of values and ArrayList of Strings was being used
 * because of the habit in using the method "getContent()" accessed by the cell
 * itself. The change was made duo to impossibility of ascending or descending
 * correctly. Example: with two Strings, one being "35" and other "4" the "35"
 * would actually be a "smaller" number when asceding.</p>
 *
 * <b>SortJDialog</b>
 * <p>
 * This window will interact with the user to select the column and the sorting
 * order.</p>
 * <p>
 * Window first Draft:</p>
 * <p>
 * <img src="doc-files/Jdialog_box.png" alt="Jdialog_draft"></p>
 *
 *
 * <h3>Class Diagram Analysis</h3>
 * <p>
 * <img src="doc-files/sort_extension_1.png" alt="Class Diagram Analysis"></p>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 * <p>
 * The Core problem lies on the algorithm used to show only the active columns.
 * The only method that already exists and can be helpful in this situation is
 * the "getColumnCount()" provided by the active Spreadsheet accessed by the
 * UIController. Even then, this method returns an int number accountable from
 * the first column to the last "active" column. In a situation where A,B,C
 * columns had cells with content the returned number would be 3 (scenario 1).
 * If only A and C had content the number would be the same(scenario 2). Same as
 * C being the only with content (scenario 3). A possible solution for the 3
 * scenarios above would be to allow the User to select either one of the three
 * columns. So all three cells would be available to select, no matter the
 * scenario. On the other hand the sorting algorithm will only target cells with
 * content so this doesn't represent an actual hard-to-solve problem.</p>
 * <p>
 * There was also the possibility to work with ascII code to operate with the
 * associated decimal, but for now the idea is on hold.</p>
 * <p>
 * Update on current subject:</p>
 * <p>
 * After considering using ascII code I've decided to proceed with this idea.
 * Turns out the solution was quite simple. The implemented code will allow
 * SortJDialog to show to the User all the columns that have content. The user
 * proceeds to select a column. This column references are Char type, this Char
 * will be added to the existing columnComboBox and the selected column index
 * will further be used.</p>
 *
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 * <p>
 * Tests will be performed for Class SortController to check if the order occurs
 * as planned.</p>
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <p>
 * The following Diagrams are useful to understand the UC Realization:</p>
 *
 * <h3>5.3. Extension Setup</h3>
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
 * <h3>5.4. Classes</h3>
 * <p>
 * Everything inside *[expression]* was implemented before JDialog
 * implementation. SortAction was directly connected to SortController</p>
 *
 * <h3>Class Diagram</h3>
 *
 * <p>
 * <img src="doc-files/sort_class_diagram.png" alt="Class Diagram Analysis"></p>
 *
 * <h3>5.5. Design Patterns and Best Practices</h3>
 * <p>
 * Singleton Pattern implemented by ExtensionManager.</p>
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
 * - For loop limiter wasn't valid, that leads to the update of the current
 * class also.</p>
 *
 * <p>
 * Commit Evidences:</p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/3dbf709a0a5f3dc77b3f56d7fb028a66c308db0c">Commit
 * concerning Analysis and Design</a></p>
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/2c5a95e9c69bd0fe2903809e04a3d65be54d9e45">Commit
 * concerning the fix for the bug, and first steps into Implementation</a></p>
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
 * Today:
 * <p>
 * 1. Updated Analysis.
 * <p>
 * 2. Started and mostly finished Design.
 * <p>
 * 3. Started Implementation.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Today:
 * <p>
 * 1. Feature fully available, finished Implementation but will need
 * refactoring.
 * <p>
 * 2. Altered Design, code refactoring was needed and most likely will be needed
 * again. With it, the previous designed and implemented test solution will too
 * need to change.
 * <p>
 * 3. Altered Diagrams according to SortJDialog implementation.
 * <p>
 * 4. Reunion with Product Owner.
 * <p>
 * 5. Reunion with Manager.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
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
