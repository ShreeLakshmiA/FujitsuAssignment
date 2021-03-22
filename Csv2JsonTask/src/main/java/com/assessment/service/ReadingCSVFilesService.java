package com.assessment.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseChar;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.LMinMax;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.exception.SuperCsvConstraintViolationException;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import com.assessment.model.Student;
import com.assessment.model.StudentWrapperClass;
import com.assessment.model.Teacher;
import com.assessment.model.TeacherWrapperClass;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Service
public class ReadingCSVFilesService {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	/* Super CSV cell processor */
	private CellProcessor[] getProcessors() {
	        
	       /* final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
	        StrRegEx.registerMessage(emailRegex, "must be a valid email address"); */
	        
	        final CellProcessor[] processors = new CellProcessor[] { 
	        		new ParseInt(),									// id (not null, int)											//new UniqueHashCode(),							// id (must be unique)
	                new NotNull(),									// category (not null, string)
	                new StrMinMax(1, 30),							// firstname (not null, string, min=1, max=30)
	                new StrMinMax(1, 30),							// lastname (not null, string, min=1, max=30)
	                new ParseChar(),								// gender (not null, upto 1 char)
	                new ParseDate("MM/dd/yyyy"),					// dob (not null, date of format MM/dd/yyyy)
	                new Optional(new StrMinMax(0, 30)),				// previous_school (nullable, string, min=0, max=30)
	                new Optional(new ParseDate("MM/dd/yyyy")),		// doj (nullable, date of format MM/dd/yyyy)
	                new Optional(),									// class*****(nullable, string)
	                new Optional(new StrMinMax(0, 30)),				// post (nullable, string, min=0, max=30)
	                new Optional(new LMinMax(2, 1000000)),			// salary (nullable, long, min=2, max=1000000)
	                new Optional(new StrMinMax(0, 10)),				// class_teacher_of (nullable, string, min=0, max=10)
	                new Optional(new ParseInt()),					// roll_no (nullable, int)
	                new Optional(),									// emp_no (nullable, string)
	                new Optional(new LMinMax(1, 1000)),				// total_marks ---> validation of total_marks ( > 0 <=1000) is applied		[nullable, long, min=1, max=1000]
	                new NotNull(),									// city (not null, string)
	                new NotNull(),									// aadhar_number (not null, string)
	                new NotNull(),									// contact_number (not null, string)
	                new NotNull(),									// blood_group (not null, string)
	                new Optional(),									// subject_teaches (nullable, string)
	                new Optional(),									// hs_stream (nullable, string)
	                new Optional(new ParseInt())					// sec_percent (nullable, int)

	                
	                //new StrRegEx(emailRegex), // email
	        };
	        
	        return processors;
	}

	//Super CSV Map Reader
	public void readWithCsvMapReader() throws Exception {
		
			String filename = "master-data.csv";
			ClassLoader classLoader = getClass().getClassLoader();
	        
			/* To read csv file using SuperCSV Map Reader in resource folder */
			try (ICsvMapReader mapReader = new CsvMapReader(new FileReader(classLoader.getResource(filename).getFile()), CsvPreference.STANDARD_PREFERENCE)) {
	                
	                // the header columns are used as the keys to the Map
	                final String[] header = mapReader.getHeader(true);
	                final CellProcessor[] processors = getProcessors();
	                
	                List<Student> students = new ArrayList<>();
	                List<Teacher> teachers = new ArrayList<>();
	                
	                if (header.length == 22) {
	                
		                Map<String, Object> personnelMap;
		                while( (personnelMap = mapReader.read(header, processors)) != null ) {
		                        /*System.out.println(String.format("lineNo=%s, rowNo=%s, personnelMap=%s", mapReader.getLineNumber(),
		                                mapReader.getRowNumber(), personnelMap));*/
		                        
								/* convert data from csv file to java objects */
		                        if ("student".equals(mapReader.get(2))) {
		                        	students.add(studentService.setStudentData(header, personnelMap));
		                        } else if ("teacher".equals(mapReader.get(2))) {
		                        	teachers.add(teacherService.setTeacherData(header, personnelMap));
		                        }
		                }
		                
		                ObjectMapper mapper = new ObjectMapper(); 
	                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");					//To format json date
	                    mapper.setDateFormat(df);
	                    ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
	                    
						/* Check if directory already exists, otherwise, create it */
	                    LocalDate today = LocalDate.now();
	                    
	                    String dir = "D:/data/json/";
	                    File file = new File(dir);
	                    boolean flag = false;
						/* To check if directory already exists */
	                    if (file.exists()) {
	                    	System.out.println("Directory " + dir + " already exists");
	                    	flag = true;
	                    } else {
	                    	boolean retval = file.mkdirs();
	                    	
	                    	if (retval) {
	                    		System.out.println("Directory " + dir + " is created successfully");
	                    		flag = true;
	                    	} else {
	                    		System.err.println("Directory " + dir + " creation failed");
	                    	}
	                    }
	                    if (flag) {
	                    	writer.writeValue(new File(dir + "student_record_"+today.getYear()+StringUtils.leftPad(String.valueOf(today.getMonthValue()), 2, "0")+StringUtils.leftPad(String.valueOf(today.getDayOfMonth()), 2, "0")+".json"), new StudentWrapperClass(students.size(), students));
	                    }
	                    
	                    if (flag) {
	                    	writer.writeValue(new File(dir + "teacher_record_"+today.getYear()+StringUtils.leftPad(String.valueOf(today.getMonthValue()), 2, "0")+StringUtils.leftPad(String.valueOf(today.getDayOfMonth()), 2, "0")+".json"), new TeacherWrapperClass(teachers.size(), teachers));
	                    }
	                    
	                    
		                //students.forEach(System.out::println);
		                //teachers.forEach(System.out::println);
	                } else {
	                	System.err.println("The number of columns to be processed: " + header.length + " must match the number of CellProcessors defined: 22");
	                }
	        } catch (SuperCsvConstraintViolationException e) {
	        	System.err.println("Validation failed..");
	        	e.printStackTrace();
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	}
}
