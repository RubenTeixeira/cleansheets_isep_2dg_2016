/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell;

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
	 */
	public void order(List<String> valueList, int order) {

		if (order == 0) { //ascending
			Collections.sort(valueList);
		} else { //descending mode
			Collections.reverse(valueList);
		}
	}
}
