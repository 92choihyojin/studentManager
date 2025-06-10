package dao;

public class SubjectDAO {
	
	private int no; //일련번호
	private String num; //과목번호
	private String name; //과목명
	
	public SubjectDAO() {
		super();
	}
	public SubjectDAO(int no, String num, String name) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "과목 [일련번호: " + no + "/ 과목번호: " + num + "/ 과목명: " + name + "]";
	}

	
}
