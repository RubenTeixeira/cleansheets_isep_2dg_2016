/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogo Leite
 */
public class ConditionalFormattingController {

	public void apply(Cell cell) throws FormulaCompilationException {
		try {
			if (cell.getValue().toBoolean()) {

			}
		} catch (IllegalValueTypeException ex) {
			Logger.getLogger(ConditionalFormattingController.class.getName()).
				log(Level.SEVERE, null, ex);
		}

	}

}
