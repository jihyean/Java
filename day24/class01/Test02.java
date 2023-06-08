package class01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test02 {

	public static void main(String[] args) {
		
		//1. 
		// 해당 드라이버들은 기본 제공되는 클래스가 아님
		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";
		
		try {
			// new가 없음 ---> static임
			Class.forName(driverName_MySQL);
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		
		
		// 2.
		// Connection 객체가 필요
		final String url_MySQL= "jdbc:mysql://localhost/jhdb";
		final String url_Oracle= "jdbc:oracle:thin:@localhost:1521:xe";
		final String userName = "root";
		final String passwd = "1234";
		
		Connection conn = null;
		
		try {
			// url, userName, password
			// conn 객체는 DB와의 연결통로 역할
			conn =DriverManager.getConnection(url_MySQL, userName, passwd);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		// 3.
		// 데이터를 read/ write 하는 객체인 statement
		Statement stmt = null;
		

		
		final String sql_SELECTALL = "SELECT NUM, NAME, SCORE FROM STUDENT;";
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTALL); //이터레이터 유사
			
			
			
			while(rs.next()) {
				// CTRL 시작
				StudentVO sVO = new StudentVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("SCORE"));
				
				// CTRL 끝
				
				// View 시작
				System.out.println(sVO.getNum());
				System.out.println(sVO.getName());
				System.out.println(sVO.getScore());
				System.out.println();
				// View 끝
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 4. 연결해제
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("로그: 프로그램 종료");
		

	}

}



























