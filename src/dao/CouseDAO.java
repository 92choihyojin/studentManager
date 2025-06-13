package dao;

public class CouseDAO {
	private int no;
	private String num;
	private String id;
	private String pwd;
	
	public CouseDAO() {
		super();
	}

	public CouseDAO(int no, String num, String id, String pwd) {
		super();
		this.no = no;
		this.num = num;
		this.id = id;
		this.pwd = pwd;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "CouseDAO [no=" + no + ", num=" + num + ", id=" + id + ", pwd=" + pwd + "]";
	}
	

	
}
	
