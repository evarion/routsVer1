package com.evarion.gui;

import javax.swing.*;

import java.awt.*;

import static com.evarion.gui.FrameMain.menuDownInfoJP0;

public class InfoPanel extends JFrame {


    public static void createInfoPanel() {
        JPanel jPanelEmpty = new JPanel();
        menuDownInfoJP0.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weighty = GridBagConstraints.NONE;
        jPanelEmpty.setPreferredSize(new Dimension(30, 30));
        jPanelEmpty.setMinimumSize(new Dimension(30, 30));
        jPanelEmpty.setBackground(Color.gray);
        menuDownInfoJP0.add(jPanelEmpty);
    }
}