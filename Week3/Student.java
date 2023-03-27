package Week3;

public class Student {
	private String studentName;
	private String studentNo;
	private String schoolYear;
	private String term;
	
	public Student(String studentName, String studentNo, String schoolYear, String Term) {
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.schoolYear = schoolYear;
		this.term = term;
	}

	//Setter
	public void setStudentName(String studentName){
		this.studentName = studentName;
	}
	
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	//Getter
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getStudentNo() {
		return studentNo;
	}
	
	public String getSchoolYear() {
		return schoolYear;
	}
	
	public String getTerm() {
		return term;
	}
}




