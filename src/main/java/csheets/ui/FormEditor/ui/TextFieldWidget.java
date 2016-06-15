/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.FormEditor.ui;

import javax.swing.JPanel;

/**
 *
 * @author João Martins
 */
public class TextFieldWidget implements Widget {

	@Override
	public JPanel getPanel(String content) {
		return new TextFieldPanel(content);
	}

	@Override
	public String getName() {
		return "textfield";
	}

}
