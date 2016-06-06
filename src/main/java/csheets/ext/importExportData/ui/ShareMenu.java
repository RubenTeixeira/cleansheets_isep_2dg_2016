package csheets.ext.importExportData.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 * Represents the UI extension menu of the share extension.
 *
 * @author Rui Bastos
 */
public class ShareMenu extends JMenu {

	/**
	 * Creates a new share menu. This constructor creates and adds the menu
	 * options. A menu option is an action (in this case
	 *
	 *
	 * @param uiController the user interface controller
	 * @param shareController The share cells controller.
	 */
	public ShareMenu(UIController uiController,
					 ImportExportTextFileController shareController) {
		super("Share");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		//add(new OptionsAction(uiController, shareController));
	}
}
