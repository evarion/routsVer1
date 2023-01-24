package com.evarion.gui.actionButtonListeners;

import com.evarion.dataBase.DataBase;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCreateTableSQL implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        DataBase.createDefaultTables();
    }
}
