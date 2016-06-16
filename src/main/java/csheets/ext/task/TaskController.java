/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.task;

import csheets.domain.Contact;
import csheets.domain.Task;
import csheets.factory.TaskFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class TaskController {

	/**
	 * The user interface controller
	 */
	private final UIController uiController;

	/**
	 * Creates a new comment controller.
	 *
	 * @param uiCtrl the user interface controller
	 */
	public TaskController(UIController uiCtrl) {
		this.uiController = uiCtrl;

	}

	public Iterable<Contact> showContacts() {
		return PersistenceContext.repositories().contacts().all();
	}

	public Task createTask(String taskName, String description, int priority,
						   float percentageofcompletion, Contact contact) throws DataIntegrityViolationException {
		Task task = TaskFactory.
			createTask(taskName, description, priority, percentageofcompletion, contact);
		PersistenceContext.repositories().task().add(task);
		Notification.taskInformer().notifyChange(task);
		return task;
	}

	public Task editTask(Task task) {
		PersistenceContext.repositories().task().save(task);
		Notification.taskInformer().notifyChange(task);
		return task;
	}

	public void removeTask(Task task) {
		PersistenceContext.repositories().task().delete(task);
		Notification.taskInformer().notifyChange();
	}

	public List<Task> allTasksContact(Contact contact) {
		return PersistenceContext.repositories().task().task(contact);
	}
}
