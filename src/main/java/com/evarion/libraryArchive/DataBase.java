package com.evarion.libraryArchive;

import com.evarion.libraryArchive.CheckConnection.ConnectionManager;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    public static void createDefaultTables(){
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


        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table created successfully");

    }
    public static void checkDefaultTable(){
        DatabaseMetaData databaseMetaData = null;
        try {
            databaseMetaData = ConnectionManager.connection.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = databaseMetaData.getTables(null, null, null, new String[] {"TABLE"});
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String name = null;
            try {
                name = resultSet.getString("TABLE_NAME");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String schema = null;
            try {
                schema = resultSet.getString("TABLE_SCHEM");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(name + " on schema " + schema);
        }
    }
}
