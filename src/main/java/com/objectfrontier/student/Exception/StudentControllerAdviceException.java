package com.objectfrontier.student.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentControllerAdviceException {
	
	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleEmptyInput(InvalidInputException studentException){
		 return new ResponseEntity<String>("Please send valid input, It's blank", HttpStatus.BAD_REQUEST);
	}
 
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleStudentListEmpty(NoSuchElementException noSuchElementException){
		 return new ResponseEntity<String>("Hey!!! The student table is completely empty, there is nothing to display", HttpStatus.NOT_FOUND);
	}
}
