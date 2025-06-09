package dao;

public class LessonDAO {
	private int no;
	private String abbre;
	private String name;
	
	public LessonDAO() {}
	public LessonDAO(int n, String ab, String na) { no = n; abbre = ab; name = na;}
	
	public int getNo() { return no; }
	public void setNo(int n) { no = n; }
	public String getAbbre() { return abbre; }
	public void setAbbre(String a) { abbre = a; }
	public String getName() { return name; }
	public void setName(String na) { name = na; }
	
	@Override
	public String toString() {
		return "Lesson : no = " + no + ", Abbre = " + abbre + ", Name = " + name;
	}
}
