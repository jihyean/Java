package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	static final String driverName_MySQL="com.mysql.cj.jdbc.Driver";
	static final String url_MySQL="jdbc:mysql://localhost/jhdb";
	static final String userName="root";
	static final String passwd="1234";

	public static Connection connect() {
		Connection conn=null;
		try {
			Class.forName(driverName_MySQL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			conn=DriverManager.getConnection(url_MySQL, userName, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void disconnect(Statement stmt,Connection conn) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// disconnect 오버로딩 ResultSet 사용시 같이 닫음
	public static void disconnect(ResultSet rs,Statement stmt,Connection conn) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
