package com.evarion.gui;

import javax.swing.*;
import java.awt.event.*;

public class MainMenuItem extends JFrame {


    public  void createMainMenuButton() {//if
        FrameMain.jButtonMainMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                int yPositionMenu = FrameMain.jButtonMainMenu.getY() + 20;
                FrameMain.menu.show(e.getComponent(), FrameMain.menu.getX(), yPositionMenu);

                }

        });


        FrameMain.menu.add(new JMenuItem(new AbstractAction("First Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));


        FrameMain.menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));


        FrameMain.menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));


        for (int i = 0; i < 15; i++) {
            FrameMain.menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            }));
        }
    }
}



