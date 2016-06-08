package csheets.ext.contacts.ui;

import csheets.domain.Contact;
import csheets.ext.contacts.ContactsController;
import csheets.ext.contacts.ContactsExtension;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class ContactsPanel2 extends javax.swing.JPanel implements Observer {

	private ContactsController controller;

	/**
	 * Creates new form ContactsPanel
	 *
	 * @param uiController The user interface controller.
	 */
	public ContactsPanel2(UIController uiController) {
		this.setName(ContactsExtension.NAME);
		this.controller = new ContactsController(uiController, this);
		this.initComponents();
		this.update(null, null);
		Notification.contactInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.jPanelContacts.removeAll();
		//((GridLayout) this.jPanelPrincipal.getLayout()).setRows(1);
		//((GridLayout) this.jPanelContacts.getLayout()).setRows(5);
		List<Contact> contacts = (List<Contact>) this.controller.allContacts();
		Contact principal = null;

		/*
		for (Contact contact : this.controller.allContacts()) {
			if (contact.name() == "") {
				principal = contact;
			} else {
				this.jPanelContacts.
					add(new ContactsPanelSingle2(this.controller, principal));
				GridLayout layout = (GridLayout) this.jPanelContacts.getLayout();
				layout.setRows(layout.getRows() + 1);
			}
		}

		if (principal != null) {
			this.jPanelPrincipal.
				add(new ContactsPanelSingle2(this.controller, principal));
		}
		 */
		this.jPanelContacts.removeAll();
		((GridLayout) this.jPanelContacts.getLayout()).setRows(5);
		for (Contact contact : this.controller.allContacts()) {
			ContactsPanelSingle2 panel = new ContactsPanelSingle2(this.controller, contact);
			this.jPanelContacts.add(panel);
			GridLayout layout = (GridLayout) this.jPanelContacts.getLayout();
			layout.setRows(layout.getRows() + 1);
		}
		this.jPanelContacts.revalidate();
		this.jPanelContacts.repaint();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelContacts = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jPanelPrincipal = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanelContacts.setBackground(new java.awt.Color(204, 204, 204));
        jPanelContacts.setLayout(new java.awt.GridLayout(5, 1));
        jScrollPane1.setViewportView(jPanelContacts);

        jButtonAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/add_event.png"))); // NOI18N
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jPanelPrincipal.setBackground(new java.awt.Color(204, 204, 204));
        jPanelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/add_contact.png"))); // NOI18N
        addBtn.setMaximumSize(new java.awt.Dimension(25, 25));
        addBtn.setMinimumSize(new java.awt.Dimension(25, 25));
        addBtn.setPreferredSize(new java.awt.Dimension(25, 25));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdd)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
		ContactsManage2 manage = new ContactsManage2(this.controller, null);
		int eventOption = JOptionPane.
			showConfirmDialog(null, manage, "Create Contact", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (eventOption == JOptionPane.OK_OPTION) {
			manage.createEvent();
		}
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
		// TODO add your handling code here:
		new PersonManager(null, this.controller, null).setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContacts;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
