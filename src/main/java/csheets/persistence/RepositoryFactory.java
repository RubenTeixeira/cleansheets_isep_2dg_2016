package csheets.persistence;

/**
 * @author Paulo Gandra Sousa
 *
 */
public interface RepositoryFactory {

	ContactRepository contacts();

	EventRepository events();
}
