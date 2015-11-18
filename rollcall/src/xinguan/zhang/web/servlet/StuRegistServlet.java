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

public class StuRegistServlet extends HttpServlet {

	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//��ÿͻ��˵���֤��
		String checkcode = request.getParameter("checkcode");
		
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		
		//��Session��ɾ��Session
        request.getSession().removeAttribute("checkcode_session");
        if(checkcode==null||!checkcode.equals(checkcode_session)){
        	//��֤�벻��ȷ
        	request.setAttribute("msg", "��֤�����");
        	request.getRequestDispatcher("/stu_regist.jsp").forward(request, response);
        }
       
        else{
        	String stu_id = request.getParameter("stu_id");
        	
        	Student student = new Student();
        	try {
        		//��form���ݷ�װ��javabean��
				BeanUtils.populate(student, request.getParameterMap());
				System.out.println(student.getStu_id());
				//student.setStu_id(stu_id);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//3�������ݴ��ݵ�ҵ���
        	StudentService studentService = new StudentService();
            int num  =  studentService.stu_regist(student);
        	if(num==1){
        		request.setAttribute("msg", "�û����Ѵ���");
            	request.getRequestDispatcher("/stu_regist.jsp").forward(request, response);
        	}
        	if(num==2){
        		request.setAttribute("msg", "�����Ѵ���");
            	request.getRequestDispatcher("/stu_regist.jsp").forward(request, response);
        	}
        	//4����ʾע����Ϣ
        	response.getWriter().print("ע��ɹ��������ʼ��ѷ�����ע�����䣬����2Сʱ������˺ż��");
        }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
