package inter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.StudentDAO;


public class StuInterfaceImpl implements StuInterface {
	
	public ArrayList<StudentDAO> selectStuAll(Connection conn) {
		ArrayList<StudentDAO> studentDAOList = null;
		try {
			String selectSQL = "SELECT\r\n"
					+ "    s.NO AS NO,\r\n"
					+ "    s.NUM AS NUM,\r\n"
					+ "    s.NAME AS NAME,\r\n"
					+ "    s.ID AS ID,\r\n"
					+ "    s.PASSWD AS PASSWD,\r\n"
					+ "    s.LESSON_NO AS LESSON_NO,\r\n"
					+ "    l.NAME AS LESSON_NAME,\r\n"
					+ "    s.BIRTHDAY AS BIRTHDAY,\r\n"
					+ "    s.PHONE AS PHONE,\r\n"
					+ "    s.ADDRESS AS ADDRESS,\r\n"
					+ "    s.EMAIL AS EMAIL,\r\n"
					+ "    s.REGISTER_DATE AS REGISTER_DATE \r\n"
					+ "FROM STUDENT s,LESSON l WHERE s.LESSON_NO = l.NO";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			studentDAOList = new ArrayList<StudentDAO>();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String passwd = rs.getString("PASSWD");
				int lessonNo = rs.getInt("LESSON_NO");
				String lessonName = rs.getString("LESSON_NAME");
				String birthday = rs.getString("BIRTHDAY");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				String registerDate = rs.getString("REGISTER_DATE");
				
				StudentDAO studentDAO = new StudentDAO(no, num, name, id, passwd, lessonNo, lessonName, birthday,
						phone, address, email, registerDate);
				studentDAOList.add(studentDAO);
			}
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return studentDAOList;
	}
	
	public StudentDAO selectStuOne(Connection conn, String i_num) {
		StudentDAO studentDAO = null;
		try {
			String selectSQL = "SELECT * FROM STUDENT WHERE NUM = ?";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setString(1, i_num);
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			studentDAO = new StudentDAO();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String passwd = rs.getString("PASSWD");
				int lessonNo = rs.getInt("LESSON_NO");
				String birthday = rs.getString("BIRTHDAY");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				String registerDate = rs.getString("REGISTER_DATE");
				
				studentDAO = new StudentDAO(no, num, name, id, passwd, lessonNo, birthday,
						phone, address, email, registerDate);
			}
			
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return studentDAO;
	}
	
	
	public String selectByLessonNoCount(Connection conn, int no) {
		try {
			String selectSQL = "SELECT NVL(LPAD(COUNT(*)+1,4,0), 0001) AS CNT FROM STUDENT WHERE LESSON_NO = ?";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, no);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			while(rs.next()) {
				String cnt = rs.getString("CNT");
				return cnt;
			}
			
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return null;
	}
	public boolean selectByIdCheck(Connection conn, String id) {
		try {
			String selectSQL = "SELECT COUNT(*) AS CNT FROM STUDENT WHERE ID = ?";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, id);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			while(rs.next()) {
				int cnt = rs.getInt("CNT");
				if (cnt >= 1) {
					return false;
				}else if(cnt == 0) {
					return true;	
				}
			}
			
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return false;
	}
	public boolean insert(Connection conn, StudentDAO dao) {
		try {
			String insertSQL = "INSERT INTO STUDENT VALUES (STUDENT_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate )";
			PreparedStatement pstmt = conn.prepareStatement(insertSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setString(1, dao.getNum());
			pstmt.setString(2, dao.getName());
			pstmt.setString(3, dao.getId());
			pstmt.setString(4, dao.getPasswd());
			pstmt.setInt(5, dao.getLessonNo());
			pstmt.setString(6, dao.getBirthday());
			pstmt.setString(7, dao.getPhone());
			pstmt.setString(8, dao.getAddress());
			pstmt.setString(9, dao.getEmail());
			
			int rc = pstmt.executeUpdate();
			if(rc >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("등록 실패");
			e.printStackTrace();			
		}
		return false;
	}
	public boolean update(Connection conn, StudentDAO dao) {
		try {
			String updateSQL = "UPDATE STUDENT SET NAME = ?, ID = ?, PHONE = ?, EMAIL = ? WHERE NUM = ?";
			PreparedStatement pstmt = conn.prepareStatement(updateSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			
			pstmt.setString(1, dao.getName());
			pstmt.setString(2, dao.getId());
			pstmt.setString(3, dao.getPhone());
			pstmt.setString(4, dao.getEmail());
			pstmt.setString(5, dao.getNum());
			
			int rc = pstmt.executeUpdate();
			if(rc >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("등록 실패");
			e.printStackTrace();			
		}
		return false;
	}
	public boolean delete(Connection conn, StudentDAO dao) {
		try {
			String deleteSQL = "DELETE STUDENT WHERE NUM = ?";
			PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setString(1, dao.getNum());
			
			int rc = pstmt.executeUpdate();
			if(rc >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("등록 실패");
			e.printStackTrace();			
		}
		return false;
	}
	public ArrayList<StudentDAO> searchByName(Connection conn, String i_name) {
		ArrayList<StudentDAO> studentDAOList = null;
		try {
			String selectSQL = "SELECT\r\n"
					+ "    s.NO AS NO,\r\n"
					+ "    s.NUM AS NUM,\r\n"
					+ "    s.NAME AS NAME,\r\n"
					+ "    s.ID AS ID,\r\n"
					+ "    s.PASSWD AS PASSWD,\r\n"
					+ "    s.LESSON_NO AS LESSON_NO,\r\n"
					+ "    l.NAME AS LESSON_NAME,\r\n"
					+ "    s.BIRTHDAY AS BIRTHDAY,\r\n"
					+ "    s.PHONE AS PHONE,\r\n"
					+ "    s.ADDRESS AS ADDRESS,\r\n"
					+ "    s.EMAIL AS EMAIL,\r\n"
					+ "    s.REGISTER_DATE AS REGISTER_DATE \r\n"
					+ "FROM STUDENT s,LESSON l WHERE s.LESSON_NO = l.NO"
					+ "AND NAME LIKE '%'||?||'%'";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			pstmt.setString(1, i_name);
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
			studentDAOList = new ArrayList<StudentDAO>();
			while(rs.next()) {
				int no = rs.getInt("NO");
				String num = rs.getString("NUM");
				String name = rs.getString("NAME");
				String id = rs.getString("ID");
				String passwd = rs.getString("PASSWD");
				int lessonNo = rs.getInt("LESSON_NO");
				String lessonName = rs.getString("LESSON_NAME");
				String birthday = rs.getString("BIRTHDAY");
				String phone = rs.getString("PHONE");
				String address = rs.getString("ADDRESS");
				String email = rs.getString("EMAIL");
				String registerDate = rs.getString("REGISTER_DATE");
				
				StudentDAO studentDAO = new StudentDAO(no, num, name, id, passwd, lessonNo, lessonName, birthday,
						phone, address, email, registerDate);
				studentDAOList.add(studentDAO);
			}
			
		} catch (SQLException e) {
			System.out.println("createStatment 생성실패");
		}
		return studentDAOList;
	}
}
