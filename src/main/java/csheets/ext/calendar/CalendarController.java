/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.calendar;

import csheets.domain.Calendar;
import csheets.domain.Contact;
import csheets.ext.calendar.ui.CalendarMainPanel;
import csheets.factory.CalendarFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;

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
	private CalendarMainPanel uiPanel;

	public CalendarController(UIController controller,
							  CalendarMainPanel calendar) {
		this.uiController = controller;
		this.uiPanel = calendar;
	}

	public Iterable<Contact> getAllContacts() {
		return PersistenceContext.repositories().contacts().all();
	}

	public Calendar createCalendar(String nome, String descripition,
								   String color, Contact cont) throws DataIntegrityViolationException {
		Calendar cal = CalendarFactory.
			createCalendar(nome, descripition, color, cont);
		PersistenceContext.repositories().calendars().add(cal);
		return cal;
	}
}
