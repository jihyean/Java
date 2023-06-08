package class01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test01 {

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
		
		// ----- View 시작
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학생의 이름을 입력하세요");
		System.out.println("입력: ");
		String studentName = sc.next();
		
		System.out.println("학생의 점수를 입력하세요");
		System.out.println("입력: ");
		int studentScore = sc.nextInt();
		// ----- View 끝
		
		
		// ------CTRL 시작
		// CTRL 입장:"M의 DAO의 CRUD 메서드 인자는 VO 주고 받는 것도 VO"
		StudentVO sVO = new StudentVO(0,studentName, studentScore);
		// ------CTRL 끝
		
		final String sql_INSERT = "INSERT INTO STUDENT (NAME,SCORE) VALUES ('"+sVO.getName()+"', "+sVO.getScore()+");";
		final String sql_UPDATE = "UPDATE STUDENT SET SCORE=0 WHERE NUM=1;";
		final String sql_DELETE = "DELETE FROM STUDENT WHERE NUM=2;";
		
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql_INSERT);
			stmt.executeUpdate(sql_UPDATE);
			stmt.executeUpdate(sql_DELETE);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 4. 연결해제
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
		

	}

}



























