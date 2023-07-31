package com.evarion.library.libraryArchive;

public class MyPanelMain {
    public static void main(String[] args) {

        MyPanel frameMain = new MyPanel();
        MyPanel topButtonMenu = new MyPanel();
        frameMain.createPanel(frameMain, topButtonMenu);

    }
}
