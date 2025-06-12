package inter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.LessonDAO;
import dao.SubjectDAO;
import service.ConnectionService;
import service.LessonService;




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
			System.out.println("과목 불러오기 실패");
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

	// 과목 등록
	public boolean insert(Connection conn, SubjectDAO dao) {
		try {
			String insertSQL = "INSERT INTO SUBJECT VALUES (SUBJECT_SEQ.nextval, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setString(1, dao.getNum());
			pstmt.setString(2, dao.getName());
			
			int rc = pstmt.executeUpdate();
			if(rc >= 1) {
				return true;
			} else {
				return false;
			}
		}
		catch (SQLException e) {
			System.out.println("등록 실패");			
		}
		return false;
	}
		
	// 과목 수정
	public boolean update(Connection conn, SubjectDAO dao) {
		try {
			String updateSQL = "UPDATE SUBJECT SET NUM = ?, NAME = ? WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);

			pstmt.setString(1, dao.getNum());
			pstmt.setString(2, dao.getName());
			pstmt.setInt(3, dao.getNo());
			
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
			String deleteSQL = "DELETE FROM SUBJECT WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, dao.getNo());

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
	
	// 과목 검색 /////////////////
	public ArrayList<SubjectDAO>searchByName(Connection conn,String i_name){
		ArrayList<SubjectDAO> subjectDAOList = null;
		try {
			//Statement stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM SUBJECT WHERE NAME LIKE '%'||?||'%'";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, i_name);
			
			ResultSet rs = pstmt.executeQuery();
			
			subjectDAOList = new ArrayList<SubjectDAO>();
			while(rs.next()) {
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
		
}
