/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.factory;

import csheets.domain.Contact;
import csheets.domain.Task;
import java.util.Calendar;

/**
 *
 * @author Bruno
 */
public class TaskFactory {

	public TaskFactory() {

	}

	public static final Task createTask(String taskName, String description,
										int priority,
										float percentageofcompletion,
										Contact contact, Calendar date) {
		return new Task(taskName, description, priority, percentageofcompletion, contact,date);
	}
}
