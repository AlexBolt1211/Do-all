package by.doall.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionManager {

  private static final ConnectionManager instance = new ConnectionManager();

  private static final String URL = "jdbc:mysql://localhost:3306/do-all-schema?serverTimezone=UTC";
  private static final int INITIAL_POOL_SIZE = 10;
  private static final String USER = null;
  private static final String PASSWORD = null;

  private final ConcurrentLinkedQueue<Connection> connections =
      new ConcurrentLinkedQueue<Connection>();

  private ConnectionManager() {
    try {
      init(URL, USER, PASSWORD, INITIAL_POOL_SIZE);
    } catch (SQLException e) {
      throw new ConnectionManagerInitException(e);
    }
  }

  public static ConnectionManager getInstance() {
    return instance;
  }

  private void init(String url, String user, String password, int maxSize) throws SQLException {
    for (int i = 0; i < maxSize; i++) {
      connections.add(createConnection(url, user, password));
    }
  }

  private Connection createConnection(String url, String user, String password)
      throws SQLException {
    return DriverManager.getConnection(url, user, password);
  }

  public Connection takeConnection() {
    return connections.peek();
  }

  public void returnConnection(Connection connection) {
    connections.offer(connection);
  }
}
