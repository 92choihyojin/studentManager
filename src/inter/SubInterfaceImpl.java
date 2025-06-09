package inter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.SubjectDAO;

public class SubInterfaceImpl implements SubInterface {
	public ArrayList<SubjectDAO> selectSubAll(Connection conn) {
		ArrayList<SubjectDAO> subjectDAOList = null;
		try {
			//Statement stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM SUBJECT";
			PreparedStatement pstmt = conn.prepareStatement(selectSQL);
			// 5. 사람을(DML) 탑승시켜 보내고, 오라클에서 실행(executeQuery)시키고 , 실행된 사람 다시 태우고 도착한다.
			ResultSet rs = pstmt.executeQuery();
			// 6. collecction framework (data class) 맘대로 할수있다
			
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
