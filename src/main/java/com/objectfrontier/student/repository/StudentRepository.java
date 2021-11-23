package com.objectfrontier.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.objectfrontier.student.bean.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
