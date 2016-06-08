/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell;

import csheets.ui.ctrl.UIController;
import javax.activation.UnsupportedDataTypeException;

/**
 * Macro/BeanShell Controller.
 *
 * @author Rui Bento
 */
public class MacroBeanShellController {

    private UIController uicontroller;

    public MacroBeanShellController(UIController uicontroller) {
        this.uicontroller = uicontroller;
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

}
