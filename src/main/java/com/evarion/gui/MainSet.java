package com.evarion.gui;

import com.evarion.Main;

import javax.swing.*;
import java.awt.*;


public class MainSet {
    static JDialog jd = new JDialog();

    public static void testDialogSET() {

        JPanel pan = new JPanel();
        pan.setLayout(new FlowLayout());

        int h = FrameMain.mainPanel.getSize().height;
        int w = FrameMain.mainPanel.getSize().width;


        pan.add(new JLabel("label"));
        pan.add(new JButton("button"));


        // jd.setPreferredSize(new Dimension(400,400));


        if (w > 1200) {
            jd.setMinimumSize(new Dimension(1200, h));
          //  jd.setLocationRelativeTo(null); //по центру
            setLocation();// переделать на центр для этого метода
        } else {

            jd.setMinimumSize(new Dimension(w, h));
            setLocation();
        }
        //jd.setMaximumSize(new Dimension(400,h));


        jd.setAlwaysOnTop(true);
        jd.add(pan);
        jd.setVisible(true);
    }

    private static void setLocation() {
        int locY;
        int locX;
        Main.getLocMainForm();
        locX = Main.getLocMainFormX();
        locY = Main.getLocMainFormY();
        jd.setLocation(locX, locY);
    }
}

