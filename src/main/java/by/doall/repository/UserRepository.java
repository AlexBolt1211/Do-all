package by.doall.repository;

import by.doall.model.Role;
import by.doall.model.User;

public class UserRepository extends BaseEntityRepository<User> {

    private ConnectionManager connectionManager;

    public UserRepository(ConnectionManager connectionManager, ConnectionBuilder connectionBuilder) {
        this.connectionManager = connectionManager;
        this.connectionBuilder = connectionBuilder;
    }

    public void setConnectionBuilder(ConnectionBuilder connectionBuilder) {
        this.connectionBuilder = connectionBuilder;
    }

    private ConnectionBuilder connectionBuilder;
    // 30 %
    // 1. JDBC connection pool
    // 1.1 configuration
    // 1.2 provide jdbc drivers
    // 1.3. init connections 10 on application startup

    // 10 %
    // 3. repository get jdbc connection from pool
    // 4. create prepared statement
    // 5. create query  [Select *  from users where users.id = ? ]
    // 6. execute query using prepared statement and jdbc connection from pool
    // 7. process result: build new User object, populate data
    // 8. finally return connection back to pool

    @Override
    public User getById(long id) {
        User user = new User(1, "test", "test", "test", Role.ROLE_GUEST);
        // todo:

        return user;
    }

}
