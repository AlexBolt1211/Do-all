package by.doall.repository;

import by.doall.model.BaseEntity;
import by.doall.repository.exception.RepositoryException;
import by.doall.sql.ConnectionSource;
import by.doall.sql.util.ResultSetMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;

public abstract class BaseEntityRepository<T extends BaseEntity> implements EntityRepository<T> {

  private static final Logger LOG = LogManager.getLogger(BaseEntityRepository.class);

  private final ConnectionSource connectionSource;

  public BaseEntityRepository(ConnectionSource connectionSource) {
    this.connectionSource = Objects.requireNonNull(connectionSource);
  }

  public ConnectionSource getConnectionSource() {
    return connectionSource;
  }

  protected abstract ResultSetMapper<T> getResultSetMapper();

  protected Collection<T> findAll(String query) throws RepositoryException {
    return null;
  }

  protected T create(T entity, String query, Map<String, Object> params)
          throws RepositoryException {
    return null;
  }

  protected boolean remove(long id, String query) throws RepositoryException {
    return false;
  }
}
