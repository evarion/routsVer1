package com.evarion.dataBase;

import com.evarion.gui.TopButtonMenu;
import com.evarion.gui.actionButtonListeners.ActionStartStopConnectionSQL;

import javax.swing.*;
import java.sql.SQLException;

public class CheckConnectionSQL {
    static final Icon stopConnectionSQL = new ImageIcon("src/main/resources/images/stopConnectionSQL.png");

    public static void checkConnect() {
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
                if (!ActionStartStopConnectionSQL.stopManualConnection) {
                    if (checkConnect) {
                        {
                            ConnectionManager.startConnectionSQL();
                            System.out.println("соединение с БД повторно установлено");
                            ConnectionManager.isStartSQL = true;
                            checkConnect = false;
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
