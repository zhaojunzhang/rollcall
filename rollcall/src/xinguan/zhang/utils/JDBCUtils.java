package xinguan.zhang.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ������ �ṩ���ݿ����ӳ� �����ݿ�����
 * 
 * @author seawind
 * 
 */
public class JDBCUtils {
	private static DataSource dataSource = new ComboPooledDataSource();

	public static DataSource getDataSource() {
		return dataSource;
	}

	/**
	 * ��DBUtils��Ҫ�ֶ���������ʱ�����ø÷������һ������
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	//�������  ��Ʒ���
	public static String generatecourseId(){
		String uuid = UUID.randomUUID().toString();
		int hashCode = Math.abs(uuid.hashCode());
		return "ep-"+hashCode;
	}
	public static String generateOrderId(){
		String uuid = UUID.randomUUID().toString();
		int hashCode = Math.abs(uuid.hashCode());
		return "Order-"+hashCode;
	}
}
