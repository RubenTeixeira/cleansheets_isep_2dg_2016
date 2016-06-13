/**
 * Technical documentation regarding the work of the team member (1140364) José
 * Barros during week3.
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
 * <h2>2. Use Case/Feature: Lang07.2</h2>
 *
 * <b>Issue in Jira:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-46">LPFOURDG-46</a></p>
 * <b>Sub-tasks:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-224">LPFOURDG-224</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-225">LPFOURDG-225</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-226">LPFOURDG-226</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-227">LPFOURDG-227</a></p>
 *
 *
 * <h2>3. Requirement</h2>
 * <p>
 * The scripting language BeanShell should be integrated in Cleansheets. The
 * idea is that BeanShell and Macros will be two possible mechanisms that
 * Cleansheets will provide for facilitate its customization by end users. This
 * feature is to be integrated with the Macros feature.</p>
 *
 * <p>
 * <b>Use Case 2 - "BeanShell Integration":</b> It should now be possible to
 * invoke Beanshell scripts from macros and formulas using a new function. The
 * new function should be able to execute Beanshell scripts synchronously or
 * asynchronously. If the execution mode is synchronous, then the function
 * should wait for the script to end its execution. In this case the return
 * value of the function should be the value of the last expression of the
 * Beanshell script. If the execution mode is asynchronous then the function
 * should return immediately after launching the execution of the script: the
 * script and the formula/macro will execute in parallel. Existing variables in
 * the macro or formula that executes the script should be accessible inside the
 * Beanshell script.</p>
 *
 *
 * <h2>4. Analysis</h2>
 * Analysis description...
 *
 * <h3>First Analysis sequence diagram</h3>
 *
 * <h3>#</h3>
 * Step description...
 *
 * <p>
 * <img src="#" alt="image">
 *
 *
 * <h3>Analysis of Core Technical Problem</h3>
 *
 * <h2>5. Design</h2>
 * ...
 *
 * <h3>5.1. Functional Tests</h3>
 * Test description...
 *
 * <p>
 * see: <code>#</code>
 * </p>
 *
 * <h3>5.2. UC Realization</h3>
 * UC Realization description...
 *
 * <h3>5.3. Classes</h3>
 * ...
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance,
 * database models or updates to the domain model-
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
 * 1. Analysis use case and design.</p>
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 *
 *
 * <p>
 * <b>Sunday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Analysis use case and design.</p>
 * <p>
 * Today:
 * <p>
 * 1. Update UI's</p>
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 *
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1. Update UI's</p>
 * <p>
 * Today:
 * <p>
 * 1. Creates a Script manager. UC implementation.</p>
 * <p>
 * Blocking:
 * <p>
 * 1. Nothing
 *
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesterday I worked on:
 * <p>
 * 1.</p>
 * <p>
 * Today:
 * <p>
 * 1.</p>
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
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * </p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/3d337176f5a593fd0ce47b731f73f50268650898">Script
 * Manager UI created</a></p>
 *
 * <p>
 * <a href="https://bitbucket.org/lei-isep/lapr4-2016-2dg/commits/b4359804da29e3115c99d1a20449587721923665">Integration
 * of scripts from formulas</a></p>
 *
 * <h3>10.2. Teamwork:</h3>
 *
 * <h3>10.3. Technical Documentation:</h3>
 *
 * @author José Barros 1140364@isep.ipp.pt
 */
package csheets.worklog.n1140364.sprint3;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author José Barros 1140364@isep.ipp.pt
 */
class _Dummy_ {
}
