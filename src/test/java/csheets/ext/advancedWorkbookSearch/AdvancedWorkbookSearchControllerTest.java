/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.advancedWorkbookSearch;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Tests for AdvancedWorkbookSearchController. This class allows to perform
 * tests to all methods that handle searching features. By providing a temporary
 * folder and a specific pattern - Default pattern in this test - the controller
 * is able to search all files in the giving directory.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class AdvancedWorkbookSearchControllerTest {

	/**
	 * Flag to check if the files exist.
	 */
	boolean flag = true;

	/**
	 * Allow to set up a Temporary Folder for Testing.
	 */
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	/**
	 * File under the Temporary Folder.
	 */
	public File file;

	/**
	 * Instance of AdvancedWorkbookSearchController.
	 */
	private AdvancedWorkbookSearchController instance = new AdvancedWorkbookSearchController();

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
	 * Test of search method, of class AdvancedWorkbookSearchController. The
	 * Result List constains all files located under the Temporary Folder.
	 */
	@Test
	public void testSearch() {
		try {
			file = temporaryFolder.newFile("file.cls");
		} catch (IOException ex) {
			Logger.getLogger(AdvancedWorkbookSearchControllerTest.class.
				getName()).
				log(Level.SEVERE, null, ex);
		}
		System.out.println("search");
		boolean exist;
		String pattern = ".*.cls";
		List<File> result = instance.search(temporaryFolder.getRoot(), pattern);
		exist = result.contains(file);
		assertEquals(flag, exist);
	}

}
