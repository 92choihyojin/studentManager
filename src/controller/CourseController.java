package controller;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CourseDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import service.ConnectionService;
import service.CouseService;
import service.StudentService;
import service.SubjectService;

public class CourseController {
	// 수강 목록
	public void list() throws Exception {
		System.out.println("수강 목록 나옴");
		CourseDAO cd = new CourseDAO();
		CouseService cs = new CouseService();
		ConnectionService connectionService = new ConnectionService();
		
		System.out.println("수강 전체 리스트");
		ArrayList<CourseDAO> CourseDAOList =  cs.selectCourseAll(connectionService.getConn());
		if (CourseDAOList.size() == 0) {
			System.out.println("수강전체리스트 내용이 없습니다.");
			return;
		} else if (CourseDAOList == null) {
			System.out.println("수강전체리스트 에러발생");
			return;
		} else if (CourseDAOList.size() >= 1) {
			System.out.println("|순번|         수강명      |     학번   |      이름    |    학과   |");
			for (CourseDAO data : CourseDAOList) {
				System.out.printf("%3d | %15s | %9s | %9s | %5s \n", data.getNo(), data.getSubject_name(),
						data.getStu_num(),data.getStu_name(), data.getLesson_name());
			}
		}
		//private String lesson_name;
	}
	// 수강 등록
	public void register() throws Exception {
		Scanner scan = new Scanner(System.in);
		CouseService courseService = new CouseService();
		ConnectionService connectionService = new ConnectionService();
		CourseDAO ldao = new CourseDAO();
		
		System.out.println("수강 등록 : ");
		ArrayList<StudentDAO> stuDaoList = new StudentService().selectStuAll(connectionService.getConn());
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
		
		System.out.println("학번 입력 : ");
		String stuNum = scan.nextLine();
		ArrayList<SubjectDAO> SubDAOList = new SubjectService().selectSubAll(connectionService.getConn());
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
		System.out.println("수강할 수업번호 : ");
		int subNo = Integer.parseInt(scan.nextLine());
		;
		courseService.insert(connectionService.getConn(), new CourseDAO(stuNum, subNo));
		
		
	}
		
	
	// 수강 신청 수정
	public void update() throws Exception {
		Scanner scan = new Scanner(System.in);
		CouseService courseService = new CouseService();
		ConnectionService connectionService = new ConnectionService();
		CourseDAO cdao = new CourseDAO();
		
		list();
		
		System.out.println("수정할 수업 일련번호 입력 : ");
		int CourseNo = Integer.parseInt(scan.nextLine());
		
		cdao = courseService.selectCourseOne(connectionService.getConn(), CourseNo);
		
		if(courseService.delete(connectionService.getConn(), cdao)) {
			System.out.println("해당 수업 신청이 취소 되었습니다.");
		}
	}

	// 수강 취소
//	public void cancle() throws Exception {
//		System.out.println("수강 취소 나옴");
//		
//	}

	
}
