package com.evarion.libraryArchive;

import javax.swing.*;


public class MyPanel extends JPanel {

    public void createPanel(JPanel jPanel, JPanel jPanel2) {
        addPanel(jPanel, jPanel2);
    }

    void addPanel(JPanel jPanel, JPanel jPanel2) {
        jPanel.add(jPanel2);
    }


}

