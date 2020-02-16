/**
 * 
 */
package com.ahmad.jwt;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Usman-F
 *
 */
public class JwtTest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public JwtTest() {
		System.out.println("default constructor");
		JButton b = new JButton("click me");
		b.setBounds(30, 100, 80, 30);// setting button position
		add(b);// adding button into frame
		setSize(300, 300);// frame size 300 width and 300 height
		setLayout(null);// no layout manager
		setVisible(true);// now frame will be visible, by default not visible
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("JWT examples.....");
		new JwtTest();
	}

}
