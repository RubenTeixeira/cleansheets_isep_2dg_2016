/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.notes_and_lists.ui;

import csheets.domain.Contact;
import csheets.domain.List;
import csheets.domain.Note;
import csheets.ext.notes_and_lists.NotesListsController;
import csheets.ext.notes_and_lists.NotesListsExtension;
import csheets.notification.Notification;
import csheets.ui.DefaulListModel;
import csheets.ui.ctrl.UIController;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rui Bento
 * @author Diogo Azevedo
 */
public class NotesListsPanels extends javax.swing.JPanel implements Observer {

    private NotesListsController controller;

    /**
     * Default receive list
     */
    private DefaultListModel NoteListModel = new DefaulListModel();
    /**
     * Default receive list
     */
    private DefaultListModel VersionListModel = new DefaulListModel();

    private DefaultComboBoxModel<Contact> contactModel;
    private DefaultListModel<List> contactListModel;
    private DefaultListModel<List> listVersionModel;
    private DefaultTableModel listDataModel;

    /**
     * Creates new form EventsPanel
     *
     * @param uiController The user interface controller.
     */
    public NotesListsPanels(UIController uiController) {
        this.controller = new NotesListsController(uiController);
        this.setName(NotesListsExtension.NAME);
        createModels();
        initComponents();
        createActions();
        fetchContacts();
        Notification.noteInformer().addObserver(this);
        Notification.contactInformer().addObserver(this);
        this.update(null, null);
    }

    private void createModels() {
        contactModel = new DefaultComboBoxModel();
        contactListModel = new DefaultListModel();
        listVersionModel = new DefaultListModel();
        listDataModel = new DefaultTableModel();
    }

    private void createActions() {
        addContactsComboBoxAction();
        addListsAction();
        addListVersionsAction();
        addEditAction();
    }

    private void fetchContacts() {
        controller.updateContacts(contactModel);
    }

    private void addContactsComboBoxAction() {
        cbListContact.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    controller.updateContactListsModel(contactListModel, e.getItem());
                    panelContactList.setVisible(true);
                    panelCreateList.setVisible(true);
                    panelListVersion.setVisible(false);
                    panelListData.setVisible(false);
                    panelListActions.setVisible(false);
                }
            }
        });
    }

    private void addListsAction() {
        lstContactLists.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                controller.updateContactListsModel(contactListModel, e.getSource());
                panelListVersion.setVisible(true);
                panelListData.setVisible(true);
                panelListActions.setVisible(true);
                if (checkboxEditList.isSelected()) {
                    showListEdit();
                    btnApply.setText("Edit");
                } else {
                    hideListEdit();
                    btnApply.setText("Apply");
                }
            }
        });
    }

    private void addListVersionsAction() {
        lstListVersions.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                /*if(edit) {
                    e.getSource(); // show on edit mode
                } else {
                    popup cannot show this version because not on edit mode
                    showing only the last version.
                }*/
            }
        });
    }

    private void addEditAction() {
        checkboxEditList.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    showListEdit();
                    btnApply.setText("Edit");
                } else {
                    hideListEdit();
                    btnApply.setText("Apply");
                }
            }
        });
    }

    private void showListEdit() {
        textAreadListData.setVisible(true);
        textAreadListData.setEnabled(true);
        tableListData.setVisible(false);
        tableListData.setEnabled(false);
    }

    private void hideListEdit() {
        textAreadListData.setVisible(false);
        textAreadListData.setEnabled(false);
        tableListData.setVisible(true);
        tableListData.setEnabled(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Contact) {
            this.cbNoteContact.removeAllItems();
            for (Contact c : controller.showContacts()) {
                cbNoteContact.addItem(c);
            }
        } else if (arg instanceof Note) {
            this.NoteListModel.removeAllElements();
            if (cbNoteContact.getSelectedItem() != null) {
                Contact c = (Contact) cbNoteContact.getSelectedItem();
                for (Note note : controller.notesByContact(c)) {
                    this.NoteListModel.addElement(note);
                }
                lstContactNotes.setModel(NoteListModel);
            }
        } else if (arg == null) {
            this.cbNoteContact.removeAllItems();
            for (Contact c : controller.showContacts()) {
                cbNoteContact.addItem(c);
            }
            //NOTES
            this.NoteListModel.removeAllElements();
            if (cbNoteContact.getSelectedItem() != null) {
                Contact c = (Contact) cbNoteContact.getSelectedItem();
                for (Note note : controller.notesByContact(c)) {
                    this.NoteListModel.addElement(note);
                }
                lstContactNotes.setModel(NoteListModel);
            }
        }
        refreshUI();
    }

    private void refreshUI() {
        lstContactNotes.revalidate();
        lstContactNotes.repaint();
        lstNoteVersions.revalidate();
        lstNoteVersions.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        panelNotes = new javax.swing.JPanel();
        panelNoteContact = new javax.swing.JPanel();
        lblNoteContact = new javax.swing.JLabel();
        cbNoteContact = new javax.swing.JComboBox<>();
        panelNoteInfo = new javax.swing.JPanel();
        panelContactNoteList = new javax.swing.JPanel();
        lblNoteContactNotes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstContactNotes = new javax.swing.JList<>();
        panelNoteVersionList = new javax.swing.JPanel();
        lblNoteVersion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstNoteVersions = new javax.swing.JList<>();
        panelNoteData = new javax.swing.JPanel();
        lblNote = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textAreaNote = new javax.swing.JTextArea();
        panelNoteActions = new javax.swing.JPanel();
        btnNoteCreate = new javax.swing.JButton();
        btnNoteEdit = new javax.swing.JButton();
        btnNoteDelete = new javax.swing.JButton();
        panelLists = new javax.swing.JPanel();
        panelListContact = new javax.swing.JPanel();
        lblListContact = new javax.swing.JLabel();
        cbListContact = new javax.swing.JComboBox<>();
        panelCreateList = new javax.swing.JPanel();
        btnCreateNewList = new javax.swing.JButton();
        panelListInfo = new javax.swing.JPanel();
        panelContactList = new javax.swing.JPanel();
        lblContactLists = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstContactLists = new javax.swing.JList<>();
        panelListVersion = new javax.swing.JPanel();
        lblListVersions = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstListVersions = new javax.swing.JList<>();
        panelListData = new javax.swing.JPanel();
        lblList = new javax.swing.JLabel();
        checkboxEditList = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableListData = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreadListData = new javax.swing.JTextArea();
        panelListActions = new javax.swing.JPanel();
        btnApply = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        lblNoteContact.setText("Contact:");

        javax.swing.GroupLayout panelNoteContactLayout = new javax.swing.GroupLayout(panelNoteContact);
        panelNoteContact.setLayout(panelNoteContactLayout);
        panelNoteContactLayout.setHorizontalGroup(
            panelNoteContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteContactLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNoteContact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbNoteContact, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelNoteContactLayout.setVerticalGroup(
            panelNoteContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblNoteContact)
                .addComponent(cbNoteContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblNoteContactNotes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoteContactNotes.setText("Contact Notes");

        lstContactNotes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstContactNotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstContactNotesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstContactNotes);

        javax.swing.GroupLayout panelContactNoteListLayout = new javax.swing.GroupLayout(panelContactNoteList);
        panelContactNoteList.setLayout(panelContactNoteListLayout);
        panelContactNoteListLayout.setHorizontalGroup(
            panelContactNoteListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addComponent(lblNoteContactNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelContactNoteListLayout.setVerticalGroup(
            panelContactNoteListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactNoteListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNoteContactNotes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
        );

        lblNoteVersion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNoteVersion.setText("Note Versions");

        lstNoteVersions.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstNoteVersions);

        javax.swing.GroupLayout panelNoteVersionListLayout = new javax.swing.GroupLayout(panelNoteVersionList);
        panelNoteVersionList.setLayout(panelNoteVersionListLayout);
        panelNoteVersionListLayout.setHorizontalGroup(
            panelNoteVersionListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNoteVersionListLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelNoteVersionListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNoteVersion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        panelNoteVersionListLayout.setVerticalGroup(
            panelNoteVersionListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteVersionListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNoteVersion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout panelNoteInfoLayout = new javax.swing.GroupLayout(panelNoteInfo);
        panelNoteInfo.setLayout(panelNoteInfoLayout);
        panelNoteInfoLayout.setHorizontalGroup(
            panelNoteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteInfoLayout.createSequentialGroup()
                .addComponent(panelContactNoteList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNoteVersionList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelNoteInfoLayout.setVerticalGroup(
            panelNoteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNoteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContactNoteList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNoteVersionList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        lblNote.setText("Note");

        textAreaNote.setColumns(20);
        textAreaNote.setRows(5);
        jScrollPane3.setViewportView(textAreaNote);

        javax.swing.GroupLayout panelNoteDataLayout = new javax.swing.GroupLayout(panelNoteData);
        panelNoteData.setLayout(panelNoteDataLayout);
        panelNoteDataLayout.setHorizontalGroup(
            panelNoteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        panelNoteDataLayout.setVerticalGroup(
            panelNoteDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteDataLayout.createSequentialGroup()
                .addComponent(lblNote)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
        );

        btnNoteCreate.setText("Create");
        btnNoteCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoteCreateActionPerformed(evt);
            }
        });

        btnNoteEdit.setText("Edit");
        btnNoteEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoteEditActionPerformed(evt);
            }
        });

        btnNoteDelete.setText("Delete");
        btnNoteDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoteDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNoteActionsLayout = new javax.swing.GroupLayout(panelNoteActions);
        panelNoteActions.setLayout(panelNoteActionsLayout);
        panelNoteActionsLayout.setHorizontalGroup(
            panelNoteActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteActionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNoteCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNoteEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNoteDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelNoteActionsLayout.setVerticalGroup(
            panelNoteActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNoteActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNoteActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNoteCreate)
                    .addComponent(btnNoteEdit)
                    .addComponent(btnNoteDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelNotesLayout = new javax.swing.GroupLayout(panelNotes);
        panelNotes.setLayout(panelNotesLayout);
        panelNotesLayout.setHorizontalGroup(
            panelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelNoteContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNotesLayout.createSequentialGroup()
                        .addGroup(panelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelNoteActions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelNoteData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelNoteInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelNotesLayout.setVerticalGroup(
            panelNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelNoteContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNoteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelNoteData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNoteActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPane.addTab("Notes", panelNotes);

        lblListContact.setText("Contact:");

        cbListContact.setModel(contactModel);

        javax.swing.GroupLayout panelListContactLayout = new javax.swing.GroupLayout(panelListContact);
        panelListContact.setLayout(panelListContactLayout);
        panelListContactLayout.setHorizontalGroup(
            panelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListContactLayout.createSequentialGroup()
                .addComponent(lblListContact)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbListContact, 0, 252, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelListContactLayout.setVerticalGroup(
            panelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblListContact)
                .addComponent(cbListContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnCreateNewList.setText("Create New List");
        btnCreateNewList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateNewListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCreateListLayout = new javax.swing.GroupLayout(panelCreateList);
        panelCreateList.setLayout(panelCreateListLayout);
        panelCreateListLayout.setHorizontalGroup(
            panelCreateListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCreateNewList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCreateListLayout.setVerticalGroup(
            panelCreateListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCreateNewList)
        );

        panelListInfo.setPreferredSize(new java.awt.Dimension(239, 200));

        panelContactList.setPreferredSize(new java.awt.Dimension(93, 139));
        panelContactList.setVisible(false);

        lblContactLists.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContactLists.setText("Contact Lists");

        lstContactLists.setModel(contactListModel);
        jScrollPane4.setViewportView(lstContactLists);

        javax.swing.GroupLayout panelContactListLayout = new javax.swing.GroupLayout(panelContactList);
        panelContactList.setLayout(panelContactListLayout);
        panelContactListLayout.setHorizontalGroup(
            panelContactListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblContactLists, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
        );
        panelContactListLayout.setVerticalGroup(
            panelContactListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactListLayout.createSequentialGroup()
                .addComponent(lblContactLists)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4))
        );

        panelListVersion.setPreferredSize(new java.awt.Dimension(120, 139));

        lblListVersions.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblListVersions.setText("List Versions");

        lstListVersions.setModel(listVersionModel);
        jScrollPane5.setViewportView(lstListVersions);

        javax.swing.GroupLayout panelListVersionLayout = new javax.swing.GroupLayout(panelListVersion);
        panelListVersion.setLayout(panelListVersionLayout);
        panelListVersionLayout.setHorizontalGroup(
            panelListVersionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblListVersions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelListVersionLayout.setVerticalGroup(
            panelListVersionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListVersionLayout.createSequentialGroup()
                .addComponent(lblListVersions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelListInfoLayout = new javax.swing.GroupLayout(panelListInfo);
        panelListInfo.setLayout(panelListInfoLayout);
        panelListInfoLayout.setHorizontalGroup(
            panelListInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListInfoLayout.createSequentialGroup()
                .addComponent(panelContactList, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelListVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelListInfoLayout.setVerticalGroup(
            panelListInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelListVersion, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
            .addComponent(panelContactList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
        );

        panelListData.setPreferredSize(new java.awt.Dimension(202, 188));

        lblList.setText("List");

        checkboxEditList.setText("Enable Edit");

        tableListData.setModel(listDataModel);
        jScrollPane6.setViewportView(tableListData);

        textAreadListData.setSize(panelListData.getWidth(), tableListData.getHeight());
        textAreadListData.setColumns(10);
        textAreadListData.setRows(5);
        jScrollPane7.setViewportView(textAreadListData);

        javax.swing.GroupLayout panelListDataLayout = new javax.swing.GroupLayout(panelListData);
        panelListData.setLayout(panelListDataLayout);
        panelListDataLayout.setHorizontalGroup(
            panelListDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListDataLayout.createSequentialGroup()
                .addComponent(lblList, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkboxEditList))
            .addGroup(panelListDataLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelListDataLayout.setVerticalGroup(
            panelListDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListDataLayout.createSequentialGroup()
                .addGroup(panelListDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblList)
                    .addComponent(checkboxEditList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelListDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)))
        );

        btnApply.setText("Apply");
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");

        javax.swing.GroupLayout panelListActionsLayout = new javax.swing.GroupLayout(panelListActions);
        panelListActions.setLayout(panelListActionsLayout);
        panelListActionsLayout.setHorizontalGroup(
            panelListActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListActionsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelListActionsLayout.setVerticalGroup(
            panelListActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListActionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListActionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApply)
                    .addComponent(btnDelete))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelListsLayout = new javax.swing.GroupLayout(panelLists);
        panelLists.setLayout(panelListsLayout);
        panelListsLayout.setHorizontalGroup(
            panelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelListActions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelListContact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListsLayout.createSequentialGroup()
                        .addGroup(panelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelCreateList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelListData, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                            .addComponent(panelListInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panelListsLayout.setVerticalGroup(
            panelListsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelListContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCreateList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelListInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelListData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(panelListActions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabPane.addTab("Lists", panelLists);

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

    private void lstContactNotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstContactNotesMouseClicked
        //VERSIONS
        this.VersionListModel.removeAllElements();
        if (lstContactNotes.getSelectedValue() != null) {
            Note n = (Note) this.NoteListModel.getElementAt(this.lstContactNotes.getSelectedIndex());
            for (Note note : n.versionByNote()) {
                this.VersionListModel.addElement(note);
            }
            lstNoteVersions.setModel(VersionListModel);
        }
        refreshUI();
    }//GEN-LAST:event_lstContactNotesMouseClicked

    private void btnNoteDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoteDeleteActionPerformed
        controller.deleteNote((Note) this.NoteListModel.getElementAt(this.lstContactNotes.getSelectedIndex()));
    }//GEN-LAST:event_btnNoteDeleteActionPerformed

    private void btnNoteEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoteEditActionPerformed
        controller.editNote(textAreaNote.getText(), (Note) this.NoteListModel.getElementAt(this.lstContactNotes.getSelectedIndex()));
    }//GEN-LAST:event_btnNoteEditActionPerformed

    private void btnNoteCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoteCreateActionPerformed
        Contact contact = (Contact) cbNoteContact.getSelectedItem();
        System.out.println(contact.name());
        controller.createNote(textAreaNote.getText(), contact);
    }//GEN-LAST:event_btnNoteCreateActionPerformed

    private void btnCreateNewListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateNewListActionPerformed
        panelListVersion.setVisible(false);
        showListEdit();
        panelListData.setVisible(true);
        panelListActions.setVisible(true);
        checkboxEditList.setSelected(true);
        btnApply.setText("Create");
    }//GEN-LAST:event_btnCreateNewListActionPerformed

    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        switch(evt.getActionCommand()) {
            case "Create": {
                controller.createList(cbListContact.getSelectedItem(),textAreadListData.getText());
                break;
            }
            case "Edit": {
                controller.editList(lstContactLists.getSelectedValue(),textAreadListData.getText());
                break;
            }
            case "Apply": {
                controller.applyList(lstContactLists.getSelectedValue(),listDataModel);
                break;
            }
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnCreateNewList;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNoteCreate;
    private javax.swing.JButton btnNoteDelete;
    private javax.swing.JButton btnNoteEdit;
    private javax.swing.JComboBox<Contact> cbListContact;
    private javax.swing.JComboBox<Contact> cbNoteContact;
    private javax.swing.JCheckBox checkboxEditList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblContactLists;
    private javax.swing.JLabel lblList;
    private javax.swing.JLabel lblListContact;
    private javax.swing.JLabel lblListVersions;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblNoteContact;
    private javax.swing.JLabel lblNoteContactNotes;
    private javax.swing.JLabel lblNoteVersion;
    private javax.swing.JList<List> lstContactLists;
    private javax.swing.JList<String> lstContactNotes;
    private javax.swing.JList<List> lstListVersions;
    private javax.swing.JList<String> lstNoteVersions;
    private javax.swing.JPanel panelContactList;
    private javax.swing.JPanel panelContactNoteList;
    private javax.swing.JPanel panelCreateList;
    private javax.swing.JPanel panelListActions;
    private javax.swing.JPanel panelListContact;
    private javax.swing.JPanel panelListData;
    private javax.swing.JPanel panelListInfo;
    private javax.swing.JPanel panelListVersion;
    private javax.swing.JPanel panelLists;
    private javax.swing.JPanel panelNoteActions;
    private javax.swing.JPanel panelNoteContact;
    private javax.swing.JPanel panelNoteData;
    private javax.swing.JPanel panelNoteInfo;
    private javax.swing.JPanel panelNoteVersionList;
    private javax.swing.JPanel panelNotes;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tableListData;
    private javax.swing.JTextArea textAreaNote;
    private javax.swing.JTextArea textAreadListData;
    // End of variables declaration//GEN-END:variables
}
