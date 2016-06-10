package csheets.ext.contacts.ui;

import csheets.domain.Contact;
import csheets.ext.contacts.ContactsController;
import csheets.ext.contacts.ContactsExtension;
import csheets.notification.Notification;
import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

/**
 *
 * @author Marcelo Barroso 1131399
 */
public class ContactPanel extends javax.swing.JPanel implements Observer {

	private ContactsController controller;
	private Contact user;

	/**
	 * Creates new form ContactsPanel
	 *
	 * @param uiController The user interface controller.
	 */
	public ContactPanel(UIController uiController) {
		this.setName(ContactsExtension.NAME);
		this.controller = new ContactsController(uiController, this);
		this.user = this.controller.systemUser();
		this.initComponents();
		this.update(null, null);
		Notification.contactInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.user = this.controller.systemUser();
		if (this.user != null) {
			this.jLabelName.setText(this.user.name());
			try {
				this.jLabelPhoto.setIcon(new ImageIcon(this.controller.
					contactPhoto(this.user).getScaledInstance(this.jLabelPhoto.
					getWidth(), this.jLabelPhoto.getHeight(), Image.SCALE_SMOOTH)));
			} catch (IOException ex) {
			}
		}
		this.jPanelContacts.removeAll();
		((GridLayout) this.jPanelContacts.getLayout()).setRows(5);
		for (Contact contact : this.controller.allContacts()) {
			if (this.user != null && !contact.name().equalsIgnoreCase(this.user.
				name())) {
				ContactPanelSingle panel = new ContactPanelSingle(this.controller, contact);
				this.jPanelContacts.add(panel);
				GridLayout layout = (GridLayout) this.jPanelContacts.
					getLayout();
				layout.setRows(layout.getRows() + 1);
			}
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
        jPanelPrincipal = new javax.swing.JPanel();
        jLabelPhoto = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jButtonEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanelContacts.setLayout(new java.awt.GridLayout(5, 1));
        jScrollPane1.setViewportView(jPanelContacts);

        jPanelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelPrincipalMouseClicked(evt);
            }
        });

        jLabelPhoto.setMaximumSize(new java.awt.Dimension(45, 45));
        jLabelPhoto.setMinimumSize(new java.awt.Dimension(45, 45));
        jLabelPhoto.setPreferredSize(new java.awt.Dimension(45, 45));
        jLabelPhoto.setSize(new java.awt.Dimension(45, 45));
        jLabelPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPhotoMouseClicked(evt);
            }
        });

        jLabelName.setText("jLabel1");
        jLabelName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelNameMouseClicked(evt);
            }
        });

        jButtonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csheets/res/img/edit.png"))); // NOI18N
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jLabel1.setText("Computer user");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jButtonEdit)))
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonEdit))
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabelPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
		new ContactManager(null, this.controller, null).setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
		new ContactManager(null, this.controller, this.user).setVisible(true);
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jPanelPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelPrincipalMouseClicked
		new PersonView(controller, this.user).setVisible(true);
    }//GEN-LAST:event_jPanelPrincipalMouseClicked

    private void jLabelPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPhotoMouseClicked
		new PersonView(controller, this.user).setVisible(true);
    }//GEN-LAST:event_jLabelPhotoMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
		new PersonView(controller, this.user).setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabelNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelNameMouseClicked
		new PersonView(controller, this.user).setVisible(true);
    }//GEN-LAST:event_jLabelNameMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhoto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelContacts;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
