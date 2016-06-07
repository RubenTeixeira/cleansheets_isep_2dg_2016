/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.FindWorkbook.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Carlos Mateus
 */
public class FindWorkbookAction extends BaseAction {

	/**
	 * The user interface controller
	 */
	protected UIController uiController;

	/**
	 * Find workbook controller.
	 */
	private final FindWorkbookController findWorkbookController;

	/**
	 * Creates a new action.
	 *
	 * @param uiController the user interface controller
	 * @param findWorkbookController find workbook controller
	 */
	public FindWorkbookAction(UIController uiController,
							  FindWorkbookController findWorkbookController) {
		this.uiController = uiController;
		this.findWorkbookController = findWorkbookController;
	}

	@Override
	protected String getName() {
		return "Find Workbook";
	}

	@Override
	protected void defineProperties() {
	}

	/**
	 * A simple action that presents a confirmation dialog. If the user confirms
	 * then the contents of the cell A1 of the current sheet are set to the
	 * string "Changed".
	 *
	 * @param event the event that was fired
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		FindWorkbookUI findWorkbook = new FindWorkbookUI(uiController, findWorkbookController);
		findWorkbook.run();
	}

}
