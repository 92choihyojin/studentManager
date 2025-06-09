package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

import dao.LessonDAO;
import dao.StudentDAO;
import service.ConnectionService;
import service.LessonService;
import service.StudentService;

public class StudentController {

	// 학생 목록
	public void list() throws Exception {
		StudentService ss = new StudentService();

		System.out.println("학생 전체 리스트");
		ArrayList<StudentDAO> stuDaoList = ss.selectStuAll(new ConnectionService().getConn());
		if (stuDaoList.size() == 0) {
			System.out.println("학생전체리스트 내용이 없습니다.");
			return;
		} else if (stuDaoList == null) {
			System.out.println("학생전체리스트 에러발생");
			return;
		}
		System.out.println("|    학번   |   이름   |   아이디   |   학과   |    연락처    |        이메일          |        등록일자       |");
		for (StudentDAO data : stuDaoList) {
			System.out.printf("|%9s |  %-4s | %-10s| %-7s| %11s | %-20s| %s |\n", data.getNum(), data.getName(),
					data.getId(), data.getLessonName(), data.getPhone(), data.getEmail(), data.getRegisterDate());
		}
	}

	// 학생 등록
	public void register() throws Exception {
		Scanner scan = new Scanner(System.in);
		StudentDAO sd = new StudentDAO();
		StudentService studentService = new StudentService();
		LessonService lessonService = new LessonService();
		boolean idCheck = false;

		String num; // 학생번호
		String name; // 학생이름
		String id; // 학생아이디
		String passwd; // 학생비밀번호
		int lessonNo; // 외래키 subject_num 학과번호
		String birthday; // 학생생일
		String phone; // 학생전화번호
		String address; // 학생주소
		String email; // 학생이메일

		ArrayList<LessonDAO> lessonList = lessonService.selectLessonAll(new ConnectionService().getConn()); // 학과번호리스트 출력
		for (int i = 0; i < lessonList.size(); i++) {
			System.out.println(lessonList.get(i));
		}
		System.out.print("학과번호선택 : ");
		lessonNo = Integer.parseInt(scan.nextLine());

		// 학생 번호는8자리로 생성한다. (연도2자리+학과2자리+일련번호 - 예로06 01 0001)
		SimpleDateFormat sdf = new SimpleDateFormat("yy");
		String year = sdf.format(new java.util.Date());

		String studentCount = studentService.selectByLessonNoCount(new ConnectionService().getConn(), lessonNo);
		num = year + ((lessonNo <= 9) ? "0" + lessonNo : lessonNo) + studentCount;

		System.out.printf("학생번호 : %s \n", num);

		System.out.print("학생이름 : ");
		name = scan.nextLine();

		do {
			System.out.print("아이디(5자 이상 12자 이내) : ");
			id = scan.nextLine();
			idCheck = studentService.selectByIdCheck(new ConnectionService().getConn(), id);
			if (idCheck == false) {
				System.out.println("중복된 아이디입니다. 다시 입력하세요");
			}
		} while (idCheck == false);

		System.out.print("비밀번호(12자 이내) : ");
		passwd = scan.nextLine();
		System.out.print("생년월일(8자리 ex:25/01/01) : ");
		birthday = scan.nextLine();
		System.out.print("전화번호 : ");
		phone = scan.nextLine();
		System.out.print("도로명 주소 : ");
		address = scan.nextLine();
		System.out.print("이메일 : ");
		email = scan.nextLine();

		sd.setNum(num); // 학생번호
		sd.setName(name); // 학생이름
		sd.setId(id); // 학생아이디
		sd.setPasswd(passwd); // 학생비밀번호
		sd.setLessonNo(lessonNo); // 외래키 학과번호
		sd.setBirthday(birthday); // 학생생일
		sd.setPhone(phone); // 학생전화번호
		sd.setAddress(address); // 학생주소
		sd.setEmail(email); // 학생이메일
		
		if (studentService.insert(new ConnectionService().getConn(), sd)) {
			System.out.println("저장완료");
		} else {
			System.out.println("저장실패");
		}
	}

	// 학생 수정 관리
	public void update() throws Exception {
		Scanner scan = new Scanner(System.in);
		StudentService studentService = new StudentService();
		StudentDAO sd = new StudentDAO();

		String num; // 학생 번호
		String name; // 학생 이름
		String id; // 학생 아이디
		String phone; // 학생 핸드폰
		String email; // 학생 이메일

		list();
		System.out.println();

		System.out.println("수정할 학생번호 입력");
		System.out.print("학생번호 : ");
		num = scan.nextLine();

		StudentDAO dao = new StudentService().selectStuOne(new ConnectionService().getConn(), num);

		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.printf("수정할 학생이름 (%s) : ", dao.getName());
		name = scan.nextLine();
		System.out.printf("수정할 학생아이디 (%s) : ", dao.getId());
		id = scan.nextLine();
		System.out.printf("수정할 학생핸드폰 (%s) : ", dao.getPhone());
		phone = scan.nextLine();
		System.out.printf("수정할 학생이메일 (%s) : ", dao.getEmail());
		email = scan.nextLine();

//			svo.setNum(num);
//			svo.setName(name);
//			svo.setPhone(name);
//			int count = sd.update(svo);
		// (num.equals(""))? dao.getNum():num
		dao.setNum((num.equals("")) ? dao.getNum() : num);
		dao.setName((name.equals("")) ? dao.getName() : name);
		dao.setId((id.equals("")) ? dao.getId() : id);
		dao.setPhone((phone.equals("")) ? dao.getPhone() : phone);
		dao.setEmail((email.equals("")) ? dao.getEmail() : email);

		// boolean stuUpdate = studentService.update(studentService.getConn(), dao);

		if (studentService.update(new ConnectionService().getConn(), dao)) {
			System.out.println("학생정보 수정완료");
		} else {
			System.out.println("학생정보 수정 오류발생 조치바람");
			return;
		}

		System.out.println();
		list();
		System.out.println();
	}

	// 학생 삭제 관리
	public void delete() throws Exception {
		Scanner scan = new Scanner(System.in);
		StudentService studentService = new StudentService();

		String num; // 학생번호
		list();
		System.out.println();

		System.out.println("삭제할 학생번호 입력");
		System.out.print("학생번호 : ");
		num = scan.nextLine();
		StudentDAO dao = new StudentService().selectStuOne(new ConnectionService().getConn(), num);

		// boolean dResult = studentService.delete(studentService.getConn(), dao);

		if (studentService.delete(new ConnectionService().getConn(), dao)) {
			System.out.println("학생정보 삭제완료");
		} else {
			System.out.println("학생정보 삭제 오류발생 조치바람");
			return;
		}
		System.out.println();
		list();
		System.out.println();
	}

	// 학생 검색 관리
	public static void Search() {
		Scanner scan = new Scanner(System.in);
		StudentService studentService = new StudentService();
		System.out.println("검색할 학생 '이름'을 입력해주세요 : ");
		String name = scan.nextLine(); // 학생이름
		
		ArrayList<StudentDAO> stuDaoList = studentService.searchByName(new ConnectionService().getConn(), name);
		if (stuDaoList.size() == 0) {
			System.out.println("학생전체리스트 내용이 없습니다.");
			return;
		} else if (stuDaoList == null) {
			System.out.println("학생전체리스트 에러발생");
			return;
		}
		System.out.println("|    학번   |   이름   |   아이디   |   학과   |    연락처    |        이메일        |        등록일자        |");
		for (StudentDAO data : stuDaoList) {
			System.out.printf("|%9s |  %-4s | %-10s| %-7s| %11s | %-20s| %s |\n", data.getNum(), data.getName(),
					data.getId(), data.getLessonName(), data.getPhone(), data.getEmail(), data.getRegisterDate());
		}
	}

}
