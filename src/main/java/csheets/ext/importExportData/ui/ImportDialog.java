/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExportData.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Rui Bastos
 */
public class ImportDialog extends javax.swing.JDialog {

	private ImportExportTextFileController controller;
	private UIController uiController;
	private Cell[][] cells;

	/**
	 * Creates new form IEDialog
	 */
	public ImportDialog(java.awt.Frame parent, boolean modal,
						UIController uiController,
						ImportExportTextFileController controller) {
		super(parent, modal);

		initComponents();

		this.controller = controller;
		this.uiController = uiController;
		this.cells = new Cell[0][0];
		initializeCellRangeText();
	}

	private void initializeCellRangeText() {
		Cell[][] selectedCells = uiController.focusOwner.getSelectedCells();
		this.rangeOfCellsImportText.setText(selectedCells[0][0].getAddress().
			toString() + "-"
			+ selectedCells[selectedCells.length - 1][selectedCells[0].length - 1].
			getAddress().toString());
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        charLabel = new javax.swing.JLabel();
        headerLabel = new javax.swing.JLabel();
        helpNoteLabel = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        headerCheckBox = new javax.swing.JCheckBox();
        separatorTextField = new javax.swing.JTextField();
        rangeOfCellsImportText = new javax.swing.JTextField();
        importFileButton = new javax.swing.JButton();
        rangeOfCellsImportLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Import Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        charLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        charLabel.setText("Separator character:");

        headerLabel.setText("First Line Header:");

        helpNoteLabel.setEditable(false);
        helpNoteLabel.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        helpNoteLabel.setText("Must be special");
        helpNoteLabel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        helpNoteLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpNoteLabelActionPerformed(evt);
            }
        });

        headerCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headerCheckBoxActionPerformed(evt);
            }
        });

        rangeOfCellsImportText.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(separatorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(rangeOfCellsImportText))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(separatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(headerCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(rangeOfCellsImportText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        importFileButton.setText("IMPORT");
        importFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importFileButtonActionPerformed(evt);
            }
        });

        rangeOfCellsImportLabel.setText("Range of cells:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(charLabel)
                            .addComponent(headerLabel)
                            .addComponent(helpNoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rangeOfCellsImportLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(importFileButton)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(charLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpNoteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(headerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rangeOfCellsImportLabel)))
                .addGap(18, 18, 18)
                .addComponent(importFileButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpNoteLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpNoteLabelActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_helpNoteLabelActionPerformed

	private void updateSelectedCells() {
		this.uiController.focusOwner.
			setRowSelectionInterval(cells[0][0].getAddress().
				getRow(), cells[0][0].getAddress().getRow() + cells.length - 1);
		this.uiController.focusOwner.
			setColumnSelectionInterval(cells[0][0].getAddress().
				getColumn(), cells[0][0].
									   getAddress().
									   getColumn() + cells[0].length - 1);
	}

    private void headerCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headerCheckBoxActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_headerCheckBoxActionPerformed

    private void importFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFileButtonActionPerformed
		String character = this.separatorTextField.getText();

		if (character.length() != 1) {
			JOptionPane.
				showMessageDialog(this, "Separator must be one character", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		String pattern = "[a-zA-Z0-9 ]";
		Pattern p = Pattern.compile(pattern, Pattern.CANON_EQ);

		Matcher matcher = p.matcher(character);

		if (matcher.find()) {
			JOptionPane.
				showMessageDialog(this, "Invalid character", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			JFileChooser fc = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("Text Files", "txt");
			fc.setFileFilter(filter);
			int returnVal = fc.showOpenDialog(fc);

			String path = "";

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				path = fc.getSelectedFile().
					getAbsolutePath();
			}

			if (!path.isEmpty()) {
				try {
					cells = uiController.focusOwner.getSelectedCells();
					if (!controller.hasEnoughCells(path, character, cells)) {
						int option = JOptionPane.
							showConfirmDialog(this, "The file exceeds the selected cells. Continue?", "Warning", JOptionPane.WARNING_MESSAGE);
						if (option == JOptionPane.NO_OPTION || option == JOptionPane.CANCEL_OPTION) {
							return;
						}
					}
					cells = controller.
						parse(path, character, this.headerCheckBox.
							  isSelected(), cells);
					updateSelectedCells();
					dispose();
				} catch (FormulaCompilationException ex) {
					Logger.getLogger(ImportDialog.class.getName()).
						log(Level.SEVERE, null, ex);
				}
			}
		}
    }//GEN-LAST:event_importFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel charLabel;
    private javax.swing.JCheckBox headerCheckBox;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JTextField helpNoteLabel;
    private javax.swing.JButton importFileButton;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel rangeOfCellsImportLabel;
    private javax.swing.JTextField rangeOfCellsImportText;
    private javax.swing.JTextField separatorTextField;
    // End of variables declaration//GEN-END:variables
}
