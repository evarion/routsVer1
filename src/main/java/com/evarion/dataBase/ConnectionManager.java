package com.evarion.dataBase;

import com.evarion.gui.TopButtonMenu;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {


    private static final String URL = "jdbc:postgresql://localhost:5432/routs";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "24test1986";
    public static Connection connection;
    public static boolean isStartSQL = false;

    static Icon startConnectionSQL = new ImageIcon("src/main/resources/images/startConnectionSQL.png");
    static Icon stopConnectionSQL = new ImageIcon("src/main/resources/images/stopConnectionSQL.png");


    public static void startConnectionSQL() {
        if (!isStartSQL) {
            try {
                Driver driver = new org.postgresql.Driver();
                DriverManager.registerDriver(driver);

                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                if (!connection.isClosed()) {
                    System.out.println("соединение с БД установлено");
                    isStartSQL = true;
                    TopButtonMenu.buttonsTopMenu[23].setIcon(startConnectionSQL);
                    TopButtonMenu.buttonsTopMenu[23].setToolTipText("соединение с БД установлено");
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
                    TopButtonMenu.buttonsTopMenu[23].setIcon(stopConnectionSQL);
                    TopButtonMenu.buttonsTopMenu[23].setToolTipText("нет соединения с БД");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
