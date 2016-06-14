package csheets.ext.distributedWorkbook_1_2.ui;

import csheets.ext.distributedWorkbook.ui.*;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 * This class implements the UI interface extension for the comments extension.
 * A UI interface extension must extend the UIExtension abstract class.
 *
 * @see UIExtension
 * @author José Barros
 */
public class UIExtensionWorkbookSearch extends UIExtension {

	/**
	 * The icon to display with the extension's name
	 */
	private Icon icon;

	/**
	 * A side bar that provides editing of comments
	 */
	private JComponent sideBar;

	/**
	 * The menu of the extension
	 */
	private WorkbookSearchMenu menu;

	/**
	 * Controller.
	 */
	private DistributedWorkbookSearchController distributedSearchController;

	/**
	 * The menu of the extension
	 *
	 * @param extension extension
	 * @param uiController ui controller
	 */
	public UIExtensionWorkbookSearch(Extension extension,
									 UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon with style
	 */
	@Override
	public Icon getIcon() {
		return null;
	}

	/**
	 * Returns an instance of a class that implements JMenu.
	 *
	 * @see WorkbookSearchMenu
	 * @return a JMenu component
	 */
	@Override
	public JMenu getMenu() {
		if (menu == null) {
			if (distributedSearchController == null) {
				distributedSearchController = new DistributedWorkbookSearchController();
			}
			menu = new WorkbookSearchMenu(uiController, distributedSearchController);
		}
		return menu;
	}

	/**
	 * Returns a side bar that gives access to extension-specific functionality.
	 *
	 * @return a component, or null if the extension does not provide one
	 */
	@Override
	public JComponent getSideBar() {
		return null;
	}

}
