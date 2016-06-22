/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.agenda.ui.CalendarView;

import csheets.ext.agenda.ui.AgendaFrame;

/**
 *
 * @author Rui Freitas <1130303@isep.ipp.pt>
 */
public abstract class AbstractCalendarViewPanel extends javax.swing.JPanel {

	protected AgendaFrame theParent;

	/**
	 * Creates new form AbstractCalendarViewPanel
	 *
	 * @param parent
	 */
	public AbstractCalendarViewPanel(AgendaFrame parent) {
		this.theParent = parent;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(380, 340));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

	/* Abstract methods to be implemented */
	public abstract void updateEvents();

	protected abstract void clearEventList();

}