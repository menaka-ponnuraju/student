package com.objectfrontier.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectfrontier.student.bean.Student;
import com.objectfrontier.student.exception.InvalidInputException;
import com.objectfrontier.student.repository.StudentRepository;

@Service
public class StudentServie implements StudentServiceInterface{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student addStudent(Student student){
		
			if(student.getName().isEmpty() || student.getName().length() == 0) {
				throw new InvalidInputException("701","Please send valid input name, It's blank");
			}
		    Student studentRecord = studentRepo.save(student);
			return studentRecord;
	}

	@Override
	public List<Student> getStudentList() {
		List<Student> studentList = studentRepo.findAll();
		
		if(studentList.isEmpty()) {
			throw new InvalidInputException("601","Hey!!! The student table is completely empty, there is nothing to display");
		}
		return studentList;
		
	}

	@Override
	public Student getStudentById(Long id) {
		Student  studentById = studentRepo.findById(id).get();
		return studentById;
	}

	@Override
	public void deleteStudentById(Long id) {
		try {
			studentRepo.deleteById(id);
		}
		catch(IllegalArgumentException e) {
			throw new InvalidInputException("605", "Given student id is null, please try with some other id" + e.getMessage());
		}
		
	}
}
