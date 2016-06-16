/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.inmemory;

import csheets.domain.Contact;
import csheets.domain.Task;
import csheets.framework.persistence.repositories.impl.immemory.InMemoryRepository;
import csheets.persistence.TaskRepository;
import java.util.List;

/**
 *
 * @author Bruno
 */
class InMemoryTaskRepository extends InMemoryRepository<Task, Long> implements TaskRepository {

	long nextID = 1;

	@Override
	protected Long newPK(Task entity) {
		return ++nextID;
	}

	public List<Task> task(Contact contact) {

		List<Task> task = null;
		for (Task t : this.all()) {
			if (t.getContact().equals(contact)) {
				task.add(t);
			}
		}
		return task;
	}

}
