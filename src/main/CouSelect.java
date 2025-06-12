package main;

import java.util.Scanner;
import java.util.regex.Pattern;

import MenuView.StudentMainMenu;
import ViewChoice.CouChoice;
import ViewChoice.StuChoice;
import controller.CouseController;

public class CouSelect {
	public static Scanner scan = new Scanner(System.in);
	public static void menuChoiceReg() {
		
        int choice = 0;
        boolean stopFlag = false; 
        
        while(!stopFlag) {
        	try {
        		StudentMainMenu.menuShowMeReg();
        		
        		CouseController cc = new CouseController();
        		
        		choice = noSel(5);
        		
                switch(choice) {
                
                case CouChoice.수강_신청_목록: 
                	cc.list();
                	break;
                case CouChoice.수강_신청:
                	cc.register();
                	break;
                case CouChoice.수강_신청_수정:
                	cc.update();
                	break;
                case CouChoice.수강_취소: 
                	cc.cancle();
                	break;
                case CouChoice.돌아가기 :
                stopFlag = true;
                break;
                }
        	}catch (Exception e) {
				System.out.println("수강관리 예외발생");
			}
        	
        }
	}
	public static int noSel(int limit) { // 파라미터(parameter) 매개변수
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
