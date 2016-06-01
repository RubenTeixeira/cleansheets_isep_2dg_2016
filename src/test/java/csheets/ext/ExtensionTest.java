/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Diogo Azevedo
 */
public class ExtensionTest {

	Extension extTrue;
	Extension extFalse;

	public ExtensionTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		extTrue = new Extension("extensaoT") {
		};
		extFalse = new Extension("extensaoF", false) {
		};
	}

	@After
	public void tearDown() {
	}
//
//    /**
//     * Test of getName method, of class Extension.
//     */
//    @Test
//    public void testGetName() {
//        System.out.println("getName");
//        Extension instance = null;
//        String expResult = "";
//        String result = instance.getName();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isEnabled method, of class Extension.
//     */
//    @Test
//    public void testIsEnabled() {
//        System.out.println("isEnabled");
//        boolean expResult = true;
//        boolean result = extTrue.isEnabled();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of getPropertyKey method, of class Extension.
//     */
//    @Test
//    public void testGetPropertyKey() {
//        System.out.println("getPropertyKey");
//        Extension instance = null;
//        String expResult = "";
//        String result = instance.getPropertyKey();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of compareTo method, of class Extension.
//     */
//    @Test
//    public void testCompareTo() {
//        System.out.println("compareTo");
//        Extension extension = null;
//        Extension instance = null;
//        int expResult = 0;
//        int result = instance.compareTo(extension);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of extend method, of class Extension.
//     */
//    @Test
//    public void testExtend_Spreadsheet() {
//        System.out.println("extend");
//        Spreadsheet spreadsheet = null;
//        Extension instance = null;
//        SpreadsheetExtension expResult = null;
//        SpreadsheetExtension result = instance.extend(spreadsheet);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of extend method, of class Extension.
//     */
//    @Test
//    public void testExtend_Cell() {
//        System.out.println("extend");
//        Cell cell = null;
//        Extension instance = null;
//        CellExtension expResult = null;
//        CellExtension result = instance.extend(cell);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUIExtension method, of class Extension.
//     */
//    @Test
//    public void testGetUIExtension() {
//        System.out.println("getUIExtension");
//        UIController uiController = null;
//        Extension instance = null;
//        UIExtension expResult = null;
//        UIExtension result = instance.getUIExtension(uiController);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of enable method, of class Extension.
//     */
//    @Test
//    public void testEnable() {
//        System.out.println("enable");
//        extFalse.enable();
//        assertEquals(true,extTrue.isEnabled());
//    }
//
//    /**
//     * Test of disable method, of class Extension.
//     */
//    @Test
//    public void testDisable() {
//        System.out.println("disable");
//        extTrue.disable();
//        assertEquals(false,extTrue.isEnabled());
//    }
//
//    public class ExtensionImpl extends Extension {
//
//        public ExtensionImpl() {
//            super("");
//        }
//    }

}
