/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.exportXML;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ruben
 */
public class ExportXMLTest {

	private Workbook workbook;
	private Spreadsheet spread1;
	private Spreadsheet spread2;
	private Spreadsheet spread3;
	private UIController uicontroller;

	public ExportXMLTest() throws FormulaCompilationException {

		this.workbook = new Workbook(3);
		this.spread1 = this.workbook.getSpreadsheet(0);
		this.spread2 = this.workbook.getSpreadsheet(1);
		this.spread3 = this.workbook.getSpreadsheet(2);
		this.spread1.setTitle("sheet");
		this.spread2.setTitle("sheet");
		this.spread3.setTitle("sheet");
		this.spread1.getCell(0, 0).setContent("={A1:=2}");
		this.spread2.getCell(1, 1).setContent("={B2:=2}");
		this.spread3.getCell(3, 3).setContent("={D4:=10}");

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
	 * Test of exportWorkbook method, of class ExportXML.
	 */
	@Test
	public void testExportWorkbook() {
		System.out.println("exportWorkbook");
		String tagWorkbook = "workbook1";
		String tagSpreadSheet = this.spread1.getTitle();
		String tagRow = "row";
		String tagColumn = "column";
		String expResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<workbook1>\n"
			+ "	<sheet name=\"sheet\" >\n"
			+ "		<row index=\"0\">\n"
			+ "			<column index=\"0\">2</column>\n"
			+ "		</row>\n"
			+ "	</sheet>\n"
			+ "	<sheet name=\"sheet\" >\n"
			+ "		<row index=\"1\">\n"
			+ "			<column index=\"1\">2</column>\n"
			+ "		</row>\n"
			+ "	</sheet>\n"
			+ "	<sheet name=\"sheet\" >\n"
			+ "	</sheet>\n"
			+ "</workbook1>\n";

		String result = ExportXML.
			exportWorkbook(tagWorkbook, tagSpreadSheet, tagRow, tagColumn, this.workbook.
						   getSpreadsheet(0).getWorkbook());
		//assertEquals(expResult, result);

	}

	/**
	 *
	 * Test of exportSpreadsheet method, of class ExportXML.
	 */
	@Test
	public void testExportSpreadsheet() {
		System.out.println("exportSpreadsheet");

		String tagSpreadSheet = this.spread1.getTitle();
		String tagRow = "row";
		String tagColumn = "column";
		Spreadsheet spreadsheet = this.spread1;

		String expResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
			+ "<sheet name=\"sheet\" >\n"
			+ "	<row index=\"0\">\n"
			+ "		<column index=\"0\">2</column>\n"
			+ "	</row>\n"
			+ "</sheet>\n"
			+ "";

		String result = ExportXML.
			exportSpreadsheet(tagSpreadSheet, tagRow, tagColumn, spreadsheet);
		//assertEquals(expResult, result);

	}

	/**
	 * Test of exportSpreadsheetSelected method, of class ExportXML.
	 *
	 * @Test
	 */
	public void testExportSpreadsheetSelected() {
		System.out.println("exportSpreadsheetSelected");
		String tagSpreadSheet = "sheet";
		String tagRow = "row";
		String tagColumn = "column";
		Cell[][] cells = this.uicontroller.focusOwner.getSelectedCells();

		String expResult = "";
		String result = ExportXML.
			exportSpreadsheetSelected(tagSpreadSheet, tagRow, tagColumn,
									  uicontroller);
		//assertEquals(expResult, result);

	}
}
