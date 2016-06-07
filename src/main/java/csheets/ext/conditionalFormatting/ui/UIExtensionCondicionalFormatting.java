package csheets.ext.conditionalFormatting.ui;

import csheets.ext.Extension;
import csheets.ext.conditionalFormatting.ConditionalFormattingExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Diogo Leite
 */
public class UIExtensionCondicionalFormatting extends UIExtension {

	/**
	 * A side bar that provides contact edition
	 */
	private JComponent sideBar;

	/**
	 * The icon to display with the extension's name
	 */
	private Icon icon;
	private ConditionalFormattingController conditionalFormatting;

	public UIExtensionCondicionalFormatting(Extension extension,
											UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns a side bar that gives access to extension-specific functionality.
	 *
	 * @return a component, or null if the extension does not provide one
	 */
	public JComponent getSideBar() {
		if (sideBar == null) {
			if (conditionalFormatting == null) {
				conditionalFormatting = new ConditionalFormattingController();
			}
			sideBar = new ConditionalFormattingUI(uiController);
		}
		return sideBar;
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon with a tree
	 */
	public Icon getIcon() {
		if (icon == null) {
			icon = new ImageIcon(
				ConditionalFormattingExtension.class.
				getResource("res/img/logo.gif"));
		}
		return icon;
	}

}
