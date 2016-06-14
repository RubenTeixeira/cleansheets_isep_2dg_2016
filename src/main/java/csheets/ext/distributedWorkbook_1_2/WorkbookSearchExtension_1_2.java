package csheets.ext.distributedWorkbook_1_2;

import csheets.ext.Extension;
import csheets.ext.distributedWorkbook.ui.UIExtensionWorkbookSearch;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * An extension to support workbook search in another instance. An extension
 * must extend the Extension abstract class. The class that implements the
 * Extension is the "bootstrap" of the extension.
 *
 * @see Extension
 * @author José Barros
 */
public class WorkbookSearchExtension_1_2 extends Extension {

	/**
	 * The name of extension
	 */
	public static final String NAME = "Distributed Workbook Search";

	/**
	 * Creates a new workbook extension.
	 */
	public WorkbookSearchExtension_1_2() {
		super(NAME);
	}

	/**
	 * Returns the user interface extension of this extension
	 *
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	@Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionWorkbookSearch(this, uiController);
	}
}
