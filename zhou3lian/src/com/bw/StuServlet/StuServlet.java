package com.bw.StuServlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bw.StuService.Stuservice;
import com.bw.entity.Student;

public class StuServlet extends HttpServlet {
	Stuservice service = new Stuservice();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String m = request.getParameter("m");
		if(m.equals("stulist"))
		{
			stulist(request,response);
		}else if(m.equals("checkstu"))
		{
			checkstu(request,response);
		}else if(m.equals("insert"))
		{
			insert(request,response);
		} 
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String sname = request.getParameter("sname");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String birthday = request.getParameter("birthday");
		String card = request.getParameter("card");
		
		
		try {
			int i = service.insert(sname,sex,age,birthday,card);
			response.getWriter().print(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void checkstu(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name = request.getParameter("sname");
		try {
			Student stu = service.checkStu(name);
			if(stu!=null)
			{
				response.getWriter().print("false");
			}
			else
			{
				response.getWriter().print("true");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//展示列表
	private void stulist(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			List<Student> list = service.stulist();
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
}
