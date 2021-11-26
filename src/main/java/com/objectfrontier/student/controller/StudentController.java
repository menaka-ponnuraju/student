package com.objectfrontier.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.objectfrontier.student.bean.Student;
import com.objectfrontier.student.exception.StudentControllerException;
import com.objectfrontier.student.exception.InvalidInputException;
import com.objectfrontier.student.service.StudentServiceInterface;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentServiceInterface studentServieInterface;
	
	//Adding student information into the db.
	@PostMapping("/addStudent")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
			Student studentSaved = studentServieInterface.addStudent(student);
			return new ResponseEntity<Student>(studentSaved,HttpStatus.CREATED);
	}
	
	//Retrieve list of student records from the db
	@GetMapping("/studentList")
	public ResponseEntity<List<Student>> getStudentList(){
		List<Student> studentList = studentServieInterface.getStudentList();
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);		
	}
	
	//Retrieve single student record from the db
	@GetMapping("/studentList/{id}")
	public ResponseEntity<Student> getStudentByid(@PathVariable ("id") Long id){
		Student studentById= studentServieInterface.getStudentById(id);
		return new ResponseEntity<Student>(studentById, HttpStatus.OK);		
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<Void> deleteStudentByid(@PathVariable ("id") Long id){
		studentServieInterface.deleteStudentById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);		
	}
	
	@PutMapping("/updateStudent")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		
		Student studentSaved = studentServieInterface.addStudent(student);
		return new ResponseEntity<Student>(studentSaved,HttpStatus.CREATED);
		
	}

}
