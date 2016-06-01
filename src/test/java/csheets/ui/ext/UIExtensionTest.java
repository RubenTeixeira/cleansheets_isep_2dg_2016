/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ext;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Diogo Azevedo
 */
public class UIExtensionTest {

	UIExtension uiExtTrue;
	UIExtension uiExtFalse;

	public UIExtensionTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		UIController uiCtrl = new UIController(new CleanSheets());

		Extension extTrue = new Extension("extensaoT") {
		};
		Extension extFalse = new Extension("extensaoF", false) {
		};

		uiExtTrue = new UIExtension(extTrue, uiCtrl) {
		};
		uiExtFalse = new UIExtension(extFalse, uiCtrl) {
		};
	}

	@After
	public void tearDown() {
	}
//
//    /**
//     * Test of getExtension method, of class UIExtension.
//     */
//    @Test
//    public void testGetExtension() {
//        System.out.println("getExtension");
//        UIExtension instance = null;
//        Extension expResult = null;
//        Extension result = instance.getExtension();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEnabledProperty method, of class UIExtension.
//     */
//    @Test
//    public void testGetEnabledProperty() {
//        System.out.println("getEnabledProperty");
//        String propKey = "";
//        UIExtension instance = null;
//        Boolean expResult = null;
//        Boolean result = instance.getEnabledProperty(propKey);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setEnabledProperty method, of class UIExtension.
//     */
//    @Test
//    public void testSetEnabledProperty() {
//        System.out.println("setEnabledProperty");
//        String propKey = "";
//        boolean enabled = false;
//        UIExtension instance = null;
//        instance.setEnabledProperty(propKey, enabled);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIcon method, of class UIExtension.
//     */
//    @Test
//    public void testGetIcon() {
//        System.out.println("getIcon");
//        UIExtension instance = null;
//        Icon expResult = null;
//        Icon result = instance.getIcon();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCellDecorator method, of class UIExtension.
//     */
//    @Test
//    public void testGetCellDecorator() {
//        System.out.println("getCellDecorator");
//        UIExtension instance = null;
//        CellDecorator expResult = null;
//        CellDecorator result = instance.getCellDecorator();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getTableDecorator method, of class UIExtension.
//     */
//    @Test
//    public void testGetTableDecorator() {
//        System.out.println("getTableDecorator");
//        UIExtension instance = null;
//        TableDecorator expResult = null;
//        TableDecorator result = instance.getTableDecorator();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMenu method, of class UIExtension.
//     */
//    @Test
//    public void testGetMenu() {
//        System.out.println("getMenu");
//        UIExtension instance = null;
//        JMenu expResult = null;
//        JMenu result = instance.getMenu();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getToolBar method, of class UIExtension.
//     */
//    @Test
//    public void testGetToolBar() {
//        System.out.println("getToolBar");
//        UIExtension instance = null;
//        JToolBar expResult = null;
//        JToolBar result = instance.getToolBar();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getSideBar method, of class UIExtension.
//     */
//    @Test
//    public void testGetSideBar() {
//        System.out.println("getSideBar");
//        UIExtension instance = null;
//        JComponent expResult = null;
//        JComponent result = instance.getSideBar();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isEnabled method, of class UIExtension.
//     */
//    @Test
//    public void testIsEnabled() {
//      System.out.println("isEnabled");
//        boolean expResult = true;
//        boolean result = uiExtTrue.isEnabled();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of enable method, of class UIExtension.
//     */
//    @Test
//    public void testEnable() {
//        System.out.println("enable");
//        uiExtFalse.enable();
//        assertEquals(true,uiExtTrue.isEnabled());
//    }
//
//    /**
//     * Test of disable method, of class UIExtension.
//     */
//    @Test
//    public void testDisable() {
//        System.out.println("disable");
//        uiExtTrue.disable();
//        assertEquals(false,uiExtTrue.isEnabled());
//    }
//
//    public class UIExtensionImpl extends UIExtension {
//
//        public UIExtensionImpl() {
//            super(null, null);
//        }
//    }

}
