/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.notes;

import csheets.domain.Contact;
import csheets.domain.Note;
import csheets.ext.notes.ui.NotesPanel;
import csheets.factory.NoteFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogo Azevedo
 */
public class NotesController {
    /**
	 * The user interface controller
	 */
	private final UIController uiController;

        
	/**
	 * Creates a new comment controller.
	 *
	 * @param uiCtrl the user interface controller
	 */
    public NotesController(UIController uiCtrl ){
        this.uiController = uiCtrl;

    }
    
    public Iterable<Contact> showContacts(){
      return PersistenceContext.repositories().contacts().all();
    }
    
    public Note createNote(String noteText,Contact contact){
        Note note = NoteFactory.createNote(noteText,contact, true);
            try {
               PersistenceContext.repositories().notes().add(note);
               Notification.noteInformer().notifyChange();
               
                
            } catch (DataIntegrityViolationException ex) {
                Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
            }
             return note;
    }
   
    public Note editNote(String noteText,Note note){
        note.editNote(noteText);
        PersistenceContext.repositories().notes().save(note);
        Notification.noteInformer().notifyChange();
        
        return note;
    }
    
    public void deleteNote(Note note){
        PersistenceContext.repositories().notes().delete(note);
        Notification.noteInformer().notifyChange();
    }
    public List<Note> notesByContact(Contact contact){
        return PersistenceContext.repositories().notes().principalNotes(contact);
    }
    public List<Note> versionByNote(Note note){
        return note.versionByNote();
    }
}
