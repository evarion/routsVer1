package com.evarion;

import com.evarion.dataBaseConfig.ConfigConnectionSQL;
import com.evarion.gui.FrameMain;
import com.evarion.liquibase.DbMigrator;

import java.io.IOException;


public class Main {
    static FrameMain frame2 = null;

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

    /*
        public static void getLocMainForm() {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                }
            });
            t1.start();
        }
     */
    public static int getSizeFormH() {
        return frame2.getHeight();
    }

    public static int getSizeFormW() {
        return frame2.getWidth();
    }

    public static int getLocMainFormX() {
        return frame2.getLocation().x;
    }

    public static int getLocMainFormY() {
        return frame2.getLocation().y;
    }


    static void runDBMigrator() {

        ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
        DbMigrator dbMigrator = new DbMigrator(configConnectionSQL.getRootChangeLog(), configConnectionSQL.getJdbcUrl(),
                configConnectionSQL.getLogin(), configConnectionSQL.getPassword());
        dbMigrator.runDbMigrations();


    }
}