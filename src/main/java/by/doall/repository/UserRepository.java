package by.doall.repository;

import by.doall.model.Role;
import by.doall.model.User;
import by.doall.repository.exception.RepositoryException;
import by.doall.sql.MySqlConnectionPool;
import by.doall.sql.util.ResultSetMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Map;

public class UserRepository extends BaseEntityRepository<User> {

  private static final Logger LOG = LogManager.getLogger(UserRepository.class);

  private static final String USER_TABLE_COLUMN_ID = "id";
  private static final String USER_TABLE_COLUMN_USERNAME = "username";
  private static final String USER_TABLE_COLUMN_ROLE = "role";
  private static final String USER_TABLE_COLUMN_FIRST_NAME = "firstname";
  private static final String USER_TABLE_COLUMN_LAST_NAME = "lastname";

  private static final String SQL_GET_USER_BY_USERNAME =
          "SELECT id, username, firstname, lastname, role FROM users WHERE username=:username";

  private static final String SQL_GET_ALL_USERS =
          "SELECT id, username, firstname, lastname, role FROM users";

  private static final String SQL_INSERT_NEW_USER =
          "INSERT INTO users (username, firstname, lastname, role) VALUES (:username, :firstname, :lastname, :role)";

  private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE id = :id";

  public UserRepository() {
    super(MySqlConnectionPool.getInstance());
  }

  @Override
  protected ResultSetMapper<User> getResultSetMapper() {
    return rs ->
            new User(
                    rs.getLong(USER_TABLE_COLUMN_ID),
                    rs.getString(USER_TABLE_COLUMN_USERNAME),
                    rs.getString(USER_TABLE_COLUMN_LAST_NAME),
                    rs.getString(USER_TABLE_COLUMN_FIRST_NAME),
                    Role.valueOf(rs.getString(USER_TABLE_COLUMN_ROLE)));
  }

  @Override
  public Collection<User> findAll() throws RepositoryException {
    return findAll(SQL_GET_ALL_USERS);
  }

  @Override
  public User create(User entity) throws RepositoryException {
    Map<String, Object> params =
            Map.of(
                    USER_TABLE_COLUMN_USERNAME,
                    entity.getUsername(),
                    USER_TABLE_COLUMN_FIRST_NAME,
                    entity.getFirstname(),
                    USER_TABLE_COLUMN_LAST_NAME,
                    entity.getLastname(),
                    USER_TABLE_COLUMN_ROLE,
                    entity.getRole());

    return create(entity, SQL_INSERT_NEW_USER, params);
  }

  @Override
  public boolean remove(long id) throws RepositoryException {
    return remove(id, SQL_DELETE_USER_BY_ID);
  }
}
