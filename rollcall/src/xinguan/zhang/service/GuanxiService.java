package xinguan.zhang.service;

import java.util.List;

import xinguan.zhang.dao.GuanxiDao;
import xinguan.zhang.domin.Guanxi;

public class GuanxiService {
	final private int A=1;
	final private int B=2;
//���ѡ��
	public void insert_info(Guanxi guanxi) {
		GuanxiDao guanxiDao = new GuanxiDao();
		guanxiDao.insert_info(guanxi);
	}
//ȡ��ѡ��
	public void cancle_teacourse(Guanxi guanxi) {
		GuanxiDao guanxiDao = new GuanxiDao();
		guanxiDao.cancle_teacourse(guanxi);
		
	}
  //��ѯ�γ̹�ϵ
	public List<Guanxi> query_guanxi(int teacher_id, int course_id) {
		GuanxiDao guanxiDao = new GuanxiDao();
		List<Guanxi> guanxis = guanxiDao.query_guanxibyID(teacher_id,course_id);
		return guanxis;
	}
//ǩ���޸Ĺ�ϵ��
	public void updatestu_num(Guanxi guanxi) {
		GuanxiDao guanxiDao = new GuanxiDao();
		 guanxiDao.updatestu_num(guanxi);
		
	}

	

	

	

}
