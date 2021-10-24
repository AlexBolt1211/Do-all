package by.doall.sql;

import java.sql.Connection;

public interface ConnectionSource extends AutoCloseable {

  Connection getConnection();

  void returnConnection(Connection con);
}
