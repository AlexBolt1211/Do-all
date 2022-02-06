package by.doall.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import by.doall.model.Role;
import by.doall.model.User;
import by.doall.repository.exception.RepositoryException;
import by.doall.sql.ConnectionSource;

public class UserRepository extends BaseEntityRepository<User> {

  private static final String SQL_GET_USER_BY_USERNAME =
      "SELECT id, username, firstname, lastname, role FROM users WHERE username= ?";

  private static final String SQL_INSERT_NEW_USER =
      "INSERT INTO users (username, firstname, lastname, role) VALUES (?, ?, ?, ?)";

  public UserRepository(ConnectionSource connectionSource) {
    super(connectionSource);
  }

  private static void mapRow(ResultSet rs, User obj) throws SQLException {
    obj.setId(rs.getInt("id"));
    obj.setUsername(rs.getString("username"));
    obj.setFirstname(rs.getString("firstname"));
    obj.setLastname(rs.getString("lastname"));
    obj.setRole(Role.valueOf(rs.getString("role")));
  }

  public void createUser(User user) throws RepositoryException {
    super.create(
        SQL_INSERT_NEW_USER,
        user.getUsername(),
        user.getFirstname(),
        user.getLastname(),
        user.getRole().name());
  }

  public User getUserByUsername(String username) throws RepositoryException {
    return super.getOne(SQL_GET_USER_BY_USERNAME, UserRepository::mapRow, User::new, username);
  }
}
