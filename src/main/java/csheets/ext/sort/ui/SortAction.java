/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort.ui;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.sort.SortController;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
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
	protected final UIController theController;

	/**
	 * Sort Controller. won't be needed.
	 */
	private SortController sortController;

	/**
	 * active Spreadsheet.
	 */
	protected Spreadsheet spreadsheet;

	/**
	 * Creats a Sort Action.
	 *
	 * @param uiController
	 */
	public SortAction(UIController uiController) {
		this.sortController = new SortController();
		this.theController = uiController;
		//this.spreadsheet = uiController.getActiveSpreadsheet();

	}

	/**
	 *
	 * @return name extension.
	 */
	@Override
	protected String getName() {
		return "Sorting Column.";
	}

	/**
	 *
	 */
	protected void defineProperties() {
		putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.
				 getResource("ext/sort/sort_icon_2.png")));
		setEnabled(true);
	}

	/**
	 *
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		this.spreadsheet = theController.getActiveSpreadsheet();

		int index = 5;
		int order = 0;

		//filtering empyy cells and cells content
		List<String> valueList = new ArrayList<>();
		List<String> resultList = new ArrayList<>();

		int n = spreadsheet.getColumn(index).length; //gives the bigger column - breakpoint
		System.out.println("Selected Column has: " + n + " Working Cells");

		for (int i = 0; i < n; i++) {
			//if not empty
			if (!spreadsheet.getCell(index, i).getValue().toString().equals("")) {
				//adds cell value to column.
				valueList.add(spreadsheet.getCell(index, i).getValue().
					toString());
			}
		}
		resultList = this.sortController.order(valueList, order);

		int j = 0;
		for (Cell c : theController.getActiveSpreadsheet().
			getColumn(index)) {
			if (!c.getValue().toString().equalsIgnoreCase("")) {
				c.clear(); //clears the value of the cell.
				try {
					c.setContent(resultList.get(j));
				} catch (FormulaCompilationException exc) {
					exc.printStackTrace();
				}
				j++;
			}
		}

	}
}
