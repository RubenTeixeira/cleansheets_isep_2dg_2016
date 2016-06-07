/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 * Represents the UI extension of the game extension.
 *
 * @author João Martins
 */
public class GameMenu extends JMenu {

	public GameMenu(UIController uiController, GameController gameController) {
		super("Game");
		setMnemonic(KeyEvent.VK_S);

		// Adds font actions
		//add(new OptionsAction(uiController, gameController));
		//??????
	}
}
