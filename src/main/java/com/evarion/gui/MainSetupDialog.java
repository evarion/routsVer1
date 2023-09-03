package com.evarion.gui;

import com.evarion.Main;
import javax.swing.*;
import java.awt.*;


public class MainSetupDialog {
    JPanel panelLeft = new JPanel();
    JPanel panelRight = new JPanel();


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
        panelLeft.setBackground(Color.GRAY.brighter());
        jDialog.add(new JScrollPane(panelLeft), constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weighty = 1;
        constraints.weightx = 0.5;
        panelRight.setBackground(Color.GRAY.brighter());
        jDialog.add(new JScrollPane(panelRight), constraints);
    }

    private void constructPanelDialogLeft() {
        int countElement = 20;
        JButton[] buttonParameterLeft = new JButton[countElement];
        JLabel[] jLabelsParameterLeft = new JLabel[countElement];
        JTextArea[] jTextAreasParameterLeft = new JTextArea[countElement];

        constructBtnTest(panelLeft, jLabelsParameterLeft, jTextAreasParameterLeft, buttonParameterLeft, countElement,
                "Left");
    }

    private void constructPanelDialogRight() {
        int countElement = 20;
        JButton[] buttonParameterRight = new JButton[countElement];
        JLabel[] jLabelsParameterRight = new JLabel[countElement];
        JTextArea[] jTextAreasParameterRight = new JTextArea[countElement];

        constructBtnTest(panelRight, jLabelsParameterRight, jTextAreasParameterRight, buttonParameterRight, countElement,
                "Right");

    }


    private void constructBtnTest(JPanel jPanel, JLabel[] jLabelsParameter, JTextArea[] jTextAreasParameter,
                                  JButton[] buttonParameter, int countElement, String nameParameter) {
        jPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        int panelEmptyY = countElement + 1;
        int x = 0;
        int y = 1;


        for (int i = 0; i < buttonParameter.length; i++) {
            jLabelsParameter[i] = new JLabel();
            jLabelsParameter[i].setName("lbl" + nameParameter + i);
            jLabelsParameter[i].setText("Test" + nameParameter + i);
            constraints.insets.left = 20;
            constraints.insets.top = 20;
            constraints.gridx = x;
            constraints.gridy = y;
            jPanel.add(jLabelsParameter[i], constraints);

            jTextAreasParameter[i] = new JTextArea();
            jTextAreasParameter[i].setName("textArea" + nameParameter + i);
            jTextAreasParameter[i].setPreferredSize(new Dimension(100, 20));
            constraints.insets.left = 10;

            x++;
            constraints.gridx = x;
            constraints.gridy = y;
            jPanel.add(jTextAreasParameter[i], constraints);

            x++;
            buttonParameter[i] = new JButton("Test" + i);
            buttonParameter[i].setName("btn" + i);
            constraints.gridx = x;
            constraints.gridy = y;
            jPanel.add(buttonParameter[i], constraints);
            x = 0;
            y++;
        }
        JPanel jPanelEmpty3 = new JPanel();
        constraints.gridx = 0;
        constraints.gridy = panelEmptyY;
        constraints.gridwidth = 3;
        constraints.weightx = 0.1;
        constraints.weighty = 0.2;
        jPanelEmpty3.setBackground(Color.cyan);
        jPanel.add(jPanelEmpty3, constraints);
    }
}


