/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.Contact;
import csheets.domain.List;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.ListRepository;
import javax.persistence.Query;

/**
 *
 * @author Rui Bento
 */
public class JpaListRepository extends JpaRepository<List, Long> implements ListRepository {

    @Override
    protected String persistenceUnitName() {
        return PersistenceSettings.PERSISTENCE_UNIT_NAME;
    }

    @Override
    public Iterable<List> listsByContact(Contact contact) {
        final Query query = entityManager().
                createQuery("SELECT l FROM List l where l.contact.id = :contact "
                        + "and l.version.deleted = false", List.class);
        query.setParameter("contact", contact.id());
        Iterable<List> tmp = query.getResultList();
        return tmp;
    }

    @Override
    public Iterable<List> listVersions(List list) {
        final Query query = entityManager().
                createQuery("SELECT l FROM List l where l.version.id = :version", List.class);
        query.setParameter("version", list.version().id());
        Iterable<List> tmp = query.getResultList();
        return tmp;
    }

}
