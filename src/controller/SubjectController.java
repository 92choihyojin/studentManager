package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.SubjectDAO;
import main.SubjectVO;
import service.SubjectService;

public class SubjectController {
	public static Scanner scan = new Scanner(System.in);
	//과목 목록
	public void list() throws Exception {
		SubjectDAO sd = new SubjectDAO();
		System.out.println("과목 전체 리스트");
		ArrayList<SubjectDVO> SubjectList = sd.selectAll();
		if (SubjectList.size() == 0) {
			System.out.println("과목전체리스트 내용이 없습니다.");
			return;
		} else if (SubjectList == null) {
			System.out.println("과목전체리스트 에러발생");
			return;
		}
		for (SubjectVO data : SubjectList) {
			System.out.println(data.toString());
		}
	}
	
	// 과목 입력
		public void register() throws Exception {
			Scanner scan = new Scanner(System.in);
			SubjectDAO sd = new SubjectDAO();
			SubjectVO svo = new SubjectVO();

			String num; // 과목번호
			String name; // 과목명

			System.out.println("과목 정보 입력");
			System.out.print("과목 번호 : ");
			num = scan.nextLine();
			System.out.print("과목명  : ");
			name = scan.nextLine();
			
			svo.setNum(num);
			svo.setName(name);

			sd.insert(svo);
			
			System.out.println();
			System.out.println("과목 전체 리스트");
			list();
			System.out.println();
		}

		// 과목 수정 관리
		public void update() throws Exception {
			Scanner scan = new Scanner(System.in);
			
			SubjectDAO dao = new SubjectService().selectStuOne(conn, 12);
			System.out.println(dao);
			
			SubjectDAO sd = new SubjectDAO();
			SubjectVO svo = new SubjectVO();

			int no; // 일련번호
			String num; // 과목 번호
			String name; // 과목 이름

			System.out.println("과목 전체 리스트");
			list();
			System.out.println();

			System.out.println("수정할 과목번호 입력");
			System.out.print("과목번호 : ");
			num = scan.nextLine();


			svo.setNo(no);
			svo.setNum(num);
			svo.setName(name);
			int count = sd.update(svo);

			if (count == 0) {
				System.out.println("과목정보 수정 오류발생 조치바람");
				return;
			} else {
				System.out.println("과목정보 수정완료");
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
			SubjectVO svo = new SubjectVO();

			String num; // 일련번호
			list();
			System.out.println();

			System.out.println("삭제할 과목번호 입력");
			System.out.print("과목번호 : ");
			num = scan.nextLine();
			svo.setNum(num);
			int count = sd.deleteByNum(svo);
			if (count == 0) {
				System.out.printf("%s 번호 삭제 문제발생 조치바람\n", num);
			} else {
				System.out.printf("%s 번호 삭제성공 \n", num);
			}
			System.out.println();
			System.out.println("과목 전체 리스트");
			list();
			System.out.println();
		}
		
		// 과목 검색 관리
		public static void Search() {
			SubjectDAO sd = new SubjectDAO();
			SubjectVO booksVO = null;
			System.out.println("검색할 과목 'name'을 입력해주세요 : ");
			String name = scan.nextLine();
			booksVO = new BooksVO();
			booksVO.setTitle(name);
			
			ArrayList<BooksVO> booksList = booksDAO.selectByTitle(booksVO);
			if(booksList.size() <= 0 || booksList == null) {
				System.out.println("책정보 검색에 오류가 발생했습니다.");
				return;
			}
			for ( BooksVO data : booksList ) {
				System.out.println(data.toString());
			}
		}
}
