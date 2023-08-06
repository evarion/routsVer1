package com.evarion.library.librarySqlJTableRequesst;

import com.evarion.dataBaseConfig.ConfigConnectionSQL;
import com.evarion.gui.DataTableLMain;


import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class RequestSQL {
    Connection connection;
    ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();

    public void requestSql() {
        connection = null;
        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create a addData connection", e);
        }


        String sql = "SELECT * FROM delivery";
        try{
            PreparedStatement pwt = connection.prepareStatement(sql);
            ResultSet rs  = pwt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) DataTableLMain.dataJTableMain.getModel();

            while (rs.next()){
            model.addRow(new String[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
            });
            }


        }catch (Exception ex){
            System.out.println("ERROR "+ ex.getMessage());
        }
    }
}
