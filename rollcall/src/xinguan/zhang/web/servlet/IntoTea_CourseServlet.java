package xinguan.zhang.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import xinguan.zhang.domin.Course;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.service.CourseService;

public class IntoTea_CourseServlet extends HttpServlet {

	//注入老师课程信息
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Course course = new Course();
		try {
			BeanUtils.populate(course, request.getParameterMap());
			Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
			course.setTeacher_id(teacher.getId());
			CourseService courseService =new CourseService();
			courseService.insert_course(course);
			request.setAttribute("teacher", teacher);
			request.getRequestDispatcher("/WEB-INF/tea_function.jsp").forward(request, response);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
