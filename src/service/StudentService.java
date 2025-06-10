package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.StudentDAO;
import inter.StuInterfaceImpl;

public class StudentService {
	public ArrayList<StudentDAO> selectStuAll(Connection conn) {
		return new StuInterfaceImpl().selectStuAll(conn);
	}
	public StudentDAO selectStuOne(Connection conn, String num) {
		return new StuInterfaceImpl().selectStuOne(conn, num);
	}
	public String selectByLessonNoCount(Connection conn, int no) {
		return new StuInterfaceImpl().selectByLessonNoCount(conn, no);
	}
	public boolean selectByIdCheck(Connection conn, String id) {
		return new StuInterfaceImpl().selectByIdCheck(conn, id);
	}
	public boolean insert(Connection conn, StudentDAO dao) {
		return new StuInterfaceImpl().insert(conn, dao);
	}
	public boolean update(Connection conn, StudentDAO dao) {
		return new StuInterfaceImpl().update(conn, dao);
	}
	public boolean delete(Connection conn, StudentDAO dao) {
		return new StuInterfaceImpl().delete(conn, dao);
	}
	public ArrayList<StudentDAO> searchByName(Connection conn, String name) {
		return new StuInterfaceImpl().searchByName(conn, name);
	}
}
