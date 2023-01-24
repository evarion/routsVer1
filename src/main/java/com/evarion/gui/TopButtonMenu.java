package com.evarion.gui;

import com.evarion.gui.actionButtonListeners.*;

import javax.swing.*;
import java.awt.*;


public class TopButtonMenu extends JFrame {

    public static JButton[] buttonsTopMenu = new JButton[25];
    static JButton jButtonMainMenu = new JButton("MENU");


    public static void createTopButtonPanel() {
        FrameMain.menuTopJP0.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        JPanel jPanelEmpty = new JPanel();
        JPanel jPanelEmpty2 = new JPanel();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets.top = 4;
        constraints.insets.bottom = 4;
        jPanelEmpty2.setBackground(Color.GRAY);
        FrameMain.menuTopJP0.add(jPanelEmpty2, constraints);


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
            FrameMain.menuTopJP0.add(jButton, constraints);
            constraints.insets.top = 10;//visible LeftMenu
        }

        constraints.weightx = 0.7;
        FrameMain.menuTopJP0.add(jPanelEmpty, constraints);

        jButtonMainMenu.setPreferredSize(new Dimension(80, 25));
        jButtonMainMenu.setMinimumSize(new Dimension(80, 25));

        constraints.anchor = GridBagConstraints.EAST;
        MainMenuItem.createMainMenuButton();//test

        constraints.insets.top = 5;
        constraints.insets.bottom = 3;
        FrameMain.menuTopJP0.add(jButtonMainMenu, constraints);
    }

    public static void actionsButtonsTopPanel(int numButton) {
        Icon leftMenuVisible = new ImageIcon("src/main/resources/images/leftMenuVisible.png");
        Icon rightMenuVisible = new ImageIcon("src/main/resources/images/RightMenuVisible.png");
        //Icon startConnectionSQL = new ImageIcon("src/main/resources/images/startConnectionSQL.png");
        Icon stopConnectionSQL = new ImageIcon("src/main/resources/images/stopConnectionSQL.png");

        switch (numButton) {
            case 1:
                buttonsTopMenu[1].addActionListener(new ActionCreateTableSQL());

                buttonsTopMenu[1].setToolTipText("создать таблицы");
                break;
            case 2:
                buttonsTopMenu[2].addActionListener(new ActionCheckTablesSQL());

                buttonsTopMenu[2].setToolTipText("проверка таблиц");
                break;

            case 24:
                buttonsTopMenu[24].addActionListener(new ActionSwitchRightMenu());
                buttonsTopMenu[24].setIcon(rightMenuVisible);
                buttonsTopMenu[24].setToolTipText("Показать/Скрыть окно");
                break;
            case 0:
                buttonsTopMenu[0].addActionListener(new ActionSwitchMenuLeftJPO());
                buttonsTopMenu[0].setToolTipText("Показать/Скрыть Меню");
                buttonsTopMenu[0].setIcon(leftMenuVisible);
                break;

            case 23:
                buttonsTopMenu[23].addActionListener(new ActionStartStopConnectionSQL());
               // TopButtonMenu.buttonsTopMenu[23].setToolTipText("нет соединения с БД");
               // buttonsTopMenu[23].setIcon(stopConnectionSQL);
               // break;
/*
            case 22:
                buttonsTopMenu[22].addActionListener(new ActionStartConnectionSQL());
                buttonsTopMenu[22].setToolTipText("Установить соединение с БД");
                buttonsTopMenu[22].setIcon(startConnectionSQL);
                break;
            case 23:
                buttonsTopMenu[23].addActionListener(new ActionStopConnectionSQL());
                buttonsTopMenu[23].setToolTipText("разорвать соединение с БД");
                buttonsTopMenu[23].setIcon(stopConnectionSQL);

 */
        }
    }
}
