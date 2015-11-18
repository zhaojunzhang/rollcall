package xinguan.zhang.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xinguan.zhang.domin.Teacher;
import xinguan.zhang.service.StudentService;

//学生查询老师讲课列表
public class Query_TeaCourseServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          StudentService studentService = new StudentService();
          List<Teacher> teachers = studentService.query_teacourseservlet();
         
          request.setAttribute("teachers", teachers);
          request.getRequestDispatcher("/WEB-INF/lookAlltea_course.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
