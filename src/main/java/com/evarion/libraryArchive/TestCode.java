package com.evarion.libraryArchive;

import javax.swing.*;
import java.awt.*;

public class TestCode extends JFrame {
    JPanel jPanelLeft = new JPanel();
    JPanel jPanelCentre = new JPanel();
    JPanel jPanelRight = new JPanel();
    JPanel jPanelData = new JPanel();
    JPanel jPanelRightDataUp = new JPanel();
    JPanel jPanelRightDataDown = new JPanel();
    JPanel jPanelDownPanelInfo = new JPanel();

    JPanel jPanelEmpty = new JPanel();
    JPanel jPanelLogo = new JPanel();
    JButton jButton1 = new JButton("Text");
    JButton jButton2 = new JButton("Text");
    JButton jButton3 = new JButton("Text");
    JButton jButton4 = new JButton("Text");
    JButton jButton5 = new JButton("Text");
    JButton jButton6 = new JButton("Text");
    JButton jButton7 = new JButton("Text");


    JButton[] buttonsTopMenu = new JButton[11];
    JButton[] buttonsRightsMenu = new JButton[6];
    JButton[] buttonsLeftMenu = new JButton[8];

    public TestCode() {
        super("App");
        createGUI();
    }
    public void createGUI() {
        //MainPanel.createPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 40);
        setMinimumSize(new Dimension(1800, 900));

        addPanel();
        //addButton();
        //addButtonVar2();


        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }

    public void addPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints();

        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 5;
        constraints1.gridwidth = 1;
        jPanelLeft.setPreferredSize(new Dimension(120, 820));
        jPanelLeft.setBackground(Color.ORANGE);
        add(jPanelLeft, constraints1);

        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 1;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        jPanelCentre.setPreferredSize(new Dimension(1000, 100));
        jPanelCentre.setBackground(Color.green);
        add(jPanelCentre, constraints1);

        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 2;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        jPanelRight.setPreferredSize(new Dimension(400, 100));
        jPanelRight.setBackground(Color.BLUE);
        add(jPanelRight, constraints1);

        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 1;
        constraints1.gridy = 2;
        constraints1.gridheight = 2;
        constraints1.gridwidth = 1;
        jPanelData.setPreferredSize(new Dimension(1000, 640));
        jPanelData.setBackground(Color.MAGENTA);
        add(jPanelData, constraints1);

        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 2;
        constraints1.gridy = 2;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        jPanelRightDataUp.setPreferredSize(new Dimension(400, 320));
        jPanelRightDataUp.setBackground(Color.cyan);
        add(jPanelRightDataUp, constraints1);

        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 2;
        constraints1.gridy = 3;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        jPanelRightDataDown.setPreferredSize(new Dimension(400, 320));
        jPanelRightDataDown.setBackground(Color.RED);
        add(jPanelRightDataDown, constraints1);

        constraints1.weightx = 0;
        constraints1.weighty = 0;
        constraints1.gridx = 1;
        constraints1.gridy = 4;
        constraints1.gridheight = 0;
        constraints1.gridwidth = 2;
        jPanelDownPanelInfo.setPreferredSize(new Dimension(1400, 80));
        jPanelDownPanelInfo.setBackground(Color.YELLOW);
        add(jPanelDownPanelInfo, constraints1);

    }

    public void addButton() {

        jPanelLeft.setLayout(new GridLayout(8, 2, 7, 10));

        jPanelLeft.add(jPanelLogo);
        jPanelLeft.add(jButton1);
        jPanelLeft.add(jButton2);
        jPanelLeft.add(jButton3);
        jPanelLeft.add(jButton4);
        jPanelLeft.add(jButton5);
        jPanelLeft.add(jButton6);
        jPanelLeft.add(jButton7);


    }

    public void addButtonVar2() {
        jPanelLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints2 = new GridBagConstraints();

        constraints2.anchor = GridBagConstraints.NORTH;
        constraints2.weighty = 0.001;

        jPanelEmpty.setPreferredSize(new Dimension(0, 1));
        constraints2.gridx = 0;
        constraints2.gridy = 0;
        jPanelLeft.add(jPanelEmpty, constraints2);


        jPanelLogo.setPreferredSize(new Dimension(100, 75));
        constraints2.gridx = 0;
        constraints2.gridy = 1;
        jPanelLeft.add(jPanelLogo, constraints2);

        jButton1.setPreferredSize(new Dimension(90, 90));
        constraints2.gridx = 0;
        constraints2.gridy = 2;
        jPanelLeft.add(jButton1, constraints2);

        jButton2.setPreferredSize(new Dimension(90, 90));
        constraints2.gridx = 0;
        constraints2.gridy = 3;
        jPanelLeft.add(jButton2, constraints2);

        jButton3.setPreferredSize(new Dimension(90, 90));
        constraints2.gridx = 0;
        constraints2.gridy = 4;
        jPanelLeft.add(jButton3, constraints2);

        jButton4.setPreferredSize(new Dimension(90, 90));
        constraints2.gridx = 0;
        constraints2.gridy = 5;
        jPanelLeft.add(jButton4, constraints2);

        jButton5.setPreferredSize(new Dimension(90, 90));
        constraints2.gridx = 0;
        constraints2.gridy = 6;
        jPanelLeft.add(jButton5, constraints2);

        jButton6.setPreferredSize(new Dimension(90, 90));
        constraints2.gridx = 0;
        constraints2.gridy = 7;
        jPanelLeft.add(jButton6, constraints2);

        jButton7.setPreferredSize(new Dimension(90, 90));
        constraints2.gridx = 0;
        constraints2.gridy = 8;
        jPanelLeft.add(jButton7, constraints2);


        jPanelCentre.setLayout(new GridBagLayout());
        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.weighty = 0.001;
        constraints3.weightx = 0.001;


        for (int i = 0; i < 11; i++) {
            buttonsTopMenu[i] = new JButton();
            buttonsTopMenu[i].setName("JButton" + i);
            buttonsTopMenu[i].setText("Text");
            buttonsTopMenu[i].setPreferredSize(new Dimension(80, 60));
        }

        for (JButton jButton : buttonsTopMenu) {
            jPanelCentre.add(jButton, constraints3);
        }

        jPanelRight.setLayout(new GridBagLayout());
        GridBagConstraints constraints4 = new GridBagConstraints();
        constraints4.weighty = 0.001;
        constraints4.weightx = 0.001;


        for (int i = 0; i < 6; i++) {
            buttonsRightsMenu[i] = new JButton();
            buttonsRightsMenu[i].setName("JButtonRight" + i);
            buttonsRightsMenu[i].setText("Text");
            buttonsRightsMenu[i].setPreferredSize(new Dimension(60, 60));
        }

        for (JButton jButton : buttonsRightsMenu) {
            jPanelRight.add(jButton, constraints4);
        }
    }
}
