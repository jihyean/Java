package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AirOptDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 쿼리문
	static final String sql_INSERT = "INSERT INTO AIROPT (AIROPT_GRADE, AIROPT_PRICE) VALUES (?, ?)"; 

	static final String sql_SELECTALL = "SELECT AIROPT_NUM, AIROPT_GRADE, AIROPT_PRICE FROM AIROPT";
	
	//===============================[ C ]==================================
	
	// - 항공옵션 데이터 삽입 : 프로그램 실행 전 기본 데이터를 DB에 삽입(이코노미, 비즈니스, 퍼스트)
	public boolean insert(AirOptVO aoVO) {
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, aoVO.getAirOptGrade());
			pstmt.setInt(2, aoVO.getAirOptPice());
			
			int result = pstmt.executeUpdate();
			if(result <= 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		JDBCUtil.disconnect(pstmt, conn);
		return true;
	}

	//===============================[ U ]==================================
	
	// - 해당기능없음
	public boolean update(AirOptVO aoVO) {
		return false;
	}

	//===============================[ D ]==================================

	// - 해당기능없음
	public boolean delete(AirOptVO aoVO) {
		return false;
	}

	//===============================[ R ]==================================
	
	// - 항공옵션 목록출력 : 항공상세 테이블에 데이터를 삽입할 때 필요한 항공옵션 목록을 조회
	public ArrayList<AirOptVO> selectAll(AirOptVO aoVO){
		ArrayList<AirOptVO> aodatas = new ArrayList<AirOptVO>();
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_SELECTALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				aodatas.add(new AirOptVO(rs.getInt("AIROPT_NUM"), rs.getString("AIROPT_GRADE"), rs.getInt("AIROPT_PRICE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return null;
		}
		
		JDBCUtil.disconnect(rs, pstmt, conn);
		return aodatas;
	}
	
	// - 해당기능없음
	public AirOptVO selectOne(AirOptVO aoVO){
		return null;
	}
}
