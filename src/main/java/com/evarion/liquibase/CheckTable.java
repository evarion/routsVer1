package com.evarion.liquibase;

import java.sql.*;

public class CheckTable {
    private final String jdbcUrl;
    private final String username;
    private final String password;

    public CheckTable( String jdbcUrl, String username, String password) {// перенести
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public void runCheck(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to create a db connection", e);
        }
        DatabaseMetaData databaseMetaData = null;
        try {
            databaseMetaData = connection.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet = null;
        try {
            resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});
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
