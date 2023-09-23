package com.evarion.gui;


import com.evarion.dataRightBotton.DataDeliveryRBottom;
import javax.swing.*;
import java.awt.*;

public class DataTableRBottom extends JFrame {
    public static DataDeliveryRBottom  dataDeliveryRBottom = new DataDeliveryRBottom();
    public static JTable dataJTableRBottom = new JTable();
    public static Box contents = new Box(BoxLayout.Y_AXIS);

    public static Box constructDataTable(int value){
        DataDeliveryRBottom.runRightBottomDataSQL(value);
        dataDeliveryRBottom.addAction();

        FrameMain.jVisiblePanelDataRBottom.setLayout(new BorderLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty=100;

        contents.add(new JScrollPane(dataJTableRBottom));

        dataJTableRBottom.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        return contents;
    }

}
