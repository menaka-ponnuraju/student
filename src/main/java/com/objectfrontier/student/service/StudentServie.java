package com.objectfrontier.student.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.objectfrontier.student.Exception.StudentServiceException;
import com.objectfrontier.student.bean.Student;
import com.objectfrontier.student.repository.StudentRepository;

@Service
public class StudentServie implements StudentServiceInterface{
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public Student addStudent(Student student)throws StudentServiceException {
		
		try {
			if(student.getName().isEmpty() || student.getName().length() == 0) {
				throw new StudentServiceException("701","Please send valid input name, It's blank");
			}
		    Student studentRecord = studentRepo.save(student);
			return studentRecord;
		}
	
		catch(Exception e) {
			throw new StudentServiceException("703","Something went wrong in service layer, while saving the student data in the table" +e.getMessage() );
		}
		
	}

	@Override
	public List<Student> getStudentList() {
		List<Student> studentList =null;
		
		try {
			studentList = studentRepo.findAll();
			
		}
		catch(Exception e) {
			throw new StudentServiceException("602","Something went wrong in srvice layer, while fetching student information from the db" + e.getMessage());
		}
		
		if(studentList.isEmpty())
			throw new StudentServiceException("601","Hey!!! The student table is completely empty, there is nothing to display");
		    return studentList;
	}

	@Override
	public Student getStudentById(Long id) {
		try {
			return studentRepo.findById(id).get();	
		}
		catch(IllegalArgumentException e) {
			throw new StudentServiceException("603", "Given student id is null, please try with some other id" + e.getMessage());
		}
		catch(NoSuchElementException e) {
			throw new StudentServiceException("604","Given student id doesn't exist in db");
		}
	
	}

	@Override
	public void deleteStudentById(Long id) {
		try {
			studentRepo.deleteById(id);
		}
		catch(IllegalArgumentException e) {
			throw new StudentServiceException("605", "Given student id is null, please try with some other id" + e.getMessage());
		}
		
	}
}
