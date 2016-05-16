package cn.itcast.web.vote.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//JDBC�����ࣺ�ر�����ȡ������
public final class JdbcUtil {
	private static ComboPooledDataSource dataSource;
	static{
		dataSource = new ComboPooledDataSource();
	}
	//ȡ������Դ
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
}

