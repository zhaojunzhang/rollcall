package xinguan.zhang.service;

import java.util.List;

import xinguan.zhang.dao.GuanxiDao;
import xinguan.zhang.domin.Guanxi;

public class GuanxiService {
	final private int A=1;
	final private int B=2;
//添加选课
	public void insert_info(Guanxi guanxi) {
		GuanxiDao guanxiDao = new GuanxiDao();
		guanxiDao.insert_info(guanxi);
	}
//取消选课
	public void cancle_teacourse(Guanxi guanxi) {
		GuanxiDao guanxiDao = new GuanxiDao();
		guanxiDao.cancle_teacourse(guanxi);
		
	}
  //查询课程关系
	public List<Guanxi> query_guanxi(int teacher_id, int course_id) {
		GuanxiDao guanxiDao = new GuanxiDao();
		List<Guanxi> guanxis = guanxiDao.query_guanxibyID(teacher_id,course_id);
		return guanxis;
	}
//签到修改关系表
	public void updatestu_num(Guanxi guanxi) {
		GuanxiDao guanxiDao = new GuanxiDao();
		 guanxiDao.updatestu_num(guanxi);
		
	}

	

	

	

}
