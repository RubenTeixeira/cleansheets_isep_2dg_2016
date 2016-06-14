/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExportData.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Rui Bastos
 */
public class ExportDialog extends javax.swing.JDialog {

	private ImportExportTextFileController controller;
	private UIController uiController;
	private Cell[][] cells;

	/**
	 * Creates new form IEDialog
	 *
	 * @param parent parent
	 * @param modal modal
	 * @param uiController uiController
	 * @param controller controller
	 */
	public ExportDialog(java.awt.Frame parent, boolean modal,
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
		this.rangeOfCellsExportText.setText(selectedCells[0][0].getAddress().
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

        jPanel6 = new javax.swing.JPanel();
        charLabel1 = new javax.swing.JLabel();
        helpNoteLabel1 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        separatorTextField1 = new javax.swing.JTextField();
        rangeOfCellsExportText = new javax.swing.JTextField();
        exportFileButton = new javax.swing.JButton();
        rangeOfCellsExportLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Export Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 13))); // NOI18N

        charLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        charLabel1.setText("Separator character:");

        helpNoteLabel1.setEditable(false);
        helpNoteLabel1.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        helpNoteLabel1.setText("Must be special");
        helpNoteLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        helpNoteLabel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpNoteLabel1ActionPerformed(evt);
            }
        });

        rangeOfCellsExportText.setEditable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rangeOfCellsExportText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(separatorTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(separatorTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rangeOfCellsExportText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        exportFileButton.setText("EXPORT");
        exportFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileButtonActionPerformed(evt);
            }
        });

        rangeOfCellsExportLabel.setText("Range of cells:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(charLabel1)
                            .addComponent(helpNoteLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rangeOfCellsExportLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exportFileButton)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(charLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpNoteLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rangeOfCellsExportLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exportFileButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void helpNoteLabel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpNoteLabel1ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_helpNoteLabel1ActionPerformed

    private void exportFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButtonActionPerformed
		this.cells = this.uiController.focusOwner.getSelectedCells();

		String character = this.separatorTextField1.getText();

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

			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Export File");
			if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				String path = jfc.getSelectedFile().getAbsolutePath();
				if (JOptionPane.
					showConfirmDialog(this, "Do you want to save the file here?",
									  "Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Thread t = createThread(path);
					t.start();
					dispose();
				}
			}
		}
    }//GEN-LAST:event_exportFileButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel charLabel1;
    private javax.swing.JButton exportFileButton;
    private javax.swing.JTextField helpNoteLabel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel rangeOfCellsExportLabel;
    private javax.swing.JTextField rangeOfCellsExportText;
    private javax.swing.JTextField separatorTextField1;
    // End of variables declaration//GEN-END:variables

	private Thread createThread(String path) {
		return new Thread() {

			@Override
			public void run() {
				if (controller.
					exportFile(path, cells, ExportDialog.this.separatorTextField1.
							   getText())) {
					JOptionPane.
						showMessageDialog(null, "The file was saved", "Sucess", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.
						showMessageDialog(null, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		};
	}
}
