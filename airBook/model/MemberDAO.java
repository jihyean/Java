package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// ************[ 기 능 ]*************
// - 회원가입
// - 로그인
// - 로그아웃
// - 회원탈퇴
// - 정보변경 : 비밀번호 변경
// *********************************

// 회원 샘플 데이터는 DB에서 추가함
public class MemberDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 쿼리문
	static final String sql_INSERT ="INSERT INTO MEMBER (MEMBER_ID, MEMBER_PW, MEMBER_NAME) VALUES(?, ?, ?)";

	static final String sql_UPDATE ="UPDATE MEMBER SET MEMBER_PW=? WHERE MEMBER_ID=?";

	static final String sql_DELETE ="DELETE FROM MEMBER WHERE MEMBER_ID=?";

	static final String sql_SELECTONE ="SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, STATUS_NUM FROM MEMBER WHERE MEMBER_ID=? AND MEMBER_PW=?";
	static final String sql_SELECTONE_SIGN ="SELECT MEMBER_ID, MEMBER_PW, MEMBER_NAME, STATUS_NUM FROM MEMBER WHERE MEMBER_ID=?";
	
	//===============================[ C ]==================================
	
	// - 회원가입 : DB에 회원 데이터 추가
	public boolean insert(MemberVO mVO) {
		
		conn = JDBCUtil.connect(); // JDBC 연결
		
		try {
			pstmt = conn.prepareStatement(sql_INSERT); // 쿼리문 실행(데이터 삽입)
			pstmt.setString(1, mVO.getMemberId());
			pstmt.setString(2, mVO.getMemberPw());
			pstmt.setString(3, mVO.getMemberName());
			
			int result = pstmt.executeUpdate(); // 쿼리문 업데이트
			if(result <= 0) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000); // 1초 슬립
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		JDBCUtil.disconnect(pstmt, conn); // JDBC 연결해제
		return true;
	}
	
	//===============================[ U ]==================================
	
	// - 회원정보수정 : 비밀번호 변경
	public boolean update(MemberVO mVO) {
		
		conn = JDBCUtil.connect(); // JDBC 연결
		
		try {
			pstmt = conn.prepareStatement(sql_UPDATE); // 쿼리문 실행(데이터 변경)
			pstmt.setString(1, mVO.getMemberPw()); // 첫 번째 물음표(변경할 PW 임시변수)
			pstmt.setString(2, mVO.getMemberId()); // 두 번째 물음표(ID)
			
			int result = pstmt.executeUpdate(); // 쿼리문 업데이트
			if(result <= 0) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000); // 1초 슬립
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		JDBCUtil.disconnect(pstmt, conn); // JDBC 연결해제
		return true;
	}
	
	//===============================[ D ]==================================
	
	// - 회원 탈퇴	: DB에 해당 회원 데이터 삭제
	public boolean delete(MemberVO mVO) {
		
		conn = JDBCUtil.connect(); // JDBC 연결
		
		try {
			pstmt = conn.prepareStatement(sql_DELETE); // 쿼리문 실행(데이터 삭제)
			pstmt.setString(1, mVO.getMemberId()); // 첫 번째 물음표(ID)
			
			int result = pstmt.executeUpdate(); // 쿼리문 업데이트
			if(result <= 0) {
				return false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000); // 1초 슬립
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		
		JDBCUtil.disconnect(pstmt, conn); // JDBC 연결해제
		return true;
	}
	
	//===============================[ R ]==================================
	
	// - 해당기능없음
	public ArrayList<MemberVO> selectAll(MemberVO mVO){
		return null;
	}
	
	// - 로그인 : 해당하는 회원이 존재하는지 유무
	public MemberVO selectOne(MemberVO mVO){
		
		MemberVO mdata = null; // 반환할 임시 객체 생성
		
		conn = JDBCUtil.connect(); // JDBC 연결
		
		//static final String sql_selectOne ="SELECT ID,PW,NAME FROM MEMBER WHERE ID=? AND PW=?";
		
		try {
			
			if(mVO.getTmpString().equals("로그인")) {
				
				pstmt = conn.prepareStatement(sql_SELECTONE); // 쿼리문 실행(데이터 출력)
				pstmt.setString(1, mVO.getMemberId()); // 첫 번째 물음표(ID)
				pstmt.setString(2, mVO.getMemberPw()); // 두 번째 물음표(PW)
				rs = pstmt.executeQuery(); // 쿼리문 업데이트
				
				if(rs.next()) { // 임시 객체에 데이터 저장(ID, PW, NAME)
					mdata = new MemberVO(rs.getString("MEMBER_ID"), rs.getString("MEMBER_PW"), rs.getString("MEMBER_NAME"));
					mdata.setStatusNum(rs.getInt("STATUS_NUM"));
					return mdata;
				}
			}
			else if(mVO.getTmpString().equals("아이디중복확인")) {
				pstmt = conn.prepareStatement(sql_SELECTONE_SIGN); // 쿼리문 실행(데이터 출력)
				pstmt.setString(1, mVO.getMemberId()); // 첫 번째 물음표(ID)
				rs = pstmt.executeQuery(); // 쿼리문 업데이트
				
				if(rs.next()) { // 임시 객체에 데이터 저장(ID, PW, NAME)
					mdata = new MemberVO(rs.getString("MEMBER_ID"), rs.getString("MEMBER_PW"), rs.getString("MEMBER_NAME"));
					mdata.setStatusNum(rs.getInt("STATUS_NUM"));
					return mdata;
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000); // 1초 슬립
			} catch (InterruptedException e1) {
				e1.printStackTrace();
				return null;
			}
		} finally {
			JDBCUtil.disconnect(rs, pstmt, conn); // JDBC 연결해제			
		}
		return null;
	}
}
