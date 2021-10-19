package by.doall.repository;

import by.doall.model.BaseEntity;
import by.doall.repository.exception.RepositoryException;
import by.doall.sql.ConnectionSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public abstract class BaseEntityRepository<T extends BaseEntity> {

  private static final Logger LOG = LogManager.getLogger(BaseEntityRepository.class);

  private final ConnectionSource connectionSource;

  public BaseEntityRepository(ConnectionSource connectionSource) {
    this.connectionSource = Objects.requireNonNull(connectionSource);
  }

  public ConnectionSource getConnectionSource() {
    return connectionSource;
  }

  protected T executeQuery(String query, ResultSetMapper<T> mapper, Map<String, Object> params)
      throws RepositoryException {

    T result = null;

    try (var con = getConnectionSource().getConnection();
        var st = con.prepareCall(query)) {

      Optional.ofNullable(params)
          .ifPresent(
              p ->
                  p.forEach(
                      (key, value) -> {
                        try {
                          st.setObject(key, value);
                        } catch (SQLException e) {
                          LOG.error("failed to set param {}, {}", key, value);
                          throw new RepositoryException(e);
                        }
                      }));

      var resultSet = st.executeQuery();
      while (resultSet.next()) {
        result = mapper.mapRow(resultSet);
      }

    } catch (SQLException e) {
      LOG.error("failed to executeQuery {}", query);
      throw new RepositoryException(e);
    }

    return result;
  }
}
