package xinguan.zhang.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xinguan.zhang.domin.Teacher;
import xinguan.zhang.service.CourseService;
import xinguan.zhang.service.TeacherService;

public class Cancle_CourseServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		CourseService courseService = new CourseService();
		courseService.delbyid(id);
		//获得用户的信息
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
	    TeacherService teacherService = new TeacherService();
	   
	    String id1 = Integer.toString(teacher.getId()); 
	    
	   List<Teacher> teachers =  teacherService.looktea_course(id1);
	   request.setAttribute("teachers", teachers);
	   request.getRequestDispatcher("/WEB-INF/looktea_course.jsp").forward(request, response);
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
