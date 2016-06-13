/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.agenda.ui;

import csheets.domain.Contact;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author ab
 */
public class AgendaControllerTest {

    AgendaController controller;

    public AgendaControllerTest() {
        UIController uiController = UIController.getUIController();
        controller = new AgendaController(uiController);

    }

    /**
     * Test of getContacts method, of class AgendaController.
     */
    @Test
    public void testGetContacts() {
        ArrayList<Contact> list = new ArrayList();
        for (Contact contact : PersistenceContext.repositories().contacts().
                all()) {
            list.add(contact);
        }
        ContactListModel expectedResult = new ContactListModel(list);
        ContactListModel result = controller.getContacts();
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void testFailGetContacts() {
        ArrayList<Contact> list = new ArrayList();
        ContactListModel expectedResult = new ContactListModel(list);
        ContactListModel result = controller.getContacts();
        assertNotEquals(expectedResult, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullGetContacts() {
        ContactListModel expectedResult = new ContactListModel(null);
        ContactListModel result = controller.getContacts();
        assertTrue(false);
    }

    /**
     * Test of updateEvents method, of class AgendaController.
     */
    @Test
    public void testUpdateEvents() {
        ContactListModel list = controller.getContacts();
        if (list.isEmpty()) {
            assertTrue(true);
        }
        Contact cont = list.getContactAt(0);
        Iterable result = controller.updateEvents(Calendar.getInstance(), cont);
        Iterable expected = PersistenceContext.repositories().events().eventsContactPerDay(cont, Calendar.getInstance());
        assertEquals(expected, result);
    }
}
