package com.tg50624;

import javax.swing.*;

public class Main{

    public static void main(String[] args) {
	    JFrame frame = new JFrame("Block Breaking Game");
		BlockPanel panel = new BlockPanel();
		frame.getContentPane().add(panel);
	    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(900,900);
    }
}
