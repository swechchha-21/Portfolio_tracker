package com.capx.assignmentProject;

import com.capx.assignmentProject.models.User;
import com.capx.assignmentProject.models.Stock;
import com.capx.assignmentProject.repositories.UserRepository;
import com.capx.assignmentProject.repositories.StockRepository;
import com.capx.assignmentProject.services.StockService;
import com.capx.assignmentProject.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class AssignmentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentProjectApplication.class, args);
	}

}