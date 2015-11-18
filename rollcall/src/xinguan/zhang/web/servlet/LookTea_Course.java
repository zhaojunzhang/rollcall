package xinguan.zhang.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xinguan.zhang.domin.Teacher;
import xinguan.zhang.service.TeacherService;

public class LookTea_Course extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id= request.getParameter("id");
		
		TeacherService teacherService = new TeacherService();
		//根据教师编号查询教师课程信息
		List<Teacher> teachers = teacherService.looktea_course(id);
        
		request.setAttribute("teachers", teachers);
		request.getRequestDispatcher("/WEB-INF/looktea_course.jsp").forward(request, response);
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
