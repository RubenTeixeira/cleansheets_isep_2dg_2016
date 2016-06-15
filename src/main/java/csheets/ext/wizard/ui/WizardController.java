/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.wizard.ui;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.core.formula.lang.Language;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Controller of the wizard process to simplify the WizardFrame code and use
 * good practices of code structuring
 *
 * @author AB-1140280
 */
public class WizardController {

    UIController uicontroller;
    FunctionParameter[] parameters;
    String formulaSelected;
    int i=0;

    public WizardController(UIController uicontroller) {
        this.uicontroller = uicontroller;
        
    }

    public FunctionListModel getFunctions() {
        ArrayList<Function> list = new ArrayList();
        for (Function func : Language.getInstance().getFunctions()) {
            list.add(func);
        }
        return new FunctionListModel(list);
    }

    public String getFunctionInfo(Function func) {
        parameters = func.getParameters();
        this.formulaSelected=func.getTemplate();
        return func.getTemplate();   
    }
    
    public FunctionParameter[] getParametersOfFunctionSelected() {
        return this.parameters;   
    }

    public String executeFormula(String text) throws FormulaCompilationException, IllegalValueTypeException {
        Formula formula = FormulaCompiler.getInstance().compile(uicontroller.getActiveCell(), text);
        Value result = formula.evaluate();
        return result.toString();
    }

    public String setValuesOnExpression(String text, String text0, String text1, String text2) {
        String s=this.formulaSelected;
        String replaced;
        int x=this.parameters.length;
        
        switch (x) {
                        case 0:
                            return s;
                        
			case 1:
				if(text ==null||text.isEmpty()){
                                    throw new IllegalArgumentException("tem que preencher o primeiro parametro.");
                                }
                                ArrayList<FunctionParameter> lst = new ArrayList<>();
                                for(FunctionParameter par:parameters){
                                    lst.add(par);
                                }
                                Iterator<FunctionParameter> it=lst.iterator();
                                FunctionParameter fPara = it.next();
                                String troca = fPara.getValueType().toString();
                                replaced=s.replace(troca, text);
				return replaced;
			case 2:
				if(text ==null||text.isEmpty()||text0 ==null||text0.isEmpty()){
                                    throw new IllegalArgumentException("tem que preencher os dois primeiros parametros.");
                                }
                                ArrayList<FunctionParameter> lst1 = new ArrayList<>();
                                for(FunctionParameter par:parameters){
                                    lst1.add(par);
                                }
                                Iterator<FunctionParameter> it1=lst1.iterator();
                                    FunctionParameter fPara1 = it1.next();
                                String troca1 = fPara1.getValueType().toString();
                                String aux=s.replaceFirst(troca1, text);
                                fPara1 = it1.next();
                                String troca2 = fPara1.getValueType().toString();
                                String replaced1 = aux.replaceFirst(troca2, text0);
				return replaced1;
			case 3:
				if(text ==null||text.isEmpty()||text0 ==null||text0.isEmpty()||text1 ==null||text1.isEmpty()){
                                    throw new IllegalArgumentException("tem que preencher todos os parametros.");
                                }
				return null;
			case 4:
                                if(text ==null||text.isEmpty()||text0 ==null||text0.isEmpty()||text1 ==null||text1.isEmpty()||text2 ==null||text2.isEmpty()){
                                    throw new IllegalArgumentException("tem que preencher todos os parametros.");
                                }
				return null;
		}
        return null;
        
    }

}
