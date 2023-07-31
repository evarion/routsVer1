package com.evarion.library.libraryArchive;


import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Scroll {
    public static void main(String args[]) {
        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button1 = new JButton("Questions and Answers");
        JButton button2 = new JButton("Videos");
        JButton button3 = new JButton("Tools");
        JButton button4 = new JButton("Tutorials");
        JButton button5 = new JButton("Online Compiler");
        JButton button6 = new JButton("Quiz");
        Box box = Box.createVerticalBox();
        box.setPreferredSize(new Dimension(900,900));
        box.add(button1);
        box.add(button2);
        box.add(button3);
        box.add(button4);
        box.add(button5);
        box.add(button6);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(box);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(550, 250);
        frame.setVisible(true);
    }
}

