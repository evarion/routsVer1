package com.evarion.library;


import javax.swing.*;
import java.awt.*;

public class LayoutTest {

    public static void main(String[] args) {
        new LayoutTest();
    }

    public LayoutTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }


                JPanel greenPane = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(275, 300);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.GREEN;
                    }

                };

                JPanel redPane = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(300, 600);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.RED;
                    }
                };

                JPanel left = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.weightx = 1;
                gbc.weighty = 0.25;
                gbc.fill = GridBagConstraints.BOTH;

                left.add(greenPane, gbc);
                gbc.gridy++;
                gbc.weighty = 0.75;
                left.add(redPane, gbc);

                JPanel yellowPane = new JPanel() {

                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(600, 50);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.YELLOW;
                    }
                };

                JPanel grayPane = new JPanel() {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(400, 600);
                    }

                    @Override
                    public Dimension getMinimumSize() {
                        return getPreferredSize();
                    }

                    @Override
                    public Color getBackground() {
                        return Color.GRAY;
                    }

                };

                JPanel center = new JPanel(new GridBagLayout());
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.weightx = 1;
                gbc.weighty = 1;
                center.add(grayPane, gbc);

                gbc.gridy++;
                gbc.weighty = 0;
                center.add(yellowPane, gbc);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(left, BorderLayout.WEST);
                frame.add(center);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}

