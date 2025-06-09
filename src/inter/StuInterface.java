package inter;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StudentDAO;

public interface StuInterface {
	public ArrayList<StudentDAO> selectStuAll(Connection conn);
	public StudentDAO selectStuOne(Connection conn, String num);
	public String selectByLessonNoCount(Connection con, int no);
	public boolean selectByIdCheck(Connection conn, String id);
	public boolean insert(Connection conn, StudentDAO dao);
	public boolean update(Connection conn, StudentDAO dao);
	public boolean delete(Connection conn, StudentDAO dao);
	public ArrayList<StudentDAO> searchByName(Connection conn, String name);
}
