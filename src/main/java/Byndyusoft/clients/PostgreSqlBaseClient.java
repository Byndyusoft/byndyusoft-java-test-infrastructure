package Byndyusoft.clients;


import Byndyusoft.configs.Property;

import java.io.IOException;
import java.sql.*;


public class PostgreSqlBaseClient {

    private static final int postgreSleep = 1000;

    protected Connection connection;

    protected static Connection createConnection(String uri, String userName, String userPassword) {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        }
        catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(uri + "?" + "user=" + userName + "&password=" + userPassword);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static String selectFromPostgre(String query) throws IOException, SQLException {
        Connection connection = createConnection(new Property().getProperty("postgreDB.uri"),
                new Property().getProperty("postgreDB.userName"), new Property().getProperty("postgreDB.userPassword"));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println("number = " + resultSet.getString("number"));
        }

        String s = resultSet.getString(1);

        return s;
    }

    public void dropTable(String tableName) throws SQLException, IOException {
        Connection connection = createConnection(new Property().getProperty("postgreDB.uri"),
                new Property().getProperty("postgreDB.userName"), new Property().getProperty("postgreDB.userPassword"));
        Statement statement = connection.createStatement();
        statement.executeUpdate("DROP " + tableName + ";");
    }

    public void dropDatabase(String databaseName) throws SQLException, IOException {
        Connection connection = createConnection(new Property().getProperty("postgreDB.uri"),
                new Property().getProperty("postgreDB.userName"), new Property().getProperty("postgreDB.userPassword"));
        Statement statement = connection.createStatement();
        statement.executeQuery("DROP DATABASE [IF EXISTS) " + databaseName + ";");
    }

}
