package csheets.ext.contacts.ui;

import csheets.CleanSheets;
import csheets.domain.Contact;
import csheets.domain.PersonContact;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.support.Converter;
import csheets.ui.ctrl.UIController;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author Rui Freitas
 */
public class ContactsController {

	private static final String DEFAULT_USER_PHOTO_FILE = "res/img/default-user.png";

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private JPanel uiPanel;

	public ContactsController() {
	}

	public ContactsController(UIController uiController, JPanel uiPanel) {
		this.uiController = uiController;
		this.uiPanel = uiPanel;
	}

	public Iterable<Contact> allContacts() {
		return PersistenceContext.repositories().contacts().all();
	}

	public Image contactPhoto(Contact contact) throws IOException {
		return Converter.getImage(contact.photo());
	}

	public boolean newContact(String firstName, String lastName, File photoPath) throws DataIntegrityViolationException, IOException {
		byte[] thePhoto;

		if (photoPath == null) {
			thePhoto = Converter.setImage(new File(CleanSheets.class.
				getResource(DEFAULT_USER_PHOTO_FILE).getFile()));
		} else {
			try {
				thePhoto = Converter.setImage(photoPath);
			} catch (IOException ex) {
				throw new IOException("Loading file error!");
			}
		}

		PersonContact ct = new PersonContact(firstName, lastName, "scrum", null, thePhoto);

		boolean flag = PersistenceContext.repositories().contacts().add(ct);
		Notification.contactInformer().notifyChange();
		return flag;
	}

	public void removeContact(Contact theContact) {
		PersistenceContext.repositories().contacts().delete(theContact);
		Notification.contactInformer().notifyChange();
	}

	public Contact editContact(Contact theContact) throws DataIntegrityViolationException {
		PersistenceContext.repositories().contacts().save(theContact);
		Notification.contactInformer().notifyChange();
		return theContact;
	}

	public void addSystemUser() {
		try {
			String userName = System.getProperty("user.name");
			Contact contact = PersistenceContext.repositories().contacts().
				getByName(userName);
			if (contact == null) {
				this.newContact(userName, "user", null);
			}
		} catch (Exception ex) {
		}

	}

}
