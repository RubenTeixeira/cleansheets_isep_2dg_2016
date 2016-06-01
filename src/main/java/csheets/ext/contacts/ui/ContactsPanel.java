/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contacts.ui;

import csheets.core.SpreadsheetImpl;
import csheets.domain.Contact;
import csheets.ext.contacts.ContactsExtension;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

/**
 *
 * @author Rui Freitas <1130303>
 */
public class ContactsPanel extends JPanel implements Observer {

    private final ContactsController theController = new ContactsController();

    /**
     * Creates new form ContactsPanel
     *
     * @param controller
     */
    public ContactsPanel(UIController controller) {
        setName(ContactsExtension.NAME);
        Notification.contactCardInformer().addObserver(this);
        Notification.contactInformer().addObserver(this);
        
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

        jPanel1 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        contactsPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(100, 50));
        setMinimumSize(new java.awt.Dimension(100, 50));
        setPreferredSize(new java.awt.Dimension(100, 50));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout(10, 10));

        jPanel1.setLayout(new java.awt.BorderLayout());

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        contactsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contactsPanel.setLayout(new java.awt.GridLayout(5, 1));
        jScrollPane2.setViewportView(contactsPanel);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    /* 
    * Add button action: opens a new dialog where the user can insert a new contact data.
     */
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        new AddEditContactDialog(null, theController, null).setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    /* 
    * Panel selected action: everytime the sidebar is in focus, data is updated.
     */
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        Notification.contactInformer().notifyChange();
    }//GEN-LAST:event_formComponentShown

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Yeah!");
        refreshContactCards();
        contactsPanel.revalidate();
        contactsPanel.repaint();
    }

    /*
    * Refreshes contact list: deletes all information and gets the new data
     */
    protected void refreshContactCards() {
        clearContactList();
        new ListContactsWorker().execute();
    }

    /* 
    * Deletes all information from contact list.
     */
    private void clearContactList() {
        this.contactsPanel.removeAll();
        defaultGridRow();
    }

    /*
    * Adds a single ContactCard to the panel.
     */
    private void addContactCard(JComponent comp) {
        this.contactsPanel.add(comp);
        addGridRow();

    }

    /*
    * Layout specific: set's the default number of rows (5)
     */
    private void defaultGridRow() {
        ((GridLayout) this.contactsPanel.getLayout()).setRows(5);
    }

    /*
    * Layout specific: add's a row to the panel's layout (to prevent adding a new colummn).
     */
    private void addGridRow() {
        GridLayout layout = (GridLayout) this.contactsPanel.getLayout();

        layout.setRows(layout.getRows() + 1);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel contactsPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    /*
    * SwingWorker task to get all contacts from the persistence. 
    * A ContactCard is added step by step and at the end of the task the panel is refreshed.
     */
    class ListContactsWorker extends SwingWorker<Integer, ContactCardPanel> {

        @Override
        protected Integer doInBackground() throws Exception {

            ContactCardPanel card;

            for (Contact ct : theController.allContacts()) {
                card = new ContactCardPanel();
                card.setFirstName(ct.firstName());
                card.setLastName(ct.lastName());
                try {
                    card.setPhoto(theController.contactPhoto(ct));
                } catch (IOException ex) {
                    System.out.println("erro");
                }
                publish(card);
            }
            return 1;
        }

        @Override
        protected void process(List<ContactCardPanel> chunks) {
            for (ContactCardPanel panel : chunks) {
                addContactCard(panel);
            }
        }
    }

}
