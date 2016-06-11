/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.search;

import java.io.Serializable;

/**
 * This is a Data Transfer Object class which sole purpose is to gather all
 * information of a search result (SpreadSheet, cell, cell content/value, search
 * pattern and even WorkBook if needed in the future).
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class SearchResultDTO implements Serializable {

        
        private final String workbook;
    
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

	public SearchResultDTO(String workbookFileName, String spreadSheet, String cell, String formula,
						   String value) {
                this.workbook = workbookFileName;
		this.spreadSheet = spreadSheet;
		this.cell = cell;
		this.formula = formula;
		this.value = value;
	}

        public String getWorkBook() {
            return workbook;
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
                description += workbook + " - ";
		description += spreadSheet;
		description += " [" + cell + "]\n";
		if (formula != null && !"".equals(formula)) {
			description += " Formula: " + formula;
		}
		description += " Value: " + value;
		return description;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final SearchResultDTO other = (SearchResultDTO) obj;
		return !(!other.workbook.equals(this.workbook)
                        || !other.spreadSheet.equals(this.spreadSheet)
			|| !other.cell.equals(this.cell)
			|| !other.formula.equals(this.formula)
			|| !other.value.equals(this.value));
	}

}
