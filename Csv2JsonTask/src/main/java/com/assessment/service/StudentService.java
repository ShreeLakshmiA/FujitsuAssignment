package com.assessment.service;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.stereotype.Service;

import com.assessment.model.Student;

@Service
public class StudentService {
	
	public Student setStudentData(final String[] header, Map<String, Object> personnelMap) {
		Student student = new Student();
		
		for (String head : header) {
			settersForStudent(student, head, personnelMap);
		}
		
		if (student.getDob() != null) {
			student.setAge(student.getDob());
		}
		
		if (student.getTotalMarks() > 0) {
			student.setGrade(calculateGrade(student.getTotalMarks()));
		}
		
		return student;
	}
	
	/* Set Data in personnelMap to Student pojo */
	private void settersForStudent(Student student, String header, Map<String, Object> personnelMap) {
		switch (header) {
			case "id":
				student.setId((Integer)personnelMap.get("id"));
				break;
			case "firstname":
				if ((student.getFullname() == null) || (student.getFullname().isEmpty())) {
					student.setFullname(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("firstname"))));										//validation for fullname
				} else {
					student.setFullname(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("firstname")) + " " + student.getFullname()));		//validation for fullname
				}
				break;
				
			case "lastname":
				if ((student.getFullname() == null) || (student.getFullname().isEmpty())) {
					student.setFullname(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("lastname"))));										//validation for fullname
				} else {
					student.setFullname(WordUtils.capitalizeFully(student.getFullname() + " " + String.valueOf(personnelMap.get("lastname"))));			//validation for fullname
				}
				break;
				
			case "gender":
				String gender = String.valueOf(personnelMap.get("gender"));
				if ((gender != null) && (!gender.isEmpty())) {
					gender = (gender.equals("m"))? "Male" : (gender.equals("f"))? "Female" : null;			//validation for gender
					student.setGender(gender);
				}
				break;
				
			case "dob":
				student.setDob((Date)personnelMap.get("dob"));
				break;
				
			case "class":
				student.setClassName(String.valueOf(personnelMap.get("class")));
				break;
				
			case "roll_no":
				student.setRollNumber((Integer)personnelMap.get("roll_no"));
				break;
				
			case "total_marks":
				student.setTotalMarks(((Long)personnelMap.get("total_marks")).intValue());
				break;
				
			case "city":
				student.setCity(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("city"))));
				break;
				
			case "aadhar_number":
				student.setAadhar(String.valueOf(personnelMap.get("aadhar_number")));
				break;
				
			case "contact_number":
				student.setContact(String.valueOf(personnelMap.get("contact_number")));
				break;
				
			case "hs_stream":
				student.setHsStream(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("hs_stream"))));
				break;
				
			case "sec_percent":
				student.setSecPercentage((Integer)personnelMap.get("sec_percent"));
				break;
				
			default:
				break;
		}
	}
	
	/* To Calculate grade using total_marks */
	public String calculateGrade(Integer totalMarks) {
		double marksPercentage = (totalMarks*100)/1000;
		
		String grade = (marksPercentage >= 90)? "A+" : ((marksPercentage >= 80) && (marksPercentage < 90))? "A" : 
			((marksPercentage >= 70) && (marksPercentage < 80))? "B+" : ((marksPercentage >= 60) && (marksPercentage < 70))? "B" : 
			((marksPercentage >= 50) && (marksPercentage < 60))? "C" : "D";
		
		return grade;
	}
	
	

}
