package xinguan.zhang.service;

import xinguan.zhang.dao.CourseDao;
import xinguan.zhang.domin.Course;

public class CourseService {
//根据id删除出课程信息
	public void delbyid(String id) {
		CourseDao courseDao = new CourseDao();
		courseDao.delbuidcourse(id);
		
	}
//插入课程数据
	public void insert_course(Course course) {
	CourseDao courseDao = new CourseDao();
	courseDao.insert_course(course);
		
	}
	public Course findById(int course_id) {
	CourseDao courseDao = new CourseDao();
	Course course = courseDao.findById(course_id);
		return course;
	}

}
