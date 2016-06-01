/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
class OptionsAction extends BaseAction {

	/**
	 * The user interface controller
	 */
	protected UIController uiController;

	/**
	 * Creates a new action.
	 *
	 * @param uiController the user interface controller
	 */
	public OptionsAction(UIController uiController) {
		this.uiController = uiController;
	}

	protected String getName() {
		return "Options";
	}

	protected void defineProperties() {
	}

	/**
	 * A simple action that presents a confirmation dialog. If the user confirms
	 * then the contents of the cell A1 of the current sheet are set to the
	 * string "Changed".
	 *
	 * @param event the event that was fired
	 */
	public void actionPerformed(ActionEvent event) {

		OptionsUI options = new OptionsUI(uiController);
		options.run();
	}

}
