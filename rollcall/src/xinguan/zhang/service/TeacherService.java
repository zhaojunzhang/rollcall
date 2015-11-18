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
    //��ʦע��
  final	private int A=1;
  final private int B=2;
  final private int C=3;
	
	public int tea_regist(Teacher teacher) {
		//1,���û��ĵ���Ϣ���浽���ݿ�
		//2,���ɼ�����
		
		TeacherDao teacherDao = new TeacherDao();
		//�û�����֤
		 Teacher teacher1 = teacherDao.queryUsername(teacher);
		 
		if(teacher1!=null){
		  return A;
		}
		//������֤������
		 Teacher teacher2 = teacherDao.queryMail(teacher);
	    if(teacher2!=null){
		   return B;
		 }
		    	String activecode = MailUtils.generateActivecode();
		  		teacher.setActivecode(activecode);
		  		teacherDao.insert(teacher);
		  		//����Session
		  		Session session = MailUtils.createSession();
		  		//��д�ʼ�
		  		try {
					Message message = MailUtils.generateMessage(session, teacher);
					//�����ʼ�
					MailUtils.sendMail(message, session);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException("���ͼ����ʼ�ʧ��");
				}
		  		
		   return C;
	}
	//�˻�����
	public void actice_account(String activecode) {
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher = teacherDao.findbyActivecode(activecode);
		if(teacher==null){
			 //��������Ч
			  throw new RuntimeException("��������Ч");
		}else{
			  //���������
			  //2���жϼ������Ƿ��Ѿ�����
			  if(System.currentTimeMillis()-teacher.getRegisttime().getTime()>1000*60*60*2){
				  //������Сʱ
				  //TODO  ���·���---�������ݿⱣ�漤����
				  throw new RuntimeException("�������Ѿ�����");
			  }else{
				  //���Լ���ɼ���
				 teacher.setState(1);
				 teacherDao.updateState(teacher);
				  
			  }
	}
	}
	//��ѯδ������˻�
	public void query() {
		TeacherDao teacherDao  =new TeacherDao();
		List<Teacher> teachers =  teacherDao.queryNoactive();
		for(Teacher teacher:teachers){
			//�����������Сʱ���ǹ����Զ�ɾ��
			if(System.currentTimeMillis()-teacher.getRegisttime().getTime()>1000*60*60*2){
			teacherDao.DelNoactive(teacher);
			}
		}
		
	}
	//�û���½
	public Teacher tea_login(User user) {
		TeacherDao teacherDao = new TeacherDao();
		Teacher teacher  =teacherDao.tea_query(user);
		return teacher;
	}
	//��ѯ��ʦ�Ŀγ���Ϣ
	public List<Teacher> looktea_course(String id) {
		TeacherDao teacherDao = new TeacherDao();
		//��ѯ��ʦ��Ϣ������û�пγ���Ϣ
		List<Teacher> teachers = teacherDao.looktea_course(id);
		for(Teacher teacher:teachers){
			List<Course> courses = TeacherDao.findCourse(teacher);
			
			teacher.setCourses(courses);
			
		}
		
		return teachers;
	}
	
}
