/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.wizard.ui;

import csheets.core.formula.Function;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author AB-1140280
 */
public class FunctionListModel extends DefaultListModel<String> {

    public ArrayList<Function> listSubjects;

    public FunctionListModel(ArrayList<Function> listSubjects) {
        this.listSubjects = listSubjects;
    }

    @Override
    public int getSize() {
        return listSubjects.size();
    }

    @Override
    public String getElementAt(int index) {
        return listSubjects.get(index).getIdentifier();
    }

    public String getFunctionInfo(int index, WizardController controller) {
        return controller.getFunctionInfo(listSubjects.get(index));
    }

    public String getHelp(int selectedIndex) {
        //listSubjects.get(selectedIndex).getDescription();
        return "To be done";
    }
}
