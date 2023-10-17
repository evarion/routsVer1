package com.evarion.dataMainLeft;

import com.evarion.dataRightBotton.DataDeliveryRBottom;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    public void selectTest(final JTable jTable){

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
                        System.out.println("id выбрана строка из нового метода = " + value);
                        result = Integer.parseInt(value);
                        DataDeliveryRBottom.runRightBottomDataSQL(result);
                    }
                }
                dataSplitPaneHorizontal.updateUI(); //ok
                // do some actions here, for example
                // print first column value from selected row
                // System.out.println("из нового метода " + jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
            }
        });
    }
}
