/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.factory;

import csheets.domain.Calendar;
import csheets.domain.Contact;

/**
 *
 * @author Eduardo
 */
public class CalendarFactory {

	public CalendarFactory() {

	}

	public static final Calendar createCalendar(String name, String txt,
												String color, Contact conta) {
		return new Calendar(name, txt, color, conta);
	}
}
