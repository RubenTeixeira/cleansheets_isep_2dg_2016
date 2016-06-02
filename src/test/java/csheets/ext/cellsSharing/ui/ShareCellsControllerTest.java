/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.cellsSharing.ui;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.Map;
import javax.swing.DefaultListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Carlos Mateus
 */
public class ShareCellsControllerTest {

	Cell[][] cell;
	ShareCellsController instance;
	DefaultListModel receiveListModel;
	String message;
	TcpService tcpservice;

	UIController ui;
	Map<String, String> cells;
	CleanSheets cleansheets;
	Map<String, String> newcell;

	public ShareCellsControllerTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		cell = new Cell[1][1];
		tcpservice = new TcpService();
		tcpservice.client("255.255.255.255", message);

		message = ";" + cell[0][0].getAddress().getColumn() + ";" + cell[0][0].
			getAddress().getRow() + ";" + cell[0][0].getValue().getType() + ";" + cell[0][0].
			getValue().toString();

		newcell.put("1", message);
		cleansheets = new CleanSheets();
		ui = new UIController(cleansheets);

	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of updateCells method, of class ShareCellsController.
	 */
	@Test
	public void testUpdateCells() throws Exception {
//		instance.updateCells(ui, cells);
//		Map<String, String> expResult = cells;
//		Map<String, String> result = newcell;
//
//		assertEquals(expResult.get(0), cell);
	}
}
