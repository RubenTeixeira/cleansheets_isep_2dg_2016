/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.importXML;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author scarl
 */
public class ImportXMLTest {

	public ImportXMLTest() {
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
	 * Test of getFileData method, of class ImportXML.
	 */
	@Test
	public void testGetFileData() throws Exception {
		System.out.println("getFileData");
		String path = "file_workbook_test.xml";
		String expResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<WorkBook>"
			+ "<SpreadSheet name=\"Sheet  1\" >"
			+ "<Row index=\"0\">"
			+ "<Column index=\"0\">ola</Column>"
			+ "<Column index=\"1\">tudo bem</Column>"
			+ "</Row>"
			+ "<Row index=\"4\">"
			+ "<Column index=\"1\">lapr4</Column>"
			+ "</Row>"
			+ "<Row index=\"8\">"
			+ "<Column index=\"0\">lindo</Column>"
			+ "</Row>"
			+ "</SpreadSheet>"
			+ "<SpreadSheet name=\"Sheet  2\" >"
			+ "</SpreadSheet>"
			+ "<SpreadSheet name=\"Sheet  3\" >"
			+ "</SpreadSheet>"
			+ "</WorkBook>";
		String result = ImportXML.getFileData(path);
		assertEquals(expResult, result);

	}

	/**
	 * Test of importWorkbook method, of class ImportXML.
	 */
	@Test
	public void testImportWorkbook() throws Exception {
		System.out.println("importWorkbook");
		String path = "file_workbook_test.xml";
		String tagWorkbook = "WorkBook";
		String tagSpreadSheet = "SpreadSheet";
		String tagRow = "Row";
		String tagColumn = "Column";
		Workbook workbook = new Workbook(3);
		String expResult = "ola";
		ImportXML.
			importWorkbook(path, tagWorkbook, tagSpreadSheet, tagRow, tagColumn, workbook);
		String result = workbook.getSpreadsheet(0).getCell(0, 0).getContent();
		assertEquals(expResult, result);
	}

	/**
	 * Test of importSpreadsheet method, of class ImportXML.
	 */
	@Test
	public void testImportSpreadsheet() throws Exception {
		System.out.println("importSpreadsheet");
		String path = "file_spreadsheet_test.xml";
		String tagSpreadSheet = "SpreadSheet";
		String tagRow = "Row";
		String tagColumn = "Column";
		Workbook workbook = new Workbook(1);
		Spreadsheet spreadsheet = workbook.getSpreadsheet(0);
		List<String> expResult = new ArrayList<>();
		expResult.add("a");
		expResult.add("b");
		expResult.add("c");
		expResult.add("d");
		expResult.add("e");
		expResult.add("f");
		expResult.add("coisa");
		expResult.add("g");
		expResult.add("vamos ver");

		ImportXML.
			importSpreadsheet(path, tagSpreadSheet, tagRow, tagColumn, spreadsheet);

		List<String> result = new ArrayList<>();

		for (int i = 0; i <= spreadsheet.getRowCount(); i++) {
			for (int j = 0; j <= spreadsheet.getColumnCount(); j++) {
				if (!spreadsheet.getCell(j, i).getContent().isEmpty()) {
					result.add(spreadsheet.getCell(j, i).getContent());
				}
			}
		}
		assertEquals(expResult, result);

	}

	/**
	 * Test of importSpreadsheetSelected method, of class ImportXML.
	 */
//	@Test
//	public void testImportSpreadsheetSelected() throws Exception {
//		System.out.println("importSpreadsheetSelected");
//		String path = "";
//		String tagSpreadSheet = "";
//		String tagRow = "";
//		String tagColumn = "";
//		UIController uiController = null;
//		ImportXML.
//			importSpreadsheetSelected(path, tagSpreadSheet, tagRow, tagColumn, uiController);
//		// TODO review the generated test code and remove the default call to fail.
//		fail("The test case is a prototype.");
//	}
}
