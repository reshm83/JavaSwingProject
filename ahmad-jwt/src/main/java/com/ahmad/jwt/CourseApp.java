package com.ahmad.jwt;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

import com.ahmad.utility.dto.Course;

public class CourseApp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseApp() {
		JFrame frame = new JFrame();
		JLabel courseNo = new JLabel("Course Number: ");
		JLabel courseName = new JLabel("Course Name: ");
		JLabel coursePrice = new JLabel("Course Price: ");
		JLabel courseSeats = new JLabel("Course Seats: ");
		JLabel courseDuration = new JLabel("Course Duration: ");
		final JTextField courseNoT = new JTextField("");
		final JTextField courseNameT = new JTextField("");
		final JTextField coursePriceT = new JTextField("");
		final JTextField courseSeatsT = new JTextField("");
		final JTextField courseDurationT = new JTextField("");
		JButton add = new JButton("Add");
		JButton print = new JButton("Print");

		frame.add(courseNo);
		frame.add(courseNoT);

		frame.add(courseName);
		frame.add(courseNameT);

		frame.add(coursePrice);
		frame.add(coursePriceT);

		frame.add(courseSeats);
		frame.add(courseSeatsT);

		frame.add(courseDuration);
		frame.add(courseDurationT);

		frame.add(add);
		frame.add(print);

		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				Course course1 = new Course(Integer.parseInt(courseNoT.getText()), courseNameT.getText(),
						Double.parseDouble(coursePriceT.getText()), Integer.parseInt(courseSeatsT.getText()),
						Integer.parseInt(courseDurationT.getText()));
				insertCoursePrepared(course1);

			}
		});
		print.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				selectCourses();
				
			}
		});
		frame.setLayout(new GridLayout(6, 2));
		frame.setVisible(true);
		frame.setSize(400, 400);
	}

	public static void main(String[] args) {
		 new CourseApp();
	}

	private static void insertCoursePrepared(Course course) {
		String insertCourses = "insert courses(course_no, Course_name, Price, Seats, Duration) values(?, ?, ?, ?, ?)";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmeddb", "root", "root");
			PreparedStatement ps = connection.prepareStatement(insertCourses);
			ps.setInt(1, course.getCourseNo());
			ps.setString(2, course.getCourseName());
			ps.setDouble(3, course.getPrice());
			ps.setInt(4, course.getSeats());
			ps.setInt(5, course.getDuration());
			int count = ps.executeUpdate();
			System.out.println("insert count:" + count);
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static void selectCourses() {

		String selectCourses = "Select * from courses order by course_no asc;";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmeddb", "root", "root");
			Statement statement = connection.createStatement();
			// statement.executeQuery("insert courses(course_no, Course_name, Price, Seats,
			// Duration) values(104, 'Angular Dev.', 20000.50, 50, 50);");
			ResultSet result = statement.executeQuery(selectCourses);
			while (result.next()) {
				System.out.println(result.getInt(1) + " | " + result.getString(2) + " | " + result.getDouble(3) + " | "
						+ result.getInt(4) + " | " + result.getInt(5));
			}
			System.out.println("-------------------------------------------------------------------");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}

