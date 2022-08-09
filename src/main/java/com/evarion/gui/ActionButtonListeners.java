package com.evarion.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonListeners {
    static boolean dataRightActive = false;

    static class ChangeEventActionFromAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!dataRightActive) {
                FrameMain.dataSplitPaneHorizontal.getRightComponent().setVisible(false);
                FrameMain.dataSplitPaneHorizontal.setDividerSize(0);
                FrameMain.dataSplitPaneHorizontal.updateUI();
                dataRightActive = true;

            } else {
                FrameMain.dataSplitPaneHorizontal.getRightComponent().setVisible(true);
                FrameMain.dataSplitPaneHorizontal.setDividerSize(10);
                FrameMain.dataSplitPaneHorizontal.updateUI();
                dataRightActive = false;


            }
        }
    }

    static class TestButtonFromAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }
}
