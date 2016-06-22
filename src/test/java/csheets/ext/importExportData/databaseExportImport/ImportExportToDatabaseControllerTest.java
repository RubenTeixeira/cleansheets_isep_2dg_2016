/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExportData.databaseExportImport;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

/**
 *
 * @author ab
 */
public class ImportExportToDatabaseControllerTest {

    CleanSheets app;
    UIController uiController;
    ImportExportToDatabaseController controller;
    String tableName = "ImportExportToDatabaseControllerTest";
    String driver = "org.h2.Driver";
    String name = "jdbc:h2:./db/csheets";
    String username = "";
    String password = "";

    public ImportExportToDatabaseControllerTest() {
        app = new CleanSheets();
        uiController = new UIController(app);
        controller = new ImportExportToDatabaseController(uiController);
    }

    /**
     * Test of importFromDatabase method, of class
     * ImportExportToDatabaseController.
     */
    @Test
    public void testImportFromDatabase() throws Exception {
    }

    /**
     * Test of exportToDatabase method, of class
     * ImportExportToDatabaseController.
     */
    @Test
    public void testExportToDatabase() throws Exception {
    }

    /**
     * Test of getSelectedCells method, of class
     * ImportExportToDatabaseController.
     */
    @Test
    public void testGetSelectedCells() {
    }

    /**
     * Test of getHeader method, of class ImportExportToDatabaseController.
     */
    @Test
    public void testGetHeader() throws FormulaCompilationException {
//        String[] expectedResult = new String[4];
//        expectedResult[0] = "header1";
//        expectedResult[1] = "header2";
//        expectedResult[2] = "header3";
//        expectedResult[3] = "header4";
//        Cell[][] cells = new Cell[2][4];
//        cells[0][0] = uiController.getActiveSpreadsheet().getCell(0, 0);
//        cells[0][0].setContent(expectedResult[0]);
//        cells[0][1] = uiController.getActiveSpreadsheet().getCell(0, 1);
//        cells[0][1].setContent(expectedResult[1]);
//        cells[0][2] = uiController.getActiveSpreadsheet().getCell(0, 2);
//        cells[0][2].setContent(expectedResult[2]);
//        cells[0][3] = uiController.getActiveSpreadsheet().getCell(0, 3);
//        cells[0][3].setContent(expectedResult[3]);
//        assertArrayEquals(expectedResult,controller.getHeader(cells));

    }

    /**
     * Test of getContent method, of class ImportExportToDatabaseController.
     */
    @Test
    public void testGetContent() {
    }

    /**
     * Test of setCellContent method, of class ImportExportToDatabaseController.
     */
    @Test
    public void testSetCellContent() throws Exception {
    }

}
