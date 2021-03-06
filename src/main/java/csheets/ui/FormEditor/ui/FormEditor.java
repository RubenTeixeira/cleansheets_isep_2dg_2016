/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ui.FormEditor.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.notification.Notification;
import csheets.ui.ctrl.FormEditorController;
import csheets.ui.ctrl.UIController;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hichampt
 */
public class FormEditor extends JDialog implements Observer {

	/**
	 * Creates new form FormEditor
	 */
	FormEditorController controller;
	private FormE form;
	private String closeButton;
//	private String content;

	public FormEditor(Cell cell) {
		this.controller = new FormEditorController(cell);
		Notification.formInformer().addObserver(this);
		super.setAlwaysOnTop(true);
		initComponents();
		setVisible(true);

	}

	/**
	 * Constructor of the FormEditor
	 *
	 * @param form is form
	 * @param modal is boolean
	 */
	public FormEditor(FormE form, boolean modal) {
		initComponents();
		this.setModal(modal);
		this.form = form;
		this.setTitle("Form " + this.form.getNameForm());
		this.controller = new FormEditorController(form.cell());
		this.jCheckBox1.
			setSelected(true);
		if (this.jCheckBox1.isSelected()) {
			this.form.setEditable(true);
			this.updateButton.setVisible(true);
			this.setEnabled(true);
		} else {
			this.form.setEditable(false);
			this.updateButton.setVisible(false);
			this.setEnabled(false);
		}
		this.closeButton = "";
		Notification.formInformer().addObserver(this);
		super.setAlwaysOnTop(true);

		for (Widget widget : this.form.showLstWidget()) {
			this.createPanel(widget, widget.getContent());
		}

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FormEditor.this.closeButton = "Close Button";
				try {
					if (FormEditor.this.isModal()) {
						FormEditor.this.form.cell().setContent(closeButton);
					}
				} catch (FormulaCompilationException ex) {
					Logger.getLogger(FormEditor.class.getName()).
						log(Level.SEVERE, null, ex);
				}
				e.getWindow().dispose();
			}
		});
		refreshUI();
		setVisible(true);
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
        mainPanel = new javax.swing.JPanel();
        buttonsPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainPanel.setLayout(new java.awt.GridLayout(5, 1, 5, 5));
        jScrollPane1.setViewportView(mainPanel);

        addButton.setText("Add");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(addButton)
                .addGap(26, 26, 26)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addGap(19, 19, 19))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton)
                    .addComponent(updateButton))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jCheckBox1.setText("Editable");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCheckBox1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(88, 88, 88)
                            .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        setSize(new java.awt.Dimension(465, 413));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
		updateTextField();
		UIController.getUIController().getActiveWorkbook().addFormE(form.
			getNameForm(), form);

		this.closeButton = "Update Button";
		try {
			if (this.isModal()) {
				FormEditor.this.form.cell().setContent(closeButton);
			}
		} catch (FormulaCompilationException ex) {
			Logger.getLogger(FormEditor.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		dispose();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
		super.setAlwaysOnTop(false);
		AskContent contentPanel = new AskContent();
		int op = JOptionPane.
			showConfirmDialog(null, contentPanel, "Create New Line", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (op == JOptionPane.OK_OPTION) {

			Widget widget = controller.getWidget(contentPanel.name());
			widget.setContentWidget(contentPanel.content());
			if (widget != null) {
				this.createPanel(widget, widget.getContent());
			} else {
				JOptionPane.showMessageDialog(this, "Widget not found.");
			}
			form.addWidget(widget);
			refreshUI();
		}
    }//GEN-LAST:event_addButtonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
		form.setEditable(!form.isEditable());
		this.updateButton.setVisible(!updateButton.isVisible());
		this.updateButton.setEnabled(!updateButton.isEnabled());
		setPanelEnabled(this.mainPanel, form.
						isEditable());
		setPanelEnabled(this.buttonsPanel, form.isEditable());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
		this.closeButton = "Cancel Button";
		try {
			if (this.isModal()) {
				FormEditor.this.form.cell().setContent(closeButton);
			}
		} catch (FormulaCompilationException ex) {
			Logger.getLogger(FormEditor.class.getName()).
				log(Level.SEVERE, null, ex);
		}
		this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

	/**
	 * Create Panel with widget
	 *
	 * @param wgt
	 * @param content
	 */
	private void createPanel(Widget wgt, String content) {
		if (wgt instanceof ButtonWidget) {
			addPanel(new ButtonPanel(content));
		} else if (wgt instanceof LabelWidget) {
			addPanel(new LabelPanel(content));
		} else {
			addPanel(new TextFieldPanel(content));
		}
	}

	/**
	 * Enable or disable Form Editor
	 *
	 * @param panel
	 * @param isEnabled
	 */
	private void setPanelEnabled(JPanel panel, Boolean isEnabled) {
		panel.setEnabled(isEnabled);

		Component[] components = panel.getComponents();

		for (int i = 0; i < components.length; i++) {
			if (components[i].getClass().getName() == "javax.swing.JPanel") {
				setPanelEnabled((JPanel) components[i], isEnabled);
			} else if (components[i].getClass().getName() == "csheets.ui.FormEditor.ui.ButtonPanel") {
				setPanelEnabled((JPanel) components[i], isEnabled);
			} else if (components[i].getClass().getName() == "csheets.ui.FormEditor.ui.TextFieldPanel") {
				setPanelEnabled((JPanel) components[i], isEnabled);
			} else if (components[i].getClass().getName() == "csheets.ui.FormEditor.ui.LabelPanel") {
				setPanelEnabled((JPanel) components[i], isEnabled);
			}

			components[i].setEnabled(isEnabled);
		}
	}

	/**
	 * Click on Update Button and save changes on textfield
	 */
	private void updateTextField() {

		Component[] components = mainPanel.getComponents();

		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof TextFieldPanel) {
				for (Widget w : this.form.showLstWidget()) {
					if (w instanceof TextFieldWidget) {
						w.setContentWidget(((TextFieldPanel) components[i]).
							contentText());
					}
				}
			}
		}
	}

	/**
	 * Add new Line
	 *
	 * @param panel
	 */
	private void addPanel(JPanel panel) {
		this.mainPanel.add(panel);
		addGridRow();
	}

	/**
	 * Remove line
	 *
	 * @param panel
	 */
	private void removePanel(JPanel panel) {
		this.mainPanel.remove(panel);
		removeGridRow();
	}

	/**
	 * Layout specific: set's the default number of rows (5).
	 */
	private void defaultGridRow() {
		((GridLayout) this.mainPanel.getLayout()).setRows(5);
	}

	/**
	 * Layout specific: add's a row to the panel's layout (to prevent adding a
	 * new column).
	 */
	private void addGridRow() {
		GridLayout layout = (GridLayout) this.mainPanel.getLayout();
		layout.setRows(layout.getRows() + 1);
	}

	/**
	 * Remove row grid.
	 */
	private void removeGridRow() {
		GridLayout layout = (GridLayout) this.mainPanel.getLayout();
		layout.setRows(layout.getRows() - 1);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

	/**
	 * refresh Form Editor
	 */
	private void refreshUI() {
		mainPanel.revalidate();
		mainPanel.repaint();
	}

	/**
	 *
	 * @param o is Observable
	 * @param o1 is widget
	 */
	@Override
	public void update(Observable o, Object o1) {
		String c = "";
		if (o1 instanceof JPanel) {
			removePanel((JPanel) o1);
			if (o1 instanceof LabelPanel) {
				c = ((LabelPanel) o1).getContent();
			} else if (o1 instanceof ButtonPanel) {
				c = ((ButtonPanel) o1).getContent();
			} else {
				c = ((TextFieldPanel) o1).contentText();
			}
			for (Widget w : this.form.showLstWidget()) {
				if (w.getContent().equals(c)) {
					this.form.showLstWidget().remove(w);
					break;
				}
			}
			refreshUI();
		}
	}

	/**
	 *
	 * @return name of button to close Form Editor
	 */
	public String closeButton() {
		return this.closeButton;
	}

}
