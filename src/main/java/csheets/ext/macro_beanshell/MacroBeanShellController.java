package csheets.ext.macro_beanshell;

import csheets.ui.ctrl.UIController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.activation.UnsupportedDataTypeException;

/**
 * Macro/BeanShell Controller.
 *
 * @author Rui Bento
 */
public class MacroBeanShellController {

	private UIController uicontroller;
	private BeanShell beanShell;

	public MacroBeanShellController(UIController uicontroller) {
		this.uicontroller = uicontroller;
		this.beanShell = new BeanShell(uicontroller);
	}

	public String executeCode(String scriptType, String code) {
		Script script;
		try {
			script = createScript(scriptType);
		} catch (UnsupportedDataTypeException ex) {
			return ex.getMessage();
		}
		try {
			return script.run(code);
		} catch (UnsupportedOperationException ex) {
			return ex.getMessage();
		}
	}

	private Script createScript(String scriptType) throws UnsupportedDataTypeException {
		if (scriptType != null) {
			switch (scriptType) {
				case BeanShell.NAME: {
					return new BeanShell(uicontroller);
				}
				case Macro.NAME: {
					return new Macro(uicontroller);
				}
			}
		}
		throw new UnsupportedDataTypeException("Unknown script type.");
	}

	public String createExample(String scriptType) {
		Script script;
		try {
			script = createScript(scriptType);
		} catch (UnsupportedDataTypeException ex) {
			return ex.getMessage();
		}
		try {
			return script.getExample();
		} catch (UnsupportedOperationException ex) {
			return ex.getMessage();
		}
	}

	public void saveScript(String name, String code) {

		uicontroller.getActiveWorkbook().addScript(name, code);
	}

	public List<String> getSavedScripts() {

		List<String> list = new ArrayList();

		for (Map.Entry<String, String> entry : uicontroller.getActiveWorkbook().
			getScripts().entrySet()) {
			list.add(entry.getKey());
		}

		return list;
	}

	public void editScript(String new_code, String script) {

		String old_code = uicontroller.getActiveWorkbook().getScripts().
			get(script);
		uicontroller.getActiveWorkbook().getScripts().
			replace(script, old_code, new_code);
	}

	public String getScriptContent(String script) throws FileNotFoundException, IOException {

		return uicontroller.getActiveWorkbook().getScripts().get(script);
	}

	public boolean deleteScript(String script) {

		return uicontroller.getActiveWorkbook().getScripts().remove(script) != null;
	}

	public void executeScript(String script) {

		String code = uicontroller.getActiveWorkbook().getScripts().get(script);
		executeCode(BeanShell.NAME, code);
	}
}
