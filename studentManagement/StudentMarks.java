package com.studentManagement;

import java.util.Date;



public class StudentMarks {

	private int rollnum;
	private String name;
	private int tamil;
	private int english;
	private int maths;
	private int science;
	private int socialScience;
	private int total;
	private String grade;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollnum() {
		return rollnum;
	}

	public void setRollnum(int rollnum) {
		this.rollnum = rollnum;
	}

	public int getTamil() {
		return tamil;
	}

	public void setTamil(int tamil) {
		this.tamil = tamil;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocialScience() {
		return socialScience;
	}

	public void setSocialScience(int socialScience) {
		this.socialScience = socialScience;
	}

	public int getTotal() {
		return tamil + english + maths + science + socialScience;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getGrade() {

		int total = getTotal();
		String graderesult = "";
		if (total >= 480 && total <= 500) {

			graderesult = "A+";
		} else if (total >= 450 && total < 480) {

			graderesult = "A";
		} else if (total >= 430 && total < 450) {

			graderesult = "B+";
		} else if (total >= 400 && total < 430) {

			graderesult = "B";
		}
		else if (total >= 350 && total < 400) {

			graderesult = "C+";
		}else if (total >= 300 && total < 350) {

			graderesult = "C";
		}else if (total >= 175 && total < 300) {

			graderesult = "D";
		}else if (total >= 0 && total < 175){
			graderesult = "F";
		}
		return graderesult;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	

}
