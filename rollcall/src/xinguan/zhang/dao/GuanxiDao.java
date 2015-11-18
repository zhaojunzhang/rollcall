package xinguan.zhang.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import xinguan.zhang.domin.Guanxi;
import xinguan.zhang.utils.JDBCUtils;

public class GuanxiDao {
//选课插入
	public void insert_info(Guanxi guanxi) {
		String sql= "insert into guanxi values(?,?,?,0)";
		Object[] param = {guanxi.getStudent_id(),guanxi.getCourse_id(),guanxi.getTeacher_id()};
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("插入关系表sql语句错误");
		}
		
	}

	public void cancle_teacourse(Guanxi guanxi) {
		String sql = "delete from guanxi where student_id=? and course_id=? and teacher_id=?";
		Object[] param = {guanxi.getStudent_id(),guanxi.getCourse_id(),guanxi.getTeacher_id()};
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,param);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("删除关系表sql语句错误");
		}
		
	}
//查询选课信息
	public List<Guanxi> query_guanxibyID(int teacher_id, int course_id) {
		String sql= "select * from guanxi where course_id=? and teacher_id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			List<Guanxi> guanxis = queryRunner.query(sql, new BeanListHandler<Guanxi>(Guanxi.class),course_id,teacher_id);
			return guanxis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
//因签到修改选课信息
	public void updatestu_num(Guanxi guanxi) {
		String sql = "update guanxi set num=num+1 where student_id=? and course_id=? and teacher_id=?";
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		try {
			queryRunner.update(sql,guanxi.getStudent_id(),guanxi.getCourse_id(),guanxi.getTeacher_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("修改guanxi表的sql语句错误");
		}
		
	}

	

	
	

	

	
	

}
