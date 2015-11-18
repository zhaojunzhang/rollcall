package xinguan.zhang.web.Listen;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import xinguan.zhang.service.StudentService;
import xinguan.zhang.service.TeacherService;
//�����������Ƿ���ڣ����ھ�ɾ��������

public class DelNoActiveListen implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		//������ʱ��
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				TeacherService teacherService = new TeacherService();
				StudentService studentService = new StudentService();
				teacherService.query();
				studentService.query();
			}
		
		},0, 1000*60);
	}

}
