/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.factory;

import csheets.domain.Contact;
import csheets.domain.Event;
import java.util.Calendar;

/**
 *
 * @author Martins
 */
final public class EventsFactory {

	private EventsFactory() {
	}

	static public Event createEvent(Contact contact, String description,
									Calendar date) {
		return new Event(contact, description, date);
	}

	static public Event createEvent(Contact contact, String description,
									Calendar date, boolean alert) {
		return new Event(contact, description, date, alert);
	}
}
