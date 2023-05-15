package com.evarion.liquibase;
import java.sql.*;


import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;



public class DbMigrator {

    private final String liquibaseRootChangelog;
    private final String jdbcUrl;
    private final String username;
    private final String password;

    public DbMigrator(String liquibaseRootChangelog, String jdbcUrl, String username, String password) {
        this.liquibaseRootChangelog = liquibaseRootChangelog;
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }

    public void runDbMigrations() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to create a db connection", e);
        }

        try {
            Liquibase liquibase = new Liquibase(
                    liquibaseRootChangelog,
                    new ClassLoaderResourceAccessor(),
                    new JdbcConnection(connection)
            );
            liquibase.update("");

        } catch (LiquibaseException e) {
            throw new RuntimeException("Failed to execute a Liquibase update", e);
        }

    }
    public void checkTable(){// перенести

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
