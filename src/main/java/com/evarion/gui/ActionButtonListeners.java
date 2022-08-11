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
                DataPanel.dataSplitPaneHorizontal.getRightComponent().setVisible(false);
                DataPanel.dataSplitPaneHorizontal.setDividerSize(0);
                DataPanel.dataSplitPaneHorizontal.updateUI();
                dataRightActive = true;

            } else {
                DataPanel.dataSplitPaneHorizontal.getRightComponent().setVisible(true);
                DataPanel.dataSplitPaneHorizontal.setDividerSize(10);
                DataPanel.dataSplitPaneHorizontal.updateUI();
                dataRightActive = false;
            }
        }
    }

    static class TestButtonFromAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int position = DataPanel.dataSplitPaneHorizontal.getDividerLocation();
            if (!leftMenuActive) {
                FrameMain.menuLeftJP0.setVisible(false);
                FrameMain.jVisiblePanelMenuDataLeft.setVisible(true);
                DataPanel.dataSplitPaneHorizontal.setDividerLocation(position + 120);
                DataPanel.dataSplitPaneHorizontal.updateUI();
                leftMenuActive = true;

            } else {
                FrameMain.menuLeftJP0.setVisible(true);
                DataPanel.dataSplitPaneHorizontal.setDividerLocation(position - 120);
                DataPanel.dataSplitPaneHorizontal.updateUI();
                FrameMain.jVisiblePanelMenuDataLeft.setVisible(false);
                leftMenuActive = false;
            }
        }
    }
}
