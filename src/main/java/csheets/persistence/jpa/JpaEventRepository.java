/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.EventRepository;

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
	public Iterable<Event> eventsContact(Contact contactObj) {
		/*
		List<Event> list = new ArrayList();
		for (Event event : this.all()) {
			if (event.contact() == contactObj) {
				list.add(event);
			}
		}
		return list;
		 */
		return null;
	}

}
