package com.assessment.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Student extends Personnel{
	
	private Integer rollNumber;
	
	private String className;
	
	private Integer totalMarks;
	
	private String grade;
	
	private Integer secPercentage;
	
	private String hsStream;

	public Student() {
		super();
	}

	public Integer getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getSecPercentage() {
		return secPercentage;
	}

	public void setSecPercentage(Integer secPercentage) {
		this.secPercentage = secPercentage;
	}

	public String getHsStream() {
		return hsStream;
	}

	public void setHsStream(String hsStream) {
		this.hsStream = hsStream;
	}
	
	public void setAge(Date dob) {
		LocalDate bday = new java.sql.Date(dob.getTime()).toLocalDate();
		LocalDate today = LocalDate.now();
		
		Period period = Period.between(bday, today);
		int years = period.getYears();
		int months = period.getMonths();
		this.age = years + ((years > 1)?" Yrs ":" Yr ") + months + ((months > 1)?" Months":" Month");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((hsStream == null) ? 0 : hsStream.hashCode());
		result = prime * result + ((rollNumber == null) ? 0 : rollNumber.hashCode());
		result = prime * result + ((secPercentage == null) ? 0 : secPercentage.hashCode());
		result = prime * result + ((totalMarks == null) ? 0 : totalMarks.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (hsStream == null) {
			if (other.hsStream != null)
				return false;
		} else if (!hsStream.equals(other.hsStream))
			return false;
		if (rollNumber == null) {
			if (other.rollNumber != null)
				return false;
		} else if (!rollNumber.equals(other.rollNumber))
			return false;
		if (secPercentage == null) {
			if (other.secPercentage != null)
				return false;
		} else if (!secPercentage.equals(other.secPercentage))
			return false;
		if (totalMarks == null) {
			if (other.totalMarks != null)
				return false;
		} else if (!totalMarks.equals(other.totalMarks))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (fullname != null) {
			builder.append("fullname=");
			builder.append(fullname);
			builder.append(", ");
		}
		if (gender != null) {
			builder.append("gender=");
			builder.append(gender);
			builder.append(", ");
		}
		if (dob != null) {
			builder.append("dob=");
			builder.append(dob);
			builder.append(", ");
		}
		if (age != null) {
			builder.append("age=");
			builder.append(age);
			builder.append(", ");
		}
		if (aadhar != null) {
			builder.append("aadhar=");
			builder.append(aadhar);
			builder.append(", ");
		}
		if (city != null) {
			builder.append("city=");
			builder.append(city);
			builder.append(", ");
		}
		if (contact != null) {
			builder.append("contact=");
			builder.append(contact);
			builder.append(", ");
		}
		if (rollNumber != null) {
			builder.append("rollNumber=");
			builder.append(rollNumber);
			builder.append(", ");
		}
		if (className != null) {
			builder.append("className=");
			builder.append(className);
			builder.append(", ");
		}
		if (totalMarks != null) {
			builder.append("totalMarks=");
			builder.append(totalMarks);
			builder.append(", ");
		}
		if (grade != null) {
			builder.append("grade=");
			builder.append(grade);
			builder.append(", ");
		}
		if (secPercentage != null) {
			builder.append("secPercentage=");
			builder.append(secPercentage);
			builder.append(", ");
		}
		if (hsStream != null) {
			builder.append("hsStream=");
			builder.append(hsStream);
		}
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
