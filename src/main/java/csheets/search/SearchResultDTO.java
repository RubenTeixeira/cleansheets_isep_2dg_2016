/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.search;

import java.io.Serializable;

/**
 * This is a Data Transfer Object class which sole purpose is to gather all
 * information of a search result (SpreadSheet, cell, cell content/value, search
 * pattern and even WorkBook if needed in the future).
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class SearchResultDTO implements Serializable {

	/**
	 * The workbook (uneeded atm)
	 */
	//private final String workBook;
	/**
	 * The SpreadSheet of the result
	 */
	private final String spreadSheet;

	/**
	 * The cell
	 */
	private final String cell;

	/**
	 * Formula if applicable
	 */
	private final String formula;

	/**
	 * Value
	 */
	private final String value;

	public SearchResultDTO(String spreadSheet, String cell, String formula,
						   String value) {
		this.spreadSheet = spreadSheet;
		this.cell = cell;
		this.formula = formula;
		this.value = value;
	}

	public String getSpreadSheet() {
		return spreadSheet;
	}

	public String getCell() {
		return cell;
	}

	public String getFormula() {
		return formula;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		String description = "";
		description += spreadSheet;
		description += " [" + cell + "]\n";
		if (formula != null && !"".equals(formula)) {
			description += " Formula: " + formula;
		}
		description += " Value: " + value;
		return description;
	}

}
