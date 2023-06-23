package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StatusDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	static final String sql_INSERT ="INSERT INTO STATUS (STATUS_NAME) VALUES (?)";
	
	public boolean insert(StatusVO sVO) {
		conn = JDBCUtil.connect();
		
		try {
			pstmt = conn.prepareStatement(sql_INSERT);
			pstmt.setString(1, sVO.getStatusName());
			
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
	public boolean update(StatusVO sVO) {
		return false;
	}
	public boolean delete(StatusVO sVO) {
		return false;
	}

	public ArrayList<StatusVO> selectAll(StatusVO sVO){
		return null;
	}

	public MemberVO selecOne(StatusVO sVO){
		return null;
	}
}
