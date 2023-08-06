package com.evarion;

import com.evarion.dataBaseConfig.ConfigConnectionSQL;
import com.evarion.gui.FrameMain;
import com.evarion.liquibase.DbMigrator;

import java.io.IOException;


public class Main {
    static FrameMain frame2 = null;


    static int locMainFormX;
    static int locMainFormY;

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // FrameMain frame2 = null;
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
        //ConnectionManager.startConnectionSQL();
        /*final Runnable connectionInfo = new Runnable() {
            public void run() {
                CheckConnectionSQL.checkConnect();//тест
            }
        };
        Thread thread = new Thread(connectionInfo);
        thread.start();
       */
    }

    public static void getLocMainForm() {
        locMainFormX = frame2.getLocation().x;
        locMainFormY = frame2.getLocation().y;
    }

    public static int getLocMainFormX() {
        return locMainFormX;
    }

    public static int getLocMainFormY() {
        return locMainFormY;
    }


    static void runDBMigrator() {
        ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
        DbMigrator dbMigrator = new DbMigrator(configConnectionSQL.getRootChangeLog(), configConnectionSQL.getJdbcUrl(),
                configConnectionSQL.getLogin(), configConnectionSQL.getPassword());
        dbMigrator.runDbMigrations();
    }


}