package com.evarion.gui;

import com.evarion.Main;

import javax.swing.*;
import java.awt.*;


public class MainSetupDialog {
    JPanel panelLeft = new JPanel();
    JPanel panelRight = new JPanel();

    JLabel onePar = new JLabel("первый параметр");
    JTextArea oneParInputTA = new JTextArea();
    JButton oneBtnOk = new JButton("OK");

    JLabel oneParR = new JLabel("первый параметр");
    JTextArea oneParInputTAR = new JTextArea();
    JButton oneBtnOkR = new JButton("OK");

    MainSetupDialog(JDialog jDialog) {
        constructJDialog(jDialog);
    }

    public static void testDialogSET() {
        //FrameMain.jDialogSetup.setLocationRelativeTo(FrameMain.mainPanel);//расположение по центру
        FrameMain.jDialogSetup.setLocation(Main.getLocMainFormX(), Main.getLocMainFormY());
        FrameMain.jDialogSetup.setMinimumSize(new Dimension(Main.getSizeFormW(), Main.getSizeFormH()));
        FrameMain.jDialogSetup.pack();
        FrameMain.jDialogSetup.setVisible(true);
    }

    public void constructJDialog(JDialog jDialog) {
        jDialog.setAlwaysOnTop(true);
        jDialog.setLayout(new GridBagLayout());

        constructPanelDialogLeft();
        constructPanelDialogRight();

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.WEST;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weighty = 1;
        constraints.weightx = 0.5;
        panelLeft.setBackground(Color.magenta);
        jDialog.add(panelLeft, constraints);


        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weighty = 1;
        constraints.weightx = 0.5;
        panelRight.setBackground(Color.orange);
        jDialog.add(panelRight, constraints);


    }

    private void constructPanelDialogLeft() {
        JPanel jPanelEmpty = new JPanel();
        JPanel jPanelEmpty1 = new JPanel();
        JPanel jPanelEmpty2 = new JPanel();


        panelLeft.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelLeft.add(onePar, constraints);

        jPanelEmpty.setPreferredSize(new Dimension(10, 20));
        constraints.gridx = 1;
        constraints.gridy = 0;
        jPanelEmpty.setBackground(Color.magenta);
        panelLeft.add(jPanelEmpty, constraints);

        oneParInputTA.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 2;
        constraints.gridy = 0;
        panelLeft.add(oneParInputTA, constraints);

        jPanelEmpty1.setPreferredSize(new Dimension(10, 20));
        constraints.gridx = 3;
        constraints.gridy = 0;
        panelLeft.add(jPanelEmpty1, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        panelLeft.add(oneBtnOk, constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        jPanelEmpty2.setBackground(Color.cyan);
        panelLeft.add(jPanelEmpty2, constraints);

    }

    private void constructPanelDialogRight() {
        JPanel jPanelEmpty = new JPanel();
        JPanel jPanelEmpty1 = new JPanel();
        JPanel jPanelEmpty2 = new JPanel();


        panelRight.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        constraints.gridx = 0;
        constraints.gridy = 0;
        panelRight.add(oneParR, constraints);

        jPanelEmpty.setPreferredSize(new Dimension(10, 20));
        constraints.gridx = 1;
        constraints.gridy = 0;
        jPanelEmpty.setBackground(Color.magenta);
        panelRight.add(jPanelEmpty, constraints);

        oneParInputTAR.setPreferredSize(new Dimension(100, 20));
        constraints.gridx = 2;
        constraints.gridy = 0;
        panelRight.add(oneParInputTAR, constraints);

        jPanelEmpty1.setPreferredSize(new Dimension(10, 20));
        constraints.gridx = 3;
        constraints.gridy = 0;
        panelRight.add(jPanelEmpty1, constraints);

        constraints.gridx = 4;
        constraints.gridy = 0;
        panelRight.add(oneBtnOkR, constraints);

        constraints.gridx = 5;
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        jPanelEmpty2.setBackground(Color.cyan);
        panelRight.add(jPanelEmpty2, constraints);
    }
}

