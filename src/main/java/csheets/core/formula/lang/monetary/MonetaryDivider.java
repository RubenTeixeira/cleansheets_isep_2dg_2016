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
public class MonetaryDivider implements BinaryOperator {

	private static final long serialVersionUID = 4131307438607651284L;

	@Override
	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		//TODO make Money.divide(double)!!!
		return new Value(leftOperand.evaluate().toMoney().amount() / rightOperand.
			evaluate().toMoney().amount());
//		return new Value(leftOperand.evaluate().toMoney().divide(rightOperand.
//			evaluate().toMoney()));
	}

	@Override
	public String getIdentifier() {
		return "/€";
	}

	@Override
	public Value.Type getOperandValueType() {
		return Value.Type.MONEY;
	}

}
