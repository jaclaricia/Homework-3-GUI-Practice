package Week3;

public class Student {
	private String studentName;
	private int studentNo;
	private int schoolYear;
	private int term;
	
	//Will be use to initialize Student class without constructor
	public Student() {
		
	}
	
	public Student(String studentName, int studentNo, int schoolYear, int term) {
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.schoolYear = schoolYear;
		this.term = term;
	}

	//Setter
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}
	
	public void setSchoolYear(int schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	public void setTerm(int term) {
		this.term = term;
	}
	
	//Getter
	
	public String getStudentName() {
		return studentName;
	}
	
	public int getStudentNo() {
		return studentNo;
	}
	
	public int getSchoolYear() {
		return schoolYear;
	}
	
	public int getTerm() {
		return term;
	}
}
