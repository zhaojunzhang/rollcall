package xinguan.zhang.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import xinguan.zhang.domin.Student;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.domin.User;
import xinguan.zhang.service.StudentService;
import xinguan.zhang.service.TeacherService;

public class LoginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		User user  = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
		
			if(user.getRole().equals("teacher")){
				TeacherService teacherService = new TeacherService();
				
			    Teacher teacher=teacherService.tea_login(user);
			    if(teacher==null){
			    	request.setAttribute("msg", "��������˻�������");
			    	request.getRequestDispatcher("/login.jsp").forward(request, response);
			    }else{

			    request.setAttribute("teacher", teacher);
			    //����¼��Ϣ����Session��
			    request.getSession().setAttribute("teacher", teacher);
			    //ת������ʦ������ҳ��
			    request.getRequestDispatcher("/WEB-INF/tea_function.jsp").forward(request, response);
			    }
			}
			if(user.getRole().equals("student")){
				StudentService studentService = new StudentService();
				Student student =studentService.stu_login(user);
				 if(student==null){
				    	request.setAttribute("msg", "��������˻�������");
				    	request.getRequestDispatcher("/login.jsp").forward(request, response);
				    }else{
				request.setAttribute("student", student);
				//����½��Ϣ����Session��
				request.getSession().setAttribute("student", student);
				request.getRequestDispatcher("/WEB-INF/stu_function.jsp").forward(request, response);
				    }
			}
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
