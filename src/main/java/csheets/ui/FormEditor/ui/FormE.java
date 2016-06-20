/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.FormEditor.ui;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class FormE {

	/**
	 *
	 */
	private String nameForm;

	private List<Widget> lstWidget;

	/**
	 *
	 * @param nameForm lstWidget is a new List
	 */
	public FormE(String nameForm) {
		this.nameForm = nameForm;
		this.lstWidget = new ArrayList<>();
	}

	/**
	 *
	 * @return list of Widgets
	 */
	public List showListWidget() {
		return lstWidget;
	}

	/**
	 *
	 * @param wgt is a received widget
	 */
	public void addWidget(Widget wgt) {
		this.lstWidget.add(wgt);
	}
}
