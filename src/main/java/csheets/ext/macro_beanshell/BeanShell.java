/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell;

import bsh.EvalError;
import bsh.Interpreter;
import csheets.ui.ctrl.UIController;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 *
 * @author Rui Bento
 */
public class BeanShell implements Script {

    public final static String NAME = "BeanShell";
    
    private UIController uiController;
    
    public BeanShell(UIController uiController) {
        this.uiController = uiController;
    }
    
    @Override
    public String getExample() {
        return "uiController.getCleansheet().create();\n" +
               "title=\"The BeanShell Mega Title\";\n" +
               "uiController.getActiveSpreadsheet().getCell(0, 0).setContent(\"This is the Spreadsheet title: \"+title);\n" +
               "uiController.getActiveSpreadsheet().setTitle(title);";
    }
    
    @Override
    public String run(String code) {
        String result = "";
        uiController.getActiveSpreadsheet().getCell(1, 1).getContent();
        String instructions[] = separateInstructions(code);
        Interpreter i = new Interpreter();  // Construct an interpreter
        try {
            i.set("uiController", uiController);
        } catch (EvalError ex) {
            return String.format("Error: %s\n", ex.getMessage());
        }
        for (String instruction : instructions) {
            try {
                Object o = i.eval(instruction);
                if(o!=null) {
                    result = o.toString();
                } else {
                    result = "";
                }
            } catch (EvalError ex) {
                return String.format("Error: %s\n", ex.getMessage());
            }
        }
        return result;
    }

    private String[] separateInstructions(String code) {
        //return code.split("(?<=;)");
        return code.split("\n");
        //return new String[] {code};
    }
    
}
