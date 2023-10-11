package ru.kpfu.itis.bagaviev.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {

    public static final String DRIVER = "org.postgresql.Driver";
    public static final String URL = "jdbc:postgresql://localhost:5432/test";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "172332";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(
                        URL,
                        USERNAME,
                        PASSWORD
                );
            } catch (ClassNotFoundException | SQLException exception) {
                throw new RuntimeException(exception);
            }
        }
        return connection;
    }
}
