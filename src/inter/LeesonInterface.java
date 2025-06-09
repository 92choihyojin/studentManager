package inter;

import java.sql.Connection;
import java.util.ArrayList;

import dao.LessonDAO;

public interface LeesonInterface {
	public ArrayList<LessonDAO> selectLessonAll(Connection conn);
	public boolean insert(Connection conn, LessonDAO dao);
	public LessonDAO searchByNo(Connection conn, LessonDAO dao);
	public boolean update(Connection conn, LessonDAO dao);
	public boolean delete(Connection conn, LessonDAO dao);
	public ArrayList<LessonDAO> searchByName(Connection conn, String name);
}
