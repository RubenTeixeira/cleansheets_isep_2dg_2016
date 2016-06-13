/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell;

import bsh.EvalError;
import bsh.Interpreter;
import bsh.util.JConsole;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Rui Bento
 */
public class BeanShell implements Script {

	/**
	 * consola do interpreter
	 */
	private static final JConsole console = new JConsole();

	/**
	 * Name of the Script
	 */
	public final static String NAME = "BeanShell";

	private UIController uiController;

	private Interpreter interpreter;

	public BeanShell(UIController uiController) {
		this.interpreter = new Interpreter(console);  // Construct an interpreter
		this.uiController = uiController;
	}

	/**
	 * Create example and return it
	 *
	 * @return String example
	 */
	public String getExample() {
		return "uiController.getCleanSheets().create();\n"
			+ "title=\"The BeanShell Mega Title\";\n"
			+ "uiController.getActiveSpreadsheet().setTitle(title);\n"
			+ "sum=1;\n"
			+ "uiController.getActiveSpreadsheet().getCell(0, 0).setContent(\"\"+sum);\n"
			+ "sum+=1;\n"
			+ "uiController.getActiveSpreadsheet().getCell(0, 1).setContent(\"2\");\n"
			+ "sum+=1;\n"
			+ "uiController.getActiveSpreadsheet().getCell(1, 0).setContent(\"3\");\n"
			+ "sum+=1;\n"
			+ "uiController.getActiveSpreadsheet().getCell(1, 1).setContent(\"4\");\n"
			+ "sum+=1;\n";
	}

	/**
	 * Execute the code on param and return the result of the last command. Each
	 * command is separated by line ('\n').
	 *
	 * @param code of the beanshell script
	 * @return result of the script
	 */
	@Override
	public String run(String code) {
		String result = "";
		String instructions[] = separateInstructions(code);
		try {
			interpreter.set("uiController", uiController);
		} catch (EvalError ex) {
			return createErrorMessage(ex.getMessage());
		}
		for (String instruction : instructions) {
			try {
				Object o = interpreter.eval(instruction);
				if (o != null) {
					result = o.toString();
				} else {
					result = "";
				}
			} catch (EvalError ex) {
				return createErrorMessage(ex.getMessage());
			}
		}
		return result;
	}

	private String createErrorMessage(String error) {
		return String.format("Error: %s\n", error);
	}

	private String[] separateInstructions(String code) {
		return code.split("\n");
	}

	/**
	 * Return interpreter of beanShell
	 *
	 * @return interpreter beanshell
	 */
	public Interpreter getInterpreter() {
		return interpreter;
	}
}
