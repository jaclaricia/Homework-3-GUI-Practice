package Week3;

public class Computation{
	private int milestone1;
	private int milestone2;
	private int milestone3;
	private int finalGrade;
	private double gwa;
	private String status;

	//Constructor
	public Computation(int milestone1, int milestone2, int milestone3) {
		this.milestone1 = milestone1;
		this.milestone2 = milestone2;
		this.milestone3 = milestone3;
	}
	
	//Method for computing final grade
	public int Compute(int milestone1, int milestone2, int milestone3) {
		return this.finalGrade = (milestone1 + milestone2 + milestone3);
	}
	
	//Method for determining the GWA using the computed final grade
	public double GWA(int finalGrade) {
		if(finalGrade > 96) {
			return this.gwa = 1.00;
		}else if(finalGrade <= 96 && finalGrade >= 91.51) {
			return this.gwa = 1.25;
		}else if(finalGrade <= 91.50 && finalGrade >= 87.51) {
			return this.gwa = 1.50;
		}else if(finalGrade <= 87 && finalGrade >= 82.51) {
			return this.gwa = 1.75;
		}else if(finalGrade <= 82.50 && finalGrade >= 78.01) {
			return this.gwa = 2.00;
		}else if(finalGrade <= 78 && finalGrade >= 73.51) {
			return this.gwa = 2.25;
		}else if(finalGrade <= 73.50 && finalGrade >= 69.01) {
			return this.gwa = 2.50;
		}else if(finalGrade <= 69 && finalGrade >= 64.51) {
			return this.gwa = 2.75;
		}else if(finalGrade <= 64.50 && finalGrade >= 60) {
			return this.gwa = 3.00;
		}else return this.gwa = 5.00;
	}
	
	//Method for determining the student status using the GWA
	public String Status(double gwa) {
		if(gwa != 5.00) {
			return status = "PASSED";
		}else return status = "FAILED";
	}		
}
