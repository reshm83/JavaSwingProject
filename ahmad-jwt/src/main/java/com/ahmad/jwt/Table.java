package com.ahmad.jwt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.ahmad.utility.dto.Course;

public class Table {
	public Table() {
		JFrame f = new JFrame();
		List<Course> courses = selectCourses();
		Object[] header = new Object[] { "Course No.", "Name", "Price", "Seats", "Duration", "Edit", "Delete" };
		Object[][] coursesList = new Object[courses.size()][6];

		for (int i = 0; i < courses.size(); i++) {
			Course course = courses.get(i);
			Object[] courseArray = { course.getCourseNo(), course.getCourseName(), course.getPrice(), course.getSeats(),
					course.getDuration(), "Edit", "Delete" };
			coursesList[i] = courseArray;
		}
		JTable table = new JTable(coursesList, header);

		// SET CUSTOM RENDERER TO TEAMS COLUMN
		table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
		;

		// SET CUSTOM EDITOR TO TEAMS COLUMN
		table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));
		table.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
		;

		// SET CUSTOM EDITOR TO TEAMS COLUMN
		table.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));

		// SCROLLPANE,SET SZE,SET CLOSE OPERATION
		JScrollPane pane = new JScrollPane(table);
		f.getContentPane().add(pane);
		f.setSize(750, 450);
		f.setVisible(true);

	}

	public static void main(String[] args) {
		new Table();
		// System.out.println(courses.toString());
	}

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
				courses.add(course);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		return courses;
	}

}