/**
 * Technical documentation regarding the work of the team member (1130980)
 * Rafael Vilar during week4.
 *
 * * <p>
 * <b>-Note: this is a template/example of the individual documentation that
 * each team member must produce each week/sprint. Suggestions on how to build
 * this documentation will appear between '-' like this one. You should remove
 * these suggestions in your own technical documentation-</b>
 * <p>
 * <b>Scrum Master: -(yes/no)- no</b>
 *
 * <p>
 * <b>Area Leader: -(yes/no)- no</b>
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 * This week will be developed the Advanced Forms.
 *
 * <h2>2. Use Case/Feature: IPC07.2</h2>
 *
 * Issue in Jira:
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-44">LPFOURDG-44</a>
 * <p>
 * Sub-Task in Jira:</p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-359">Analysis -
 * LPFOURDG-359</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-360">Design -
 * LPFOURDG-360</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-361">Implementation
 * - LPFOURDG-361</a></p>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-362">Tests -
 * LPFOURDG-362</a></p>
 *
 * <h2>3. Requirement</h2>
 * This feature Advanced Forms is my responsibility.
 *
 * <p>
 * <b>Use Case "Advanced Forms":</b>
 * <p>
 * It should now be possible to create multiple forms for each workbook. Forms
 * should also be persistent with the workbook. To distinguish Forms each one
 * should have a unique name (within its workbook). The function (in macros and
 * formulas) that displays the forms should now have one parameter that is used
 * to pass the name of the form to display (since there can be several forms for
 * each workbook). When displaying a form it should be possible specify if it
 * should be readonly (i.e., it will display the value of the variables but does
 * not allow any update) or writable (in this case the form should allow for the
 * user to modify the values that are displayed). Writable forms should have a
 * new "Update" button. When the user clicks in the update button the form
 * closes and the current values of the widgets update the corresponding
 * variables. If the user closes the form window by any other means the
 * variables should not be updated. It should be also possible to specify the
 * "mode" of the form window (when invoking the display of a form). Two modes
 * are allowed: modal and modeless. A modal form window is a window that will
 * block the macro or formula that call it until the user closes the form
 * window. The macro or formula will only resume execution when the form is
 * closed. A modeless for window is a window that will no block the calling
 * macro or formula, i.e., the macro or formula will continue its execution in
 * parallel with the display of the form. Modeless forms do not return anything.
 * Model forms should return the name of the button that was used to close the
 * window.
 * </p>
 *
 * <h2>4. Analysis</h2>
 * <p>
 * <img src="doc-files/LANG06_3_Analysis_2.png" alt="image">
 * </p>
 * <p>
 * In this feature, the user initiates the Cleansheets application, which will
 * create several forms for the same workbook.
 * </p>
 * <p>
 * To create a new form will have to write the following in a cell:
 * <h3>=FORM(nameForm)</h3></p>
 * <p>
 * The form name is passed as parameter, and a check is made to see if there is
 * some form of the same name, and if it exists, is asked to you a new name.
 * </p>
 * When we show a form should be possible to define whether it is read-only or
 * write.
 * <p>
 * If writing, only when you click the update button is that the new values are
 * assigned to corresponding variables.
 * </p>
 * <p>
 * </p>
 * <p>
 *
 *
 *
 * <h3>Domain Model</h3>
 *
 *
 *
 * <h2>5. Design</h2>
 * <p>
 * <img src="doc-files/ipc07_2_Design.png" alt="image">
 * </p>
 * <h3>5.1. Functional Tests</h3>
 *
 *
 *
 * <h3>5.2. UC Realization</h3>
 *
 * <p>
 * <b>Note:</b> It is very important that in the final version of this technical
 * documentation the elements depicted in these design diagrams exist in the
 * code!
 *
 *
 * <h3>5.4. Design Patterns and Best Practices</h3>
 *
 * -Describe new or existing design patterns used in the issue-
 * <p>
 * -You can also add other artifacts to document the design, for instance,
 * database models or updates to the domain model-
 * </p>
 * <h2>6. Implementation</h2>
 *
 * <code>csheets.ext.game.controllers.GameController</code>
 * <code>csheets.ext.game.controllers.SpecificGameController</code>
 * <code>csheets.ext.game.controllers.TicTacToeController</code>
 * <code>csheets.ext.game.domain.TicTacToe</code>
 * <code>csheets.ext.game.ui.GamePanel</code>
 * <code>csheets.ext.game.ui.TcpService</code>
 * <code>csheets.ext.game.ui.UdpService</code>
 * <code>csheets.ext.game.ui.ListOpponents</code>
 * <code>csheets.ext.game.ui.ProfileOpponent</code>
 * <code>csheets.ext.game.ui.UIGameExtension</code>
 * <code>csheets.ext.game.GameExtension</code>
 *
 * <p>
 * -Also refer all other artifacts that are related to the implementation and
 * where used in this issue. As far as possible you should use links to the
 * commits of your work-
 * </p>
 * see:
 * <p>
 * <a href="../../../../csheets/ext/game/package-summary.html">csheets.ext.comments</a>
 * </p>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * This week my feature was to implement the tictactoe game. This feature
 * belongs to IPC07.2 area and need to implement network communication so that
 * it can be played on two machines over the network.
 *
 * <h2>8. Final Remarks</h2>
 *
 * <h2>9. Work Log</h2>
 *
 * <p>
 * <b>Monday</b>
 * </p>
 * 1. Analysis use case
 * <p>
 * Blocking:
 * </p>
 * 1. Nothing.
 * <p>
 * <b>Tuesday</b>
 * </p>
 * 1. Design and Starts Implementaton
 * <p>
 * Blocking:
 * </p>
 * 1. Nothing.
 * <p>
 * <b>Wednesday</b>
 * </p>
 * 1. Implementation and Tests
 * <p>
 * Blocking:
 * </p>
 * 1. Nothing.
 *
 * <h2>10. Self Assessment</h2>
 *
 * -Insert here your self-assessment of the work during this sprint.-
 *
 * <h3>10.1. Design and Implementation:3</h3>
 *
 * <p>
 * <b>Evidences:</b>
 * </p>
 * <p>
 * <h3>Step 1 - </h3>User Profile<br/><br/>
 * <img src="http://imgur.com/KjMAiPP.png" alt="connect">
 * </p>
 * <p>
 * <h3>Step 2 - </h3>Choose Opponent<br/><br/>
 * <img src="http://imgur.com/lU1DKyc.png" alt="connect2">
 * </p>
 * <p>
 * <h3>Step 3 - </h3>Choose TicTacToe Game<br/><br/>
 * <img src="http://imgur.com/JORXj49.png" alt="choose game">
 * </p>
 * <p>
 * <h3>Step 4 - </h3>Connect Opponent<br/><br/>
 * <img src="http://imgur.com/QRBRgbW.png" alt="connect">
 * </p>
 * <p>
 * <h3>Step 5 - </h3>Received invitation from opponent<br/><br/>
 * <img src="http://imgur.com/ThgR6uB.png" alt="connect established">
 * </p>
 * <p>
 * <h3>Step 6 - </h3>Start Game<br/><br/>
 * <img src="http://imgur.com/4xdMVMv.png" alt="play">
 * </p>
 * <p>
 * <h3>Step 7 - </h3>"O" is ever the first move<br/><br/>
 * <img src="http://imgur.com/SatOArC.png" alt="game">
 * </p>
 *
 * <h3>10.2. Teamwork: ...</h3>
 *
 * <h3>10.3. Technical Documentation: ...</h3>
 *
 * /**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Rafael Vilar
 */
package csheets.worklog.n1130980.sprint4;

class _Dummy_ {
}
