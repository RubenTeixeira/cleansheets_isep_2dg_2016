/**
 * Technical documentation regarding the work of the team member (1140260) Diogo
 * Leite during week4.
 *
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <b>Area Leader: -(yes/no)- no</b>
 * </p>
 *
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Use Case/Feature: core08.1</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-21">LPFOURDG-21</a>
 *
 * <p>
 * Sub-Task in Jira:
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-333">LPFOURDG-333</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-332">LPFOURDG-332</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-331">LPFOURDG-331</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-330">LPFOURDG-330</a>
 *
 * <h2>3.1 Requirement for Export PDF of Worksheet</h2>
 * It should be possible to export to PDF an entire workbook, a worksheet or a
 * range of cells. The contents should include only the values of the cells (and
 * not its formulas, for instance). The user should be able to select the
 * content to be exported and also if the document should have a table of
 * contents with links to the sections or not. If select, sections/chapters
 * should be generated for each worksheet of the workbook.
 *
 *
 *
 * <p>
 * <b>Use Case 1 - "Export the contents of an workbook to PDF file":</b>
 * <p>
 * The user inserts all values in the cells and selects File-ExportPDF, defines
 * content like workbook,assign file title and save it.
 *
 * <p>
 * <b>Use Case 2 - "Export the contents of an Worksheet to PDF file":</b>
 * <p>
 * The user inserts all values in the cells and selects File-ExportPDF, defines
 * the worksheet to save assign file title and save it.
 *
 * <p>
 * <b>Use Case 3 - "Export range of cells to an PDF file":</b>
 * <p>
 * The user inserts all values in the cells and selects File-ExportPDF, selects
 * cells to export, the worksheet to save , assign file title and save it.
 *
 * <h2>4.2 Analysis - Export PDF</h2>
 * The user can choose one of this options: Export the contents of an workbook
 * to PDF file, Export the contents of an Worksheet to PDF file and Export range
 * of cells to an PDF file.
 *
 *
 * <h3> First "analysis" sequence diagram - Export XML of Worksheetk</h3>
 *
 * <p>
 * <img src="doc-files/core08.1_Export_pdf_sd_analysis.png" alt="image">
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * Basically, for the development and after analysis, we test if the content of
 * the cells of pdf file it´s correct for each column and row.These tests were
 * commented because the build in Jenkins faild when I send that commit into the
 * bitbucket.
 *
 * <h3>5.2. UC Realization</h3>
 *
 * I have to use iText Library .I have create 3 methods on class ExportPDF:
 * writeWorkbook - Export the contents of an Workbook to PDF file;
 * writeSelectedCells - Export range of cells of an worksheet to an PDF file;
 * writeSpreadsheet - Export PDF of Spreadsheet; It´s necessary to create a
 * class ExportPDFAction and ExportPDFController to call all methods to export.
 * Will be using a FileChooser to choose the type of file
 *
 *
 * *
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
 * <b>Use Case 1 - "Export the contents of an workbook to PDF file"</b>
 *
 * <img src="doc-files/core08.1_Export_pdf_sd_design_1.png" alt="Export_pdf_sd_design_1">
 *
 * <p>
 * <b>Use Case 2 - "Export the contents of an Worksheet to PDF file"</b>
 *
 * <img src="doc-files/core08.1_Export_pdf_sd_design_2.png" alt="Export_pdf_sd_design_2">
 *
 * <p>
 * <b>Use Case 3 - "Export range of cells of an worksheet to an PDF file"</b>
 *
 * <img src="doc-files/core08.1_Export_pdf_sd_design_3.png" alt="Export_pdf_sd_design_3">
 *
 * <b>Created Classes</b>:
 *
 * <p>
 * PDFCodec, ExportPDFAction, ExportPDFController, ExportPDFPanel
 *
 * <b>Updated Classes/Files</b>:
 *
 * <p>
 * ExportMenu
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
 * <b>Monday</b>
 *
 * <p>
 * Start analysis , design and start implementation
 *
 * <p>
 * Blocking :nothing
 * </p>
 *
 *
 * <b>Tuesday</b>
 *
 * <p>
 * Continue implementation , start unit tests
 *
 * <p>
 * Blocking : nothing
 * </p>
 *
 *
 *
 * <b>Wednesday</b>
 *
 * <p>
 * Ending unit tests and small refractor in implementation
 *
 * <p>
 * Blocking : nothing
 * </p>
 *
 *
 *
 *
 * <b>Thursday</b>
 *
 * <p>
 * todo
 *
 * <p>
 * Blocking :
 * </p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * During this sprint, my work was mainly of analysis and study of the
 * application architecture.
 *
 * <h3>10.1. Design and Implementation:</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * </p>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Diogo Leite
 */
package csheets.worklog.n1140260.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author alexandrebraganca
 */
class _Dummy_ {
}
