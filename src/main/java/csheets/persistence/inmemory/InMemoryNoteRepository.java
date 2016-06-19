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
	public List<Note> search(Calendar startDate, Calendar endDate,
							 String expression) {
		List<Note> notes = new ArrayList();
		for (Note note : this.all()) {
			if (note.date().after(startDate) && note.date().before(endDate)) {
				notes.add(note);
			}
		}
		if (expression == null || expression.isEmpty()) {
			return notes;
		}
		ArrayList<Note> results = new ArrayList();
		for (Note note : notes) {
			for (Note version : note.versionByNote()) {
				if (version.toString().matches(expression)) {
					results.add(version);
				}
			}
		}
		return results;
	}

}
