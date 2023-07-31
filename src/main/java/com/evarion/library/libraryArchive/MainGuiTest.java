package com.evarion.library.libraryArchive;


import javax.swing.*;
import java.awt.*;


public class MainGuiTest extends JFrame {

    JPanel mainPanelTopMain = new JPanel();
    JPanel mainPanelDownInfo = new JPanel();

    JPanel mainPanelLeftMenu = new JPanel();
    JPanel mainPanelCentre = new JPanel();
    JPanel mainPanelRight = new JPanel();

    JPanel mainPanelTopCentreMenu = new JPanel();
    JPanel mainPanelDownCentreData = new JPanel();

    JPanel mainPanelTopRightMenu = new JPanel();
    JPanel mainPanelTopRightData = new JPanel();
    JPanel mainPanelDownRightData = new JPanel();


    public MainGuiTest() {
        super("App");
        createGUI();
    }

    public void createGUI() {
        MainPanel.createPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));
        setLocation(200, 40);
        setMinimumSize(new Dimension(1600, 900));
        //setExtendedState(JFrame.MAXIMIZED_BOTH);

        addPanel();
        configPanel();

    }


    public void addPanel() {
        add(mainPanelTopMain);
        add(mainPanelDownInfo);

        mainPanelTopMain.add(mainPanelLeftMenu);
        mainPanelTopMain.add(mainPanelCentre);
        mainPanelTopMain.add(mainPanelRight);

        mainPanelCentre.add(mainPanelTopCentreMenu);
        mainPanelCentre.add(mainPanelDownCentreData);

        mainPanelRight.add(mainPanelTopRightMenu);
        mainPanelRight.add(mainPanelTopRightData);
        mainPanelRight.add(mainPanelDownRightData);

    }

    public void configPanel() {
       //setLayout(new GridLayout(2,1));

       setLayout(new GridBagLayout());
       GridBagConstraints constraints  = new GridBagConstraints();
       constraints.fill = GridBagConstraints.VERTICAL;

        mainPanelTopMain.setBackground(Color.YELLOW);
        mainPanelDownInfo.setBackground(Color.ORANGE);

    }
}
