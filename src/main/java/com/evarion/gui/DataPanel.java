package com.evarion.gui;

import javax.swing.*;
import java.awt.*;


public class DataPanel extends JFrame {

    static JPanel menuDataLeft = new JPanel();         //2
    static JPanel dataLeft = new JPanel();             //2
    static JPanel menuDataRight = new JPanel();        //2
    static JPanel dataRight = new JPanel();            //2
    static JPanel dataRightTop = new JPanel();         //3
    static JPanel dataRightBottom = new JPanel();      //3
    static JPanel mainDataLeft = new JPanel();         //1
    static JPanel mainDataRight = new JPanel();        //1

    static JButton[] buttonsMenuDataRight = new JButton[8];
    static JButton[] buttonsMenuDataLeft = new JButton[18];

    public static JSplitPane dataSplitPaneHorizontal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, mainDataLeft, mainDataRight);//3

    public static void createDataPanel() {
        FrameMain.dataCentreJP0.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        //constraints.weighty = GridBagConstraints.NONE;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;

        mainDataLeft.setBackground(Color.WHITE);
        createMainDataLeft(); //
        mainDataRight.setBackground(Color.GRAY.brighter());
        createMainDataRight(); //

        dataSplitPaneHorizontal.setResizeWeight(0.8);
        FrameMain.dataCentreJP0.add(dataSplitPaneHorizontal, constraints);
    }


    public static void createMainDataLeft() {
        mainDataLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 0.03;
        constraints.weighty = GridBagConstraints.NONE;
        menuDataLeft.setBackground(Color.darkGray);
        createButtonMenuLeft();
        mainDataLeft.add(menuDataLeft, constraints);


        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.97;

        dataLeft.setBackground(Color.WHITE);
        createDataLeft();
        mainDataLeft.add(dataLeft, constraints);
    }


    public static void createMainDataRight() {
        mainDataRight.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 0.03;
        constraints.weighty = GridBagConstraints.NONE;
        menuDataRight.setBackground(Color.black);
        createButtonMenuRight();
        mainDataRight.add(menuDataRight, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.97;
        dataRight.setBackground(Color.LIGHT_GRAY);
        createDataRightTopBottom();
        mainDataRight.add(dataRight, constraints);
    }


    public static void createButtonMenuLeft() { // пример для createDataLeft
        JPanel jPanelEmpty = new JPanel();

        menuDataLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets.left = 110;
        FrameMain.jVisiblePanelMenuDataLeft.setBackground(Color.darkGray);
        FrameMain.jVisiblePanelMenuDataLeft.setVisible(false);

        menuDataLeft.add(FrameMain.jVisiblePanelMenuDataLeft, constraints);

        constraints.weightx = GridBagConstraints.NONE;
        constraints.insets.top = 8;
        constraints.insets.left = 8;
        constraints.insets.bottom = 8;

        for (int i = 0; i < buttonsMenuDataLeft.length; i++) {
            buttonsMenuDataLeft[i] = new JButton();
            buttonsMenuDataLeft[i].setName("buttonsMenuDataLeft" + i);
            buttonsMenuDataLeft[i].setPreferredSize(new Dimension(20, 20));
            buttonsMenuDataLeft[i].setMinimumSize(new Dimension(20, 20));
        }


        for (JButton jButton : buttonsMenuDataLeft) {
            menuDataLeft.add(jButton, constraints);
        }
        constraints.weightx = 0.2;
        jPanelEmpty.setBackground(Color.darkGray);
        menuDataLeft.add(jPanelEmpty, constraints);
    }

    //============================================================================================================

    public static void createDataLeft() {//добавление таблицы данных

        dataLeft.setLayout(new BorderLayout()); //1111111111111
        FrameMain.jVisiblePanelDataLeft.setBackground(Color.MAGENTA); // необходимо вместо панели добавить данные таблицы
        FrameMain.jVisiblePanelDataLeft.setVisible(true);

        DataTable.constructDataTable();
        dataLeft.add(FrameMain.jVisiblePanelDataLeft, BorderLayout.WEST);
    }


    public static void createButtonMenuRight() {
        JPanel jPanelEmpty = new JPanel();
        menuDataRight.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;

        constraints.insets.top = 8;
        constraints.insets.left = 8;//ok
        constraints.insets.bottom = 8;//ok


        for (int i = 0; i < buttonsMenuDataRight.length; i++) {
            buttonsMenuDataRight[i] = new JButton();
            buttonsMenuDataRight[i].setName("buttonsMenuDataRight" + i);
            buttonsMenuDataRight[i].setPreferredSize(new Dimension(20, 20));
            buttonsMenuDataRight[i].setMinimumSize(new Dimension(20, 20));
        }

        for (JButton jButton : buttonsMenuDataRight) {
            menuDataRight.add(jButton, constraints);
        }
        constraints.weightx = 0.2;
        jPanelEmpty.setBackground(Color.BLACK);
        menuDataRight.add(jPanelEmpty, constraints);
    }


    public static void createDataRightTopBottom() {
        dataRight.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = GridBagConstraints.NONE;
        JSplitPane splitPaneVertical = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        dataRightTop.setBackground(Color.LIGHT_GRAY);
        dataRightBottom.setBackground(Color.GRAY);

        splitPaneVertical.setResizeWeight(0.5);
        splitPaneVertical.setTopComponent(dataRightTop);
        splitPaneVertical.setBottomComponent(dataRightBottom);
        dataRight.add(splitPaneVertical, constraints);
    }


}