/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.reminder;

import csheets.domain.Event;
import csheets.domain.Reminder;
import csheets.ext.events.ui.EventsPanel;
import csheets.ext.reminder.ui.RemindersPanel;
import csheets.factory.EventsFactory;
import csheets.factory.ReminderFactory;
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
 *
 * @author Gabriel
 */
public class RemindersControllers {
    /**
	 * The user interface controller
	 */
	private UIController uiController;

	/**
	 * User interface panel *
	 */
	private RemindersPanel uiPanel;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiController the user interface controller
	 * @param uiPanel the user interface panel
	 */
    public RemindersControllers(UIController uiController, RemindersPanel uiPanel) {
		this.uiController = uiController;
		this.uiPanel = uiPanel;

//		TaskManager tm = new TaskManager();
//		Task verify;
//		verify = new Task() {
//			public void fire() {
//				for (Event event : allEvents()) {
//					if (event.alert() && event.date().before(DateTime.now())) {
//						Notification.eventInformer().notifyChange(event);
//					}
//				}
//			}
//		};
//		ThreadManager.create("crm.reminder", new Thread() {
//							 public void run() {
//								 tm.after(5).every(60).fire(verify);
//							 }
//						 });
//		ThreadManager.run("crm.reminder");
    }

    public Reminder createReminder(String nameReminder, String dscReminder, Calendar calendar) throws DataIntegrityViolationException {
                Reminder reminder = ReminderFactory.createReminder(nameReminder, dscReminder, calendar);
		PersistenceContext.repositories().reminders().add(reminder);
		
		return reminder;
    }

    public Reminder editReminder(Reminder reminder) {
                PersistenceContext.repositories().reminders().save(reminder);
		
		return reminder;
    }
    
}
