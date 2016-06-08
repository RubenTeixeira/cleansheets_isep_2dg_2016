/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rui Bento
 */
public class BeanShellTest {
    
    private UIController uiController;
    
    public BeanShellTest() {
        this.uiController = UIController.getUIController();
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
     * Test of getExample with run method, of class BeanShell.
     */
    @Test
    public void testExampleTest() {
        System.out.println("BeanShell-ExampleTest and Run it");
        BeanShell instance = new BeanShell(uiController);
        String result = instance.getExample();
        if(result.startsWith("Error: ")) {
            fail("Example not working");
        }
        assertNotNull(result);
    }

    /**
     * Test of run method, of class BeanShell.
     */
    @Test
    public void testRunWithReturn() {
        System.out.println("BeanShell-Return Test of run");
        String code = "return \"Fat Joe is awesome!\";";
        BeanShell instance = new BeanShell(uiController);
        String expResult = "Fat Joe is awesome!";
        String result = instance.run(code);
        if(result.startsWith("Error: ")) {
            fail("Code not working");
        }
        assertNotNull(result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class BeanShell.
     */
    @Test
    public void testRunWithReturn2() {
        System.out.println("BeanShell-Return Test of run");
        String code = "a=2;\n" +
                      "a+=1;\n";
        BeanShell instance = new BeanShell(uiController);
        String expResult = "3";
        String result = instance.run(code);
        if(result.startsWith("Error: ")) {
            fail("Code not working");
        }
        assertNotNull(result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of run method, of class BeanShell.
     */
    @Test
    public void testRunWithoutReturnInfo() {
        System.out.println("BeanShell-Without Return Test of run");
        String code = "a=2;\n" +
                      "print(\"NON\");\n";
        BeanShell instance = new BeanShell(uiController);
        String expResult = "";
        String result = instance.run(code);
        if(result.startsWith("Error: ")) {
            fail("Code not working");
        }
        assertNotNull(result);
        assertEquals(expResult, result);
    }
    
}
