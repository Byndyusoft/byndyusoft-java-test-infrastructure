package Byndyusoft.clients;


import Byndyusoft.configs.Property;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class PostgreSqlBaseClient {

    private static final int postgreSleep = 1000;

    protected Connection connection;

    protected static Connection createConnection(String uri, String userName, String userPassword) {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(uri + "?" + "user=" + userName + "&password=" + userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public void connectionToPostgre(String uri, String userName, String userPassword) {
        this.connection = createConnection(uri, userName, userPassword);
    }

}
