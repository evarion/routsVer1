package com.evarion.dataMainLeft;

import com.evarion.gui.FrameMain;

import javax.swing.*;
import java.awt.*;


public class DataTable extends JFrame {
    public static JTable table1 = new JTable(

    );


    public static Box constructDataTable() {
        DataDeliveryMain dataDeliveryMain = new DataDeliveryMain();
        dataDeliveryMain.runMainDataSQL();

        FrameMain.jVisiblePanelDataLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 100; //ok

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(table1));

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return contents;
    }
}

