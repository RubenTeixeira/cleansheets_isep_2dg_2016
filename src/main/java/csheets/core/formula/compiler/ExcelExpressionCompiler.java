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
 * 
 * ATB (April, 2014): Updated to use antlr3 generated parser and lexer
 */
package csheets.core.formula.compiler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionCall;
import csheets.core.formula.Literal;
import csheets.core.formula.Reference;
import csheets.core.formula.UnaryOperation;
import csheets.core.formula.lang.CellReference;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.RangeReference;
import csheets.core.formula.lang.ReferenceOperation;
import csheets.core.formula.lang.UnknownElementException;

/**
 * A compiler that generates Excel-style formulas from strings.
 * @author Einar Pehrson
 */
public class ExcelExpressionCompiler implements ExpressionCompiler {

	/** The character that signals that a cell's content is a formula ('=') */
	public static final char FORMULA_STARTER = '=';

	/**
	 * Creates the Excel expression compiler.
	 */
	public ExcelExpressionCompiler() {}

	public char getStarter() {
		return FORMULA_STARTER;
	}

	public Expression compile(Cell cell, String source) throws FormulaCompilationException {
		// Creates the lexer and parser
		ANTLRStringStream input = new ANTLRStringStream(source);
		
		// create the buffer of tokens between the lexer and parser 
		FormulaLexer lexer=new FormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		FormulaParser parser = new FormulaParser(tokens);
		
		CommonTree tree = null;	
	
		try {
			// Attempts to match an expression
			tree=(CommonTree)parser.expression().getTree();
		} /* catch (MismatchedTokenException e){
	        //not production-quality code, just forming a useful message
	        String expected = e.expecting == -1 ? "<EOF>" : parser.tokenNames[e.expecting];
	        String found = e.getUnexpectedType() == -1 ? "<EOF>" : parser.tokenNames[e.getUnexpectedType()];

	        String message="At ("+e.line+";"+e.charPositionInLine+"): "+"Fatal mismatched token exception: expected " + expected + " but was " + found;   
	        throw new FormulaCompilationException(message);
	    } catch (NoViableAltException e) {
	    	//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
	    	String message=parser.getErrorMessage(e, parser.tokenNames);
	    	String message2="At ("+e.line+";"+e.charPositionInLine+"): "+message;
	    	throw new FormulaCompilationException(message2);
	    } */
		catch (RecognitionException e) {
	    	//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
	    	String message=parser.getErrorMessage(e, parser.tokenNames);
	    	throw new FormulaCompilationException("At ("+e.line+";"+e.charPositionInLine+"): "+message);
	    } catch (Exception e) {
	    	String message="Other exception : " + e.getMessage();
	    	throw new FormulaCompilationException(message);
	    } 
		
		// Converts the expression and returns it
		return convert(cell, tree);
	}

	/**
	 * Converts the given ANTLR AST to an expression.
         * @param cell cell
	 * @param node the abstract syntax tree node to convert
	 * @return the result of the conversion
         * @throws csheets.core.formula.compiler.FormulaCompilationException exception
	 */
	protected Expression convert(Cell cell, Tree node) throws FormulaCompilationException {
		// System.out.println("Converting node '" + node.getText() + "' of tree '" + node.toStringTree() + "' with " + node.getNumberOfChildren() + " children.");
		if (node.getChildCount() == 0) {
			try {
				switch (node.getType()) {
					case FormulaLexer.NUMBER:
						return new Literal(Value.parseNumericValue(node.getText()));
					case FormulaLexer.STRING:
						return new Literal(Value.parseValue(node.getText(), Value.Type.BOOLEAN, Value.Type.DATE));
					case FormulaLexer.CELL_REF:
						return new CellReference(cell.getSpreadsheet(), node.getText());
//					case FormulaParserTokenTypes.NAME:
						/* return cell.getSpreadsheet().getWorkbook().
							getRange(node.getText()) (Reference)*/
				}
			} catch (ParseException e) {
				throw new FormulaCompilationException(e);
			}
		}
                
		// Convert function call
		Function function = null;
		try {
			function = Language.getInstance().getFunction(node.getText());
		} catch (UnknownElementException e) {}

		if (function != null) {
			List<Expression> args = new ArrayList<Expression>();
			Tree child = node.getChild(0);
			if (child != null) {
				for (int nChild=0; nChild<node.getChildCount(); ++nChild) {
					child = node.getChild(nChild);
					args.add(convert(cell, child));
				}
			}
			Expression[] argArray = args.toArray(new Expression[args.size()]);
			return new FunctionCall(function, argArray);
		}

		if (node.getChildCount() == 1)
			// Convert unary operation
			return new UnaryOperation(
				Language.getInstance().getUnaryOperator(node.getText()),
				convert(cell, node.getChild(0))
			);
		else if (node.getChildCount() == 2) {
			// Convert binary operation
			BinaryOperator operator = Language.getInstance().getBinaryOperator(node.getText());
			if (operator instanceof RangeReference)
				return new ReferenceOperation(
					(Reference)convert(cell, node.getChild(0)),
					(RangeReference)operator,
					(Reference)convert(cell, node.getChild(1))
				);
			else 
				return new BinaryOperation(
					convert(cell, node.getChild(0)),
					operator,
					convert(cell, node.getChild(1))
				);
		}  else
			// Shouldn't happen
			throw new FormulaCompilationException();
        }
}
