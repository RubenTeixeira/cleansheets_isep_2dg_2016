/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.inmemory;

import csheets.domain.Note;
import csheets.framework.persistence.repositories.impl.immemory.InMemoryRepository;
import csheets.persistence.NoteRepository;

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

}
