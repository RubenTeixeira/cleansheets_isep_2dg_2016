/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.InstructionBlock;

/**
 * Execution of For Loop.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class For implements Function {

	//private FunctionParameter[] args;
	private Expression[] args;

//	public For(Expression[] args){
//		//explode
//		this.args = (FunctionParameter[]) args;
//	}
	/**
	 * Create For.
	 */
	public For(Expression... args) {
		this.args = args;

	}

	/**
	 *
	 * @return Identifier
	 */
	@Override
	public String getIdentifier() {
		return "For";
	}

	/**
	 *
	 * @param args
	 * @return
	 * @throws IllegalValueTypeException
	 */
	@Override
	public Value applyTo(Expression[] args) throws IllegalValueTypeException {
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
			throw new IllegalThreadStateException();
		}
		Value value = new Value();
		while (args[1].evaluate().toBoolean()) {
			value = block.evaluate();
		}
		return value;
	}

	/**
	 * TODO.
	 *
	 * @return
	 */
	@Override
	public FunctionParameter[] getParameters() {
		return null;
	}

	/**
	 * n Arguments.
	 *
	 * @return true
	 */
	@Override
	public boolean isVarArg() {
		return true;

	}
}
