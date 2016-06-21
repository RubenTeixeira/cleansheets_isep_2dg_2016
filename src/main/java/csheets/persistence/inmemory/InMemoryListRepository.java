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
	public Iterable<List> search(Calendar startdate, Calendar endDate,
								 String text, boolean content) {
		ArrayList<List> tmp = new ArrayList();
		return tmp;
	}

	public Iterable<List> searchContent(Calendar startDate, Calendar endDate,
										String expression) {
		ArrayList<List> tmp = new ArrayList();
		for (List list : this.all()) {
			if (!list.isDeleted()) {
				tmp.add(list);
			}
		}
		if (startDate != null && endDate != null) {
			for (List list : this.all()) {
				tmp = new ArrayList();
				if (list.getTimeCreated().after(startDate) && list.
					getTimeCreated().before(endDate) && !list.isDeleted()) {
					tmp.add(list);
				}
			}
		} else if (startDate != null) {
			tmp = new ArrayList();
			for (List list : this.all()) {
				if (list.getTimeCreated().after(startDate) && !list.isDeleted()) {
					tmp.add(list);
				}
			}
		} else if (endDate != null) {
			tmp = new ArrayList();
			for (List list : this.all()) {
				if (list.getTimeCreated().before(endDate) && !list.isDeleted()) {
					tmp.add(list);
				}
			}
		}
		if (expression == null || expression.isEmpty()) {
			return tmp;
		}
		ArrayList<List> results = new ArrayList();
		for (List list : tmp) {
			if (list.getText().matches(expression)) {
				results.add(list);
			}
		}
		return results;
	}

	public Iterable<List> searchTitle(Calendar startDate, Calendar endDate,
									  String expression) {
		ArrayList<List> tmp = new ArrayList();
		for (List list : this.all()) {
			if (!list.isDeleted()) {
				tmp.add(list);
			}
		}
		if (startDate != null && endDate != null) {
			for (List list : this.all()) {
				tmp = new ArrayList();
				if (list.getTimeCreated().after(startDate) && list.
					getTimeCreated().before(endDate) && !list.isDeleted()) {
					tmp.add(list);
				}
			}
		} else if (startDate != null) {
			tmp = new ArrayList();
			for (List list : this.all()) {
				if (list.getTimeCreated().after(startDate) && !list.isDeleted()) {
					tmp.add(list);
				}
			}
		} else if (endDate != null) {
			tmp = new ArrayList();
			for (List list : this.all()) {
				if (list.getTimeCreated().before(endDate) && !list.isDeleted()) {
					tmp.add(list);
				}
			}
		}
		if (expression == null || expression.isEmpty()) {
			return tmp;
		}
		ArrayList<List> results = new ArrayList();
		for (List list : tmp) {
			if (list.getTitle().matches(expression)) {
				results.add(list);
			}
		}
		return results;
	}

	@Override
	public Iterable<List> allPrincipal() {
		return new ArrayList();
	}

}
