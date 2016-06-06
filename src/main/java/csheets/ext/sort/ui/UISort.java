/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JMenu;

/**
 * User Interface of Sort Extension
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class UISort extends UIExtension {

	/**
	 * Icon to be displayed.
	 */
	private Icon icon;

	/**
	 * Sort extension menu.
	 */
	private SortMenu menu;

	/**
	 * Creats UISortExtension.
	 *
	 * @param extension
	 * @param uiController
	 */
	public UISort(Extension extension, UIController uiController) {
		super(extension, uiController);
	}

	public Icon getIcon() {
		return null;

	}

	/**
	 *
	 * @return
	 */
	public JMenu getMenu() {
		if (menu == null) {
			menu = new SortMenu(uiController);
		}
		return menu;
	}
}
