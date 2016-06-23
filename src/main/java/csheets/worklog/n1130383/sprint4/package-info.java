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
 * <p>
 * During this week I’ve spent a significant amount of time with this feature.
 * Although it wasn’t hard, it was definitely extensive to perform all the
 * required analysis and design for both Use Cases. The feature was implemented
 * with the necessary requirements and some additional functionalities.
 * Alongside this implementation I’ve paired up with my colleague Rúben Teixeira
 * – 1140780 to solve difficulties from my part as from his.</p>
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
 * the name of the variable). For example, the formula
 * <code>=@abc[2]:=123</code> will set the position 2 of the global variable
 * '@abc' to the value 123. Each position of an array can be of a different
 * type. For instance it should be possible to have an array with numeric and
 * alphanumeric values. There should also be a window in the sidebar to display
 * and edit the value of global variables. The values that appear in this window
 * should be automatically updated when the variables are updated.</p>
 *
 * <p>
 * <b>Use Case: Array Variables Support</b>: Both temporal and global variables
 * should now support an array of values. All values from one variable should be
 * accessed by its position on the array. Both variable types should be
 * initialized inside a opened Workbook. The Assign operations assigns a value
 * to one specific position of the Array. <code>=@global[2]:=3</code> - This
 * will assign the value 3 into the second position of the global (@) variable
 * '@global'. The token '_' is used for local (temporal) variables.</p>
 *
 * <p>
 * <b>Use Case: Edit global Variables Side Bar</b>: Cleansheets application
 * should have a side bar linked to the workbook in the current workspace. The
 * side bar should provide access to its Global variables and allow the editing
 * of its values in the used positions.</p>
 *
 *
 * <h2>4. Analysis</h2>
 * <p>
 * For the Analysis of this feature it’s important to perform and read both
 * analysis of the previous features that led to this one. First one being
 * <b>Support for Temporal Variables</b> and second being <b>Support for Global
 * Variables</b>. It’s known that these tokens '_' and '@' allow to initialize
 * these different Variables. But how does the process work?</p>
 *
 * <p>
 * By analyzing the current class <code>ExcelExpressionCompiler</code>, when the
 * method compile() is running and after the grammar interpretation, the
 * Expression <code>=@global:=2</code> its recognized as a <b>Binary
 * Operation</b>. The Parse Tree recognizes the node as an Assign Operator
 * (':=') and the Childs that descend from this node are both '@global', as Left
 * Operant, and '2' as Right Operant.</p>
 *
 * <p>
 * The operation then proceeds to recursively detect the reference belonging to
 * each Child. In this case, '@global' is recognized as a
 * <code>FormulaLexer.VARG_REF</code> and the value '2' as a
 * <code>FormulaLexer.NUMBER</code>. This excerpt of Code is important to
 * understand how to implement the feature:
 * <pre>
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
 * <p>
 * For this feature, the main goal it’s to detect both variables as a
 * <code>FormulaLexer.ARRAY_REF</code> when, in the Left Operant, there are
 * Straight Brackets '[]' and one or more digits inside [{0,1,2,3,4,5,6,7,8,9}].
 * This requires adding code to <code>FormulaLexer.java</code>.</p>
 * <p>
 * Update on this Subject:</p>
 * <p>
 * It wasn't necessary to take this approach since both variables reference are
 * now inherited from <code>VariableArrayReference</code> as seen in the Class
 * Diagram of this Use Case. The class <code>ExcelExpressionCompiler</code>
 * still differs one local variable from a global variable as said before. The
 * way it was implemented, it's guaranteed the increase of cohesion.</p>
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
 * VART_REF (LSBRA DIGIT+ RSBRA)?; - Temporal Variable followed by
 * [*digit*]</li>
 * <li>
 * VARG_REF (LSBRA DIGIT+ RSBRA)? – Global Variable followed by [*digit*]</li>
 * </ul>
 *
 * <p>
 * By performing this changes it should be possible to retrieve the correct
 * reference and work with the expresiion - '@global[2]'.</p>
 * <p>
 * From the previous Features two classes are important
 * <code>VariableLocalReference</code> and <code>VariableGlobalReference</code>.
 * Both classes create a reference from where(Cell) the variable was initialized
 * and its name. An object of <code>VariableLocalReference</code> is linked to a
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
 * solution.</p>
 *
 * <h3>First Analysis Diagram</h3>
 *
 * <p>
 * <img src="http://i.imgur.com/ZZ2FQlV.jpg" alt="Class Diagram Analysis"></p>
 *
 * <h2>5. Design</h2>
 *
 * <h3>Class Diagram of Use Case - Array Variable Support.</h3>
 * <p>
 * <img src="http://i.imgur.com/y319gjS.jpg" alt="Class Diagram"></p>
 *
 * <h3>Class Diagram of Use Case - Edit Variable SideBar.</h3>
 * <p>
 * <img src="doc-files/lang02.3_class_diagram.png" alt="Class Diagram"></p>
 *
 * <h3>Sequence Diagram of Use Case - Edit Variable SideBar.</h3>
 * <p>
 * <img src="doc-files/lang02.3_sequence_diagram.png" alt="Sequence Diagram"></p>
 *
 * <h3>Functional Tests</h3>
 * <p>
 * Tests will be performed to test the used Grammar. If it recognizes all tokens
 * and rules associated with an Array Reference. All <code>evaluate()</code>
 * methods should also be tested for their specific behaviour.</p>
 *
 * <p>
 * Tests were added for the Assign to test if the value assigned to a specific
 * position of the Array works as expected.The tests performed in this Class
 * also allow to test if the <code>ExcelExpressionCompiler</code> returns the
 * <code>Reference</code> required to interpret whether if it is a
 * <code>VariableLocalReference</code> or
 * <code>VariableGlobalReference</code>.</p>
 *
 * <h3>UC Realization</h3>
 * <p>
 * This feature was divided into two Use Caso due to the extensive amount of
 * work required. The separation provided a better Analysis to set the paths on
 * how to implement.</p>
 *
 * <h3>Classes</h3>
 * <p>
 * The list above has sorted information to help understand what classes were
 * added, what classes were updated and what operations they provide:<ul>
 * <li><b>Formula.g</b>:Added two new tokens and two new rules so the
 * application is able to recognize an VariableArray, as explained above in the
 * analysis.<ul>
 * <li>LSBRA: '[' ;</li>
 * <li>RSBRA: ']' ;</li>
 * <li>VART_REF : UNDR ( LETTER | DIGIT )+ (LSBRA DIGIT+ RSBRA)?;</li>
 * <li>VARG_REF : ARRB ( LETTER | DIGIT )+ (LSBRA DIGIT+ RSBRA)?;</li></ul>
 *
 * <li><b>VaribleGlobalReference</b>: Updated. This class now extends
 * VariableArrayReference since all Variables must be an array. This
 * implementation is better described in the Class Diagram provided above.</li>
 *
 * <li><b>VaribleLocalReference</b>: Updated. This class now extends
 * VariableArrayReference as well.</li>
 *
 * <li><b>VariableArrayReference</b>: Created. This class provides the necessary
 * operations for the creation of a VariableArray.</li>
 *
 * <li><b>CellImpl</b>: Updated. This class was updated according to the design,
 * it uses the concept of VariableArray and saves its variables in a ArrayList.
 * The methods implemented operate directly with this ArrayList whether to add
 * new values to one specific variable, add a new variable or search for a
 * specific variable of value.</li>
 *
 * <li><b>Workbook</b>: Updated. This class got similar updates as CellImpl
 * except for some bonus methods to work alongside the sidebar required to
 * implement.</li>
 *
 * <li><b>Assign</b>: Updated. Among the most important Class to look at when
 * analysing this feature. The Assign is responsible for creating a new
 * variable, assign it the given value and add it to the Workbook, in case of a
 * global variable, or to a Cell, in case of local variable.</li>
 *
 * <li><b>VariableArray</b>: Created. A new concept for variable was
 * implemented. Both Cell and Workbook work with objects from this Class. For
 * this use case its all.</li></ul>
 *
 * <p>
 * The Classes listed below where added for Use Case 2 of this Feature<ul>
 * <li><b>WorkbookGlobalVariableUI.</b></li>
 * <li><b>WorkbookGlobalVariableExtension.</b></li>
 * <li><b>WorkbookGlobalVariableController.</b></li>
 * <li><b>WorkbookGlobalVariablePanel</b>: Provides the main interaction with
 * the user.</li>
 * <li><b>WorkbookGlobalVariableEditDialog:</b>Provides Edit Value of variable
 * interaction with the user.</li>
 * <li><b>WorkbookGlobalVariableAddDialog.</b>Provides Add Value of variable
 * interaction with the user.</li></ul>
 *
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
 * 1. Started Analysis.
 * <p>
 * 1. Updated Formula.g file according to new Tokens and Expressions.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <p>
 * <b>Monday</b>
 * <p>
 * Yesteday:
 * <p>
 * 1. Analysis developed as expected.
 * <p>
 * Today:
 * <p>
 * 1. First Design Solutions for first Use Case of this feature.
 * <p>
 * 2. Test Solutions for first Use Case.
 * <p>
 * 3. Implementation of the first Use Case.
 * <p>
 * 2. Reunion with Product Owner.
 * <p>
 * 2. Reunion with Manager.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <p>
 * <b>Tuesday</b>
 * <p>
 * Yesteday:
 * <p>
 * 1. All Tasks from yesterday were done as expected.
 * <p>
 * Today:
 * <p>
 * 1. Updated Diagrams for first Use Case.
 * <p>
 * 2. Started Design - Class placement for Second Use Case of this Feature.
 * <p>
 * 2. Reunion with Supervisor.
 * <p>
 * Blocking:
 * <p>
 * 1. nothing.
 *
 * <p>
 * <b>Wednesday</b>
 * <p>
 * Yesteday:
 * <p>
 * 1. All Tasks from yesterday were done as expected.
 * <p>
 * Today:
 * <p>
 * 1. Finished Implementation from second Use Case from this feature.
 * <p>
 * 2. Finished Design from second Use Case.
 * <p>
 * 2. Performed Tests.
 * <p>
 * 2. Reunion with Supervisor.
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
