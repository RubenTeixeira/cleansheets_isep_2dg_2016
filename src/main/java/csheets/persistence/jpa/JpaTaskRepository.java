/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.Contact;
import csheets.domain.Task;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.TaskRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruno
 */
public class JpaTaskRepository extends JpaRepository<Task, Long> implements TaskRepository {

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}

	@Override
	public List<Task> task(Contact contact) {
		/*
		 final Query query = entityManager().
		 createQuery("task = :contact", Task.class);
		 query.setParameter("contact", contact.id());
		 List<Task> tmp = query.getResultList();
		 return tmp;
		 */
		List<Task> list = new ArrayList();
		for (Task task : this.all()) {
			if (task.getContact().equals(contact)) {
				list.add(task);
			}
		}
		return list;
	}

	@Override
	public void delete(Task entity) {
		for (Task task : this.all()) {
			if (task.TaskName().equalsIgnoreCase(entity.TaskName())) {
				super.delete(entity);
			}
		}
	}
}
