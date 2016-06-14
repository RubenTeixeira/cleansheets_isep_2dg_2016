package csheets.ext.sort;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Renato Machado
 */
public class SortServiceTest {
    
    public SortServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sortRangeOfCells method, of class SortService.
     */
    @Test
    public void testSortRangeOfCells() throws FormulaCompilationException {
        /*Workbook wb = new Workbook(1);
        Spreadsheet ss = wb.getSpreadsheet(0);
        
        ss.getCell(1, 0).setContent("12");
        ss.getCell(1, 1).setContent("14");
        
        ss.getCell(2, 0).setContent("15");
        ss.getCell(2, 1).setContent("11");
        
        Cell[][] cells = new Cell[][] {
            { ss.getCell(1, 0), ss.getCell(2, 0) },
            { ss.getCell(1, 1), ss.getCell(2, 1) },
        };
        
        SortService service = new SortService();
        
        service.sortRangeOfCells(null, cells, 1, true);
        */
    }
    
}
