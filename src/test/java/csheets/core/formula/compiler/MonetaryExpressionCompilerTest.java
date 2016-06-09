/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.compiler;

import csheets.core.Cell;
import csheets.core.formula.Expression;
import org.antlr.runtime.tree.Tree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rui Freitas <1130303@isep.ipp.pt>
 */
public class MonetaryExpressionCompilerTest {

	public MonetaryExpressionCompilerTest() {
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
	 * Test of getStarter method, of class MonetaryExpressionCompiler.
	 */
	@Test
	public void testGetStarter() {
		System.out.println("getStarter");
		MonetaryExpressionCompiler instance = new MonetaryExpressionCompiler();
		char expResult = ' ';
		char result = instance.getStarter();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of compile method, of class MonetaryExpressionCompiler.
	 */
	@Test
	public void testCompile() throws Exception {
		System.out.println("compile");
		Cell cell = null;
		String source = "";
		MonetaryExpressionCompiler instance = new MonetaryExpressionCompiler();
		Expression expResult = null;
		Expression result = instance.compile(cell, source);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of convert method, of class MonetaryExpressionCompiler.
	 */
	@Test
	public void testConvert() throws Exception {
		System.out.println("convert");
		Cell cell = null;
		Tree node = null;
		MonetaryExpressionCompiler instance = new MonetaryExpressionCompiler();
		Expression expResult = null;
		Expression result = instance.convert(cell, node);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

}
