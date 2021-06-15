package com.college;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.college.controller.FeeController;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		new File(FeeController.uploadDirectory).mkdir();
		
		SpringApplication.run(Application.class, args);
	}

}
