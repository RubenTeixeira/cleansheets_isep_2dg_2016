package csheets.ext.distributedWorkbook;

import csheets.ui.ctrl.UIController;

/**
 *
 * @author José Barros
 */
public class SearchWorkbook {

	private UIController controller;

	private String workbookNameToSearch;

	public SearchWorkbook(UIController uiController) {
		this.controller = uiController;
	}

	public void setWorkbookToSearch(String name) {
		this.workbookNameToSearch = name;
	}

	public void findWorkbook() {

	}

}
