/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;

/**
 * A Function where the Left Operand will be assigned the Value of the Right
 * Operand.
 *
 * @author Ruben Teixeira 1140780@isep.ipp.pt
 */
public class Assign implements BinaryOperator {

	/**
	 * Creates a new Assign
	 */
	public Assign() {
	}

	@Override
	public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
		return rightOperand.evaluate();
	}

	@Override
	public String getIdentifier() {
		return ":=";
	}

	@Override
	public Value.Type getOperandValueType() {
		return Value.Type.NUMERIC;
	}

	@Override
	public String toString() {
		return getIdentifier();
	}

}
