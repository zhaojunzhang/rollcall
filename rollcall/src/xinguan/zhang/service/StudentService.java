package xinguan.zhang.service;

import java.util.List;

import javax.mail.Message;
import javax.mail.Session;
import xinguan.zhang.dao.StudentDao;
import xinguan.zhang.dao.TeacherDao;
import xinguan.zhang.domin.Course;
import xinguan.zhang.domin.Student;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.domin.User;
import xinguan.zhang.utils.MailUtils_Stu;
public class StudentService {
	//学生注册

	  final	private int A=1;
	  final private int B=2;
	  final private int C=3;
	
	public int stu_regist(Student student) {
		//1,将用户的的信息保存到数据库
				//2,生成激活码
		
				StudentDao studentDao = new StudentDao();
				//用户名验证
				Student student1 = studentDao.queryUsername(student);
				 
				if(student1!=null){
				  return A;
				}
				//邮箱验证：：：
				 Student student2 = studentDao.queryMail(student);
			    if(student2!=null){
				   return B;
				 }
				    	String activecode = MailUtils_Stu.generateActivecode();
				  		student.setActivecode(activecode);
				  		studentDao.insert(student);
				  		//创建Session
				  		Session session = MailUtils_Stu.createSession();
				  		//编写邮件
				  		try {
							Message message = MailUtils_Stu.generateMessage(session, student);
							//发送邮件
							MailUtils_Stu.sendMail(message, session);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw new RuntimeException("发送激活邮件失败");
						}
				  		
				   return C;
	}
    //激活账户
	public void actice_account(String activecode) {
		StudentDao studentDao = new StudentDao();
		Student student =  studentDao.findbyActivecode(activecode);
		if(student==null){
			 //激活码无效
			  throw new RuntimeException("激活码无效");
		}else{
			  //激活码存在
			  //2，判断激活码是否已经过期
			  if(System.currentTimeMillis()-student.getRegisttime().getTime()>1000*60*60*2){
				  //超过两小时
				  //TODO  重新发送---更新数据库保存激活码
				  throw new RuntimeException("激活码已经过期");
			  }else{
				  //可以激活可激活
				  student.setState(1);
				  studentDao.updateState(student);
				  
			  }
	}
		
	}
//查询为激活账户
	public void query() {
		StudentDao studentDao  =new StudentDao();
		List<Student> students =  studentDao.queryNoactive();
		for(Student student:students){
			//如果超过两个小时就是过期自动删除
			if(System.currentTimeMillis()-student.getRegisttime().getTime()>1000*60*60*2){
			studentDao.DelNoactive(student);
			}
		}
		
		
	}
	//用户登陆
	public Student stu_login(User user) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.stu_query(user);
		return student;
	}
	//修改学生信息
	public void update_stuinfo(Student student) {
		StudentDao studentDao = new StudentDao();
		
		studentDao.update_stuinfo(student);
		
		
	}
	//根据ID查询学生信息
	public Student findbyId(int id) {

		StudentDao studentDao =new StudentDao();
		Student student =  studentDao.findbyId_stuinfo(id);
		return student;
	}
	//查询老师课程信息
	public List<Teacher> query_teacourseservlet() {
		StudentDao studentDao = new StudentDao();
		//查询老师信息，没有课程信息
		List<Teacher> teachers = studentDao.query_teainfo();
		//根据老师的Id来查询课程信息
		for(Teacher teacher:teachers){
            List<Course> courses = TeacherDao.findCourse(teacher);
			
			teacher.setCourses(courses);
		}
		
		return teachers;
	}
}
