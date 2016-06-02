package csheets.ext.events;

import csheets.core.Cell;
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
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
					if (event.alert() && DateTime.
						isPreviousDate(event.date(), DateTime.now())) {
						Notification.eventInformer().notifyChange(event);
					}
				}
			}
		};

		ThreadManager.create("crm.events", new Thread() {
							 public void run() {
								 tm.every(60).fire(verify);
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
		Notification.eventInformer().notifyChange(event);
		return event;
	}

	public Event editEvent(Event event) {
		PersistenceContext.repositories().events().save(event);
		Notification.eventInformer().notifyChange();
		Notification.eventInformer().notifyChange(event);
		return event;
	}

	public void removeEvent(Event event) {
		PersistenceContext.repositories().events().delete(event);
		Notification.eventInformer().notifyChange();
		Notification.eventInformer().notifyChange(event);
	}

	public Iterable<Contact> allContacts() {
		return (List<Contact>) PersistenceContext.repositories().contacts().
			all();
	}

	public Iterable<Event> allEvents() {
		return PersistenceContext.repositories().events().
			all();
	}

	public void mmb() {
		SpreadsheetTable table = new SpreadsheetTable(uiController.
			getActiveSpreadsheet(), uiController);
		Cell[][] cells = table.getSelectedCells();
		System.out.println("INICIO!!! ");
		if (cells != null) {
			System.out.println("Cells " + cells);
			if (cells.length > 0 && cells[0].length > 0) {
				System.out.println(cells.length + " " + cells[0].length);
				for (int i = 0; i < cells.length; i++) {
					for (int j = 0; j < cells[0].length; j++) {
						System.out.println("" + i + j + " " + cells[i][j].
							getContent());
					}
				}
			}
		}
		System.out.println("MEIO!!! ");
		Algo al = new Algo();
		for (String o : al.getSelectedCells()) {
			System.out.println("ABC -> " + o);
		}
		System.out.println("FIM!!! ");
	}

	class Algo extends FocusOwnerAction {

		UIController controller;

		@Override
		protected String getName() {
			return "Algo";
		}

		@Override
		public void actionPerformed(ActionEvent e) {

		}

		public List<String> getSelectedCells() {
			this.controller.getActiveCell();
			Cell[][] selected = this.focusOwner.getSelectedCells();
			ArrayList<String> listSelected = new ArrayList<String>();

			//creates arrayList with the contents from the first column of selected cells (easy to refactor for the next use case)
			for (int i = 0; i < selected.length; i++) {
				listSelected.add(selected[i][0].getContent());
			}
			return listSelected;
		}

	}
}
