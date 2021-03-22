package com.assessment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.assessment.service.ReadingCSVFilesService;

@SpringBootApplication
public class Csv2JsonTaskApplication implements CommandLineRunner {
	
	@Autowired
	ReadingCSVFilesService readingCSVFilesService;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Csv2JsonTaskApplication.class);
		app.run(args);
	
	}
	
	@Override
	public void run(String[] args) {
		/* To read csv file */
		try {
			readingCSVFilesService.readWithCsvMapReader();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
