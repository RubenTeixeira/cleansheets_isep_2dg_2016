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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	public Iterable<Note> search(Calendar startDate, Calendar endDate,
								 String text, boolean content) {
		Iterable<Note> list = searchDates(startDate, endDate);
		list = this.search(list, text, content);
		return list;
	}

	public Iterable<Note> search(Iterable<Note> lists, String expression,
								 Boolean content) {
		Set<Note> results = new HashSet();
		for (Note note : lists) {
			if (note.getTitle().matches(expression)) {
				results.add(note);
			}
			if (content && note.getNoteText().matches(expression)) {
				results.add(note);
			}
		}
		return results;
	}

	public Iterable<Note> searchDates(Calendar startDate, Calendar endDate) {
		return this.all();
	}

	@Override
	public Iterable<Note> allPrincipal() {
		return this.all();
	}

}
