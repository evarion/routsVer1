package com.evarion.libraryArchive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManagerV3 {

    private static final String PASSWORD = "24test1986";
    private static final String USERNAME = "root";
    private static final String URL = "jdbc:postgresql://localhost:5432/routs";

    public static void main(String[] args) {
        openConnection();
    }

    public static void openConnection() {
        Connection connection;
        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Драйвер подключен");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Соединение установлено");
            } else {
                System.out.println("Соединение не установлено");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}





