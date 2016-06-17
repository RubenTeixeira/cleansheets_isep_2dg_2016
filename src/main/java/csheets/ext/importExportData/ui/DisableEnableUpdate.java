/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.importExportData.ui;

import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.ext.importExportData.FileTask;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author hichampt
 */
public class DisableEnableUpdate extends javax.swing.JDialog implements Observer {

    private final ImportExportTextFileController controller;
    private final UIController uiController;
    //  private Cell[][] cells;

    public DisableEnableUpdate(java.awt.Frame parent, boolean modal,
            UIController uiController,
            ImportExportTextFileController controller) {

        super(parent, modal);

        this.initComponents();

        this.controller = controller;
        this.uiController = uiController;
        super.setAlwaysOnTop(true);

        for (Spreadsheet spreadsheet : uiController.getActiveWorkbook()) {
            this.jComboBoxSpreadSheet.addItem(spreadsheet);
        }

        this.update(null, null);
        Notification.linkFileInformer().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        SpreadsheetImpl spreadsheet = (SpreadsheetImpl) this.jComboBoxSpreadSheet.
                getSelectedItem();
        FileTask fileTask = spreadsheet.getFileTask();
        if (fileTask == null) {
            this.jButtonLink.setText("Link");
            this.jTextFieldPathFile.setText("");
            this.jTextFieldPathFile.setEnabled(true);
            this.jTextFieldSeparator.setText("");
            this.jTextFieldSeparator.setEnabled(true);
            this.jButtonSearch.setEnabled(true);
        } else {
            this.jButtonLink.setText("Unlink");
            this.jTextFieldPathFile.setText(fileTask.getFilePath());
            this.jTextFieldPathFile.setEnabled(false);
            this.jTextFieldSeparator.setText(fileTask.getSeparator());
            this.jTextFieldSeparator.setEnabled(false);
            this.jButtonSearch.setEnabled(false);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonLink = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jComboBoxSpreadSheet = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPathFile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSeparator = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Enable or Disabel automatically update");

        jButtonLink.setText("Link");
        jButtonLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLinkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jComboBoxSpreadSheet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxSpreadSheetItemStateChanged(evt);
            }
        });

        jLabel2.setText("SpreadSheet:");

        jLabel3.setText("Path File:");

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel4.setText("Separator:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxSpreadSheet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldPathFile, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jButtonLink, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSpreadSheet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPathFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonLink))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLinkActionPerformed

        SpreadsheetImpl spreadsheet = (SpreadsheetImpl) this.jComboBoxSpreadSheet.getSelectedItem();

        FileTask fileTask = spreadsheet.getFileTask();

        if (fileTask == null) {
            /**
             * validate Path Text file
             */
            if (jTextFieldPathFile.getText().isEmpty()) {
                JOptionPane.
                        showMessageDialog(this, "You should choose the file to Linking", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                /**
                 * validate Separator Text file
                 */
                if (this.jTextFieldSeparator.getText().isEmpty()) {
                    JOptionPane.
                            showMessageDialog(this, "You should inserts the Separator to Linking", "Error", JOptionPane.ERROR_MESSAGE);
                    return;

                }

                this.controller.
                        linked(this.jTextFieldPathFile.getText(), this.jTextFieldSeparator.
                                getText(), spreadsheet);
            }
        } else {
            this.controller.unlinked(spreadsheet);
            JOptionPane.showMessageDialog(this, "The Unliking has been successfully", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_jButtonLinkActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("File");
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            this.jTextFieldPathFile.setText(fileChooser.getSelectedFile().
                    getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jComboBoxSpreadSheetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxSpreadSheetItemStateChanged
        this.update(null, null);
    }//GEN-LAST:event_jComboBoxSpreadSheetItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonLink;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<Spreadsheet> jComboBoxSpreadSheet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPathFile;
    private javax.swing.JTextField jTextFieldSeparator;
    // End of variables declaration//GEN-END:variables
}
