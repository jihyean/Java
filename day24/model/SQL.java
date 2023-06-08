package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class SQL {

	public static void main(String[] args) {

		final String driverName_MySQL = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driverName_MySQL);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		final String url_MySQL = "jdbc:mysql://localhost/jhdb";
		final String userName = "root";
		final String passwd = "1234";

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url_MySQL, userName, passwd);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		Statement stmt = null;
		
		ArrayList<ProductVO> pVO = Crawling.sample();
		ResultSet rs = null;
		try {
		stmt = conn.createStatement();
		
		for(int i = 0; i<pVO.size(); i++) {
			
			final String sql_INSERT = "INSERT INTO PRODUCT(NAME, PRICE, DISCOUNT) VALUES ('"+pVO.get(i).getName()+"', "+pVO.get(i).getPrice()+", "+pVO.get(i).getDiscount()+");";
			stmt.executeUpdate(sql_INSERT); // 이터레이터 유사
		}
		
		
		final String sql_SELECTALL = "SELECT NUM, NAME, PRICE, DISCOUNT FROM PRODUCT";
		
		rs = stmt.executeQuery(sql_SELECTALL); //이터레이터 유사
		
		//final String sql_SELECTONE = "SELECT NUM, NAME, SCORE FROM STUDENT WHERE NUM=" + sVO.getNum() + ";";

		while(rs.next()) {
			// CTRL 시작
			ProductVO pVO1 = new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("PRICE"), rs.getInt("DISCOUNT"));
			
			// CTRL 끝
			
			// View 시작
			System.out.println(pVO1.getNum());
			System.out.println(pVO1.getName());
			System.out.println(pVO1.getPrice());
			System.out.println(pVO1.getDiscount());
			System.out.println();
			// View 끝
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
