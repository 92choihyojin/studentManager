package inter;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SubjectDAO;

public interface SubInterface {
	public ArrayList<SubjectDAO> selectSubAll(Connection conn);
	
}
