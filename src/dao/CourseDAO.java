package dao;

public class CourseDAO {
	private int no;
	private int sub_no;
	private String subject_name;
	private String stu_num;
	private String stu_name;
	private String lesson_name;
	
	public CourseDAO() {
		super();
	}
	
	public CourseDAO(String stu_num, int sub_no ) {
		this.stu_num = stu_num;
		this.sub_no = sub_no;
	}
	
	public CourseDAO(int no, String subject_name, String stu_num, String stu_name, String lesson_name) {
		super();
		this.no = no;
		this.subject_name = subject_name;
		this.stu_num = stu_num;
		this.stu_name = stu_name;
		this.lesson_name = lesson_name;
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}


	public String getSubject_name() {
		return subject_name;
	}

	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}


	public String getStu_num() {
		return stu_num;
	}

	public void setStu_num(String stu_num) {
		this.stu_num = stu_num;
	}

	public String getStu_name() {
		return stu_name;
	}
	
	public int getSub_no() {
		return sub_no;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getLesson_name() {
		return lesson_name;
	}

	public void setLesson_name(String lesson_name) {
		this.lesson_name = lesson_name;
	}

	
	

	
}
	
