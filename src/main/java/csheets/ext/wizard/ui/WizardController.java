/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.wizard.ui;

import csheets.core.formula.Function;
import csheets.core.formula.lang.Language;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;

/**
 * Controller of the wizard process to simplify the WizardFrame code and use
 * good practices of code structuring
 *
 * @author AB-1140280
 */
public class WizardController {

	UIController uicontroller;

	public WizardController(UIController uicontroller) {
		this.uicontroller = uicontroller;
	}

	public FunctionListModel getFunctions() {
		ArrayList<Function> list = new ArrayList();
		for (Function func : Language.getInstance().getFunctions()) {
			list.add(func);
		}
		FunctionListModel modelList = new FunctionListModel(list);
		return modelList;
	}

}