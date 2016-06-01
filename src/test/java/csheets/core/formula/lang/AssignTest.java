/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

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
//	@Test
//	public void testApplyTo() throws Exception {
//		System.out.println("ApplyTo");
//
//		/**
//		 * Gathering all Elements.
//		 */
//		Workbook testBook = new Workbook(2);
//		Spreadsheet testSheet = testBook.getSpreadsheet(0);
//		Cell targetCell = testSheet.getCell(0, 0);
//		Cell originalCell = testSheet.getCell(1, 1);
//
//		/**
//		 * originalCell will target targetCell (A1) with an Expression to
//		 * assign.
//		 *
//		 */
//		originalCell.setContent("A1:=2");
//		Value expectedResult = new Value(2);
//
//		/**
//		 * Generating Formula with recognizable tokens.
//		 */
//		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
//
//		Expression exp = compiler.compile(originalCell, originalCell.
//										  getContent());
//		/**
//		 * Mentioned method should recognize the Expression as a Assignment and
//		 * return the assign value of the targetCell.
//		 */
//		Value result = exp.evaluate();
//		assertEquals(result, expectedResult);
//	}
}
