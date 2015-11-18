package xinguan.zhang.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import xinguan.zhang.domin.Course;
import xinguan.zhang.utils.JDBCUtils;

public class CourseDao {

	public void delbuidcourse(String id) {
		String sql ="delete from  course where id=?";
		QueryRunner queryRunner =new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void insert_course(Course course) {
		String sql = "insert into course values(null,?,?,?)";
		Object[] param = {course.getCourse_name(),course.getCollege(),course.getTeacher_id()};
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Course findById(int course_id) {
		String sql = "select * from course where id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			Course course = queryRunner.query(sql, new BeanHandler<Course>(Course.class),course_id);
			return course;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
