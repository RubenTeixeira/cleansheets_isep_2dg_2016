/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.factory;

import csheets.domain.Calendar;
import csheets.domain.Contact;
import java.awt.Color;

/**
 *
 * @author Eduardo
 */
public class CalendarFactory {

	public CalendarFactory() {

	}

	public static final Calendar createCalendar(String name, String description,
												Color color, Contact contact) {
		return new Calendar(name, description, color, contact);
	}
}
