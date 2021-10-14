package by.doall.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

   private static final String URL = "jdbc:mysql://localhost/do-all-schema?serverTimezone=UTC";
   private static final String USER = null;
   private static final String PASWORD = null;

   public ConnectionManager getConnectionManager() throws SQLException {
       return (ConnectionManager) DriverManager.getConnection(URL, USER, PASWORD );
    }
    Connection connection;
    {
        try {
            connection = DriverManager.getConnection(URL, USER, PASWORD);
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO users (id, username, lastname, firstname, password ) VALUES ()");


            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    // public Connection takeConnectionFromPool();

    // public void returnConnectionToPool(Connection connection);
}
