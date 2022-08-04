package com.evarion.gui;

import javax.swing.*;
import java.awt.*;
import com.evarion.gui.MainMenuItem;

public class FrameMain extends JFrame {

    static JPanel mainPanel = new JPanel();

    static JPanel menuLeftJP0 = new JPanel();
    JPanel jPanelLogo = new JPanel();
    JLabel logo = new JLabel("LOGO");
    JButton[] buttonsLeftMenu = new JButton[8];

    static JPanel menuTopJP0 = new JPanel();
    JButton[] buttonsTopMenu = new JButton[25];
    static JButton jButtonMainMenu = new JButton("MENU");
    static JPopupMenu menu = new JPopupMenu();


    static JPanel dataCentreJP0 = new JPanel();        //0
    static JPanel mainDataLeft = new JPanel();         //1
    static JPanel menuDataLeft = new JPanel();         //2
    static JPanel dataLeft = new JPanel();             //2
    static JPanel mainDataRight = new JPanel();        //1
    static JPanel menuDataRight = new JPanel();        //2
    static JPanel dataRight = new JPanel();            //2
    JButton[] buttonsMenuDataRight = new JButton[6];
    JButton[] buttonsMenuDataLeft = new JButton[8];

    static JPanel menuDownInfoJP0 = new JPanel();


    public FrameMain() {
        super("Routs Logistic");
        createGUI();
    }

    public void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 40);
        setMinimumSize(new Dimension(800, 600));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        createMainPanel();

    }


    public void createMainPanel() {
        add(mainPanel);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.1;
        constraints.weightx = GridBagConstraints.NONE;//ok
        menuTopJP0.setBackground(Color.GRAY);
        createTopButtonPanel();
        mainPanel.add(menuTopJP0, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.weightx = 0.97;
        constraints.weighty = 0.9;
        constraints.weightx = GridBagConstraints.NONE;//ok
        menuLeftJP0.setBackground(Color.ORANGE);
        createLeftButtonPanel();
        mainPanel.add(menuLeftJP0, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.03;
        constraints.weighty = 0.7;
        dataCentreJP0.setBackground(Color.GRAY.brighter());
        createDataPanel();
        mainPanel.add(dataCentreJP0, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.03;
        constraints.weighty = GridBagConstraints.NONE;
        createInfoPanel();
        menuDownInfoJP0.setBackground(Color.GRAY);
        mainPanel.add(menuDownInfoJP0, constraints);
    }


    public void createLeftButtonPanel() {
        menuLeftJP0.setLayout(new GridBagLayout());
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
        menuLeftJP0.add(jPanelLogo, constraints);
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
            menuLeftJP0.add(jButton, constraints);
        }
    }


    public void createTopButtonPanel() {
        menuTopJP0.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel jPanelEmpty = new JPanel();
        JPanel jPanelEmpty2 = new JPanel();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets.top = 4;
        constraints.insets.bottom = 4;

        jPanelEmpty2.setBackground(Color.GRAY);
        menuTopJP0.add(jPanelEmpty2, constraints);


        for (int i = 0; i < buttonsTopMenu.length; i++) {
            buttonsTopMenu[i] = new JButton();
            buttonsTopMenu[i].setName("jButtonTop" + i);
            buttonsTopMenu[i].setPreferredSize(new Dimension(25, 25));
            buttonsTopMenu[i].setMinimumSize(new Dimension(25, 25));
            actionsButtonsTopPanel(i);
        }

        int gridX = 1;
        int count = 1;

        for (JButton jButton : buttonsTopMenu) {
            constraints.gridx = gridX;
            constraints.gridwidth = 1;
            constraints.gridy = 0;
            if (count <= 4) {
                constraints.insets.right = 5;
                count++;
            } else {
                constraints.insets.right = 15;
                count = 1;
            }
            gridX = gridX + 1;
            menuTopJP0.add(jButton, constraints);
        }
        constraints.weightx = 0.7;
        menuTopJP0.add(jPanelEmpty, constraints);

        jButtonMainMenu.setPreferredSize(new Dimension(80, 25));
        jButtonMainMenu.setMinimumSize(new Dimension(80, 25));

        constraints.anchor = GridBagConstraints.EAST;
        MainMenuItem.createMainMenuButton();//test

        menuTopJP0.add(jButtonMainMenu, constraints);
    }

    public void createDataPanel() {
        dataCentreJP0.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.8;
        constraints.weighty = 1.0;
        mainDataLeft.setBackground(Color.WHITE);
        createMainDataLeft(); //
        dataCentreJP0.add(mainDataLeft, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.2;
        constraints.weighty = 1.0;
        mainDataRight.setBackground(Color.GRAY.brighter());
        createMainDataRight(); //
        dataCentreJP0.add(mainDataRight, constraints);
    }

    public void createMainDataLeft() {
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
        mainDataLeft.add(dataLeft, constraints);
    }

    public void createMainDataRight() {
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
        mainDataRight.add(dataRight, constraints);
    }


    public void createButtonMenuLeft() {
        JPanel jPanelEmpty = new JPanel();
        menuDataLeft.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
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


    public void createButtonMenuRight() {
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


    public void createInfoPanel() {
        JPanel jPanelEmpty = new JPanel();
        jPanelEmpty.setPreferredSize(new Dimension(20, 20));
        jPanelEmpty.setMinimumSize(new Dimension(20, 20));
        jPanelEmpty.setBackground(Color.gray);
        menuDownInfoJP0.add(jPanelEmpty);
    }


    public void actionsButtonsTopPanel(int numButton) {
        switch (numButton) {
            case 24:
                buttonsTopMenu[24].addActionListener(new ActionButtonListeners.ChangeEventActionFromAction());
                buttonsTopMenu[24].setToolTipText("Показать/Скрыть окно");
                break;
            case 0:
                buttonsTopMenu[0].addActionListener(new ActionButtonListeners.TestButtonFromAction());
        }

    }


}
