/**
 * Technical documentation regarding the work of the team member (1140280) António Estêvão during week4.
 *
 *
 *
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 *
 * <b>Area Leader: -(yes/no)- no</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.
 *
 * <h2>2. Use Case/Feature: IPC04.3</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-88">LPFOURDG-88</a>
 * <p>
 * It should be possible to export and import data to/from a table in a
 * database. Each row in the table corresponds to a row in Cleansheets and each
 * column in the table corresponds to a column in Cleansheets. The user should
 * enter a range of cells to be used as source (export) or destination (import)
 * for the operation. The first row of the range should be treated as a header.
 * Each column in the first row is used as the name of the corresponding
 * database column. This feature should be based in jdbc (Java Database
 * Connectivity). The user should specify a database connection to be used and
 * the name of the table.</p>
 * <h2>3. Requirement</h2>
 * <p>
 * Given a range of cells it should be possible to export those data into a
 * database base connection or import form a database to the selectede cells
 * </p>
 *
 * <h2>4. Analysis</h2>
 * Learning about JDBC and ODBC and how to connect and create tables on
 * databases using it
 * <p>
 * During the first analysis some questions were raised to be asked in monday:
 * <p>
 * Should the user be able to specify the database driver?</p>
 * Yes it should
 * <p>
 * Can the user choose a non existent file to export to?</p>
 * No and it should return error
 * <p>
 * Should JPA be used in the use case?</p>
 * No it is not apropriatte
 * <p>
 * A class to interact with new tables on different databases should be stored
 * in persistence? No, different package
 * </p>
 * </p>
 * After the questions were solved anylisis is complete and going for design
 * <h3>Analysis sequence diagram</h3>
 * <p>
 * </p>
 *
 * <h2>5. Design</h2>
 *
 * <h3>Design sequence diagram</h3>
 * <p>
 * </p>
 *
 * <h3>5.1. Functional Tests</h3>
 * <p>
 * Unit testing should be mostly be on importing and exporting:
 * <p>
 * 1. Export and import a 4x4 matrix to ensure basic export and import are
 * working </p>
 * <p>
 * 2. Export and import a non selected cell to ensure the returned matriz is
 * from A1-Z25</p>
 * <p>
 * 3. Export and import a matrix having all cells content to ensure all values
 * are being saved correclty</p>
 * <p>
 * 4. Export to a invalid database connection and ensure an error is
 * returning</p>
 * <p>
 * 5. Import to a invalid database connection and ensure an error is
 * returning</p>
 * <p>
 * 6. Import to a non existent table and ensure an error is returning</p>
 * <p>
 * 7. Export to a already exixting table and ensure an error is returning</p>
 * </p>
 *
 * <h3>5.2. UC Realization</h3>
 *
 *
 * <h2>6. Implementation</h2>
 *
 *
 *
 * <h2>9. Work Log</h2>
 *
 * <b>Sunday</b>
 * <p>
 * Start analysis and worklog updates, some questions were raised to be asked
 * tomorrow
 * </p>
 * <p>
 * Blocking: Answer to the questions to be asked
 * </p>
 * <p>
 * Tomorrow: Maybe start implementing UI which does not require the awnsers
 * </p>
 * <b>Monday</b>
 * <p>
 * Morning: Started by implementing the parts o the UI which dont need anwsers
 * to be asked in th afternoon Started test planning
 * </p>
 * <p>
 * Afternoon: Got all analysis questions anwsered and did design
 * </p>
 * <p>
 * Tomorrow: Finish test planing and test implementation, probably also starting
 * implementation
 * <b>Tuesday</b>
 * <p>
 * </p>
 * <p>
 * Tomorrow:
 * <b>Wednsday</b>
 * <p>
 * </p>
 * <p>
 * Tomorrow:
 * </p>
 * <b>Wednsday</b>
 * <p>
 * </p>
 *
 * <h2>10. Self Assessment</h2>
 *
 * <h3>10.1. Design and Implementation:</h3>
 * <p>
 * </p>
 * <b>Evidences:</b>
 *
 * <p>
 * </p>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author AB-1140280
 */
package csheets.worklog.n1140280.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author AB-1140280
 */
class _Dummy_ {
}
