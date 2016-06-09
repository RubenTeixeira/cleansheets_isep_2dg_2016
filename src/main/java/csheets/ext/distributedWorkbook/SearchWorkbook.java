package csheets.ext.distributedWorkbook;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Responsible for saving a workbook data and search to of this workbook on
 * another instance.
 *
 * @author José Barros
 */
public class SearchWorkbook {

	/**
	 * UI Controller
	 */
	private UIController controller;

	/**
	 * List of workbook spreadsheets
	 */
	private List<Spreadsheet> worksheets;

	/**
	 * Instance workbook
	 */
	private Workbook workbook;

	/**
	 * Result of search
	 */
	private boolean result = false;

	/**
	 * Name of workbook to search
	 */
	private String workbookNameToSearch;

	/**
	 * Instance constructor.
	 *
	 * @param uiController UI Controller
	 */
	public SearchWorkbook(UIController uiController) {
		this.controller = uiController;
		this.worksheets = new ArrayList<>();
	}

	/**
	 * Save name of workbook to search
	 *
	 * @param name Name of workbook
	 */
	public void setWorkbookToSearch(String name) {
		this.workbookNameToSearch = name + ".cls";
	}

	/**
	 * Return search result.
	 *
	 * @return search result
	 */
	public boolean result() {
		return result;
	}

	/**
	 * Search workbook in instance directories.
	 *
	 * @param workbookName workbook
	 * @return response
	 */
	public boolean findWorkbook(String workbookName) {

		setWorkbookToSearch(workbookName);
		searchDirectory(new File("C:\\Users\\"));
		return result;
	}

	/**
	 * Search all directories.
	 *
	 * @param directory Path of directory
	 */
	public void searchDirectory(File directory) {

		if (directory.isDirectory()) {
			search(directory);
		} else {
			System.out.
				println(directory.getAbsoluteFile() + " is not a directory!");
		}

	}

	/**
	 * Search a file in directory
	 *
	 * @param file File Path
	 */
	private void search(File file) {

		if (result == true) {
			return;
		}

		if (file.isDirectory()) {
			System.out.println("Searching directory ... " + file.
				getAbsoluteFile());

			//do you have permission to read this directory?
			if (file.canRead()) {
				if (file.listFiles() == null) {
					return;
				}
				for (File temp : file.listFiles()) {
					if (temp.isDirectory()) {
						search(temp);
					} else if (this.workbookNameToSearch.equals(temp.getName().
						toLowerCase())) {
						if (activeWorkbook(temp)) {
							Iterator<Spreadsheet> spreadsheets = workbook.
								iterator();
							while (spreadsheets.hasNext()) {
								worksheets.add(spreadsheets.next());
							}
							result = true;
						}
					}
				}

			} else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}

	}

	/**
	 * Verifies if book it is active in the cleansheet of instance
	 *
	 * @param workbookFile Workbook path
	 * @return result
	 */
	private boolean activeWorkbook(File workbookFile) {

		workbook = controller.getCleanSheets().getWorkbook(workbookFile);

		return workbook != null;
	}

	/**
	 * Returns the summary of workbook contents
	 *
	 * @return summary
	 */
	public String getSummary() {

		Address start = new Address(0, 0);
		Address finish = new Address(128, 52);

		HashMap<String, String> summary = new HashMap<>();

		for (Spreadsheet spread : worksheets) {
			summary.put(spread.getTitle(), "");
			for (Cell cell : spread.getCells(start, finish)) {
				if (cell.getContent().compareTo("") != 0) {
					summary.replace(spread.getTitle(), "", cell.getAddress().
									toString());
				}
			}
		}

		return displaySummary(summary);
	}

	/**
	 * Builds summary of workbook contents
	 *
	 * @param summary Worbook Summary
	 * @return summary
	 */
	public String displaySummary(HashMap<String, String> summary) {

		String message = ".: Workbook Content :. ";
		for (Map.Entry<String, String> entry : summary.entrySet()) {
			message += "Spread title - " + entry.getKey() + ": ";
			if (entry.getValue().compareTo("") != 0) {
				message += "First non-empty cell address - " + entry.getValue();
			} else {
				message += "Empty spreadsheet ";
			}
		}
		return message;
	}
}
