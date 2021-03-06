package csheets.ext.notes_and_lists.ui;

import csheets.domain.Contact;
import csheets.domain.Note;
import csheets.ext.notes_and_lists.NotesListsController;
import csheets.ext.notes_and_lists.NotesListsExtension;
import csheets.notification.Notification;
import csheets.ui.DefaulListModel;
import csheets.ui.ctrl.UIController;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;

/**
 *
 * @author Diogo Azevedo
 */
public class NotesPanel extends javax.swing.JPanel implements Observer {

    private final NotesListsController controller;
    /**
     * Default receive list
     */
    private DefaultListModel NoteListModel = new DefaulListModel();
    /**
     * Default receive list
     */
    private DefaultListModel VersionListModel = new DefaulListModel();

    /**
     * Creates new form EventsPanel
     *
     * @param uiController The user interface controller.
     */
    public NotesPanel(UIController uiController) {
        this.controller = new NotesListsController(uiController);
        this.setName(NotesListsExtension.NAME);
        this.initComponents();
        Notification.noteInformer().addObserver(this);
        Notification.contactInformer().addObserver(this);
        this.update(null, null);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Contact) {
            this.jComboBoxContacts.removeAllItems();
            for (Contact c : controller.showContacts()) {
                jComboBoxContacts.addItem(c);
            }
        } else if (arg instanceof Note) {
            this.NoteListModel.removeAllElements();
            if (jComboBoxContacts.getSelectedItem() != null) {
                Contact c = (Contact) jComboBoxContacts.getSelectedItem();
                for (Note note : controller.notesByContact(c)) {
                    this.NoteListModel.addElement(note);
                }
                jListNotes.setModel(NoteListModel);
            }
        } else if (arg == null) {
            this.jComboBoxContacts.removeAllItems();
            for (Contact c : controller.showContacts()) {
                jComboBoxContacts.addItem(c);
            }
            //NOTES
            this.NoteListModel.removeAllElements();
            if (jComboBoxContacts.getSelectedItem() != null) {
                Contact c = (Contact) jComboBoxContacts.getSelectedItem();
                for (Note note : controller.notesByContact(c)) {
                    this.NoteListModel.addElement(note);
                }
                jListNotes.setModel(NoteListModel);
            }
        }
        refreshUI();
    }

    private void refreshUI() {
        jListNotes.revalidate();
        jListNotes.repaint();
        jListNotesVersion.revalidate();
        jListNotesVersion.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxContacts = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaNote = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListNotesVersion = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jButtonCreate = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListNotes = new javax.swing.JList<>();

        jLabel2.setText("jLabel2");

        jPanel1.setLayout(new java.awt.BorderLayout());

        jComboBoxContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxContactsActionPerformed(evt);
            }
        });

        jLabel1.setText("Contacts:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contact's Notes");

        jLabel4.setText("Note");

        jTextAreaNote.setColumns(20);
        jTextAreaNote.setRows(5);
        jScrollPane2.setViewportView(jTextAreaNote);

        jScrollPane3.setViewportView(jListNotesVersion);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Note's versions");

        jButtonCreate.setText("Create");
        jButtonCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCreateActionPerformed(evt);
            }
        });

        jButtonEdit.setText("Edit");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jListNotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListNotesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListNotes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxContacts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonCreate)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxContacts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 40, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCreate)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonDelete))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCreateActionPerformed
        Contact contacto = (Contact) jComboBoxContacts.getSelectedItem();
        System.out.println(contacto.name());
        controller.createNote(jTextAreaNote.getText(), (Contact) jComboBoxContacts.getSelectedItem());
    }//GEN-LAST:event_jButtonCreateActionPerformed

    private void jComboBoxContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxContactsActionPerformed

    }//GEN-LAST:event_jComboBoxContactsActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        controller.editNote(jTextAreaNote.getText(), (Note) this.NoteListModel.getElementAt(this.jListNotes.getSelectedIndex()));
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        controller.deleteNote((Note) this.NoteListModel.getElementAt(this.jListNotes.getSelectedIndex()));

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jListNotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListNotesMouseClicked
        //VERSIONS
        this.VersionListModel.removeAllElements();
        if (jListNotes.getSelectedValue() != null) {
            Note n = (Note) this.NoteListModel.getElementAt(this.jListNotes.getSelectedIndex());
            for (Note note : n.versionByNote()) {
                this.VersionListModel.addElement(note);
            }
            jListNotesVersion.setModel(VersionListModel);
        }
        refreshUI();
    }//GEN-LAST:event_jListNotesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JComboBox<Object> jComboBoxContacts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListNotes;
    private javax.swing.JList<Object> jListNotesVersion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextAreaNote;
    // End of variables declaration//GEN-END:variables
}
