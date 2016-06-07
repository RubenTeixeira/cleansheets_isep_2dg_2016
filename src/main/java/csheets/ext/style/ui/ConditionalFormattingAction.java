/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.style.ui;

import csheets.ext.conditionalFormatting.ui.ConditionalFormattingUI;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Diogo Leite
 */
@SuppressWarnings("serial")
public class ConditionalFormattingAction extends FocusOwnerAction {

	/**
	 * The user interface controller
	 */
	private UIController uiController;
	private ConditionalFormattingUI conditionalFormattingUI;

	public ConditionalFormattingAction(UIController uiController) {
		this.uiController = uiController;
	}

	protected String getName() {
		return "Conditional Formatting";
	}

	protected void defineProperties() {
//		putValue(SMALL_ICON, new ImageIcon(StyleExtension.class.
//				 getResource("res/img/c.png")));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		conditionalFormattingUI = new ConditionalFormattingUI(uiController);

	}

}
