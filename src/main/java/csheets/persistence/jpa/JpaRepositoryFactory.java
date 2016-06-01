package csheets.persistence.jpa;

import csheets.persistence.ContactRepository;
import csheets.persistence.EventRepository;
import csheets.persistence.RepositoryFactory;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

	@Override
	public ContactRepository contacts() {
		return new JpaContactRepository();
	}

	@Override
	public EventRepository events() {
		return new JpaEventRepository();
	}
}
