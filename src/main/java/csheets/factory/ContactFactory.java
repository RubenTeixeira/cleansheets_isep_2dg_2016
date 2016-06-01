package csheets.factory;

import csheets.domain.Contact;

/**
 *
 * @author Rui Freitas <1130303>
 */
public class ContactFactory {
    
    private ContactFactory(){}
    
    public static final Contact createContact(String firstName, String lastName, byte[] photo)
    {
        return new Contact(firstName, lastName, photo);
    }
}
