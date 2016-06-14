package csheets.ext.macro_beanshell;

import csheets.ui.ctrl.UIController;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.UnsupportedDataTypeException;

/**
 * Macro/BeanShell Controller.
 *
 * @author Rui Bento
 * @author José Barros
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

	public void saveScript(String name, String type, String content,
						   boolean synchronous) {

		Code oldCode = uicontroller.getActiveWorkbook().getScript(name);

		if (oldCode != null) {
			uicontroller.getActiveWorkbook().getScripts().remove(oldCode);
		}

		Code code = new Code(name, type, content, synchronous);

		uicontroller.getActiveWorkbook().addScript(code);
	}

	public List<Code> getSavedScripts() {

		return uicontroller.getActiveWorkbook().getScripts();
	}

	public String getScriptContent(String script) throws FileNotFoundException, IOException {

		return uicontroller.getActiveWorkbook().getScript(script).getContent();
	}

	public boolean deleteScript(String script) {

		Code code = uicontroller.getActiveWorkbook().getScript(script);
		return uicontroller.getActiveWorkbook().getScripts().remove(code);
	}

	public void executeScript(String script_name) {

		Code code = uicontroller.getActiveWorkbook().getScript(script_name);

		Script script;

		try {
			script = createScript(code.getType());
			script.run(code.getContent());

		} catch (UnsupportedOperationException ex) {
			System.out.println(ex.getMessage());

		} catch (UnsupportedDataTypeException ex) {
			Logger.getLogger(MacroBeanShellController.class.getName()).
				log(Level.SEVERE, null, ex);
		}
	}
}
