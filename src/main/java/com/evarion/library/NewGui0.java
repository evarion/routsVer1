package com.evarion.library;

import javax.swing.*;
import java.awt.*;

public class NewGui0 {



    public static void  createPanel(Container container) {
        container.setLayout(new GridBagLayout());
        JPanel jPanelLeft = new JPanel();

        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        jPanelLeft.setBackground(Color.ORANGE);
        container.add(jPanelLeft, constraints1);


    }

    public static void main(String[] args) {
        // Создание окна
        JFrame frame = new JFrame("GridBagLayoutTest");
        frame.setMinimumSize(new Dimension(1600, 900));
        frame.setLocation(200, 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Определить панель содержания
        createPanel(frame.getContentPane());

        // Показать окно
        frame.pack();
        frame.setVisible(true);
    }
}
