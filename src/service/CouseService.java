package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SubjectDAO;
import inter.SubInterfaceImpl;

public class CouseService {
	//수강신청 목록
	public ArrayList<CouseDAO> selectCouseAll(Connection conn) {
		return new CouInterfaceImpl().selectCouseAll(conn);
	}

	// 1가지만 검색
	public SubjectDAO selectSubOne(Connection conn, int i_no) {
		return new CouInterfaceImpl().selectCosOne(conn, i_no);
	}

	// 입력
	public boolean insert(Connection conn, SubjectDAO dao) {
		return new CouInterfaceImpl().insert(conn, dao);
	}

	// 수정
	public boolean update(Connection conn, SubjectDAO dao) {
		return new CouInterfaceImpl().update(conn, dao);
	}

	// 삭제
	public boolean delete(Connection conn, SubjectDAO dao) {
		return new CouInterfaceImpl().delete(conn, dao);
	}
	// 검색
	public ArrayList<CouseDAO> selectByName(Connection conn, String name) {
		return new CouInterfaceImpl().searchByName(conn, name);
	}

}