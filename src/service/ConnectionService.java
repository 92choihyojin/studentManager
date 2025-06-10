package service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionService {
	public Connection getConn() {
		Connection conn = null;
		try {
			// 1. 드라이버를 로드한다. (해당되는 클래스 메모리 로드하는 기능)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//*****************************************************************
			// 2단계 1. db.properties 파일경로를 가져온다.
			String filepath = "D:/javaWorkspace/studentManager/src/config/db.properties";
			// 2단계 2. properties 객체를 만든다.
			Properties properties = new Properties();
			// 2단계 3. properties 객체에 해당된 파일을 로드한다.
			properties.load(new FileReader(filepath));
			// 2단계 4. 로드된 파일을 properties 
			String url = properties.getProperty("url");
			String id = properties.getProperty("id");
			String pwd = properties.getProperty("pwd");
			//*****************************************************************
			
			// 2. URL(오라클주소:포트번호) 아이디, 패스워드 필요
			conn = DriverManager.getConnection(url, id, pwd);
			if(conn == null) {
				System.out.println("오라클 서버 연결 실패");
				return null;
			} else {
				return conn;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 서버를 찾을 수 없습니다.");
		} catch (SQLException e) {
			System.out.println("오라클 서버에 연결을 실패하였습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("db.properties 로드 실패하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
