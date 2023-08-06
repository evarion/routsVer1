package com.evarion.gui;

import com.evarion.dataMainLeft.DataDeliveryMain;
import javax.swing.*;
import java.awt.*;


public class DataTableLMain extends JFrame {
    public static JTable dataJTableMain = new JTable();


    public static Box constructDataTable() {
        DataDeliveryMain dataDeliveryMain = new DataDeliveryMain();
        dataDeliveryMain.runMainDataSQL();

        FrameMain.jVisiblePanelDataLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 100; //ok

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(dataJTableMain));

        dataJTableMain.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return contents;
    }
}


