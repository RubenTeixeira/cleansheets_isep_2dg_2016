package csheets.ext.reminder;

import csheets.domain.Reminder;
import csheets.ext.reminder.ui.ReminderPanel;
import csheets.factory.ReminderFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.support.DateTime;
import csheets.support.Task;
import csheets.support.TaskManager;
import csheets.support.ThreadManager;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * A controller for updating the user-specified comment of a cell.
 *
 * @author João Martins
 */
public class ReminderController {

	/**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private ReminderPanel uiPanel;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 * @param uiPanel the user interface panel
	 */
	public ReminderController(UIController uiController, ReminderPanel uiPanel) {
		this.uiController = uiController;
		this.uiPanel = uiPanel;

		TaskManager tm = new TaskManager();
		Task verify;
		verify = new Task() {
			public void fire() {
				for (Reminder reminder : allReminders()) {
					if (reminder.alert() && reminder.timeOfReminder().
						before(DateTime.now())) {
						Notification.reminderInformer().notifyChange(reminder);
					}
				}
			}
		};
		ThreadManager.create("crm.reminders", new Thread() {
							 public void run() {
								 tm.after(5).every(60).fire(verify);
							 }
						 });
		ThreadManager.run("crm.reminders");
	}

	public Reminder createReminder(String name, String description,
								   Calendar date,
								   boolean alert) throws DataIntegrityViolationException {
		Reminder reminder = ReminderFactory.
			createReminder(name, description, date, alert);
		PersistenceContext.repositories().reminders().add(reminder);
		Notification.reminderInformer().notifyChange();
		return reminder;
	}

	public Reminder editReminder(Reminder reminder) {
		PersistenceContext.repositories().reminders().save(reminder);
		Notification.reminderInformer().notifyChange();
		return reminder;
	}

	public void removeReminder(Reminder reminder) {
		PersistenceContext.repositories().reminders().delete(reminder);
		Notification.reminderInformer().notifyChange();
	}

	public Iterable<Reminder> allReminders() {
		//return PersistenceContext.repositories().reminders().all();
		return new ArrayList();
	}

	public void snoozeReminder(Reminder reminder) {
		reminder.add(Calendar.MINUTE, 5);
		PersistenceContext.repositories().reminders().save(reminder);
		Notification.reminderInformer().notifyChange();
	}

	public void alert(Reminder reminder, boolean active) {
		reminder.
			defineReminder(reminder.name(), reminder.description(), reminder.
						   timeOfReminder(), active);
		PersistenceContext.repositories().reminders().save(reminder);
		Notification.reminderInformer().notifyChange();
	}
}
