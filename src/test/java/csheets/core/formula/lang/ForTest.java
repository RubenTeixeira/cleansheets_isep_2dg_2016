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
public class ForTest {

	public ForTest() {
	}

	/**
	 * Test of applyTo method, of class For.
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
//		originalCell.setContent("=FOR{A1:=1;A1<10;A1:=A1+1}");
//		Value expectedResult = new Value(10);
//
//		/**
//		 * Generating Formula with recognizable tokens.
//		 */
//		ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
//
//		Expression exp = compiler.compile(originalCell, originalCell.
//										  getContent());
//		/**
//		 * Mentioned method should recognize the Expression as a For Loop and
//		 * return the assign value of the targetCell.
//		 */
//		Value result = exp.evaluate();
//		assertEquals(result, expectedResult);
//	}
}