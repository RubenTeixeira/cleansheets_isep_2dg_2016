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
	public Iterable<Note> search(Calendar startDate, Calendar endDate,
								 String title, String content) {
		Iterable<Note> tmp = searchDates(startDate, endDate);
		Boolean cont = true;
		if (content == null || content.isEmpty()) {
			cont = false;
		}
		tmp = this.search(tmp, title, cont);
		return tmp;
	}

	public Iterable<Note> search(Iterable<Note> lists, String expression,
								 Boolean content) {
		ArrayList<Note> results = new ArrayList();
		for (Note note : lists) {
			if (note.getTitle().matches(expression)) {
				results.add(note);
			} else if (content && note.getNoteText().matches(expression)) {
				results.add(note);
			}
		}
		return results;
	}

	public Iterable<Note> searchContent(Iterable<Note> notes, String content) {
		ArrayList<Note> results = new ArrayList();
		for (Note note : notes) {
			if (note.getNoteText().matches(content)) {
				results.add(note);
			}
		}
		return results;
	}

	public Iterable<Note> searchTitle(Iterable<Note> notes, String title) {
		ArrayList<Note> results = new ArrayList();
		for (Note note : notes) {
			if (note.getTitle().matches(title)) {
				results.add(note);
			}
		}
		return results;
	}

	public Iterable<Note> searchDates(Calendar startDate, Calendar endDate) {
		String term = "SELECT n FROM Note n";
		if (startDate != null && endDate != null) {
			term = "SELECT n FROM Note n where n.time BETWEEN :startDate AND :endDate";
		} else if (startDate != null) {
			term = "SELECT n FROM Note n where n.time > :startDate";
		} else if (endDate != null) {
			term = "SELECT n FROM Note n where n.time < :endDate";
		}
		final Query query = entityManager().createQuery(term, Note.class);
		if (startDate != null) {
			query.setParameter("startDate", startDate, TemporalType.DATE);
		}
		if (endDate != null) {
			query.setParameter("endDate", endDate, TemporalType.DATE);
		}
		return (Iterable<Note>) query.getResultList();
	}
}
