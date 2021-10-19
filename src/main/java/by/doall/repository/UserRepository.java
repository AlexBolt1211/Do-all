package by.doall.repository;

import by.doall.model.Role;
import by.doall.model.User;
import by.doall.sql.MySqlConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class UserRepository extends BaseEntityRepository<User> {

  private static final String USER_TABLE_COLUMN_ID = "id";
  private static final String USER_TABLE_COLUMN_USERNAME = "username";
  private static final String USER_TABLE_COLUMN_ROLE = "role";
  private static final String USER_TABLE_COLUMN_FIRST_NAME = "firstname";
  private static final String USER_TABLE_COLUMN_LAST_NAME = "lastname";

  private static final String SQL_GET_USER_BY_USERNAME =
      "SELECT id, username, firstname, lastname, role FROM users WHERE username=:username";

  private static final Logger LOG = LogManager.getLogger(UserRepository.class);

  public UserRepository() {
    super(MySqlConnectionPool.getInstance());
  }

  public User findByUsername(String username) {
    return executeQuery(
        SQL_GET_USER_BY_USERNAME,
        rs ->
            new User(
                rs.getLong(USER_TABLE_COLUMN_ID),
                rs.getString(USER_TABLE_COLUMN_USERNAME),
                rs.getString(USER_TABLE_COLUMN_LAST_NAME),
                rs.getString(USER_TABLE_COLUMN_FIRST_NAME),
                Role.valueOf(rs.getString(USER_TABLE_COLUMN_ROLE))),
        Map.of(USER_TABLE_COLUMN_USERNAME, username));
  }
}
