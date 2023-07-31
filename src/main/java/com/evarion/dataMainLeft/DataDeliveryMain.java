package com.evarion.dataBaseRequest;

import com.evarion.dataBaseConfig.ConfigConnectionSQL;

import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.*;

import static com.evarion.dataMainLeft.DataTable.table1;

public class DataDeliveryMain {
    static ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
    SetTableMain setTableMain= new SetTableMain();


    public void runMainDataSQL() {
        Connection connection;
        Vector<String> columnNames = new Vector<>();
        Vector<Vector<Object>> data = new Vector<>();
      //  setTableMain.stopEditJTable(table1);

        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
            // String sql = "SELECT * FROM delivery";
            String sql = "SELECT delivery.id, delivery.container, country.country, cargo.cargo, \n" +
                    "exportimport.exportimport,sizeconteiner.sizeconteiner, typeconteiner.typeconteiner, port.port," +
                    " sealine.nameline,\n" + "status.status, vessel.vessel \n" +
                    "\n" +
                    "FROM delivery \n" +
                    "JOIN country \n" +
                    "ON delivery.country_id=country.id\n" +
                    "JOIN cargo \n" +
                    "ON delivery.cargo_id=cargo.id\n" +
                    "JOIN exportimport \n" +
                    "ON delivery.exportimport_id=exportimport.id\n" +
                    "JOIN port \n" +
                    "ON delivery.port_id=port.id\n" +
                    "JOIN sealine \n" +
                    "ON delivery.line_id=sealine.id\n" +
                    "JOIN sizeconteiner \n" +
                    "ON delivery.sizeconteiner_id=sizeconteiner.id\n" +
                    "JOIN status \n" +
                    "ON delivery.status_id=status.id\n" +
                    "JOIN typeconteiner \n" +
                    "ON delivery.typeconteiner_id=typeconteiner.id\n" +
                    "JOIN vessel \n" +
                    "ON delivery.vessel_id=vessel.id";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        table1 = new JTable(data, columnNames);
        //table1.setAutoCreateRowSorter (true); //сортировка
        TableColumn column;
        for (int i = 0; i < table1.getColumnCount(); i++) {
            column = table1.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
            column.setPreferredWidth(110);//ширина колонок
        }
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //updateTable();

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
            settingColumn(tcm);
            settingColourHeader();

            setTableMain.setBoxCellColumn(table1);
            //tableColumn.setPreferredWidth( preferredWidth );
        }
        UpdateTableSQL.updateTableEnter(table1);
        UpdateTableSQL.updateTable(table1);
       // UpdateTableSQL.updTable(table1);


    }


    public void settingColumn(TableColumnModel tcm) {
        for (int i = 0; i < table1.getColumnCount(); i++) {
            if (tcm.getColumn(i).getHeaderValue().equals("container")) {
                tcm.getColumn(i).setHeaderValue("КОНТЕЙНЕР");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("id")) {
                tcm.getColumn(i).setHeaderValue("№");
                tcm.getColumn(i).setPreferredWidth(40);
            }
            if (tcm.getColumn(i).getHeaderValue().equals("nameline")) {
                tcm.getColumn(i).setHeaderValue("ЛИНИЯ");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("vessel")) {
                tcm.getColumn(i).setHeaderValue("СУДНО");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("port")) {
                tcm.getColumn(i).setHeaderValue("ПОРТ");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("cargo")) {
                tcm.getColumn(i).setHeaderValue("ГРУЗ");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("exportimport")) {
                tcm.getColumn(i).setHeaderValue("ЭКСПОРТ/ИМПОРТ");
                tcm.getColumn(i).setPreferredWidth(160);
            }
            if (tcm.getColumn(i).getHeaderValue().equals("country")) {
                tcm.getColumn(i).setHeaderValue("СТРАНА");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("status")) {
                tcm.getColumn(i).setHeaderValue("СТАТУС");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("typeconteiner")) {
                tcm.getColumn(i).setHeaderValue("ТИП КНТР");
            }
            if (tcm.getColumn(i).getHeaderValue().equals("sizeconteiner")) {
                tcm.getColumn(i).setHeaderValue("РАЗМЕР КНТР");
            }
        }
    }

    public void settingColourHeader() {
        table1.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table1.getTableHeader().setBackground(Color.ORANGE);
    }



}


