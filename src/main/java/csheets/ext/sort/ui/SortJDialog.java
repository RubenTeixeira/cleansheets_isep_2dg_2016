/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.sort.ui;

import csheets.ext.sort.SortController;
import csheets.ui.ctrl.UIController;
import javax.swing.DefaultComboBoxModel;

/**
 * JDialog Window for User Interaction.
 *
 * @author Pedro Gomes 1130383@isep.ipp.pt
 */
public class SortJDialog extends javax.swing.JDialog {

	/**
	 * Sort Controller.
	 */
	private SortController sortController;

	/**
	 * User Interface Controller.
	 */
	private UIController uiController;

	/**
	 * Sort order.
	 */
	private int order = 0;

	public SortJDialog(UIController c) {
		this.uiController = c;
		this.sortController = new SortController(this.uiController);
		setTitle("Sort Column");
		initComponents();
		setModal(true);
		ascendingRadioButton.setSelected(true);//default
		setLocation(1005, 100); //window location
		setDefaultLookAndFeelDecorated(true); //LookAndFeal
		//combo box - defaultmodel
		columnComboBox.setModel(new DefaultComboBoxModel());
		DefaultComboBoxModel box = (DefaultComboBoxModel) columnComboBox.
			getModel();
		char str = 'A';
		box.addElement(str);
		for (int i = 0; i < this.uiController.getActiveSpreadsheet().
			getColumnCount(); i++) {
			str = (char) (str + 1);
			box.addElement(str);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        ascendingRadioButton = new javax.swing.JRadioButton();
        descendingRadioButton = new javax.swing.JRadioButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        columnComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ascendingRadioButton.setText("Ascending");
        ascendingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascendingRadioButtonActionPerformed(evt);
            }
        });

        descendingRadioButton.setText("Descending ");
        descendingRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descendingRadioButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        columnComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        columnComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                columnComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Sort Column");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(okButton)
                            .addComponent(columnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(descendingRadioButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ascendingRadioButton)
                                    .addComponent(cancelButton))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(columnComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(ascendingRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descendingRadioButton)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Ascending option.
	 *
	 * @param evt
	 */
    private void ascendingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascendingRadioButtonActionPerformed
		ascendingRadioButton.setSelected(true);
		descendingRadioButton.setSelected(false);
    }//GEN-LAST:event_ascendingRadioButtonActionPerformed

	/**
	 * Descending option.
	 *
	 * @param evt
	 */
    private void descendingRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descendingRadioButtonActionPerformed
		ascendingRadioButton.setSelected(false);
		descendingRadioButton.setSelected(true);
    }//GEN-LAST:event_descendingRadioButtonActionPerformed

	/**
	 * Cancel.
	 *
	 * @param evt
	 */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * Perform Sorting
	 *
	 * @param evt
	 */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
		this.sortController.setIndex(columnComboBox.getSelectedIndex());
		this.sortController.updateValueList();
		if (ascendingRadioButton.getModel().isSelected()) {
			this.sortController.order(order);
			this.sortController.updateColumn();
		} else {
			order = 1;
			this.sortController.order(order);
			this.sortController.updateColumn();
		}
		ascendingRadioButton.setSelected(false);
		descendingRadioButton.setSelected(false);
		dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void columnComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_columnComboBoxActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_columnComboBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascendingRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox columnComboBox;
    private javax.swing.JRadioButton descendingRadioButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables
}
