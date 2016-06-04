package csheets.ext.distributedWorkbook.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 * Represents the UI extension menu of the share extension.
 *
 * @author José Barros
 */
class WorkbookSearchMenu extends JMenu {

	/**
	 * Creates a new workbook menu. This constructor creates and adds the menu
	 * options. A menu option is an action (in this case
	 *
	 *
	 * @param uiController the user interface controller
	 * @param distributedController The distributed workbook search controller.
	 */
	public WorkbookSearchMenu(UIController uiController, DistributedWorkbookSearchController distributedSearchController) {
		super("Distributed Workbook Search");
		setMnemonic(KeyEvent.VK_W);

		// Adds font actions
		add(new WorkbookSearchAction(uiController, distributedSearchController));
	}

}
