package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import MenuView.StudentMainMenu;
import ViewChoice.MenuChoice;

public class StudentProgram {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

//		Connection con = DBUtill.getConnection();
		int choice = 0;
		boolean stopFlag = false;
//		if (con == null) {
//			System.out.println("DB 연결 오류");
//			return;

		while (!stopFlag) {
			try {
				StudentMainMenu.main();
				choice = noSel(5);
//				choice = Integer.parseInt(scan.nextLine());
				switch (choice) {

				case MenuChoice.학생_관리:
					new StuSelect().menuChoiceStu();
					break;

				case MenuChoice.과목_관리:
					new SubSelect().menuChoiceSub();
					break;

				case MenuChoice.학과_관리:
					new LesSelect().menuChoiceLes();
					break;

				case MenuChoice.수강_관리:
					CouSelect.menuChoiceReg();
					break;

				case MenuChoice.EXIT:
					System.out.println("프로그램 종료");
					stopFlag = true;
					break;

				}
			} catch (Exception e) {
				System.out.println("학과정보 예외발생");
			}
		}
	}// main end

	// 번호선택
	public static int noSel(int limit) { // 파라미터(parameter) 매개변수
		Scanner scan = new Scanner(System.in);

		int choice = 0;

		while (true) {
			System.out.printf("번호 선택 : ");
			String input = scan.nextLine();
			boolean isInputCheck = Pattern.matches("^[1-" + limit + "]$", input);
			if (isInputCheck) {
				choice = Integer.parseInt(input);
				break;
			} else {
				System.out.println("올바른 번호를 입력해주세요.");
			}
		}
		return choice; // 리턴밸류(return value) 반환값
	}

}// class end
