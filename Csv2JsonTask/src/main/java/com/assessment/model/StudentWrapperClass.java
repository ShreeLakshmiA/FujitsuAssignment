package com.assessment.model;

import java.util.List;

public class StudentWrapperClass {
	
	private Integer studentRecordCount;
	
	private List<Student> data;

	public StudentWrapperClass() {
		super();
	}

	public StudentWrapperClass(Integer studentRecordCount, List<Student> data) {
		super();
		this.studentRecordCount = studentRecordCount;
		this.data = data;
	}

	public Integer getStudentRecordCount() {
		return studentRecordCount;
	}

	public void setStudentRecordCount(Integer studentRecordCount) {
		this.studentRecordCount = studentRecordCount;
	}

	public List<Student> getData() {
		return data;
	}

	public void setData(List<Student> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((studentRecordCount == null) ? 0 : studentRecordCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentWrapperClass other = (StudentWrapperClass) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (studentRecordCount == null) {
			if (other.studentRecordCount != null)
				return false;
		} else if (!studentRecordCount.equals(other.studentRecordCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentWrapperClass [");
		if (studentRecordCount != null) {
			builder.append("studentRecordCount=");
			builder.append(studentRecordCount);
			builder.append(", ");
		}
		if (data != null) {
			builder.append("data=");
			builder.append(data);
		}
		builder.append("]");
		return builder.toString();
	}

}
