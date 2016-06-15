package csheets.core;

import csheets.ext.macro_beanshell.BeanShell;
import csheets.ext.macro_beanshell.Code;
import csheets.ext.macro_beanshell.Macro;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class WorkbookTest {

	private List<Code> scripts;
	private Workbook workbook;
	private final Code code1;
	private final Code code2;

	public WorkbookTest() {
		this.workbook = new Workbook(2);

		scripts = new ArrayList<>();
		code1 = new Code("test1", BeanShell.NAME, "Hello world", true);
		scripts.add(code1);
		code2 = new Code("test2", Macro.NAME, "Amazing", false);
		scripts.add(code2);

		workbook.getScripts().addAll(scripts);
	}

	@Test
	public void testGetSpreadsheetCount() {

		// create a workbook with 2 sheets
		Workbook wb = new Workbook(2);

		assertEquals("Result", 2, wb.getSpreadsheetCount());
	}

	@Test
	public void testGetScriptWithWrongName() {
		String scriptToReturn = "test3";
		Code code = workbook.getScript(scriptToReturn);
		Assert.assertNull(code);
	}

	@Test
	public void testGetScriptWithRightName() {
		String scriptToReturn = "test2";
		Code code = workbook.getScript(scriptToReturn);
		Assert.assertNotNull(code);
		assertEquals(code, code2);
	}

	@Test
	public void testAddScript() {
		int firstSize = workbook.getScripts().size();
		System.out.println("First Length = " + firstSize);

		Code code3 = new Code("test3", BeanShell.NAME, "Hi", false);
		Assert.assertNotNull(code3);
		workbook.addScript(code3);

		int secondSize = workbook.getScripts().size();
		System.out.println("Second Length = " + secondSize);

		assertTrue(secondSize > firstSize);
	}

	@Test
	public void testClearList() {
		int firstSize = workbook.getScripts().size();
		System.out.println("First Length = " + firstSize);

		workbook.clearScripts();

		int secondSize = workbook.getScripts().size();
		System.out.println("Second Length = " + secondSize);

		assertTrue(secondSize < firstSize);
		assertEquals("Size", 0, workbook.getScripts().size());
	}

}
