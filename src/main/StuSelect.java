package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import MenuView.StudentMainMenu;
import ViewChoice.StuChoice;
import controller.StudentController;

public class StuSelect {

	// 학생 관리 메뉴
	public void menuChoiceStu() {
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		boolean stopFlag = false;

		// Connection conn = new StudentService().getConn();

		while (!stopFlag) {
			try {
				StudentMainMenu.menuShowMeStu();
				
				StudentController st = new StudentController();
				choice = noSel(6);
				switch (choice) {

				case StuChoice.학생_정보_목록:
					st.list();
					break;

				case StuChoice.학생_정보_등록:
					st.register();
					break;

				case StuChoice.학생_정보_수정:
					st.update();
					stopFlag = true;
					break;

				case StuChoice.학생_정보_삭제:
					st.delete();
					break;
					
				case StuChoice.학생_정보_검색:
					st.Search();
					break;
					
				case StuChoice.돌아가기:
					stopFlag = true;
					break;
				}
			} catch (Exception e) {
				System.out.println("발생");
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