package by.doall.sql;

public interface ConnectionPool extends ConnectionSource {

  void start() throws Exception;

  void stop();
}
