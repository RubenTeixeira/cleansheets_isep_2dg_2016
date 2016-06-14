package csheets.ext.sort;

import csheets.core.Cell;

/**
 * Sorts cells which the type are of TEXT.
 * 
 * @author Renato Machado
 */
public class TextSortStrategy implements SortStrategy {

    @Override
    public Cell[][] sort(Cell[][] cells, int column, boolean order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compare(Cell o1, Cell o2) {
        return -1;
    }

    
    
}
