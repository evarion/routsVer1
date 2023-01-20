package com.evarion.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TestPanel extends JFrame {

    JPanel mainPanel = new JPanel();
    JPanel[] jPanels = new JPanel[6];

    public TestPanel() throws IOException {
        super("Routs Logistics");
        createGUI1();
    }

    public void createGUI1() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 40);
        setMinimumSize(new Dimension(920, 640));
        setIconImage(ImageIO.read(TestPanel.class.getResourceAsStream("/logo/logo1.png")));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        createMainPanel();
    }

    public void createMainPanel() {
        add(mainPanel);
        GridBagConstraints[] constraints = new GridBagConstraints[6];


    }

    public static void main(String[] args) throws IOException {
        TestPanel testPanel = new TestPanel();
        testPanel.setVisible(true);


    }
}
