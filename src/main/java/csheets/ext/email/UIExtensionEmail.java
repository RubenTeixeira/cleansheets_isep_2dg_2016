package csheets.ext.email;

import csheets.ext.Extension;
import csheets.ext.email.ui.EmailMenu;
import csheets.ext.simple.ui.ExampleMenu;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;

/**
 * This class implements the UI interface extension for the email
 * functionalities. A UI interface extension must extend the UIExtension
 * abstract class.
 *
 * @see UIExtension
 * @author Rui Bastos
 */
public class UIExtensionEmail extends UIExtension {

	/**
	 * The icon to display with the extension's name
	 */
	private Icon icon;

	/**
	 * A side bar that provides editing of comments
	 */
	private EmailMenu menu;
	private EmailController controller;

	/**
	 * The menu of the extension
	 *
	 * @param extension extension
	 * @param uiController ui controller
	 */
	public UIExtensionEmail(Extension extension, UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon with style
	 */
	@Override
	public Icon getIcon() {
		if (this.icon == null) {
			this.icon = new ImageIcon(EmailExtension.class.
				getResource("res/img/email.png"));
		}
		return icon;
	}

	/**
	 * Returns an instance of a class that implements JMenu. In this simple case
	 * this class only supplies one menu option.
	 *
	 * @see ExampleMenu
	 * @return a JMenu component
	 */
	@Override
	public JMenu getMenu() {
		if (menu == null) {
			if (this.controller == null) {
				this.controller = new EmailController();
			}
			menu = new EmailMenu(uiController, controller);
		}
		return menu;
	}
}
