/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.framework.search;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
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
public class SearchResultAssemblerTest {

	public SearchResultAssemblerTest() {
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
	 * Test of getResultInformation method, of class SearchResultAssembler.
	 */
	@Test
	public void testGetResultInformation() {
		System.out.println("getResultInformation");
		Workbook workBook = new Workbook(1);
		Spreadsheet spreadSheet = workBook.getSpreadsheet(0);
		Cell cell = spreadSheet.getCell(0, 0);
		try {
			cell.setContent("=2+2");
		} catch (FormulaCompilationException ex) {
		}
		SearchResultDTO expResult = new SearchResultDTO("Sheet 1", "A1", "=2+2", "4");
		SearchResultDTO result = SearchResultAssembler.
			getResultInformation(spreadSheet, cell);
		assertEquals(expResult, result);
	}

}
