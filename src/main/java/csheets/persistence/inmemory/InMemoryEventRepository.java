/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.inmemory;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.framework.persistence.repositories.impl.immemory.InMemoryRepository;
import csheets.persistence.EventRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martins
 */
class InMemoryEventRepository extends InMemoryRepository<Event, Long>
	implements EventRepository {

	long nextID = 1;

	@Override
	protected Long newPK(Event entity) {
		return ++nextID;
	}

	@Override
	public Iterable<Event> eventsContact(Contact contactObj) {
		List<Event> list = new ArrayList();
		for (Event event : this.all()) {
			if (event.contact() == contactObj) {
				list.add(event);
			}
		}
		return list;
	}
}
