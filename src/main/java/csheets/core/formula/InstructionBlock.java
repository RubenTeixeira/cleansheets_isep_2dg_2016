/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;

/**
 * A Set of Expressions.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class InstructionBlock implements Expression {

	/**
	 * Array with expressions.
	 */
	private Expression[] expressions;

	/**
	 * Creates a new InstructionBlock.
	 *
	 * @param expressions
	 */
	public InstructionBlock(Expression... expressions) {
		this.expressions = expressions;
	}

	/**
	 * Evaluate Expressions.
	 *
	 * @return Value of the final Expression within the InstructionBlock.
	 * @throws IllegalValueTypeException
	 */
	@Override
	public Value evaluate() throws IllegalValueTypeException {

		Value value = null;

		for (int i = 0; i < (this.expressions.length); i++) {
			value = this.expressions[i].evaluate();
		}
		return value;
	}

	/**
	 *
	 * @return Expressions Array
	 */
	public Expression[] getExpressions() {
		return this.expressions;
	}

	/**
	 * Accept
	 *
	 * @return visited
	 * @param visitor
	 */
	@Override
	public Object accept(ExpressionVisitor visitor) {
		return visitor.visitInstructionBlock(this);
	}
}
