package xinguan.zhang.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import xinguan.zhang.domin.Course;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.domin.User;
import xinguan.zhang.utils.JDBCUtils;

public class TeacherDao {
    //����ע����Ϣ�����ݿ�
	public void insert(Teacher teacher) {
		String sql = "insert into teacher values(null,?,?,?,?,'teacher',null,0,?)";
		QueryRunner queryRunner  = new QueryRunner(JDBCUtils.getDataSource());
		Object[] param={teacher.getUsername(),teacher.getPassword(),teacher.getNickname(),teacher.getEmail()
				,teacher.getActivecode()};
		
		try {
			queryRunner.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ע��ʧ�ܣ�" + e.getMessage());
		}
		
	}
   //��ѯ������
	public Teacher findbyActivecode(String activecode) {
	String sql = "select * from teacher where activecode=?";
	QueryRunner queryRunner  = new QueryRunner(JDBCUtils.getDataSource());
	try {
		Teacher teacher =queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),activecode);
		return teacher;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException("�˻�����ʧ��");
	}
		
	}
	//�����˻�
	public void updateState(Teacher teacher) {
		String sql = "update teacher set state=? where id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,teacher.getState(),teacher.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	//��ѯδ�����û�
	public List<Teacher> queryNoactive() {
		String sql = "select * from teacher where state=?";
		QueryRunner queryRunner= new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Teacher> teacher = queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class),0);
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("��ѯδ�����˻���sql��䱨��");
		}
	
	}
	//ɾ��δ����Ѿ����ڵ��û�
	public void DelNoactive(Teacher teacher) {
		String sql = "delete from teacher where id=?";
		QueryRunner queryRunner =new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,teacher.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("ɾ�������û�sql��䱨��");
		}
		
	}
	//��ѯ����
	public Teacher queryMail(Teacher teacher) {
		String sql = "select * from teacher where email=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Teacher teacher1 = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),teacher.getEmail());
			return teacher1;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("��ѯEmail����sql��䱨��");
		}
		

	}
	//��ѯ�û���
	public Teacher queryUsername(Teacher teacher) {
		String sql = "select * from teacher where username=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Teacher teacher1 = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),teacher.getUsername());
			return teacher1;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("��ѯUsername����sql��䱨��");
		}
	}
	//��¼��ѯ
	public Teacher tea_query(User user) {
		String sql = "select * from teacher where username=? and password=? and state=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		
		try {
			Teacher teacher  = queryRunner.query(sql, new BeanHandler<Teacher>(Teacher.class),user.getUsername(),user.getPassword(),1);
			return teacher;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//���ݽ�ʦ��Ų�ѯ��ʦ��Ϣ
	public List<Teacher> looktea_course(String id) {
		String sql= "SELECT *FROM teacher WHERE id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Teacher> teachers = queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class),id);
			return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
		return null;
	}
	public static List<Course> findCourse(Teacher teacher) {
		String sql = "select * from course where teacher_id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Course> courses = queryRunner.query(sql, new BeanListHandler<Course>(Course.class),teacher.getId());
			return courses;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
		
	
    
}
