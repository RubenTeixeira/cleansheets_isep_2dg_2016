/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contacts.ui;

import csheets.domain.Contact;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.persistence.PersistenceContext;
import javax.swing.ImageIcon;

/**
 *
 * @author Rui Freitas <1130303>
 */
public class ContactsController {
    
    
    public Iterable<Contact> allContacts()
    {
        return PersistenceContext.repositories().contacts().all();
    }
    
    public ImageIcon contactPhoto(Contact ct)
    {
        return new ImageIcon(ct.photo());
    }
    
    public void addContact(Contact ct) throws DataIntegrityViolationException
    {
        PersistenceContext.repositories().contacts().add(ct);
    }
    
}
