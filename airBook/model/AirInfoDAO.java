package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AirInfoDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 쿼리문
	static final String sql_INSERT = "INSERT INTO AIRINFO(AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE) VALUES(?, ?, ?, ?, ?)";
	
	static final String sql_UPDATE_TIME = "UPDATE AIRINFO SET AIRINFO_START = ?, AIRINFO_RETURN = ? WHERE AIRINFO_NUM = ?";
	static final String sql_UPDATE_PRICE = "UPDATE AIRINFO SET AIRINFO_PRICE = ? WHERE AIRINFO_NUM = ?";
	static final String sql_UPDATE_ALL = "UPDATE AIRINFO SET AIRINFO_START = ?, AIRINFO_RETURN = ?, AIRINFO_PRICE = ? WHERE AIRINFO_NUM = ?";
	
	static final String sql_DELETE = "DELETE FROM AIRINFO WHERE AIRINFO_NUM = ?";
	
	static final String sql_SELECTALL = "SELECT AIRINFO_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE, AIRINFO_DATE FROM AIRINFO;";
	static final String sql_SELECTALL_POPULAR = "SELECT A.AIRINFO_NUM, A.AIRINFO_AIRLINE, A.AIRINFO_ROUTE, A.AIRINFO_START, A.AIRINFO_RETURN, A.AIRINFO_PRICE, A.AIRINFO_DATE FROM AIRINFO AS A LEFT JOIN AIRDET AS B ON A.AIRINFO_NUM = B.AIRINFO_NUM LEFT JOIN AIRBOOK AS C ON C.AIRDET_NUM = B.AIRDET_NUM GROUP BY A.AIRINFO_NUM ORDER BY SUM(C.AIRBOOK_CNT) DESC, AIRINFO_NUM ASC;";
	static final String sql_SELECTALL_TIME = "SELECT AIRINFO_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE, AIRINFO_DATE FROM AIRINFO ORDER BY AIRINFO_START;";
	static final String sql_SELECTALL_SEARCH_TIME = "SELECT AIRINFO_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE, AIRINFO_DATE FROM AIRINFO WHERE AIRINFO_START BETWEEN ? AND ?;";
	static final String sql_SELECTALL_SEARCH_PRICE = "SELECT AIRINFO_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE, AIRINFO_DATE FROM AIRINFO WHERE AIRINFO_PRICE BETWEEN ? AND ?;";
	static final String sql_SELECTALL_SEARCH_ALL = "SELECT AIRINFO_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE, AIRINFO_DATE FROM AIRINFO WHERE AIRINFO_START BETWEEN ? AND ? AND AIRINFO_PRICE BETWEEN ? AND ?;";
	
	static final String sql_SELECTONE = "SELECT AIRINFO_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE, AIRINFO_DATE FROM AIRINFO WHERE AIRINFO_NUM = ?;";

	//===============================[ C ]==================================
	
	// - 항공정보 데이터 삽입 : 크롤링한 정보들을 항공정보 테이블의 각 컬럼별로 데이터 삽입
	public boolean insert(AirInfoVO aiVO) {
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, aiVO.getAirInfoAirline());
			pstmt.setString(2, aiVO.getAirInfoRoute());
			pstmt.setTime(3, Util.dateTotime(aiVO.getAirInfoStart()));
			pstmt.setTime(4, Util.dateTotime(aiVO.getAirInfoReturn()));
			pstmt.setInt(5, aiVO.getAirInfoPrice());
			
			int result = pstmt.executeUpdate();
			if (result <= 0) {
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
	
	// - 항공정보 변경(관리자) : 해당 항공정보 데이터 변경
	public boolean update(AirInfoVO aiVO) {
		
		conn = JDBCUtil.connect();
		
		try {
			if(aiVO.getTmpAirSC().equals("시간")) { // 항공정보 시간 변경시
				pstmt = conn.prepareStatement(sql_UPDATE_TIME);
				pstmt.setTime(1, Util.dateTotime(aiVO.getAirInfoStart()));
				pstmt.setTime(2, Util.dateTotime(aiVO.getAirInfoReturn()));
				pstmt.setInt(3, aiVO.getAirInfoNum());
			} 
			else if(aiVO.getTmpAirSC().equals("가격")) { // 항공정보 가격 변경시
				pstmt = conn.prepareStatement(sql_UPDATE_PRICE);
				pstmt.setInt(1, aiVO.getTmpPrice());
				pstmt.setInt(2, aiVO.getAirInfoNum());
			} 
			else if(aiVO.getTmpAirSC().equals("시간가격")) { // 항공정보 시간, 가격 변경시
				pstmt = conn.prepareStatement(sql_UPDATE_ALL);
				pstmt.setTime(1, Util.dateTotime(aiVO.getAirInfoStart()));
				pstmt.setTime(2, Util.dateTotime(aiVO.getAirInfoReturn()));
				pstmt.setInt(3, aiVO.getTmpPrice());
				pstmt.setInt(4, aiVO.getAirInfoNum());
			}
			
			int result = pstmt.executeUpdate();
			if (result <= 0) {
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
	
	//===============================[ D ]==================================
	
	// - 항공정보 삭제(관리자) : 해당 항공정보 데이터 삭제
	public boolean delete(AirInfoVO aiVO) {

		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, aiVO.getAirInfoNum());
			
			int result = pstmt.executeUpdate();
			if (result <= 0) {
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
	
	//===============================[ R ]==================================
	
	// - 항공정보 목록출력 : 예매(사용자), 항공정보 변경(관리자)시 DB에 보유한 항공정보 목록 조회
	public ArrayList<AirInfoVO> selectAll(AirInfoVO aiVO){
		ArrayList<AirInfoVO> pdatas = new ArrayList<AirInfoVO>();

		conn = JDBCUtil.connect();
		
		try {
			if (aiVO.getTmpAirSC().equals("전체")) { // 전체 항공정보 목록 
				pstmt = conn.prepareStatement(sql_SELECTALL);
			} else if(aiVO.getTmpAirSC().equals("전체인기")) { // 전체 항공정보 목록중 인기순 정렬
				pstmt = conn.prepareStatement(sql_SELECTALL_POPULAR);				
			} 
			else if(aiVO.getTmpAirSC().equals("전체시간")) { // 전체 항공정보 목록중 시간순 정렬
				pstmt = conn.prepareStatement(sql_SELECTALL_TIME);
			} 
			else if(aiVO.getTmpAirSC().equals("시간")) { // 필터 검색시 해당 시간 사이의 항공정보 목록
				pstmt = conn.prepareStatement(sql_SELECTALL_SEARCH_TIME);
				pstmt.setTime(1, Util.dateTotime(aiVO.getAirInfoStart()));
				pstmt.setTime(2, Util.dateTotime(aiVO.getAirInfoReturn()));
			} else if(aiVO.getTmpAirSC().equals("가격")) { // 필터 검색시 해당 가격 사이의 항공정보 목록
				pstmt = conn.prepareStatement(sql_SELECTALL_SEARCH_PRICE);
				pstmt.setInt(1, aiVO.getAirInfoPrice());
				pstmt.setInt(2, aiVO.getTmpPrice());				
			}
			else if(aiVO.getTmpAirSC().equals("시간가격")) { // 필터 검색시 해당 시간, 가격 사이의 항공정보 목록
				pstmt = conn.prepareStatement(sql_SELECTALL_SEARCH_ALL);
				pstmt.setTime(1, Util.dateTotime(aiVO.getAirInfoStart()));
				pstmt.setTime(2, Util.dateTotime(aiVO.getAirInfoReturn()));
				pstmt.setInt(3, aiVO.getAirInfoPrice());
				pstmt.setInt(4, aiVO.getTmpPrice());
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				pdatas.add(new AirInfoVO(rs.getInt("AIRINFO_NUM"), rs.getString("AIRINFO_AIRLINE"), rs.getString("AIRINFO_ROUTE"), Util.timeToDate(rs.getTime("AIRINFO_START")), Util.timeToDate(rs.getTime("AIRINFO_RETURN")), rs.getInt("AIRINFO_PRICE"), rs.getDate("AIRINFO_DATE")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return pdatas;
		}
		
		JDBCUtil.disconnect(rs, pstmt, conn); 
		return pdatas;
	}
	
	// - 항공정보 확인 : 사용자가 입력한 항공정보 번호가 DB에 존재하는지 여부 확인
	// - 항공정보 출력 : 특정 항공정보 번호의 정보를 조회
	public AirInfoVO selectOne(AirInfoVO aiVO){
		
		AirInfoVO pdata = null;
		
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_SELECTONE);
			pstmt.setInt(1, aiVO.getAirInfoNum());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				pdata = new AirInfoVO(rs.getInt("AIRINFO_NUM"), rs.getString("AIRINFO_AIRLINE"), rs.getString("AIRINFO_ROUTE"), Util.timeToDate(rs.getTime("AIRINFO_START")), Util.timeToDate(rs.getTime("AIRINFO_RETURN")), rs.getInt("AIRINFO_PRICE"), rs.getDate("AIRINFO_DATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return pdata;
		}
		
		JDBCUtil.disconnect(rs, pstmt, conn); 
		return pdata;
	}
}
