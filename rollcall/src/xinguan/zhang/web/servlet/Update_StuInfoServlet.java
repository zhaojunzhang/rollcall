package xinguan.zhang.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import xinguan.zhang.domin.Student;
import xinguan.zhang.service.StudentService;

public class Update_StuInfoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
         Student student  = new Student();
         try {
			BeanUtils.populate(student, request.getParameterMap());
			StudentService studentService= new StudentService();
			//修改学生信息
			studentService.update_stuinfo(student);
			//根据Id查询学生信息
			Student student1= studentService.findbyId(student.getId());
			request.setAttribute("student", student1);
			request.getRequestDispatcher("/WEB-INF/stu_function.jsp").forward(request, response);
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
