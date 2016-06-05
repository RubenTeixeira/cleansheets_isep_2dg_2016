package csheets.ext.importExportData;

import csheets.ext.Extension;
import csheets.ext.importExportData.ui.UIExtensionShareTextFile;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * An extension to support text file sharing. An extension must extend the
 * Extension abstract class. The class that implements the Extension is the
 * "bootstrap" of the extension.
 *
 * @see Extension
 * @author Rui Bastos
 */
public class ShareTextExtension extends Extension {

	/**
	 * The name of extension
	 */
	public static final String NAME = "Share text file";

	/**
	 * Creates a new Share extension.
	 */
	public ShareTextExtension() {
		super(NAME);
	}

	/**
	 * Returns the user interface extension of this extension
	 *
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionShareTextFile(this, uiController);
	}
}
