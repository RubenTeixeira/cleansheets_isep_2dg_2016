/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang.monetary;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;

/**
 *
 * @author Rui Freitas
 */
public class MonetaryMultiplier implements BinaryOperator {

	private static final long serialVersionUID = 8633576567786564982L;

	@Override
	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		return new Value(leftOperand.evaluate().toMoney().multiply(rightOperand.
			evaluate().toMoney().amount()));
	}

	@Override
	public String getIdentifier() {
		return "*€";
	}

	@Override
	public Value.Type getOperandValueType() {
		return Value.Type.MONEY;
	}

}
