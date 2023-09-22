package com.evarion.dataRightBotton;

import javax.swing.*;

public class SelectRowAction { //
    public static void selectRow(final JTable jTable1) {
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int column = 0;
                for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                    String nameColumn = jTable1.getModel().getColumnName(i);
                    if (nameColumn.equals("fk_delivery")) {
                        column = i;
                        int row = jTable1.getSelectedRow();
                        String value = jTable1.getModel().getValueAt(row, column).toString();
                        System.out.println("id выбрана строка = " + value);
                    }
                }

            }
        });
    }
}
