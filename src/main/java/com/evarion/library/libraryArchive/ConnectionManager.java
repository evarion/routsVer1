package com.evarion.library.libraryArchive;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;


public class ConnectionManager {

    private static final String URL = "jdbc:postgresql://localhost:5432/routs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "24test1986";

    public static void main(String[] args) {
        Connection connection;

        try {
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("соединение с базой данных установлено");
            }

            System.out.println("введите число для закрытия соединения");
            Scanner sc = new Scanner(System.in);
            sc.nextInt();

            connection.close();
            if (connection.isClosed()) {
                System.out.println("соединение с базой данных закрыто");
            }

        } catch (SQLException e) {
            System.err.println("не удалось загрузить дравйвер");
        }
    }
}
