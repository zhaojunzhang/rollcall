
package xinguan.zhang.utils;

import java.util.Properties;

import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import xinguan.zhang.domin.Student;




/**
 * 发送邮件 工具方法
 * 
 * @author seawind
 * 
 */
public class MailUtils_Stu {
	// 生成激活码
	public static String generateActivecode() {
		return UUID.randomUUID().toString();
	}
 
	// 发送邮件
	public static void sendMail(Message message, Session session)
			throws Exception {
		Transport transport = session.getTransport();
		transport.connect("13029802829", "13895895490");
		transport.sendMessage(message, message.getAllRecipients());
	}

	// 生成邮件
	public static Message generateMessage(Session session,Student student)
			throws Exception {
		
		MimeMessage message = new MimeMessage(session);
		// 邮件头
		message.setFrom(new InternetAddress("13029802829@sina.cn"));// 发件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(student
				.getEmail())); // 收件人
		message.setSubject("兆军上课点名系统");
		// 邮件头
		message
				.setContent(
						"<h2>欢迎"
								+ student.getUsername()
								+ "欢迎同学注册兆军点名系统</h2><h3>请于2小时内点击下面链接完成账户激活：</h3><a href='http://localhost/rollcall/stuactive?activecode="
								+ student.getActivecode()
								+ "'>http://localhost/rollcall/stuactive?activecode="
								+ student.getActivecode() + "</a>",
						"text/html;charset=utf-8");
		return message;
	}

	// 创建会话
	public static Session createSession() {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.sina.cn");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties);
		return session;
	}
}
