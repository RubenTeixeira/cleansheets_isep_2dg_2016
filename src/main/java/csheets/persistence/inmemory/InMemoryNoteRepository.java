/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.inmemory;

import csheets.domain.Contact;
import csheets.domain.Note;
import csheets.framework.persistence.repositories.impl.immemory.InMemoryRepository;
import csheets.persistence.NoteRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Martins
 */
class InMemoryNoteRepository extends InMemoryRepository<Note, Long>
	implements NoteRepository {

	long nextID = 1;

	@Override
	protected Long newPK(Note entity) {
		return ++nextID;
	}

	@Override
	public List<Note> notesByContact(Contact contact) {

		List<Note> notes = null;
		for (Note n : this.all()) {
			if (n.getContact().equals(contact)) {
				notes.add(n);
			}
		}
		return notes;
	}

	@Override
	public List<Note> principalNotes(Contact contact) {
		List<Note> notes = new ArrayList();
		for (Note note : this.all()) {
			if (note.noteState() == true && note.getContact().equals(contact)) {
				notes.add(note);
			}
		}
		return notes;
	}

	@Override
	public Iterable<Note> search(Calendar startdate, Calendar endDate,
								 String title, String content) {
		ArrayList<Note> tmp = new ArrayList();
		if (title != null) {
			tmp.addAll((Collection) this.searchTitle(startdate, endDate, title));
		}
		if (content != null) {
			tmp.addAll((Collection) this.
				searchContent(startdate, endDate, content));
		}
		return tmp;
	}

	public Iterable<Note> searchContent(Calendar startDate, Calendar endDate,
										String expression) {
		ArrayList<Note> tmp = new ArrayList();
		for (Note note : this.all()) {
			tmp.add(note);
		}
		if (startDate != null && endDate != null) {
			for (Note note : this.all()) {
				tmp = new ArrayList();
				if (note.date().after(startDate) && note.date().before(endDate)) {
					tmp.add(note);
				}
			}
		} else if (startDate != null) {
			tmp = new ArrayList();
			for (Note note : this.all()) {
				if (note.date().after(startDate)) {
					tmp.add(note);
				}
			}
		} else if (endDate != null) {
			tmp = new ArrayList();
			for (Note note : this.all()) {
				if (note.date().before(endDate)) {
					tmp.add(note);
				}
			}
		}
		if (expression == null || expression.isEmpty()) {
			return tmp;
		}
		ArrayList<Note> results = new ArrayList();
		for (Note note : tmp) {
			if (note.getNoteText().matches(expression)) {
				results.add(note);
			}
		}
		return results;
	}

	public Iterable<Note> searchTitle(Calendar startDate, Calendar endDate,
									  String expression) {
		ArrayList<Note> tmp = new ArrayList();
		for (Note note : this.all()) {
			tmp.add(note);
		}
		if (startDate != null && endDate != null) {
			for (Note note : this.all()) {
				tmp = new ArrayList();
				if (note.date().after(startDate) && note.date().before(endDate)) {
					tmp.add(note);
				}
			}
		} else if (startDate != null) {
			tmp = new ArrayList();
			for (Note note : this.all()) {
				if (note.date().after(startDate)) {
					tmp.add(note);
				}
			}
		} else if (endDate != null) {
			tmp = new ArrayList();
			for (Note note : this.all()) {
				if (note.date().before(endDate)) {
					tmp.add(note);
				}
			}
		}
		if (expression == null || expression.isEmpty()) {
			return tmp;
		}
		ArrayList<Note> results = new ArrayList();
		for (Note note : tmp) {
			if (note.getTitle().matches(expression)) {
				results.add(note);
			}
		}
		return results;
	}
}
