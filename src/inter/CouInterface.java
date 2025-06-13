package inter;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CourseDAO;

public interface CouInterface {	
	public ArrayList<CourseDAO> selectCourseAll(Connection conn );
	public CourseDAO selectCouOne(Connection conn, int no);
	public String selectByCouNoCount(Connection con, int no);
	public boolean selectByIdCheck(Connection conn, String id);
	public boolean insert(Connection conn, CourseDAO dao);
	//public boolean update(Connection conn, CourseDAO dao);
	public boolean delete(Connection conn, CourseDAO dao);
	//public ArrayList<CourseDAO> searchByName(Connection conn, String name);
}
