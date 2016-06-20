/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.Contact;
import csheets.domain.Note;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.NoteRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;

/**
 *
 * @author Diogo Azevedo
 */
public class JpaNoteRepository extends JpaRepository<Note, Long> implements NoteRepository {

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}

	@Override
	public List<Note> notesByContact(Contact contact) {
		final Query query = entityManager().
			createQuery("select m from Note m where m.contact.id = :contact", Note.class);
		query.setParameter("contact", contact.id());
		List<Note> tmp = query.getResultList();
		return tmp;
	}

	@Override
	public List<Note> principalNotes(Contact contact) {
		final Query query = entityManager().
			createQuery("select m from Note m where m.contact.id = :contact and m.versionState = 1", Note.class);
		query.setParameter("contact", contact.id());
		List<Note> tmp = query.getResultList();
		return tmp;
	}

	@Override
	public List<Note> search(Calendar startDate, Calendar endDate,
							 String expression) {
		final Query query = entityManager().
			createQuery("SELECT n FROM Note n where n.time BETWEEN :startDate AND :endDate",
						Note.class);
		query.setParameter("startDate", startDate, TemporalType.DATE);
		query.setParameter("endDate", endDate, TemporalType.DATE);
		List<Note> tmp = query.getResultList();
		if (expression == null || expression.isEmpty()) {
			return tmp;
		}
		ArrayList<Note> results = new ArrayList();
		for (Note note : tmp) {
			for (Note version : note.versionByNote()) {
				if (version.toString().matches(expression)) {
					results.add(version);
				}
			}
		}
		return results;
	}

}
