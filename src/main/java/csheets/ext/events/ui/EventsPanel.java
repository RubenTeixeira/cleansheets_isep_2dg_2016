/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.events.ui;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.ext.events.EventsController;
import csheets.ext.events.EventsExtension;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.support.DateTime;
import csheets.ui.ctrl.UIController;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Martins
 */
public class EventsPanel extends javax.swing.JPanel implements Observer {

	private DefaultListModel jModelListEvents;
	private EventsController controller;

	/**
	 * Creates new form EventsPanel
	 *
	 * @param uiController
	 */
	public EventsPanel(UIController uiController) {
		this.setName(EventsExtension.NAME);
		this.jModelListEvents = new DefaultListModel();

		this.creation();
		Notification.eventInformer().addObserver(this);
		this.controller = new EventsController(uiController, this);
		this.initComponents();
		this.update(null, null);
	}

	@Override
	public void update(Observable o, Object arg) {

	}

	public void creation() {
		this.jModelListEvents.removeAllElements();
//		Contact contact = new Contact("João", "Pessoal");
//		Calendar calendar = DateTime.
//			newCalendar(2016, 05, 31, 8, 22, 0);
//		Event event = new Event(contact, "Lapr4", calendar);
//		try {
//			PersistenceContext.repositories().events().add(event);
//		} catch (DataIntegrityViolationException ex) {
//			System.out.println("Erro");
//		}
//		this.jModelListEvents.addElement(event);
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
        jListEvents = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jButtonEdit = new javax.swing.JButton();
        jButtonRemoveEvent = new javax.swing.JButton();
        jButtonAddEvent = new javax.swing.JButton();

        jListEvents.setModel(this.jModelListEvents);
        jListEvents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListEvents);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jButtonEdit.setText("edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEdit, java.awt.BorderLayout.CENTER);

        jButtonRemoveEvent.setText("-");
        jButtonRemoveEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveEventActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRemoveEvent, java.awt.BorderLayout.EAST);

        jButtonAddEvent.setText("+");
        jButtonAddEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEventActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddEvent, java.awt.BorderLayout.WEST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEventActionPerformed
		ManageEvents event = new ManageEvents(this.controller);

		int eventOption = JOptionPane.
			showConfirmDialog(null, event, "Create Event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		if (eventOption == JOptionPane.OK_OPTION) {
			event.createEvent();
		}

    }//GEN-LAST:event_jButtonAddEventActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
		ManageEvent event = new ManageEvent(this.controller);
		event.setVisible(true);
		event.setLocationRelativeTo(this);
		event.setTitle("Edit Event");
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonRemoveEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveEventActionPerformed
    }//GEN-LAST:event_jButtonRemoveEventActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddEvent;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonRemoveEvent;
    private javax.swing.JList<String> jListEvents;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}