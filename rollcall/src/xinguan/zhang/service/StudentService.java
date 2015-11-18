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
	//ѧ��ע��

	  final	private int A=1;
	  final private int B=2;
	  final private int C=3;
	
	public int stu_regist(Student student) {
		//1,���û��ĵ���Ϣ���浽���ݿ�
				//2,���ɼ�����
		
				StudentDao studentDao = new StudentDao();
				//�û�����֤
				Student student1 = studentDao.queryUsername(student);
				 
				if(student1!=null){
				  return A;
				}
				//������֤������
				 Student student2 = studentDao.queryMail(student);
			    if(student2!=null){
				   return B;
				 }
				    	String activecode = MailUtils_Stu.generateActivecode();
				  		student.setActivecode(activecode);
				  		studentDao.insert(student);
				  		//����Session
				  		Session session = MailUtils_Stu.createSession();
				  		//��д�ʼ�
				  		try {
							Message message = MailUtils_Stu.generateMessage(session, student);
							//�����ʼ�
							MailUtils_Stu.sendMail(message, session);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							throw new RuntimeException("���ͼ����ʼ�ʧ��");
						}
				  		
				   return C;
	}
    //�����˻�
	public void actice_account(String activecode) {
		StudentDao studentDao = new StudentDao();
		Student student =  studentDao.findbyActivecode(activecode);
		if(student==null){
			 //��������Ч
			  throw new RuntimeException("��������Ч");
		}else{
			  //���������
			  //2���жϼ������Ƿ��Ѿ�����
			  if(System.currentTimeMillis()-student.getRegisttime().getTime()>1000*60*60*2){
				  //������Сʱ
				  //TODO  ���·���---�������ݿⱣ�漤����
				  throw new RuntimeException("�������Ѿ�����");
			  }else{
				  //���Լ���ɼ���
				  student.setState(1);
				  studentDao.updateState(student);
				  
			  }
	}
		
	}
//��ѯΪ�����˻�
	public void query() {
		StudentDao studentDao  =new StudentDao();
		List<Student> students =  studentDao.queryNoactive();
		for(Student student:students){
			//�����������Сʱ���ǹ����Զ�ɾ��
			if(System.currentTimeMillis()-student.getRegisttime().getTime()>1000*60*60*2){
			studentDao.DelNoactive(student);
			}
		}
		
		
	}
	//�û���½
	public Student stu_login(User user) {
		StudentDao studentDao = new StudentDao();
		Student student = studentDao.stu_query(user);
		return student;
	}
	//�޸�ѧ����Ϣ
	public void update_stuinfo(Student student) {
		StudentDao studentDao = new StudentDao();
		
		studentDao.update_stuinfo(student);
		
		
	}
	//����ID��ѯѧ����Ϣ
	public Student findbyId(int id) {

		StudentDao studentDao =new StudentDao();
		Student student =  studentDao.findbyId_stuinfo(id);
		return student;
	}
	//��ѯ��ʦ�γ���Ϣ
	public List<Teacher> query_teacourseservlet() {
		StudentDao studentDao = new StudentDao();
		//��ѯ��ʦ��Ϣ��û�пγ���Ϣ
		List<Teacher> teachers = studentDao.query_teainfo();
		//������ʦ��Id����ѯ�γ���Ϣ
		for(Teacher teacher:teachers){
            List<Course> courses = TeacherDao.findCourse(teacher);
			
			teacher.setCourses(courses);
		}
		
		return teachers;
	}
}
