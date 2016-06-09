/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.macro_beanshell.ui;

import csheets.ext.macro_beanshell.BeanShell;
import csheets.ext.macro_beanshell.Macro;
import csheets.ext.macro_beanshell.MacroBeanShellController;
import csheets.ext.macro_beanshell.MacroBeanShellExtension;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.JRadioButton;

/**
 *
 * @author yur
 */
public class MacroBeanShellPanel extends javax.swing.JPanel {

	private MacroBeanShellController controller;

	/**
	 * Creates new form MacroShellBeanPanel
	 *
	 * @param uiController uiController
	 */
	public MacroBeanShellPanel(UIController uiController) {
		this.controller = new MacroBeanShellController(uiController);
		setName(MacroBeanShellExtension.NAME);
		initComponents();
		txtAreaResult.setEnabled(false);
		createJRadioButtons();
		setRadioGroupButtonsAction();
	}

	private void createJRadioButtons() {
		createJRadioConfig(radioBtnMacro, Macro.NAME);
		createJRadioConfig(radioBtnBeanShell, BeanShell.NAME);
	}

	private void createJRadioConfig(JRadioButton r, String name) {
		r.setText(name);
		r.setActionCommand(name);
	}

	private void setRadioGroupButtonsAction() {
		Enumeration radioGroup = radioGroupScript.getElements();
		while (radioGroup.hasMoreElements()) {
			JRadioButton radioBtn = (JRadioButton) radioGroup.nextElement();
			radioBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					scriptSelectChange(e.getActionCommand());
				}
			});
		}
	}

	private void scriptSelectChange(String scriptName) {
		String example = controller.createExample(scriptName);
		txtAreaCode.setText(example);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupScript = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radioBtnMacro = new javax.swing.JRadioButton();
        radioBtnBeanShell = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaCode = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaResult = new javax.swing.JTextArea();
        btnExecute = new javax.swing.JButton();

        radioGroupScript.add(radioBtnMacro);
        radioBtnMacro.setText("Macro");

        radioGroupScript.add(radioBtnBeanShell);
        radioBtnBeanShell.setText("BeanShell Script");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioBtnMacro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioBtnBeanShell)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBtnMacro)
                    .addComponent(radioBtnBeanShell))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtAreaCode.setColumns(20);
        txtAreaCode.setRows(5);
        jScrollPane1.setViewportView(txtAreaCode);

        txtAreaResult.setEditable(false);
        txtAreaResult.setBackground(new java.awt.Color(60, 63, 65));
        txtAreaResult.setColumns(20);
        txtAreaResult.setForeground(Color.WHITE);
        txtAreaResult.setRows(5);
        txtAreaResult.setDisabledTextColor(new java.awt.Color(150, 150, 150));
        jScrollPane2.setViewportView(txtAreaResult);

        btnExecute.setText("Execute");
        btnExecute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExecuteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addComponent(btnExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExecute)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteActionPerformed
		String result = controller.executeCode(radioGroupScript.getSelection().
			getActionCommand(), txtAreaCode.getText());
		txtAreaResult.setEnabled(true);
		txtAreaResult.setText(result);
    }//GEN-LAST:event_btnExecuteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecute;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioBtnBeanShell;
    private javax.swing.JRadioButton radioBtnMacro;
    private javax.swing.ButtonGroup radioGroupScript;
    private javax.swing.JTextArea txtAreaCode;
    private javax.swing.JTextArea txtAreaResult;
    // End of variables declaration//GEN-END:variables
}
