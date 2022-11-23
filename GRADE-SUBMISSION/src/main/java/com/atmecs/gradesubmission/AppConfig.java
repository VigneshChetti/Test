package com.atmecs.gradesubmission;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atmecs.gradesubmission.repository.GradeRepository;

@Configuration
public class AppConfig {
	
	@Bean
	public GradeRepository gradeRepository() {
		return new GradeRepository();
	}

}
