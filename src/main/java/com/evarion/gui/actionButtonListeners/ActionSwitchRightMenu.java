package com.evarion.gui.actionButtonListeners;

import com.evarion.gui.DataPanel;
import com.evarion.gui.FrameMain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ActionSwitchRightMenu implements ActionListener {
    boolean dataRightActive = false;

    @Override
    public void actionPerformed(ActionEvent e) { //11111111111111111
       // int position = DataPanel.dataSplitPaneHorizontal.getDividerLocation();
        //System.out.println(position);
        if (!dataRightActive) {
            DataPanel.dataSplitPaneHorizontal.getRightComponent().setVisible(false);
            DataPanel.dataSplitPaneHorizontal.setDividerSize(0);
            DataPanel.dataSplitPaneHorizontal.updateUI();
            dataRightActive = true;
           // FrameMain.jVisiblePanelDataLeft.setPreferredSize(new Dimension(1790,890));
            //FrameMain.jVisiblePanelDataLeft.updateUI();
        } else {
            DataPanel.dataSplitPaneHorizontal.getRightComponent().setVisible(true);
            DataPanel.dataSplitPaneHorizontal.setDividerSize(10);
            DataPanel.dataSplitPaneHorizontal.updateUI();
            dataRightActive = false;
          //  FrameMain.jVisiblePanelDataLeft.setPreferredSize(new Dimension(1340,890));
        }
    }
}
