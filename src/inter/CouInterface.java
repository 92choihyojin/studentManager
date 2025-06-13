package inter;

import java.sql.Connection;
import java.util.ArrayList;

import dao.StudentDAO;

public interface CouInterface {	
	public ArrayList<CouseDAO> selectCouAll(Connection conn );
//	public CouseDAO selectCosOne(Connection conn, String num);
//	public String selectByCosNoCount(Connection con, int no);
//	public boolean selectByIdCheck(Connection conn, String id);
//	public boolean insert(Connection conn, CouseDAO dao);
//	public boolean update(Connection conn, CouseDAO dao);
//	public boolean delete(Connection conn, CouseDAO dao);
//	public ArrayList<CouseDAO> searchByName(Connection conn, String name);
}
