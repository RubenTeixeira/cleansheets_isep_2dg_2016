package csheets.ext.macro_beanshell;

import csheets.ext.Extension;
import csheets.ext.simple.ui.UIExtensionExample;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * @see Extension
 * @author Rui Bento
 */
public class MacroBeanShellExtension extends Extension {

	/** The name of the extension */
	public static final String NAME = "Marco/BeanShell";

	/**
	 * Creates a new Example extension.
	 */
	public MacroBeanShellExtension() {
		super(NAME);
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIExtensionExample}).
	 * In this extension example we are only extending the user interface.
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionExample(this, uiController);
	}
}
