/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.wizard.ui;

import com.toedter.calendar.JTextFieldDateEditor;
import csheets.core.formula.FunctionParameter;
import csheets.ui.ctrl.UIController;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author AB-1140280
 */
public class WizardFrame extends javax.swing.JFrame {

	WizardController controller;

	/**
	 * Creates new form WizardFrame
	 *
	 * @param uiController uiController
	 */
	public WizardFrame(UIController uiController) {
		setLocationRelativeTo(this);
		controller = new WizardController(uiController);
		initComponents();
                txtFieldsInvisibles();
		loadFunctions();
                setVisible(true);
                setLocationRelativeTo(null);
	}

	private void loadFunctions() {
		FunctionListModel model = controller.getFunctions();
		functionsList.setModel(model);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        resultTextBox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        selectedFunctionTextBox = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        functionsList = new javax.swing.JList<>();
        helpButton = new javax.swing.JButton();
        panelTextFieldsOfFunction = new javax.swing.JPanel();
        txtFieldParameter1 = new javax.swing.JTextField();
        txtFieldParameter2 = new javax.swing.JTextField();
        txtFieldParameter3 = new javax.swing.JTextField();
        txtFieldParameter4 = new javax.swing.JTextField();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        resultTextBox.setEditable(false);
        resultTextBox.setText("Hit confirm...");
        resultTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultTextBoxActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Result");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Function");

        selectedFunctionTextBox.setText("Select a function");
        selectedFunctionTextBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedFunctionTextBoxActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirm");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        functionsList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                functionsListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(functionsList);

        helpButton.setText("Help");
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        panelTextFieldsOfFunction.setForeground(new java.awt.Color(1, 0, 5));
        panelTextFieldsOfFunction.setDoubleBuffered(false);

        txtFieldParameter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldParameter1ActionPerformed(evt);
            }
        });

        txtFieldParameter2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldParameter2ActionPerformed(evt);
            }
        });

        txtFieldParameter3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldParameter3ActionPerformed(evt);
            }
        });

        txtFieldParameter4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldParameter4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTextFieldsOfFunctionLayout = new javax.swing.GroupLayout(panelTextFieldsOfFunction);
        panelTextFieldsOfFunction.setLayout(panelTextFieldsOfFunctionLayout);
        panelTextFieldsOfFunctionLayout.setHorizontalGroup(
            panelTextFieldsOfFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextFieldsOfFunctionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFieldParameter1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldParameter2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldParameter3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFieldParameter4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelTextFieldsOfFunctionLayout.setVerticalGroup(
            panelTextFieldsOfFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTextFieldsOfFunctionLayout.createSequentialGroup()
                .addGroup(panelTextFieldsOfFunctionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldParameter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldParameter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldParameter4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(txtFieldParameter3)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(confirmButton)
                .addGap(18, 18, 18)
                .addComponent(helpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(61, 61, 61))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(selectedFunctionTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resultTextBox))
                    .addComponent(panelTextFieldsOfFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(selectedFunctionTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelTextFieldsOfFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(cancelButton)
                    .addComponent(helpButton))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectedFunctionTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedFunctionTextBoxActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_selectedFunctionTextBoxActionPerformed

    private void resultTextBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultTextBoxActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_resultTextBoxActionPerformed

	/**
	 * When a function is clicked diplays detailed function info
	 *
	 * @param evt
	 */
    private void functionsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_functionsListMouseClicked
		int index = functionsList.getSelectedIndex();
		String info = ((FunctionListModel) functionsList.getModel()).
			getFunctionInfo(index, controller);
		selectedFunctionTextBox.setText(info);
                int i=this.controller.getParametersOfFunctionSelected().length;
                System.out.println(i);
                openTextFields(i);
    }//GEN-LAST:event_functionsListMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * Tries to execute the function in selectedFunctionTextBox if an an
	 * exception occurs a message dialog is presented to the user showing the
	 * error
	 *
	 * @param evt
	 */
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
		try {
			String result = controller.executeFormula(selectedFunctionTextBox.
				getText());
			resultTextBox.setText(result);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Ocorreu um erro" + ex.
										  getMessage());
		}
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
		String help = ((FunctionListModel) functionsList.getModel()).
			getHelp(functionsList.getSelectedIndex());
		JOptionPane.showMessageDialog(this, help);
    }//GEN-LAST:event_helpButtonActionPerformed

    private void txtFieldParameter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldParameter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldParameter1ActionPerformed

    private void txtFieldParameter2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldParameter2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldParameter2ActionPerformed

    private void txtFieldParameter3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldParameter3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldParameter3ActionPerformed

    private void txtFieldParameter4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldParameter4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldParameter4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JList<String> functionsList;
    private javax.swing.JButton helpButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelTextFieldsOfFunction;
    private javax.swing.JTextField resultTextBox;
    private javax.swing.JTextField selectedFunctionTextBox;
    private javax.swing.JTextField txtFieldParameter1;
    private javax.swing.JTextField txtFieldParameter2;
    private javax.swing.JTextField txtFieldParameter3;
    private javax.swing.JTextField txtFieldParameter4;
    // End of variables declaration//GEN-END:variables

    private void txtFieldsInvisibles() {
        txtFieldParameter1.setVisible(false);
        txtFieldParameter2.setVisible(false);
        txtFieldParameter3.setVisible(false);
        txtFieldParameter4.setVisible(false);
    }

    private void openTextFields(int i) {
        System.out.println(i);
        if(i==1){
            txtFieldParameter1.setVisible(true);
        }
        if(i==2){
            txtFieldParameter1.setVisible(true);
            txtFieldParameter2.setVisible(true);
        }
        if(i==3){
            txtFieldParameter1.setVisible(true);
            txtFieldParameter2.setVisible(true);
            txtFieldParameter3.setVisible(true);
        }
        if(i==1){
            txtFieldParameter1.setVisible(true);
            txtFieldParameter2.setVisible(true);
            txtFieldParameter3.setVisible(true);
            txtFieldParameter4.setVisible(true);
        }
    }

}
