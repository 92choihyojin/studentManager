package inter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.SubjectDAO;




public class CouInterfaceImpl implements CouInterface {
	// 수강 불러오기
	public ArrayList<CourseDAO> selectCourseAll(Connection conn) {
		ArrayList<CourseDAO> CourseDAOList = null;
		try {
			// Statement stmt = conn.createStatement();
			String selectSQL = "SELECT\r\n"
					+ "C.NO, \r\n"
					+ "SUB.NAME SUBJECT_NAME,\r\n"
					+ "STU.NUM STUDENT_NUM,\r\n"
					+ "STU.NAME STUDENT_NAME,\r\n"
					+ "L.NAME LESSON_NAME\r\n"
					+ "FROM COURSE C, \r\n"
					+ "     LESSON L, \r\n"
					+ "     STUDENT STU, \r\n"
					+ "     SUBJECT SUB \r\n"
					+ "WHERE C.SUB_NO = SUB.NO \r\n"
					+ "AND C.STU_NO = STU.NO \r\n"
					+ "AND STU.LESSON_NO = L.NO";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			ResultSet rs = pstmt.executeQuery();

			CourseDAOList = new ArrayList<CourseDAO>();
			while (rs.next()) {
				int no = rs.getInt("NO");
				String subject_name = rs.getString("SUBJECT_NAME");
				String stu_num = rs.getString("STUDENT_NUM");
				String stu_name = rs.getString("STUDENT_NAME");
				String lesson_name = rs.getString("LESSON_NAME");

				
				CourseDAO CourseDAO = new CourseDAO(no, subject_name, stu_num, stu_name, lesson_name);
				CourseDAOList.add(CourseDAO);
			}
		} catch (SQLException e) {
			System.out.println("수강 불러오기 실패");
		}
		return CourseDAOList;
	}

	// 수강 1개만 불러오기
	public CourseDAO selectCouOne(Connection conn, int i_no) {
		CourseDAO courseDAO = null;
		String selectSQL = "SELECT\r\n"
				+ "C.NO, \r\n"
				+ "SUB.NAME SUBJECT_NAME,\r\n"
				+ "STU.NUM STUDENT_NUM,\r\n"
				+ "STU.NAME STUDENT_NAME,\r\n"
				+ "L.NAME LESSON_NAME\r\n"
				+ "FROM COURSE C, \r\n"
				+ "     LESSON L, \r\n"
				+ "     STUDENT STU, \r\n"
				+ "     SUBJECT SUB \r\n"
				+ "WHERE C.SUB_NO = SUB.NO \r\n"
				+ "AND C.STU_NO = STU.NO \r\n"
				+ "AND STU.LESSON_NO = L.NO\r\n"
				+ "AND C.NO = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, i_no);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("NO");
				String subject_name = rs.getString("SUBJECT_NAME");
				String stu_num = rs.getString("STUDENT_NUM");
				String stu_name = rs.getString("STUDENT_NAME");
				String lesson_name = rs.getString("LESSON_NAME");

				
				return new CourseDAO(no, subject_name, stu_num, stu_name, lesson_name);
			}
		} catch (SQLException e) {
			System.out.println("과목 불러오기 실패");
		}
		return null;
	}

	public String selectByCouNoCount(Connection con, int no) {
		return "";
	}
	public boolean selectByIdCheck(Connection conn, String id) {
		return false;
	}
	
	// 수강 등록
	public boolean insert(Connection conn, CourseDAO dao) {
		try {
			String insertSQL = "INSERT INTO COURSE VALUES (COURSE_SEQ.nextval, ?, (SELECT NO FROM STUDENT WHERE NUM = ?))";
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			
			pstmt.setInt(1, dao.getSub_no());
			pstmt.setString(2, dao.getStu_num());
			
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
		
	// 수강 수정
//	public boolean update(Connection conn, CourseDAO dao) {
//		try {
//			String updateSQL = "UPDATE SUBJECT SET NUM = ?, NAME = ? WHERE NO = ?";
//			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
//
//			pstmt.setString(1, dao.getNum());
//			pstmt.setString(2, dao.getName());
//			pstmt.setInt(3, dao.getNo());
//			
//			int rc = pstmt.executeUpdate();
//
//			if (rc >= 1) {
//				return true;
//			} else {
//				return false;
//			}
//		} catch (SQLException e) {
//			System.out.println("과목 수정(update) 실패");
//			e.printStackTrace();
//		}
//		return false;
//	}

	// 수강 삭제
	public boolean delete(Connection conn, CourseDAO dao) {
		try {
			String deleteSQL = "DELETE FROM COURSE WHERE NO = ?";
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
	
	// 수강 검색 /////////////////
//	public ArrayList<CourseDAO>searchByName(Connection conn, String i_name){
//		ArrayList<CourseDAO> courseDAOList = null;
//		try {
//			//Statement stmt = conn.createStatement();
//			String selectSQL = "SELECT * FROM SUBJECT WHERE NAME LIKE '%'||?||'%'";
//			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
//			pstmt.setString(1, i_name);
//			
//			ResultSet rs = pstmt.executeQuery();
//			
//			subjectDAOList = new ArrayList<SubjectDAO>();
//			while(rs.next()) {
//				int no = rs.getInt("NO");
//				String num = rs.getString("NUM");
//				String name = rs.getString("NAME");
//				
//				SubjectDAO subjectDAO = new SubjectDAO(no, num, name);
//				subjectDAOList.add(subjectDAO);
//			}
//		} catch (SQLException e) {
//			System.out.println("createStatment 생성실패");
//		}
//		return subjectDAOList;
//	}
		
}
