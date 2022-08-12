package com.evarion.gui.actionButtonListeners;

import com.evarion.gui.DataPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionSwitchRightMenu implements ActionListener {
    boolean dataRightActive = false;

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
