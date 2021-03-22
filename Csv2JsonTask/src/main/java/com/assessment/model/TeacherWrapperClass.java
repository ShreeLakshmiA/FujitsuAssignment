package com.assessment.model;

import java.util.List;

public class TeacherWrapperClass {
	
	private Integer teacherRecordCount;
	
	private List<Teacher> data;

	public TeacherWrapperClass() {
		super();
	}

	public TeacherWrapperClass(Integer teacherRecordCount, List<Teacher> data) {
		super();
		this.teacherRecordCount = teacherRecordCount;
		this.data = data;
	}

	public Integer getTeacherRecordCount() {
		return teacherRecordCount;
	}

	public void setTeacherRecordCount(Integer teacherRecordCount) {
		this.teacherRecordCount = teacherRecordCount;
	}

	public List<Teacher> getData() {
		return data;
	}

	public void setData(List<Teacher> data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((teacherRecordCount == null) ? 0 : teacherRecordCount.hashCode());
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
		TeacherWrapperClass other = (TeacherWrapperClass) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (teacherRecordCount == null) {
			if (other.teacherRecordCount != null)
				return false;
		} else if (!teacherRecordCount.equals(other.teacherRecordCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TeacherWrapperClass [");
		if (teacherRecordCount != null) {
			builder.append("teacherRecordCount=");
			builder.append(teacherRecordCount);
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
