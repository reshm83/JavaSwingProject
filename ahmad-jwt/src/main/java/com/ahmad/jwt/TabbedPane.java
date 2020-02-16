package com.ahmad.jwt;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

import com.ahmad.utility.dto.Course;

public class TabbedPane extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame f;
	JPanel p1;
	final JPanel p2;
	final JButton update;
	final JPanel p3;
	final JTabbedPane tp;
final JScrollPane jsp;
	TabbedPane() {
		f = new JFrame("Course Database");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		tp = new JTabbedPane();

		update = new JButton("Update");
		JScrollPane scrollFrame = new JScrollPane(p3);
		p3.setAutoscrolls(true);
//		scrollFrame.setPreferredSize(new Dimension(400, 800));
		// f.add(scrollFrame);
		jsp = new JScrollPane(p3);
//		p3.setPreferredSize(new java.awt.Dimension(1330, 1910));
        jsp.setViewportView(p3);

		tp.add("View", jsp);
		tp.add("Edit", p2);
		tp.add("Add", p1);
		f.add(tp);
		f.setSize(1920, 1080);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final Dimension height = f.getSize();
		System.out.println(height);
		f.setLayout(null);

		tp.setBounds(0, 0, 1020, 600);
		f.setVisible(true);

		p3.setVisible(true);
		p1.setSize(1920, 1000);
		panel1();
		panel2(tp);
		PrintCourses(tp);
	}

	private void PrintCourses(final JTabbedPane jtp) {
		Border blackline = BorderFactory.createLineBorder(Color.black);
		JLabel courseNo1 = new JLabel("Course No.", SwingConstants.CENTER);
		JLabel courseName1 = new JLabel("Name", SwingConstants.CENTER);
		JLabel coursePrice1 = new JLabel("Price", SwingConstants.CENTER);
		JLabel courseSeats1 = new JLabel("Seats", SwingConstants.CENTER);
		JLabel courseDuration1 = new JLabel("Duration", SwingConstants.CENTER);
		JLabel edit = new JLabel("Edit", SwingConstants.CENTER);
		JLabel delete = new JLabel("Delete", SwingConstants.CENTER);

		courseNo1.setOpaque(true);
		courseNo1.setFont(new Font("consolas", Font.BOLD, 20));
		courseNo1.setBackground(Color.white);
		courseName1.setOpaque(true);
		courseName1.setFont(new Font("consolas", Font.BOLD, 20));
		courseName1.setBackground(Color.white);
		coursePrice1.setOpaque(true);
		coursePrice1.setFont(new Font("consolas", Font.BOLD, 20));
		coursePrice1.setBackground(Color.white);
		courseSeats1.setOpaque(true);
		courseSeats1.setFont(new Font("consolas", Font.BOLD, 20));
		courseSeats1.setBackground(Color.white);
		courseDuration1.setOpaque(true);
		courseDuration1.setFont(new Font("consolas", Font.BOLD, 20));
		courseDuration1.setBackground(Color.white);
		edit.setOpaque(true);
		edit.setFont(new Font("consolas", Font.BOLD, 20));
		edit.setBackground(Color.white);
		delete.setOpaque(true);
		delete.setFont(new Font("consolas", Font.BOLD, 20));
		delete.setBackground(Color.white);
		courseNo1.setBorder(blackline);
		courseName1.setBorder(blackline);
		coursePrice1.setBorder(blackline);
		courseSeats1.setBorder(blackline);
		courseDuration1.setBorder(blackline);
		delete.setBorder(blackline);

		edit.setBorder(blackline);
		p3.add(courseNo1);
		p3.add(courseName1);
		p3.add(coursePrice1);
		p3.add(courseSeats1);
		p3.add(courseDuration1);

		p3.add(edit);

		p3.add(delete);
		List<Course> coursesList1 = selectCourses();
		// int courseCount = setVlauesInGrid(p3);
		for (final Course course : coursesList1) {
			JLabel courseNoi = new JLabel(String.valueOf(course.getCourseNo()), SwingConstants.CENTER);
			JLabel namei = new JLabel(course.getCourseName(), SwingConstants.CENTER);
			JLabel pricei = new JLabel(String.valueOf(course.getPrice()), SwingConstants.CENTER);
			JLabel seatsi = new JLabel(String.valueOf(course.getSeats()), SwingConstants.CENTER);
			JLabel durationi = new JLabel(String.valueOf(course.getDuration()), SwingConstants.CENTER);
			JButton bEdit = new JButton("Edit");
			JButton bDelete = new JButton("Delete");
//			courseNoi.setFont(new Font("consolas", Font.BOLD, 24));
//			namei.setFont(new Font("consolas", Font.BOLD, 24));
//			pricei.setFont(new Font("consolas", Font.BOLD, 24));
//			seatsi.setFont(new Font("consolas", Font.BOLD, 24));
//			durationi.setFont(new Font("consolas", Font.BOLD, 24));
//			bEdit.setFont(new Font("consolas", Font.BOLD, 24));
//			bDelete.setFont(new Font("consolas", Font.BOLD, 24));
			p3.add(courseNoi);
			p3.add(namei);
			p3.add(pricei);
			p3.add(seatsi);
			p3.add(durationi);
			p3.add(bEdit);
			p3.add(bDelete);
			courseNoi.setBorder(blackline);
			namei.setBorder(blackline);
			pricei.setBorder(blackline);
			seatsi.setBorder(blackline);

			bEdit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// get all data
					jtp.setSelectedIndex(1);
					System.out.println("course.getCourseNo():" + course.getCourseNo());
					p2.setName("" + course.getCourseNo());
					p2.removeAll();
					panel2(tp);

				}
			});
			bDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {

					p3.setName("" + course.getCourseNo());
					int yesOrNo = JOptionPane.showConfirmDialog(f,
							"Do you really want to delete the course with course number " + course.getCourseNo());
					if (yesOrNo == 0) {
						deleteCourse(course.getCourseNo());
					}
				}

				private void deleteCourse(Integer courseNo) {
					String deleteCourse = "delete from courses where course_no=" + courseNo + ";";
					try {

						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmeddb",
								"root", "root");
						Statement statement = connection.createStatement();
						statement.executeUpdate(deleteCourse);
						// System.out.println(selectCourses);
						System.out.println("Updated");

					} catch (Exception e) {
						System.err.println(e);
					}
					p3.removeAll();
					PrintCourses(tp);
				}
			});

			durationi.setBorder(blackline);
		}

		p3.setPreferredSize(new Dimension(900,coursesList1.size()*30));
		p3.setLayout(new GridLayout(coursesList1.size() + 1, 7));
		// JButton update = new JButton("Refresh");
		//
		// update.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// // get all data
		// System.out.println("get all data.....");
		////
		// p3.removeAll();
		// PrintCourses(jtp);
		//// p3.repaint();
		// }
		// });
		// p3.add(new JLabel());
		// p3.add(new JLabel());
		// p3.add(update);
	}

	//// public static int setVlauesInGrid(JPanel p3) {
	// Border blackline = BorderFactory.createLineBorder(Color.black);
	// List<Course> coursesList1 = selectCourses();
	// System.out.println("coursesList:" + coursesList1.size());
	//
	// for (int i = 0; i < coursesList1.size(); i++) {
	// Course course = coursesList1.get(i);
	// JLabel courseNoi = new JLabel(String.valueOf(course.getCourseNo()),
	//// SwingConstants.CENTER);
	// JLabel namei = new JLabel(course.getCourseName(), SwingConstants.CENTER);
	// JLabel pricei = new JLabel(String.valueOf(course.getPrice()),
	//// SwingConstants.CENTER);
	// JLabel seatsi = new JLabel(String.valueOf(course.getSeats()),
	//// SwingConstants.CENTER);
	// JLabel durationi = new JLabel(String.valueOf(course.getDuration()),
	//// SwingConstants.CENTER);
	//
	// p3.add(courseNoi);
	// p3.add(namei);
	// p3.add(pricei);
	// p3.add(seatsi);
	// p3.add(durationi);
	// p3.add(new JButton("Edit"));
	// courseNoi.setBorder(blackline);
	// namei.setBorder(blackline);
	// pricei.setBorder(blackline);
	// seatsi.setBorder(blackline);
	// durationi.setBorder(blackline);
	// }
	// return coursesList1.size();
	// }
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TabbedPane();
			}
		});
		// new TabbedPane();
	}

	private static int insertCoursePrepared(Course course) {
		int count = 0;
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
			count = ps.executeUpdate();
			System.out.println("insert count:" + count);
		} catch (Exception e) {
			System.err.println(e);
		}
		return count;
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

	private void updateCourse(Integer duration, Double price, String name, Integer seats, Integer number) {
		String selectCourses = "update courses set course_name=\"" + name + "\",Seats=" + seats + ", price=" + price
				+ ", duration=" + duration + " where course_no=" + number + ";";
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ahmeddb", "root", "root");
			Statement statement = connection.createStatement();
			statement.executeUpdate(selectCourses);
			System.out.println(selectCourses);
			System.out.println("Updated");

		} catch (Exception e) {
			System.err.println(e);
		}

	}

	private void panel1() {
		JButton add = new JButton("Save");
		JButton clean = new JButton("Clean");
		add.setFont(new Font("Consolas", Font.PLAIN, 30));
		clean.setFont(new Font("Consolas", Font.PLAIN, 30));

		GridBagConstraints gbc = new GridBagConstraints();
		JLabel courseNo = new JLabel("Course Number: ");
		courseNo.setFont(new Font("Consolas", Font.PLAIN, 30));
		JLabel courseName = new JLabel("Course Name: ");
		JLabel coursePrice = new JLabel("Course Price: ");
		JLabel courseSeats = new JLabel("Course Seats: ");
		JLabel courseDuration = new JLabel("Course Duration: ");
		courseName.setFont(new Font("Consolas", Font.PLAIN, 30));
		coursePrice.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseSeats.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseDuration.setFont(new Font("Consolas", Font.PLAIN, 30));
		gbc.weightx = 1;
		final JTextField courseNoT = new JTextField("");
		final JTextField courseNameT = new JTextField("");
		final JTextField coursePriceT = new JTextField("");
		final JTextField courseSeatsT = new JTextField("");
		final JTextField courseDurationT = new JTextField("");
		JButton update = new JButton("Update");
		courseNoT.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseNameT.setFont(new Font("Consolas", Font.PLAIN, 30));
		coursePriceT.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseSeatsT.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseDurationT.setFont(new Font("Consolas", Font.PLAIN, 30));
		update.setFont(new Font("Consolas", Font.PLAIN, 30));
		p1.setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		p1.add(courseNo, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		p1.add(courseNoT, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		p1.add(courseName, gbc);
		gbc.gridx = 1;
		courseNoT.setSize(new Dimension(20, 100));
		gbc.gridy = 1;
		p1.add(courseNameT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		p1.add(coursePrice, gbc);
		gbc.gridx = 1;
		courseNoT.setSize(new Dimension(20, 100));

		gbc.gridy = 2;
		p1.add(coursePriceT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		p1.add(courseSeats, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		p1.add(courseSeatsT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
		p1.add(courseDuration, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		p1.add(courseDurationT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 5;

		p1.add(add, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;

		p1.add(clean, gbc);

		add.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// validate course number
				Integer number = null;
				int error = 0;
				try {

					String numStr = courseNoT.getText();

					if (numStr == "") {
						error += 1;
						JOptionPane.showMessageDialog(f, "Please enter course number.");
					}
					number = Integer.parseInt(courseNoT.getText());
				} catch (Exception e) {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter correct course number.");
				}
				// validate course name
				String crsName = courseNameT.getText();
				if (crsName == "") {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter course name.");
				}

				// validate price
				Double price = 0.0;
				try {
					String numStr = coursePriceT.getText();
					if (numStr == "") {
						error += 1;
						JOptionPane.showMessageDialog(f, "Please enter price.");
					}
					price = Double.parseDouble(coursePriceT.getText());
				} catch (Exception e) {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter valid price.");
				}
				// validate seats
				Integer seats = 0;
				try {
					String seatStr = courseSeatsT.getText();
					if (seatStr == "") {
						error += 1;
						JOptionPane.showMessageDialog(f, "Please enter seat number.");
					}
					seats = Integer.parseInt(courseSeatsT.getText());
				} catch (Exception e) {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter valid seats number.");
				}
				// validate duration
				Integer duration = 0;
				try {
					String durStr = courseDurationT.getText();
					if (durStr == "") {
						error += 1;
						JOptionPane.showMessageDialog(f, "Please enter duration value.");
					}
					duration = Integer.parseInt(courseDurationT.getText());
				} catch (Exception e) {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter valid duration value.");
				}
				try {
					// insert the course data
					if (error == 0) {

						Course course1 = new Course(number, crsName, price, seats, duration);

						int count = insertCoursePrepared(course1);
						if (count == 1) {
							JOptionPane.showMessageDialog(f, "Course inserted successfully.");
							p3.removeAll();
							PrintCourses(tp);
						}
					} else {
						error = 0;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(f, "Oops! There is some error. Please Enter Correct Values");
				}

			}
		});
		p1.setVisible(true);
		p1.setSize(1920, 1080);

		clean.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				courseNoT.setText("");
				courseNameT.setText("");
				courseDurationT.setText("");
				courseSeatsT.setText("");
				coursePriceT.setText("");

			}
		});

	}

	private void panel2(final JTabbedPane jtp) {
		System.out.println("" + p2.getName());
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel courseNo = new JLabel("Course Number: ");
		courseNo.setFont(new Font("Consolas", Font.PLAIN, 30));
		JLabel courseName = new JLabel("Course Name: ");
		JLabel coursePrice = new JLabel("Course Price: ");
		JLabel courseSeats = new JLabel("Course Seats: ");
		JLabel courseDuration = new JLabel("Course Duration: ");
		courseName.setFont(new Font("Consolas", Font.PLAIN, 30));
		coursePrice.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseSeats.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseDuration.setFont(new Font("Consolas", Font.PLAIN, 30));
		gbc.weightx = 1;
		final JTextField courseNoT = new JTextField();
		final JTextField courseNameT = new JTextField();
		final JTextField coursePriceT = new JTextField();
		final JTextField courseSeatsT = new JTextField();
		final JTextField courseDurationT = new JTextField();
		final JButton retrieve = new JButton("Retrieve");
		JButton update = new JButton("Update");
		courseNoT.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseNameT.setFont(new Font("Consolas", Font.PLAIN, 30));
		coursePriceT.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseSeatsT.setFont(new Font("Consolas", Font.PLAIN, 30));
		courseDurationT.setFont(new Font("Consolas", Font.PLAIN, 30));
		update.setFont(new Font("Consolas", Font.PLAIN, 30));
		retrieve.setFont(new Font("Consolas", Font.PLAIN, 30));

		final JComboBox<?> ComboBox = new JComboBox();
		final List<Course> coursesList1 = selectCourses();
		String[] courseNoList = new String[coursesList1.size()];
		// int courseCount = setVlauesInGrid(p3);
		for (int i = 0; i < coursesList1.size(); i++) {
			Course course = coursesList1.get(i);
			courseNoList[i] = "" + course.getCourseNo();
		}
		ComboBox.setModel(new javax.swing.DefaultComboBoxModel(courseNoList));
		ComboBox.setFont(new Font("Consolas", Font.PLAIN, 30));

		p2.setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		p2.add(courseNo, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		p2.add(courseNoT, gbc);
		courseNoT.setEnabled(false);
		// p2.add(ComboBox, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		p2.add(courseName, gbc);
		gbc.gridx = 1;
		courseNoT.setSize(new Dimension(20, 100));
		gbc.gridy = 1;
		p2.add(courseNameT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		p2.add(coursePrice, gbc);
		gbc.gridx = 1;
		courseNoT.setSize(new Dimension(20, 100));

		gbc.gridy = 2;
		p2.add(coursePriceT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 3;
		p2.add(courseSeats, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		p2.add(courseSeatsT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 4;
		p2.add(courseDuration, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		p2.add(courseDurationT, gbc);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		p2.add(update, gbc);
		if (p2.getName() != null) {
			Course course = null;
			for (int i = 0; i < coursesList1.size(); i++) {
				Course courseOld = coursesList1.get(i);

				if (p2.getName().toString().equals(courseOld.getCourseNo().toString())) {
					course = courseOld;
				}
			}
			courseNoT.setText(course.getCourseNo().toString());
			courseNameT.setText(course.getCourseName());
			coursePriceT.setText(course.getPrice().toString());
			courseSeatsT.setText(course.getSeats().toString());
			courseDurationT.setText(course.getDuration().toString());
		}

		update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent AE) {

				int error = 0;
				// validate course name
				String crsName = courseNameT.getText();
				if (crsName == "") {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter course name.");
				}

				// validate price
				Double price = 0.0;
				try {
					String numStr = coursePriceT.getText();
					if (numStr == "") {
						error += 1;
						JOptionPane.showMessageDialog(f, "Please enter price.");
					}
					price = Double.parseDouble(coursePriceT.getText());
				} catch (Exception e) {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter valid price.");
				}
				// validate seats
				Integer seats = 0;
				try {
					String seatStr = courseSeatsT.getText();
					if (seatStr == "") {
						error += 1;
						JOptionPane.showMessageDialog(f, "Please enter seat number.");
					}
					seats = Integer.parseInt(courseSeatsT.getText());
				} catch (Exception e) {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter valid seats number.");
				}
				// validate duration
				Integer duration = 0;
				try {
					String durStr = courseDurationT.getText();
					if (durStr == "") {
						error += 1;
						JOptionPane.showMessageDialog(f, "Please enter duration value.");
					}
					duration = Integer.parseInt(courseDurationT.getText());
				} catch (Exception e) {
					error += 1;
					JOptionPane.showMessageDialog(f, "Please enter valid duration value.");
				}
				try {
					// insert the course data
					if (error == 0) {
						updateCourse(Integer.parseInt(courseDurationT.getText()),
								Double.parseDouble(coursePriceT.getText()), courseNameT.getText(),
								Integer.parseInt(courseSeatsT.getText()), Integer.parseInt(p2.getName()));
						JOptionPane.showMessageDialog(f, "Updated successfully.");
						p3.removeAll();
						PrintCourses(jtp);
						tp.setSelectedIndex(0);
					} else {
						error = 0;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(f, "Oops! There is some error. Please Enter Correct Values");
					System.err.println(e);
					e.printStackTrace();
				}

				System.out.println("Updated");

			}
		});
		retrieve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Course course = null;
				for (int i = 0; i < coursesList1.size(); i++) {
					Course courseOld = coursesList1.get(i);

					if (p2.getName().toString().equals(courseOld.getCourseNo().toString())) {
						course = courseOld;
					}
				}
				courseNameT.setText(course.getCourseName());
				coursePriceT.setText(course.getPrice().toString());
				courseSeatsT.setText(course.getSeats().toString());
				courseDurationT.setText(course.getDuration().toString());
			}
		});
		p2.setVisible(true);
		p2.setSize(1920, 1080);

	}
}
