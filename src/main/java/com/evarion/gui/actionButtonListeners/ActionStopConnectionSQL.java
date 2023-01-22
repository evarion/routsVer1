package com.evarion.gui.actionButtonListeners;

import com.evarion.dataBase.ConnectionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionStopConnectionSQL implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConnectionManager.stopConnectionSQL();
    }
}
