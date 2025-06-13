package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.LessonDAO;
import service.ConnectionService;
import service.LessonService;

public class LessonController {
	// 학과 목록
	public void list() throws Exception {
		LessonService lessonService = new LessonService();
		ConnectionService connectionService = new ConnectionService();

		System.out.println("학과 전체 리스트");
		ArrayList<LessonDAO> lessonDAOList = lessonService.selectLessonAll(connectionService.getConn());
		if (lessonDAOList.size() == 0) {
			System.out.println("학과전체리스트 내용이 없습니다.");
			return;
		} else if (lessonDAOList == null) {
			System.out.println("학과전체리스트 에러발생");
			return;
		} else if (lessonDAOList.size() >= 1) {
			System.out.println("|순번| 약어 | 학과명 ");
			for (LessonDAO data : lessonDAOList) {
				System.out.printf("%d | %s | %s\n", data.getNo(), data.getAbbre(), data.getName());
			}
		}
	}

	// 학과 등록
	public void register() throws Exception {
		Scanner scan = new Scanner(System.in);
		LessonService lessonService = new LessonService();
		ConnectionService connectionService = new ConnectionService();
		LessonDAO ldao = new LessonDAO();

		this.list();
		System.out.print("등록할 학과약어입력 (두자리): ");
		ldao.setAbbre(scan.nextLine());
		System.out.print("등록할 학과명 : ");
		ldao.setName(scan.nextLine());

		lessonService.insert(connectionService.getConn(), ldao);
		this.list();
	}

	// 학과 수정
	public void update() throws Exception {
		Scanner scan = new Scanner(System.in);
		LessonService lessonService = new LessonService();
		ConnectionService connectionService = new ConnectionService();
		LessonDAO ldao = new LessonDAO();

		this.list();
		System.out.print("수정할 학과번호입력 : ");
		ldao.setNo(Integer.parseInt(scan.nextLine()));

		ldao = lessonService.searchByNo(connectionService.getConn(), ldao);

		System.out.printf("수정할 학과약어 입력(%s): ", ldao.getAbbre());
		String chAbbre = scan.nextLine();
		ldao.setAbbre((chAbbre.equals("")) ? ldao.getAbbre() : chAbbre);

		System.out.printf("수정할 학과명(%s) : ", ldao.getName());
		String chName = scan.nextLine();
		ldao.setName((chName.equals("")) ? ldao.getName() : chName);

		lessonService.update(connectionService.getConn(), ldao);
		this.list();
	}

	// 학과 삭제
	public void delete() throws Exception {
		Scanner scan = new Scanner(System.in);
		LessonService lessonService = new LessonService();
		ConnectionService connectionService = new ConnectionService();
		LessonDAO ldao = new LessonDAO();

		this.list();
		System.out.print("삭제할 학과번호입력 : ");
		ldao.setNo(Integer.parseInt(scan.nextLine()));

		ldao = lessonService.searchByNo(connectionService.getConn(), ldao);
		
		lessonService.delete(connectionService.getConn(), ldao);
		this.list();
	}

	// 학과 검색
	public static void search() throws Exception {
		Scanner scan = new Scanner(System.in);
		LessonService lessonService = new LessonService();
		ConnectionService connectionService = new ConnectionService();
		LessonDAO ldao = new LessonDAO();
		
		System.out.print("검색할 학과 약어 또는 명 입력 : ");
		String name = scan.nextLine();
		
		System.out.println("검색된 학과 리스트");
		ArrayList<LessonDAO> lessonDAOList = lessonService.searchByName(connectionService.getConn(), name);
		if (lessonDAOList.size() == 0) {
			System.out.println("검색된 학과리스트 내용이 없습니다.");
			return;
		} else if (lessonDAOList == null) {
			System.out.println("학과검색 에러발생");
			return;
		} else if (lessonDAOList.size() >= 1) {
			System.out.println("|순번| 약어 | 학과명 ");
			for (LessonDAO data : lessonDAOList) {
				System.out.printf("| %d |  %s | %s\n", data.getNo(), data.getAbbre(), data.getName());
			}
		}
	}
}
