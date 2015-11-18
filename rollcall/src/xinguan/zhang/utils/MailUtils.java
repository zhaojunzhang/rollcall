
package xinguan.zhang.utils;

import java.util.Properties;

import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import xinguan.zhang.domin.Teacher;



/**
 * �����ʼ� ���߷���
 * 
 * @author seawind
 * 
 */
public class MailUtils {
	// ���ɼ�����
	public static String generateActivecode() {
		return UUID.randomUUID().toString();
	}
 
	// �����ʼ�
	public static void sendMail(Message message, Session session)
			throws Exception {
		Transport transport = session.getTransport();
		transport.connect("13029802829", "13895895490");
		transport.sendMessage(message, message.getAllRecipients());
	}

	// �����ʼ�
	public static Message generateMessage(Session session,Teacher teacher)
			throws Exception {
		
		MimeMessage message = new MimeMessage(session);
		// �ʼ�ͷ
		message.setFrom(new InternetAddress("13029802829@sina.cn"));// ������
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(teacher
				.getEmail())); // �ռ���
		message.setSubject("�׾��Ͽε���ϵͳ");
		// �ʼ�ͷ
		message
				.setContent(
						"<h2>��ӭ"
								+ teacher.getUsername()
								+ "��ӭ��ʦ��ע���׾�����ϵͳ�����ﹻ���������ѧ����</h2><h3>����2Сʱ�ڵ��������������˻����</h3><a href='http://localhost/rollcall/active?activecode="
								+ teacher.getActivecode()
								+ "'>http://localhost/rollcall/active?activecode="
								+ teacher.getActivecode() + "</a>",
						"text/html;charset=utf-8");
		return message;
	}

	// �����Ự
	public static Session createSession() {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.sina.cn");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties);
		return session;
	}
}
