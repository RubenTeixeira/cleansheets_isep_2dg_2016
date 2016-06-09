/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Diogo Leite
 *
 */
public class ConditionalFormattingControllerTest {

	private Cell cell;
	private ConditionalFormattingController controller;

	public ConditionalFormattingControllerTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		controller = new ConditionalFormattingController(null);
		cell = controller.createConditionalCell();

	}

	@After
	public void tearDown() {
	}

	@Test
	public void isExpressionComparisonTrueTest() {
		try {
			cell.setContent("=2<5");
		} catch (FormulaCompilationException ex) {
			Logger.
				getLogger(ConditionalFormattingControllerTest.class.getName()).
				log(Level.SEVERE, null, ex);
		}

		assertEquals(true, controller.isExpressionComparison(cell));

	}

	@Test
	public void isExpressionComparisonFalseTest() {
		try {
			cell.setContent("=2+5");
		} catch (FormulaCompilationException ex) {
			Logger.
				getLogger(ConditionalFormattingControllerTest.class.getName()).
				log(Level.SEVERE, null, ex);
		}

		assertEquals(false, controller.isExpressionComparison(cell));

	}

	@Test
	public void evaluateExpressionTrueTest() {
		try {
			cell.setContent("=2<5");
		} catch (FormulaCompilationException ex) {
			Logger.
				getLogger(ConditionalFormattingControllerTest.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		boolean result;
		try {
			result = controller.evaluateExpression(cell);
			assertEquals(true, result);
		} catch (IllegalValueTypeException ex) {
			Logger.
				getLogger(ConditionalFormattingControllerTest.class.getName()).
				log(Level.SEVERE, null, ex);
		}

	}

	@Test
	public void evaluateExpressionFalseTest() {
		try {
			cell.setContent("=2>5");
		} catch (FormulaCompilationException ex) {
			Logger.
				getLogger(ConditionalFormattingControllerTest.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		boolean result;
		try {
			result = controller.evaluateExpression(cell);
			assertEquals(false, result);
		} catch (IllegalValueTypeException ex) {
			Logger.
				getLogger(ConditionalFormattingControllerTest.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}

}
