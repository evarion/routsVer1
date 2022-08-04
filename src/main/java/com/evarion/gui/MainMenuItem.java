package com.evarion.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainMenuItem extends JFrame {
    public static void createMainMenuButton() {
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
        FrameMain.jButtonMainMenu.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int yPositionMenu = FrameMain.jButtonMainMenu.getY() + 20;
                FrameMain.menu.show(e.getComponent(), FrameMain.menu.getX(), yPositionMenu);
            }
        });
        FrameMain.menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        }));

    }

}
