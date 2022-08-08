package com.evarion.main;

import com.evarion.gui.FrameMain;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrameMain frame2 = null;
                try {
                    frame2 = new FrameMain();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                frame2.setVisible(true);

            }
        });


    }
}