package com.bw.Studao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bw.entity.Student;

public class Studao {



	public List<Student> stulist() throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql:///stuu", "root", "root");
		PreparedStatement ps = conn.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();
		List<Student> list = new ArrayList<Student>();
		while(rs.next())
		{
			Student s = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
			list.add(s);
		}
		rs.close();
		ps.close();
		conn.close();
		return list;
	}

	public Student checkStu(String name) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///stuu",
				"root", "root");
		PreparedStatement ps = con
				.prepareStatement("SELECT * from student where sname=?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		Student stu = null;
		while(rs.next()){
			 stu = new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
		}
		rs.close();
		ps.close();
		con.close();
		return stu;
	}

	public int insert(String sname, String sex, String age, String birthday,
			String card) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql:///stuu",
				"root", "root");
		PreparedStatement ps = con
				.prepareStatement("insert into student values(null,?,?,?,?,?)");
		ps.setString(1, sname);
		ps.setString(2, sex);
		ps.setString(3, age);
		ps.setString(4, birthday);
		ps.setString(5, card);
		int i = ps.executeUpdate();
		ps.close();
		con.close();
		return i;
	}

	
}
