package com.evarion.gui;

import javax.swing.*;
import java.awt.*;



public class InfoPanel extends JFrame {

    public InfoPanel()  {
    }

    public static void createInfoPanel() {
        JPanel jPanelEmpty = new JPanel();
        FrameMain.menuDownInfoJP0.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = GridBagConstraints.NONE;
        jPanelEmpty.setPreferredSize(new Dimension(30, 30));
        jPanelEmpty.setMinimumSize(new Dimension(30, 30));
        jPanelEmpty.setBackground(Color.gray);
        FrameMain.menuDownInfoJP0.add(jPanelEmpty);
    }
}