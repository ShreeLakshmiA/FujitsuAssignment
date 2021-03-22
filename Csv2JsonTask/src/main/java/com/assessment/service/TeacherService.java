package com.assessment.service;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.stereotype.Service;

import com.assessment.model.Teacher;

@Service
public class TeacherService {
	
	public Teacher setTeacherData(final String[] header, Map<String, Object> personnelMap) {
		Teacher teacher = new Teacher();
		
		for (String head : header) {
			settersForTeacher(teacher, head, personnelMap);
		}
		
		if (teacher.getDob() != null) {
			teacher.setAge(teacher.getDob());
		}
		
		if (teacher.getDoj() != null) {
			teacher.setServicePeriod(teacher.getDoj());
		}
		
		return teacher;
	}
	
	private void settersForTeacher(Teacher teacher, String header, Map<String, Object> personnelMap) {
		switch (header) {
			case "id":
				teacher.setId((Integer)personnelMap.get("id"));
				break;
			case "firstname":
				if ((teacher.getFullname() == null) || (teacher.getFullname().isEmpty())) {
					teacher.setFullname(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("firstname"))));
				} else {
					teacher.setFullname(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("firstname")) + " " + teacher.getFullname()));
				}
				break;
				
			case "lastname":
				if ((teacher.getFullname() == null) || (teacher.getFullname().isEmpty())) {
					teacher.setFullname(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("lastname"))));
				} else {
					teacher.setFullname(WordUtils.capitalizeFully(teacher.getFullname() + " " + String.valueOf(personnelMap.get("lastname"))));
				}
				break;
				
			case "gender":
				String gender = String.valueOf(personnelMap.get("gender"));
				if ((gender != null) && (!gender.isEmpty())) {
					gender = (gender.equals("m"))? "Male" : (gender.equals("f"))? "Female" : null;
					teacher.setGender(gender);
				}
				break;
				
			case "dob":
				teacher.setDob((Date)personnelMap.get("dob"));
				break;
				
			case "previous_school":
				teacher.setPreviousSchool(String.valueOf(personnelMap.get("previous_school")));
				break;
				
			case "doj":
				teacher.setDoj((Date)personnelMap.get("doj"));
				break;
				
			case "post":
				teacher.setPost((String.valueOf(personnelMap.get("post"))).substring(0, 1).toUpperCase());
				break;
				
			case "salary":
				teacher.setSalary(((Long)personnelMap.get("salary")).intValue());
				break;
			
			case "class_teacher_of":
				teacher.setClassTeacher(String.valueOf(personnelMap.get("class_teacher_of")));
				break;
				
			case "emp_no":
				teacher.setEmpNo((String.valueOf(personnelMap.get("emp_no"))).toUpperCase());
				break;
				
			case "city":
				teacher.setCity(WordUtils.capitalizeFully(String.valueOf(personnelMap.get("city"))));
				break;
				
			case "aadhar_number":
				teacher.setAadhar(String.valueOf(personnelMap.get("aadhar_number")));
				break;
				
			case "contact_number":
				teacher.setContact(String.valueOf(personnelMap.get("contact_number")));
				break;
				
			/* To generate subject_teaches as list with delimiter - */
			case "subject_teaches":
				String subjectTeaches = String.valueOf(personnelMap.get("subject_teaches"));
				if ((subjectTeaches != null) && (!subjectTeaches.isEmpty())) {
					String[] arrayOfSubjectTeaches = subjectTeaches.split("-");
					for (String all : arrayOfSubjectTeaches) {
						teacher.addSubjectTeaches(WordUtils.capitalizeFully(all));
					}
				}
				break;
				
			default:
				break;
		}
	}

}
