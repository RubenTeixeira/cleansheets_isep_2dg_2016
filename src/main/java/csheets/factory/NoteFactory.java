/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.factory;

import csheets.domain.Note;

/**
 *
 * @author Diogo Azevedo
 */
public class NoteFactory {
        public NoteFactory() {

	}

	public static final Note createNote(String notetext) {
		return new Note(notetext);
	}
}

