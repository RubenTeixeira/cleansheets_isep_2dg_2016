/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.persistence.inmemory;

import csheets.domain.Contact;
import csheets.domain.List;
import csheets.framework.persistence.repositories.impl.immemory.InMemoryRepository;
import csheets.persistence.ListRepository;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Rui Bento
 */
class InMemoryListRepository extends InMemoryRepository<List, Long>
	implements ListRepository {

	long nextID = 1;

	@Override
	protected Long newPK(List entity) {
		return ++nextID;
	}

	@Override
	public Iterable<List> listsByContact(Contact contact) {
		java.util.List<List> lists = new ArrayList<>();
		for (List l : this.all()) {
			if (l.getContact().equals(contact)
				&& !l.isDeleted()
				&& l.isLatestVersion()) {
				lists.add(l);
			}
		}
		return lists;
	}

	@Override
	public Iterable<List> listVersions(List list) {
		java.util.List<List> lists = new ArrayList<>();
		for (List l : this.all()) {
			if (l.sameNotation(list)) {
				lists.add(l);
			}
		}
		return lists;
	}

	@Override
	public Iterable<List> search(Calendar startDate, Calendar endDate,
								 String expression) {
		ArrayList<List> lists = new ArrayList();
		for (List list : this.all()) {
			if (list.getTimeCreated().after(startDate) && list.getTimeCreated().
				before(endDate)) {
				lists.add(list);
			}
		}
		if (expression == null || expression.isEmpty()) {
			return lists;
		}
		ArrayList<List> results = new ArrayList();
		for (List list : lists) {
			if (list.getText().matches(expression)) {
				results.add(list);
			}
		}
		return results;
	}

}
