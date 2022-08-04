package com.evarion.gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MainMenuItem extends JFrame {

    public static void createMainMenuButton() {
        final JFrame jFrame = new JFrame();
        jFrame.setMinimumSize(new Dimension(400, 400));
        final boolean[] isStart = {true};

        FrameMain.menu.add(new JMenuItem(new AbstractAction("First Item Menu Component") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart[0]) {
                    jFrame.setVisible(true);
                    isStart[0] = true;

                } else {
                    jFrame.setVisible(false);
                    isStart[0] = false;

                }
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

        for (int i = 0; i < 15; i++) {
            FrameMain.menu.add(new JMenuItem(new AbstractAction("Next Item Menu Component") {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            }));
        }

    }

}
