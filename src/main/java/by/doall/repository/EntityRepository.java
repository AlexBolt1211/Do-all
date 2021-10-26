package by.doall.repository;

import by.doall.repository.exception.RepositoryException;

import java.util.Collection;

public interface EntityRepository<T> {

    Collection<T> findAll() throws RepositoryException;

    T create(T entity) throws RepositoryException;

    boolean remove(long id) throws RepositoryException;
}