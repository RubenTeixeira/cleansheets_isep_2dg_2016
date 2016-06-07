package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

/**
 * Execution of For Loop.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class For implements Function {

    public static final FunctionParameter[] parameters = new FunctionParameter[]{
        new FunctionParameter(Value.Type.UNDEFINED, "Term1", false,
        "A number to be included in the sum"),
        new FunctionParameter(Value.Type.BOOLEAN, "Condition", false,
        "A condition to evaluate before proceeding"),
        new FunctionParameter(Value.Type.UNDEFINED, "Term3", false,
        "A number to be included in the sum")
    };

    public For() {
    }

    /**
     *
     * @return Identifier
     */
    @Override
    public String getIdentifier() {
        return "FOR";
    }

    /**
     *
     * @param args Array of expressions.
     * @return Returns the value of a cell.
     * @throws IllegalValueTypeException The value can be illegal.
     */
    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        Value value = new Value();
        for (Expression expression : args) {
            System.out.println(expression);
        }
        args[0].evaluate();
        while (args[1].evaluate().toBoolean()) {
            args[2].evaluate();
        }
        return value;
        /*
		Expression assignment = args[0];
		Expression limiter = args[1];
		//expressions[] for instructionblock.
		Expression[] expBlock = new Expression[args.length - 2];
		int j = 0;
		for (int i = 2; i < args.length; i++) {
			expBlock[j] = args[i];
			j++;
		}
		InstructionBlock block = new InstructionBlock(expBlock);
		//starting point.
		assignment.evaluate();
		//limiter validation
		Value flag = limiter.evaluate();
		if (flag.toBoolean() == false) {
			throw new IllegalValueTypeException(flag, flag.getType());
		}
		Value value = new Value();
		while (args[1].evaluate().toBoolean()) {
			value = block.evaluate();
		}
		return value;*/
    }

    public FunctionParameter[] getParameters() {
        return parameters;
    }

    public boolean isVarArg() {
        return false;
    }

    @Override
    public String getDescription() {
        return " Execution of For Loop.";
    }
}
