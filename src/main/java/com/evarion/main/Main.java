package com.evarion.main;

import com.evarion.dataBase.ConnectionManager;
import com.evarion.gui.FrameMain;
import com.evarion.gui.TopButtonMenu;

import javax.swing.*;
import java.io.IOException;
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
        ConnectionManager.startConnectionSQL();


        final Runnable connectionInfo = new Runnable() {
            final Icon stopConnectionSQL = new ImageIcon("src/main/resources/images/stopConnectionSQL.png");

            public void run() {
                boolean open = true;
                boolean checkConnect = false;
                while (open) {

                    try {
                        ConnectionManager.connection.isValid(5);
                        if (!checkConnect) {

                            if (ConnectionManager.connection.isClosed()) {
                                TopButtonMenu.buttonsTopMenu[23].setIcon(stopConnectionSQL);
                                TopButtonMenu.buttonsTopMenu[23].setToolTipText("нет соединения с БД");
                                System.out.println("Потеряно соединение с БД");
                                ConnectionManager.isStartSQL = false;
                                checkConnect = true;
                            }
                        }
                        if (checkConnect) {
                            {
                                ConnectionManager.startConnectionSQL();
                                System.out.println("соединение с БД повторно установлено");
                                ConnectionManager.isStartSQL = true;
                                checkConnect = false;
                            }
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(connectionInfo);
        thread.start();
    }
}// перенести в DataBase