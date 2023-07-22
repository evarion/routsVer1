package com.evarion.dataBaseRequest;


import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import static com.evarion.dataBaseRequest.DeliveryWork1.configConnectionSQL;
import static com.evarion.gui.DataTable.table1;

public class DataDeliveryTest {

    public void runDataSQL() {
        Connection connection = null;
        Vector columnNames = new Vector();
        Vector data = new Vector();


        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
            String sql = "SELECT * FROM delivery";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        table1 = new JTable(data, columnNames);


        TableColumn column;
        for (int i = 0; i < table1.getColumnCount(); i++) {
            column = table1.getColumnModel().getColumn(i);

            column.setMaxWidth(250);
            column.setPreferredWidth(110);//ширина колонок
        }

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int column1 = 0; column1 < table1.getColumnCount(); column1++) {
            TableColumn tableColumn = table1.getColumnModel().getColumn(column1);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < table1.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table1.getCellRenderer(row, column1);
                Component c = table1.prepareRenderer(cellRenderer, row, column1);
                int width = c.getPreferredSize().width + table1.getIntercellSpacing().width;

                preferredWidth = Math.max(preferredWidth, width);

                //  We've exceeded the maximum width, no need to check other rows

                if (preferredWidth >= maxWidth) {
                    //preferredWidth = maxWidth;
                    break;
                }
            }
            TableColumnModel tcm = table1.getColumnModel();//ширина колонок
            tcm.getColumn(0).setPreferredWidth(60);
            tcm.getColumn(0).setHeaderValue("НОМЕР");
            tcm.getColumn(1).setPreferredWidth(100);
            tcm.getColumn(1).setHeaderValue("КОНТЕЙНЕР");
            tcm.getColumn(2).setPreferredWidth(100);
            tcm.getColumn(2).setHeaderValue("ЛИНИЯ");
            tcm.getColumn(3).setPreferredWidth(100);
            tcm.getColumn(3).setHeaderValue("СУДНО");
            tcm.getColumn(4).setPreferredWidth(100);
            tcm.getColumn(4).setHeaderValue("ПОРТ");
            tcm.getColumn(5).setPreferredWidth(100);
            tcm.getColumn(5).setHeaderValue("ГРУЗ");
            tcm.getColumn(6).setPreferredWidth(140);
            tcm.getColumn(6).setHeaderValue("ЭКСПОРТ/ИМПОРТ");
            tcm.getColumn(7).setPreferredWidth(100);
            tcm.getColumn(7).setHeaderValue("СТРАНА");
            tcm.getColumn(8).setPreferredWidth(100);
            tcm.getColumn(8).setHeaderValue("СТАТУС");
            tcm.getColumn(9).setPreferredWidth(140);
            tcm.getColumn(9).setHeaderValue("ТИП КОНТЕЙНЕРА");
            tcm.getColumn(10).setPreferredWidth(140);
            tcm.getColumn(10).setHeaderValue("РАЗМЕР КОНТЕЙНЕРА");

            //tableColumn.setPreferredWidth( preferredWidth );
        }
    }

}