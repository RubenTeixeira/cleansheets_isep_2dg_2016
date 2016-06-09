/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.ctrl;

import csheets.ui.FormEditor.ui.SingleLine;

/**
 *
 * @author Hicham Abahri
 */
public class FormEditorController {

    private final String name;
    private final String description;
    private SingleLine singleLine;

    public FormEditorController(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
