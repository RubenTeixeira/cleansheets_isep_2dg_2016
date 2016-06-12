/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.networkAnalizer.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 *
 * @author Diogo Leite
 */
public class UIExtensionNetworkAnalizer extends UIExtension {

	/**
	 * A side bar that provides contact edition
	 */
	private JComponent sideBar;

	/**
	 * The icon to display with the extension's name
	 */
	private Icon icon;

	/**
	 * Controller
	 */
	private NetworkAnalizerController networkAnalizer;

	/**
	 * The menu of the extension
	 *
	 * @param extension extension
	 * @param uiController ui controller
	 */
	public UIExtensionNetworkAnalizer(Extension extension,
									  UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon with style
	 */
	public Icon getIcon() {
//		if (icon == null) {
//			icon = new ImageIcon(.class.getResource("res/img/share.png"));
//		}
//		return icon;
		return null;
	}

	/**
	 * Returns a side bar that gives access to extension-specific functionality.
	 *
	 * @return a component, or null if the extension does not provide one
	 */
	public JComponent getSideBar() {
		if (sideBar == null) {
			sideBar = new NetworkAnalizerUI(uiController);
		}
		return sideBar;
	}

}
