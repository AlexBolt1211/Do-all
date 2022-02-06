package by.doall.sql.util;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetMapper<T> {

  void mapRow(ResultSet rs, T obj) throws SQLException;
}
