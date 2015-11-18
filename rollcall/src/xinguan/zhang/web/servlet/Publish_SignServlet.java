package xinguan.zhang.web.servlet;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import xinguan.zhang.domin.Course;
import xinguan.zhang.domin.Guanxi;
import xinguan.zhang.domin.Student;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.service.CourseService;
import xinguan.zhang.service.GuanxiService;
import xinguan.zhang.service.StudentService;

public class Publish_SignServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//教师id
        String tea_id = request.getParameter("tea_id");
        //课程id
        String cou_id=request.getParameter("course_id");
        //获取Session中的数据
       int teacher_id = Integer.parseInt(tea_id);
       int course_id = Integer.parseInt(cou_id);
       GuanxiService guanxiService = new GuanxiService();
      List<Guanxi> guanxis = guanxiService.query_guanxi(teacher_id,course_id);
      List<Student> students  = new  ArrayList<Student>();
      for(Guanxi guanxi:guanxis){
    	  int student_id = guanxi.getStudent_id();
    	  StudentService studentService =new StudentService();
    	   Student student = studentService.findbyId(student_id);
    	 
    	   students.add(student);
    	  
      }
      CourseService courseService = new CourseService();
         Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
         Course course = courseService.findById(course_id);
         request.setAttribute("teacher", teacher);
         request.setAttribute("course", course);
         request.setAttribute("students", students);
         request.setAttribute("guanxis", guanxis);
         this.getServletContext().setAttribute("teacher", teacher);
         this.getServletContext().setAttribute("course", course);
         this.getServletContext().setAttribute("guanxis", guanxis);
         
         
		request.getRequestDispatcher("/WEB-INF/publish_sign.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
