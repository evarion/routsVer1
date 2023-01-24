package com.evarion.gui.actionButtonListeners;

import com.evarion.dataBase.ConnectionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionStartStopConnectionSQL implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ConnectionManager.isStartSQL) {
            ConnectionManager.startConnectionSQL();
            ConnectionManager.isStartSQL = true;
        } else {
            ConnectionManager.stopConnectionSQL();
            ConnectionManager.isStartSQL = false;
        }
    }
}
