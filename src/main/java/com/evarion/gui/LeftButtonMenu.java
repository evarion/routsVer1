package com.evarion.gui;

import javax.swing.*;
import java.awt.*;


public class LeftButtonMenu extends JFrame {

    static JPanel jPanelLogo = new JPanel();
    static JLabel logo = new JLabel("LOGO");
    static JButton[] buttonsLeftMenu = new JButton[8];


    public static void createLeftButtonPanel() {
        FrameMain.menuLeftJP0.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.weighty = 0.001;

        constraints.ipady = 30;
        constraints.insets.top = 10;
        constraints.insets.left = 10;//ok
        constraints.insets.right = 10;//ok

        logo.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));
        jPanelLogo.setPreferredSize(new Dimension(100, 70));
        jPanelLogo.setMinimumSize(new Dimension(100, 70));

        constraints.gridx = 0;
        constraints.gridy = 1;

        jPanelLogo.add(logo);
        FrameMain.menuLeftJP0.add(jPanelLogo, constraints);
        constraints.insets.top = 2;


        for (int i = 0; i < buttonsLeftMenu.length; i++) {
            buttonsLeftMenu[i] = new JButton();
            buttonsLeftMenu[i].setName("jButtonLeft" + i);
            buttonsLeftMenu[i].setText("Text");
            buttonsLeftMenu[i].setPreferredSize(new Dimension(100, 60));
            buttonsLeftMenu[i].setMinimumSize(new Dimension(100, 20));
        }

        int numY = 2;
        for (JButton jButton : buttonsLeftMenu) {
            constraints.gridy = numY;
            constraints.gridx = 0;
            numY++;
            FrameMain.menuLeftJP0.add(jButton, constraints);
        }
    }
}