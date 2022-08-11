package com.evarion.gui;

import javax.swing.*;

import java.awt.*;

import static com.evarion.gui.FrameMain.menuTopJP0;

public class TopButtonMenu extends JFrame {

    static JButton[] buttonsTopMenu = new JButton[25];
    static JButton jButtonMainMenu = new JButton("MENU");
    static MainMenuItem mainMenuItem = new MainMenuItem();


    public static void createTopButtonPanel() {
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
            constraints.insets.top = 5;//visible LeftMenu
            gridX = gridX + 1;
            menuTopJP0.add(jButton, constraints);
            constraints.insets.top = 10;//visible LeftMenu
        }

        constraints.weightx = 0.7;
        menuTopJP0.add(jPanelEmpty, constraints);

        jButtonMainMenu.setPreferredSize(new Dimension(80, 25));
        jButtonMainMenu.setMinimumSize(new Dimension(80, 25));

        constraints.anchor = GridBagConstraints.EAST;
        mainMenuItem.createMainMenuButton();//test

        constraints.insets.top = 5;
        constraints.insets.bottom = 3;
        menuTopJP0.add(jButtonMainMenu, constraints);
    }

    public static void actionsButtonsTopPanel(int numButton) {
        Icon leftMenuVisible = new ImageIcon("images/leftMenuVisible.png");
        Icon rightMenuVisible = new ImageIcon("images/RightMenuVisible.png");

        switch (numButton) {
            case 24:
                buttonsTopMenu[24].addActionListener(new ActionButtonListeners.ChangeEventActionFromAction());
                buttonsTopMenu[24].setIcon(rightMenuVisible);
                buttonsTopMenu[24].setToolTipText("Показать/Скрыть окно");
                break;
            case 0:
                buttonsTopMenu[0].addActionListener(new ActionButtonListeners.TestButtonFromAction());
                buttonsTopMenu[0].setToolTipText("Показать/Скрыть Меню");
                buttonsTopMenu[0].setIcon(leftMenuVisible);
        }
    }
}
