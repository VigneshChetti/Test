package com.atmecs.gradesubmission.repository;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.atmecs.gradesubmission.Grade;

@Repository
public class GradeRepository {
	
	@Autowired
	private List<Grade> studentGrades;
	
	public Grade getGrade(int index ) {
		return studentGrades.get(index);
		
		}
	public void addGrade(Grade garde) {
		studentGrades.add(garde);
	}
	
	public void updateGrade(Grade grade,int index) {
		studentGrades.set(index, grade);
	}
	
	public List<Grade> getGrades(){
		return studentGrades;
	}

}
