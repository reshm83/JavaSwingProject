package com.ahmad.jwt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Tab extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Tab() {
		JFrame f= new JFrame();
		JTabbedPane tp = new JTabbedPane();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		tp.add("Tab1", p1);
		tp.add("Tab2", p2);
		JButton button = new JButton("Switch");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tp.setSelectedIndex(1);
			}
		});
		p1.add(button);
		f.add(tp);
		f.setVisible(true);
		f.setSize(400,400);
	}
	public static void main(String[] args) {
		new Tab();
	}
	
}