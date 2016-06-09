/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contacts.ui;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.ext.contacts.ContactsController;
import csheets.notification.Notification;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Martins
 */
public class CompanyView extends javax.swing.JFrame implements Observer {

	private ContactsController controller;
	private Contact contact;

	/**
	 * Creates new form CompanyView
	 *
	 * @param controller controller
	 * @param contact contact
	 */
	public CompanyView(ContactsController controller, Contact contact) {
		this.controller = controller;
		initComponents();
		Notification.calendarInformer().addObserver(this);
		Notification.contactInformer().addObserver(this);
		Notification.eventInformer().addObserver(this);
		this.update(null, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		try {
			this.jLabelCompanyPhoto.setIcon(new ImageIcon(this.controller.
				contactPhoto(contact)));
			this.jLabelCompanyName.setText(this.contact.name());
			this.jTreeCompany.removeAll();
			DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.jTreeCompany.
				getModel().getRoot();
			for (Contact contact : this.controller.contactsCompany(contact)) {
				DefaultMutableTreeNode contactRoot = new DefaultMutableTreeNode(contact);
				root.add(new DefaultMutableTreeNode(contact));
				for (Event event : this.controller.eventsContact(contact)) {
					contactRoot.add(new DefaultMutableTreeNode(event));
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(CompanyView.class.getName()).
				log(Level.SEVERE, null, ex);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCompany = new javax.swing.JTree();
        jLabelAgenda = new javax.swing.JLabel();
        jLabelCompanyPhoto = new javax.swing.JLabel();
        jLabelCompanyName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTreeCompany);

        jLabelAgenda.setText("Agenda:");

        jLabelCompanyPhoto.setBackground(new java.awt.Color(0, 0, 0));

        jLabelCompanyName.setText("Company Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCompanyPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCompanyName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelAgenda))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCompanyName)
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelCompanyPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelAgenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAgenda;
    private javax.swing.JLabel jLabelCompanyName;
    private javax.swing.JLabel jLabelCompanyPhoto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTreeCompany;
    // End of variables declaration//GEN-END:variables

}
