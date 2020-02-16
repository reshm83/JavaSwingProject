package com.ahmad.jwt;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GridLayoutExample extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new GridLayoutExample();
	}

	public GridLayoutExample() {
		
		// create a new frame to store text field and button 
        JFrame f = new JFrame("My Frame"); 
  
       
        // create a new buttons 
        JButton b = new JButton("Add");
        JButton b1 = new JButton("Clean");
  
        // create a label to display text 
        JLabel l = new JLabel("panel label"); 
        final JTextField text = new JTextField();
        //text.setSize(new Dimension(10, 120));
        //text.setBounds(100,100, 200, 30);
        text.setBackground(Color.GREEN);
        
        
        b.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				text.setText("Welcome to Javatpoint.");	
				String courNo = text.getText();
				System.out.println(courNo);
//				Course couse = new Course();
//				course.setCourseNo();
//				couser.serCourseName();
//				db,insertData*(course)
				
			}
		});
        b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				text.setText("");				
			}
		});
        // setbackground of panel 
        f.add(l); f.add(text); f.add(b);f.add(b1);
        
        f.setLayout(new GridLayout(2, 5));
        // set the size of frame 
        f.setSize(300, 300); 
       // f.setLayout(null);
        f.setVisible(true);

        
	}
}
