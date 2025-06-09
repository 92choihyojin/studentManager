package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import MenuView.StudentMainMenu;
import ViewChoice.StuChoice;
import ViewChoice.SubChoice;
import controller.StudentController;
import controller.SubjectController;

public class SubSelect {
	public void menuChoiceSub() {
		Scanner scan = new Scanner(System.in);
		// 과목 관리 메뉴
		int choice = 0;
		boolean stopFlag = false;

		while (!stopFlag) {
			try {
				StudentMainMenu.menuShowMeSub();
				SubjectController sb = new SubjectController();
				choice = noSel(6);
				switch (choice) {
				case SubChoice.과목_정보_목록:
					sb.list();
					break;
				case SubChoice.과목_정보_등록:
					sb.register();
					break;
				case SubChoice.과목_정보_수정:
					sb.update();
					break;
				case SubChoice.과목_정보_삭제:
					sb.delete();
					break;
				case SubChoice.과목_정보_검색:
					sb.Search();
					break;
				case SubChoice.돌아가기:
					stopFlag = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("과목관리 예외발생");
			}
		}
	}
	
	public int noSel(int limit) { // 파라미터(parameter) 매개변수
		Scanner scan = new Scanner(System.in);

		int choice = 0;
		
		while(true) {
			System.out.printf("번호 선택 : ");
			String input = scan.nextLine();
			boolean isInputCheck = Pattern.matches("^[1-"+limit+"]$", input);
			if (isInputCheck) {
				choice = Integer.parseInt(input);
				break;
			} else {
				System.out.println("올바른 번호를 입력해주세요.");
			}
		}
		return choice; // 리턴밸류(return value) 반환값
	}
}
