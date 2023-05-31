package com.evarion.gui.actionButtonListeners;



import com.evarion.dataBase.ConfigConnectionSQL;
import com.evarion.liquibase.CheckTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCheckTablesSQL implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
            ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
            CheckTable checkTable = new CheckTable(configConnectionSQL.getJdbcUrl(),configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
            checkTable.runCheck();
    }
}
