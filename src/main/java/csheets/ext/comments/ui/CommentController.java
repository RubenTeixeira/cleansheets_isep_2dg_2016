package csheets.ext.comments.ui;

import csheets.ext.comments.Comment;
import csheets.ext.comments.CommentableCell;
import csheets.ui.ctrl.UIController;
import java.util.List;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author Alexandre Braganca
 * @author Einar Pehrson
 */
public class CommentController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 * @param uiPanel the user interface panel
	 */
	public CommentController(UIController uiController) {
		this.uiController = uiController;
	}

	/**
	 * Attempts to create a new comment from the given string. If successful,
	 * adds the comment to the given cell. If the input string is empty or null,
	 * the comment is set to null.
	 *
	 * @param cell the cell for which the comment should be set
	 * @param commentString the comment, as entered by the user
	 * @param username
	 * @return true if the cell's comment was changed
	 */
	public boolean addComment(CommentableCell cell, String commentString)
		throws IllegalArgumentException {

		String userName = System.getProperty("user.name");
		// Stores the comment
		cell.addComment(userName, commentString);
		uiController.setWorkbookModified(cell.getSpreadsheet().getWorkbook());
		return true;
	}

//	/**
//	 * A cell is selected.
//	 *
//	 * @param cell the cell whose comments changed
//	 */
//	public boolean cellSelected(CommentableCell cell) {
//		// Updates the text field and validates the comment, if any
//		if (cell.hasComment()) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	public List<Comment> getCommentList(CommentableCell cell) {
		return cell.getLstComment();
	}
}
