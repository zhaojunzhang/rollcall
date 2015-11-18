package xinguan.zhang.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xinguan.zhang.domin.Guanxi;
import xinguan.zhang.domin.Student;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.service.GuanxiService;
import xinguan.zhang.service.StudentService;

public class Select_TeaCourseServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//教师id
         String tea_id = request.getParameter("tea_id");
         //课程id
         String cou_id=request.getParameter("course_id");
         //获取Session中的数据
        Student student = (Student) request.getSession().getAttribute("student");
        //学生id
		int student_id = student.getId();
		int teacher_id = Integer.parseInt(tea_id);
		int course_id = Integer.parseInt(cou_id);
		Guanxi guanxi = new Guanxi();
		guanxi.setStudent_id(student_id);
		guanxi.setTeacher_id(teacher_id);
		guanxi.setCourse_id(course_id);
		
		GuanxiService guanxiService = new GuanxiService();
		guanxiService.insert_info(guanxi);
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
