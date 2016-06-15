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
public interface Widget {

	/**
	 * Get panel with content.
	 *
	 * @param content
	 * @return
	 */
	public JPanel getPanel(String content);

	/**
	 * Get name widget.
	 *
	 * @return
	 */
	public String getName();

}
