package csheets.ext.macro_beanshell;

import csheets.ui.ctrl.UIController;

/**
 *
 * @author Rui Bento/ Rui Bastos
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
