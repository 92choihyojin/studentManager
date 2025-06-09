package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import MenuView.StudentMainMenu;
import ViewChoice.LesChoice;
import ViewChoice.StuChoice;
import controller.LessonController;
import controller.StudentController;

public class LesSelect {
	public void menuChoiceLes() {
		Scanner scan = new Scanner(System.in);
        int choice = 0;
        boolean stopFlag = false; 
        while(!stopFlag) {
            try {
            	StudentMainMenu.menuShowMeLes();
            	choice = noSel(6);
            	switch(choice) {
                case LesChoice.학과_정보_목록:
                	new LessonController().list();
                	break;
                case LesChoice.학과_정보_등록: 
                	new LessonController().register();
                	break;
                case LesChoice.학과_정보_수정: 
                	new LessonController().update();
                	break;
                case LesChoice.학과_정보_삭제: 
                	new LessonController().delete();
                	break;
                case LesChoice.학과_정보_검색: 
                	new LessonController().search();
                	break;
                case LesChoice.돌아가기 :
                stopFlag = true;
                break;
                }
            }catch (Exception e) {
				System.out.println("학과관리 예외발생");
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
