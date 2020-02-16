package com.ahmad.jwt;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.ahmad.utility.dto.Course;

public class DisplayCourses extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		new DisplayCourses();
	}

	public DisplayCourses() {
		JFrame frame = new JFrame("Course Frame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columns = new String[] { "Course No.", "Name", "Price", "Seats", "Duration" };
		
		List<Course> coursesList = selectCourses();
		System.out.println("coursesList:" + coursesList.size());
		Object[][] objArray = new Object[coursesList.size()][5];

		for (int i = 0; i < coursesList.size(); i++) {
			Course course = coursesList.get(i);
			objArray[i] = new Object[] { "" + course.getCourseNo(), course.getCourseName(), "" + course.getPrice(),
					"" + course.getSeats(), "" + course.getDuration() };
		}

		JTable jtable = new JTable(objArray, columns);
		jtable.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 20));
		frame.add(new JScrollPane(jtable));

		frame.setVisible(true);
		frame.setSize(400, 400);

	}

	// public DisplayCourses() {
	// JFrame frame = new JFrame("Course Frame");
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// Border blackline = BorderFactory.createLineBorder(Color.black);
	// JLabel courseNo =new JLabel("Course No.");
	// JLabel courseName =new JLabel("Name");
	// JLabel coursePrice =new JLabel("Price");
	// JLabel courseSeats =new JLabel("Seats");
	// JLabel courseDuration =new JLabel("Duration");
	//
	// frame.add(courseNo);
	// frame.add(courseName);
	// frame.add(coursePrice);
	// frame.add(courseSeats);
	// frame.add(courseDuration);
	//
	// List<Course> coursesList = selectCourses();
	// System.out.println("coursesList:" + coursesList.size());
	// for (int i = 0; i < coursesList.size(); i++) {
	//
	// Course course = coursesList.get(i);
	// JLabel courseNoi = new JLabel(String.valueOf(course.getCourseNo()));
	// JLabel namei = new JLabel(course.getCourseName());
	// JLabel pricei = new JLabel(String.valueOf(course.getPrice()));
	// JLabel seatsi = new JLabel(String.valueOf(course.getSeats()));
	// JLabel durationi = new JLabel(String.valueOf(course.getDuration()));
	// frame.add(courseNoi);
	// frame.add(namei);
	// frame.add(pricei);
	// frame.add(seatsi);
	// frame.add(durationi);
	// }
	// frame.setLayout(new GridLayout(coursesList.size()+1, 5));
	// frame.setVisible(true);
	// frame.setSize(400, 400);
	//
	// }

	private static List<Course> selectCourses() {

		List<Course> courses = new ArrayList<Course>();
		String selectCourses = "Select * from courses;";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmeddb", "root", "root");
			Statement statement = connection.createStatement();
			// statement.executeQuery("insert courses(course_no, Course_name, Price, Seats,
			// Duration) values(104, 'Angular Dev.', 20000.50, 50, 50);");
			ResultSet result = statement.executeQuery(selectCourses);

			while (result.next()) {
				Course course = new Course();
				course.setCourseNo(result.getInt(1));
				course.setCourseName(result.getString(2));
				course.setPrice(result.getDouble(3));
				course.setSeats(result.getInt(4));
				course.setDuration(result.getInt(5));
				// System.out.println(result.getInt(1) + " | " + result.getString(2) + " | " +
				// result.getDouble(3) + " | "
				// + result.getInt(4) + " | " + result.getInt(5));
				// System.out.println(course.toString());
				courses.add(course);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return courses;
	}
}
