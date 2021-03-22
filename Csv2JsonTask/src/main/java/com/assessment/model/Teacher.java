package com.assessment.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Teacher extends Personnel{
	
	private String empNo;
	
	private String classTeacher;
	
	private String previousSchool;
	
	private String post;
	
	private Date doj;
	
	private Integer salary;
	
	private String servicePeriod;			//calculated from doj. e.g., 20 years 3 months 15 days
	
	private List<String> subjectTeaches;	//Split the value of column T, by the delimiter - and stored the vaues in an ArrayList.
											//E.g if the value is Geography-History-Pol Science
											//The List <String>subjectTeacher will be as below
											//Geography
											//History
											//Pol Science

	public Teacher() {
		super();
		this.subjectTeaches = new ArrayList<String>();
	}
	
	public void setAge(Date dob) {
		LocalDate bday = new java.sql.Date(dob.getTime()).toLocalDate();
		LocalDate today = LocalDate.now();
		
		Period period = Period.between(bday, today);
		int years = period.getYears();
		int months = period.getMonths();
		this.age = years + ((years > 1)?" Yrs ":" Yr ") + months + ((months > 1)?" Months":" Month");
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getClassTeacher() {
		return classTeacher;
	}

	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}

	public String getPreviousSchool() {
		return previousSchool;
	}

	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getServicePeriod() {
		return servicePeriod;
	}
	
	public void setServicePeriod(Date doj) {
		LocalDate jday = new java.sql.Date(doj.getTime()).toLocalDate();
		LocalDate today = LocalDate.now();
		
		Period period = Period.between(jday, today);
		int years = period.getYears();
		int months = period.getMonths();
		int days = period.getDays();
		this.servicePeriod = years + ((years > 1)?" Yrs ":" Yr ") + months + ((months > 1)?" Months ":" Month ") + days + ((days > 1)?" Days":" Day");
	}

	public void setServicePeriod(String servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public List<String> getSubjectTeaches() {
		return subjectTeaches;
	}

	public void setSubjectTeaches(List<String> subjectTeaches) {
		this.subjectTeaches = subjectTeaches;
	}
	
	public void addSubjectTeaches(String subjectTeaches) {
		this.subjectTeaches.add(subjectTeaches);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((classTeacher == null) ? 0 : classTeacher.hashCode());
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + ((empNo == null) ? 0 : empNo.hashCode());
		result = prime * result + ((post == null) ? 0 : post.hashCode());
		result = prime * result + ((previousSchool == null) ? 0 : previousSchool.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((servicePeriod == null) ? 0 : servicePeriod.hashCode());
		result = prime * result + ((subjectTeaches == null) ? 0 : subjectTeaches.hashCode());
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
		Teacher other = (Teacher) obj;
		if (classTeacher == null) {
			if (other.classTeacher != null)
				return false;
		} else if (!classTeacher.equals(other.classTeacher))
			return false;
		if (doj == null) {
			if (other.doj != null)
				return false;
		} else if (!doj.equals(other.doj))
			return false;
		if (empNo == null) {
			if (other.empNo != null)
				return false;
		} else if (!empNo.equals(other.empNo))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (previousSchool == null) {
			if (other.previousSchool != null)
				return false;
		} else if (!previousSchool.equals(other.previousSchool))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (servicePeriod == null) {
			if (other.servicePeriod != null)
				return false;
		} else if (!servicePeriod.equals(other.servicePeriod))
			return false;
		if (subjectTeaches == null) {
			if (other.subjectTeaches != null)
				return false;
		} else if (!subjectTeaches.equals(other.subjectTeaches))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Teacher [");
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
		if (empNo != null) {
			builder.append("empNo=");
			builder.append(empNo);
			builder.append(", ");
		}
		if (classTeacher != null) {
			builder.append("classTeacher=");
			builder.append(classTeacher);
			builder.append(", ");
		}
		if (previousSchool != null) {
			builder.append("previousSchool=");
			builder.append(previousSchool);
			builder.append(", ");
		}
		if (post != null) {
			builder.append("post=");
			builder.append(post);
			builder.append(", ");
		}
		if (doj != null) {
			builder.append("doj=");
			builder.append(doj);
			builder.append(", ");
		}
		if (salary != null) {
			builder.append("salary=");
			builder.append(salary);
			builder.append(", ");
		}
		if (servicePeriod != null) {
			builder.append("servicePeriod=");
			builder.append(servicePeriod);
			builder.append(", ");
		}
		if (subjectTeaches != null) {
			builder.append("subjectTeaches=");
			builder.append(subjectTeaches);
		}
		builder.append("]");
		return builder.toString();
	}

	
	
	
	

}
