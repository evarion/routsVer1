package com.evarion.libraryArchive.CheckConnection;

import com.evarion.libraryArchive.CheckConnection.ConnectionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionStartStopConnectionSQL implements ActionListener {
    public static boolean stopManualConnection=false;//ForCheckConnectionSQL

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!ConnectionManager.isStartSQL) {
            //ConnectionManager.startConnectionSQL();
            ConnectionManager.isStartSQL = true;
            stopManualConnection=false;
        } else {
            //ConnectionManager.stopConnectionSQL();
            ConnectionManager.isStartSQL = false;
            stopManualConnection=true;

        }
    }
}
