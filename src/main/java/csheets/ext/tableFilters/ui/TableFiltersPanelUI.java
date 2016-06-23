/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.tableFilters.ui;

import csheets.ext.tableFilters.SpreadsheetWithTables;
import csheets.ext.tableFilters.Table;
import csheets.ext.tableFilters.Table.Filter;
import csheets.ext.tableFilters.TableFiltersController;
import csheets.ext.tableFilters.TableFiltersExtension;
import csheets.notification.Notification;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rúben Teixeira 1140780@isep.ipp.pt
 */
public class TableFiltersPanelUI extends JPanel implements Observer, SelectionListener {

	/**
	 * Table and Filters controller
	 */
	private final TableFiltersController controller;

	/**
	 * The UIController
	 */
	private final UIController uiController;

	/**
	 * Helper var
	 */
	private boolean firstClick;

	/**
	 * Current Spreadsheet existant tables
	 */
	private final DefaultListModel<Table> tables;

	/**
	 * The selected table
	 */
	private Table selectedTable;

	/**
	 * The selected Filter
	 */
	private Filter selectedFilter;

	/**
	 * Selected table filters Model
	 */
	private final DefaultListModel<Filter> selectedTableFilters;

	/**
	 * Current spreadsheet
	 */
	private SpreadsheetWithTables activeSpreadsheet;

	/**
	 * Hidden rows list
	 */
	private List<Integer> hiddenRows;

	/**
	 * Creates new form TableFiltersPanelUI
	 *
	 * @param uiController the UIController
	 */
	public TableFiltersPanelUI(UIController uiController) {
		setName(TableFiltersExtension.NAME);
		this.uiController = uiController;
		controller = new TableFiltersController(uiController);
		this.firstClick = true;
		this.hiddenRows = new ArrayList<>();
		this.tables = new DefaultListModel<>();
		this.selectedTableFilters = new DefaultListModel<>();

		initComponents();

		this.jTableList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Notification.tablesInformer().addObserver(this);
		this.uiController.addSelectionListener(this);
		this.jNewFilterBtn.setEnabled(false);
		this.jApplyFilterBtn.setEnabled(false);
		this.jDisableFilterBtn.setEnabled(false);
		this.jRemoveFilterBtn.setEnabled(false);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jFilterList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jDisableFilterBtn = new javax.swing.JButton();
        jApplyFilterBtn = new javax.swing.JButton();
        jNewFilterBtn = new javax.swing.JButton();
        jRemoveFilterBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCreateTableBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableList = new javax.swing.JList();
        jRemoveTableBtn = new javax.swing.JButton();

        jFilterList.setModel(selectedTableFilters);
        jFilterList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jFilterListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jFilterList);

        jLabel2.setText("Filters:");

        jDisableFilterBtn.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jDisableFilterBtn.setText("Disable");
        jDisableFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDisableFilterBtnActionPerformed(evt);
            }
        });

        jApplyFilterBtn.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jApplyFilterBtn.setText("Apply");
        jApplyFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jApplyFilterBtnActionPerformed(evt);
            }
        });

        jNewFilterBtn.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jNewFilterBtn.setText("New");
        jNewFilterBtn.setSize(40, 25);
        jNewFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewFilterBtnActionPerformed(evt);
            }
        });

        jRemoveFilterBtn.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jRemoveFilterBtn.setText("Remove");
        jRemoveFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoveFilterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jNewFilterBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jDisableFilterBtn))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jApplyFilterBtn)
                        .addGap(18, 18, 18)
                        .addComponent(jRemoveFilterBtn)))
                .addContainerGap())
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jApplyFilterBtn, jDisableFilterBtn, jNewFilterBtn, jRemoveFilterBtn});

        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNewFilterBtn)
                    .addComponent(jDisableFilterBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jApplyFilterBtn)
                    .addComponent(jRemoveFilterBtn))
                .addContainerGap())
        );

        jLayeredPane1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jApplyFilterBtn, jDisableFilterBtn, jNewFilterBtn, jRemoveFilterBtn});

        jLayeredPane1.setLayer(jDisableFilterBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jApplyFilterBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jNewFilterBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jRemoveFilterBtn, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel3.add(jLayeredPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jCreateTableBtn.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jCreateTableBtn.setText("Create Table");
        jCreateTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCreateTableBtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Tables:");

        jTextField1.setText("Table name...");
        jTextField1.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (firstClick) {
                    jTextField1.setText("");
                    firstClick = false;
                }
            }
        });

        jTableList.setModel(tables);
        jTableList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jTableListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTableList);

        jRemoveTableBtn.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jRemoveTableBtn.setText("Remove");
        jRemoveTableBtn.setEnabled(false);
        jRemoveTableBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoveTableBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jRemoveTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCreateTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRemoveTableBtn)
                    .addComponent(jCreateTableBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCreateTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCreateTableBtnActionPerformed
		createNewTable();
    }//GEN-LAST:event_jCreateTableBtnActionPerformed

    private void jTableListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jTableListValueChanged
		this.selectedTable = (Table) this.jTableList.getSelectedValue();
		fireTableSelectionChanged();
    }//GEN-LAST:event_jTableListValueChanged

    private void jNewFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewFilterBtnActionPerformed
		java.awt.EventQueue.invokeLater(() -> {
			new NewFilterFrame(uiController, controller, selectedTable);
		});
    }//GEN-LAST:event_jNewFilterBtnActionPerformed

    private void jRemoveTableBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoveTableBtnActionPerformed
		Table selected = (Table) this.jTableList.getSelectedValue();
		removeTable(selected);
    }//GEN-LAST:event_jRemoveTableBtnActionPerformed

    private void jRemoveFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoveFilterBtnActionPerformed
		this.controller.removeFilter(this.selectedTable, this.selectedFilter);
    }//GEN-LAST:event_jRemoveFilterBtnActionPerformed

    private void jFilterListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jFilterListValueChanged
		if (this.jFilterList.getSelectedValue() != null) {
			this.selectedFilter = (Filter) this.jFilterList.getSelectedValue();
			this.jApplyFilterBtn.setEnabled(true);
			this.jDisableFilterBtn.setEnabled(true);
			this.jRemoveFilterBtn.setEnabled(true);
		} else {
			this.jApplyFilterBtn.setEnabled(false);
			this.jDisableFilterBtn.setEnabled(false);
			this.jRemoveFilterBtn.setEnabled(false);
		}
    }//GEN-LAST:event_jFilterListValueChanged

    private void jApplyFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jApplyFilterBtnActionPerformed
		if (this.jFilterList.getSelectedValue() != null) {
			this.selectedFilter = (Filter) this.jFilterList.getSelectedValue();
			removeRowsFrom(selectedFilter);
		}
    }//GEN-LAST:event_jApplyFilterBtnActionPerformed

    private void jDisableFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDisableFilterBtnActionPerformed
		if (this.jFilterList.getSelectedValue() != null) {
			this.selectedFilter = (Filter) this.jFilterList.getSelectedValue();
			readdRowsFrom(selectedFilter);
		}
    }//GEN-LAST:event_jDisableFilterBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jApplyFilterBtn;
    private javax.swing.JButton jCreateTableBtn;
    private javax.swing.JButton jDisableFilterBtn;
    private javax.swing.JList jFilterList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JButton jNewFilterBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jRemoveFilterBtn;
    private javax.swing.JButton jRemoveTableBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList jTableList;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

	private void createNewTable() {
		try {
			this.controller.
				createNewTable(this, this.jTextField1.getText(), activeSpreadsheet);
			fireSpreadsheetSelectionChanged();
		} catch (IllegalArgumentException ex) {
			JOptionPane.
				showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void removeTable(Table selected) {
		this.controller.removeTable(selected, activeSpreadsheet);
		fireSpreadsheetSelectionChanged();
	}

	/**
	 * Implementation of update from Observable
	 */
	@Override
	public void update(Observable o, Object arg) {

		if (arg instanceof Filter) { // Filter added or removed
			updateFilters((Filter) arg);
		} else if (arg instanceof List) {
			fireSpreadsheetSelectionChanged();

		}

	}

	/**
	 * Updates the list of tables currently on the spreadsheet
	 */
	private void fireSpreadsheetSelectionChanged() {
		if (this.activeSpreadsheet == null) {
			return;
		}
		this.tables.clear();
		List<Table> tableList = this.activeSpreadsheet.tables(this);
		for (Table table : tableList) {
			this.tables.addElement(table);
		}
		updateFilters(null);
	}

	@Override
	public void selectionChanged(SelectionEvent event) {
		this.activeSpreadsheet = (SpreadsheetWithTables) event.getSpreadsheet().
			getExtension(TableFiltersExtension.NAME);
		fireSpreadsheetSelectionChanged();
	}

	/**
	 * Updates the list of filters of currently selected table
	 */
	private void fireTableSelectionChanged() {
		this.selectedTableFilters.clear();
		if (this.selectedTable == null) {
			this.jRemoveTableBtn.setEnabled(false);
			return;
		}
		for (Filter filter : this.selectedTable.filters()) {
			this.selectedTableFilters.addElement(filter);
		}

		this.jNewFilterBtn.setEnabled(true);
		this.jRemoveTableBtn.setEnabled(true);
	}

	/**
	 * Revalidates and repaints spreadsheet
	 */
	private void redrawSpreadSheet() {
		uiController.focusOwner.
			setRowSorter(generateTableRowSorter(uiController.focusOwner.
					getModel()));
		uiController.focusOwner.revalidate();
		uiController.focusOwner.repaint();

	}

	/**
	 * Updates Filter List when one is added ore removed
	 *
	 * @param updatedFilter
	 */
	private void updateFilters(Filter updatedFilter) {

		if (updatedFilter == null) {
			this.selectedTableFilters.clear();
			if (selectedTable != null) {
				selectedTable.filters().stream().
					forEach((Filter filter) -> {
						this.selectedTableFilters.addElement(filter);
					});
			}

		} else if (this.selectedTableFilters.contains(updatedFilter)) {
			this.selectedTableFilters.removeElement(updatedFilter);
			readdRowsFrom(updatedFilter);
		} else {
			this.selectedTableFilters.addElement(updatedFilter);
		}
	}

	/**
	 * Returns the Sorter used to 'filter the filtered' rows
	 *
	 * @param model the TableModel
	 * @return TableRowSorter
	 */
	private TableRowSorter<TableModel> generateTableRowSorter(
		TableModel model) {
		RowFilter filter = new TableRowFilter();
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(model);
		sorter.setRowFilter(filter);
		return sorter;
	}

	/**
	 * Returns visibilty to rows affected by given Filter
	 *
	 * @param filter the Filter
	 */
	private void readdRowsFrom(Filter filter) {
		for (Integer row : filter.rows) {
			this.hiddenRows.remove(row);
		}
		redrawSpreadSheet();
	}

	/**
	 * Removes visibilty to rows affected by given Filter
	 *
	 * @param filter the Filter
	 */
	private void removeRowsFrom(Filter filter) {
		for (Integer row : filter.rows) {
			this.hiddenRows.add(row);
		}
		redrawSpreadSheet();
	}

	class TableRowFilter extends RowFilter {

		@Override
		public boolean include(RowFilter.Entry entry) {
			Integer index = (Integer) entry.getIdentifier();
			for (Integer row : hiddenRows) {
				if (Objects.equals(index, row)) {
					return false;
				}
			}
			return true;
		}

	}
}
