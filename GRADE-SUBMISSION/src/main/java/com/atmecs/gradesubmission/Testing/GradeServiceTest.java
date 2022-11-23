package com.atmecs.gradesubmission.Testing;

import org.junit.runner.RunWith;

import com.atmecs.gradesubmission.repository.GradeRepository;
import com.atmecs.gradesubmission.service.GradeService;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {
	@Mock
	private GradeRepository gradeRepository;
	@InjectMocks
	private GradeService gradeService;
	
	
}
