package csheets.ext.findNotesLists;

import csheets.domain.List;
import csheets.domain.Note;
import csheets.ext.findNotesLists.ui.FindPanel;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.util.Calendar;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author João Martins
 */
public class FindController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private FindPanel uiPanel;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 * @param uiPanel the user interface panel
	 */
	public FindController(UIController uiController, FindPanel uiPanel) {
		this.uiController = uiController;
		this.uiPanel = uiPanel;
	}

	public Iterable<Note> searchNotes(Calendar startDate, Calendar endDate,
									  String title, String content) {
		return PersistenceContext.repositories().notes().
			search(startDate, endDate, title, content);
	}

	public Iterable<List> searchLists(Calendar startDate, Calendar endDate,
									  String title, String content) {
		return PersistenceContext.repositories().lists().
			search(startDate, endDate, title, content);
	}

}
