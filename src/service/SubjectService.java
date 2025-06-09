package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import dao.SubjectDAO;
import inter.SubInterfaceImpl;

public class SubjectService {
	public static ArrayList<SubjectDAO> selectSubAll(Connection conn) {
		return new SubInterfaceImpl().selectSubAll(conn);
	}
}
