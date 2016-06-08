/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.inmemory;

import csheets.domain.Calendar;
import csheets.domain.Contact;
import csheets.framework.persistence.repositories.impl.immemory.InMemoryRepository;
import csheets.persistence.CalendarRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martins
 */
class InMemoryCalendarRepository extends InMemoryRepository<Calendar, Long>
	implements CalendarRepository {

	long nextID = 1;

	@Override
	protected Long newPK(Calendar entity) {
		return ++nextID;
	}

	@Override
	public Iterable<Calendar> calendarsContact(Contact contact) {
		List<Calendar> list = new ArrayList();
		for (Calendar calendar : this.all()) {
			if (calendar.getContact() == contact) {
				list.add(calendar);
			}
		}
		return list;
	}
}
