package com.evarion;

import com.evarion.dataBase.CheckConnectionSQL;
import com.evarion.dataBase.ConfigConnectionSQL;
import com.evarion.dataBase.ConnectionManager;
import com.evarion.gui.FrameMain;
import com.evarion.liquibase.DbMigrator;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrameMain frame2 = null;
                try {
                    frame2 = new FrameMain();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert frame2 != null;
                frame2.setVisible(true);
            }
        });
        runDBMigrator();
        ConnectionManager.startConnectionSQL();


        final Runnable connectionInfo = new Runnable() {
            public void run() {
                CheckConnectionSQL.checkConnect();//тест
            }
        };
        Thread thread = new Thread(connectionInfo);
        thread.start();

    }

    static void runDBMigrator() {
        // String rootChangeLog = "db/changelog/db.changelog-master.xml";
        // String jdbcUrl = "jdbc:postgresql://localhost:5432/testBase1";
        // String login = "root";
        // String password = "24test1986";
        ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();

        DbMigrator dbMigrator = new DbMigrator(configConnectionSQL.getRootChangeLog(), configConnectionSQL.getJdbcUrl(),
                configConnectionSQL.getLogin(), configConnectionSQL.getPassword());
        dbMigrator.runDbMigrations();
        dbMigrator.checkTable();
    }


}