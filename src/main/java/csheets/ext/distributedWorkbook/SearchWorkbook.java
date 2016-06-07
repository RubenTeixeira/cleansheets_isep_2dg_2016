package csheets.ext.distributedWorkbook;

import csheets.CleanSheets;
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
 *
 * @author José Barros
 */
public class SearchWorkbook {

	private UIController controller;
	private List<Spreadsheet> worksheets;
	Workbook activeWorkbook = new Workbook();
	private boolean result;
	private CleanSheets clean;

	private String workbookNameToSearch;

	public SearchWorkbook(UIController uiController) {
		this.controller = uiController;
		this.worksheets = new ArrayList<>();
	}

	public void setWorkbookToSearch(String name) {
		this.workbookNameToSearch = name + ".cls";
	}

	public boolean result() {
		return result;
	}

	public void findWorkbook() {

		searchDirectory(new File("C:\\Users\\"), workbookNameToSearch);
	}

	public void searchDirectory(File directory, String fileNameToSearch) {

		if (directory.isDirectory()) {
			search(directory);
		} else {
			System.out.
				println(directory.getAbsoluteFile() + " is not a directory!");
		}

	}

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
							Iterator<Spreadsheet> spreadsheets = activeWorkbook.
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

	private boolean activeWorkbook(File workbookFile) {

		activeWorkbook = controller.getCleansheet().getWorkbook(workbookFile);

		return activeWorkbook != null;
	}

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

		String message = ".: Workbook Content :.\n";
		for (Map.Entry<String, String> entry : summary.entrySet()) {
			message += "Spread title - " + entry.getKey() + ":\n";
			if (entry.getValue().compareTo("") != 0) {
				message += "First non-empty cell address - " + entry.getValue() + "\n";
			} else {
				message += "Empty spreadsheet\n";
			}
		}

		return message;
	}
}
