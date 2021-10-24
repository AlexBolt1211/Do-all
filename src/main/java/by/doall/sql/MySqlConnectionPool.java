package by.doall.sql;

import by.doall.sql.config.ConnectionPoolConfig;
import by.doall.sql.exception.ConnectionPoolInitException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MySqlConnectionPool implements ConnectionPool {

  private static final Logger LOG = LogManager.getLogger(MySqlConnectionPool.class);

  private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

  private static final MySqlConnectionPool POOL_INSTANCE = new MySqlConnectionPool();

  private BlockingQueue<Connection> freeConnections;
  private BlockingQueue<Connection> inUseConnections;

  private MySqlConnectionPool() {}

  public static ConnectionPool getInstance() {
    return POOL_INSTANCE;
  }

  @Override
  public void start() throws ConnectionPoolInitException {
    LOG.info("...starting db pool");

    var config = ConnectionPoolConfig.getApplicationConfig();
    var poolSize = config.getSize();

    this.freeConnections = new ArrayBlockingQueue<>(poolSize);
    this.inUseConnections = new ArrayBlockingQueue<>(poolSize);

    try {
      Class.forName(DRIVER_NAME);

      for (int i = 0; i < poolSize; i++) {
        var connection =
            DriverManager.getConnection(config.getUrl(), config.getUser(), config.getPassword());
        freeConnections.add(new ConnectionWrapper(connection, this));
      }
    } catch (SQLException | ClassNotFoundException ex) {
      throw new ConnectionPoolInitException("could not initialize connection pool", ex);
    }

    LOG.info("db pool started");
  }

  @Override
  public void stop() {
    LOG.info("attempt to stop db pool");
    try {
      while (!freeConnections.isEmpty()) {
        freeConnections.take().close();
      }
      while (!inUseConnections.isEmpty()) {
        inUseConnections.take().close();
      }
    } catch (InterruptedException | SQLException e) {
      LOG.error(e);
    }
    LOG.info("db pool stopped");
  }

  @Override
  public Connection getConnection() {
    Connection connection = null;
    try {
      connection = freeConnections.take();
      inUseConnections.add(connection);
    } catch (InterruptedException e) {
      LOG.error("could not get connection", e);
    }

    return connection;
  }

  @Override
  public void returnConnection(Connection con) {
    Objects.requireNonNull(con);

    if (inUseConnections.remove(con)) {
      freeConnections.add(con);
    }
  }

  @Override
  public void close() {
    this.stop();
  }
}
