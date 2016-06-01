package csheets.ext.events;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.ext.events.ui.EventsPanel;
import csheets.factory.EventsFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.persistence.PersistenceContext;
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
	}

	public Event createEvent(Contact contact, String description, Calendar date) throws DataIntegrityViolationException {
		Event e = EventsFactory.createEvent(contact, description, date);
		PersistenceContext.repositories().events().add(e);
		return e;
	}

	public Event editEvent(Event event) {
		return PersistenceContext.repositories().events().save(event);
	}

	public void removeEvent(Event event) {
		PersistenceContext.repositories().events().delete(event);
	}
}
