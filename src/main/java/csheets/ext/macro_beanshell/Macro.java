/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell;

import csheets.ui.ctrl.UIController;

/**
 *
 * @author Rui Bento
 */
public class Macro implements Script {

    public final static String NAME = "Macro";
    
    private UIController uiController;
    
    public Macro(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    public String getExample() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String run(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
