/**
 * Technical documentation regarding the work of the team member (1130383) Pedro
 * Gomes during week4.
 *
 * <p>
 * <b>Scrum Master:</b>no.
 *
 * <p>
 * <b>Area Leader:</b>no.
 *
 * <h2>1. Notes</h2>
 *
 * -Notes about the week's work.-
 * <p>
 * -In this section you should register important notes regarding your work
 * during the week. For instance, if you spend significant time helping a
 * colleague or if you work in more than a feature.-
 *
 * <h2>2. Use Case/Feature: Lang02.3</h2>
 *
 * <b>Issue in Jira:</b>
 * <p>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-32">LPFOURDG-32</a></p>
 * <b>Sub-tasks:</b><ul>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-334">LPFOURDG-334</a></li>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-335">LPFOURDG-335</a></li>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-336">LPFOURDG-336</a></li>
 * <li>
 * <a href="http://jira.dei.isep.ipp.pt:8080/browse/LPFOURDG-337">LPFOURDG-337</a></li>
 * </ul>
 *
 * <h2>3. Requirement</h2>
 * <p>
 * Add support for array variables (temporary and global). Any variable can be
 * an array. When accessing a variable only by its name it should be inferred
 * the position 1 of the array. To explicitly access a position in a array
 * variable the position index should be specified inside brackets (following
 * the name of the variable). For example, the formula '=@abc[2]:=123' will set
 * the position 2 of the global variable @abc to the value 123. Each position of
 * an array can be of a different type. For instance it should be possible to
 * have an array with numeric and alphanumeric values. There should also be a
 * window in the sidebar to display and edit the value of global variables. The
 * values that appear in this window should be automatically updated when the
 * variables are updated.</p>
 *
 * <p>
 * <b>Use Case: Array Variables Support</b>: Both temporal and global variables
 * should now support an array of values. All values from one variable should be
 * accessed by its position on the array. Both variable types should be
 * initialized inside a opened Workbook. The Assign operations assign a value to
 * one specific position of the Array. <code>=@global[2]:=3</code> - This will
 * assign the value 3 into the second position of the global (@) variable
 * '@global'. The token _ is used for local/temporal variables.</p>
 *
 * <p>
 * <b>Use Case: Edit global Variables Side Bar</b>: Cleansheets application
 * should have a side bar linked to the workbook opened in the current
 * workspace. The side bar should provide access to its Global variables and
 * allow the editing of its values in the used positions.</p>
 *
 *
 * <h2>4. Analysis</h2>
 * <p>
 * For the Analysis of this feature it’s important to perform and read both
 * analysis of the previous features that led to this one. First one being
 * <b>Support for Temporal Variables</b> and second being <b>Support for Global
 * Variables</b>. It’s known that these tokens _ and @ allow to initialize these
 * different Variables. But how does the process work?</p>
 *
 * <p>
 * By analyzing the current class <code>ExcelExpressionCompiler</code>, when the
 * method compile() is running and after the grammar interpretation, the
 * Expression <code>=@global:=2</code> its recognized as a Binary Operation. The
 * Parse Tree recognizes the node as an Assign Operator (':=') and the Childs
 * that descend from this node are both '@global', as Left Operant, and '2' as
 * Right Operant.</p>
 *
 * <p>
 * The operation then proceeds to recursively detect the reference belonging to
 * each Child. In this case, '@global' is recognized as a
 * <code>FormulaLexer.VARG_REF</code> and the '2' as a
 * <code>FormulaLexer.NUMBER CODE</code>. This excerpt of Code is important to
 * understand how to implement the feature:
 * <pre>
 *
 * {@code
 *		if (node.getChildCount() == 0) {
 *		try {
 *			switch (node.getType()) {
 *				case FormulaLexer.CELL_REF:
 *					return new CellReference(cell.getSpreadsheet(), node.getText());
 *				case FormulaLexer.VART_REF:
 *					return new VariableLocalReference(cell, node.getText());
 *				case FormulaLexer.VARG_REF:
 *					return new VariableGlobalReference(cell, node.getText());
 *				case FormulaLexer.NUMBER:
 *					return new Literal(Value.parseNumericValue(node.getText()));
 *				case FormulaLexer.STRING:
 *					return new Literal(Value.
 *					parseValue(node.getText(), Value.Type.BOOLEAN, Value.Type.DATE));
 *				}
 *			} catch (ParseException e) {
 *			throw new FormulaCompilationException(e);
 *			}
 *		}
 * }
 * </pre>
 *
 * <p>
 * For this feature, the main goal it’s to detect both variables as an
 * <code>FormulaLexer.ARRAY_REF</code> when, in the Left Operant, there are
 * Straight Brackets '[]' and one or more digits inside [{0,1,2,3,4,5,6,7,8,9}].
 * This requires adding code to <code>FormulaLexer.java</code>.</p>
 *
 * <p>
 * It’s also necessary to edit the grammar rules, <code>Formula.g</code> and add
 * new tokens: <ul>
 * <li>
 * Left Straight Bracket - [;</li>
 * <li>
 * Right Straight Bracket - ];</li>
 * </ul>
 * Both under the Miscellaneous operators.
 * <p>
 * The new rules to add would be similar to this:<ul>
 * <li>
 * VART_REF (LSBRA DIGIT+ RSBRA)?; - Temporal Variable followed by [*digit*]
 * VARG_REF</li>
 * <li>
 * (LSBRA DIGIT+ RSBRA)? – Global Variable followed by [*digit*]</li>
 * </ul>
 *
 * <p>
 * By performing this changes it should be possible to retrieve the correct
 * reference and work with the retrieved text, such as '@global[2]'.</p>
 * <p>
 * From the previous Features two classes are important
 * <code>VariableLocalReference</code> and <code>VariableGlobalReference</code>.
 * Both classes create a reference from where the variable was initialized and
 * its name. An object of <code>VariableLocalReference</code> is linked to a
 * Cell, with no Serialization, which means that, at close-up, the variables and
 * their correspondent Value would not be saved. However, an object of
 * <code>VariableGlobalReference</code> is linked to a Workbook and saved with
 * it. For as long as that Workbook prevails the variable and its correspondent
 * value should also exist, the user should also be able to delete it.
 * <p>
 * A possible Solution would be to add at both this classes an ArrayList of
 * Values to store the assign Values. This would led to a change in both Classes
 * <code>Workbook.java</code> and <code>CellImpl.java</code> that are currently
 * using an HashMap(String,Value) to assign to a variable (String) one and only
 * one Value (Value). This solution would probably over-complicate the situation
 * and promote Low cohesion among this classes. This will be the current
 * solution:</p>
 *
 *
 * <h3>First "analysis" sequence diagram</h3>
 *
 * <h3>Analysis of Core Technical Problem</h3>
 *
 * <h2>5. Design</h2>
 *
 * <h3>Functional Tests</h3>
 *
 *
 * <h3>UC Realization</h3>
 *
 * <h3>Extension Setup</h3>
 *
 * <h3>Classes</h3>
 *
 * <h3>Design Patterns and Best Practices</h3>
 *
 * <h2>6. Implementation</h2>
 *
 * <h2>7. Integration/Demonstration</h2>
 *
 * <h2>8. Final Remarks</h2>
 *
 * <h2>9. Work Log</h2>
 * <p>
 * <b>Sunday</b>
 * <p>
 * Today:
 * <p>
 * 1. Starte Analysis.
 * <p>
 * 1. Updated Formula.g file according to new Tokens and Expressions.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <h2>10. Self Assessment</h2>
 *
 * <h3>Design and Implementation:</h3>
 *
 * <h3>Teamwork:</h3>
 *
 * <h3>Technical Documentation:</h3>
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
package csheets.worklog.n1130383.sprint4;

/**
 * This class is only here so that javadoc includes the documentation about this
 * EMPTY package! Do not remove this class!
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
class _Dummy_ {
}
