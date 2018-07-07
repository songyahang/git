package com.bw.StuService;

import java.util.List;

import com.bw.Studao.Studao;
import com.bw.entity.Student;

public class Stuservice {
	Studao dao = new Studao();

	

	public List<Student> stulist() throws Exception {
		// TODO Auto-generated method stub
		List<Student> list =  dao.stulist();
		return list;
	}



	public Student checkStu(String name) throws Exception {
		// TODO Auto-generated method stub
		Student stu = dao.checkStu(name);
		return stu;
	}



	public int insert(String sname, String sex, String age, String birthday,
			String card) throws Exception {
		// TODO Auto-generated method stub
		int i = dao.insert(sname,sex,age,birthday,card);
		return i;
	}
	
}
