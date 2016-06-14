/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.agenda.ui;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Controller of the wizard process to simplify the WizardFrame code and use
 * good practices of code structuring
 *
 * @author AB-1140280
 */
public class AgendaController {

	UIController uicontroller;

	public AgendaController(UIController uicontroller) {
		this.uicontroller = uicontroller;
	}

	/**
	 * Returns a list model with the contacts on teh database
	 *
	 * @return ContactListModel
	 */
	public ContactListModel getContacts() {
		ArrayList<Contact> list = new ArrayList();
		for (Contact contact : PersistenceContext.repositories().contacts().
			all()) {
			list.add(contact);
		}
		return new ContactListModel(list);
	}

	/**
	 * Returns a list of events for a given date and contact
	 *
	 * @param date date
	 * @param contact contact
	 * @return list of events
	 */
	public List<Event> updateEvents(Calendar date, Contact contact) {
		ArrayList<Event> list = new ArrayList<Event>();
		for (Event event : PersistenceContext.repositories().events().
			eventsContactPerDay(contact, date)) {
			list.add(event);
		}
		return list;
	}

	public Calendar nextDay(Calendar calendar) {
		calendar.add(Calendar.DATE, 1);
		return calendar;
	}

	public Calendar previousDay(Calendar calendar) {
		calendar.add(Calendar.DATE, -1);
		return calendar;
	}

}
