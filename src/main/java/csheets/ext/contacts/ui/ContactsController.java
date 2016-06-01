/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.contacts.ui;

import csheets.CleanSheets;
import csheets.domain.Contact;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.persistence.PersistenceContext;
import csheets.support.Converter;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;

/**
 *
 * @author Rui Freitas <1130303>
 */
public class ContactsController {

    private static final String DEFAULT_USER_PHOTO_FILE = "res/img/default-user.png";

    public Iterable<Contact> allContacts() {
        return PersistenceContext.repositories().contacts().all();
    }

    public Image contactPhoto(Contact ct) throws IOException {
        return new Converter().getImage(ct.photo());
    }

    public boolean newContact(String firstName, String lastName, File photoPath) throws DataIntegrityViolationException, IOException {
        byte[] thePhoto;

        if (photoPath == null) {
            thePhoto = new Converter().setImage(new File(CleanSheets.class.getResource(DEFAULT_USER_PHOTO_FILE).getFile()));
        } else {
            try {
                thePhoto = new Converter().setImage(photoPath);
            } catch (IOException ex) {
                throw new IOException("Loading file error!");
            }
        }

        Contact ct = new Contact(firstName, lastName, thePhoto);
        return PersistenceContext.repositories().contacts().add(ct);
    }

}
