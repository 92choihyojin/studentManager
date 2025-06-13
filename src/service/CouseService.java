package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.CourseDAO;
import dao.SubjectDAO;
import inter.CouInterfaceImpl;

public class CouseService {
	//수강신청 목록
	public ArrayList<CourseDAO> selectCourseAll(Connection conn) {
		return new CouInterfaceImpl().selectCourseAll(conn);
	}

	// 1가지만 검색
	public CourseDAO selectCourseOne(Connection conn, int i_no) {
		return new CouInterfaceImpl().selectCouOne(conn, i_no);
	}

	// 입력
	public boolean insert(Connection conn, CourseDAO dao) {
		return new CouInterfaceImpl().insert(conn, dao);
	}

	// 수정
	public boolean update(Connection conn, CourseDAO dao) {
		return false; //new CouInterfaceImpl().update(conn, dao);
	}

	// 삭제
	public boolean delete(Connection conn, CourseDAO dao) {
		return new CouInterfaceImpl().delete(conn, dao);
	}
	// 검색
	public ArrayList<CourseDAO> selectByName(Connection conn, String name) {
		return null;//new CouInterfaceImpl().searchByName(conn, name);
	}

}