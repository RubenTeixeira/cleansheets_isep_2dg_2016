package csheets.ext.sort;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Sort Controller.
 */
public class SortController {

    /**
     * User Interface controller.
     */
    private UIController uiController;

    /**
     * Sorting List.
     */
    private List<Value> valueList = new ArrayList<>();

    /**
     * Column index.
     */
    private int index;

    public SortController(UIController controller) {
        this.uiController = controller;
    }

    /**
     * Set Column Index.
     *
     * @param index index
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Assign column values to valueList.
     */
    public void updateValueList() {
        for (Cell c : this.uiController.getActiveSpreadsheet().
                getColumn(this.index)) {
            if (!c.getValue().toString().equals("")) {
                valueList.add(c.getValue());
            }
        }
    }

    /**
     * Set a new List.
     *
     * @param newList List.
     */
    public void setValueList(List<Value> newList) {
        this.valueList = newList;
    }

    /**
     * Value List Sorting.
     *
     * @param order order
     */
    public void order(int order) {
        if (order == 0) {
            Collections.sort(valueList);
        } else {
            Collections.sort(valueList);
            Collections.reverse(valueList);
        }
    }

    /**
     * Updates the working column.
     */
    public void updateColumn() {
        int j = 0;
        for (Cell c : this.uiController.getActiveSpreadsheet().
                getColumn(this.index)) {
            if (!c.getValue().toString().equalsIgnoreCase("")) {
                c.clear();
                try {
                    c.setContent(valueList.get(j).toString());
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(SortController.class.getName()).
                            log(Level.SEVERE, null, ex);
                }
                j++;
            }
        }
        valueList.clear();
    }

    /**
     * Gets the selected columns in the spreadsheet.
     * 
     * @return Selected columns.
     */
    public int[] getSelectedColumns() {
        return this.uiController.focusOwner.getSelectedColumns();
    }
    
    /**
     * Gets the available sort types.
     * 
     * @return Sort Types.
     */
    public String[] getSortTypes() {
        return new String[] {
            "Text",
            "Numeric",
            "Date",
        };
    }
    
    /**
     * Sorts the currently selected cells with the information given.
     * 
     * @param column Column to sort.
     * @param type The sort type.
     * @param order The sort order.
     */
    public void sortRangeOfCells(int column, int type, boolean order) {
        if (column < 0) {
            throw new IllegalArgumentException("A column can not have an index below 0.");
        }
        
        if (type < 0) {
            throw new IllegalArgumentException("A sort type can not have an index below 0.");
        }
        
        Cell[][] cells = this.uiController.focusOwner.getSelectedCells();
        SortStrategy strategy = this.getSortStrategy(type);
        
        new SortService().sortRangeOfCells(strategy, cells, column, order);
    }
    
    private SortStrategy getSortStrategy(int type)
    {
        if (type < 0) {
            throw new IllegalArgumentException("The given sort type is not a valid strategy.");
        }
        
        String[] strategies = this.getSortTypes();
        
        if (type > strategies.length) {
            throw new IllegalArgumentException("The given sort type is not a valid strategy.");
        }
        
        String strategy = strategies[type];
        
        if (strategy.equalsIgnoreCase("Text")) {
            return new TextSortStrategy();
        }
        
        if (strategy.equalsIgnoreCase("Numeric")) {
            return new NumericSortStrategy();
        }
        
        if (strategy.equalsIgnoreCase("Date")) {
            return new DateSortStrategy();
        }
        
        throw new IllegalArgumentException("No strategy was found for the given sort type.");
    }
}
