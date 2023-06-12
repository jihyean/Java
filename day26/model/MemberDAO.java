package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;

	// 회원가입
	public boolean insert(MemberVO mVO) {
		final String sql_insert="INSERT INTO MEMBER (MID,MPW) VALUES('"+mVO.getMid()+"','"+mVO.getMpw()+"')";

		conn=JDBCUtil.connect();
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql_insert);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			return false;
		}
		JDBCUtil.disconnect(stmt, conn);
		return true;
	}
	
	// 상품구매
	// 비번변경
	public boolean update(MemberVO mVO) {
		final String sql_update_total="UPDATE MEMBER SET TOTAL=TOTAL+"+mVO.getTmpPrice()+" WHERE MID='"+mVO.getMid()+"'";
		final String sql_update_pass="UPDATE MEMBER SET MPW = '"+mVO.getMpw()+"' WHERE MID='"+mVO.getMid()+"'";

		conn=JDBCUtil.connect();
		try {
			stmt=conn.createStatement();
			int result = 0;
			if(mVO.getTmpPrice() >= 0) { // 만약 tmpPrice가 양수면 == 유효한 값을 가지고 있으면		
				result=stmt.executeUpdate(sql_update_total);
			}
			else if(mVO.getTmpPrice() == -1) { // tmpPrice에 -1을 줘서 기능 구분
				result=stmt.executeUpdate(sql_update_pass);
			}
			
			if(result<=0) {
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
		JDBCUtil.disconnect(stmt, conn);
		return true;
	}
	
	// 회원탈퇴
	public boolean delete(MemberVO mVO) {
		final String sql_delete="DELETE FROM MEMBER WHERE MID='"+mVO.getMid()+"'";

		conn=JDBCUtil.connect();
		try {
			stmt=conn.createStatement();
			int result=stmt.executeUpdate(sql_delete);
			if(result<=0) {
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
		JDBCUtil.disconnect(stmt, conn);
		return true;
	}

	private ArrayList<MemberVO> selectAll(MemberVO mVO){
		return null;
	}
	
	// 로그인
	public MemberVO selectOne(MemberVO mVO){
		final String sql_selectOne="SELECT MID,MPW,TOTAL FROM MEMBER WHERE MID='"+mVO.getMid()+"' AND MPW='"+mVO.getMpw()+"'";

		MemberVO mdata=null;
		
		conn=JDBCUtil.connect();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql_selectOne);

			if(rs.next()) {
				mdata=new MemberVO(rs.getString("MID"),rs.getString("MPW"),rs.getInt("TOTAL"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
		JDBCUtil.disconnect(rs, stmt, conn);
		
		return mdata;
	}
}
