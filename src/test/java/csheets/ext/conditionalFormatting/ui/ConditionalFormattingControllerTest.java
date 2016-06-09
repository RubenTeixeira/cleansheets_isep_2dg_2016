///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package csheets.ext.conditionalFormatting.ui;
//
//import csheets.CleanSheets;
//import csheets.core.Cell;
//import csheets.core.IllegalValueTypeException;
//import csheets.core.Spreadsheet;
//import csheets.core.Workbook;
//import csheets.core.formula.compiler.FormulaCompilationException;
//import csheets.ext.style.StylableCell;
//import csheets.ext.style.StyleExtension;
//import csheets.ui.ctrl.UIController;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.junit.After;
//import org.junit.AfterClass;
//import static org.junit.Assert.assertEquals;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
///**
// *
// * @author Diogo Leite
// *
// */
//public class ConditionalFormattingControllerTest {
//
//	UIController uiController;
//	ConditionalFormattingController controller;
//	Cell cell;
//	StylableCell trueStyle;
//	StylableCell falseStyle;
//	CleanSheets app;
//	Workbook workbook;
//	Spreadsheet spreadsheet;
//	String contenteTrue;
//	String contenteFalse;
//
//	public ConditionalFormattingControllerTest() {
//	}
//
//	@BeforeClass
//	public static void setUpClass() {
//	}
//
//	@AfterClass
//	public static void tearDownClass() {
//	}
//
//	@Before
//	public void setUp() {
//		app = new CleanSheets();
//		uiController = new UIController(app);
//		controller = new ConditionalFormattingController(uiController);
//		workbook = new Workbook(1);
//		spreadsheet = workbook.getSpreadsheet(0);
//		cell = spreadsheet.getCell(0, 0);
//		trueStyle = (StylableCell) spreadsheet.getCell(0, 1).getExtension(
//			StyleExtension.NAME);
//		falseStyle = (StylableCell) spreadsheet.getCell(0, 2).getExtension(
//			StyleExtension.NAME);
//		trueStyle.setHorizontalAlignment(0);
//		falseStyle.setHorizontalAlignment(2);
//		contenteTrue = "=2<5";
//		contenteFalse = "=2>5";
//	}
//
//	@After
//	public void tearDown() {
//	}
//
//	/**
//	 * Test of createConditionalCell method, of class
//	 * ConditionalFormattingController.
//	 */
//	@Test
//	public void testApply() {
//		System.out.println("createConditionalCell");
//		ConditionalFormattingController instance = null;
//		try {
//			cell.setContent(contenteTrue);
//		} catch (FormulaCompilationException ex) {
//			Logger.
//				getLogger(ConditionalFormattingControllerTest.class.getName()).
//				log(Level.SEVERE, null, ex);
//		}
//		try {
//			if (cell.getValue().toBoolean()) {
//				controller.changeHorizontalAlign(trueStyle, 0);
//				int expResult = 0;
//
//				int result = trueStyle.getHorizontalAlignment();
//				assertEquals(expResult, result);
//			} else {
//				controller.changeHorizontalAlign(falseStyle, 2);
//				int expResult = 2;
//
//				int result = falseStyle.getHorizontalAlignment();
//				assertEquals(expResult, result);
//			}
//		} catch (IllegalValueTypeException ex) {
//			Logger.
//				getLogger(ConditionalFormattingControllerTest.class.getName()).
//				log(Level.SEVERE, null, ex);
//		}
//
//	}
//
//}
