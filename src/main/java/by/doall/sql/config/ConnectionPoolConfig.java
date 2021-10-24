package by.doall.sql.config;

import java.util.ResourceBundle;

public final class ConnectionPoolConfig {

  private static final String DB_URL = "db.url";
  private static final String DB_USER = "db.user";
  private static final String DB_PASSWORD = "db.password";
  private static final String DB_POOL_SIZE = "db.poolsize";

  private final String url;
  private final String user;
  private final String password;
  private final int size;

  public ConnectionPoolConfig(String bundleName) {
    ResourceBundle dbResourceBundle = ResourceBundle.getBundle(bundleName);

    this.user = dbResourceBundle.getString(DB_USER);
    this.password = dbResourceBundle.getString(DB_PASSWORD);
    this.url = dbResourceBundle.getString(DB_URL);
    this.size = Integer.parseInt(dbResourceBundle.getString(DB_POOL_SIZE));
  }

  public static ConnectionPoolConfig getApplicationConfig() {
    return new ConnectionPoolConfig("application");
  }

  public String getUrl() {
    return url;
  }

  public String getUser() {
    return user;
  }

  public String getPassword() {
    return password;
  }

  public int getSize() {
    return size;
  }
}
