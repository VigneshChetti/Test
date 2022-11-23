package com.atmecs.gradesubmission.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecs.gradesubmission.Grade;
import com.atmecs.gradesubmission.repository.GradeRepository;

@Service
public class GradeService {
	
	@Autowired
	GradeRepository gradeRepository;
	
	public Grade getGrade(int index ) {
		return gradeRepository.getGrade(index);
		
		}
	public void addGrade(Grade garde) {
		gradeRepository.addGrade(garde);;
	}
	
	public void updateGrade(Grade grade,int index) {
		gradeRepository.updateGrade(grade, index);;
	}
	
	public List<Grade> getGrades(){
		return gradeRepository.getGrades();
	}

}
