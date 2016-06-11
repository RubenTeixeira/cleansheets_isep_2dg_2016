/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.search;

import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class WorkBookSearchTest {

	public WorkBookSearchTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of getMatches method, of class WorkBookSearch.
	 */
	@Test
	public void testGetMatches() {

		System.out.println("getMatches");
		String pattern = ".*4.*";
		Stack<Workbook> workBooks = new Stack<>();
                Workbook workBook = new Workbook(1);
                workBooks.push(workBook);
		WorkBookSearch instance = new WorkBookSearch(workBooks);

		// set a few cells content: only 2 of them should match
		try {
			workBook.getSpreadsheet(0).getCell(0, 0).setContent("646");
			workBook.getSpreadsheet(0).getCell(0, 1).setContent("=2+2");
			workBook.getSpreadsheet(0).getCell(0, 2).setContent("5");
		} catch (FormulaCompilationException ex) {

		}
		int expResult = 2;
		int result = instance.getMatches(pattern).size();
		boolean res = (expResult == result);
		assertEquals(expResult, result);

	}

}
