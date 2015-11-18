package xinguan.zhang.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xinguan.zhang.domin.Student;

public class Stu_SignInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Student student = (Student) request.getSession().getAttribute("student");
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("/WEB-INF/stu_signinfo.jsp").forward(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
