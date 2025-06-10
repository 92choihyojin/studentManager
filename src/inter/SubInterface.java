package inter;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StudentDAO;
import dao.SubjectDAO;

public interface SubInterface {
	public ArrayList<SubjectDAO> selectSubAll(Connection conn);
	public SubjectDAO selectSubOne(Connection conn, int id);
	public boolean insert(Connection conn, SubjectDAO dao);
	public boolean update(Connection conn, SubjectDAO dao);
	public boolean delete(Connection conn, SubjectDAO dao);
	public ArrayList<SubjectDAO> searchByName(Connection conn, String name);
	
	
	
}
