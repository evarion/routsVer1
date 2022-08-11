package com.evarion.gui;

import javax.swing.*;
import java.awt.event.*;

public class MainMenuItem extends JFrame {
    static JPopupMenu menu = new JPopupMenu();


    public  void createMainMenuButton() {//if
        TopButtonMenu.jButtonMainMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int yPositionMenu = TopButtonMenu.jButtonMainMenu.getY() + 20;
                menu.show(e.getComponent(), menu.getX(), yPositionMenu);
                }
        });


        menu.add(new JMenuItem(new AbstractAction("First Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));


        menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));


       menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));


        for (int i = 0; i < 15; i++) {
            menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            }));
        }
    }
}



