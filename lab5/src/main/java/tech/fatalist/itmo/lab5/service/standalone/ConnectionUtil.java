package tech.fatalist.itmo.lab5.service.standalone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String JDBC_URL = "jdbc:postgresql://itmo.fatalist.tech:5432/itmo-web-services";
    private static final String JDBC_USER = "example-wrong-user";
    private static final String JDBC_PASSWORD = "example-wrong-password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}
