package xinguan.zhang.web.Listen;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import xinguan.zhang.service.StudentService;
import xinguan.zhang.service.TeacherService;
//监听激活码是否过期，过期就删除激活码

public class DelNoActiveListen implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		//启动定时器
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
