/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;

/**
 * This class implements the UI interface extension for the game extension. Ui
 * interface extension must extend the UIExtension abstract class.
 *
 * @author João Martins
 */
public class UIGameExtension extends UIExtension {

	/**
	 * TODO
	 */
	private JComponent sideBar;

	/**
	 * The menu of the extension.
	 */
	private GameMenu menu;

	/**
	 * Controller of the game extension.
	 */
	private GameController gameController;

	/**
	 * The menu of the extension.
	 *
	 * @param extension
	 * @param uiController
	 */
	public UIGameExtension(Extension extension, UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an instance of a class that implements JMenu.
	 *
	 * @see GameMenu
	 * @return a JMenu component
	 */
	@Override
	public JMenu getMenu() {
		if (menu == null) {
			if (gameController == null) {
				gameController = new GameController();
			}
			menu = new GameMenu(uiController, gameController);
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
		if (sideBar == null) {
			if (gameController == null) {
				gameController = new GameController();
			}
			sideBar = new GamePanel(uiController, gameController);
		}
		return sideBar;
	}

}
