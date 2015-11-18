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
//ǩ��ҳ��
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ʦid
        String tea_id = request.getParameter("tea_id");
        //�γ�id
        String cou_id=request.getParameter("course_id");
        //��ȡѧ��id
        String stu_id= request.getParameter("student_id");
        //��ȡSession�е�����
       Student student = (Student) request.getSession().getAttribute("student");
       //ѧ��id
		int student_id = student.getId();
		int student_id1 = Integer.parseInt(stu_id);
		int teacher_id = Integer.parseInt(tea_id);
		int course_id = Integer.parseInt(cou_id);
		if(student_id!=student_id1){
			response.getWriter().print("���Ǳ���ǩ��");
		}else{
		Guanxi guanxi = new Guanxi();
		
		guanxi.setStudent_id(student_id);
		guanxi.setTeacher_id(teacher_id);
		guanxi.setCourse_id(course_id);
		GuanxiService guanxiService = new GuanxiService();
		guanxiService.updatestu_num(guanxi);
		
		response.getWriter().print("ǩ���ɹ�");
		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
