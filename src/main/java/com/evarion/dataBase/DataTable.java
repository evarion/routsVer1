package com.evarion.dataBase;

import java.sql.SQLException;
import java.sql.Statement;

public class DataTable {
    public static void createDefaultTables() {
        Statement stmt = null;
        try {
            stmt = ConnectionManager.connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS COMPANY " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    " NAME TEXT NOT NULL, " +
                    " AGE INT NOT NULL, " +
                    " ADDRESS CHAR(50), " +
                    " SALARY REAL)";
            stmt.executeUpdate(sql);
            stmt.close();


        } catch (
                SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    private static void createDefaultTableVessel() {
        Statement stmt = null;
        try {
            String sql = "CREATE TABLE IF NOT EXISTS VESSEL " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    "NAME TEXT NOT NULL, " +
                    "FLAG TEXT NOT NULL";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (
                SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    private static void createDefaultTablePort(Statement stmt) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS PORT " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    "NAME TEXT NOT NULL, " +
                    "FLAG TEXT NOT NULL"+
                    "COUNTRY TEXT NOT NULL ";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (
                SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static void createDefaultTableCargo(Statement stmt) {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS CARGO " +
                    "(ID INT PRIMARY KEY NOT NULL," +
                    "NAME TEXT NOT NULL, " +
                    "NETTO DESIMAL" +
                    "BRUTTO DESIMAL";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (
                SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private static void createNewTable() {

    }
}

