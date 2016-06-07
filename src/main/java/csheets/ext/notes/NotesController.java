/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.notes;

import csheets.domain.Contact;
import csheets.domain.Note;
import csheets.ext.notes.ui.NotesPanel;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;

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
	 * User interface panel *
	 */
	private final NotesPanel uiPanel;
        
	/**
	 * Creates a new comment controller.
	 *
	 * @param uiCtrl the user interface controller
	 * @param panel the user interface panel
	 */
    public NotesController(UIController uiCtrl,NotesPanel panel ){
        this.uiController = uiCtrl;
	this.uiPanel = panel;
        
    }
    
    public Iterable<Contact> showContacts(){
      return PersistenceContext.repositories().contacts().all();  
    }
    
    public void createNote(String noteText){
        Note n= new Note(noteText);
        n.add();
    }
}
