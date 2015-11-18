package xinguan.zhang.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xinguan.zhang.domin.Guanxi;
import xinguan.zhang.domin.Student;
import xinguan.zhang.service.GuanxiService;

public class Stu_SignServlet extends HttpServlet {
//签到页面
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//教师id
        String tea_id = request.getParameter("tea_id");
        //课程id
        String cou_id=request.getParameter("course_id");
        //获取学生id
        String stu_id= request.getParameter("student_id");
        //获取Session中的数据
       Student student = (Student) request.getSession().getAttribute("student");
       //学生id
		int student_id = student.getId();
		int student_id1 = Integer.parseInt(stu_id);
		int teacher_id = Integer.parseInt(tea_id);
		int course_id = Integer.parseInt(cou_id);
		if(student_id!=student_id1){
			response.getWriter().print("不是本人签到");
		}else{
		Guanxi guanxi = new Guanxi();
		
		guanxi.setStudent_id(student_id);
		guanxi.setTeacher_id(teacher_id);
		guanxi.setCourse_id(course_id);
		GuanxiService guanxiService = new GuanxiService();
		guanxiService.updatestu_num(guanxi);
		
		response.getWriter().print("签到成功");
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
