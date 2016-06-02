/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class AssignTest {

	public AssignTest() {
	}

	/**
	 * Test of applyTo method, of class Assign.
	 *
	 * @throws Exception
	 */
	@Test
	public void testApplyTo() throws Exception {
		System.out.println("ApplyTo");

		/**
		 * Gathering all Elements.
		 */
		Workbook testBook = new Workbook(2);
		Spreadsheet testSheet = testBook.getSpreadsheet(0);

		Cell targetCell = testSheet.getCell(0, 0);

		/**
		 * originalCell will target targetCell (A1) with an Expression to
		 * assign.
		 *
		 */
		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();

		Expression exp = compiler.compile(targetCell, "=A1:=2");

		Value result = exp.evaluate();
		Value expectedResult = new Value(2);

		assertEquals(result.toString(), expectedResult.toString());
	}
}
