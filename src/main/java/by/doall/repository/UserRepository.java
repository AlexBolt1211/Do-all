package by.doall.repository;

import by.doall.model.Role;
import by.doall.model.User;
import by.doall.pool.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository extends BaseEntityRepository<User> {

  private static final String SELECT_BY_USER_ID =
      "SELECT id,username,lastname,firstname  FROM users WHERE users.id = ?";

  // 30 %
  // 1. JDBC connection pool
  // 1.1 configuration
  // 1.2 provide jdbc drivers
  // 1.3. init connections 10 on application startup

  // 10 %
  // 3. repository get jdbc connection from pool
  // 4. create prepared statement
  // 5. create query  [Select *  from users where users.id = ? ]
  // 6. execute query using prepared statement and jdbc connection from pool
  // 7. process result: build new User object, populate data
  // 8. finally return connection back to pool

  @Override
  public User getById(long id) {
    Connection connection = connectionManager.takeConnection();

    User user = null;

    try {

      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_USER_ID);
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      user =
          new User(
              resultSet.getLong("id"),
              resultSet.getString("username"),
              resultSet.getString("lastname"),
              resultSet.getString("firstname"),
              Role.ROLE_GUEST);

    } catch (Exception e) {
      throw new RepositoryException(e);
    } finally {
      connectionManager.returnConnection(connection);
    }

    return user;
  }
}
