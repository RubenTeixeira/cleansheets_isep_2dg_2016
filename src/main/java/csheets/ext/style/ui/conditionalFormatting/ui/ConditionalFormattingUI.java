/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.style.ui.conditionalFormatting.ui;

import csheets.ext.style.ui.conditionalFormatting.ConditionalFormattingController;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author utilizador
 */
public class ConditionalFormattingUI extends javax.swing.JPanel implements SelectionListener {

	private final UIController uiController;
	private final ConditionalFormattingController conditionalFormattingController;

	/**
	 * Creates new form ConditionalFormattingUI
	 *
	 * @param uiController
	 */
	public ConditionalFormattingUI(UIController uiController) {
		initComponents();
		this.uiController = uiController;
		this.conditionalFormattingController = new ConditionalFormattingController();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
	public void run() {
		this.setVisible(true);
	}

	@Override
	public void selectionChanged(SelectionEvent event) {
		//TODO
	}
}
