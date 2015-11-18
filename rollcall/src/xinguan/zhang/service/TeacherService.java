package xinguan.zhang.service;

import java.util.List;

import javax.mail.Message;
import javax.mail.Session;

import xinguan.zhang.dao.TeacherDao;
import xinguan.zhang.domin.Course;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.domin.User;
import xinguan.zhang.utils.MailUtils;

public class TeacherService {
    //教师注册
  final	private int A=1;
  final private int B=2;
  final private int C=3;
	
	public int tea_regist(Teacher teacher) {
		//1,将用户的的信息保存到数据库
		//2,生成激活码
		
		TeacherDao teacherDao = new TeacherDao();
		//用户名验证
		 Teacher teacher1 = teacherDao.queryUsername(teacher);
		 
		if(teacher1!=null){
		  return A;
		}
		//邮箱验证：：：
		 Teacher teacher2 = teacherDao.queryMail(teacher);
	    if(teacher2!=null){
		   return B;
		 }
		    	String activecode = MailUtils.generateActivecode();
		  		teacher.setActivecode(activecode);
		  		teacherDao.insert(teacher);
		  		//创建Session
		  		Session session = MailUtils.createSession();
		  		//编写邮件
		  		try {
					Message message = MailUtils.generateMessage(session, teacher);
					//发送邮件
					MailUtils.sendMail(message, session);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("发送激活邮件失败");
				}
		  		
		   return C;
	}
	//账户激活
	public void actice_account(String activecode) {
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.findbyActivecode(activecode);
		if(teacher==null){
			 //激活码无效
			  throw new RuntimeException("激活码无效");
		}else{
			  //激活码存在
			  //2，判断激活码是否已经过期
			  if(System.currentTimeMillis()-teacher.getRegisttime().getTime()>1000*60*60*2){
				  //超过两小时
				  //TODO  重新发送---更新数据库保存激活码
				  throw new RuntimeException("激活码已经过期");
			  }else{
				  //可以激活可激活
				 teacher.setState(1);
				 teacherDao.updateState(teacher);
				  
			  }
	}
	}
	//查询未激活的账户
	public void query() {
		TeacherDao teacherDao  =new TeacherDao();
		List<Teacher> teachers =  teacherDao.queryNoactive();
		for(Teacher teacher:teachers){
			//如果超过两个小时就是过期自动删除
			if(System.currentTimeMillis()-teacher.getRegisttime().getTime()>1000*60*60*2){
			teacherDao.DelNoactive(teacher);
			}
		}
		
	}
	//用户登陆
	public Teacher tea_login(User user) {
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher  =teacherDao.tea_query(user);
		return teacher;
	}
	//查询教师的课程信息
	public List<Teacher> looktea_course(String id) {
		TeacherDao teacherDao = new TeacherDao();
		//查询教师信息，这里没有课程信息
		List<Teacher> teachers = teacherDao.looktea_course(id);
		for(Teacher teacher:teachers){
			List<Course> courses = TeacherDao.findCourse(teacher);
			
			teacher.setCourses(courses);
			
		}
		
		return teachers;
	}
	
}
