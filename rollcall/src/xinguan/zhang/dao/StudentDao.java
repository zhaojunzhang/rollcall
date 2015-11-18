package xinguan.zhang.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import xinguan.zhang.domin.Student;
import xinguan.zhang.domin.Teacher;
import xinguan.zhang.domin.User;
import xinguan.zhang.utils.JDBCUtils;

public class StudentDao {
   //查询学生的用户名
	public Student queryUsername(Student student) {
		String sql = "select * from student where username=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Student student1 = queryRunner.query(sql, new BeanHandler<Student>(Student.class),student.getUsername());
			return student1;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("查询Stu_Username——sql语句报错");
		}

   }
    //查询学生的邮箱
	public Student queryMail(Student student) {
		String sql = "select * from student where email=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Student student1 = queryRunner.query(sql, new BeanHandler<Student>(Student.class),student.getEmail());
			return student1;
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("查询Email——sql语句报错");
		}
	}
	//注册学生表数据
	public void insert(Student student) {
		
		String sql = "insert into student values(null,?,?,?,?,?,'student',null,0,?)";
		QueryRunner queryRunner  = new QueryRunner(JDBCUtils.getDataSource());
		Object[] param={student.getStu_id(),student.getUsername(),student.getPassword(),student.getNickname(),student.getEmail()
				,student.getActivecode()};
		
		try {
			queryRunner.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("注册失败！" + e.getMessage());
		}
		
	}
	//查询学生激活码
	public Student findbyActivecode(String activecode) {
		String sql = "select * from student where activecode=?";
		QueryRunner queryRunner  = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Student student =queryRunner.query(sql, new BeanHandler<Student>(Student.class),activecode);
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("账户激活码查询sql失败");
		}
	}
	//激活学生账号
	public void updateState(Student student) {
		String sql = "update student set state=? where id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,student.getState(),student.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	//查询学生未激活用户
	public List<Student> queryNoactive() {
		String sql = "select * from student where state=?";
		QueryRunner queryRunner= new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Student> student = queryRunner.query(sql, new BeanListHandler<Student>(Student.class),0);
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("查询未激活学生账户的sql语句报错");
		}
	}
	//删除学生已过期未激活的账户
	public void DelNoactive(Student student) {
		String sql = "delete from student where id=?";
		QueryRunner queryRunner =new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,student.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除过期学生用户sql语句报错");
		}
		
	}
	//登陆查询
	public Student stu_query(User user) {
		String sql = "select * from student where username=? and password=? and state=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Student student = queryRunner.query(sql, new BeanHandler<Student>(Student.class),user.getUsername(),user.getPassword(),1);
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//修改学生信息
	public void update_stuinfo(Student student) {
		
		String sql = "update student set stu_id=?,username=?,password=?,nickname=? where id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,student.getStu_id(),student.getUsername(),
					student.getPassword(),student.getNickname(),student.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	//通过id查询学生信息
	public Student findbyId_stuinfo(int id) {
		String sql = "select * from student where id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Student student = queryRunner.query(sql, new BeanHandler<Student>(Student.class),id);
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	//查询老师的信息
	public List<Teacher> query_teainfo() {
		String sql = "select * from teacher";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Teacher> teachers = queryRunner.query(sql, new BeanListHandler<Teacher>(Teacher.class));
			return teachers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
