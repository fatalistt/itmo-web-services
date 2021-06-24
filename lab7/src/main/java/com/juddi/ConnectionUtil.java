package com.juddi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static final String JDBC_URL = "jdbc:postgresql://itmo.fatalist.tech:5432/itmo-web-services";
    private static final String JDBC_USER = "ifmo-user";
    private static final String JDBC_PASSWORD = "ifmo-password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
}