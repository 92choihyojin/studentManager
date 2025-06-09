package dao;

public class StudentDAO {
	private int no;
	private String num;
	private String name;
	private String id;
	private String passwd;
	private int lessonNo;
	private String lessonName;
	private String birthday;
	private String phone;
	private String address;
	private String email;
	private String registerDate;
	
	public StudentDAO() {
		super();
	}
	public StudentDAO(int no, String num, String name, String id, String passwd, int lessonNo, String birthday,
			String phone, String address, String email, String registerDate) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.lessonNo = lessonNo;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.registerDate = registerDate;
	}

	public StudentDAO(int no, String num, String name, String id, String passwd, int lessonNo, String lessonName, String birthday,
			String phone, String address, String email, String registerDate) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.lessonNo = lessonNo;
		this.lessonName = lessonName;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.registerDate = registerDate;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getLessonNo() {
		return lessonNo;
	}

	public void setLessonNo(int lessonNo) {
		this.lessonNo = lessonNo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getLessonName() {
		return lessonName;
	}

	@Override
	public String toString() {
		return "학생: [ "+ no +" / 학번: "+ num +" / 이름: "+ name +" / ID: "+ id +" / 비밀번호: "+ passwd +"\n     "
						+ "학과번호: "+ lessonNo +" / 생년월일: "+ birthday +" / 연락처: "+ phone +" / 주소: "+ address +"\n     "
						+ "이메일: "+ email +"/ 등록일자: "+ registerDate +"]";
	}
	
}
	
