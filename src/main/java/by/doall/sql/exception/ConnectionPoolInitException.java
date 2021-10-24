package by.doall.sql.exception;

public class ConnectionPoolInitException extends RuntimeException {

  private static final long serialVersionUID = 5386951227140375947L;

  public ConnectionPoolInitException(String message, Throwable cause) {
    super(message, cause);
  }
}
