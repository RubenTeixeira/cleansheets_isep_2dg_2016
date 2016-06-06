/**
 * Technical documentation regarding the work of the team member (1130523) Ruben
 * Santos during week1.
 *
 * <p>
 * <b>Scrum Master: no</b>
 *
 * <p>
 * <b>Area Leader: no</b>
 *
 * <h2>1. Notes</h2>
 *
 *
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Use Case/Feature: Lang08.1</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-48">LPFOURDG-48</a>
 * Sub-Task in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-161">LPFOURDG-161</a>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-162">LPFOURDG-162</a>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-163">LPFOURDG-163</a>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-164">LPFOURDG-164</a>
 *
 * <h2>3.1 Requirement for Export XML of Worksheet</h2>
 * It should be possible to export the contents of an worksheet or part of an
 * worksheet to an XML file. As we want to optimize as much as possible the
 * process the solution should not rely on any third party library. Cleansheets
 * should have a window to configure the XML tags to use for each type of
 * element. The export should only include the value of the cells. The export
 * menu option should appear in the File menu.
 *
 *
 * <p>
 * <b>Use Case 1 - "Export XML of Worksheet with default tags":</b> The user
 * inserts all values in the cells and selects File-ExportXML, assign a title to
 * the file and save it.
 *
 * <p>
 * <b>Use Case 2 - "Export XML of Worksheet with different tags":</b>
 * The user inserts all values in the cells, defines the tags to see in XML file
 * and selects File-ExportXML, assign a title to the file and save it.
 *
 * <h2>4.2 Analysis - Export XML of Worksheet</h2>
 * The user must have the option to export the worksheet information to a
 * standard xml file with the defined tags (paper-columns-column-line-cell) or
 * set these tags with the names what the user wants.
 *
 *
 * <h3> First "analysis" sequence diagram - Export XML of Worksheetk</h3>
 *
 * <p>
 * <img src="doc-files/lang08.1_Export_xml_sd_analysis.png" alt="image">
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * Basically, for the development and after analysis, we test if a column index
 * it´s corretly converted for a letter in the xml file...
 *
 *
 * <h3>5.2. UC Realization</h3>
 *
 * For this use case it will be necessary to create a class that implements
 * Extension. Will be using a FileChooser to choose the type of file and the
 * directory where the file will be saved.
 *
 * <b>Assign Operation Sequence Diagram</b>:
 * <img src="doc-files/lang01.1_design_assign_operator.png" alt="SD">
 *
 * <h3>5.3. Classes</h3>
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p>
 * Implemented Patterns: Low Coupling - High Cohesion.
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * <b>Created Classes</b>:
 *
 * <p>
 * <b>Updated Classes/Files</b>:
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
 * <p>
 * As an extra this use case also implements a small cell visual decorator if
 * the cell has a comment. This "feature" is not documented in this page.
 * </p>
 *
 * <h2>9. Work Log</h2>
 *
 * -Insert here a log of you daily work. This is in essence the log of your
 * daily standup meetings.-
 * <p>
 * Example
 * </p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * </p>
 * 1. Analysis of Lang08.1 - Export XML 2. Part of Design Lang08.1 - Export XML
 * <p>
 * Today
 * </p>
 * 1. Design Lang08.1 - Export XML 2. Begin of Implementation
 * <p>
 * Blocking:
 * </p>
 * 1. nothing
 * <p>
 * <b>Tuesday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * TEXT
 * </p>
 * Today
 * <p>
 * TEXT
 * </p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 * <p>
 * <b>Wednesday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * TEXT
 * </p>
 * Today
 * <p>
 * TEXT
 * </p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 * <p>
 * <b>Thursday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * TEXT
 * </p>
 * Today
 * <p>
 * TEXT
 * <p>
 * 1. nothing
 * </p>
 *
 * <p>
 * <b>Friday</b>
 * </p>
 * Yesterday I worked on:
 * <p>
 * TEXT
 * </p>
 * Today
 * <p>
 * TEXT
 * </p>
 * Blocking:
 * <p>
 * 1. nothing
 * </p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * During this sprint, my work was mainly of analysis and study of the
 * application architecture.
 *
 * <h3>10.1. Design and Implementation:</h3>
 *
 * 3- bom: os testes cobrem uma parte significativa das funcionalidades (ex:
 * mais de 50%) e apresentam código que para além de não ir contra a arquitetura
 * do cleansheets segue ainda as boas práticas da área técnica (ex:
 * sincronização, padrões de eapli, etc.)
 * <p>
 * <b>Evidences:</b>
 * </p>
 * - url of commit: ... - description: this commit is related to the
 * implementation of the design pattern ...-
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Ruben Santos
 */
package csheets.worklog.n1130523.sprint2;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author ruben
 */
class _Dummy_ {
}
