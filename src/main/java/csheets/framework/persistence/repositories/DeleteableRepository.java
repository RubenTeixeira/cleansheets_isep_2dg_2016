package csheets.framework.persistence.repositories;

/**
 *
 * @author Paulo Gandra Sousa
 */
public interface DeleteableRepository<T, K> extends Repository<T, K> {

    /**
     * removes the specified entity from the repository.
     *
     * @param entity
     */
    @Override
    void delete(T entity);

    /**
     * Removes the entity with the specified ID from the repository.
     *
     * @param entityId Entity identification.
     */
    void deleteById(K entityId);
}
