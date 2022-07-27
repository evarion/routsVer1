package com.evarion.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonListeners {
   static boolean dataRightActive=false;
    static class ChangeEventActionFromAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!dataRightActive) {
                FrameMain.mainDataRight.setVisible(false);
                dataRightActive=true;
            }
            else {
                FrameMain.mainDataRight.setVisible(true);
                dataRightActive=false;
            }
        }
    }

    static class TestButtonFromAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

}
