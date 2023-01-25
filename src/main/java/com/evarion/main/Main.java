package com.evarion.main;

import com.evarion.dataBase.CheckConnectionSQL;
import com.evarion.dataBase.ConnectionManager;
import com.evarion.gui.FrameMain;

import java.io.IOException;


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

        ConnectionManager.startConnectionSQL();

        final Runnable connectionInfo = new Runnable() {
            public void run() {
                CheckConnectionSQL.checkConnect();//тест
            }
        };
        Thread thread = new Thread(connectionInfo);
        thread.start();
    }
}