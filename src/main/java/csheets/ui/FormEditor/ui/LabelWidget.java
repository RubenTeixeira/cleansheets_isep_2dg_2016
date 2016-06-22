/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.FormEditor.ui;

/**
 *
 * @author João Martins
 */
public class LabelWidget implements Widget {

	/**
	 * content of the label
	 */
	private String content;

	@Override
	public String getName() {
		return "label";
	}

	@Override
	public void setContentWidget(String content) {
		this.content = content;
	}

	/**
	 * content of the label
	 *
	 * @return content
	 */
	@Override
	public String getContent() {
		return content;
	}

}
