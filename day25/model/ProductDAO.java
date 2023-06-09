package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {

	private Connection conn;
	private Statement stmt;

	// insert를 배열리스트 사이즈 == 데이터 개수만큼 반복 ---> for문()
	public boolean insert(ProductVO pVO) {

		conn = JDBCUtil.connect();

		if (conn == null) {
			System.out.println("로그: ProductDAO JDBC 연결 실패");
			return false;
		}

		// 3. 데이터 read, write
		stmt = null;

		try {
			stmt = conn.createStatement();

			final String sql_INSERT = "INSERT INTO PRODUCT(NAME, PRICE, DISCOUNT) VALUES ('" + pVO.getName() + "', "
					+ pVO.getPrice() + ", " + pVO.getDiscount() + ");";

			int res = stmt.executeUpdate(sql_INSERT);

			if (res <= 0) {
				// 적용된 row 없음
				return false;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);
		}

		return true;
	}

	public ArrayList<ProductVO> selectAll(ProductVO pVO) {

		ArrayList<ProductVO> mdatas = new ArrayList<ProductVO>();
		conn = JDBCUtil.connect();

		// 3. 데이터 read, write
		stmt = null;

		final String sql_SELECTALL = "SELECT NUM, NAME, PRICE, DISCOUNT FROM PRODUCT WHERE NAME LIKE '%"
				+ pVO.getName() + "%';";

		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTALL); // 이터레이터 유사

			while (rs.next()) {
				ProductVO pArg = new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("PRICE"),
						rs.getInt("DISCOUNT"));
				mdatas.add(pArg);

			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}
		finally {
			JDBCUtil.disconnect(rs, stmt, conn);		
		}
		
		return mdatas;
	}

	public ProductVO selectOne(ProductVO pVO) {
		ProductVO pArg = null;

		conn = JDBCUtil.connect();

		stmt = null;
		final String sql_SELECTONE = "SELECT NUM, NAME, PRICE, DISCOUNT FROM PRODUCT WHERE NUM=" + pVO.getNum() + ";";

		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_SELECTONE); // 이터레이터 유사

			if (rs.next()) {
				pArg = new ProductVO(rs.getInt("NUM"), rs.getString("NAME"), rs.getInt("PRICE"), rs.getInt("DISCOUNT"));

			} else {
				pArg = new ProductVO(-1, null, 0, 0);
				return pArg;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, stmt, conn);
		}

		return pArg;
	}

	public boolean update(ProductVO pVO) {
		conn = JDBCUtil.connect();

		// 3. 데이터 read, write
		stmt = null;

		try {
			stmt = conn.createStatement();

			final String sql_UPDATE = "UPDATE PRODUCT SET NAME = '" + pVO.getName() + "' WHERE NUM = " + pVO.getNum()
					+ ";";

			int res = stmt.executeUpdate(sql_UPDATE);

			if (res <= 0) {
				System.out.println("해당 상품은 존재하지 않습니다");
				return false;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);
		}

		return true;
	}

	public boolean delete(ProductVO pVO) {

		conn = JDBCUtil.connect();

		// 3. 데이터 read, write
		stmt = null;

		try {
			stmt = conn.createStatement();

			final String sql_DELETE = "DELETE FROM PRODUCT WHERE NUM =" + pVO.getNum() + ";";

			int res = stmt.executeUpdate(sql_DELETE);

			if (res <= 0) {
				System.out.println("해당 상품은 존재하지 않습니다");
				return false;
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(stmt, conn);
		}

		return true;
	}
}
