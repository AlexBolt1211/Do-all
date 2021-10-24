package by.doall.sql.util;

import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface ResultSetMapper<T> {

  T mapRow(ResultSet rs) throws SQLException;
}
