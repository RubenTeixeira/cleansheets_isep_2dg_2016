/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell;

import bsh.EvalError;
import bsh.Interpreter;
import csheets.ui.ctrl.UIController;


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
        return "uiController.getCleanSheets().create();\n" +
               "title=\"The BeanShell Mega Title\";\n" +
               "sum=1;\n" +
               "uiController.getActiveSpreadsheet().getCell(0, 0).setContent(\"1\");\n" +
               "sum+=1;\n" +
               "uiController.getActiveSpreadsheet().getCell(0, 1).setContent(\"2\");\n" +
               "sum+=1;\n" +
               "uiController.getActiveSpreadsheet().getCell(1, 0).setContent(\"3\");\n" +
               "sum+=1;\n" +
               "uiController.getActiveSpreadsheet().getCell(1, 1).setContent(\"4\");\n" +
               "sum+=1;\n" +
               "uiController.getActiveSpreadsheet().setTitle(title);\n" +
               "return \"Result is: \"+sum;\n";
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
        return code.split("\n");
    }
    
}
