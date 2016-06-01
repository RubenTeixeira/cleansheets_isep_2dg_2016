/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.ext.Extension;
import csheets.ext.cellsSharing.ShareExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 * This class implements the UI interface extension for the comments extension.
 * A UI interface extension must extend the UIExtension abstract class.
 *
 * @see UIExtension
 * @author José Barros
 */
public class UIExtensionShare extends UIExtension {

	/**
	 * The icon to display with the extension's name
	 */
	private Icon icon;
	/**
	 * A cell decorator that visualizes comments on cells
	 */
	private CellDecorator cellDecorator;

	/**
	 * A side bar that provides editing of comments
	 */
	private JComponent sideBar;

	/**
	 * The menu of the extension
	 */
	private ShareMenu menu;

	/**
	 * The menu of the extension
	 *
	 * @param extension extension
	 * @param uiController ui controller
	 */
	public UIExtensionShare(Extension extension, UIController uiController) {
		super(extension, uiController);
	}

	/**
	 * Returns an icon to display with the extension's name.
	 *
	 * @return an icon with style
	 */
	public Icon getIcon() {
//		if (icon == null) {
//			icon = new ImageIcon(ShareExtension.class.getResource("res/img/share.png"));
//		}
//		return icon;
		return null;
	}

	/**
	 * Returns an instance of a class that implements JMenu.
	 *
	 * @see ShareMenu
	 * @return a JMenu component
	 */
	public JMenu getMenu() {
		if (menu == null) {
			menu = new ShareMenu(uiController);
		}
		return menu;
	}

	/**
	 * Returns a cell decorator that visualizes the data added by the extension.
	 *
	 * @return a cell decorator, or null if the extension does not provide one
	 */
	public CellDecorator getCellDecorator() {
		return null;
	}

	/**
	 * Returns a table decorator that visualizes the data added by the
	 * extension.
	 *
	 * @return a table decorator, or null if the extension does not provide one
	 */
	public TableDecorator getTableDecorator() {
		return null;
	}

	/**
	 * Returns a toolbar that gives access to extension-specific functionality.
	 *
	 * @return a JToolBar component, or null if the extension does not provide
	 * one
	 */
	public JToolBar getToolBar() {
		return null;
	}

	/**
	 * Returns a side bar that gives access to extension-specific functionality.
	 *
	 * @return a component, or null if the extension does not provide one
	 */
	public JComponent getSideBar() {
		if (sideBar == null) {
			sideBar = new SharePanel(uiController);
		}
		return sideBar;
	}

}
