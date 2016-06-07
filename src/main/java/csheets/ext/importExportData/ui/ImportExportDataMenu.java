package csheets.ext.importExportData.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 * Represents the UI extension menu of the share extension.
 *
 * @author Rui Bastos
 */
public class ImportExportDataMenu extends JMenu {

	/**
	 * Creates a new share menu. This constructor creates and adds the menu
	 * options. A menu option is an action (in this case
	 *
	 *
	 * @param uiController the user interface controller
	 * @param controller The controller.
	 */
	public ImportExportDataMenu(UIController uiController,
								ImportExportTextFileController controller) {
		super("Import/Export Data");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		add(new ImportAction(uiController, controller));
		add(new ExportAction(uiController, controller));
	}
}
