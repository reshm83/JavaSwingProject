package com.ahmad.jwt;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GridLayoutBag {
	public static void main(String[] args) {
		new GridLayoutBag();
	}
	public GridLayoutBag() {
	JFrame frame = new JFrame();
	GridBagLayout grid= new GridBagLayout();
	GridBagConstraints constrains = new GridBagConstraints();

	frame.setLayout(grid);

	JTextField name = new JTextField();
	JPasswordField pass = new JPasswordField();
	
	constrains.fill = GridBagConstraints.HORIZONTAL;
    constrains.ipadx = 0;  

	constrains.gridx = 0;
	constrains.gridy = 0;

	frame.add(new JLabel("Name"), constrains);
    constrains.ipadx = 90;  
	constrains.gridx = 1;
	constrains.gridy = 0;
	frame.add(name, constrains);
	constrains.fill = GridBagConstraints.HORIZONTAL;
    constrains.ipadx = 0;  
	constrains.gridx = 0;
	constrains.gridy = 1;
	frame.add(new JLabel("Password"), constrains);
    constrains.ipadx = 90;  

	constrains.gridx = 1;
	constrains.gridy = 1;
	pass.setSize(20, 100);
	frame.add(pass, constrains);
	
	frame.setSize(400,400);
	frame.setVisible(true);
	}
	
}