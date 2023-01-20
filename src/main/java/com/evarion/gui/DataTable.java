package com.evarion.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class DataTable extends JFrame {

    // Данные для таблиц
    private static Object[][] array = new String[][]{
            {"1", "MEDU1329432", "SPB", "20.02.22", "24.02.22", "MSC ATLANTIC", "NEW YORK"},
            {"2", "MEDU1323116", "SPB", "20.02.22", "24.02.22", "MSC ATLANTIC", "NEW YORK"},
            {"3", "MEDU3452217", "SPB", "22.02.22", "25.02.22", "VLADIMIR", "NEW YORK"},
            {"4", "MEDU3452223", "SPB", "25.02.22", "26.02.22", "MSC SHENON", "NANT"}
    };


    // Заголовки столбцов
    private static Object[] columnsHeader = new String[]{"NUM", "CONTAINER", "POL", "ATA POL", "ATD POL", "VESSEL", "POD"};

    public static Box constructDataTable() {
        JTable table1 = new JTable(array, columnsHeader);

        FrameMain.jVisiblePanelDataLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 100; //ok

        //constraints.anchor = GridBagConstraints.NORTH;//ok


        // Данные для таблицы на основе Vector
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        // Вектор с заголовками столбцов
        Vector<String> header = new Vector<String>();


        // Формирование в цикле массива данных
        for (int j = 0; j < array.length; j++) {
            header.add((String) columnsHeader[j]);
            Vector<String> row = new Vector<String>();
            for (int i = 0; i < array[j].length; i++) {
                row.add((String) array[j][i]);
            }
            data.add(row);
        }

        Box contents = new Box(BoxLayout.Y_AXIS);

        contents.add(new JScrollPane(table1));

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return contents;
    }
}
