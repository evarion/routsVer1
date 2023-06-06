package com.evarion.gui.actionButtonListeners;



import com.evarion.dataBase.ConfigConnectionSQL;
import com.evarion.liquibase.CheckTableInDataBase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionCheckTablesSQL implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
            ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
            CheckTableInDataBase checkTable = new CheckTableInDataBase(configConnectionSQL.getJdbcUrl(),configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
            checkTable.runCheck();
    }
}
