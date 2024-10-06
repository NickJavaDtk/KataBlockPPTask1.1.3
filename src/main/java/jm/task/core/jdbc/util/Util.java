package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String loginDB = "sa";
    private static final String passwordDB = "Admin";
    private static final String urlDB = "jdbc:mysql://localhost:3306/kata?serverTimezone=UTC";
    private static Connection connection;

    private static Connection getConnectionBD() {
        try {
            connection = DriverManager.getConnection(urlDB, loginDB, passwordDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return connection == null ? getConnectionBD() : connection;
    }
}
