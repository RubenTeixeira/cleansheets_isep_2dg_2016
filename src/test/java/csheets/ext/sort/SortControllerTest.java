/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort;

import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class SortControllerTest {

	private SortController controller;
	private Workbook wb;
	private Spreadsheet ss;
	private List<Value> list = new ArrayList<>();
	Value value1 = new Value(300);
	Value value2 = new Value("ola");
	Value value3 = new Value(Boolean.TRUE);
	Value value4 = new Value(6);
	Value value5 = new Value(4.30);
	Value value6 = new Value("adeus");
	Value value7 = new Value(Boolean.FALSE);

	public SortControllerTest() {
	}

	@Before
	public void setUp() {

		UIController uiController = UIController.getUIController();
		list.add(value1);
		list.add(value2);
		list.add(value3);
		list.add(value4);
		list.add(value5);
		list.add(value6);
		list.add(value7);
//		wb = new Workbook(3);
//		ss = wb.getSpreadsheet(1);
//		try {
//			ss.getCell(0, 0).setContent("a");
//			ss.getCell(0, 1).setContent("d");
//			ss.getCell(0, 2).setContent("f");
//			ss.getCell(0, 3).setContent("c");
//			ss.getCell(0, 4).setContent("b");
//			ss.getCell(0, 5).setContent("g");
//			ss.getCell(0, 6).setContent("e");
//		} catch (Exception e) {
//			//handling
//		}
		controller = new SortController(uiController);
	}

	/**
	 * Test of order method, of class SortController.
	 */
	@Test
	public void testAscendingOrder() {
		System.out.println("ascending");
		controller.setValueList(list);
		controller.order(0); //asc
		List<Value> expResult = new ArrayList<>();
		expResult.add(value5);
		expResult.add(value4);
		expResult.add(value1);
		expResult.add(value6);
		expResult.add(value2);
		expResult.add(value7);
		expResult.add(value3);
		assertEquals(expResult, list);
	}

	@Test
	public void testDescendingOrder() {
		System.out.println("descending");
		controller.setValueList(list);
		controller.order(1);
		List<Value> expResult = new ArrayList<>();
		expResult.add(value3);
		expResult.add(value7);
		expResult.add(value2);
		expResult.add(value6);
		expResult.add(value1);
		expResult.add(value4);
		expResult.add(value5);
		assertEquals(expResult, list);

	}

}
