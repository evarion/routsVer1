package com.evarion.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionButtonListeners {
    static boolean dataRightActive = false;
    static boolean leftMenuActive = false;

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
            int position = FrameMain.dataSplitPaneHorizontal.getDividerLocation();
            if (!leftMenuActive) {
                FrameMain.menuLeftJP0.setVisible(false);
                FrameMain.jVisiblePanelMenuDataLeft.setVisible(true);
                FrameMain.dataSplitPaneHorizontal.setDividerLocation(position + 120);
                FrameMain.dataSplitPaneHorizontal.updateUI();
                leftMenuActive = true;

            } else {
                FrameMain.menuLeftJP0.setVisible(true);
                FrameMain.dataSplitPaneHorizontal.setDividerLocation(position - 120);
                FrameMain.dataSplitPaneHorizontal.updateUI();
                FrameMain.jVisiblePanelMenuDataLeft.setVisible(false);
                leftMenuActive = false;
            }
        }
    }
}
