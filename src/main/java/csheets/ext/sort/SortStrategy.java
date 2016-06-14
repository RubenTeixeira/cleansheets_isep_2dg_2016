package csheets.ext.sort;

import csheets.core.Cell;
import java.util.Comparator;

/**
 * This interface allows to define a strategy for sorting purposes.
 * 
 * @author Renato Machado
 */
public interface SortStrategy extends Comparator<Cell> {

    /**
     * Sorts an array of elements based on the concrete strategy.
     * 
     * @param cells The elements to be sorted.
     * @param column The column which the sort will apply on.
     * @param order The order of the sort.
     * @return The sorted elements.
     */
    public Cell[][] sort(Cell[][] cells, int column, boolean order);
}
