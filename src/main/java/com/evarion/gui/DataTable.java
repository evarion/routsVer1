package com.evarion.gui;

import com.evarion.dataBaseRequest.RequestDataBase;

import javax.swing.*;
import java.awt.*;


public class DataTable extends JFrame {
    public static Box constructDataTable() {
        RequestDataBase requestDataBase = new RequestDataBase();
        JTable table1 = new JTable(requestDataBase);

        requestDataBase.addData();

        FrameMain.jVisiblePanelDataLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = 100; //ok

        Box contents = new Box(BoxLayout.Y_AXIS);


        contents.add(new JScrollPane(table1));

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return contents;
    }
}
