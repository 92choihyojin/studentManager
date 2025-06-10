package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.SubjectDAO;
import inter.SubInterfaceImpl;

public class SubjectService {
	//
	public ArrayList<SubjectDAO> selectSubAll(Connection conn) {
		return new SubInterfaceImpl().selectSubAll(conn);
	}

	// 1가지만 검색
	public SubjectDAO selectSubOne(Connection conn, int i_no) {
		return new SubInterfaceImpl().selectSubOne(conn, i_no);
	}

	// 입력
	public boolean insert(Connection conn, SubjectDAO dao) {
		return new SubInterfaceImpl().insert(conn, dao);
	}

	// 수정
	public boolean update(Connection conn, SubjectDAO dao) {
		return new SubInterfaceImpl().update(conn, dao);
	}

	// 삭제
	public boolean delete(Connection conn, SubjectDAO dao) {
		return new SubInterfaceImpl().delete(conn, dao);
	}
	public ArrayList<SubjectDAO> selectByName(Connection conn, String name) {
		return new SubInterfaceImpl().selectByName(conn, name);
	}

}