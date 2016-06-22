/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.ext.task;

import csheets.domain.Contact;
import csheets.domain.Event;
import csheets.domain.Reminder;
import csheets.domain.Task;
import csheets.factory.TaskFactory;
import csheets.framework.persistence.repositories.DataIntegrityViolationException;
import csheets.notification.Notification;
import csheets.persistence.PersistenceContext;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.Calendar;
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
    public Iterable<Reminder> allReminders;

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
            float percentageofcompletion, Contact contact, Calendar date) throws DataIntegrityViolationException {
        Task task = TaskFactory.
                createTask(taskName, description, priority, percentageofcompletion, contact, date
                );
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

    public List<Task> allTasks() {
        return (List<Task>) PersistenceContext.repositories().task().all();
    }

    public List<Task> allTasks(String left, String right) {
        if (left == null || left.isEmpty()) {
            left = "0";
        }
        if (right == null || right.isEmpty()) {
            right = "100";
        }
        Double numLeft = Double.parseDouble(left);
        Double numRight = Double.parseDouble(right);
        if (numLeft == null || numRight == null || numRight < numLeft) {
            return this.allTasks();
        }
        List<Task> percent = new ArrayList();
        for (Task task : PersistenceContext.repositories().task().all()) {
            if (numLeft <= task.Percentage() && task.Percentage() <= numRight) {
                percent.add(task);
            }
        }
        return percent;
    }

    public Iterable<Contact> allContacts() {
        return PersistenceContext.repositories().contacts().
                all();
    }

    public Iterable<Event> allEvents() {
       return PersistenceContext.repositories().events().all();
    }

    public Iterable<Reminder> allReminders() {
        return PersistenceContext.repositories().reminders().all();
    }
}
