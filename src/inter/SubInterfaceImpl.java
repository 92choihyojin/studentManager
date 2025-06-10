package inter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.SubjectDAO;




public class SubInterfaceImpl implements SubInterface {
	// 과목 불러오기
	public ArrayList<SubjectDAO> selectSubAll(Connection conn) {
		ArrayList<SubjectDAO> subjectDAOList = null;
		try {
			// Statement stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM SUBJECT";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			ResultSet rs = pstmt.executeQuery();

			subjectDAOList = new ArrayList<SubjectDAO>();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String name = rs.getString("NAME");

				SubjectDAO subjectDAO = new SubjectDAO(no, num, name);
				subjectDAOList.add(subjectDAO);
			}
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return subjectDAOList;
	}

	// 과목 1개만 불러오기
	public SubjectDAO selectSubOne(Connection conn, int i_no) {
		SubjectDAO subjectDAO = null;
		String selectSQL = "SELECT * FROM SUBJECT WHERE NO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, i_no);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String name = rs.getString("NAME");
				subjectDAO = new SubjectDAO(no, num, name);
			}
		} catch (SQLException e) {
			System.out.println("과목 불러오기 실패");
		}
		return subjectDAO;
	}

	public boolean insert(Connection conn, SubjectDAO dao) {
		return false;
	}

	// 과목 수정
	public boolean update(Connection conn, SubjectDAO dao) {
		try {
			String updateSQL = "UPDATE * FROM SUBJECT SET NO = ?, NUM = ?, NAME = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);

			pstmt.setInt(1, dao.getNo());
			pstmt.setString(2, dao.getNum());
			pstmt.setString(3, dao.getName());

			int rc = pstmt.executeUpdate();
			if (rc >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("과목 수정(update) 실패");
			e.printStackTrace();
		}
		return false;
	}

	// 과목 삭제
	public boolean delete(Connection conn, SubjectDAO dao) {
		try {
			String deleteSQL = "DELETE * FROM SUBJECT WHERE NUM = ?";
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setString(1, dao.getNum());

			int rc = pstmt.executeUpdate();
			if (rc >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("과목 삭제(delete) 실패");
			e.printStackTrace();
		}
		return false;
	}
	public ArrayList<SubjectDAO>searchByName(Connection conn,String name){
		return null;
	}
}
