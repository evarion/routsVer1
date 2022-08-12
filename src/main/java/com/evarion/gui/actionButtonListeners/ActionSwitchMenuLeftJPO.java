package com.evarion.gui.actionButtonListeners;

import com.evarion.gui.DataPanel;
import com.evarion.gui.FrameMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionSwitchMenuLeftJPO implements ActionListener {
    boolean leftMenuActive = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        int position = DataPanel.dataSplitPaneHorizontal.getDividerLocation();
        if (!leftMenuActive) {
            FrameMain.jVisiblePanelMenuDataLeft.setVisible(false);
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

