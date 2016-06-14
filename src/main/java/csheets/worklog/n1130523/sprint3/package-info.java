/**
 * Technical documentation regarding the work of the team member (1130523) Ruben
 * Santos during week2.
 *
 * <p>
 * <b>Scrum Master: Antonio Bernardo Curado</b>
 *
 * <p>
 * <b>Area Leader: Antonio Bernardo Curado</b>
 *
 *
 * <h2>1. Notes</h2>
 *
 *
 * <h2>2. Use Case/Feature: CRM01.3- Contacts with Tags</h2>
 *
 * <p>
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-77">LPFOURDG-48</a>
 *
 * <p>
 * Sub-Task in Jira:
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-257">LPFOURDG-161</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-258">LPFOURDG-162</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-259">LPFOURDG-163</a>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-260">LPFOURDG-164</a>
 *
 * <h2>3.1 Contacts with Tags</h2>
 *
 * It should be possible to associated tags to contacts (individual or company
 * contacts. A tag is simple an alphanumeric word. Cleansheets should have a
 * window to search contacts based on tags. The search should be based on
 * regular expressions related to tags. Cleansheets should display the search
 * results in a list. The user may click on an item of the list to edit the
 * corresponding contact. There should also be a window with a list of tags that
 * is automatically sorted (descending) based on the frequency of the tag
 * utilization. The list should display in each line the tag and its frequency.
 *
 *
 * <p>
 * <b>Use Case 1 - "Associated tags to contacts":</b>
 * <p>
 * The user selects option "Associated tags to contacts". The user selects
 * contact and Cleansheets shows a window for add tags to specific contact. The
 * user write tag. A tag is correctly associated the contact and Cleansheets
 * informs success of operation.
 *
 * <p>
 * <b>Use Case 2 - "Edit contact of Specific tag":</b>
 * <p>
 * The user selects option "Edit contact of Specific tag". The user write a
 * specific tag. System shows a list with all contacts with the specific tag.
 * The user edits contact if he wants. The system validates and imforms success
 * of operation.
 *
 *
 *
 *
 * <h2>4.2 Analysis - Contacts with Tags</h2>
 * The user must have the option to associate tags to contacts, edit contact of
 * specific tag. The search should be based on regular expressions related to
 * tags. The window with a list of tags that is automatically sorted
 * (descending) based on the frequency of the tag utilization. The list should
 * display in each line the tag and its frequency.
 *
 *
 * <h3> First "analysis" sequence diagram - Contacts with Tags</h3>
 *
 * <p>
 * <img src="doc-files/crm_contacts_with_tags_analysis_ssd.png" alt="image">
 *
 * <h2>5. Design</h2>
 *
 * <h3>5.1. Functional Tests</h3>
 *
 * TEXT
 *
 *
 * <h3>5.2. UC Realization</h3>
 *
 * TEXT
 *
 *
 * *
 * <h3>5.3. Classes</h3>
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 * <p>
 * TEXT
 *
 * <h2>6. Implementation</h2>
 *
 * <p>
 * <b>Use Case 1 - "Associated tags to contacts"</b>
 *
 * <img src="doc-files/crm_contacts_with_tags_design_sd_1.png" alt="contacts_with_tags_design_sd_1">
 *
 * <p>
 * <b>Use Case 2 - "Edit contact of Specific tag"</b>
 *
 * <img src="doc-files/crm_contacts_with_tags_design_sd_2.png" alt="contacts_with_tags_design_sd_2">
 *
 * <p>
 *
 *
 * <b>Created Classes</b>:
 *
 * <p>
 * TEXT
 *
 * <b>Updated Classes/Files</b>:
 *
 * <p>
 * TEXT
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
 * nothing
 * <p>
 * Today
 * </p>
 * 1. Analysis - CRM01.3- Contacts with Tags, 2. Part of design - CRM01.3-
 * Contacts with Tags
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
 * Implementation commits (links only open in new windows - select option
 * browser to open in new windows) :
 *
 * <p>
 * TEXT
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * @author Ruben Santos
 */
package csheets.worklog.n1130523.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author ruben
 */
class _Dummy_ {
}
