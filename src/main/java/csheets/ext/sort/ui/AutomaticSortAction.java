/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort.ui;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.sort.SortController;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.SMALL_ICON;
import javax.swing.ImageIcon;

/**
 *
 * @author scarl
 */
public class AutomaticSortAction extends BaseAction implements SelectionListener {

    private final SortController controller;

    protected UIController uiController;

    private Cell[][] selectedCells;

    public AutomaticSortAction(UIController uiController) {
        this.uiController = uiController;
        this.controller = new SortController(uiController);
    }

    /**
     * @return name extension.
     */
    @Override
    protected String getName() {
        return "Automatic sort";
    }

    @Override
    protected void defineProperties() {
        putValue(MNEMONIC_KEY, KeyEvent.VK_F);
        putValue(SMALL_ICON, new ImageIcon(CleanSheets.class.
                getResource("ext/sort/sort_icon_2.png")));
        setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        uiController.addSelectionListener(this);
        selectedCells = uiController.focusOwner.getSelectedCells();
        for (int i = 0; i < selectedCells.length; i++) {
            for (int j = 0; j < selectedCells[0].length; j++) {
                StylableCell cell = (StylableCell) selectedCells[i][j].getExtension(StyleExtension.NAME);
                cell.setBackgroundColor(Color.yellow);
            }
        }
        // uiController.removeSelectionListener(AutomaticSortAction.this);
    }

    @Override
    public void selectionChanged(SelectionEvent event) {
        if (event.isCellChanged()) {
            int column = event.getCell().getAddress().getColumn() + 1;

            boolean ascending = true;

            sortByColumn(column, ascending);
        }
    }

    public void sortByColumn(int column, boolean order) {
        Cell[][] cells = this.controller.sortRangeOfCells(selectedCells, column, order);
        String[][] sorted = new String[cells.length][cells[0].length];

        // Brute-force copy.
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {
                sorted[i][j] = cells[i][j].getContent();
            }
        }

        int[] columns = uiController.focusOwner.getSelectedColumns();
        int[] rows = uiController.focusOwner.getSelectedRows();

        Spreadsheet ss = uiController.getActiveSpreadsheet();

        for (int i = 0; i < columns.length; i++) {
            for (int j = 0; j < rows.length; j++) {
                try {
                    ss.getCell(columns[i], rows[j]).setContent(sorted[j][i]);
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(RangedSortDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        uiController.focusOwner.revalidate();
        uiController.focusOwner.repaint();
    }
}
