package inter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.LessonDAO;


public class LeesonInterfaceImpl implements LeesonInterface {
	
	//학과 목록
	public ArrayList<LessonDAO> selectLessonAll(Connection conn) {
		ArrayList<LessonDAO> lessonDAOList = null;
		try {
			//Statement stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM LESSON";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			lessonDAOList = new ArrayList<LessonDAO>();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String abbre = rs.getString("ABBRE");
				String name = rs.getString("NAME");
				
				LessonDAO lessonDAO = new LessonDAO(no, abbre, name);
				lessonDAOList.add(lessonDAO);
			}
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return lessonDAOList;
	}
	// 학과 등록
	public boolean insert(Connection conn, LessonDAO dao) {
		try {
			String insertSQL = "INSERT INTO LESSON VALUES (LESSON_SEQ.nextval, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, dao.getAbbre());
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
	// 학과번호 검색
	public LessonDAO searchByNo(Connection conn, LessonDAO dao) {
		LessonDAO lessonDAO = null;
		try {
			//Statement stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM LESSON WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setInt(1, dao.getNo());
			
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			while(rs.next()) {
				int no = rs.getInt("NO");
				String abbre = rs.getString("ABBRE");
				String name = rs.getString("NAME");
				return lessonDAO = new LessonDAO(no, abbre, name);
			}
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return lessonDAO;
	}
	
	//학과 수정
	public boolean update(Connection conn, LessonDAO dao) {
		try {
			String updateSQL = "UPDATE LESSON SET ABBRE = ?, NAME = ? WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setString(1, dao.getAbbre());
			pstmt.setString(2, dao.getName());
			pstmt.setInt(3, dao.getNo());
			
			int rc = pstmt.executeUpdate();
			if(rc >= 1) {
				return true;
			} else {
				return false;
			}
		}
		catch (SQLException e) {
			System.out.println("수정 실패");			
		}
		return false;
	}
	// 학과 삭제
	public boolean delete(Connection conn, LessonDAO dao) {
		try {
			String deleteSQL = "DELETE FROM LESSON WHERE NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.

			pstmt.setInt(1, dao.getNo());
			
			int rc = pstmt.executeUpdate();
			if(rc >= 1) {
				return true;
			} else {
				return false;
			}
		}
		catch (SQLException e) {
			System.out.println("삭제 실패");			
		}
		return false;
	}
	// 학과명 검색
	public ArrayList<LessonDAO> searchByName(Connection conn, String i_name) {
		ArrayList<LessonDAO> lessonDAOList = null;
		try {
			//Statement stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM LESSON WHERE ABBRE LIKE '%'||?||'%' OR NAME LIKE '%'||?||'%'";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setString(1, i_name);
			pstmt.setString(2, i_name);
			
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			lessonDAOList = new ArrayList<LessonDAO>();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String abbre = rs.getString("ABBRE");
				String name = rs.getString("NAME");
				
				LessonDAO lessonDAO = new LessonDAO(no, abbre, name);
				lessonDAOList.add(lessonDAO);
			}
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return lessonDAOList;
	}
}
