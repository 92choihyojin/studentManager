package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CouseDAO;
import dao.LessonDAO;
import dao.SubjectDAO;
import service.ConnectionService;
import service.LessonService;
import service.SubjectService;

public class CouseController {
	// 수강 목록
	public void list() throws Exception {
		System.out.println("수강 목록 나옴");
		CouseDAO cd = new CouseDAO();
		CouseService cs = new CouseService();
		ConnectionService connectionService = new ConnectionService();
		
		System.out.println("수강 전체 리스트");
		ArrayList<CouseDAO> CouseDAOList =  ;
		if (CouseDAOList.size() == 0) {
			System.out.println("수강전체리스트 내용이 없습니다.");
			return;
		} else if (CouseDAOList == null) {
			System.out.println("수강전체리스트 에러발생");
			return;
		} else if (CouseDAOList.size() >= 1) {
			System.out.println("|순번| 약어 | 학과명 ");
			for (CouseDAO data : CouseDAOList) {
				System.out.printf("%d | %s | %s | %s \n", data.getNo(), data.getNum(), data.getId(), data.getPwd());
			}
		}
	}
	// 수강 등록
	public void register() throws Exception {
		System.out.println("수강 등록 나옴");
		
		Scanner scan = new Scanner(System.in);
		CouseDAO cd = new CouseDAO();
		CouseService cs = new CouseService();
		ConnectionService connectionService = new ConnectionService();
		
//		String num; // 과목번호
//		String name; // 과목명
//
//		System.out.println("과목 정보 입력");
//		System.out.print("과목 번호 : ");
//		num = scan.nextLine();
//		System.out.print("과목명  : ");
//		name = scan.nextLine();
//
//		sd.setNum(num);
//		sd.setName(name);
//
//		
//		ss.insert(connectionService.getConn(), sd);
//
//		System.out.println();
//		System.out.println("과목 전체 리스트");
//		list();
//		System.out.println();
//	}
		
	
	// 수강 신청 수정
	public void update() throws Exception {
		System.out.println("수강 수/삭 나옴");
		
	}

	// 수강 취소
	public void cancle() throws Exception {
		System.out.println("수강 취소 나옴");
		
	}

	
}
