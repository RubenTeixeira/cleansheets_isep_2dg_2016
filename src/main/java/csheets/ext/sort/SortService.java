package csheets.ext.sort;

import csheets.core.Cell;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Simple Cell Sort service.
 * 
 * @author Renato Machado
 */
public class SortService {
    
    /**
     * Sorts a range of cells.
     * 
     * @param strategy Strategy of the sort.
     * @param cells Cells to be sorted.
     * @param column Column to be sorted.
     * @param order Order of the sort.
     * @return Sorted cells.
     */
    public Cell[][] sortRangeOfCells(SortStrategy strategy, Cell[][] cells, int column, boolean order)
    {
        final int relativeColumn = column - cells[0][0].getAddress().getColumn();
        
        Arrays.sort(cells, (final Cell[] entry1, final Cell[] entry2) -> {
            final Cell cell1 = entry1[relativeColumn];
            final Cell cell2 = entry2[relativeColumn];
            
            return cell1.getValue().compareTo(cell2.getValue());
        });
        
        return cells;
    }
    
}
