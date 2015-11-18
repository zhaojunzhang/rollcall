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
	
		//或得客户端的验证码
		String checkcode = request.getParameter("checkcode");
		
		String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
		
		//从Session中删除Session
        request.getSession().removeAttribute("checkcode_session");
        if(checkcode==null||!checkcode.equals(checkcode_session)){
        	//验证码不正确
        	request.setAttribute("msg", "验证码错误");
        	request.getRequestDispatcher("/stu_regist.jsp").forward(request, response);
        }
       
        else{
        	String stu_id = request.getParameter("stu_id");
        	
        	Student student = new Student();
        	try {
        		//将form数据封装到javabean中
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
        	//3，将数据传递到业务层
        	StudentService studentService = new StudentService();
            int num  =  studentService.stu_regist(student);
        	if(num==1){
        		request.setAttribute("msg", "用户名已存在");
            	request.getRequestDispatcher("/stu_regist.jsp").forward(request, response);
        	}
        	if(num==2){
        		request.setAttribute("msg", "邮箱已存在");
            	request.getRequestDispatcher("/stu_regist.jsp").forward(request, response);
        	}
        	//4，显示注册信息
        	response.getWriter().print("注册成功！激活邮件已发送您注册邮箱，请于2小时内完成账号激活！");
        }
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
