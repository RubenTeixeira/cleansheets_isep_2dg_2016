/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.calendar;

import csheets.domain.Calendar;
import csheets.domain.Contact;
import csheets.ext.calendar.ui.CalendarPanel;
import csheets.factory.CalendarFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.awt.Color;

/**
 *
 * @author Eduardo
 */
public class CalendarController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private CalendarPanel uiPanel;

	public CalendarController(UIController controller,
							  CalendarPanel calendar) {
		this.uiController = controller;
		this.uiPanel = calendar;
	}

	public Iterable<Contact> getAllContacts() {
		return PersistenceContext.repositories().contacts().all();
	}

	public Calendar createCalendar(String nome, String descripition,
								   Color color, Contact cont) throws DataIntegrityViolationException {
		Calendar cal = CalendarFactory.
			createCalendar(nome, descripition, color, cont);
		PersistenceContext.repositories().calendars().add(cal);
		Notification.calendarInformer().notifyChange();
		return cal;
	}

	public Iterable<Calendar> getAllCalendars() {
		return PersistenceContext.repositories().calendars().all();
	}
}
