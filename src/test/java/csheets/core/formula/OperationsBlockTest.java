/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula;

/**
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class OperationsBlockTest {

	public OperationsBlockTest() {
	}

//	/**
//	 * Test of evaluate method, of class OperationsBlock.
//	 *
//	 * @throws Exception
//	 */
//	@Test
//	public void testEvaluate() throws Exception {
//		System.out.println("Evaluate");
//
//		/**
//		 * Gathering all Elements.
//		 */
//		Workbook testBook = new Workbook(2);
//		Spreadsheet testSheet = testBook.getSpreadsheet(0);
//		Cell cell = testSheet.getCell(0, 0);
//		/**
//		 * Source simulates an OperationsBlock where the final result should be
//		 * equal to 1.
//		 */
//		cell.setContent("={2+2;4*4;6-1;6>3;2-1}");
//		Value expectedResult = new Value(1);
//
//		/**
//		 * Generating Formula with recognizable tokens.
//		 */
//		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
//		Expression exp = compiler.compile(cell, cell.getContent());
//
//		/**
//		 * Mentioned method should recognize the Expression as a OperationsBlock
//		 * and assign the result of the last Expression to result.
//		 */
//		Value result = exp.evaluate();
//
//		assertEquals(result, expectedResult);
//
//	}
}
