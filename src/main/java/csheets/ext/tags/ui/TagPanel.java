/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.tags.ui;

import csheets.domain.Contact;
import csheets.ext.contacts.ContactsExtension;
import csheets.ext.tags.TagController;
import csheets.notification.Notification;
import csheets.ui.DefaulListModel;
import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author João Martins
 */
public class TagPanel extends javax.swing.JPanel implements Observer {

	private TagController controller;
	private Contact user;
	private DefaulListModel model = new DefaulListModel();

	/**
	 * Creates new form EventsPanel
	 *
	 * @param uiController The user interface controller.
	 */
	public TagPanel(UIController uiController) {
		this.setName(ContactsExtension.NAME);
		this.controller = new TagController(uiController, this);
		this.user = this.controller.systemUser();
		this.initComponents();
		this.update(null, null);
		Notification.contactInformer().addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.user = this.controller.systemUser();
		this.jPanelContacts.removeAll();
		((GridLayout) this.jPanelContacts.getLayout()).setRows(5);
		for (Contact contact : this.controller.allContactsTag()) {
			ContactPanelSingle panel = new ContactPanelSingle(this.controller, contact);
			this.jPanelContacts.add(panel);
			GridLayout layout = (GridLayout) this.jPanelContacts.
				getLayout();
			layout.setRows(layout.getRows() + 1);
		}
		this.jPanelContacts.revalidate();
		this.jPanelContacts.repaint();
		this.model.removeAllElements();
		for (Entry<String, Integer> tagFrequency : this.controller.
			tagFrequency().entrySet()) {
			String auxiliar = "Tag: " + tagFrequency.getKey() + "  -  Frequency: " + tagFrequency.
				getValue();
			this.model.addElement(auxiliar);
		}
		this.jListFrequency.setModel(this.model);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jScrollPane8 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        tabPane = new javax.swing.JTabbedPane();
        panelNotes = new javax.swing.JPanel();
        jPanelContacts = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        panelLists = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListFrequency = new javax.swing.JList<>();

        jMenu1.setText("jMenu1");

        jScrollPane8.setViewportView(jEditorPane1);

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jPanelContacts.setLayout(new java.awt.GridLayout(5, 1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelNotesLayout = new javax.swing.GroupLayout(panelNotes);
        panelNotes.setLayout(panelNotesLayout);
        panelNotesLayout.setHorizontalGroup(
            panelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                    .addComponent(jPanelContacts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelNotesLayout.setVerticalGroup(
            panelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelContacts, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
        );

        tabPane.addTab("Contacts", panelNotes);

        jScrollPane9.setViewportView(jListFrequency);

        javax.swing.GroupLayout panelListsLayout = new javax.swing.GroupLayout(panelLists);
        panelLists.setLayout(panelListsLayout);
        panelListsLayout.setHorizontalGroup(
            panelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
        );
        panelListsLayout.setVerticalGroup(
            panelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
        );

        tabPane.addTab("Frequency", panelLists);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

		controller.setText(this.jTextField1.getText());
		this.update(null, null);
    }//GEN-LAST:event_jTextField1KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JList<String> jListFrequency;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanelContacts;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelLists;
    private javax.swing.JPanel panelNotes;
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
