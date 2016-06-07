package csheets.ext.distributedWorkbook;

import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author José Barros
 */
public class SearchWorkbook {

	private UIController controller;
	private List<Spreadsheet> worksheets;
	private boolean result;

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

		searchDirectory(new File("C:\\Users\\user\\"), workbookNameToSearch + ".cls");
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
						result = true;
					}
				}

			} else {
				System.out.println(file.getAbsoluteFile() + "Permission Denied");
			}
		}

	}

//		Iterator<Spreadsheet> spreadsheets = controller.getActiveWorkbook().
//			iterator();
//		while (spreadsheets.hasNext()) {
//			worksheets.add(spreadsheets.next());
//		}
//	}
//
//	public List<Spreadsheet> worksheets() {
//		return this.worksheets;
//	}
}
