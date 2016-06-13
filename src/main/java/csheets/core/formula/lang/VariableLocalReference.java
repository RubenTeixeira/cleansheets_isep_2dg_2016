/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.Value;
import csheets.core.formula.Reference;
import csheets.core.formula.util.ExpressionVisitor;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A reference to a cell in a spreadsheet.
 *
 * @author Einar Pehrson
 */
public class VariableLocalReference implements Reference {

	/**
	 * The cell to which the reference points
	 */
	private Cell cell;

	private String variable;

	/**
	 * Creates a new cell reference to the given address. By default, relative
	 * addressing is used.
	 *
	 * @param cell the cell to which the reference points
	 * @param variable variable
	 */
	public VariableLocalReference(Cell cell, String variable) {
		this.cell = cell;
		this.variable = variable;
	}

	public Value evaluate() {
		return ((CellImpl) cell).getVariable(this.variable);
	}

	/**
	 * Returns the cell to which the reference points.
	 *
	 * @return the cell to which the reference points
	 */
	public Cell getCell() {
		return cell;
	}

	String getVariable() {
		return this.variable;
	}

	@Override
	public SortedSet<Cell> getCells() {
		SortedSet<Cell> cells = new TreeSet();
		cells.add(this.cell);
		return cells;
	}

	@Override
	public int compareTo(Reference reference) {
		return reference.getCells().first().compareTo(this.cell);
	}

	@Override
	public Object accept(ExpressionVisitor visitor) {
		return null;
	}

}
