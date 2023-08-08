package com.evarion.gui;

import com.evarion.Main;

import javax.swing.*;
import java.awt.*;


public class MainSetupDialog {
    public static void testDialogSET() {
        //FrameMain.jDialogSetup.setLocationRelativeTo(FrameMain.mainPanel);//расположение по центру
        FrameMain.jDialogSetup.setLocation(Main.getLocMainFormX(), Main.getLocMainFormY());
        FrameMain.jDialogSetup.setMinimumSize(new Dimension(Main.getSizeFormW(), Main.getSizeFormH()));
        FrameMain.jDialogSetup.pack();
        FrameMain.jDialogSetup.setVisible(true);
    }


    public static void constructJDialog(JDialog jDialog) {
        jDialog.setAlwaysOnTop(true);

        JPanel jPanelEmpty = new JPanel();
        JPanel jPanelEmpty1 = new JPanel();
        JLabel onePar = new JLabel("первый параметр");
        JTextArea oneParInputTA = new JTextArea();
        JButton oneBtnOk = new JButton("OK");
        oneParInputTA.setPreferredSize(new Dimension(100, 20));


        JPanel pan = new JPanel();
        pan.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        pan.add(onePar, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        jPanelEmpty.setPreferredSize(new Dimension(10, 20));
        pan.add(jPanelEmpty, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        pan.add(oneParInputTA, constraints);

        constraints.gridx = 3;
        constraints.gridy = 0;
        jPanelEmpty1.setPreferredSize(new Dimension(10, 20));
        pan.add(jPanelEmpty1, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        pan.add(oneBtnOk, constraints);

        jDialog.add(pan);

    }
}

