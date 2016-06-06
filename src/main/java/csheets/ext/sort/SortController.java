/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Sort Controller.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class SortController {

	/**
	 * Handle Sorting.
	 *
	 * @param valueList
	 * @param order
	 * @return column sorted
	 */
	public List<String> order(List<String> valueList, int order) {

		//will the object be lost?
		List<String> list = new ArrayList<>();
		if (order == 0) { //ascending
			Collections.sort(valueList);
			list = valueList;
		} else { //descending mode
			Collections.reverse(valueList);
			list = valueList;
		}
		return list;
	}
}
