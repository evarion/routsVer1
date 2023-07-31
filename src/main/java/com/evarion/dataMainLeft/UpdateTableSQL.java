package com.evarion.dataBaseRequest;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.evarion.dataBaseRequest.DataDeliveryMain.configConnectionSQL;


public class UpdateTableSQL {
    static String valueClicked = "";
    static String valueEdit = "";

    public static void updateTableEnter(final JTable table) {


        table.getModel().addTableModelListener(
                new TableModelListener() {
                    public void tableChanged(TableModelEvent evt) {
                        Connection connection;

                        int col = evt.getColumn();
                        int row = evt.getLastRow();
                        Object value;
                        String header;
                        value = table.getValueAt(row, col);
                        header = table.getColumnName(col);

                        valueEdit = value.toString();
                        System.out.println("tableChanged = col = " + col + " row = " + row + " значение = " + value + " заголовок = " + header);
                        // here goes your code "on cell update"
                        if (!valueClicked.equals(valueEdit)) {
                            try {
                                connection = DriverManager.getConnection(configConnectionSQL.getJdbcUrl(), configConnectionSQL.getLogin(),
                                        configConnectionSQL.getPassword());
                                // String sql = "UPDATE  delivery SET  country_id = '" + 1 + "' WHERE id = " + row;
                                // String sql = "UPDATE " + header + " SET " +header +" = '" +value+"' WHERE id = " +row;
                                // System.out.println("запрос = "+sql);
                                Statement statement = connection.createStatement();
                                // statement.executeQuery(sql);
                                System.out.println("было изменение");
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
    }

    public static void updTable(final JTable jTable1) {
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int row = jTable1.rowAtPoint(e.getPoint());
                int col = jTable1.columnAtPoint(e.getPoint());
                Object value;
                if (row >= 0 && col >= 0) {
                    System.out.println("mousePressed col = " + col + " " + "mousePressed row = " + row);
                    value = jTable1.getValueAt(row, col);
                    System.out.println("значение mousePressed = " + value.toString());
                }
            }
        });
    }

    public static void updateTable(final JTable jTable) {
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable.rowAtPoint(evt.getPoint());
                int col = jTable.columnAtPoint(evt.getPoint());
                Object value;
                if (row >= 0 && col >= 0) {
                    System.out.println("updateTable col = " + col + " " + "updateTable row = " + row);
                    value = jTable.getValueAt(row, col);
                    valueClicked = value.toString();//для сравнения
                    System.out.println("значение = " + value.toString());
                }
            }
        });
    }
}


