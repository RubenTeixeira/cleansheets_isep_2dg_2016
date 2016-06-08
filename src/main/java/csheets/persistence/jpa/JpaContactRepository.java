/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.jpa;

import csheets.domain.Contact;
import csheets.framework.persistence.repositories.impl.jpa.JpaRepository;
import csheets.persistence.ContactRepository;

/**
 *
 * @author Rui Freitas
 */
public class JpaContactRepository extends JpaRepository<Contact, Long> implements ContactRepository {

	@Override
	protected String persistenceUnitName() {
		return PersistenceSettings.PERSISTENCE_UNIT_NAME;
	}

	public Contact getByName(String name) {
		/*
		final Query query = entityManager().
			createQuery("select m from Contact m where m.name = :name", Contact.class);
		query.setParameter("name", name);
		return (Contact) query.getSingleResult();
		 */
		for (Contact contact : this.all()) {
			if (contact.name().equalsIgnoreCase(name)) {
				return contact;
			}
		}
		return null;
	}

}
