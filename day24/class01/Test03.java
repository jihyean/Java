package class01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {

		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
		final String driverName_Oracle = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driverName_MySQL);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		final String url_MySQL = "jdbc:mysql://localhost/jhdb";
		final String url_Oracle = "jdbc:oracle:thin:@localhost:1521:xe";
		final String userName = "root";
		final String passwd = "1234";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		Statement stmt = null;

		// view 시작====================================================
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 학생 번호를 입력해주세요");
		int studentNum = -1;

		while (true) {
			try {
				System.out.print("입력: ");
				studentNum = sc.nextInt();
				System.out.println();
				
				if(studentNum<=0) {
					System.out.println("0보다 큰 정수를 입력해주세요");
					continue;
				}
				break;
				
			} catch (InputMismatchException e) {
				sc.nextLine();
				//e.printStackTrace();
				System.out.println("정수만 입력 가능합니다");
				System.out.println("다시 입력해주세요!");
			}
		}
		// view 끝====================================================
		
		// CTRL 시작 ====================================================
		
		StudentVO sVO = new StudentVO(studentNum, "", 0);
		
		// CTRL 끝 ====================================================
		
		final String sql_SELECTONE = "SELECT NUM, NAME, SCORE FROM STUDENT WHERE NUM=" + sVO.getNum() + ";";
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTONE); // 이터레이터 유사

			if (rs.next()) {
				sVO = new StudentVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("SCORE"));
				System.out.println(sVO.getNum());
				System.out.println(sVO.getName());
				System.out.println(sVO.getScore());

			} else {
				System.out.println("없는 학생입니다!");
				System.out.println();
			}

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
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
