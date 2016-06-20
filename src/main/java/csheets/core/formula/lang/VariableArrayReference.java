/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.Reference;
import csheets.core.formula.util.ExpressionVisitor;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class concerns an Array Variable. All variables can be an Array - Global
 * and Local Variables. Therefore from this class will inherit both
 * VariableLocalReference and VariableGlobalReference.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public abstract class VariableArrayReference implements Reference {

	/**
	 * The Cell to where the variable is initialized.
	 */
	private Cell cell;

	/**
	 * Variable Name.
	 */
	private String variable;

	/**
	 * Value List of this Variable.
	 */
	private List<Value> values;

	/**
	 * Creates a VariableArrayReference.
	 *
	 * @param cell cell
	 * @param variable variable
	 */
	public VariableArrayReference(Cell cell, String variable) {
		this.cell = cell;
		this.variable = variable;
	}

	/**
	 * Returns the Cell.
	 *
	 * @return variable Cell
	 */
	public Cell getCell() {
		return this.cell;
	}

	/**
	 *
	 * @return variables' name.
	 */
	String getVariable() {
		return this.variable;
	}

	/**
	 * This is an abstract method.
	 *
	 * @return Value.
	 */
	@Override
	public abstract Value evaluate();

	/**
	 * Returns an ordered Set of the references' addresses.
	 *
	 * @return TreeSet of Cells.
	 */
	@Override
	public SortedSet<Cell> getCells() {
		SortedSet<Cell> cells = new TreeSet();
		cells.add(this.cell);
		return cells;
	}

	/**
	 * Compares the reference with the given reference for order.
	 *
	 * @param reference Reference.
	 * @return a negative integer, zero, or a positive integer as this object is
	 * less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Reference reference) {
		return reference.getCells().first().compareTo(this.cell); //Only comparing the first Cell of the TreeSet.
	}

	/**
	 *
	 * @param visitor visitor.
	 * @return Object.
	 */
	@Override
	public Object accept(ExpressionVisitor visitor) {
		return null;
	}
}
