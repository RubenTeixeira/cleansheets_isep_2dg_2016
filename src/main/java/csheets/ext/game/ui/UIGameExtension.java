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

/**
 * This class implements the UI interface extension for the game extension. Ui
 * interface extension must extend the UIExtension abstract class.
 *
 * @author João Martins
 */
public class UIGameExtension extends UIExtension {

	/**
	 * SideBar to choose player and game to paly.
	 */
	private JComponent sideBar;

	/**
	 * Controller of the game extension.
	 */
	private GameController gameController;

	/**
	 * The menu of the extension.
	 *
	 * @param extension extension
	 * @param uiController uiController
	 */
	public UIGameExtension(Extension extension, UIController uiController) {
		super(extension, uiController);
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
