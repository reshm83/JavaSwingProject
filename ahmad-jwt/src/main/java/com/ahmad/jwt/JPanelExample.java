package com.ahmad.jwt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JPanelExample  extends JFrame{

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// JButton 
    static JButton b, b1, b2; 
  
	public static void main(String[] args) {
		init();
	}
	
	public static void init() {
		
		// create a new frame to store text field and button 
        JFrame f = new JFrame("panel"); 
  
       
        // create a new buttons 
        b = new JButton("button1"); 
        b1 = new JButton("button2"); 
        //b2 = new JButton("button3"); 
  
        // create a panel to add buttons 
        JPanel p = new JPanel(); 
  		p.setBounds(40, 80, 200,200);
  		p.setBackground(Color.GRAY);
        // add buttons and textfield to panel 
        p.add(b); 
        p.add(b1); 
        //p.add(b2); 
        
        // create a label to display text 
        JLabel l = new JLabel("panel label"); 
        final JTextField text = new JTextField();
        text.setSize(new Dimension(10, 120));
        text.setBounds(100,100, 200, 30);
        text.setBackground(Color.GREEN);
        
        p.add(l); 
        p.add(text);
  
        b.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				text.setText("Welcome to Javatpoint.");				
			}
		});
        // setbackground of panel 
        p.setBackground(Color.CYAN); 
  
        // add panel to frame 
        f.add(p); 
  
        // set the size of frame 
        f.setSize(300, 300); 
       // f.setLayout(null);
        f.setVisible(true);
	}
}
