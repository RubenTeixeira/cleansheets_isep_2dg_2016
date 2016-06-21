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
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This class concerns an Array Variable Reference. All variables can be an
 * Array - Global and Local Variables. Therefore from this class will inherit
 * both VariableLocalReference and VariableGlobalReference.
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
	 * Current required position to save a Value in the ArrayList.
	 */
	private int position;

	/**
	 * Creates a VariableArrayReference. The String received has the position on
	 * where to save the current Value.
	 *
	 * @param cell cell
	 * @param variable variable
	 */
	public VariableArrayReference(Cell cell, String variable) {
		this.cell = cell;
		if (variable.contains("[")) {
			String[] temp = variable.split("\\["); //splits the String variable.
			this.variable = temp[0]; //assigns name.
			this.position = Integer.parseInt(temp[1].substring(0, 1));
		} else {
			this.variable = variable;
			this.position = 1;
		}

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
	 * Returns the position on where to insert the Value.
	 *
	 * @return position.
	 */
	public int getPosition() {
		return position;
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
