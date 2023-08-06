package com.evarion.gui;

import com.evarion.dataRightTop.DataDeliveryRTop;
import javax.swing.*;
import java.awt.*;

public class DataTableRTop {
    public static JTable dataJTableRTop = new JTable();

    public static Box constructDataTable(){
        DataDeliveryRTop dataDeliveryRTop = new DataDeliveryRTop();
        dataDeliveryRTop.runRightTopDataSQL();

        FrameMain.jVisiblePanelDataRBTop.setLayout(new BorderLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty=100;

        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(dataJTableRTop));

        dataJTableRTop.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return contents;
    }
}
