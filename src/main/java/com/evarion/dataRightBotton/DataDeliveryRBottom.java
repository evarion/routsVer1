package com.evarion.dataRightBotton;

import com.evarion.dataBaseConfig.ConfigConnectionSQL;
import com.evarion.dataMainLeft.SetTableMain;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import static com.evarion.gui.DataTableRBottom.dataJTableRBottom; //

public class DataDeliveryRBottom {
    static ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
    static SetTableMain setTableMain = new SetTableMain();
    static Vector<String> columnNames = new Vector<>();
    static Vector<Vector<Object>> data = new Vector<>();

    public void addAction() {
       // SelectRowAction.selectRow(dataJTableRBottom); //ОШИБКА  ИСПРАВИТЬ
    }


    public static void runRightBottomDataSQL(int value) {
        data.clear();
        //int value =2;
        Connection connection;

        //  setTableMain.stopEditJTable(table1);

        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
            // String sql = "SELECT * FROM delivery";
            String sql = "SELECT * FROM budgeteprofitmain WHERE fk_delivery = " + value + "\n";

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
            connection.close();
        } catch (Exception e) {
            System.out.println("ошибка "+e.getMessage());
        }

        dataJTableRBottom = new JTable(data, columnNames);
        //table1.setAutoCreateRowSorter (true); //сортировка
        TableColumn column;
        for (int i = 0; i < dataJTableRBottom.getColumnCount(); i++) {
            column = dataJTableRBottom.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
            column.setPreferredWidth(110);//ширина колонок
        }
        dataJTableRBottom.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //updateTable();

        for (int column1 = 0; column1 < dataJTableRBottom.getColumnCount(); column1++) {
            TableColumn tableColumn = dataJTableRBottom.getColumnModel().getColumn(column1);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < dataJTableRBottom.getRowCount(); row++) {
                TableCellRenderer cellRenderer = dataJTableRBottom.getCellRenderer(row, column1);
                Component c = dataJTableRBottom.prepareRenderer(cellRenderer, row, column1);
                int width = c.getPreferredSize().width + dataJTableRBottom.getIntercellSpacing().width;

                preferredWidth = Math.max(preferredWidth, width);
                //  We've exceeded the maximum width, no need to check other rows
                if (preferredWidth >= maxWidth) {
                    //preferredWidth = maxWidth;
                    break;
                }
            }

            //  TableColumnModel tcm = dataJTableRBottom.getColumnModel();//ширина колонок
            //settingColumn(tcm);
            settingColourHeader();
          //  setTableMain.setBoxCellColumn(dataJTableRBottom);
            //tableColumn.setPreferredWidth( preferredWidth );
        }
        // UpdateTableSQL.updateTableEnter(dataJTableRBottom);
        //  UpdateTableSQL.updateTable(dataJTableRBottom);
        // UpdateTableSQL.updTable(table1);
       // dataSplitPaneHorizontal.updateUI(); //ok
    }

/*
    public void settingColumn(TableColumnModel tcm) {
        for (int i = 0; i < dataJTableRBottom.getColumnCount(); i++) {
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

 */

    public static void settingColourHeader() {
        dataJTableRBottom.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        dataJTableRBottom.getTableHeader().setBackground(Color.ORANGE);
    }
}

