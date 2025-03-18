package com.evarion.dataMainLeft;

import com.evarion.dataRightBotton.DataDeliveryRBottom;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static com.evarion.gui.DataPanel.dataSplitPaneHorizontal;


public class SelectRowActionMainData {
    public static int result; //переделать на геттер

    public void selectRow(final JTable jTable1) {//only mouse
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int column;
                for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                    String nameColumn = jTable1.getModel().getColumnName(i);
                    if (nameColumn.equals("id")) {
                        column = i;
                        int row = jTable1.getSelectedRow();
                        String value = jTable1.getModel().getValueAt(row, column).toString();
                        System.out.println("id выбрана строка = " + value);
                        result = Integer.parseInt(value);
                        DataDeliveryRBottom.runRightBottomDataSQL(result);
                    }
                }
                //  DataPanel.dataRightBottom.setVisible(false);
                dataSplitPaneHorizontal.updateUI(); //ok
            }
        });
    }

    public void selectTest(final JTable jTable) {

    }

    public void selRowKeyboardMouse(final JTable jTable) {
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jTable.rowAtPoint(e.getPoint());
                int col = jTable.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println("Mouse selected cell: (" + row + ", " + col + ")");
                }
            }
        });
    }

    public void selectRowNew(final JTable jTable1) {// mouse and keyboard
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int column;
                for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                    String nameColumn = jTable1.getModel().getColumnName(i);
                    if (nameColumn.equals("id")) {
                        column = i;
                        int row = jTable1.getSelectedRow();
                        String value = jTable1.getModel().getValueAt(row, column).toString();

                        result = Integer.parseInt(value);
                        DataDeliveryRBottom.runRightBottomDataSQL(result);
                        DataDeliveryRBottom.runRightBottomDataSQLBudgetExpenses(result);
                        System.out.println("id выбрана строка из нового метода = " + value);
                    }
                }
                dataSplitPaneHorizontal.updateUI(); //ok
                // do some actions here, for example
                // print first column value from selected row
                // System.out.println("из нового метода " + jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            }
        });
    }

    public void newSelectTest1(final JTable jTable1) {
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) { // Игнорируем промежуточные события
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) { // Проверяем, что строка выделена
                        System.out.println("Selected row: " + selectedRow);
                        for (int column = 0; column < jTable1.getColumnCount(); column++) {
                            Object value = jTable1.getValueAt(selectedRow, column);
                            System.out.println("Column " + column + ": " + value);
                        }
                    }
                }
            }
        });
    }
}

