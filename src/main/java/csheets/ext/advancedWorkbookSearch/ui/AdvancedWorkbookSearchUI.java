/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.advancedWorkbookSearch.ui;

import csheets.ext.advancedWorkbookSearch.ui.AdvancedWorkbookSearchPanel;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 * User Interface of Advanced Workbook Search Extension.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class AdvancedWorkbookSearchUI extends UIExtension {

	/**
	 * SideBar's Extension.
	 */
	private JComponent sideBar;

	/**
	 * Creates AdvancedWorkbookSearch Panel.
	 *
	 * @param extension Extension.
	 * @param uiController UIController.
	 */
	public AdvancedWorkbookSearchUI(Extension extension,
									UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Extension' side bar.
	 *
	 * @return JComponent
	 */
	@Override
	public JComponent getSideBar() {
		if (sideBar == null) {
			sideBar = new AdvancedWorkbookSearchPanel(uiController);
		}
		return sideBar;
	}
}