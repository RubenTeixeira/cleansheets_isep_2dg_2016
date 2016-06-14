/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.game;

import csheets.core.Spreadsheet;
import csheets.ext.SpreadsheetExtension;

/**
 *
 * @author Rafael
 */
public class TictactoeSpreadsheetExtension extends SpreadsheetExtension {

	/**
	 * Definition of the name extension.
	 */
	public String NAME = "Play Game";

	/**
	 * Creates a new Game Extension - "Play Game"
	 *
	 * @param sheet
	 * @param name
	 */
	public TictactoeSpreadsheetExtension(Spreadsheet sheet, String name) {
		super(sheet, name);
	}

//	/**
//	 * Returns the user interface extension of this extension
//	 *
//	 * @param uiController the user interface controller
//	 * @return a user interface extension, or null if none is provided
//	 */
//	@Override
//	public UIExtension getUIExtension(UIController uiController) {
//		return new UIGameExtension(this, uiController);
//	}
}
