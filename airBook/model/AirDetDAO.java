package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class AirDetDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	static Random rand = new Random();

	// 쿼리문
	static final String sql_INSERT = "INSERT INTO AIRDET(AIRINFO_NUM, AIROPT_NUM, AIRDET_CNT) VALUES(?, ?, ?)";

	static final String sql_UPDATE_DECREASE = "UPDATE AIRDET SET AIRDET_CNT = AIRDET_CNT - ? WHERE AIRDET_NUM = ?";
	static final String sql_UPDATE_CHANGE = "UPDATE AIRDET SET AIRDET_CNT = ? WHERE AIRDET_NUM = ?"; 

	static final String sql_SELECTALL = "SELECT ad_v.AIRINFO_NUM, ad_v.AIRDET_NUM, ad_v.AIRINFO_AIRLINE, ad_v.AIRINFO_ROUTE, ad_v.AIRINFO_START, ad_v.AIRINFO_RETURN, ad_v.PRICE, ad_v.AIRINFO_DATE, ad_v.AIROPT_GRADE, ad_v.AIRDET_CNT FROM AIRINFO ai JOIN AIRDET_VIEW ad_v USING (AIRINFO_NUM) ORDER BY AIRDET_NUM;";
	static final String sql_SELECTALL_AIRINFONUM = "SELECT AIRINFO_NUM, AIRDET_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, PRICE, AIRINFO_DATE, AIROPT_GRADE, AIRDET_CNT FROM AIRDET_VIEW WHERE AIRINFO_NUM = ?;";

	static final String sql_SELECTONE = "SELECT AIRINFO_NUM, AIRDET_NUM, AIRINFO_AIRLINE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, PRICE, AIRINFO_DATE, AIROPT_GRADE, AIRDET_CNT FROM AIRDET_VIEW WHERE AIRDET_NUM = ?;";

	//===============================[ C ]==================================
	
	// - 항공상세 데이터 삽입 : 크롤링한 항공정보의 PK와 항공옵션 PK 테이블을 이용하여 항공상세 테이블에 데이터 삽입
	public boolean insert(AirDetVO adVO) {
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setInt(1, adVO.getAirInfoNum());
			pstmt.setInt(2, adVO.getAirOptNum());
			if (adVO.getAirOptNum() == 1) {
				// 이코노미 랜덤좌석 200 ~ 300
				pstmt.setInt(3, rand.nextInt(101) + 200);				
			} else if (adVO.getAirOptNum() == 2) {
				// 비즈니스 랜덤좌석 50 ~ 100
				pstmt.setInt(3, rand.nextInt(51) + 50);
			} else if (adVO.getAirOptNum() == 3) {
				// 퍼스트 랜덤좌석 1 ~ 20
				pstmt.setInt(3, rand.nextInt(20) + 1);
			}

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
	
	// - 예매시 잔여좌석 감소(사용자) : 사용자가 항공권 예매시 해당 항공상세 데이터 잔여좌석 감소
	// - 항공권 잔여좌석 변경(관리자) : 관리자가 해당 항공상세 데이터 잔여좌석 변경 (증가, 감소)
	public boolean update(AirDetVO adVO) {
		conn = JDBCUtil.connect();
		try {
			if(adVO.getAirTmpName().equals("감소")) { // 예매시 잔여좌석 감소
				pstmt = conn.prepareStatement(sql_UPDATE_DECREASE);
				pstmt.setInt(1, adVO.getAirDetCnt());
				pstmt.setInt(2, adVO.getAirDetNum());
			} else if(adVO.getAirTmpName().equals("변경")) { // 항공권 잔여좌석 변경
				pstmt = conn.prepareStatement(sql_UPDATE_CHANGE);
				pstmt.setInt(1, adVO.getAirDetCnt());
				pstmt.setInt(2, adVO.getAirDetNum());
			}

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

	//===============================[ D ]==================================

	// - 해당기능없음
	public boolean delete(AirDetVO adVO) {
		return false;
	}

	//===============================[ R ]==================================

	// - 항공상세 목록출력 : 예매, 예매변경(사용자), 항공상세 변경(관리자)시 DB에 보유한 항공상세 목록 조회
	public ArrayList<AirDetVO> selectAll(AirDetVO adVO){
		conn = JDBCUtil.connect();

		ArrayList<AirDetVO> adList = new ArrayList<AirDetVO>();

		try {
			if(adVO.getAirTmpName().equals("예약변경")) { // 예약변경시
				pstmt = conn.prepareStatement(sql_SELECTALL);
			} else if(adVO.getAirTmpName().equals("예약")) { // 예약시
				pstmt = conn.prepareStatement(sql_SELECTALL_AIRINFONUM);
				pstmt.setInt(1, adVO.getAirInfoNum());
			}
			rs = pstmt.executeQuery();

			while (rs.next()) {
				adList.add(new AirDetVO(rs.getInt("AIRDET_NUM"), rs.getInt("AIRINFO_NUM"), rs.getString("AIRINFO_AIRLINE"), rs.getString("AIRINFO_ROUTE"), Util.timeToDate(rs.getTime("AIRINFO_START")), Util.timeToDate(rs.getTime("AIRINFO_RETURN")), rs.getInt("PRICE"), rs.getDate("AIRINFO_DATE"), rs.getString("AIROPT_GRADE"), rs.getInt("AIRDET_CNT")));
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
		return adList;
	}

	// - 항공상세 확인 : 사용자가 입력한 항공상세 번호가 DB에 존재하는지 여부 확인
	// - 항공상세 출력 : 특정 항공상세 번호의 정보를 조회
	public AirDetVO selectOne(AirDetVO adVO){
		conn = JDBCUtil.connect();

		AirDetVO adData = null;

		try {
			pstmt = conn.prepareStatement(sql_SELECTONE);
			pstmt.setInt(1, adVO.getAirDetNum());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				adData = new AirDetVO(rs.getInt("AIRDET_NUM"), rs.getInt("AIRINFO_NUM"), rs.getString("AIRINFO_AIRLINE"), rs.getString("AIRINFO_ROUTE"), Util.timeToDate(rs.getTime("AIRINFO_START")), Util.timeToDate(rs.getTime("AIRINFO_RETURN")), rs.getInt("PRICE"), rs.getDate("AIRINFO_DATE"), rs.getString("AIROPT_GRADE"), rs.getInt("AIRDET_CNT"));
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
		return adData;
	}
}
