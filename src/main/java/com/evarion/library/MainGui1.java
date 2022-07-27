package com.evarion.library;

import javax.swing.*;
import java.awt.*;


public class MainGui1 extends JFrame {

    JPanel jPanelLeft = new JPanel();
    JPanel jPanelCentre = new JPanel();
    JPanel jPanelRight = new JPanel();
    JPanel jPanelData = new JPanel();
    JPanel jPanelRightDataUp = new JPanel();
    JPanel jPanelRightDataDown = new JPanel();
    JPanel jPanelDownPanelInfo = new JPanel();
    JPanel jPanelDataTable = new JPanel();
    JPanel jPanelDataTableSubRight = new JPanel();

    JPanel dataUpRight = new JPanel();
    JPanel dataUpLeft = new JPanel();
    JPanel dataDownRight = new JPanel();
    JPanel dataDownLeft = new JPanel();


    JPanel jPanelLogo = new JPanel();

    JLabel logo = new JLabel("LOGO");


    JButton[] buttonsTopMenu = new JButton[12];
    JButton[] buttonsRightsMenu = new JButton[7];
    JButton[] buttonsLeftMenu = new JButton[8];

    public MainGui1() {
        super("App");
        createGUI();
    }


    public void createGUI() {
        //MainPanel.createPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 40);
        setMinimumSize(new Dimension(1800, 900));

        addPanel();
        addButtonOnPanel();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setResizable(false);
    }


    public void addPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints();

        int heightYellowPanel = 80;
        int magentaHeight = 800;
        int widthOrange = 120;
        int widthMagentaGreen = 1300;
        int widthCyanRedBlue = 500;
        int heightGreenBlue = 100;
        int heightOrange = magentaHeight + heightYellowPanel + heightGreenBlue;
        int widthYellow = widthMagentaGreen + widthCyanRedBlue;


        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridheight = 5;
        constraints1.gridwidth = 1;
        jPanelLeft.setPreferredSize(new Dimension(widthOrange, heightOrange));
        jPanelLeft.setBackground(Color.ORANGE);
        add(jPanelLeft, constraints1);


        constraints1.gridx = 1;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        jPanelCentre.setPreferredSize(new Dimension(widthMagentaGreen, heightGreenBlue));
        jPanelCentre.setBackground(Color.green);
        add(jPanelCentre, constraints1);


        constraints1.gridx = 1;
        constraints1.gridy = 2;
        constraints1.gridheight = 2;
        constraints1.gridwidth = 2;
        jPanelData.setPreferredSize(new Dimension(widthYellow, magentaHeight));
        jPanelData.setBackground(Color.MAGENTA.darker());
        add(jPanelData, constraints1);


        constraints1.gridx = 2;
        constraints1.gridy = 0;
        constraints1.gridheight = 1;
        constraints1.gridwidth = 1;
        jPanelRight.setPreferredSize(new Dimension(widthCyanRedBlue, heightGreenBlue));
        jPanelRight.setBackground(Color.BLUE);
        add(jPanelRight, constraints1);

        jPanelDataTable.setBackground(Color.LIGHT_GRAY);
        jPanelDataTableSubRight.setBackground(Color.GRAY);
        jPanelDataTable.setPreferredSize(new Dimension(1300, 800));
        jPanelDataTableSubRight.setPreferredSize(new Dimension(500, 800));
        JSplitPane splitPaneData = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanelDataTable, jPanelDataTableSubRight);
        jPanelData.add(splitPaneData);


        dataUpRight.setBackground(Color.cyan);
        dataUpLeft.setBackground(Color.cyan);
        dataUpRight.setPreferredSize(new Dimension(235, 700));
        dataUpLeft.setPreferredSize(new Dimension(235, 700));
        JSplitPane oneTest0 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dataUpRight, dataUpLeft);
        jPanelRightDataUp.add(oneTest0);


        dataDownRight.setBackground(Color.red.darker());
        dataDownLeft.setBackground(Color.red.darker());
        dataDownRight.setPreferredSize(new Dimension(235, 700));
        dataDownLeft.setPreferredSize(new Dimension(235, 700));

        JSplitPane oneTest1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, dataDownRight, dataDownLeft);
        jPanelRightDataDown.add(oneTest1);

/*
        JSplitPane rightDataSubTable = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jPanelRightDataUp, jPanelRightDataDown);
        jPanelDataTableSubRight.add(rightDataSubTable);
        rightDataSubTable.setDividerLocation(360);
*/

        JSplitPane rightDataSub = splitPanelVertical(jPanelRightDataUp,jPanelRightDataDown,360);
        jPanelDataTableSubRight.add(rightDataSub);

        constraints1.gridx = 1;
        constraints1.gridy = 4;
        constraints1.gridheight = 0;
        constraints1.gridwidth = 2;
        jPanelDownPanelInfo.setPreferredSize(new Dimension(widthYellow, 80));
        jPanelDownPanelInfo.setBackground(Color.YELLOW);
        add(jPanelDownPanelInfo, constraints1);
    }

    public JSplitPane splitPanelVertical(JPanel jPane1, JPanel jPanel2,int dividerLocation) {
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jPane1, jPanel2);
        jSplitPane.setDividerLocation(dividerLocation);
        return jSplitPane;
    }


    public void addButtonOnPanel() {
        jPanelLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.NORTH;
        constraints2.weighty = 0.001;
        constraints2.ipady = 30;

        logo.setBorder(BorderFactory.createEmptyBorder(35, 0, 0, 0));
        jPanelLogo.setPreferredSize(new Dimension(100, 70));

        constraints2.gridx = 0;
        constraints2.gridy = 1;


        jPanelLogo.add(logo);

        jPanelLeft.add(jPanelLogo, constraints2);


        for (int i = 0; i < buttonsLeftMenu.length; i++) {
            buttonsLeftMenu[i] = new JButton();
            buttonsLeftMenu[i].setName("jButtonLeft" + i);
            buttonsLeftMenu[i].setText("Text");
            buttonsLeftMenu[i].setPreferredSize(new Dimension(100, 60));
        }

        int numY = 2;
        for (JButton jButton : buttonsLeftMenu) {
            constraints2.gridy = numY;
            constraints2.gridx = 0;
            numY++;
            jPanelLeft.add(jButton, constraints2);
        }

        jPanelCentre.setLayout(new GridBagLayout());
        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.weighty = 0.001;
        constraints3.weightx = 0.001;


        for (int i = 0; i < buttonsTopMenu.length; i++) {
            buttonsTopMenu[i] = new JButton();
            buttonsTopMenu[i].setName("JButtonTopCentre" + i);
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


        for (int i = 0; i < buttonsRightsMenu.length; i++) {
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
