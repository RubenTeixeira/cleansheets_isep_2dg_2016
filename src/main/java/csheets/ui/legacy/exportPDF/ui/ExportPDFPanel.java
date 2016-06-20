/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.exportPDF.ui;

import csheets.io.FilenameExtensionFilter;
import csheets.ui.FileChooser;
import csheets.ui.ctrl.UIController;
import csheets.ui.legacy.exportPDF.ExportPDFController;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Diogo Leite
 */
public class ExportPDFPanel extends javax.swing.JFrame {

	private final ExportPDFController controller;
	private UIController uiController;

	/**
	 * Creates new form ExportXMLPanel
	 *
	 * @param uiController uiController
	 */
	public ExportPDFPanel(UIController uiController) {
		initComponents();
		this.uiController = uiController;
		this.controller = new ExportPDFController(this.uiController);
		initiateOptions();
		this.jComboBoxSpreedSheet.setEnabled(false);
	}

	/**
	 * Method to add Items
	 */
	private void initiateOptions() {
		this.jComboBoxType.removeAll();
		this.jComboBoxType.addItem("Workbook");
		this.jComboBoxType.addItem("SpreedSheet");
		this.jComboBoxType.addItem("Range of Cells");
		this.jComboBoxSpreedSheet.removeAll();
		for (int i = 0; i < this.uiController.getActiveWorkbook().
			getSpreadsheetCount(); i++) {
			this.jComboBoxSpreedSheet.addItem(this.uiController.
				getActiveWorkbook().getSpreadsheet(i).getTitle());
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        checkbox1 = new java.awt.Checkbox();
        jButtonExport = new javax.swing.JButton();
        jComboBoxType = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxSpreedSheet = new javax.swing.JComboBox<String>();
        jToggleButtonCancel = new javax.swing.JToggleButton();

        checkbox1.setLabel("export selected");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonExport.setText("Export");
        jButtonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExportActionPerformed(evt);
            }
        });

        jComboBoxType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTypeActionPerformed(evt);
            }
        });

        jLabel1.setText("Type:");

        jLabel2.setText("SpreedSheet:");

        jToggleButtonCancel.setText("Cancel");
        jToggleButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonExport)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxSpreedSheet, 0, 122, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButtonCancel)
                                .addGap(24, 24, 24)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxSpreedSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonExport)
                    .addComponent(jToggleButtonCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
		JFileChooser fileChooser = new JFileChooser();

		fileChooser.
			addChoosableFileFilter(new FileChooser.Filter(new FilenameExtensionFilter("pdf"), "Portable Document Format"));

		fileChooser.
			setFileFilter(new FileNameExtensionFilter("Portable Document Format (*.pdf)", "pdf"));
		int retrival = fileChooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {

				switch (this.jComboBoxType.getSelectedIndex()) {
					case 0:
						this.controller.
							exportWorkbook(fileChooser);
						break;
					case 1:
						this.controller.
							exportSpreadSheet(fileChooser, this.uiController.
											  getActiveWorkbook().
											  getSpreadsheet(this.jComboBoxSpreedSheet.
												  getSelectedIndex()));
						break;
					default:
						this.controller.exportSelectedCells(fileChooser, uiController);
						break;
				}
				this.dispose();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
    }//GEN-LAST:event_jButtonExportActionPerformed

    private void jToggleButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonCancelActionPerformed
		this.dispose();
    }//GEN-LAST:event_jToggleButtonCancelActionPerformed

    private void jComboBoxTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTypeActionPerformed
		if (this.jComboBoxType.getSelectedIndex() == 1) {
			this.jComboBoxSpreedSheet.setEnabled(true);
		} else {
			this.jComboBoxSpreedSheet.setEnabled(false);
		}
    }//GEN-LAST:event_jComboBoxTypeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JComboBox<String> jComboBoxSpreedSheet;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToggleButton jToggleButtonCancel;
    // End of variables declaration//GEN-END:variables

}
