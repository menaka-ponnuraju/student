package com.objectfrontier.student.service;

import java.util.List;

import com.objectfrontier.student.bean.Student;

public interface StudentServiceInterface {
	
	public Student addStudent(Student student);

	public List<Student> getStudentList();

	public Student getStudentById(Long id);

	public void deleteStudentById(Long id);

}
