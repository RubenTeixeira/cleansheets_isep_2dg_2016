/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.advancedWorkbookSearch;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the Controller of Advanced Workbook Search Extension. This class will
 * handle the Extension Operations.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class AdvancedWorkbookSearchController {

	/**
	 * Empty constructor.
	 */
	public AdvancedWorkbookSearchController() {

	}

	/**
	 * Search for Files accordingly to the giving pattern. Make use of
	 * Recursivity to perform the search on Sub-Directories.
	 *
	 * @param dir Search Directory.
	 * @param pattern Search Pattern.
	 * @return Results List.
	 */
	public List<File> search(File dir, String pattern) throws NullPointerException {

		List<File> workbookList = new ArrayList<>();
		try {
			if (dir.isDirectory()) {
				File[] subdirs = dir.listFiles(new FileFilter() {

					@Override
					public boolean accept(File pathname) {
						return pathname.isDirectory() || pathname.getName().
							matches(pattern);
					}
				});
				for (File subFile : subdirs) {
					if (subFile.isDirectory()) {
						workbookList.addAll(search(subFile, pattern)); //Recursivity.
					} else {
						workbookList.add(subFile);
					}
				}
			}
		} catch (NullPointerException e) {
			e.getMessage();
		}
		System.out.println("I'm on it! - CONTROLLER");
		return workbookList;
	}
}
