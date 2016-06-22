/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.calendar.ui;

import csheets.domain.Contact;
import csheets.domain.ContactCalendar;
import csheets.domain.PersonContact;
import csheets.ext.calendar.CalendarController;
import csheets.ext.contacts.ContactsController;
import csheets.ext.contacts.ui.*;
import csheets.notification.Notification;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Martins
 */
public class CalendarView extends javax.swing.JFrame implements Observer {

	private CalendarController controller;
	DefaultMutableTreeNode root;
	private ContactCalendar calendar;
	private Contact contact;

	/**
	 * Creates new form EventView
	 *
	 * @param controller controller
	 * @param calendar calendar
	 */
	public CalendarView(CalendarController controller, ContactCalendar calendar) {
		this.controller = controller;
		this.calendar = calendar;
		this.contact = this.calendar.getContact();
		initComponents();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);

		DefaultMutableTreeNode treeRoot = (DefaultMutableTreeNode) this.jTreeEvent.
			getModel().getRoot();
		this.root = new DefaultMutableTreeNode("Calendar: " + this.calendar.
			getName());
		treeRoot.add(root);

		this.update(null, null);
		Notification.calendarInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.jLabel1.setText("Name: " + this.calendar.getName());
		this.jLabel2.setText("Description: " + this.calendar.getText());
		try {
			this.jTreeEvent.removeAll();
			DefaultMutableTreeNode contactRoot = new DefaultMutableTreeNode("Contact: " + this.contact.
				name());
			root.add(contactRoot);
			this.jTreeEvent.revalidate();
			this.jTreeEvent.repaint();
		} catch (Exception ex) {
			Logger.getLogger(CompanyView.class.getName()).
				log(Level.SEVERE, null, ex);

		}
		this.revalidate();
		this.repaint();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeEvent = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTextField2.setText("jTextField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTreeEvent.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTreeEvent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTreeEventMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTreeEvent);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTreeEventMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTreeEventMouseClicked
		if (evt.getClickCount() == 3) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTreeEvent.
				getLastSelectedPathComponent();
			if (node == null) {
				return;
			}
			String[] info = node.getUserObject().toString().split(":");
			if (info[0].equalsIgnoreCase("Contact")) {
				if (this.contact instanceof PersonContact) {
					new PersonView(new ContactsController(), this.contact);
				} else {
					new CompanyView(new ContactsController(), this.contact);
				}
			}
		}
    }//GEN-LAST:event_jTreeEventMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTree jTreeEvent;
    // End of variables declaration//GEN-END:variables

}
