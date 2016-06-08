/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class UISearch extends UIExtension {

	/**
	 * Icon to be displayed.
	 */
	private Icon icon;

	/**
	 * A side bar that provides search functionality
	 */
	private JComponent sideBar;

	/**
	 * Creates UISearchExtension.
	 *
	 * @param extension Extension
	 * @param uiController UIController
	 */
	public UISearch(Extension extension, UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns a side bar that gives access to search functionality.
	 *
	 * @return a component, or null if the extension does not provide one
	 */
	@Override
	public JComponent getSideBar() {
		if (sideBar == null) {
			sideBar = new SearchPanel(uiController);
		}
		return sideBar;
	}
}
