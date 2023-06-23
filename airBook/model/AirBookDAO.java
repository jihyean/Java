package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AirBookDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	// 쿼리문
	static final String sql_INSERT = "INSERT INTO AIRBOOK(MEMBER_ID, AIRDET_NUM, AIRBOOK_CNT, AIRBOOK_CARD) VALUES (?, ?, ?, ?)";

	static final String sql_UPDATE = "UPDATE AIRBOOK SET AIRDET_NUM = ?, AIRBOOK_DATE = CURRENT_DATE, AIRBOOK_CNT = ? WHERE AIRBOOK_NUM = ?";

	static final String sql_DELETE = "DELETE FROM AIRBOOK WHERE AIRBOOK_NUM = ?";

	static final String sql_SELECTALL = "SELECT AIRBOOK_NUM, MEMBER_ID, AIRDET_NUM, AIRBOOK_CNT, AIRBOOK_DATE, AIRBOOK_CARD FROM AIRBOOK WHERE MEMBER_ID = ?";

	static final String sql_SELECTONE = "SELECT AIRBOOK_NUM, MEMBER_ID, AIRDET_NUM, AIRBOOK_CNT, AIRBOOK_DATE, AIRBOOK_CARD FROM AIRBOOK WHERE AIRBOOK_NUM = ?";
	static final String sql_SELECTONE_Ticket = "SELECT AIRINFO_NUM, MEMBER_NAME, AIROPT_GRADE, AIRINFO_ROUTE, AIRINFO_START, AIRINFO_RETURN, AIRINFO_PRICE, AIRINFO_DATE\r\n"
			+ "FROM TICKET_VIEW\r\n"
			+ "WHERE AIRBOOK_NUM = (\r\n"
			+ "SELECT AIRBOOK_NUM\r\n"
			+ "FROM AIRBOOK\r\n"
			+ "WHERE MEMBER_ID = ?\r\n"
			+ "ORDER BY AIRBOOK_NUM DESC LIMIT 1\r\n"
			+ ")";

	//===============================[ C ]==================================
	
	// - 항공권 예매 : DB에 항공예매정보 데이터 추가
	public boolean insert(AirBookVO abVO) {
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, abVO.getMemberId());
			pstmt.setInt(2, abVO.getAirDetNum());
			pstmt.setInt(3, abVO.getAirBookCnt());
			pstmt.setString(4, abVO.getAirBookCard());

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
	
	// - 항공원 예매 변경 : 해당 항공예매정보 데이터 수정
	public boolean update(AirBookVO abVO) {
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_UPDATE);
			pstmt.setInt(1, abVO.getAirDetNum());
			pstmt.setInt(2, abVO.getAirBookCnt());
			pstmt.setInt(3, abVO.getAirBooknum());

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
	
	// - 예매 취소 : 해당 항공예매정보 데이터 삭제
	public boolean delete(AirBookVO abVO) {
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_DELETE);
			pstmt.setInt(1, abVO.getAirBooknum());

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
	
	// - 예매한 항공권목록 : 로그인한 사용자의 항공예매정보 목록을 조회
	public ArrayList<AirBookVO> selectAll(AirBookVO abVO) {
		ArrayList<AirBookVO> abdatas = new ArrayList<AirBookVO>();
		conn = JDBCUtil.connect();

		try {
			pstmt = conn.prepareStatement(sql_SELECTALL);
			pstmt.setString(1, abVO.getMemberId());

			rs = pstmt.executeQuery();
			while (rs.next()) {
				abdatas.add(new AirBookVO(rs.getInt("AIRBOOK_NUM"), rs.getString("MEMBER_ID"), rs.getInt("AIRDET_NUM"),
						rs.getInt("AIRBOOK_CNT"), rs.getDate("AIRBOOK_DATE"), rs.getString("AIRBOOK_CARD")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		JDBCUtil.disconnect(rs, pstmt, conn);
		return abdatas;
	}

	// - 예매한 항공권 : 로그인한 사용자의 특정 항공예매정보를 조회
	public AirBookVO selectOne(AirBookVO abVO) {
		AirBookVO abdata;
		conn = JDBCUtil.connect();

		try {

			if (abVO.getTmpString().equals("티켓")) {

				pstmt = conn.prepareStatement(sql_SELECTONE_Ticket);
				pstmt.setString(1, abVO.getMemberId());

				rs = pstmt.executeQuery();
				if (rs.next()) {
					
					abdata = new AirBookVO(rs.getInt("AIRINFO_NUM"), rs.getString("MEMBER_NAME"), 0, 0, rs.getDate("AIRINFO_DATE"), 
							rs.getString("AIROPT_GRADE"));
					
					abdata.setTmpStart(rs.getString("AIRINFO_START"));
					abdata.setTmpReturn(rs.getString("AIRINFO_RETURN"));
					abdata.setTmpDate(rs.getString("AIRINFO_ROUTE"));
					
					return abdata;
				}

			}
			else {
				pstmt = conn.prepareStatement(sql_SELECTONE);
				pstmt.setInt(1, abVO.getAirBooknum());

				rs = pstmt.executeQuery();
				if (rs.next()) {
					abdata = new AirBookVO(rs.getInt("AIRBOOK_NUM"), rs.getString("MEMBER_ID"), rs.getInt("AIRDET_NUM"),
							rs.getInt("AIRBOOK_CNT"), rs.getDate("AIRBOOK_DATE"), rs.getString("AIRBOOK_CARD"));
					return abdata;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.disconnect(rs, pstmt, conn);
		}
		return null;
	}
}