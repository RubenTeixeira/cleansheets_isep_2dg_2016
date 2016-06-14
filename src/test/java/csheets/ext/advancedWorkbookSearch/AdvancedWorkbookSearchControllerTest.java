/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.advancedWorkbookSearch;

import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for AdvancedWorkbookSearchController. This class allows to perform
 * tests to all methods that handle searching features. By providing a directory
 * and a pattern this controller is able to search for Files in the current
 * machine.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class AdvancedWorkbookSearchControllerTest {

	/**
	 * Flag to check if the files exist.
	 */
	boolean flag = false;

	public AdvancedWorkbookSearchControllerTest() {
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
	 * Test of search method, of class AdvancedWorkbookSearchController.
	 */
	@Test
	public void testSearch() {
		System.out.println("search");
		boolean exist = true;
		String pathName = "C:\\Users\\Pedro\\Documents\\lapr4-2016-2dg\\findWorkbook";
		File dir = new File(pathName);
		String pattern = ".*.cls";
		AdvancedWorkbookSearchController instance = new AdvancedWorkbookSearchController();
		//List<File> expResult = null;
		List<File> result = instance.search(dir, pattern);
		result.stream().
			forEach((f) -> {
				flag = f.exists();
			});
		//assertEquals(1, result.size());
		assertEquals(exist, flag);
	}

}
