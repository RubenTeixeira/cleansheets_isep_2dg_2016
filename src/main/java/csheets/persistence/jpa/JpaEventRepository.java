/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.Calendar;
import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.EventRepository;
import csheets.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Martins
 */
public class JpaEventRepository extends JpaRepository<Event, Long> implements EventRepository {

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}

	@Override
	public Iterable<Event> eventsContact(Contact contact) {
		List<Event> list = new ArrayList();
		for (Calendar calendar : PersistenceContext.repositories().calendars().
			calendarsContact(contact)) {
			for (Event event : this.eventsCalendar(calendar)) {
				list.add(event);
			}
		}
		return list;
	}

	@Override
	public Iterable<Event> eventsCalendar(Calendar calendar) {
		List<Event> list = new ArrayList();
		for (Event event : this.all()) {
			if (event.calendar() == calendar) {
				list.add(event);
			}
		}
		return list;
	}

}
