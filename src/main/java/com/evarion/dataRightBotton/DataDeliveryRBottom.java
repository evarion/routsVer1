package com.evarion.dataRightBotton;

import com.evarion.dataBaseConfig.ConfigConnectionSQL;
//import com.evarion.dataMainLeft.SetTableMain;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
import static com.evarion.gui.DataTableRBottom.dataJTableRBottomBudgetExpenses; //
import static com.evarion.gui.DataTableRBottom.dataJTableRBottomBudgetProfit;


public class DataDeliveryRBottom {
    static ConfigConnectionSQL configConnectionSQL = new ConfigConnectionSQL();
    //static SetTableMain setTableMain = new SetTableMain();
    static Vector<String> columnNames = new Vector<>();
    static Vector<Vector<Object>> data = new Vector<>();
    static Vector<String> columnNamesExpenses = new Vector<>();
    static Vector<Vector<Object>> dataExpenses = new Vector<>();

    public void addAction() {
        // SelectRowAction.selectRow(dataJTableRBottom); //ОШИБКА  ИСПРАВИТЬ образец из selectRowActionMainData.selectRowNew(dataJTableMain);
    }


    public static void runRightBottomDataSQL(int value) {
        data.clear();
        Connection connection;
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
            System.out.println("ошибка " + e.getMessage());
        }

        dataJTableRBottomBudgetProfit = new JTable(data, columnNames);
        //table1.setAutoCreateRowSorter (true); //сортировка
        TableColumn column;
        for (int i = 0; i < dataJTableRBottomBudgetProfit.getColumnCount(); i++) {
            column = dataJTableRBottomBudgetProfit.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
            column.setPreferredWidth(110);//ширина колонок
        }
        dataJTableRBottomBudgetProfit.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //updateTable();

        for (int column1 = 0; column1 < dataJTableRBottomBudgetProfit.getColumnCount(); column1++) {
            TableColumn tableColumn = dataJTableRBottomBudgetProfit.getColumnModel().getColumn(column1);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < dataJTableRBottomBudgetProfit.getRowCount(); row++) {
                TableCellRenderer cellRenderer = dataJTableRBottomBudgetProfit.getCellRenderer(row, column1);
                Component c = dataJTableRBottomBudgetProfit.prepareRenderer(cellRenderer, row, column1);
                int width = c.getPreferredSize().width + dataJTableRBottomBudgetProfit.getIntercellSpacing().width;

                preferredWidth = Math.max(preferredWidth, width);
                //  We've exceeded the maximum width, no need to check other rows
                if (preferredWidth >= maxWidth) {
                    //preferredWidth = maxWidth;
                    break;
                }
            }
            settingColourHeader();
        }
    }


    public static void runRightBottomDataSQLBudgetExpenses(int value) {
        dataExpenses.clear();
        Connection connection;
        try {
            connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                    configConnectionSQL.getPassword());
            // String sql = "SELECT * FROM delivery";
            String sql = "SELECT * FROM budgetexpenses WHERE fk_delivery = " + value + "\n";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNamesExpenses.addElement(metaData.getColumnName(i));
            }
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                dataExpenses.addElement(row);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("ошибка " + e.getMessage());
        }

        dataJTableRBottomBudgetExpenses = new JTable(dataExpenses, columnNamesExpenses);
        //table1.setAutoCreateRowSorter (true); //сортировка
        TableColumn column;
        for (int i = 0; i < dataJTableRBottomBudgetExpenses.getColumnCount(); i++) {
            column = dataJTableRBottomBudgetExpenses.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
            column.setPreferredWidth(110);//ширина колонок
        }
        dataJTableRBottomBudgetExpenses.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //updateTable();

        for (int column1 = 0; column1 < dataJTableRBottomBudgetExpenses.getColumnCount(); column1++) {
            TableColumn tableColumn = dataJTableRBottomBudgetExpenses.getColumnModel().getColumn(column1);
            int preferredWidth = tableColumn.getMinWidth();
            int maxWidth = tableColumn.getMaxWidth();

            for (int row = 0; row < dataJTableRBottomBudgetExpenses.getRowCount(); row++) {
                TableCellRenderer cellRenderer = dataJTableRBottomBudgetExpenses.getCellRenderer(row, column1);
                Component c = dataJTableRBottomBudgetExpenses.prepareRenderer(cellRenderer, row, column1);
                int width = c.getPreferredSize().width + dataJTableRBottomBudgetExpenses.getIntercellSpacing().width;

                preferredWidth = Math.max(preferredWidth, width);
                //  We've exceeded the maximum width, no need to check other rows
                if (preferredWidth >= maxWidth) {
                    //preferredWidth = maxWidth;
                    break;
                }
            }
            settingColourHeaderExpenses();
        }
    }


    public static void settingColourHeader() {
        dataJTableRBottomBudgetProfit.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        dataJTableRBottomBudgetProfit.getTableHeader().setBackground(Color.GREEN.darker());
    }

    public static void settingColourHeaderExpenses() {
        dataJTableRBottomBudgetExpenses.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        dataJTableRBottomBudgetExpenses.getTableHeader().setBackground(Color.RED);
    }
}

