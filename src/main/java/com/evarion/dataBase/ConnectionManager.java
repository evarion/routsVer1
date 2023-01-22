package com.evarion.dataBase;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/routs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "24test1986";
    private static Connection connection;
    private static boolean isStartSQL = false;

    public static void startConnectionSQL() {
        if (!isStartSQL) {
            try {
                Driver driver = new org.postgresql.Driver();
                DriverManager.registerDriver(driver);

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                if (!connection.isClosed()) {
                    System.out.println("соединение с БД установлено");
                    isStartSQL = true;
                }
            } catch (SQLException e) {
                System.err.println("не удалось загрузить дравйвер");
            }
        }
    }

    public static void stopConnectionSQL() {
        if (isStartSQL) {
            try {
                connection.close();
                isStartSQL = false;
                if (connection.isClosed()) {
                    System.out.println("соединение с БД данных закрыто");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
