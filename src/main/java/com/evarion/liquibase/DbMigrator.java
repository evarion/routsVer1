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
}
