package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.LessonDAO;
import inter.LeesonInterfaceImpl;

public class LessonService {
	public ArrayList<LessonDAO> selectLessonAll(Connection conn) {
		return new LeesonInterfaceImpl().selectLessonAll(conn);
	}
	public boolean insert(Connection conn, LessonDAO dao) {
		return new LeesonInterfaceImpl().insert(conn, dao);
	}
	public LessonDAO searchByNo(Connection conn, LessonDAO dao) {
		return new LeesonInterfaceImpl().searchByNo(conn, dao);
	}
	public boolean update(Connection conn, LessonDAO dao) {
		return new LeesonInterfaceImpl().update(conn, dao);
	}
	public boolean delete(Connection conn, LessonDAO dao) {
		return new LeesonInterfaceImpl().delete(conn, dao);
	}
	public ArrayList<LessonDAO> searchByName(Connection conn, String name) {
		return new LeesonInterfaceImpl().searchByName(conn, name);
	}
}
