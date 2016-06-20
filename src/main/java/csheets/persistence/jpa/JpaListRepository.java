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
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.Query;
import javax.persistence.TemporalType;

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
				+ "and l.version.deleted = false "
				+ "and l.version.lastVersion = l.versionNum",
						List.class);
		query.setParameter("contact", contact.id());
		Iterable<List> tmp = query.getResultList();
		return tmp;
	}

	@Override
	public Iterable<List> listVersions(List list) {
		final Query query = entityManager().
			createQuery("SELECT l FROM List l where l.version.id = :version",
						List.class);
		query.setParameter("version", list.version().id());
		Iterable<List> tmp = query.getResultList();
		return tmp;
	}

	@Override
	public Iterable<List> search(Calendar startDate, Calendar endDate,
								 String title, String content) {
		Iterable<List> tmp = searchDates(startDate, endDate);
		Boolean cont = true;
		if (content == null || content.isEmpty()) {
			cont = false;
		}
		tmp = this.search(tmp, title, cont);
		return tmp;
	}

	public Iterable<List> search(Iterable<List> lists, String expression,
								 Boolean content) {
		ArrayList<List> results = new ArrayList();
		for (List list : lists) {
			if (list.getTitle().matches(expression)) {
				results.add(list);
			} else if (content && list.getText().matches(expression)) {
				results.add(list);
			}
		}
		return results;
	}

	public Iterable<List> searchContent(Iterable<List> lists, String content) {
		ArrayList<List> results = new ArrayList();
		for (List list : lists) {
			if (list.getText().matches(content)) {
				results.add(list);
			}
		}
		return results;
	}

	public Iterable<List> searchTitle(Iterable<List> lists, String title) {
		ArrayList<List> results = new ArrayList();
		for (List list : lists) {
			if (list.getTitle().matches(title)) {
				results.add(list);
			}
		}
		return results;
	}

	public Iterable<List> searchDates(Calendar startDate, Calendar endDate) {
		String term = "SELECT l FROM List l where l.version.deleted = false";
		if (startDate != null && endDate != null) {
			term = "SELECT l FROM List l where l.time BETWEEN :startDate AND :endDate AND l.version.deleted = false";
		} else if (startDate != null) {
			term = "SELECT l FROM List l where l.time > :startDate AND l.version.deleted = false";
		} else if (endDate != null) {
			term = "SELECT l FROM List l where l.time < :endDate AND l.version.deleted = false";
		}
		final Query query = entityManager().createQuery(term, List.class);
		if (startDate != null) {
			query.setParameter("startDate", startDate, TemporalType.DATE);
		}
		if (endDate != null) {
			query.setParameter("endDate", endDate, TemporalType.DATE);
		}
		return (Iterable<List>) query.getResultList();
	}

}
