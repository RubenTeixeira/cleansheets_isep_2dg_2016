/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.ContactCalendar;
import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.EventRepository;
import csheets.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;

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
        for (ContactCalendar calendar : PersistenceContext.repositories().calendars().
                calendarsContact(contact)) {
            for (Event event : this.eventsCalendar(calendar)) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public Iterable<Event> eventsCalendar(ContactCalendar calendar) {
        List<Event> list = new ArrayList();
        for (Event event : this.all()) {
            if (event.calendar().equals(calendar)) {
                list.add(event);
            }
        }
        return list;
    }

    @Override
    public Iterable<Event> eventsContactPerDay(Contact contact, Calendar date) {
        final Query q = entityManager().createQuery("SELECT e "
                + "FROM Event e "
                + "JOIN e.calendar cc "
                + "JOIN cc.contact c "
                + "where c.name=:name and :date between e.startDate and e.endDate", Event.class);
        q.setParameter("name", contact.name());
        q.setParameter("date", date);
        return (List<Event>) q.getResultList();
    }

}
