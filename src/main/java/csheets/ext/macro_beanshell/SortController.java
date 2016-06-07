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
    
    public String executeCode(String scriptType, String code) throws UnsupportedDataTypeException {
        Script script = createScript(scriptType);
        if(script == null) throw new UnsupportedDataTypeException("Unknown script type.");
        return script.run(code);
    }
    
    private Script createScript(String scriptType) {
        switch(scriptType) {
            case BeanShell.NAME: {
                return new BeanShell();
            }
            case Macro.NAME: {
                return new Macro();
            }
        }
        return null;
    }

}
