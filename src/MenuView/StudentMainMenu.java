package MenuView;

public class StudentMainMenu {
	public static void main() { 
		System.out.println(); 
        System.out.println("' 학생 관리 프로그램 ' "); 
        System.out.println("해당 번호를 입력하세요."); 
        System.out.println("1. 학생 관리 [ 목록 / 등록 / 수정 / 삭제 / 검색 ]"); 
        System.out.println("2. 과목 관리 [ 목록 / 등록 / 수정 / 삭제 / 검색 ]"); 
        System.out.println("3. 학과 관리 [ 목록 / 등록 / 수정 / 삭제 / 검색 ]"); 
        System.out.println("4. 수강 관리 [ 목록 / 등록 / 취소 ]"); 
        System.out.println("5. 프로그램 종료"); 
    }
	
	//학생선택 창
	public static void menuShowMeStu() {
		System.out.println(); 
        System.out.println("' 학생 ' 을(를) 관리합니다."); 
        System.out.println("해당 번호를 입력하세요."); 
        System.out.println("1. 학생 정보 목록"); 
        System.out.println("2. 학생 정보 등록"); 
        System.out.println("3. 학생 정보 수정"); 
        System.out.println("4. 학생 정보 삭제"); 
        System.out.println("5. 학생 정보 검색"); 
        System.out.println("6. 돌아가기"); 
    }
	
	//과목선택 창
	public static void menuShowMeSub() { 
		System.out.println(); 
        System.out.println("' 과목 ' 을(를) 관리합니다."); 
        System.out.println("해당 번호를 입력하세요."); 
        System.out.println("1. 과목 정보 목록"); 
        System.out.println("2. 과목 정보 등록"); 
        System.out.println("3. 과목 정보 수정"); 
        System.out.println("4. 과목 정보 삭제"); 
        System.out.println("5. 과목 정보 검색"); 
        System.out.println("6. 돌아가기"); 
	}
	
	//학과선택 창
	public static void menuShowMeLes() { 
		System.out.println(); 
        System.out.println("' 학과 ' 을(를) 관리합니다."); 
        System.out.println("해당 번호를 입력하세요."); 
        System.out.println("1. 학과 정보 목록"); 
        System.out.println("2. 학과 정보 등록"); 
        System.out.println("3. 학과 정보 수정"); 
        System.out.println("4. 학과 정보 삭제"); 
        System.out.println("5. 학과 정보 검색"); 
        System.out.println("6. 돌아가기"); 
	}
	
	//수강선택 창
	public static void menuShowMeReg() { 
		System.out.println(); 
        System.out.println("' 수강 ' 을(를) 관리합니다."); 
        System.out.println("해당 번호를 입력하세요."); 
        System.out.println("1. 수강 신청 목록"); 
        System.out.println("2. 수강 등록"); 
        System.out.println("3. 수강 취소"); 
        System.out.println("4. 돌아가기"); 
	}
}
