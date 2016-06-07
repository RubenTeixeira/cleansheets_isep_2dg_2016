/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 * Search Extension Action that interacts with the Active SpreadSheet.
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class SearchAction extends BaseAction {

	/**
	 * User Interface Controller.
	 */
	protected UIController uiController;

	/**
	 * Creates a SearchAction
	 *
	 * @param uiController UIController
	 */
	public SearchAction(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 * @return name extension.
	 */
	@Override
	protected String getName() {
		return "Search WorkBook";
	}

	@Override
	protected void defineProperties() {
		putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.
				 getResource("ext/search/search_icon.png")));
		setEnabled(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new SearchPanel(this.uiController);
	}

}
