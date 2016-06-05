package csheets.ext.wizard.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * An action of the simple extension that exemplifies how to interact with the
 * spreadsheet.
 *
 * @author AB-1140280
 */
public class WizardAction extends BaseAction {

	/**
	 * The user interface controller
	 */
	protected UIController uiController;

	/**
	 * Creates a new action.
	 *
	 * @param uiController the user interface controller
	 */
	public WizardAction(UIController uiController) {
		this.uiController = uiController;
	}

	protected String getName() {
		return "Wizard to help the use of functions.";
	}

	protected void defineProperties() {
		putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.
				 getResource("ext/wizard/wizard-icon.png")));
	}

	/**
	 * A simple action that presents a confirmation dialog. If the user confirms
	 * then the contents of the cell A1 of the current sheet are set to the
	 * string "Changed".
	 *
	 * @param event the event that was fired
	 */
	public void actionPerformed(ActionEvent event) {

		// Lets user select a font
		new WizardFrame(uiController).setVisible(true);
	}
}