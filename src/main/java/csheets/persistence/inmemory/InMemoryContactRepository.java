/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.inmemory;

import csheets.domain.CompanyContact;
import csheets.domain.Contact;
import csheets.domain.PersonContact;
import csheets.framework.persistence.repositories.impl.immemory.InMemoryRepository;
import csheets.persistence.ContactRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Martins
 */
class InMemoryContactRepository extends InMemoryRepository<Contact, Long>
	implements ContactRepository {

	long nextID = 1;

	@Override
	protected Long newPK(Contact entity) {
		return ++nextID;
	}

	@Override
	public Contact getByName(String name) {
		for (Contact contact : this.all()) {
			if (contact.toString().equalsIgnoreCase(name)) {
				return contact;
			}
		}
		return null;
	}

	@Override
	public Iterable<Contact> contactsCompany(Contact company) {
		List<Contact> list = new ArrayList();
		for (Contact contact : this.all()) {
			if (contact instanceof PersonContact) {
				PersonContact person = (PersonContact) contact;
				if (person.company().equals(company)) {
					list.add(contact);
				}
			}
		}
		return list;
	}

	@Override
	public Iterable<Contact> allCompanies() {
		List<Contact> list = new ArrayList();
		for (Contact contact : this.all()) {
			if (contact instanceof CompanyContact) {
				list.add(contact);
			}
		}
		return list;
	}

}
