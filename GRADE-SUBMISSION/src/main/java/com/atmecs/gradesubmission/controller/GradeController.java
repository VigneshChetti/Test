package com.atmecs.gradesubmission.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Constraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atmecs.gradesubmission.Constants;
import com.atmecs.gradesubmission.Grade;
import com.atmecs.gradesubmission.service.GradeService;

@Controller
public class GradeController {
	
	@Autowired
	GradeService gradeService;
	
	@GetMapping("/")
	public String getForm(Model model,@RequestParam(required = false) String id) {
		int index=getGradeIndex(id);
		model.addAttribute("grade", index==Constants.NOT_FOUND ? new Grade(): gradeService.getGrade(index));
		return "form";	
		}
	
	@PostMapping("/handleSubmit")
	public String submitForm(@Validated Grade grade,BindingResult result) {
		
		if(result.hasErrors())return "form";
		
		int index= getGradeIndex(grade.getId());
		if (index==Constants.NOT_FOUND) {
			gradeService.addGrade(grade);	
		}
		else {
			gradeService.updateGrade(grade, index);
		}
		return "redirect:/grades";
	}
	
	@GetMapping("/grades")
	public String getGrades(Model model) {
		
		model.addAttribute("grades", gradeService.getGrades());
		return "grade";
	}
	
	public int getGradeIndex(String id) {
		for(int i=0;i<gradeService.getGrades().size();i++) {
			if(gradeService.getGrades().get(i).getId().equals(id)) return i;
			
		}
		return Constants.NOT_FOUND;
	}

}
