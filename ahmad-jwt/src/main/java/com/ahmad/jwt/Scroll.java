package com.ahmad.jwt;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Scroll extends JFrame {
	public Scroll() {
		getContentPane().setLayout(new BorderLayout());

		JPanel panel = createPanel();

		getContentPane().add(BorderLayout.CENTER, new JScrollPane(panel));

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
	}

	public static JPanel createPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(20, 4, 10, 10));

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel label = new JLabel("label " + i + ", " + j);
				label.setFont(new Font("Helvetica", Font.PLAIN, 30));
				panel.add(label);
			}
		}

		return panel;
	}

	public static void main(String[] args) {
		Scroll main = new Scroll();
		main.setSize(300, 300);
		main.setVisible(true);
	}
}