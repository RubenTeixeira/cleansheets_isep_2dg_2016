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
import java.util.List;
import javax.persistence.Query;

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
        System.out.println("size: " + tmp.size());
        return tmp;
    }

    @Override
    public List<Note> principalNotes(Contact contact) {
        final Query query = entityManager().
                createQuery("select m from Note m where m.contact.id = :contact and m.versionState = 1", Note.class);
        query.setParameter("contact", contact.id());
        List<Note> tmp = query.getResultList();
        System.out.println("size: " + tmp.size());
        return tmp;
    }

}
