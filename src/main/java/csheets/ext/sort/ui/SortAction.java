/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Sort Extension Action that interacts with the Active SpreadSheet.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class SortAction extends BaseAction {

	/**
	 * User Interface Controller.
	 */
	protected UIController uiController;

	public SortAction(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 * @return name extension.
	 */
	@Override
	protected String getName() {
		return "Sorting Column.";
	}

	@Override
	protected void defineProperties() {
		putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.
				 getResource("ext/sort/sort_icon_2.png")));
		setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SortJDialog(uiController).setVisible(true);
	}
}
