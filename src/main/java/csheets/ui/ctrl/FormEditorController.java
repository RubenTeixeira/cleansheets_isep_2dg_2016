/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import csheets.ui.FormEditor.ui.FormEdit;
import csheets.ui.FormEditor.ui.SingleLine;

/**
 *
 * @author Hicham Abahri <1141042@isep.ipp.pt>
 */
public class FormEditorController {

    private final String name;
    private final String description;
    private SingleLine singleLine;
    private FormEdit formEdit;
    

    public FormEditorController(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * add a new line into Jpanel.
     */
    public void addLine(){
        
        this.formEdit.add(singleLine);    
    }
    
    /**
     * Remove line into Jpanel
     */
    public void removeLine(){
        this.formEdit.remove(singleLine);
    }
}
