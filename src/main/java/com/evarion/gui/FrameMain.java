package com.evarion.gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import static com.evarion.gui.DataPanel.createDataPanel;
import static com.evarion.gui.InfoPanel.createInfoPanel;
import static com.evarion.gui.LeftButtonMenu.createLeftButtonPanel;
import static com.evarion.gui.TopButtonMenu.createTopButtonPanel;


public class FrameMain extends JFrame {

    static JPanel mainPanel = new JPanel();
    static JPanel menuLeftJP0 = new JPanel();
    static JPanel menuTopJP0 = new JPanel();
    static JPanel dataCentreJP0 = new JPanel();
    static JPanel jVisiblePanelMenuDataLeft = new JPanel();
    static JPanel menuDownInfoJP0 = new JPanel();


    public FrameMain() throws IOException {
        super("Routs Logistic");
        createGUI();
    }

    public void createGUI() throws IOException {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50, 40);
        setMinimumSize(new Dimension(920, 640));
        setIconImage(ImageIO.read(FrameMain.class.getResourceAsStream("/logo1.png")));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        createMainPanel();
    }


    public void createMainPanel() {
        add(mainPanel);
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.001; //0.1 //visible LeftMenu
        constraints.weightx = GridBagConstraints.NONE;//ok
        menuTopJP0.setBackground(Color.GRAY);
        createTopButtonPanel();
        mainPanel.add(menuTopJP0, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 3;
        constraints.weightx = 0.97;
        constraints.weighty = 0.9;
        constraints.weightx = GridBagConstraints.NONE;//ok
        menuLeftJP0.setBackground(Color.ORANGE);
        createLeftButtonPanel();
        mainPanel.add(menuLeftJP0, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.03;
        constraints.weighty = 0.9;//visible LeftMenu constraints.weighty = 0.7;
        dataCentreJP0.setBackground(Color.GRAY.brighter());
        createDataPanel();
        mainPanel.add(dataCentreJP0, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 0.03;
        constraints.weighty = GridBagConstraints.NONE;
        createInfoPanel();
        menuDownInfoJP0.setBackground(Color.GRAY);
        mainPanel.add(menuDownInfoJP0, constraints);
    }
}