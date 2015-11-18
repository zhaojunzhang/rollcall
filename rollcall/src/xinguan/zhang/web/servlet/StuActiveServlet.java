package xinguan.zhang.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xinguan.zhang.service.StudentService;



public class StuActiveServlet extends HttpServlet {

//激活学生账户
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String activecode=request.getParameter("activecode");
		StudentService studentService = new StudentService();
		studentService.actice_account(activecode);

		//通知用户激活成功
		response.getWriter().print("账户激活成功");

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
