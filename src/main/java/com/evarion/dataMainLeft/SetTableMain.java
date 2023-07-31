package com.evarion.dataMainLeft;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static com.evarion.dataMainLeft.DataDeliveryMain.configConnectionSQL;


public class SetTableMain {
    public void setBoxCellColumn(JTable jTable) {
        Connection connection;
        TableColumn sportColumn = jTable.getColumnModel().getColumn(2);
        JComboBox<String> comboBox = new JComboBox<>();
        //String result = "";
        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
            String sql = "SELECT country FROM country";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String country = resultSet.getString("country");
                // получение содержимого строк
                comboBox.addItem(country);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        sportColumn.setCellEditor(new DefaultCellEditor(comboBox));

    }


}
