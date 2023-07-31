package com.evarion.library.libraryArchive.CheckConnection;

import com.evarion.gui.TopButtonMenu;

import javax.swing.*;
import java.sql.SQLException;

public class CheckConnectionSQL {
    static final Icon stopConnectionSQL = new ImageIcon("src/main/resources/images/stopConnectionSQL.png");

    public static void checkConnect() {
        boolean open = true;
        boolean connected = false;
        while (open) {
            try {
                ConnectionManager.connection.isValid(5);
                if (!connected) {
                    if (ConnectionManager.connection.isClosed()) {
                        TopButtonMenu.buttonsTopMenu[23].setIcon(stopConnectionSQL);
                        TopButtonMenu.buttonsTopMenu[23].setToolTipText("нет соединения с БД");
                        System.out.println("Потеряно соединение с БД");
                        ConnectionManager.isStartSQL = false;
                        connected = true;
                    }
                }
                if (!ActionStartStopConnectionSQL.stopManualConnection) {
                    if (connected) {
                        {
                            //ConnectionManager.startConnectionSQL();
                            System.out.println("соединение с БД повторно установлено");
                            ConnectionManager.isStartSQL = true;
                            connected = false;
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
