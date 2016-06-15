package csheets.ext.distributedWorkbook_old.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

public class WorkbookSearchAction extends BaseAction {

	/**
	 * The user interface controller
	 */
	protected UIController uiController;

	/**
	 * The distributed workbook search controller.
	 */
	private final DistributedWorkbookSearchController distributedSearchController;

	/**
	 * Creates a new action.
	 *
	 * @param uiController the user interface controller
	 * @param distributedSearchController Controller
	 */
	public WorkbookSearchAction(UIController uiController,
								DistributedWorkbookSearchController distributedSearchController) {
		this.uiController = uiController;
		this.distributedSearchController = distributedSearchController;
	}

	@Override
	protected String getName() {
		return "Network Workbook Search";
	}

	@Override
	protected void defineProperties() {
	}

	/**
	 * A simple action that presents a confirmation dialog. If the user confirms
	 * then the contents of the cell A1 of the current sheet are set to the
	 * string "Changed".
	 *
	 * @param event the event that was fired
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		WorkbookSearchUI distributedSearch = new WorkbookSearchUI(uiController, distributedSearchController);
		distributedSearch.run();
	}

}
