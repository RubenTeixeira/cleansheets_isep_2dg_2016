///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package csheets.ext.sort;
//
//import csheets.CleanSheets;
//import csheets.core.Value;
//import csheets.ui.ctrl.UIController;
//import java.util.ArrayList;
//import java.util.List;
//import static org.junit.Assert.assertEquals;
//import org.junit.Test;
//
///**
// *
// * @author Pedro Gomes 1130383@isep.ipp.pt
// */
//public class SortControllerTest {
//
//	public SortControllerTest() {
//	}
//
//	/**
//	 * Test of order method, of class SortController.
//	 */
//	@Test
//	public void testAscendingOrder() {
//		System.out.println("ascending");
//		CleanSheets app = new CleanSheets();
//		UIController uiController = new UIController(app);
//		List<Value> valueList = new ArrayList<>();
//		Value value1 = new Value(300);
//		Value value2 = new Value("ola");
//		Value value3 = new Value(Boolean.TRUE);
//		Value value4 = new Value(6);
//		Value value5 = new Value(4.30);
//		Value value6 = new Value("adeus");
//		Value value7 = new Value(Boolean.FALSE);
//		//list non-ordered
//		valueList.add(value1);
//		valueList.add(value2);
//		valueList.add(value3);
//		valueList.add(value4);
//		valueList.add(value5);
//		valueList.add(value6);
//		valueList.add(value7);
//		int order = 0;//ascending order
//		SortController instance = new SortController(uiController);
//		instance.order(valueList, order);
//		List<Value> expResult = new ArrayList<>();
//		expResult.add(value5);
//		expResult.add(value4);
//		expResult.add(value1);
//		expResult.add(value6);
//		expResult.add(value2);
//		expResult.add(value7);
//		expResult.add(value3);
//		assertEquals(expResult, valueList);
//	}
//
//	@Test
//	public void testDescendingOrder() {
//		System.out.println("descending");
//		CleanSheets app = new CleanSheets();
//		UIController uiController = new UIController(app);
//		List<Value> valueList = new ArrayList<>();
//		Value value1 = new Value(300);
//		Value value2 = new Value("ola");
//		Value value3 = new Value(Boolean.TRUE);
//		Value value4 = new Value(6);
//		Value value5 = new Value(4.30);
//		Value value6 = new Value("adeus");
//		Value value7 = new Value(Boolean.FALSE);
//		//list non-ordered
//		valueList.add(value3);
//		valueList.add(value7);
//		valueList.add(value2);
//		valueList.add(value6);
//		valueList.add(value1);
//		valueList.add(value4);
//		valueList.add(value5);
//		int order = 1;//descending order
//		SortController instance = new SortController(uiController);
//		instance.order(valueList, order);
//		List<Value> expResult = new ArrayList<>();
//		expResult.add(value3);
//		expResult.add(value7);
//		expResult.add(value2);
//		expResult.add(value6);
//		expResult.add(value1);
//		expResult.add(value4);
//		expResult.add(value5);
//		assertEquals(expResult, valueList);
//
//	}
//
//}
