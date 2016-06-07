/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.search.ui;

import com.sun.glass.events.KeyEvent;
import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import javax.swing.ImageIcon;
import javax.swing.JMenu;

/**
 * The search menu
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class SearchBar extends JMenu {

	public SearchBar(UIController uiController) {
		super("Search");

		setMnemonic(KeyEvent.VK_E);
		this.setIcon(new ImageIcon(CleanSheets.class.
			getResource("ext/search/search_icon.png")));

		add(new SearchAction(uiController));

	}
}
