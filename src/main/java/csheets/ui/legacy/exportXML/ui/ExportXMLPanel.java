/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.legacy.exportXML.ui;

import csheets.ui.ctrl.UIController;
import csheets.ui.legacy.exportXML.ExportXMLController;
import javax.swing.JFileChooser;

/**
 *
 * @author ruben
 */
public class ExportXMLPanel extends javax.swing.JFrame {

	private final ExportXMLController controller;
	private UIController uiController;

	/**
	 * Creates new form ExportXMLPanel
	 *
	 * @param uiController
	 */
	public ExportXMLPanel(UIController uiController) {
		initComponents();
		this.uiController = uiController;
		this.controller = new ExportXMLController(this.uiController);
		initiateOptions();
		this.jComboBoxSpreedSheet.setEnabled(false);
	}

	private void initiateOptions() {
		this.jComboBoxType.removeAll();
		this.jComboBoxType.addItem("Workbook");
		this.jComboBoxType.addItem("SpreedSheet");
		this.jComboBoxType.addItem("SpreedSheet Selected");
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
        jComboBoxType = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxSpreedSheet = new javax.swing.JComboBox<>();
        jToggleButtonCancel = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldTagColumn = new javax.swing.JTextField();
        jTextFieldTagWorkbook = new javax.swing.JTextField();
        jTextFieldTagSpreadSheet = new javax.swing.JTextField();
        jTextFieldTagRow = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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

        jLabel3.setText("WoorkBook:");

        jLabel4.setText("SpreadSheet:");

        jLabel5.setText("Row:");

        jLabel6.setText("Column:");

        jTextFieldTagColumn.setText("Column");

        jTextFieldTagWorkbook.setText("WorkBook");

        jTextFieldTagSpreadSheet.setText("SpreadSheet");
        jTextFieldTagSpreadSheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTagSpreadSheetActionPerformed(evt);
            }
        });

        jTextFieldTagRow.setText("Row");

        jLabel7.setText("Tags");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxSpreedSheet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addComponent(jTextFieldTagColumn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTagWorkbook))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(63, 63, 63)
                                .addComponent(jTextFieldTagRow))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(13, 13, 13)
                                .addComponent(jTextFieldTagSpreadSheet)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addComponent(jButtonExport)
                        .addGap(27, 27, 27)
                        .addComponent(jToggleButtonCancel)
                        .addGap(32, 32, 32))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(66, 66, 66))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTagWorkbook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldTagSpreadSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldTagRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldTagColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jToggleButtonCancel)
                    .addComponent(jButtonExport))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExportActionPerformed
		JFileChooser fileChooser = new JFileChooser();
		int retrival = fileChooser.showSaveDialog(null);
		if (retrival == JFileChooser.APPROVE_OPTION) {
			try {

				switch (this.jComboBoxType.getSelectedIndex()) {
					case 0:
						this.controller.
							exportWorkbook(fileChooser, this.jTextFieldTagWorkbook.
										   getText(), this.jTextFieldTagSpreadSheet.
										   getText(), this.jTextFieldTagRow.
										   getText(), this.jTextFieldTagColumn.
										   getText());
						break;
					case 1:
						this.controller.
							exportSpreadSheet(fileChooser, this.jTextFieldTagSpreadSheet.
											  getText(), this.jTextFieldTagRow.
											  getText(), this.jTextFieldTagColumn.
											  getText(), this.uiController.
											  getActiveWorkbook().
											  getSpreadsheet(this.jComboBoxSpreedSheet.
												  getSelectedIndex()));
						break;
					default:
						this.controller.
							exportSpreadSheetSelected(fileChooser, this.jTextFieldTagSpreadSheet.
													  getText(), this.jTextFieldTagRow.
													  getText(), this.jTextFieldTagColumn.
													  getText());
						break;
				}
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

    private void jTextFieldTagSpreadSheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTagSpreadSheetActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTagSpreadSheetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox checkbox1;
    private javax.swing.JButton jButtonExport;
    private javax.swing.JComboBox<String> jComboBoxSpreedSheet;
    private javax.swing.JComboBox<String> jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextFieldTagColumn;
    private javax.swing.JTextField jTextFieldTagRow;
    private javax.swing.JTextField jTextFieldTagSpreadSheet;
    private javax.swing.JTextField jTextFieldTagWorkbook;
    private javax.swing.JToggleButton jToggleButtonCancel;
    // End of variables declaration//GEN-END:variables

}
