/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.ExcelExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 * @author João Martins 1131190@isep.ipp.pt
 */
public class AssignTest {

	private ExcelExpressionCompiler compiler;
	private Workbook workBook;
	private Spreadsheet spreadSheet;
	private Cell targetCell1;
	private Cell targetCell2;

	public AssignTest() {
		this.compiler = new ExcelExpressionCompiler();
		this.workBook = new Workbook(1);
		this.spreadSheet = this.workBook.getSpreadsheet(0);
		this.targetCell1 = this.spreadSheet.getCell(0, 0);
		this.targetCell2 = this.spreadSheet.getCell(1, 0);
	}

	/**
	 * Test of applyTo method, of class Assign.
	 *
	 * @throws Exception
	 */
	@Test
	public void testApplyTo() throws Exception {
		System.out.println("testApplyTo");
		this.targetCell1.setContent("={A1:=2}");
		assertEquals(this.targetCell1.getValue().toString(), "2");
	}

	@Test
	public void testGetCellTemporaryVariable() throws FormulaCompilationException {
		System.out.println("testGetCellTemporaryVariable");
		this.targetCell1.setContent("={_temp:=11}");
		CellImpl cell = (CellImpl) this.targetCell1;
		assertEquals(cell.getVariable("_temp").toString(), "11");
	}

	@Test
	public void testAssignTemporaryVariable() throws FormulaCompilationException {
		System.out.println("testAssignTemporaryVariable");
		this.targetCell1.setContent("={_temp:=10; B1:=_temp}");
		assertEquals(this.targetCell2.getValue().toString(), "10");
	}

	@Test(expected = NullPointerException.class)
	public void testLastNameNotAcceptNull() throws FormulaCompilationException {
		System.out.println("testLastNameNotAcceptNull");
		targetCell1.setContent("={B1:=_algo}");
	}

}
