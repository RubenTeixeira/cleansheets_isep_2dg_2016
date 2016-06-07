/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort Controller.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class SortController {

	/**
	 * User Interface controller.
	 */
	private UIController uiController;

	/**
	 * Sorting List.
	 */
	private List<Value> valueList = new ArrayList<>();

	/**
	 * Column index.
	 */
	private int index;

	public SortController(UIController controller) {
		this.uiController = controller;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void updateValueList() {
		for (Cell c : this.uiController.getActiveSpreadsheet().
			getColumn(this.index)) {
			if (!c.getValue().toString().equals("")) {
				valueList.add(c.getValue());
			}
		}
	}

	public void order(int order) {
		if (order == 0) {
			Collections.sort(valueList);
		} else {
			Collections.sort(valueList);
			Collections.reverse(valueList);
		}
	}

	public void updateColumn() {
		int j = 0;
		for (Cell c : this.uiController.getActiveSpreadsheet().
			getColumn(this.index)) {
			if (!c.getValue().toString().equalsIgnoreCase("")) {
				c.clear();
				try {
					c.setContent(valueList.get(j).toString());
				} catch (FormulaCompilationException exc) {
					//TODO: handling
				}
				j++;
			}
		}
		valueList.clear();
	}
}
