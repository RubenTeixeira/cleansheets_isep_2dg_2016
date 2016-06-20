/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.exportPDF;

import csheets.ui.ctrl.UIController;
import csheets.ui.legacy.exportPDF.ui.ExportPDFPanel;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author utilizador
 */
public class ExportPDFAction extends AbstractAction {

	private UIController controller;

	/**
	 * Creates Export PDF action.
	 *
	 * @param controller controller
	 */
	public ExportPDFAction(UIController controller) {
		// Configures action
		this.controller = controller;
		String name = "Export PDF";
		putValue(NAME, name);
		putValue(SHORT_DESCRIPTION, name);
		putValue(ACTION_COMMAND_KEY, name);
		putValue(MNEMONIC_KEY, KeyEvent.VK_P);
	}

	/**
	 *
	 * Creates actionPerformed to call ExportXMLPanel
	 *
	 * @param ae e
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		new ExportPDFPanel(this.controller).show();
	}
}
