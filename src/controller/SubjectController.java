package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.SubjectDAO;
import service.ConnectionService;
import service.SubjectService;

public class SubjectController {
	public static Scanner scan = new Scanner(System.in);

	// 과목 목록
	public void list() throws Exception {
		SubjectDAO sd = new SubjectDAO();
		SubjectService ss = new SubjectService();
		ConnectionService connectionService = new ConnectionService();
		
		
		System.out.println();
		System.out.println("과목 전체 리스트");
		ArrayList<SubjectDAO> SubDAOList = ss.selectSubAll(connectionService.getConn());
		if (SubDAOList.size() == 0) {
			System.out.println("과목전체리스트 내용이 없습니다.");
			return;
		} else if (SubDAOList == null) {
			System.out.println("과목전체리스트 에러발생");
			return;
		}
		for (SubjectDAO data : SubDAOList) {
			System.out.println(data.toString());
		}
	}

	// 과목 등록
	public void register() throws Exception {
		Scanner scan = new Scanner(System.in);
		SubjectDAO sd = new SubjectDAO();
		SubjectService ss = new SubjectService();
		ConnectionService connectionService = new ConnectionService();
		
		String num; // 과목번호
		String name; // 과목명

		System.out.println("과목 정보 입력");
		System.out.print("과목 : ");
		num = scan.nextLine();
		System.out.print("과목명 : ");
		name = scan.nextLine();

		sd.setNum(num);
		sd.setName(name);

		
		ss.insert(connectionService.getConn(), sd);

		System.out.println();
		System.out.println("과목 전체 리스트");
		list();
		System.out.println();
	}

	// 과목 수정 관리
	public void update() throws Exception {
		Scanner scan = new Scanner(System.in);

		ConnectionService connectionService = new ConnectionService();

		SubjectDAO sd = new SubjectDAO();
		SubjectService ss = new SubjectService();
		
		int no= 0; // 일련번호
		String num=""; // 과목 번호
		String name=""; // 과목 이름

		System.out.println("과목 전체 리스트");
		list();
		System.out.println();

		System.out.println("수정할 일련번호 입력");
		System.out.print("일련번호 : ");
		no = Integer.parseInt(scan.nextLine());

		sd.setNo(no);
//		sd.setNum(num);
//		sd.setName(name);
		SubjectDAO dao = ss.selectSubOne(connectionService.getConn(), sd.getNo());
		
		System.out.println("수정할 과목 입력 (" + dao.getNum()+") :");
		num = scan.nextLine();
		System.out.println("수정할 이름 입력 (" + dao.getName()+") :");
		name = scan.nextLine();
		
		dao.setNum((num.equals("")) ? dao.getNum() : num);
		dao.setName((name.equals("")) ? dao.getName() : name);
		
		
		boolean count = ss.update(connectionService.getConn(), dao);

		if (count) {
			System.out.println("과목정보 수정완료");
		} else {
			System.out.println("과목정보 수정 오류발생 조치바람");
			return;
		}

		System.out.println();
		System.out.println("과목 전체 리스트");
		list();
		System.out.println();
	}

	// 과목 삭제 관리
	public void delete() throws Exception {
		Scanner scan = new Scanner(System.in);

		SubjectDAO sd = new SubjectDAO();
		SubjectService ss = new SubjectService();
		ConnectionService connectionService = new ConnectionService();
		
		int no; // 일련번호
		list();
		System.out.println();

		System.out.println("삭제할 일련번호 입력");
		System.out.print("일련번호 : ");
		no = Integer.parseInt(scan.nextLine());
		sd.setNo(no);
		boolean count = ss.delete(connectionService.getConn(),sd);
		if (count) {
			System.out.printf("%s 번호 삭제성공 \n", no);
		} else {
			System.out.printf("%s 번호 삭제 문제발생 조치바람\n", no);
		}
		System.out.println();
		System.out.println("과목 전체 리스트");
		list();
		System.out.println();
	}

	// 과목 검색 관리///////////////////////// 손봐야함
	public static void Search() {
		SubjectDAO sd = new SubjectDAO();
		SubjectService ss = new SubjectService();
		ConnectionService connectionService = new ConnectionService();
		System.out.println("검색할 과목명을 입력해주세요");
		System.out.print("ex) '정','정보' 검색 가능 : ");
		String name = scan.nextLine();

		
		ArrayList<SubjectDAO> SubDAOList = ss.selectByName(connectionService.getConn(), name);
		if (SubDAOList.size() <= 0 || SubDAOList == null) {
			System.out.println("과목정보 검색에 오류가 발생했습니다.");
			return;
		}
		for (SubjectDAO data : SubDAOList) {
			System.out.println(data.toString());
		}
	}
}
