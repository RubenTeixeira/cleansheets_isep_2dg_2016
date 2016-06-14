/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.notes_and_lists;

import csheets.domain.Contact;
import csheets.domain.List;
import csheets.domain.Note;
import csheets.factory.NoteFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Diogo Azevedo
 * @author Rui Bento
 */
public class NotesListsController {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * Creates a new comment controller.
     *
     * @param uiCtrl the user interface controller
     */
    public NotesListsController(UIController uiCtrl) {
        this.uiController = uiCtrl;

    }

    public Iterable<Contact> showContacts() {
        return PersistenceContext.repositories().contacts().all();
    }

    public Note createNote(String noteText, Contact contact) {
        Note note = NoteFactory.createNote(noteText, contact, true);
        try {
            PersistenceContext.repositories().notes().add(note);
            Notification.noteInformer().notifyChange();

        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(NotesListsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return note;
    }

    public Note editNote(String noteText, Note note) {
        note.editNote(noteText);
        PersistenceContext.repositories().notes().save(note);
        Notification.noteInformer().notifyChange();

        return note;
    }

    public void deleteNote(Note note) {
        PersistenceContext.repositories().notes().delete(note);
        Notification.noteInformer().notifyChange();
    }

    public Iterable<Note> notesByContact(Contact contact) {
        return PersistenceContext.repositories().notes().principalNotes(contact);
    }

    public Iterable<Note> versionByNote(Note note) {
        return note.versionByNote();
    }

    public void updateContacts(DefaultComboBoxModel<Contact> contactModel) {
        Iterable<Contact> allContacts = PersistenceContext.repositories().contacts().all();
        for (Contact contact : allContacts) {
            contactModel.addElement(contact);
        }
    }

    public void updateContactListsModel(DefaultListModel<List> contactListModel, Object contactItem) {
        if(contactItem instanceof Contact && contactItem != null) {
            Contact contact = (Contact)contactItem;
            Iterable<List> contactLists = PersistenceContext.repositories().lists().listsByContact(contact);
            for (List list : contactLists) {
                contactListModel.addElement(list);
            }
        }
    }
}
