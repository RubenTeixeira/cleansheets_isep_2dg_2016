/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.Note;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.NoteRepository;

/**
 *
 * @author Diogo Azevedo
 */
public class JpaNoteRepository extends JpaRepository<Note, Long> implements NoteRepository {

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }

}
