/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.wizard.ui;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.formula.Function;
import csheets.core.formula.lang.And;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.Sum;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author AB-1140280
 */
public class WizardControllerTest {

    WizardController controller;
    Function f1;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        f1 = new Sum();
        UIController uiController = UIController.getUIController();
        controller = new WizardController(uiController);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFunctions method, of class WizardController.
     */
    @Test
    public void testGetFunctions() {
        ArrayList<Function> list = new ArrayList();
        for (Function func : Language.getInstance().getFunctions()) {
            list.add(func);
        }
        FunctionListModel expected = new FunctionListModel(list);
        assertEquals(expected, controller.getFunctions());
    }

    /**
     * Test of getFunctionInfo method, of class WizardController.
     */
    @Test
    public void testGetFunctionInfo() {
        String expected = "={SUM(NUMERIC)}";
        assertEquals(expected, controller.getFunctionInfo(f1));
    }
    
}
     // Test of Lang04.2
//    /**
//     * Test of getFunctionInfo method, of class WizardController.
//     */
//    @Test
//    public void testsetValuesOnExpression() {
//        String funcInfo = this.controller.getFunctionInfo(f1);
//        String expected = "={SUM(3;4;5)}";
//        String result = this.controller.setValuesOnExpression("3;4;5", null, null, null);
//        assertEquals(expected, result);
//    }

//    /**
//     * Hard to test compile method without a valid cell, maybe someone smarter
//     * can finish this test
//     * /
//    @Test
//    public void testExecuteFormula() throws Exception {
//        String expected = "5040";
//        String result = controller.executeFormula("={FACT(7)}");
//        assertEquals(expected, result);
//    }

