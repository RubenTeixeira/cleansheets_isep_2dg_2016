/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort;

import csheets.ext.Extension;
import csheets.ext.sort.ui.UISort;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * Sort Extension
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class SortExtension extends Extension {

	/**
	 * Extension name - required.
	 */
	private static final String NAME = "Sort";

	/**
	 * Creates a new SortExtension.
	 */
	public SortExtension() {
		super(NAME);

	}

	/**
	 * Returns the User Interface Extension of the SortExtension.
	 *
	 * @param uiController
	 * @return
	 */
	@Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UISort(this, uiController);
	}
}
