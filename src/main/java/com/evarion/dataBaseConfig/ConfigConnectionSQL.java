package com.evarion.dataBaseConfig;

public class ConfigConnectionSQL {
    String rootChangeLog = "db/changelog/db.changelog-master.xml";
    String jdbcUrl = "jdbc:postgresql://localhost:5432/testBase1";
    String login = "root";
    String password = "24test1986";


    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getRootChangeLog() {
        return rootChangeLog;
    }
}
