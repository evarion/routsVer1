package com.evarion.dataMainLeft;

import com.evarion.dataRightBotton.DataDeliveryRBottom;
import com.evarion.gui.DataTableRBottom;

import javax.swing.*;


public class SelectRowActionMainData {
    public static int result; //переделать на геттер

    public void selectRow(final JTable jTable1) {

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


            }
        });
    }
}
