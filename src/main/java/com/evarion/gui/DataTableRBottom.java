package com.evarion.gui;

import com.evarion.dataRightBotton.DataDeliveryRBottom;
import javax.swing.*;
import java.awt.*;

public class DataTableRBottom extends JFrame {
    public static JTable dataJTableRBottom = new JTable();

    public static Box constructDataTable(){
        DataDeliveryRBottom  dataDeliveryRBottom = new DataDeliveryRBottom();
        dataDeliveryRBottom.runRightBottomDataSQL();

        FrameMain.jVisiblePanelDataRBottom.setLayout(new BorderLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty=100;


        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(dataJTableRBottom));


        dataJTableRBottom.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return contents;
    }
}