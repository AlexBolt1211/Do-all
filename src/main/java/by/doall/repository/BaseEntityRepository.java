package by.doall.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.doall.model.BaseEntity;
import by.doall.repository.exception.RepositoryException;
import by.doall.sql.ConnectionSource;
import by.doall.sql.util.ResultSetMapper;

public abstract class BaseEntityRepository<T extends BaseEntity> {

  private static final Logger LOG = LogManager.getLogger(BaseEntityRepository.class);

  private final ConnectionSource connectionSource;

  public BaseEntityRepository(ConnectionSource connectionSource) {
    this.connectionSource = Objects.requireNonNull(connectionSource);
  }

  public ConnectionSource getConnectionSource() {
    return connectionSource;
  }

  public List<T> findAll(
      String selectAllQuery, ResultSetMapper<T> mapper, Supplier<T> newItemSupplier)
      throws RepositoryException {

    LOG.debug("execute findAll: " + selectAllQuery);

    try (var connection = connectionSource.getConnection();
        var statement = connection.prepareStatement(selectAllQuery);
        var resultSet = statement.executeQuery()) {

      List<T> result = new ArrayList<>();

      while (resultSet.next()) {
        T obj = newItemSupplier.get();
        mapper.mapRow(resultSet, obj);
        result.add(obj);
      }

      return result;

    } catch (SQLException e) {
      throw new RepositoryException("Error while executing query", e);
    }
  }

  public T findById(
      String selectByIdQuery, ResultSetMapper<T> mapper, Supplier<T> newItemSupplier, long id)
      throws RepositoryException {

    LOG.debug("execute findById: " + selectByIdQuery);

    try (var connection = connectionSource.getConnection();
        var statement = connection.prepareStatement(selectByIdQuery)) {

      statement.setLong(1, id);

      try (var resultSet = statement.executeQuery()) {
        resultSet.next();
        T obj = newItemSupplier.get();
        mapper.mapRow(resultSet, obj);
        return obj;
      }

    } catch (SQLException e) {
      throw new RepositoryException("Error while executing query", e);
    }
  }

  protected long create(String sqlCreate, Object... params) throws RepositoryException {
    LOG.debug("execute create: " + sqlCreate);

    try (var connection = connectionSource.getConnection();
        var statement = connection.prepareStatement(sqlCreate, new String[] {"id"})) {

      for (int i = 0; i < params.length; i++) {
        statement.setObject(i + 1, params[i]);
      }

      var row = statement.executeUpdate();
      LOG.debug("rows affected: " + row);

      try (var resultSet = statement.getGeneratedKeys()) {
        resultSet.next();
        return resultSet.getLong(1);
      }

    } catch (SQLException e) {
      throw new RepositoryException("Error while executing query", e);
    }
  }

  protected void update(String sqlUpdate, long id, Object... params) throws RepositoryException {
    LOG.debug("execute update: " + sqlUpdate);

    try (var connection = connectionSource.getConnection();
        var statement = connection.prepareStatement(sqlUpdate)) {

      statement.setLong(1, id);

      for (int i = 0; i < params.length; i++) {
        statement.setObject(i + 2, params[i]);
      }

      var row = statement.executeUpdate();
      LOG.debug("rows affected: " + row);

    } catch (SQLException e) {
      throw new RepositoryException("Error while executing query", e);
    }
  }

  protected void delete(String sqlDelete, long id) {
    LOG.debug("execute delete: " + sqlDelete);

    try (var connection = connectionSource.getConnection();
        var statement = connection.prepareStatement(sqlDelete)) {

      statement.setLong(1, id);

      var row = statement.executeUpdate();
      LOG.debug("rows affected: " + row);

    } catch (SQLException e) {
      LOG.error("Error while executing query", e);
    }
  }

  protected T getOne(
      String sqlGetOne, ResultSetMapper<T> mapper, Supplier<T> newItemSupplier, String param) {
    LOG.debug("execute getOne: " + sqlGetOne);

    try (var connection = connectionSource.getConnection();
        var statement = connection.prepareStatement(sqlGetOne)) {

      statement.setString(1, param);

      try (var resultSet = statement.executeQuery()) {
        resultSet.next();
        T obj = newItemSupplier.get();
        mapper.mapRow(resultSet, obj);
        return obj;
      }

    } catch (SQLException e) {
      throw new RepositoryException("Error while executing query", e);
    }
  }
}
