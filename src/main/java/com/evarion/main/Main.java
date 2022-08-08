package com.evarion.main;

import com.evarion.gui.FrameMain;



public class Main {
    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrameMain frame2 = new FrameMain();
                frame2.setVisible(true);

            }
        });


    }
}
