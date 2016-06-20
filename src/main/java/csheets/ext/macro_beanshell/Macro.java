package csheets.ext.macro_beanshell;

import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.MacroExpressionComplier;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Rui Bento/ Rui Bastos
 */
public class Macro implements Script {

	public final static String NAME = "Macro";

	private UIController uiController;

	public Macro(UIController uiController) {
		this.uiController = uiController;
	}

	@Override
	public String getExample() {
		return ";Sets A1 cell content to 1\n"
			+ "A1:= 1\n"
			+ ";Sets B1 cell content to 2(1+A1)\n"
			+ "B1:= {SUM(1;A1)}\n"
			+ ";Sets A2 cell content to 3(1+B1)\n"
			+ "A2:= {SUM(1;B1)}\n"
			+ ";Sets B2 cell content to 4(1+A2)\n"
			+ "B2:= {SUM(1;A2)}";
	}

	@Override
	public String run(String code) {
		Value result = null;
		String instructions[] = separateInstructions(code);

		MacroExpressionComplier compiler = new MacroExpressionComplier(this.uiController);

		for (String instruction : instructions) {
			if (instruction.charAt(0) != ';') {
				try {
					Expression formula = compiler.compile(instruction);
					result = formula.evaluate();
				} catch (Exception ex) {
					return createErrorMessage(ex.getMessage());
				}
			}
		}
		return result.toString();
	}

	private String createErrorMessage(String error) {
		return String.format("Error: %s\n", error);
	}

	/**
	 * Separates the code instructions
	 *
	 * @param code
	 * @return instructions
	 */
	private String[] separateInstructions(String code) {
		return code.split("\n");
	}

}
