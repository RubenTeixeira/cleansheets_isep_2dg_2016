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
	private final UIController uiController;

	/**
	 * Creates new form MacroShellBeanPanel
	 *
	 * @param uiController uiController
	 */
	public MacroBeanShellPanel(UIController uiController) {
		this.controller = new MacroBeanShellController(uiController);
		this.uiController = uiController;
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
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaResult = new javax.swing.JTextArea();
        btnExecute = new javax.swing.JButton();
        managerButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAreaCode = new javax.swing.JTextPane();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        managerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/settings.png"))); // NOI18N
        managerButton.setFocusable(false);
        managerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerButtonActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(txtAreaCode);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2)
                    .addComponent(btnExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(managerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(managerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExecute)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExecuteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExecuteActionPerformed
		String result = controller.executeCode(radioGroupScript.getSelection().
			getActionCommand(), txtAreaCode.getText());
		txtAreaResult.setEnabled(true);
		txtAreaResult.setText(result);
    }//GEN-LAST:event_btnExecuteActionPerformed

    private void managerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerButtonActionPerformed
		new ScriptManagerUI(uiController).run();
    }//GEN-LAST:event_managerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecute;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton managerButton;
    private javax.swing.JRadioButton radioBtnBeanShell;
    private javax.swing.JRadioButton radioBtnMacro;
    private javax.swing.ButtonGroup radioGroupScript;
    private javax.swing.JTextPane txtAreaCode;
    private javax.swing.JTextArea txtAreaResult;
    // End of variables declaration//GEN-END:variables
}
