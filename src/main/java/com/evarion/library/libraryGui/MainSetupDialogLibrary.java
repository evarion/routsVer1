package com.evarion.library.libraryGui;


import javax.swing.*;
import java.awt.*;

public class MainSetupDialogLibrary {

/*

 JLabel oneParJLabelR = new JLabel("первый параметр");
    JTextArea oneParInputTextAreaRight = new JTextArea();
    JButton oneBtnOkR = new JButton("OK");

    private void constructPanelDialogRight() {
        JPanel jPanelEmpty3 = new JPanel();

        panelRight.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        constraints.insets.left = 20;
        constraints.insets.top = 20;
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelRight.add(oneParJLabelR, constraints);

        oneParInputTextAreaRight.setPreferredSize(new Dimension(100, 20));
        constraints.insets.left = 10;
        constraints.gridx = 1;
        constraints.gridy = 0;
        panelRight.add(oneParInputTextAreaRight, constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        panelRight.add(oneBtnOkR, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.weightx = 0.1;
        constraints.weighty = 0.2;
        jPanelEmpty3.setBackground(Color.cyan);
        panelRight.add(jPanelEmpty3, constraints);
    }
    */
    /*private void constructBtnLeft() {
        panelLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        int countElement = 20;
        int panelEmptyY = countElement + 1;
        JButton[] buttonParameter = new JButton[countElement];
        JLabel[] jLabelsParameter = new JLabel[countElement];
        JTextArea[] jTextAreasParameter = new JTextArea[countElement];
        int x = 0;
        int y = 1;

        for (int i = 0; i < buttonParameter.length; i++) {

            jLabelsParameter[i] = new JLabel();
            jLabelsParameter[i].setName("lbl" + i);
            jLabelsParameter[i].setText("Test" + i);
            constraints.insets.left = 20;
            constraints.insets.top = 20;
            constraints.gridx = x;
            constraints.gridy = y;
            panelLeft.add(jLabelsParameter[i], constraints);

            jTextAreasParameter[i] = new JTextArea();
            jTextAreasParameter[i].setName("textArea" + i);
            jTextAreasParameter[i].setPreferredSize(new Dimension(100, 20));
            constraints.insets.left = 10;

            x++;
            constraints.gridx = x;
            constraints.gridy = y;
            panelLeft.add(jTextAreasParameter[i], constraints);

            x++;
            buttonParameter[i] = new JButton("Test" + i);
            buttonParameter[i].setName("btn" + i);
            constraints.gridx = x;
            constraints.gridy = y;
            panelLeft.add(buttonParameter[i], constraints);
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
        panelLeft.add(jPanelEmpty3, constraints);
    }

     */
}
