package csheets.ext.events;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.ext.events.ui.EventsPanel;
import csheets.factory.EventsFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.support.DateTime;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.Calendar;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author João Martins
 */
public class EventsController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private EventsPanel uiPanel;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 * @param uiPanel the user interface panel
	 */
	public EventsController(UIController uiController, EventsPanel uiPanel) {
		this.uiController = uiController;
		this.uiPanel = uiPanel;

		TaskManager tm = new TaskManager();
		Task verify;
		verify = new Task() {
			public void fire() {
				for (Event event : allEvents()) {
					if (event.alert() && event.date().before(DateTime.now())) {
						Notification.eventInformer().notifyChange(event);
					}
				}
			}
		};
		ThreadManager.create("crm.events", new Thread() {
							 public void run() {
								 tm.after(5).every(60).fire(verify);
							 }
						 });
		ThreadManager.run("crm.events");
	}

	public Event createEvent(Contact contact, String description, Calendar date,
							 boolean alert) throws DataIntegrityViolationException {
		Event event = EventsFactory.
			createEvent(contact, description, date, alert);
		PersistenceContext.repositories().events().add(event);
		Notification.eventInformer().notifyChange();
		return event;
	}

	public Event editEvent(Event event) {
		PersistenceContext.repositories().events().save(event);
		Notification.eventInformer().notifyChange();
		return event;
	}

	public void removeEvent(Event event) {
		PersistenceContext.repositories().events().delete(event);
		Notification.eventInformer().notifyChange();
	}

	public Iterable<Contact> allContacts() {
		return PersistenceContext.repositories().contacts().
			all();
	}

	public Iterable<Event> allEvents() {
		return PersistenceContext.repositories().events().all();
	}

	public void snoozeEvent(Event event) {
		event.add(Calendar.MINUTE, 5);
		PersistenceContext.repositories().events().save(event);
		Notification.eventInformer().notifyChange();
	}

	public void alert(Event event, boolean active) {
		event.
			defineEvent(event.contact(), event.description(), event.date(), active);
//		editEvent(event);
		PersistenceContext.repositories().events().save(event);
		Notification.eventInformer().notifyChange();
	}
}
